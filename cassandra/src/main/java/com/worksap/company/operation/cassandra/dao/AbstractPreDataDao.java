package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreDataDto;
import com.worksap.company.operation.cassandra.table.PreDataTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreDataDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreDataDto> mapper;

    public AbstractPreDataDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreDataDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreDataDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreDataDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreDataDto get(String tenantId, String landscape, UUID ts) {
        return mapper.get(tenantId, landscape, ts);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreDataDto> getAsync(String tenantId, String landscape, UUID ts) {
        return mapper.getAsync(tenantId, landscape, ts);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape, UUID ts) {
        mapper.delete(tenantId, landscape, ts);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape, UUID ts) {
        return mapper.deleteAsync(tenantId, landscape, ts);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PreDataDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreDataDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreDataDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreDataDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        return Futures.transform(session.executeAsync(batch),
                (Function<ResultSet, Void>) rs -> null);
    }

    /**
     * save dto synchronized in a light-weighted transaction way
     * @param dto
     * @return
     */
    public boolean saveLwt(PreDataDto dto){
        Statement query = QueryBuilder.insertInto(PreDataTable._NAME)
                .value(PreDataTable.TENANT_ID, dto.getTenantId())
                .value(PreDataTable.LANDSCAPE, dto.getLandscape())
                .value(PreDataTable.TS, dto.getTs())
                .value(PreDataTable.AWS_ACCESS_KEY_ID, dto.getAwsAccessKeyId())
                .value(PreDataTable.AWS_GENERAL_KEYPAIR, dto.getAwsGeneralKeypair())
                .value(PreDataTable.AWS_INSTANCE_PREFIX, dto.getAwsInstancePrefix())
                .value(PreDataTable.AWS_SECRET_ACCESS_KEY, dto.getAwsSecretAccessKey())
                .value(PreDataTable.AWS_VPC_INDEX, dto.getAwsVpcIndex())
                .value(PreDataTable.AWS_WORK_TERMINAL_KEYPAIR, dto.getAwsWorkTerminalKeypair())
                .value(PreDataTable.CASSANDRA_CLUSTER_PREFIX, dto.getCassandraClusterPrefix())
                .value(PreDataTable.CASSANDRA_HOSTS_AC_COMMON1, dto.getCassandraHostsAcCommon1())
                .value(PreDataTable.CASSANDRA_HOSTS_AC_COMMON2, dto.getCassandraHostsAcCommon2())
                .value(PreDataTable.CASSANDRA_HOSTS_AC_COMMON3, dto.getCassandraHostsAcCommon3())
                .value(PreDataTable.CASSANDRA_HOSTS_BT, dto.getCassandraHostsBt())
                .value(PreDataTable.CASSANDRA_HOSTS_HR_COMMON1, dto.getCassandraHostsHrCommon1())
                .value(PreDataTable.CASSANDRA_HOSTS_HR_COMMON2, dto.getCassandraHostsHrCommon2())
                .value(PreDataTable.CASSANDRA_JMX_PASSWORD, dto.getCassandraJmxPassword())
                .value(PreDataTable.CASSANDRA_KEYSPACE_NAME, dto.getCassandraKeyspaceName())
                .value(PreDataTable.CASSANDRA_REPLICATION_FACTOR, dto.getCassandraReplicationFactor())
                .value(PreDataTable.CONFIG_SERVER_GIT_REPOSITORY, dto.getConfigServerGitRepository())
                .value(PreDataTable.CONFIG_SERVER_LOCAL_GIT_DIR, dto.getConfigServerLocalGitDir())
                .value(PreDataTable.CONFIG_SERVER_URL, dto.getConfigServerUrl())
                .value(PreDataTable.DATASYNC_HUE_DOMAIN, dto.getDatasyncHueDomain())
                .value(PreDataTable.DICINGSEARCH_API_KEY, dto.getDicingsearchApiKey())
                .value(PreDataTable.DOCKER_REGISTRY_S3_ACCESS_KEY_ID, dto.getDockerRegistryS3AccessKeyId())
                .value(PreDataTable.DOCKER_REGISTRY_S3_BUCKET_NAME, dto.getDockerRegistryS3BucketName())
                .value(PreDataTable.DOCKER_REGISTRY_S3_REGION, dto.getDockerRegistryS3Region())
                .value(PreDataTable.DOCKER_REGISTRY_S3_SECRET_ACCESS_KEY, dto.getDockerRegistryS3SecretAccessKey())
                .value(PreDataTable.EDP2_CONFIGBRANCH, dto.getEdp2Configbranch())
                .value(PreDataTable.EDP2_WEBSERVER_URL, dto.getEdp2WebserverUrl())
                .value(PreDataTable.EKISPA_URL, dto.getEkispaUrl())
                .value(PreDataTable.ELASTICSEARCH_CLUSTER_NAME, dto.getElasticsearchClusterName())
                .value(PreDataTable.ELASTICSEARCH_HOST, dto.getElasticsearchHost())
                .value(PreDataTable.ELASTICSEARCH_INDEX_NAME, dto.getElasticsearchIndexName())
                .value(PreDataTable.ELASTICSEARCH_INSTALL_FROM_SCRATCH, dto.getElasticsearchInstallFromScratch())
                .value(PreDataTable.ENABLE_CASSANDRA_JMX, dto.getEnableCassandraJmx())
                .value(PreDataTable.FLOW_ID, dto.getFlowId())
                .value(PreDataTable.FRONT_ELB_ACCESSIBLE_CIDR_LIST, dto.getFrontElbAccessibleCidrList())
                .value(PreDataTable.GIT_SERVER_HTTP_AUTH_PASS, dto.getGitServerHttpAuthPass())
                .value(PreDataTable.GIT_SERVER_HTTP_AUTH_USER, dto.getGitServerHttpAuthUser())
                .value(PreDataTable.GIT_SERVER_REPOSITORY_PATH, dto.getGitServerRepositoryPath())
                .value(PreDataTable.HDFS_NAMENODE_IP, dto.getHdfsNamenodeIp())
                .value(PreDataTable.HUE_BT_VERSION, dto.getHueBtVersion())
                .value(PreDataTable.HUE_CONTEXT_PATH, dto.getHueContextPath())
                .value(PreDataTable.HUE_PRODUCT_VERSION, dto.getHueProductVersion())
                .value(PreDataTable.HUEDRIVE_S3_ACCESS_KEY_ID, dto.getHuedriveS3AccessKeyId())
                .value(PreDataTable.HUEDRIVE_S3_BUCKET_NAME, dto.getHuedriveS3BucketName())
                .value(PreDataTable.HUEDRIVE_S3_REGION, dto.getHuedriveS3Region())
                .value(PreDataTable.HUEDRIVE_S3_SECRET_ACCESS_KEY, dto.getHuedriveS3SecretAccessKey())
                .value(PreDataTable.HUELOG_S3_ACCESS_KEY_ID, dto.getHuelogS3AccessKeyId())
                .value(PreDataTable.HUELOG_S3_BUCKET_NAME, dto.getHuelogS3BucketName())
                .value(PreDataTable.HUELOG_S3_REGION, dto.getHuelogS3Region())
                .value(PreDataTable.HUELOG_S3_SECRET_ACCESS_KEY, dto.getHuelogS3SecretAccessKey())
                .value(PreDataTable.HUEPREHEAT_S3_ACCESS_KEY_ID, dto.getHuepreheatS3AccessKeyId())
                .value(PreDataTable.HUEPREHEAT_S3_BUCKET_NAME, dto.getHuepreheatS3BucketName())
                .value(PreDataTable.HUEPREHEAT_S3_REGION, dto.getHuepreheatS3Region())
                .value(PreDataTable.HUEPREHEAT_S3_SECRET_ACCESS_KEY, dto.getHuepreheatS3SecretAccessKey())
                .value(PreDataTable.KAFKA_HOSTS, dto.getKafkaHosts())
                .value(PreDataTable.LANDSCAPE_NAME, dto.getLandscapeName())
                .value(PreDataTable.LOGMANAGER_HOST, dto.getLogmanagerHost())
                .value(PreDataTable.LOGMANAGER_PORT, dto.getLogmanagerPort())
                .value(PreDataTable.MAILMAN_API_PASS, dto.getMailmanApiPass())
                .value(PreDataTable.MAILMAN_API_USER, dto.getMailmanApiUser())
                .value(PreDataTable.MAILMAN_HOST, dto.getMailmanHost())
                .value(PreDataTable.MAILMAN_PORT, dto.getMailmanPort())
                .value(PreDataTable.MAILMAN_VERSION, dto.getMailmanVersion())
                .value(PreDataTable.MIGRATE_TO_VERSION, dto.getMigrateToVersion())
                .value(PreDataTable.MIGRATOR_VERSION, dto.getMigratorVersion())
                .value(PreDataTable.NGINX_NODE_PORT, dto.getNginxNodePort())
                .value(PreDataTable.NUMBER_OF_USERS, dto.getNumberOfUsers())
                .value(PreDataTable.OCRUS_WEB_HOSTNAME, dto.getOcrusWebHostname())
                .value(PreDataTable.POSTGRES_IP, dto.getPostgresIp())
                .value(PreDataTable.POSTGRESQL_HOST, dto.getPostgresqlHost())
                .value(PreDataTable.POSTGRESQL_PORT, dto.getPostgresqlPort())
                .value(PreDataTable.POSTGRESQL_TENANT_ID, dto.getPostgresqlTenantId())
                .value(PreDataTable.REDIS_HOST, dto.getRedisHost())
                .value(PreDataTable.REMOTE_BATCH_JAR_DIR, dto.getRemoteBatchJarDir())
                .value(PreDataTable.REMOTE_PROPERTY_FILE_DIR, dto.getRemotePropertyFileDir())
                .value(PreDataTable.REMOTE_SHIPMENT_FILE_DIR, dto.getRemoteShipmentFileDir())
                .value(PreDataTable.SHIPMENT_S3_ACCESS_KEY_ID, dto.getShipmentS3AccessKeyId())
                .value(PreDataTable.SHIPMENT_S3_BUCKET_NAME, dto.getShipmentS3BucketName())
                .value(PreDataTable.SHIPMENT_S3_REGION, dto.getShipmentS3Region())
                .value(PreDataTable.SHIPMENT_S3_SECRET_ACCESS_KEY, dto.getShipmentS3SecretAccessKey())
                .value(PreDataTable.SMTP_HOST, dto.getSmtpHost())
                .value(PreDataTable.TENANT_ACCOUNT, dto.getTenantAccount())
                .value(PreDataTable.TENANT_NAME, dto.getTenantName())
                .value(PreDataTable.TERMINAL_CURRENT_BATCH_JAR_DIR, dto.getTerminalCurrentBatchJarDir())
                .value(PreDataTable.TERMINAL_CURRENT_CASSANDRA_DIR, dto.getTerminalCurrentCassandraDir())
                .value(PreDataTable.TERMINAL_CURRENT_EDP2_DIR, dto.getTerminalCurrentEdp2Dir())
                .value(PreDataTable.TERMINAL_CURRENT_ELASTICSEARCH_DIR, dto.getTerminalCurrentElasticsearchDir())
                .value(PreDataTable.TERMINAL_CURRENT_SHIPMENT_FILE_DIR, dto.getTerminalCurrentShipmentFileDir())
                .value(PreDataTable.TERMINAL_SHIPMENT_FILE_DIR, dto.getTerminalShipmentFileDir())
                .value(PreDataTable.USE_SELF_SIGNED_CERTIFICATES, dto.getUseSelfSignedCertificates())
                .value(PreDataTable.USER_ID, dto.getUserId())
                .value(PreDataTable.VERSION, dto.getVersion())
                .value(PreDataTable.VPC_IP_PREFIX, dto.getVpcIpPrefix())
                .value(PreDataTable.WINDOWS_WORK_TERMINAL_AMI_ID, dto.getWindowsWorkTerminalAmiId())
                .value(PreDataTable.YARN_RESOUCE_MANAGER_IP, dto.getYarnResouceManagerIp())
                .value(PreDataTable.ZOOKEEPER_CLUSTER, dto.getZookeeperCluster())
                .value(PreDataTable.ZOOKEEPER_NODES, dto.getZookeeperNodes())
                .ifNotExists()
                ;
        ResultSet rs= session.execute(query);
        return rs.one().getBool("[applied]");
    }

    /**
     * save dto asynchronized in a light-weighted transaction way
     * @param dto
     * @return
     */
    public Future<Boolean> saveLwtAsync(PreDataDto dto){
        Statement query = QueryBuilder.insertInto(PreDataTable._NAME)
                .value(PreDataTable.TENANT_ID, dto.getTenantId())
                .value(PreDataTable.LANDSCAPE, dto.getLandscape())
                .value(PreDataTable.TS, dto.getTs())
                .value(PreDataTable.AWS_ACCESS_KEY_ID, dto.getAwsAccessKeyId())
                .value(PreDataTable.AWS_GENERAL_KEYPAIR, dto.getAwsGeneralKeypair())
                .value(PreDataTable.AWS_INSTANCE_PREFIX, dto.getAwsInstancePrefix())
                .value(PreDataTable.AWS_SECRET_ACCESS_KEY, dto.getAwsSecretAccessKey())
                .value(PreDataTable.AWS_VPC_INDEX, dto.getAwsVpcIndex())
                .value(PreDataTable.AWS_WORK_TERMINAL_KEYPAIR, dto.getAwsWorkTerminalKeypair())
                .value(PreDataTable.CASSANDRA_CLUSTER_PREFIX, dto.getCassandraClusterPrefix())
                .value(PreDataTable.CASSANDRA_HOSTS_AC_COMMON1, dto.getCassandraHostsAcCommon1())
                .value(PreDataTable.CASSANDRA_HOSTS_AC_COMMON2, dto.getCassandraHostsAcCommon2())
                .value(PreDataTable.CASSANDRA_HOSTS_AC_COMMON3, dto.getCassandraHostsAcCommon3())
                .value(PreDataTable.CASSANDRA_HOSTS_BT, dto.getCassandraHostsBt())
                .value(PreDataTable.CASSANDRA_HOSTS_HR_COMMON1, dto.getCassandraHostsHrCommon1())
                .value(PreDataTable.CASSANDRA_HOSTS_HR_COMMON2, dto.getCassandraHostsHrCommon2())
                .value(PreDataTable.CASSANDRA_JMX_PASSWORD, dto.getCassandraJmxPassword())
                .value(PreDataTable.CASSANDRA_KEYSPACE_NAME, dto.getCassandraKeyspaceName())
                .value(PreDataTable.CASSANDRA_REPLICATION_FACTOR, dto.getCassandraReplicationFactor())
                .value(PreDataTable.CONFIG_SERVER_GIT_REPOSITORY, dto.getConfigServerGitRepository())
                .value(PreDataTable.CONFIG_SERVER_LOCAL_GIT_DIR, dto.getConfigServerLocalGitDir())
                .value(PreDataTable.CONFIG_SERVER_URL, dto.getConfigServerUrl())
                .value(PreDataTable.DATASYNC_HUE_DOMAIN, dto.getDatasyncHueDomain())
                .value(PreDataTable.DICINGSEARCH_API_KEY, dto.getDicingsearchApiKey())
                .value(PreDataTable.DOCKER_REGISTRY_S3_ACCESS_KEY_ID, dto.getDockerRegistryS3AccessKeyId())
                .value(PreDataTable.DOCKER_REGISTRY_S3_BUCKET_NAME, dto.getDockerRegistryS3BucketName())
                .value(PreDataTable.DOCKER_REGISTRY_S3_REGION, dto.getDockerRegistryS3Region())
                .value(PreDataTable.DOCKER_REGISTRY_S3_SECRET_ACCESS_KEY, dto.getDockerRegistryS3SecretAccessKey())
                .value(PreDataTable.EDP2_CONFIGBRANCH, dto.getEdp2Configbranch())
                .value(PreDataTable.EDP2_WEBSERVER_URL, dto.getEdp2WebserverUrl())
                .value(PreDataTable.EKISPA_URL, dto.getEkispaUrl())
                .value(PreDataTable.ELASTICSEARCH_CLUSTER_NAME, dto.getElasticsearchClusterName())
                .value(PreDataTable.ELASTICSEARCH_HOST, dto.getElasticsearchHost())
                .value(PreDataTable.ELASTICSEARCH_INDEX_NAME, dto.getElasticsearchIndexName())
                .value(PreDataTable.ELASTICSEARCH_INSTALL_FROM_SCRATCH, dto.getElasticsearchInstallFromScratch())
                .value(PreDataTable.ENABLE_CASSANDRA_JMX, dto.getEnableCassandraJmx())
                .value(PreDataTable.FLOW_ID, dto.getFlowId())
                .value(PreDataTable.FRONT_ELB_ACCESSIBLE_CIDR_LIST, dto.getFrontElbAccessibleCidrList())
                .value(PreDataTable.GIT_SERVER_HTTP_AUTH_PASS, dto.getGitServerHttpAuthPass())
                .value(PreDataTable.GIT_SERVER_HTTP_AUTH_USER, dto.getGitServerHttpAuthUser())
                .value(PreDataTable.GIT_SERVER_REPOSITORY_PATH, dto.getGitServerRepositoryPath())
                .value(PreDataTable.HDFS_NAMENODE_IP, dto.getHdfsNamenodeIp())
                .value(PreDataTable.HUE_BT_VERSION, dto.getHueBtVersion())
                .value(PreDataTable.HUE_CONTEXT_PATH, dto.getHueContextPath())
                .value(PreDataTable.HUE_PRODUCT_VERSION, dto.getHueProductVersion())
                .value(PreDataTable.HUEDRIVE_S3_ACCESS_KEY_ID, dto.getHuedriveS3AccessKeyId())
                .value(PreDataTable.HUEDRIVE_S3_BUCKET_NAME, dto.getHuedriveS3BucketName())
                .value(PreDataTable.HUEDRIVE_S3_REGION, dto.getHuedriveS3Region())
                .value(PreDataTable.HUEDRIVE_S3_SECRET_ACCESS_KEY, dto.getHuedriveS3SecretAccessKey())
                .value(PreDataTable.HUELOG_S3_ACCESS_KEY_ID, dto.getHuelogS3AccessKeyId())
                .value(PreDataTable.HUELOG_S3_BUCKET_NAME, dto.getHuelogS3BucketName())
                .value(PreDataTable.HUELOG_S3_REGION, dto.getHuelogS3Region())
                .value(PreDataTable.HUELOG_S3_SECRET_ACCESS_KEY, dto.getHuelogS3SecretAccessKey())
                .value(PreDataTable.HUEPREHEAT_S3_ACCESS_KEY_ID, dto.getHuepreheatS3AccessKeyId())
                .value(PreDataTable.HUEPREHEAT_S3_BUCKET_NAME, dto.getHuepreheatS3BucketName())
                .value(PreDataTable.HUEPREHEAT_S3_REGION, dto.getHuepreheatS3Region())
                .value(PreDataTable.HUEPREHEAT_S3_SECRET_ACCESS_KEY, dto.getHuepreheatS3SecretAccessKey())
                .value(PreDataTable.KAFKA_HOSTS, dto.getKafkaHosts())
                .value(PreDataTable.LANDSCAPE_NAME, dto.getLandscapeName())
                .value(PreDataTable.LOGMANAGER_HOST, dto.getLogmanagerHost())
                .value(PreDataTable.LOGMANAGER_PORT, dto.getLogmanagerPort())
                .value(PreDataTable.MAILMAN_API_PASS, dto.getMailmanApiPass())
                .value(PreDataTable.MAILMAN_API_USER, dto.getMailmanApiUser())
                .value(PreDataTable.MAILMAN_HOST, dto.getMailmanHost())
                .value(PreDataTable.MAILMAN_PORT, dto.getMailmanPort())
                .value(PreDataTable.MAILMAN_VERSION, dto.getMailmanVersion())
                .value(PreDataTable.MIGRATE_TO_VERSION, dto.getMigrateToVersion())
                .value(PreDataTable.MIGRATOR_VERSION, dto.getMigratorVersion())
                .value(PreDataTable.NGINX_NODE_PORT, dto.getNginxNodePort())
                .value(PreDataTable.NUMBER_OF_USERS, dto.getNumberOfUsers())
                .value(PreDataTable.OCRUS_WEB_HOSTNAME, dto.getOcrusWebHostname())
                .value(PreDataTable.POSTGRES_IP, dto.getPostgresIp())
                .value(PreDataTable.POSTGRESQL_HOST, dto.getPostgresqlHost())
                .value(PreDataTable.POSTGRESQL_PORT, dto.getPostgresqlPort())
                .value(PreDataTable.POSTGRESQL_TENANT_ID, dto.getPostgresqlTenantId())
                .value(PreDataTable.REDIS_HOST, dto.getRedisHost())
                .value(PreDataTable.REMOTE_BATCH_JAR_DIR, dto.getRemoteBatchJarDir())
                .value(PreDataTable.REMOTE_PROPERTY_FILE_DIR, dto.getRemotePropertyFileDir())
                .value(PreDataTable.REMOTE_SHIPMENT_FILE_DIR, dto.getRemoteShipmentFileDir())
                .value(PreDataTable.SHIPMENT_S3_ACCESS_KEY_ID, dto.getShipmentS3AccessKeyId())
                .value(PreDataTable.SHIPMENT_S3_BUCKET_NAME, dto.getShipmentS3BucketName())
                .value(PreDataTable.SHIPMENT_S3_REGION, dto.getShipmentS3Region())
                .value(PreDataTable.SHIPMENT_S3_SECRET_ACCESS_KEY, dto.getShipmentS3SecretAccessKey())
                .value(PreDataTable.SMTP_HOST, dto.getSmtpHost())
                .value(PreDataTable.TENANT_ACCOUNT, dto.getTenantAccount())
                .value(PreDataTable.TENANT_NAME, dto.getTenantName())
                .value(PreDataTable.TERMINAL_CURRENT_BATCH_JAR_DIR, dto.getTerminalCurrentBatchJarDir())
                .value(PreDataTable.TERMINAL_CURRENT_CASSANDRA_DIR, dto.getTerminalCurrentCassandraDir())
                .value(PreDataTable.TERMINAL_CURRENT_EDP2_DIR, dto.getTerminalCurrentEdp2Dir())
                .value(PreDataTable.TERMINAL_CURRENT_ELASTICSEARCH_DIR, dto.getTerminalCurrentElasticsearchDir())
                .value(PreDataTable.TERMINAL_CURRENT_SHIPMENT_FILE_DIR, dto.getTerminalCurrentShipmentFileDir())
                .value(PreDataTable.TERMINAL_SHIPMENT_FILE_DIR, dto.getTerminalShipmentFileDir())
                .value(PreDataTable.USE_SELF_SIGNED_CERTIFICATES, dto.getUseSelfSignedCertificates())
                .value(PreDataTable.USER_ID, dto.getUserId())
                .value(PreDataTable.VERSION, dto.getVersion())
                .value(PreDataTable.VPC_IP_PREFIX, dto.getVpcIpPrefix())
                .value(PreDataTable.WINDOWS_WORK_TERMINAL_AMI_ID, dto.getWindowsWorkTerminalAmiId())
                .value(PreDataTable.YARN_RESOUCE_MANAGER_IP, dto.getYarnResouceManagerIp())
                .value(PreDataTable.ZOOKEEPER_CLUSTER, dto.getZookeeperCluster())
                .value(PreDataTable.ZOOKEEPER_NODES, dto.getZookeeperNodes())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreDataDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreDataDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreDataDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
				.where(QueryBuilder.eq(PreDataTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreDataDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
				.where(QueryBuilder.eq(PreDataTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreDataDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
				.where(QueryBuilder.eq(PreDataTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreDataTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreDataDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
				.where(QueryBuilder.eq(PreDataTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreDataTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreDataDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreDataTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreDataDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreDataTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreDataDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
				.where(QueryBuilder.eq(PreDataTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreDataTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreDataTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreDataDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
				.where(QueryBuilder.eq(PreDataTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreDataTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreDataTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreDataDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreDataTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreDataTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreDataDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreDataTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreDataTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

    /**
     * get next page and new pagestate synchronously
     * @param size
     * @param pagingState
     */
    public Pair<PagingState,List<PreDataDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreDataDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreDataDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreDataDto> resultList = new ArrayList<PreDataDto>();
        for (PreDataDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreDataDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreDataDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreDataDto>>> queryNextPageAsync(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));

        return transferFutureResultSetWithState(futureResultSet);
    }

    /**
     * get a certain page asynchronously
     * @param size
     * @param page
     */
    public Future<Pair<PagingState,List<PreDataDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreDataDto>>> queryCertainPageAsync(
            Integer size, Integer page, Statement query) {
        //async paging
        query.setFetchSize(size);
        Future<ResultSet> futureResultSet = Futures.transform(session.executeAsync(query), pageIterate(page));

        return transferFutureResultSetWithState(futureResultSet);
    }

    /**
     * transfer future<resultset> to future<list<dto>>
     * @param futureResultSet
     */
    protected Future<List<PreDataDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreDataDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreDataDto>>) rs -> {
                    Result<PreDataDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreDataDto> resultList = new ArrayList<PreDataDto>();
                    for (PreDataDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return resultList;
                });
        return futureResutlList;
    }

    /**
     * transfer future<resultset> to future<pair<pagingstate,list<dto>>>
     * @param futureResultSet
     */
    protected Future<Pair<PagingState,List<PreDataDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreDataDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreDataDto>>>) rs -> {
                    Result<PreDataDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreDataDto> resultList = new ArrayList<PreDataDto>();
                    for (PreDataDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreDataDto>>(newPagingState,resultList);
                });
        return futureResutlList;
    }

    /**
     * use resultset interate to a certain page.
     * @param page
     */
    private AsyncFunction<ResultSet, ResultSet> pageIterate(final int page) {
        return pageIterate(page, 1);
    }

    /**
     * use resultset interate to a certain page.
     * @param page
     * @param cur
     */
    private AsyncFunction<ResultSet, ResultSet> pageIterate(final int page, int cur) {
        return (AsyncFunction<ResultSet, ResultSet>) rs -> {
            if (rs.getExecutionInfo().getPagingState() == null && cur < page) {
                return Futures.immediateCancelledFuture();
            } else if (cur == page) {
                return Futures.immediateFuture(rs);
            } else {
                for (Row row : rs) {
                    if (rs.getAvailableWithoutFetching() == 0) break;
                }
                Future<ResultSet> future = rs.fetchMoreResults();
                return Futures.transform((ListenableFuture<ResultSet>)future, pageIterate(page, cur + 1));
            }
        };
    }
}

