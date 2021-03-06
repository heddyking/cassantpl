package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreInstanceDefaultDto;
import com.worksap.company.operation.cassandra.table.PreInstanceDefaultTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreInstanceDefaultDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreInstanceDefaultDto> mapper;

    public AbstractPreInstanceDefaultDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreInstanceDefaultDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreInstanceDefaultDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreInstanceDefaultDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreInstanceDefaultDto get(String landscape, String instanceNameSuffix) {
        return mapper.get(landscape, instanceNameSuffix);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreInstanceDefaultDto> getAsync(String landscape, String instanceNameSuffix) {
        return mapper.getAsync(landscape, instanceNameSuffix);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String landscape, String instanceNameSuffix) {
        mapper.delete(landscape, instanceNameSuffix);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String landscape, String instanceNameSuffix) {
        return mapper.deleteAsync(landscape, instanceNameSuffix);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PreInstanceDefaultDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreInstanceDefaultDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreInstanceDefaultDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreInstanceDefaultDto> list) {
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
    public boolean saveLwt(PreInstanceDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreInstanceDefaultTable._NAME)
                .value(PreInstanceDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreInstanceDefaultTable.INSTANCE_NAME_SUFFIX, dto.getInstanceNameSuffix())
                .value(PreInstanceDefaultTable.IMAGE_ID, dto.getImageId())
                .value(PreInstanceDefaultTable.INSTANCE_TYPE, dto.getInstanceType())
                .value(PreInstanceDefaultTable.KEY_NAME, dto.getKeyName())
                .value(PreInstanceDefaultTable.NUM, dto.getNum())
                .value(PreInstanceDefaultTable.VOLUMES, dto.getVolumes())
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
    public Future<Boolean> saveLwtAsync(PreInstanceDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreInstanceDefaultTable._NAME)
                .value(PreInstanceDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreInstanceDefaultTable.INSTANCE_NAME_SUFFIX, dto.getInstanceNameSuffix())
                .value(PreInstanceDefaultTable.IMAGE_ID, dto.getImageId())
                .value(PreInstanceDefaultTable.INSTANCE_TYPE, dto.getInstanceType())
                .value(PreInstanceDefaultTable.KEY_NAME, dto.getKeyName())
                .value(PreInstanceDefaultTable.NUM, dto.getNum())
                .value(PreInstanceDefaultTable.VOLUMES, dto.getVolumes())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreInstanceDefaultDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreInstanceDefaultDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDefaultDto> getByPk(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME)
				.where(QueryBuilder.eq(PreInstanceDefaultTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDefaultDto>> getByPkAsync(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME)
				.where(QueryBuilder.eq(PreInstanceDefaultTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDefaultDto> getByPkCk1(/*partition key*/ String landscape
	                              /*clustering key*/ , String instanceNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME)
				.where(QueryBuilder.eq(PreInstanceDefaultTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceDefaultTable.INSTANCE_NAME_SUFFIX,instanceNameSuffix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDefaultDto>> getByPkCk1Async(/*partition key*/ String landscape
	                            /*clustering key*/ , String instanceNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME)
				.where(QueryBuilder.eq(PreInstanceDefaultTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceDefaultTable.INSTANCE_NAME_SUFFIX,instanceNameSuffix))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDefaultDto> getByCk1(/*clustering key*/ String instanceNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreInstanceDefaultTable.INSTANCE_NAME_SUFFIX,instanceNameSuffix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDefaultDto>> getByCk1Async(/*clustering key*/ String instanceNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreInstanceDefaultTable.INSTANCE_NAME_SUFFIX,instanceNameSuffix))
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
    public Pair<PagingState,List<PreInstanceDefaultDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreInstanceDefaultDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreInstanceDefaultDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreInstanceDefaultDto> resultList = new ArrayList<PreInstanceDefaultDto>();
        for (PreInstanceDefaultDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreInstanceDefaultDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreInstanceDefaultDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreInstanceDefaultDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreInstanceDefaultDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceDefaultTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreInstanceDefaultDto>>> queryCertainPageAsync(
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
    protected Future<List<PreInstanceDefaultDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreInstanceDefaultDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreInstanceDefaultDto>>) rs -> {
                    Result<PreInstanceDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreInstanceDefaultDto> resultList = new ArrayList<PreInstanceDefaultDto>();
                    for (PreInstanceDefaultDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreInstanceDefaultDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreInstanceDefaultDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreInstanceDefaultDto>>>) rs -> {
                    Result<PreInstanceDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreInstanceDefaultDto> resultList = new ArrayList<PreInstanceDefaultDto>();
                    for (PreInstanceDefaultDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreInstanceDefaultDto>>(newPagingState,resultList);
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

