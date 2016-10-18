package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreDataDefaultDto;
import com.worksap.company.operation.cassandra.table.PreDataDefaultTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreDataDefaultDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreDataDefaultDto> mapper;

    public AbstractPreDataDefaultDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreDataDefaultDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreDataDefaultDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreDataDefaultDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreDataDefaultDto get(String landscape) {
        return mapper.get(landscape);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreDataDefaultDto> getAsync(String landscape) {
        return mapper.getAsync(landscape);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String landscape) {
        mapper.delete(landscape);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String landscape) {
        return mapper.deleteAsync(landscape);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PreDataDefaultDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreDataDefaultDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreDataDefaultDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreDataDefaultDto> list) {
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
    public boolean saveLwt(PreDataDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreDataDefaultTable._NAME)
                .value(PreDataDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreDataDefaultTable.AWS_ACCESS_KEY_ID, dto.getAwsAccessKeyId())
                .value(PreDataDefaultTable.AWS_GENERAL_KEYPAIR, dto.getAwsGeneralKeypair())
                .value(PreDataDefaultTable.AWS_INSTANCE_PREFIX, dto.getAwsInstancePrefix())
                .value(PreDataDefaultTable.AWS_SECRET_ACCESS_KEY, dto.getAwsSecretAccessKey())
                .value(PreDataDefaultTable.AWS_WORK_TERMINAL_KEYPAIR, dto.getAwsWorkTerminalKeypair())
                .value(PreDataDefaultTable.CASSANDRA_CLUSTER_PREFIX, dto.getCassandraClusterPrefix())
                .value(PreDataDefaultTable.CASSANDRA_JMX_PASSWORD, dto.getCassandraJmxPassword())
                .value(PreDataDefaultTable.CASSANDRA_KEYSPACE_NAME, dto.getCassandraKeyspaceName())
                .value(PreDataDefaultTable.CASSANDRA_REPLICATION_FACTOR, dto.getCassandraReplicationFactor())
                .value(PreDataDefaultTable.CONFIG_SERVER_GIT_REPOSITORY, dto.getConfigServerGitRepository())
                .value(PreDataDefaultTable.CONFIG_SERVER_LOCAL_GIT_DIR, dto.getConfigServerLocalGitDir())
                .value(PreDataDefaultTable.DICINGSEARCH_API_KEY, dto.getDicingsearchApiKey())
                .value(PreDataDefaultTable.DOCKER_REGISTRY_S3_ACCESS_KEY_ID, dto.getDockerRegistryS3AccessKeyId())
                .value(PreDataDefaultTable.DOCKER_REGISTRY_S3_BUCKET_NAME, dto.getDockerRegistryS3BucketName())
                .value(PreDataDefaultTable.DOCKER_REGISTRY_S3_REGION, dto.getDockerRegistryS3Region())
                .value(PreDataDefaultTable.DOCKER_REGISTRY_S3_SECRET_ACCESS_KEY, dto.getDockerRegistryS3SecretAccessKey())
                .value(PreDataDefaultTable.EDP2_CONFIGBRANCH, dto.getEdp2Configbranch())
                .value(PreDataDefaultTable.EKISPA_URL, dto.getEkispaUrl())
                .value(PreDataDefaultTable.ELASTICSEARCH_INDEX_NAME, dto.getElasticsearchIndexName())
                .value(PreDataDefaultTable.ELASTICSEARCH_INSTALL_FROM_SCRATCH, dto.getElasticsearchInstallFromScratch())
                .value(PreDataDefaultTable.ENABLE_CASSANDRA_JMX, dto.getEnableCassandraJmx())
                .value(PreDataDefaultTable.GIT_SERVER_HTTP_AUTH_PASS, dto.getGitServerHttpAuthPass())
                .value(PreDataDefaultTable.GIT_SERVER_HTTP_AUTH_USER, dto.getGitServerHttpAuthUser())
                .value(PreDataDefaultTable.GIT_SERVER_REPOSITORY_PATH, dto.getGitServerRepositoryPath())
                .value(PreDataDefaultTable.HUE_CONTEXT_PATH, dto.getHueContextPath())
                .value(PreDataDefaultTable.HUEDRIVE_S3_ACCESS_KEY_ID, dto.getHuedriveS3AccessKeyId())
                .value(PreDataDefaultTable.HUEDRIVE_S3_BUCKET_NAME, dto.getHuedriveS3BucketName())
                .value(PreDataDefaultTable.HUEDRIVE_S3_REGION, dto.getHuedriveS3Region())
                .value(PreDataDefaultTable.HUEDRIVE_S3_SECRET_ACCESS_KEY, dto.getHuedriveS3SecretAccessKey())
                .value(PreDataDefaultTable.HUELOG_S3_ACCESS_KEY_ID, dto.getHuelogS3AccessKeyId())
                .value(PreDataDefaultTable.HUELOG_S3_BUCKET_NAME, dto.getHuelogS3BucketName())
                .value(PreDataDefaultTable.HUELOG_S3_REGION, dto.getHuelogS3Region())
                .value(PreDataDefaultTable.HUELOG_S3_SECRET_ACCESS_KEY, dto.getHuelogS3SecretAccessKey())
                .value(PreDataDefaultTable.HUEPREHEAT_S3_ACCESS_KEY_ID, dto.getHuepreheatS3AccessKeyId())
                .value(PreDataDefaultTable.HUEPREHEAT_S3_BUCKET_NAME, dto.getHuepreheatS3BucketName())
                .value(PreDataDefaultTable.HUEPREHEAT_S3_REGION, dto.getHuepreheatS3Region())
                .value(PreDataDefaultTable.HUEPREHEAT_S3_SECRET_ACCESS_KEY, dto.getHuepreheatS3SecretAccessKey())
                .value(PreDataDefaultTable.LOGMANAGER_PORT, dto.getLogmanagerPort())
                .value(PreDataDefaultTable.MAILMAN_API_PASS, dto.getMailmanApiPass())
                .value(PreDataDefaultTable.MAILMAN_API_USER, dto.getMailmanApiUser())
                .value(PreDataDefaultTable.MAILMAN_PORT, dto.getMailmanPort())
                .value(PreDataDefaultTable.MAILMAN_VERSION, dto.getMailmanVersion())
                .value(PreDataDefaultTable.NGINX_NODE_PORT, dto.getNginxNodePort())
                .value(PreDataDefaultTable.OCRUS_WEB_HOSTNAME, dto.getOcrusWebHostname())
                .value(PreDataDefaultTable.POSTGRES_IP, dto.getPostgresIp())
                .value(PreDataDefaultTable.POSTGRESQL_PORT, dto.getPostgresqlPort())
                .value(PreDataDefaultTable.POSTGRESQL_TENANT_ID, dto.getPostgresqlTenantId())
                .value(PreDataDefaultTable.SHIPMENT_S3_ACCESS_KEY_ID, dto.getShipmentS3AccessKeyId())
                .value(PreDataDefaultTable.SHIPMENT_S3_BUCKET_NAME, dto.getShipmentS3BucketName())
                .value(PreDataDefaultTable.SHIPMENT_S3_REGION, dto.getShipmentS3Region())
                .value(PreDataDefaultTable.SHIPMENT_S3_SECRET_ACCESS_KEY, dto.getShipmentS3SecretAccessKey())
                .value(PreDataDefaultTable.TERMINAL_SHIPMENT_FILE_DIR, dto.getTerminalShipmentFileDir())
                .value(PreDataDefaultTable.USE_SELF_SIGNED_CERTIFICATES, dto.getUseSelfSignedCertificates())
                .value(PreDataDefaultTable.WINDOWS_WORK_TERMINAL_AMI_ID, dto.getWindowsWorkTerminalAmiId())
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
    public Future<Boolean> saveLwtAsync(PreDataDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreDataDefaultTable._NAME)
                .value(PreDataDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreDataDefaultTable.AWS_ACCESS_KEY_ID, dto.getAwsAccessKeyId())
                .value(PreDataDefaultTable.AWS_GENERAL_KEYPAIR, dto.getAwsGeneralKeypair())
                .value(PreDataDefaultTable.AWS_INSTANCE_PREFIX, dto.getAwsInstancePrefix())
                .value(PreDataDefaultTable.AWS_SECRET_ACCESS_KEY, dto.getAwsSecretAccessKey())
                .value(PreDataDefaultTable.AWS_WORK_TERMINAL_KEYPAIR, dto.getAwsWorkTerminalKeypair())
                .value(PreDataDefaultTable.CASSANDRA_CLUSTER_PREFIX, dto.getCassandraClusterPrefix())
                .value(PreDataDefaultTable.CASSANDRA_JMX_PASSWORD, dto.getCassandraJmxPassword())
                .value(PreDataDefaultTable.CASSANDRA_KEYSPACE_NAME, dto.getCassandraKeyspaceName())
                .value(PreDataDefaultTable.CASSANDRA_REPLICATION_FACTOR, dto.getCassandraReplicationFactor())
                .value(PreDataDefaultTable.CONFIG_SERVER_GIT_REPOSITORY, dto.getConfigServerGitRepository())
                .value(PreDataDefaultTable.CONFIG_SERVER_LOCAL_GIT_DIR, dto.getConfigServerLocalGitDir())
                .value(PreDataDefaultTable.DICINGSEARCH_API_KEY, dto.getDicingsearchApiKey())
                .value(PreDataDefaultTable.DOCKER_REGISTRY_S3_ACCESS_KEY_ID, dto.getDockerRegistryS3AccessKeyId())
                .value(PreDataDefaultTable.DOCKER_REGISTRY_S3_BUCKET_NAME, dto.getDockerRegistryS3BucketName())
                .value(PreDataDefaultTable.DOCKER_REGISTRY_S3_REGION, dto.getDockerRegistryS3Region())
                .value(PreDataDefaultTable.DOCKER_REGISTRY_S3_SECRET_ACCESS_KEY, dto.getDockerRegistryS3SecretAccessKey())
                .value(PreDataDefaultTable.EDP2_CONFIGBRANCH, dto.getEdp2Configbranch())
                .value(PreDataDefaultTable.EKISPA_URL, dto.getEkispaUrl())
                .value(PreDataDefaultTable.ELASTICSEARCH_INDEX_NAME, dto.getElasticsearchIndexName())
                .value(PreDataDefaultTable.ELASTICSEARCH_INSTALL_FROM_SCRATCH, dto.getElasticsearchInstallFromScratch())
                .value(PreDataDefaultTable.ENABLE_CASSANDRA_JMX, dto.getEnableCassandraJmx())
                .value(PreDataDefaultTable.GIT_SERVER_HTTP_AUTH_PASS, dto.getGitServerHttpAuthPass())
                .value(PreDataDefaultTable.GIT_SERVER_HTTP_AUTH_USER, dto.getGitServerHttpAuthUser())
                .value(PreDataDefaultTable.GIT_SERVER_REPOSITORY_PATH, dto.getGitServerRepositoryPath())
                .value(PreDataDefaultTable.HUE_CONTEXT_PATH, dto.getHueContextPath())
                .value(PreDataDefaultTable.HUEDRIVE_S3_ACCESS_KEY_ID, dto.getHuedriveS3AccessKeyId())
                .value(PreDataDefaultTable.HUEDRIVE_S3_BUCKET_NAME, dto.getHuedriveS3BucketName())
                .value(PreDataDefaultTable.HUEDRIVE_S3_REGION, dto.getHuedriveS3Region())
                .value(PreDataDefaultTable.HUEDRIVE_S3_SECRET_ACCESS_KEY, dto.getHuedriveS3SecretAccessKey())
                .value(PreDataDefaultTable.HUELOG_S3_ACCESS_KEY_ID, dto.getHuelogS3AccessKeyId())
                .value(PreDataDefaultTable.HUELOG_S3_BUCKET_NAME, dto.getHuelogS3BucketName())
                .value(PreDataDefaultTable.HUELOG_S3_REGION, dto.getHuelogS3Region())
                .value(PreDataDefaultTable.HUELOG_S3_SECRET_ACCESS_KEY, dto.getHuelogS3SecretAccessKey())
                .value(PreDataDefaultTable.HUEPREHEAT_S3_ACCESS_KEY_ID, dto.getHuepreheatS3AccessKeyId())
                .value(PreDataDefaultTable.HUEPREHEAT_S3_BUCKET_NAME, dto.getHuepreheatS3BucketName())
                .value(PreDataDefaultTable.HUEPREHEAT_S3_REGION, dto.getHuepreheatS3Region())
                .value(PreDataDefaultTable.HUEPREHEAT_S3_SECRET_ACCESS_KEY, dto.getHuepreheatS3SecretAccessKey())
                .value(PreDataDefaultTable.LOGMANAGER_PORT, dto.getLogmanagerPort())
                .value(PreDataDefaultTable.MAILMAN_API_PASS, dto.getMailmanApiPass())
                .value(PreDataDefaultTable.MAILMAN_API_USER, dto.getMailmanApiUser())
                .value(PreDataDefaultTable.MAILMAN_PORT, dto.getMailmanPort())
                .value(PreDataDefaultTable.MAILMAN_VERSION, dto.getMailmanVersion())
                .value(PreDataDefaultTable.NGINX_NODE_PORT, dto.getNginxNodePort())
                .value(PreDataDefaultTable.OCRUS_WEB_HOSTNAME, dto.getOcrusWebHostname())
                .value(PreDataDefaultTable.POSTGRES_IP, dto.getPostgresIp())
                .value(PreDataDefaultTable.POSTGRESQL_PORT, dto.getPostgresqlPort())
                .value(PreDataDefaultTable.POSTGRESQL_TENANT_ID, dto.getPostgresqlTenantId())
                .value(PreDataDefaultTable.SHIPMENT_S3_ACCESS_KEY_ID, dto.getShipmentS3AccessKeyId())
                .value(PreDataDefaultTable.SHIPMENT_S3_BUCKET_NAME, dto.getShipmentS3BucketName())
                .value(PreDataDefaultTable.SHIPMENT_S3_REGION, dto.getShipmentS3Region())
                .value(PreDataDefaultTable.SHIPMENT_S3_SECRET_ACCESS_KEY, dto.getShipmentS3SecretAccessKey())
                .value(PreDataDefaultTable.TERMINAL_SHIPMENT_FILE_DIR, dto.getTerminalShipmentFileDir())
                .value(PreDataDefaultTable.USE_SELF_SIGNED_CERTIFICATES, dto.getUseSelfSignedCertificates())
                .value(PreDataDefaultTable.WINDOWS_WORK_TERMINAL_AMI_ID, dto.getWindowsWorkTerminalAmiId())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreDataDefaultDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataDefaultTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreDataDefaultDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataDefaultTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreDataDefaultDto> getByPk(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataDefaultTable._NAME)
				.where(QueryBuilder.eq(PreDataDefaultTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreDataDefaultDto>> getByPkAsync(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataDefaultTable._NAME)
				.where(QueryBuilder.eq(PreDataDefaultTable.LANDSCAPE,landscape))
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
    public Pair<PagingState,List<PreDataDefaultDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataDefaultTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreDataDefaultDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreDataDefaultDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreDataDefaultDto> resultList = new ArrayList<PreDataDefaultDto>();
        for (PreDataDefaultDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreDataDefaultDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreDataDefaultDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataDefaultTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreDataDefaultDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreDataDefaultDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreDataDefaultTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreDataDefaultDto>>> queryCertainPageAsync(
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
    protected Future<List<PreDataDefaultDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreDataDefaultDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreDataDefaultDto>>) rs -> {
                    Result<PreDataDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreDataDefaultDto> resultList = new ArrayList<PreDataDefaultDto>();
                    for (PreDataDefaultDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreDataDefaultDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreDataDefaultDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreDataDefaultDto>>>) rs -> {
                    Result<PreDataDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreDataDefaultDto> resultList = new ArrayList<PreDataDefaultDto>();
                    for (PreDataDefaultDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreDataDefaultDto>>(newPagingState,resultList);
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

