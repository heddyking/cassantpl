package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreInstanceDto;
import com.worksap.company.operation.cassandra.table.PreInstanceTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreInstanceDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreInstanceDto> mapper;

    public AbstractPreInstanceDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreInstanceDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreInstanceDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreInstanceDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreInstanceDto get(String tenantId, String landscape, UUID ts, String instanceNameSuffix) {
        return mapper.get(tenantId, landscape, ts, instanceNameSuffix);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreInstanceDto> getAsync(String tenantId, String landscape, UUID ts, String instanceNameSuffix) {
        return mapper.getAsync(tenantId, landscape, ts, instanceNameSuffix);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape, UUID ts, String instanceNameSuffix) {
        mapper.delete(tenantId, landscape, ts, instanceNameSuffix);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape, UUID ts, String instanceNameSuffix) {
        return mapper.deleteAsync(tenantId, landscape, ts, instanceNameSuffix);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PreInstanceDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreInstanceDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreInstanceDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreInstanceDto> list) {
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
    public boolean saveLwt(PreInstanceDto dto){
        Statement query = QueryBuilder.insertInto(PreInstanceTable._NAME)
                .value(PreInstanceTable.TENANT_ID, dto.getTenantId())
                .value(PreInstanceTable.LANDSCAPE, dto.getLandscape())
                .value(PreInstanceTable.TS, dto.getTs())
                .value(PreInstanceTable.INSTANCE_NAME_SUFFIX, dto.getInstanceNameSuffix())
                .value(PreInstanceTable.IMAGE_ID, dto.getImageId())
                .value(PreInstanceTable.INSTANCE_TYPE, dto.getInstanceType())
                .value(PreInstanceTable.KEY_NAME, dto.getKeyName())
                .value(PreInstanceTable.NUM, dto.getNum())
                .value(PreInstanceTable.VOLUMES, dto.getVolumes())
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
    public Future<Boolean> saveLwtAsync(PreInstanceDto dto){
        Statement query = QueryBuilder.insertInto(PreInstanceTable._NAME)
                .value(PreInstanceTable.TENANT_ID, dto.getTenantId())
                .value(PreInstanceTable.LANDSCAPE, dto.getLandscape())
                .value(PreInstanceTable.TS, dto.getTs())
                .value(PreInstanceTable.INSTANCE_NAME_SUFFIX, dto.getInstanceNameSuffix())
                .value(PreInstanceTable.IMAGE_ID, dto.getImageId())
                .value(PreInstanceTable.INSTANCE_TYPE, dto.getInstanceType())
                .value(PreInstanceTable.KEY_NAME, dto.getKeyName())
                .value(PreInstanceTable.NUM, dto.getNum())
                .value(PreInstanceTable.VOLUMES, dto.getVolumes())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreInstanceDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreInstanceDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
				.where(QueryBuilder.eq(PreInstanceTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
				.where(QueryBuilder.eq(PreInstanceTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
				.where(QueryBuilder.eq(PreInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
				.where(QueryBuilder.eq(PreInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
				.where(QueryBuilder.eq(PreInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
				.where(QueryBuilder.eq(PreInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDto> getByPkCk3(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String instanceNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
				.where(QueryBuilder.eq(PreInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PreInstanceTable.INSTANCE_NAME_SUFFIX,instanceNameSuffix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDto>> getByPkCk3Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts, String instanceNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
				.where(QueryBuilder.eq(PreInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PreInstanceTable.INSTANCE_NAME_SUFFIX,instanceNameSuffix))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreInstanceDto> getByCk3(/*clustering key*/ String landscape, UUID ts, String instanceNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PreInstanceTable.INSTANCE_NAME_SUFFIX,instanceNameSuffix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreInstanceDto>> getByCk3Async(/*clustering key*/ String landscape, UUID ts, String instanceNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PreInstanceTable.INSTANCE_NAME_SUFFIX,instanceNameSuffix))
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
    public Pair<PagingState,List<PreInstanceDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreInstanceDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreInstanceDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreInstanceDto> resultList = new ArrayList<PreInstanceDto>();
        for (PreInstanceDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreInstanceDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreInstanceDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreInstanceDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreInstanceDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreInstanceTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreInstanceDto>>> queryCertainPageAsync(
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
    protected Future<List<PreInstanceDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreInstanceDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreInstanceDto>>) rs -> {
                    Result<PreInstanceDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreInstanceDto> resultList = new ArrayList<PreInstanceDto>();
                    for (PreInstanceDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreInstanceDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreInstanceDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreInstanceDto>>>) rs -> {
                    Result<PreInstanceDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreInstanceDto> resultList = new ArrayList<PreInstanceDto>();
                    for (PreInstanceDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreInstanceDto>>(newPagingState,resultList);
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

