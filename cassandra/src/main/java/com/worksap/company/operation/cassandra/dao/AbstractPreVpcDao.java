package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreVpcDto;
import com.worksap.company.operation.cassandra.table.PreVpcTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreVpcDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreVpcDto> mapper;

    public AbstractPreVpcDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreVpcDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreVpcDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreVpcDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreVpcDto get(String tenantId, String landscape, UUID ts) {
        return mapper.get(tenantId, landscape, ts);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreVpcDto> getAsync(String tenantId, String landscape, UUID ts) {
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
    public void delete(PreVpcDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreVpcDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreVpcDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreVpcDto> list) {
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
    public boolean saveLwt(PreVpcDto dto){
        Statement query = QueryBuilder.insertInto(PreVpcTable._NAME)
                .value(PreVpcTable.TENANT_ID, dto.getTenantId())
                .value(PreVpcTable.LANDSCAPE, dto.getLandscape())
                .value(PreVpcTable.TS, dto.getTs())
                .value(PreVpcTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(PreVpcTable.AWS_SECRET_KEY, dto.getAwsSecretKey())
                .value(PreVpcTable.BUCKET_NAME_PREFIX, dto.getBucketNamePrefix())
                .value(PreVpcTable.CIDR_BLOCK_SUFFIX, dto.getCidrBlockSuffix())
                .value(PreVpcTable.DESTINATION_ROOT, dto.getDestinationRoot())
                .value(PreVpcTable.IGW_NAME_PREFIX, dto.getIgwNamePrefix())
                .value(PreVpcTable.IP_PREFIX, dto.getIpPrefix())
                .value(PreVpcTable.PRIVATE_IP_ADDRESS_SUFFIX, dto.getPrivateIpAddressSuffix())
                .value(PreVpcTable.PRIVATE_RT_NAME_PREFIX, dto.getPrivateRtNamePrefix())
                .value(PreVpcTable.PUBLIC_RT_NAME_PREFIX, dto.getPublicRtNamePrefix())
                .value(PreVpcTable.REGION, dto.getRegion())
                .value(PreVpcTable.SECURITY_GROUP_PREFIX, dto.getSecurityGroupPrefix())
                .value(PreVpcTable.SOURCE_ROOT, dto.getSourceRoot())
                .value(PreVpcTable.VPC_PREFIX, dto.getVpcPrefix())
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
    public Future<Boolean> saveLwtAsync(PreVpcDto dto){
        Statement query = QueryBuilder.insertInto(PreVpcTable._NAME)
                .value(PreVpcTable.TENANT_ID, dto.getTenantId())
                .value(PreVpcTable.LANDSCAPE, dto.getLandscape())
                .value(PreVpcTable.TS, dto.getTs())
                .value(PreVpcTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(PreVpcTable.AWS_SECRET_KEY, dto.getAwsSecretKey())
                .value(PreVpcTable.BUCKET_NAME_PREFIX, dto.getBucketNamePrefix())
                .value(PreVpcTable.CIDR_BLOCK_SUFFIX, dto.getCidrBlockSuffix())
                .value(PreVpcTable.DESTINATION_ROOT, dto.getDestinationRoot())
                .value(PreVpcTable.IGW_NAME_PREFIX, dto.getIgwNamePrefix())
                .value(PreVpcTable.IP_PREFIX, dto.getIpPrefix())
                .value(PreVpcTable.PRIVATE_IP_ADDRESS_SUFFIX, dto.getPrivateIpAddressSuffix())
                .value(PreVpcTable.PRIVATE_RT_NAME_PREFIX, dto.getPrivateRtNamePrefix())
                .value(PreVpcTable.PUBLIC_RT_NAME_PREFIX, dto.getPublicRtNamePrefix())
                .value(PreVpcTable.REGION, dto.getRegion())
                .value(PreVpcTable.SECURITY_GROUP_PREFIX, dto.getSecurityGroupPrefix())
                .value(PreVpcTable.SOURCE_ROOT, dto.getSourceRoot())
                .value(PreVpcTable.VPC_PREFIX, dto.getVpcPrefix())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreVpcDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreVpcDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreVpcDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
				.where(QueryBuilder.eq(PreVpcTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreVpcDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
				.where(QueryBuilder.eq(PreVpcTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreVpcDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
				.where(QueryBuilder.eq(PreVpcTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreVpcTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreVpcDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
				.where(QueryBuilder.eq(PreVpcTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreVpcTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreVpcDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreVpcTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreVpcDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreVpcTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreVpcDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
				.where(QueryBuilder.eq(PreVpcTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreVpcTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreVpcTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreVpcDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
				.where(QueryBuilder.eq(PreVpcTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreVpcTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreVpcTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreVpcDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreVpcTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreVpcTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreVpcDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreVpcTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreVpcTable.TS,ts))
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
    public Pair<PagingState,List<PreVpcDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreVpcDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreVpcDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreVpcDto> resultList = new ArrayList<PreVpcDto>();
        for (PreVpcDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreVpcDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreVpcDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreVpcDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreVpcDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreVpcTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreVpcDto>>> queryCertainPageAsync(
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
    protected Future<List<PreVpcDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreVpcDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreVpcDto>>) rs -> {
                    Result<PreVpcDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreVpcDto> resultList = new ArrayList<PreVpcDto>();
                    for (PreVpcDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreVpcDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreVpcDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreVpcDto>>>) rs -> {
                    Result<PreVpcDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreVpcDto> resultList = new ArrayList<PreVpcDto>();
                    for (PreVpcDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreVpcDto>>(newPagingState,resultList);
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

