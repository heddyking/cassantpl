package com.worksap.company.operation.cassangen;

import com.datastax.driver.core.*;
import com.datastax.driver.core.exceptions.InvalidQueryException;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.utils.UUIDs;
import com.fasterxml.uuid.Generators;
import com.google.common.base.Strings;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by xiaoxi on 16-8-24.
 */

public class CassandraDbUpdateUtil {

    private static final Logger logger = LoggerFactory.getLogger(CassandraDbUpdateUtil.class);

    public static void main(String[] args) throws Exception{
//        releaseAllMutex();

        CassandraDbUpdateUtil.init();
        CassandraDbUpdateUtil.runWithLock(x->{apply(); return null;});
        CassandraDbUpdateUtil.destory();
    }

    //basic addressing
    private final static String SCHEMA_PATH="cassanscript/src/main/resources/schema";
    private final static String DATA_PATH="cassanscript/src/main/resources/data";
    private final static String SCHEMA_SHORT_PATH = "schema/";
    private final static String DATA_SHORT_PATH = "data/";
    private final static String LIB_JAR= "lib/cassanscript.jar";

    //db connecting
    public static String CONTACT_POINTS ="localhost";
    public static String CLUSTER_NAME="Hue_Cluster";
    public static String KEYSPACE="elephas";
    private static Session session=null;

    //db schema constaints
    private final static String PTK="ptk";
    private final static String TYPE="type";
    private final static String DEVELOPER_ID="developer_id";
    private final static String CURRENT_TS="current_ts";
    private final static String DUMMY="dummy"; //db_version table's partition key
    private final static String SCHEMA="schema"; //db_version table's type field
    private final static String DATA="data"; //db_version table's type field
    private final static String KEYSPACE_MIGRATION ="db_migration";
    private final static String TABLE_VERSION="db_version";
    private final static String TABLE_MUTEX="db_mutex";
    private final static String MIGRATION_ID="migration_id";
    private final static String MIGRATION_TS="migration_ts";
    private final static String GLOBAL_SNAPSHOT="global_snapshot"; //if use global snapshot, we set this as developer_id.
    private final static String SCRIPT_NAME_SEPARATOR="_";

    //cql
    private final static String KEYSPACE_CQL="CREATE KEYSPACE IF NOT EXISTS db_migration WITH replication = " +
            "{'class':'SimpleStrategy', 'replication_factor':3};";
    private final static String VERSION_TABLE_CQL="create table if not exists db_migration.db_version(ptk varchar, " +
            "type varchar, developer_id varchar, current_ts varchar, PRIMARY KEY (ptk, type, developer_id));";
    private final static String MUTEX_TABLE_CQL="create table if not exists db_migration.db_mutex(ptk varchar, " +
            "migration_id varchar, migration_ts timeuuid, PRIMARY KEY (ptk, migration_id, migration_ts));";
    private final static String RELEASE_MUTEX_CQL="delete from db_migration.db_mutex where ptk='dummy' and migration_id=";
    private final static String RELEASE_ALL_MUTEX_CQL="drop table if exists db_migration.db_mutex";

    //temp variables
    private static boolean needInit=false;
    private static Map<String,Object> map1=new HashMap<String,Object>();
    private static Map<String,Object> map2=new HashMap<String,Object>();
    private static Map<String,Object> latestMap1=new HashMap<String,Object>();
    private static Map<String,Object> latestMap2=new HashMap<String,Object>();
    private static List<File> listOfSchemaScripts=new ArrayList<File>();
    private static List<File> listOfDataScripts=new ArrayList<File>();
    private static List<File> schemaScripts=new ArrayList<File>();
    private static List<File> dataScripts=new ArrayList<File>();
    private static String[] schemaCqls=new String[]{};
    private static String[] dataCqls=new String[]{};

    //init constaints
//    private static String migration_id=Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static String migration_id="heheheeheheh";
    private static UUID migration_ts= Generators.timeBasedGenerator().generate();
    private enum KIND_OF_SCRIPT {
        GLOBAL_SNAPSHOT,
        LOCAL_SNAPSHOT,
        LOCAL_AUGMENT
    }

    /**
     * init the Util
     */
    public static void init(){
        if(session==null)
            session = Cluster.builder()
                .withClusterName(CLUSTER_NAME)
                .addContactPoint(CONTACT_POINTS)
                .build().connect();
        try{
            session.execute(KEYSPACE_CQL);
            session.execute(VERSION_TABLE_CQL);
            session.execute(MUTEX_TABLE_CQL);
        }catch(Exception e){}
    }

