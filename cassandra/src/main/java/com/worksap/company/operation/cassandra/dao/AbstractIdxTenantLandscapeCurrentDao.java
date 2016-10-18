package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.IdxTenantLandscapeCurrentDto;
import com.worksap.company.operation.cassandra.table.IdxTenantLandscapeCurrentTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractIdxTenantLandscapeCurrentDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<IdxTenantLandscapeCurrentDto> mapper;

    public AbstractIdxTenantLandscapeCurrentDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(IdxTenantLandscapeCurrentDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(IdxTenantLandscapeCurrentDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(IdxTenantLandscapeCurrentDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public IdxTenantLandscapeCurrentDto get(String tenantId, String landscape) {
        return mapper.get(tenantId, landscape);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<IdxTenantLandscapeCurrentDto> getAsync(String tenantId, String landscape) {
        return mapper.getAsync(tenantId, landscape);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape) {
        mapper.delete(tenantId, landscape);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape) {
        return mapper.deleteAsync(tenantId, landscape);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(IdxTenantLandscapeCurrentDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(IdxTenantLandscapeCurrentDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<IdxTenantLandscapeCurrentDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<IdxTenantLandscapeCurrentDto> list) {
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
    public boolean saveLwt(IdxTenantLandscapeCurrentDto dto){
        Statement query = QueryBuilder.insertInto(IdxTenantLandscapeCurrentTable._NAME)
                .value(IdxTenantLandscapeCurrentTable.TENANT_ID, dto.getTenantId())
                .value(IdxTenantLandscapeCurrentTable.LANDSCAPE, dto.getLandscape())
                .value(IdxTenantLandscapeCurrentTable.TRY_TS, dto.getTryTs())
                .value(IdxTenantLandscapeCurrentTable.TRY_TYPE, dto.getTryType())
                .value(IdxTenantLandscapeCurrentTable.TS, dto.getTs())
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
    public Future<Boolean> saveLwtAsync(IdxTenantLandscapeCurrentDto dto){
        Statement query = QueryBuilder.insertInto(IdxTenantLandscapeCurrentTable._NAME)
                .value(IdxTenantLandscapeCurrentTable.TENANT_ID, dto.getTenantId())
                .value(IdxTenantLandscapeCurrentTable.LANDSCAPE, dto.getLandscape())
                .value(IdxTenantLandscapeCurrentTable.TRY_TS, dto.getTryTs())
                .value(IdxTenantLandscapeCurrentTable.TRY_TYPE, dto.getTryType())
                .value(IdxTenantLandscapeCurrentTable.TS, dto.getTs())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<IdxTenantLandscapeCurrentDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<IdxTenantLandscapeCurrentDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<IdxTenantLandscapeCurrentDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME)
				.where(QueryBuilder.eq(IdxTenantLandscapeCurrentTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxTenantLandscapeCurrentDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME)
				.where(QueryBuilder.eq(IdxTenantLandscapeCurrentTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<IdxTenantLandscapeCurrentDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME)
				.where(QueryBuilder.eq(IdxTenantLandscapeCurrentTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxTenantLandscapeCurrentTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxTenantLandscapeCurrentDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME)
				.where(QueryBuilder.eq(IdxTenantLandscapeCurrentTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxTenantLandscapeCurrentTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<IdxTenantLandscapeCurrentDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(IdxTenantLandscapeCurrentTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxTenantLandscapeCurrentDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(IdxTenantLandscapeCurrentTable.LANDSCAPE,landscape))
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
    public Pair<PagingState,List<IdxTenantLandscapeCurrentDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<IdxTenantLandscapeCurrentDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<IdxTenantLandscapeCurrentDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<IdxTenantLandscapeCurrentDto> resultList = new ArrayList<IdxTenantLandscapeCurrentDto>();
        for (IdxTenantLandscapeCurrentDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<IdxTenantLandscapeCurrentDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<IdxTenantLandscapeCurrentDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<IdxTenantLandscapeCurrentDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<IdxTenantLandscapeCurrentDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxTenantLandscapeCurrentTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<IdxTenantLandscapeCurrentDto>>> queryCertainPageAsync(
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
    protected Future<List<IdxTenantLandscapeCurrentDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<IdxTenantLandscapeCurrentDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<IdxTenantLandscapeCurrentDto>>) rs -> {
                    Result<IdxTenantLandscapeCurrentDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<IdxTenantLandscapeCurrentDto> resultList = new ArrayList<IdxTenantLandscapeCurrentDto>();
                    for (IdxTenantLandscapeCurrentDto dto : results) {
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
    protected Future<Pair<PagingState,List<IdxTenantLandscapeCurrentDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<IdxTenantLandscapeCurrentDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<IdxTenantLandscapeCurrentDto>>>) rs -> {
                    Result<IdxTenantLandscapeCurrentDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<IdxTenantLandscapeCurrentDto> resultList = new ArrayList<IdxTenantLandscapeCurrentDto>();
                    for (IdxTenantLandscapeCurrentDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<IdxTenantLandscapeCurrentDto>>(newPagingState,resultList);
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

