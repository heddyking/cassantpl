package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.AwsRegionDto;
import com.worksap.company.operation.cassandra.table.AwsRegionTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractAwsRegionDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<AwsRegionDto> mapper;

    public AbstractAwsRegionDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(AwsRegionDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(AwsRegionDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(AwsRegionDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public AwsRegionDto get(String ptk, String region) {
        return mapper.get(ptk, region);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<AwsRegionDto> getAsync(String ptk, String region) {
        return mapper.getAsync(ptk, region);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String ptk, String region) {
        mapper.delete(ptk, region);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String ptk, String region) {
        return mapper.deleteAsync(ptk, region);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(AwsRegionDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(AwsRegionDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<AwsRegionDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<AwsRegionDto> list) {
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
    public boolean saveLwt(AwsRegionDto dto){
        Statement query = QueryBuilder.insertInto(AwsRegionTable._NAME)
                .value(AwsRegionTable.PTK, dto.getPtk())
                .value(AwsRegionTable.REGION, dto.getRegion())
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
    public Future<Boolean> saveLwtAsync(AwsRegionDto dto){
        Statement query = QueryBuilder.insertInto(AwsRegionTable._NAME)
                .value(AwsRegionTable.PTK, dto.getPtk())
                .value(AwsRegionTable.REGION, dto.getRegion())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<AwsRegionDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<AwsRegionDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<AwsRegionDto> getByPk(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME)
				.where(QueryBuilder.eq(AwsRegionTable.PTK,ptk))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsRegionDto>> getByPkAsync(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME)
				.where(QueryBuilder.eq(AwsRegionTable.PTK,ptk))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsRegionDto> getByPkCk1(/*partition key*/ String ptk
	                              /*clustering key*/ , String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME)
				.where(QueryBuilder.eq(AwsRegionTable.PTK,ptk))
				.and(QueryBuilder.eq(AwsRegionTable.REGION,region))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsRegionDto>> getByPkCk1Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME)
				.where(QueryBuilder.eq(AwsRegionTable.PTK,ptk))
				.and(QueryBuilder.eq(AwsRegionTable.REGION,region))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsRegionDto> getByCk1(/*clustering key*/ String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsRegionTable.REGION,region))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsRegionDto>> getByCk1Async(/*clustering key*/ String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsRegionTable.REGION,region))
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
    public Pair<PagingState,List<AwsRegionDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<AwsRegionDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<AwsRegionDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<AwsRegionDto> resultList = new ArrayList<AwsRegionDto>();
        for (AwsRegionDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<AwsRegionDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<AwsRegionDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<AwsRegionDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<AwsRegionDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsRegionTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<AwsRegionDto>>> queryCertainPageAsync(
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
    protected Future<List<AwsRegionDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<AwsRegionDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<AwsRegionDto>>) rs -> {
                    Result<AwsRegionDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AwsRegionDto> resultList = new ArrayList<AwsRegionDto>();
                    for (AwsRegionDto dto : results) {
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
    protected Future<Pair<PagingState,List<AwsRegionDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<AwsRegionDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<AwsRegionDto>>>) rs -> {
                    Result<AwsRegionDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AwsRegionDto> resultList = new ArrayList<AwsRegionDto>();
                    for (AwsRegionDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<AwsRegionDto>>(newPagingState,resultList);
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