    /**
     * destory the Util
     */
    public static void destory(){
        if(session!=null)
            session.getCluster().close();

////        relase lock with a background daemon to avoid release lock exception
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        if(session==null)
//            session = Cluster.builder()
//                    .withClusterName(CLUSTER_NAME)
//                    .addContactPoint(CONTACT_POINTS)
//                    .build().connect();
//        session.execute(RELEASE_MUTEX_CQL+"'"+migration_id+"'");
//        if(session!=null)
//            session.getCluster().close();
    }

    /**
     *If runing has some problems, please run this function to release all the lock.
     */
    public static void releaseAllMutex(){
        if(session==null)
            session = Cluster.builder()
                    .withClusterName(CLUSTER_NAME)
                    .addContactPoint(CONTACT_POINTS)
                    .build().connect();
        session.execute(RELEASE_ALL_MUTEX_CQL);
        session.execute(MUTEX_TABLE_CQL);
    }

    /**
     * run update db with mutex lock to avoid run by several docker contains at the same time.
     * @param function
     */
    public static void runWithLock(Function<Void,Void> function){
        while(true){
            //add mutex lock
            Statement addMutex = QueryBuilder.insertInto(KEYSPACE_MIGRATION,TABLE_MUTEX)
                    .value(PTK,DUMMY)
                    .value(MIGRATION_ID,migration_id)
                    .value(MIGRATION_TS,migration_ts);
            session.execute(addMutex);

            try {
                Thread.sleep(new Random().nextInt(5000)+200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //query others' mutex lock
            Statement queryMutex = QueryBuilder.select().all().from(KEYSPACE_MIGRATION,TABLE_MUTEX)
                    .where(QueryBuilder.eq(PTK,DUMMY))
                    .and(QueryBuilder.eq(MIGRATION_ID,migration_id));
            ResultSet rs = session.execute(queryMutex);

            if(rs.all().size()==1){
                function.apply(null);

                //remove mutex lock
                Statement delMutex = QueryBuilder.delete().from(KEYSPACE_MIGRATION,TABLE_MUTEX)
                        .where(QueryBuilder.eq(PTK,DUMMY))
                        .and(QueryBuilder.eq(MIGRATION_ID,migration_id))
                        .and(QueryBuilder.eq(MIGRATION_TS,migration_ts));
                session.execute(delMutex);

                break;
            }
            else{
                //remove mutex lock
                Statement delMutex = QueryBuilder.delete().from(KEYSPACE_MIGRATION,TABLE_MUTEX)
                        .where(QueryBuilder.eq(PTK,DUMMY))
                        .and(QueryBuilder.eq(MIGRATION_ID,migration_id))
                        .and(QueryBuilder.eq(MIGRATION_TS,migration_ts));
                session.execute(delMutex);
            }

            //sleep a random time 200-1200ms
            try {
                Thread.sleep(new Random().nextInt(1000)+200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * apply the update on the db
     */
    public static void apply(){
        getMetaData();
        getUpdateScripts();

        //update schema
        Arrays.asList(schemaCqls).forEach(schemaCql->{
            String str=trm(schemaCql);
            if(str!=null && !str.isEmpty()){
                logger.info(">>> "+str);
                session.execute(str);
            }
        });

        //update data
        Arrays.asList(dataCqls).forEach(dataCql->{
            String str=trm(dataCql);
            if(str!=null && !str.isEmpty()){
                logger.info(">>> "+str);
                session.execute(str);
            }
        });

        //update schema version info
        latestMap1.entrySet().stream().forEach(entry->{
            logger.info("@@@ "+"schema "+entry.getKey()+" "+entry.getValue());
            Statement stat=QueryBuilder.insertInto(KEYSPACE_MIGRATION,TABLE_VERSION)
                    .value(PTK,DUMMY)
                    .value(TYPE,SCHEMA)
                    .value(DEVELOPER_ID,entry.getKey())
                    .value(CURRENT_TS,entry.getValue());
            session.execute(stat);
        });

        //update data version info
        latestMap2.entrySet().stream().forEach(entry->{
            logger.info("@@@ "+"data "+entry.getKey()+" "+entry.getValue());
            Statement stat=QueryBuilder.insertInto(KEYSPACE_MIGRATION,TABLE_VERSION)
                    .value(PTK,DUMMY)
                    .value(TYPE,DATA)
                    .value(DEVELOPER_ID,entry.getKey())
                    .value(CURRENT_TS,entry.getValue());
            session.execute(stat);
        });
    }

    /**
     * get db version info
     */
    private static void getMetaData(){
        ResultSet rs=null;
        List<Row> list=null;
        try{
            Statement stat=QueryBuilder.select().all().from(KEYSPACE_MIGRATION,TABLE_VERSION).where(QueryBuilder.eq(PTK,DUMMY));
            rs=session.execute(stat);
            list=rs.all();
            if(list.size()==0) {
                needInit=true;
                return;
            }
        }catch(InvalidQueryException e){
            logger.info("!! This Cassandra DB has not been init for this project !!");
            needInit=true;
            return;
        }

        list.stream().forEach(r->{
                    if(r.getString(TYPE).equals(SCHEMA)){
                        map1.put(r.getString(DEVELOPER_ID),r.getString(CURRENT_TS));
                    }
                    else if(r.getString(TYPE).equals(DATA)){
                        map2.put(r.getString(DEVELOPER_ID),r.getString(CURRENT_TS));
                    }
                }
        );
    }

    /**
     * get all the db cql scripts (schema and data)
     */
    private static void getAllScripts(){
        try {
            String jarpath=CassandraDbUpdateUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            jarpath=jarpath.replace("file:","");
            if(jarpath.indexOf('!')!=-1)jarpath=jarpath.substring(0,jarpath.indexOf('!'));
            System.out.println(">"+jarpath);

            final File jarFile = new File(jarpath);

            if(jarFile.isFile()) {  // Run with JAR file
                final JarFile jar = new JarFile(jarFile);
                final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
                while(entries.hasMoreElements()) {
                    JarEntry je=entries.nextElement();
                    System.out.println(">>"+je.getName());
                    if(je.getName().equals(LIB_JAR)){
                        String uuid= UUIDs.random()+"";
                        newFolder(uuid+"/");
                        newFolder(uuid+"/"+SCHEMA_SHORT_PATH);
                        newFolder(uuid+"/"+DATA_SHORT_PATH);
                        File jarFile2 = inputStreamToFile(jar.getInputStream(je), uuid+"/"+uuid+".jar");
                        JarFile jar2 = new JarFile(jarFile2);
                        Enumeration<JarEntry> entries2 = jar2.entries();

                        while(entries2.hasMoreElements()) {
                            JarEntry je2=entries2.nextElement();
                            String name2=je2.getName();
                            System.out.println(">>>"+name2);
                            if(name2.startsWith(SCHEMA_SHORT_PATH) && name2.endsWith(".cql")){
                                listOfSchemaScripts.add(inputStreamToFile(jar2.getInputStream(je2),uuid+"/"+SCHEMA_SHORT_PATH+name2.replace(SCHEMA_SHORT_PATH,"")));
                            }
                            else if(name2.startsWith(DATA_SHORT_PATH) && name2.endsWith(".cql")){
                                listOfDataScripts.add(inputStreamToFile(jar2.getInputStream(je2),uuid+"/"+DATA_SHORT_PATH+name2.replace(DATA_SHORT_PATH,"")));
                            }
                        }
                        break;
                    }
                }
                jar.close();
            }
            else { // Run with IDE
                File schemaFolder = new File(SCHEMA_PATH);
                File dataFolder = new File(DATA_PATH);

                listOfSchemaScripts = Arrays.asList(schemaFolder.listFiles());
                listOfDataScripts =  Arrays.asList(dataFolder.listFiles());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get all the scripts that need to be applied.
     */
    private static void getUpdateScripts(){
        getAllScripts();

        if(listOfSchemaScripts==null || listOfDataScripts==null) return;

        if(needInit){ //if no cassandra inited, init it here
            //add latest snapshot scripts
            listOfSchemaScripts.forEach(schemaScript->{
                if(kindOfScript(schemaScript.getName())== KIND_OF_SCRIPT.GLOBAL_SNAPSHOT){
                    if(schemaScripts.size()==0){
                        schemaScripts.add(schemaScript);
                        latestMap1.put(GLOBAL_SNAPSHOT,getTs(schemaScript.getName()));
                    }
                    else{
                        File initScript=schemaScripts.get(0);
                        if(schemaScript.getName().compareTo(initScript.getName())>0){
                            schemaScripts.set(0,schemaScript);
                            latestMap1.put(GLOBAL_SNAPSHOT,getTs(schemaScript.getName()));
                        }
                    }
                }
            });
            //add augment scripts
            listOfSchemaScripts.forEach(schemaScript->{
                if(kindOfScript(schemaScript.getName())== KIND_OF_SCRIPT.LOCAL_AUGMENT){
                    File initScript=schemaScripts.get(0);
                    if(schemaScript.getName().compareTo(initScript.getName())>0){
                        schemaScripts.add(schemaScript);

                        String uid=getUid(schemaScript.getName());
                        String ts=getTs(schemaScript.getName());
                        if(!latestMap1.containsKey(uid)||ts.compareTo((String)latestMap1.get(uid))>0)
                        latestMap1.put(uid,ts);
                    }
                }
            });
            schemaScripts.sort((Comparator<File>) (f1,f2)-> f1.compareTo(f2));

            //add latest snapshot scripts(data)
            listOfDataScripts.forEach(dataScript->{
                if(kindOfScript(dataScript.getName())== KIND_OF_SCRIPT.GLOBAL_SNAPSHOT){
                    if(dataScripts.size()==0){
                        dataScripts.add(dataScript);
                        latestMap2.put(GLOBAL_SNAPSHOT,getTs(dataScript.getName()));
                    }
                    else{
                        File initScript=dataScripts.get(0);
                        if(dataScript.getName().compareTo(initScript.getName())>0){
                            dataScripts.set(0,dataScript);
                            latestMap2.put(GLOBAL_SNAPSHOT,getTs(dataScript.getName()));
                        }
                    }
                }
            });
            //add augment scripts(data)
            listOfDataScripts.forEach(dataScript->{
                if(kindOfScript(dataScript.getName())== KIND_OF_SCRIPT.LOCAL_AUGMENT){
                    File initScript=dataScripts.get(0);
                    if(dataScript.getName().compareTo(initScript.getName())>0){
                        dataScripts.add(dataScript);

                        String uid=getUid(dataScript.getName());
                        String ts=getTs(dataScript.getName());
                        if(!latestMap2.containsKey(uid)||ts.compareTo((String)latestMap2.get(uid))>0)
                            latestMap2.put(uid,ts);
                    }
                }
            });
            dataScripts.sort((Comparator<File>) (f1,f2)-> f1.getName().compareTo(f2.getName()));

        }
        else{ //if cassandra has already been inited
            //add augment scripts
            listOfSchemaScripts.forEach(schemaScript->{
                if(kindOfScript(schemaScript.getName())== KIND_OF_SCRIPT.LOCAL_AUGMENT){
                    String uid=getUid(schemaScript.getName());
                    //has this uid's version
                    if(map1.containsKey(uid)){
                        //script version newer than the record version in db
                        if(getTs(schemaScript.getName()).compareTo((String)map1.get(uid))>0){
                            schemaScripts.add(schemaScript);

                            String ts=getTs(schemaScript.getName());
                            if(!latestMap1.containsKey(uid)||ts.compareTo((String)latestMap1.get(uid))>0)
                                latestMap1.put(uid,ts);
                        }
                    }
                    else{
                        //script version newer than the snapshot version
                        if(!map1.containsKey(GLOBAL_SNAPSHOT) ||
                                getTs(schemaScript.getName()).compareTo((String)map1.get(GLOBAL_SNAPSHOT))>0){
                            schemaScripts.add(schemaScript);

                            String ts=getTs(schemaScript.getName());
                            if(!latestMap1.containsKey(uid)||ts.compareTo((String)latestMap1.get(uid))>0)
                                latestMap1.put(uid,ts);
                        }
                    }
                }
            });
            schemaScripts.sort((Comparator<File>) (f1,f2)-> f1.getName().compareTo(f2.getName()));

            //add augment scripts(data)
            listOfDataScripts.forEach(dataScript->{
                if(kindOfScript(dataScript.getName())== KIND_OF_SCRIPT.LOCAL_AUGMENT){
                    String uid=getUid(dataScript.getName());
                    if(map2.containsKey(uid)){
                        if(getTs(dataScript.getName()).compareTo((String)map2.get(uid))>0){
                            dataScripts.add(dataScript);

                            String ts=getTs(dataScript.getName());
                            if(!latestMap2.containsKey(uid)||ts.compareTo((String)latestMap2.get(uid))>0)
                                latestMap2.put(uid,ts);
                        }
                    }
                    else{
                        if(!map2.containsKey(GLOBAL_SNAPSHOT) ||
                                getTs(dataScript.getName()).compareTo((String)map2.get(GLOBAL_SNAPSHOT))>0){
                            dataScripts.add(dataScript);

                            String ts=getTs(dataScript.getName());
                            if(!latestMap2.containsKey(uid)||ts.compareTo((String)latestMap2.get(uid))>0)
                                latestMap2.put(uid,ts);
                        }
                    }
                }
            });
            dataScripts.sort((Comparator<File>) (f1,f2)-> f1.compareTo(f2));
        }

        //build schema cql string.
        StringBuilder schemaCqlBuilder=new StringBuilder();
        schemaScripts.forEach(f->{
//            logger.info("schemaScript: "+f.getName());
            try{
                schemaCqlBuilder.append(IOUtils.toString(new FileInputStream(f)));
            }catch(Exception e){
                throw new RuntimeException();
            }
        });

        //build data cql string
        StringBuilder dataCqlBuilder=new StringBuilder();
        dataScripts.forEach(f->{
//            logger.info("dataScript: "+f.getName());
            try{
                dataCqlBuilder.append(IOUtils.toString(new FileInputStream(f)));
            }catch(Exception e){
                throw new RuntimeException();
            }
        });

        //delete the last ';'
        char[] schemaCqlArr=schemaCqlBuilder.toString().toCharArray();
        if(schemaCqlBuilder.toString().lastIndexOf(";")>=0)
            schemaCqlArr[schemaCqlBuilder.toString().lastIndexOf(";")]=' ';
        char[] dataCqlArr=dataCqlBuilder.toString().toCharArray();
        if(dataCqlBuilder.toString().lastIndexOf(";")>=0)
            dataCqlArr[dataCqlBuilder.toString().lastIndexOf(";")]=' ';

        //get the cql arr
        schemaCqls=new String(schemaCqlArr).split(";");
        dataCqls=new String(dataCqlArr).split(";");
    }

    //get the kind of cql scripts.
    private static KIND_OF_SCRIPT kindOfScript(String name){
        int pos=name.lastIndexOf(SCRIPT_NAME_SEPARATOR);
        switch(pos){
            case(-1): //global snapshot
                return KIND_OF_SCRIPT.GLOBAL_SNAPSHOT;
            case(12): //local snapshot
                return KIND_OF_SCRIPT.LOCAL_SNAPSHOT;
            default: //augment script
                return KIND_OF_SCRIPT.LOCAL_AUGMENT;
        }
    }

    //trim the cql string
    private static String trm(String str){
        if(Strings.isNullOrEmpty(str)) return str;
        str=str.replace("\uFEFF","").replace("\uFFFD","").trim();
        return str;
    }

    //parse cql script's name
    private static List<String> parseScriptName(String name){
        List<String> strList=new ArrayList<String>();
        if(kindOfScript(name)==KIND_OF_SCRIPT.GLOBAL_SNAPSHOT){
            strList.add(name.substring(0,12));
        }
        else if(kindOfScript(name)==KIND_OF_SCRIPT.LOCAL_SNAPSHOT){
            strList.add(name.substring(0,12));
            strList.add(name.substring(13).substring(0,name.substring(13).indexOf(SCRIPT_NAME_SEPARATOR)));
        }
        else if(kindOfScript(name)==KIND_OF_SCRIPT.LOCAL_AUGMENT){
            strList.add(name.substring(0,12));
            strList.add(name.substring(13).substring(0,name.substring(13).indexOf(SCRIPT_NAME_SEPARATOR)));
            strList.add(name.substring(13).substring(name.substring(13).indexOf(SCRIPT_NAME_SEPARATOR)).replace(".cql",""));
        }
        return strList;
    }

    //get timestamps from the cql script name
    private static String getTs(String name){
        return parseScriptName(name).get(0);
    }

    //get developer id from the cql script name
    private static String getUid(String name){
        return parseScriptName(name).get(1);
    }

    //get the tips or comments in the cql script name
    private static String getTip(String name){
        return parseScriptName(name).get(2);
    }

    //convert inputSteam to File
    private static File inputStreamToFile(InputStream inputStream, String filePathName){
        OutputStream outputStream = null;

        File file=new File(filePathName);
        try {
            // write the inputStream to a FileOutputStream
            outputStream = new FileOutputStream(file);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    // outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return file;
    }

    //create a new folder in filesystem
    private static void newFolder(String newfolder) {
        try {
            String filepath = newfolder;
            File myPath = new File(filepath);
            if (!myPath.exists()) {
                myPath.mkdir();
            }
        } catch (Exception e) {
            System.out.println("Folder Already Exists.");
        }
    }
}
