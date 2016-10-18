package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreSubnetDefaultDto;
import com.worksap.company.operation.cassandra.table.PreSubnetDefaultTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreSubnetDefaultDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreSubnetDefaultDto> mapper;

    public AbstractPreSubnetDefaultDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreSubnetDefaultDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreSubnetDefaultDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreSubnetDefaultDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreSubnetDefaultDto get(String landscape, String subnetNameSuffix) {
        return mapper.get(landscape, subnetNameSuffix);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreSubnetDefaultDto> getAsync(String landscape, String subnetNameSuffix) {
        return mapper.getAsync(landscape, subnetNameSuffix);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String landscape, String subnetNameSuffix) {
        mapper.delete(landscape, subnetNameSuffix);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String landscape, String subnetNameSuffix) {
        return mapper.deleteAsync(landscape, subnetNameSuffix);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PreSubnetDefaultDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreSubnetDefaultDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreSubnetDefaultDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreSubnetDefaultDto> list) {
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
    public boolean saveLwt(PreSubnetDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreSubnetDefaultTable._NAME)
                .value(PreSubnetDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreSubnetDefaultTable.SUBNET_NAME_SUFFIX, dto.getSubnetNameSuffix())
                .value(PreSubnetDefaultTable.SUB_REGION, dto.getSubRegion())
                .value(PreSubnetDefaultTable.SUBNET_CIDR_SUFFIX, dto.getSubnetCidrSuffix())
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
    public Future<Boolean> saveLwtAsync(PreSubnetDefaultDto dto){
        Statement query = QueryBuilder.insertInto(PreSubnetDefaultTable._NAME)
                .value(PreSubnetDefaultTable.LANDSCAPE, dto.getLandscape())
                .value(PreSubnetDefaultTable.SUBNET_NAME_SUFFIX, dto.getSubnetNameSuffix())
                .value(PreSubnetDefaultTable.SUB_REGION, dto.getSubRegion())
                .value(PreSubnetDefaultTable.SUBNET_CIDR_SUFFIX, dto.getSubnetCidrSuffix())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreSubnetDefaultDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreSubnetDefaultDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDefaultDto> getByPk(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME)
				.where(QueryBuilder.eq(PreSubnetDefaultTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDefaultDto>> getByPkAsync(/*partition key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME)
				.where(QueryBuilder.eq(PreSubnetDefaultTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDefaultDto> getByPkCk1(/*partition key*/ String landscape
	                              /*clustering key*/ , String subnetNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME)
				.where(QueryBuilder.eq(PreSubnetDefaultTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetDefaultTable.SUBNET_NAME_SUFFIX,subnetNameSuffix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDefaultDto>> getByPkCk1Async(/*partition key*/ String landscape
	                            /*clustering key*/ , String subnetNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME)
				.where(QueryBuilder.eq(PreSubnetDefaultTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetDefaultTable.SUBNET_NAME_SUFFIX,subnetNameSuffix))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDefaultDto> getByCk1(/*clustering key*/ String subnetNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSubnetDefaultTable.SUBNET_NAME_SUFFIX,subnetNameSuffix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDefaultDto>> getByCk1Async(/*clustering key*/ String subnetNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSubnetDefaultTable.SUBNET_NAME_SUFFIX,subnetNameSuffix))
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
    public Pair<PagingState,List<PreSubnetDefaultDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreSubnetDefaultDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreSubnetDefaultDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreSubnetDefaultDto> resultList = new ArrayList<PreSubnetDefaultDto>();
        for (PreSubnetDefaultDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreSubnetDefaultDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreSubnetDefaultDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreSubnetDefaultDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreSubnetDefaultDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetDefaultTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreSubnetDefaultDto>>> queryCertainPageAsync(
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
    protected Future<List<PreSubnetDefaultDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreSubnetDefaultDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreSubnetDefaultDto>>) rs -> {
                    Result<PreSubnetDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreSubnetDefaultDto> resultList = new ArrayList<PreSubnetDefaultDto>();
                    for (PreSubnetDefaultDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreSubnetDefaultDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreSubnetDefaultDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreSubnetDefaultDto>>>) rs -> {
                    Result<PreSubnetDefaultDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreSubnetDefaultDto> resultList = new ArrayList<PreSubnetDefaultDto>();
                    for (PreSubnetDefaultDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreSubnetDefaultDto>>(newPagingState,resultList);
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

