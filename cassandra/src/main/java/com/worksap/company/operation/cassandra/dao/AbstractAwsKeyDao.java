package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.AwsKeyDto;
import com.worksap.company.operation.cassandra.table.AwsKeyTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractAwsKeyDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<AwsKeyDto> mapper;

    public AbstractAwsKeyDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(AwsKeyDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(AwsKeyDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(AwsKeyDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public AwsKeyDto get(String ptk, String awsAccessKey, String awsSecretKey) {
        return mapper.get(ptk, awsAccessKey, awsSecretKey);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<AwsKeyDto> getAsync(String ptk, String awsAccessKey, String awsSecretKey) {
        return mapper.getAsync(ptk, awsAccessKey, awsSecretKey);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String ptk, String awsAccessKey, String awsSecretKey) {
        mapper.delete(ptk, awsAccessKey, awsSecretKey);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String ptk, String awsAccessKey, String awsSecretKey) {
        return mapper.deleteAsync(ptk, awsAccessKey, awsSecretKey);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(AwsKeyDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(AwsKeyDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<AwsKeyDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<AwsKeyDto> list) {
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
    public boolean saveLwt(AwsKeyDto dto){
        Statement query = QueryBuilder.insertInto(AwsKeyTable._NAME)
                .value(AwsKeyTable.PTK, dto.getPtk())
                .value(AwsKeyTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(AwsKeyTable.AWS_SECRET_KEY, dto.getAwsSecretKey())
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
    public Future<Boolean> saveLwtAsync(AwsKeyDto dto){
        Statement query = QueryBuilder.insertInto(AwsKeyTable._NAME)
                .value(AwsKeyTable.PTK, dto.getPtk())
                .value(AwsKeyTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(AwsKeyTable.AWS_SECRET_KEY, dto.getAwsSecretKey())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<AwsKeyDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<AwsKeyDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<AwsKeyDto> getByPk(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
				.where(QueryBuilder.eq(AwsKeyTable.PTK,ptk))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsKeyDto>> getByPkAsync(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
				.where(QueryBuilder.eq(AwsKeyTable.PTK,ptk))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsKeyDto> getByPkCk1(/*partition key*/ String ptk
	                              /*clustering key*/ , String awsAccessKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
				.where(QueryBuilder.eq(AwsKeyTable.PTK,ptk))
				.and(QueryBuilder.eq(AwsKeyTable.AWS_ACCESS_KEY,awsAccessKey))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsKeyDto>> getByPkCk1Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String awsAccessKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
				.where(QueryBuilder.eq(AwsKeyTable.PTK,ptk))
				.and(QueryBuilder.eq(AwsKeyTable.AWS_ACCESS_KEY,awsAccessKey))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsKeyDto> getByCk1(/*clustering key*/ String awsAccessKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsKeyTable.AWS_ACCESS_KEY,awsAccessKey))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsKeyDto>> getByCk1Async(/*clustering key*/ String awsAccessKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsKeyTable.AWS_ACCESS_KEY,awsAccessKey))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsKeyDto> getByPkCk2(/*partition key*/ String ptk
	                              /*clustering key*/ , String awsAccessKey, String awsSecretKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
				.where(QueryBuilder.eq(AwsKeyTable.PTK,ptk))
				.and(QueryBuilder.eq(AwsKeyTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsKeyTable.AWS_SECRET_KEY,awsSecretKey))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsKeyDto>> getByPkCk2Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String awsAccessKey, String awsSecretKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
				.where(QueryBuilder.eq(AwsKeyTable.PTK,ptk))
				.and(QueryBuilder.eq(AwsKeyTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsKeyTable.AWS_SECRET_KEY,awsSecretKey))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsKeyDto> getByCk2(/*clustering key*/ String awsAccessKey, String awsSecretKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsKeyTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsKeyTable.AWS_SECRET_KEY,awsSecretKey))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsKeyDto>> getByCk2Async(/*clustering key*/ String awsAccessKey, String awsSecretKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsKeyTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsKeyTable.AWS_SECRET_KEY,awsSecretKey))
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
    public Pair<PagingState,List<AwsKeyDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<AwsKeyDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<AwsKeyDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<AwsKeyDto> resultList = new ArrayList<AwsKeyDto>();
        for (AwsKeyDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<AwsKeyDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<AwsKeyDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<AwsKeyDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<AwsKeyDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsKeyTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<AwsKeyDto>>> queryCertainPageAsync(
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
    protected Future<List<AwsKeyDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<AwsKeyDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<AwsKeyDto>>) rs -> {
                    Result<AwsKeyDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AwsKeyDto> resultList = new ArrayList<AwsKeyDto>();
                    for (AwsKeyDto dto : results) {
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
    protected Future<Pair<PagingState,List<AwsKeyDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<AwsKeyDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<AwsKeyDto>>>) rs -> {
                    Result<AwsKeyDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AwsKeyDto> resultList = new ArrayList<AwsKeyDto>();
                    for (AwsKeyDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<AwsKeyDto>>(newPagingState,resultList);
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

