package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreMsaDefaultDto;
import com.worksap.company.operation.cassandra.table.PreMsaDefaultTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreMsaDefaultDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreMsaDefaultDto> mapper;

    public AbstractPreMsaDefaultDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreMsaDefaultDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreMsaDefaultDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreMsaDefaultDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreMsaDefaultDto get(String landscape) {
        return mapper.get(landscape);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreMsaDefaultDto> getAsync(String landscape) {
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
    public void delete(PreMsaDefaultDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreMsaDefaultDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreMsaDefaultDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreMsaDefaultDto> list) {
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
    public boolean saveLwt(PreMsaDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreMsaDefaultTable._NAME)
                .value(PreMsaDefaultTable.LANDSCAPE, dto.getLandscape())
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
    public Future<Boolean> saveLwtAsync(PreMsaDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreMsaDefaultTable._NAME)
                .value(PreMsaDefaultTable.LANDSCAPE, dto.getLandscape())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreMsaDefaultDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreMsaDefaultTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreMsaDefaultDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreMsaDefaultTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreMsaDefaultDto> getByPk(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreMsaDefaultTable._NAME)
				.where(QueryBuilder.eq(PreMsaDefaultTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreMsaDefaultDto>> getByPkAsync(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreMsaDefaultTable._NAME)
				.where(QueryBuilder.eq(PreMsaDefaultTable.LANDSCAPE,landscape))
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
    public Pair<PagingState,List<PreMsaDefaultDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreMsaDefaultTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreMsaDefaultDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreMsaDefaultDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreMsaDefaultDto> resultList = new ArrayList<PreMsaDefaultDto>();
        for (PreMsaDefaultDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreMsaDefaultDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreMsaDefaultDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreMsaDefaultTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreMsaDefaultDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreMsaDefaultDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreMsaDefaultTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreMsaDefaultDto>>> queryCertainPageAsync(
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
    protected Future<List<PreMsaDefaultDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreMsaDefaultDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreMsaDefaultDto>>) rs -> {
                    Result<PreMsaDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreMsaDefaultDto> resultList = new ArrayList<PreMsaDefaultDto>();
                    for (PreMsaDefaultDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreMsaDefaultDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreMsaDefaultDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreMsaDefaultDto>>>) rs -> {
                    Result<PreMsaDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreMsaDefaultDto> resultList = new ArrayList<PreMsaDefaultDto>();
                    for (PreMsaDefaultDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreMsaDefaultDto>>(newPagingState,resultList);
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

