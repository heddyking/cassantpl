package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreVpcDefaultDto;
import com.worksap.company.operation.cassandra.table.PreVpcDefaultTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreVpcDefaultDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreVpcDefaultDto> mapper;

    public AbstractPreVpcDefaultDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreVpcDefaultDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreVpcDefaultDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreVpcDefaultDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreVpcDefaultDto get(String landscape) {
        return mapper.get(landscape);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreVpcDefaultDto> getAsync(String landscape) {
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
    public void delete(PreVpcDefaultDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreVpcDefaultDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreVpcDefaultDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreVpcDefaultDto> list) {
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
    public boolean saveLwt(PreVpcDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreVpcDefaultTable._NAME)
                .value(PreVpcDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreVpcDefaultTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(PreVpcDefaultTable.AWS_SECRET_KEY, dto.getAwsSecretKey())
                .value(PreVpcDefaultTable.BUCKET_NAME_PREFIX, dto.getBucketNamePrefix())
                .value(PreVpcDefaultTable.CIDR_BLOCK_SUFFIX, dto.getCidrBlockSuffix())
                .value(PreVpcDefaultTable.DESTINATION_ROOT, dto.getDestinationRoot())
                .value(PreVpcDefaultTable.IGW_NAME_PREFIX, dto.getIgwNamePrefix())
                .value(PreVpcDefaultTable.IP_PREFIX, dto.getIpPrefix())
                .value(PreVpcDefaultTable.PRIVATE_IP_ADDRESS_SUFFIX, dto.getPrivateIpAddressSuffix())
                .value(PreVpcDefaultTable.PRIVATE_RT_NAME_PREFIX, dto.getPrivateRtNamePrefix())
                .value(PreVpcDefaultTable.PUBLIC_RT_NAME_PREFIX, dto.getPublicRtNamePrefix())
                .value(PreVpcDefaultTable.REGION, dto.getRegion())
                .value(PreVpcDefaultTable.SECURITY_GROUP_PREFIX, dto.getSecurityGroupPrefix())
                .value(PreVpcDefaultTable.SOURCE_ROOT, dto.getSourceRoot())
                .value(PreVpcDefaultTable.VPC_PREFIX, dto.getVpcPrefix())
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
    public Future<Boolean> saveLwtAsync(PreVpcDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreVpcDefaultTable._NAME)
                .value(PreVpcDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreVpcDefaultTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(PreVpcDefaultTable.AWS_SECRET_KEY, dto.getAwsSecretKey())
                .value(PreVpcDefaultTable.BUCKET_NAME_PREFIX, dto.getBucketNamePrefix())
                .value(PreVpcDefaultTable.CIDR_BLOCK_SUFFIX, dto.getCidrBlockSuffix())
                .value(PreVpcDefaultTable.DESTINATION_ROOT, dto.getDestinationRoot())
                .value(PreVpcDefaultTable.IGW_NAME_PREFIX, dto.getIgwNamePrefix())
                .value(PreVpcDefaultTable.IP_PREFIX, dto.getIpPrefix())
                .value(PreVpcDefaultTable.PRIVATE_IP_ADDRESS_SUFFIX, dto.getPrivateIpAddressSuffix())
                .value(PreVpcDefaultTable.PRIVATE_RT_NAME_PREFIX, dto.getPrivateRtNamePrefix())
                .value(PreVpcDefaultTable.PUBLIC_RT_NAME_PREFIX, dto.getPublicRtNamePrefix())
                .value(PreVpcDefaultTable.REGION, dto.getRegion())
                .value(PreVpcDefaultTable.SECURITY_GROUP_PREFIX, dto.getSecurityGroupPrefix())
                .value(PreVpcDefaultTable.SOURCE_ROOT, dto.getSourceRoot())
                .value(PreVpcDefaultTable.VPC_PREFIX, dto.getVpcPrefix())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreVpcDefaultDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcDefaultTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreVpcDefaultDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcDefaultTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreVpcDefaultDto> getByPk(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcDefaultTable._NAME)
				.where(QueryBuilder.eq(PreVpcDefaultTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreVpcDefaultDto>> getByPkAsync(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcDefaultTable._NAME)
				.where(QueryBuilder.eq(PreVpcDefaultTable.LANDSCAPE,landscape))
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
    public Pair<PagingState,List<PreVpcDefaultDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcDefaultTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreVpcDefaultDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreVpcDefaultDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreVpcDefaultDto> resultList = new ArrayList<PreVpcDefaultDto>();
        for (PreVpcDefaultDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreVpcDefaultDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreVpcDefaultDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcDefaultTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreVpcDefaultDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreVpcDefaultDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcDefaultTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreVpcDefaultDto>>> queryCertainPageAsync(
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
    protected Future<List<PreVpcDefaultDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreVpcDefaultDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreVpcDefaultDto>>) rs -> {
                    Result<PreVpcDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreVpcDefaultDto> resultList = new ArrayList<PreVpcDefaultDto>();
                    for (PreVpcDefaultDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreVpcDefaultDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreVpcDefaultDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreVpcDefaultDto>>>) rs -> {
                    Result<PreVpcDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreVpcDefaultDto> resultList = new ArrayList<PreVpcDefaultDto>();
                    for (PreVpcDefaultDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreVpcDefaultDto>>(newPagingState,resultList);
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

