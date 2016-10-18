package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreSecurityDto;
import com.worksap.company.operation.cassandra.table.PreSecurityTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreSecurityDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreSecurityDto> mapper;

    public AbstractPreSecurityDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreSecurityDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreSecurityDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreSecurityDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreSecurityDto get(String tenantId, String landscape, UUID ts, String securityNamePrefix) {
        return mapper.get(tenantId, landscape, ts, securityNamePrefix);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreSecurityDto> getAsync(String tenantId, String landscape, UUID ts, String securityNamePrefix) {
        return mapper.getAsync(tenantId, landscape, ts, securityNamePrefix);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape, UUID ts, String securityNamePrefix) {
        mapper.delete(tenantId, landscape, ts, securityNamePrefix);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape, UUID ts, String securityNamePrefix) {
        return mapper.deleteAsync(tenantId, landscape, ts, securityNamePrefix);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PreSecurityDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreSecurityDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreSecurityDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreSecurityDto> list) {
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
    public boolean saveLwt(PreSecurityDto dto){
        Statement query = QueryBuilder.insertInto(PreSecurityTable._NAME)
                .value(PreSecurityTable.TENANT_ID, dto.getTenantId())
                .value(PreSecurityTable.LANDSCAPE, dto.getLandscape())
                .value(PreSecurityTable.TS, dto.getTs())
                .value(PreSecurityTable.SECURITY_NAME_PREFIX, dto.getSecurityNamePrefix())
                .value(PreSecurityTable.CIDR_IP, dto.getCidrIp())
                .value(PreSecurityTable.FROM_PORT, dto.getFromPort())
                .value(PreSecurityTable.PROTO, dto.getProto())
                .value(PreSecurityTable.TO_PORT, dto.getToPort())
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
    public Future<Boolean> saveLwtAsync(PreSecurityDto dto){
        Statement query = QueryBuilder.insertInto(PreSecurityTable._NAME)
                .value(PreSecurityTable.TENANT_ID, dto.getTenantId())
                .value(PreSecurityTable.LANDSCAPE, dto.getLandscape())
                .value(PreSecurityTable.TS, dto.getTs())
                .value(PreSecurityTable.SECURITY_NAME_PREFIX, dto.getSecurityNamePrefix())
                .value(PreSecurityTable.CIDR_IP, dto.getCidrIp())
                .value(PreSecurityTable.FROM_PORT, dto.getFromPort())
                .value(PreSecurityTable.PROTO, dto.getProto())
                .value(PreSecurityTable.TO_PORT, dto.getToPort())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreSecurityDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreSecurityDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
				.where(QueryBuilder.eq(PreSecurityTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
				.where(QueryBuilder.eq(PreSecurityTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
				.where(QueryBuilder.eq(PreSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
				.where(QueryBuilder.eq(PreSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
				.where(QueryBuilder.eq(PreSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
				.where(QueryBuilder.eq(PreSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDto> getByPkCk3(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String securityNamePrefix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
				.where(QueryBuilder.eq(PreSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PreSecurityTable.SECURITY_NAME_PREFIX,securityNamePrefix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDto>> getByPkCk3Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts, String securityNamePrefix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
				.where(QueryBuilder.eq(PreSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PreSecurityTable.SECURITY_NAME_PREFIX,securityNamePrefix))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDto> getByCk3(/*clustering key*/ String landscape, UUID ts, String securityNamePrefix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PreSecurityTable.SECURITY_NAME_PREFIX,securityNamePrefix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDto>> getByCk3Async(/*clustering key*/ String landscape, UUID ts, String securityNamePrefix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PreSecurityTable.SECURITY_NAME_PREFIX,securityNamePrefix))
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
    public Pair<PagingState,List<PreSecurityDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreSecurityDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreSecurityDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreSecurityDto> resultList = new ArrayList<PreSecurityDto>();
        for (PreSecurityDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreSecurityDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreSecurityDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreSecurityDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreSecurityDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreSecurityDto>>> queryCertainPageAsync(
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
    protected Future<List<PreSecurityDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreSecurityDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreSecurityDto>>) rs -> {
                    Result<PreSecurityDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreSecurityDto> resultList = new ArrayList<PreSecurityDto>();
                    for (PreSecurityDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreSecurityDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreSecurityDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreSecurityDto>>>) rs -> {
                    Result<PreSecurityDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreSecurityDto> resultList = new ArrayList<PreSecurityDto>();
                    for (PreSecurityDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreSecurityDto>>(newPagingState,resultList);
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

