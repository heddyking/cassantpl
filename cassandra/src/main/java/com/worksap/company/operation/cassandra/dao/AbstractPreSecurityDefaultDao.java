package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreSecurityDefaultDto;
import com.worksap.company.operation.cassandra.table.PreSecurityDefaultTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreSecurityDefaultDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreSecurityDefaultDto> mapper;

    public AbstractPreSecurityDefaultDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreSecurityDefaultDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreSecurityDefaultDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreSecurityDefaultDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreSecurityDefaultDto get(String landscape, String securityNamePrefix) {
        return mapper.get(landscape, securityNamePrefix);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreSecurityDefaultDto> getAsync(String landscape, String securityNamePrefix) {
        return mapper.getAsync(landscape, securityNamePrefix);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String landscape, String securityNamePrefix) {
        mapper.delete(landscape, securityNamePrefix);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String landscape, String securityNamePrefix) {
        return mapper.deleteAsync(landscape, securityNamePrefix);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PreSecurityDefaultDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreSecurityDefaultDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreSecurityDefaultDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreSecurityDefaultDto> list) {
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
    public boolean saveLwt(PreSecurityDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreSecurityDefaultTable._NAME)
                .value(PreSecurityDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreSecurityDefaultTable.SECURITY_NAME_PREFIX, dto.getSecurityNamePrefix())
                .value(PreSecurityDefaultTable.CIDR_IP, dto.getCidrIp())
                .value(PreSecurityDefaultTable.FROM_PORT, dto.getFromPort())
                .value(PreSecurityDefaultTable.PROTO, dto.getProto())
                .value(PreSecurityDefaultTable.TO_PORT, dto.getToPort())
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
    public Future<Boolean> saveLwtAsync(PreSecurityDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreSecurityDefaultTable._NAME)
                .value(PreSecurityDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreSecurityDefaultTable.SECURITY_NAME_PREFIX, dto.getSecurityNamePrefix())
                .value(PreSecurityDefaultTable.CIDR_IP, dto.getCidrIp())
                .value(PreSecurityDefaultTable.FROM_PORT, dto.getFromPort())
                .value(PreSecurityDefaultTable.PROTO, dto.getProto())
                .value(PreSecurityDefaultTable.TO_PORT, dto.getToPort())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreSecurityDefaultDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreSecurityDefaultDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDefaultDto> getByPk(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME)
				.where(QueryBuilder.eq(PreSecurityDefaultTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDefaultDto>> getByPkAsync(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME)
				.where(QueryBuilder.eq(PreSecurityDefaultTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDefaultDto> getByPkCk1(/*partition key*/ String landscape
	                              /*clustering key*/ , String securityNamePrefix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME)
				.where(QueryBuilder.eq(PreSecurityDefaultTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityDefaultTable.SECURITY_NAME_PREFIX,securityNamePrefix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDefaultDto>> getByPkCk1Async(/*partition key*/ String landscape
	                            /*clustering key*/ , String securityNamePrefix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME)
				.where(QueryBuilder.eq(PreSecurityDefaultTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSecurityDefaultTable.SECURITY_NAME_PREFIX,securityNamePrefix))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSecurityDefaultDto> getByCk1(/*clustering key*/ String securityNamePrefix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSecurityDefaultTable.SECURITY_NAME_PREFIX,securityNamePrefix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSecurityDefaultDto>> getByCk1Async(/*clustering key*/ String securityNamePrefix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSecurityDefaultTable.SECURITY_NAME_PREFIX,securityNamePrefix))
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
    public Pair<PagingState,List<PreSecurityDefaultDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreSecurityDefaultDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreSecurityDefaultDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreSecurityDefaultDto> resultList = new ArrayList<PreSecurityDefaultDto>();
        for (PreSecurityDefaultDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreSecurityDefaultDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreSecurityDefaultDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreSecurityDefaultDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreSecurityDefaultDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSecurityDefaultTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreSecurityDefaultDto>>> queryCertainPageAsync(
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
    protected Future<List<PreSecurityDefaultDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreSecurityDefaultDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreSecurityDefaultDto>>) rs -> {
                    Result<PreSecurityDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreSecurityDefaultDto> resultList = new ArrayList<PreSecurityDefaultDto>();
                    for (PreSecurityDefaultDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreSecurityDefaultDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreSecurityDefaultDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreSecurityDefaultDto>>>) rs -> {
                    Result<PreSecurityDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreSecurityDefaultDto> resultList = new ArrayList<PreSecurityDefaultDto>();
                    for (PreSecurityDefaultDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreSecurityDefaultDto>>(newPagingState,resultList);
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

