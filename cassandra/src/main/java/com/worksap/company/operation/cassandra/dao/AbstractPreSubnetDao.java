package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PreSubnetDto;
import com.worksap.company.operation.cassandra.table.PreSubnetTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPreSubnetDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PreSubnetDto> mapper;

    public AbstractPreSubnetDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PreSubnetDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PreSubnetDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PreSubnetDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PreSubnetDto get(String tenantId, String landscape, UUID ts, String subnetNameSuffix) {
        return mapper.get(tenantId, landscape, ts, subnetNameSuffix);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PreSubnetDto> getAsync(String tenantId, String landscape, UUID ts, String subnetNameSuffix) {
        return mapper.getAsync(tenantId, landscape, ts, subnetNameSuffix);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape, UUID ts, String subnetNameSuffix) {
        mapper.delete(tenantId, landscape, ts, subnetNameSuffix);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape, UUID ts, String subnetNameSuffix) {
        return mapper.deleteAsync(tenantId, landscape, ts, subnetNameSuffix);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PreSubnetDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PreSubnetDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PreSubnetDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PreSubnetDto> list) {
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
    public boolean saveLwt(PreSubnetDto dto){
        Statement query = QueryBuilder.insertInto(PreSubnetTable._NAME)
                .value(PreSubnetTable.TENANT_ID, dto.getTenantId())
                .value(PreSubnetTable.LANDSCAPE, dto.getLandscape())
                .value(PreSubnetTable.TS, dto.getTs())
                .value(PreSubnetTable.SUBNET_NAME_SUFFIX, dto.getSubnetNameSuffix())
                .value(PreSubnetTable.SUB_REGION, dto.getSubRegion())
                .value(PreSubnetTable.SUBNET_CIDR_SUFFIX, dto.getSubnetCidrSuffix())
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
    public Future<Boolean> saveLwtAsync(PreSubnetDto dto){
        Statement query = QueryBuilder.insertInto(PreSubnetTable._NAME)
                .value(PreSubnetTable.TENANT_ID, dto.getTenantId())
                .value(PreSubnetTable.LANDSCAPE, dto.getLandscape())
                .value(PreSubnetTable.TS, dto.getTs())
                .value(PreSubnetTable.SUBNET_NAME_SUFFIX, dto.getSubnetNameSuffix())
                .value(PreSubnetTable.SUB_REGION, dto.getSubRegion())
                .value(PreSubnetTable.SUBNET_CIDR_SUFFIX, dto.getSubnetCidrSuffix())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PreSubnetDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PreSubnetDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
				.where(QueryBuilder.eq(PreSubnetTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
				.where(QueryBuilder.eq(PreSubnetTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
				.where(QueryBuilder.eq(PreSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
				.where(QueryBuilder.eq(PreSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
				.where(QueryBuilder.eq(PreSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
				.where(QueryBuilder.eq(PreSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDto> getByPkCk3(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String subnetNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
				.where(QueryBuilder.eq(PreSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PreSubnetTable.SUBNET_NAME_SUFFIX,subnetNameSuffix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDto>> getByPkCk3Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts, String subnetNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
				.where(QueryBuilder.eq(PreSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PreSubnetTable.SUBNET_NAME_SUFFIX,subnetNameSuffix))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PreSubnetDto> getByCk3(/*clustering key*/ String landscape, UUID ts, String subnetNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PreSubnetTable.SUBNET_NAME_SUFFIX,subnetNameSuffix))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PreSubnetDto>> getByCk3Async(/*clustering key*/ String landscape, UUID ts, String subnetNameSuffix) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PreSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PreSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PreSubnetTable.SUBNET_NAME_SUFFIX,subnetNameSuffix))
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
    public Pair<PagingState,List<PreSubnetDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PreSubnetDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PreSubnetDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PreSubnetDto> resultList = new ArrayList<PreSubnetDto>();
        for (PreSubnetDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PreSubnetDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PreSubnetDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PreSubnetDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PreSubnetDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PreSubnetTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PreSubnetDto>>> queryCertainPageAsync(
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
    protected Future<List<PreSubnetDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PreSubnetDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PreSubnetDto>>) rs -> {
                    Result<PreSubnetDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreSubnetDto> resultList = new ArrayList<PreSubnetDto>();
                    for (PreSubnetDto dto : results) {
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
    protected Future<Pair<PagingState,List<PreSubnetDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PreSubnetDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PreSubnetDto>>>) rs -> {
                    Result<PreSubnetDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PreSubnetDto> resultList = new ArrayList<PreSubnetDto>();
                    for (PreSubnetDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PreSubnetDto>>(newPagingState,resultList);
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

