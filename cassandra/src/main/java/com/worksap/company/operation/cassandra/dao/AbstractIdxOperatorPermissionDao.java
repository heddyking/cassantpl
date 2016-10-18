package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.IdxOperatorPermissionDto;
import com.worksap.company.operation.cassandra.table.IdxOperatorPermissionTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractIdxOperatorPermissionDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<IdxOperatorPermissionDto> mapper;

    public AbstractIdxOperatorPermissionDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(IdxOperatorPermissionDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(IdxOperatorPermissionDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(IdxOperatorPermissionDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public IdxOperatorPermissionDto get(String operatorId, String tenantId, String landscape, String pgroup) {
        return mapper.get(operatorId, tenantId, landscape, pgroup);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<IdxOperatorPermissionDto> getAsync(String operatorId, String tenantId, String landscape, String pgroup) {
        return mapper.getAsync(operatorId, tenantId, landscape, pgroup);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String operatorId, String tenantId, String landscape, String pgroup) {
        mapper.delete(operatorId, tenantId, landscape, pgroup);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String operatorId, String tenantId, String landscape, String pgroup) {
        return mapper.deleteAsync(operatorId, tenantId, landscape, pgroup);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(IdxOperatorPermissionDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(IdxOperatorPermissionDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<IdxOperatorPermissionDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<IdxOperatorPermissionDto> list) {
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
    public boolean saveLwt(IdxOperatorPermissionDto dto){
        Statement query = QueryBuilder.insertInto(IdxOperatorPermissionTable._NAME)
                .value(IdxOperatorPermissionTable.OPERATOR_ID, dto.getOperatorId())
                .value(IdxOperatorPermissionTable.TENANT_ID, dto.getTenantId())
                .value(IdxOperatorPermissionTable.LANDSCAPE, dto.getLandscape())
                .value(IdxOperatorPermissionTable.PGROUP, dto.getPgroup())
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
    public Future<Boolean> saveLwtAsync(IdxOperatorPermissionDto dto){
        Statement query = QueryBuilder.insertInto(IdxOperatorPermissionTable._NAME)
                .value(IdxOperatorPermissionTable.OPERATOR_ID, dto.getOperatorId())
                .value(IdxOperatorPermissionTable.TENANT_ID, dto.getTenantId())
                .value(IdxOperatorPermissionTable.LANDSCAPE, dto.getLandscape())
                .value(IdxOperatorPermissionTable.PGROUP, dto.getPgroup())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<IdxOperatorPermissionDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<IdxOperatorPermissionDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<IdxOperatorPermissionDto> getByPk(/*partition key*/ String operatorId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.OPERATOR_ID,operatorId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxOperatorPermissionDto>> getByPkAsync(/*partition key*/ String operatorId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.OPERATOR_ID,operatorId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<IdxOperatorPermissionDto> getByPkCk1(/*partition key*/ String operatorId
	                              /*clustering key*/ , String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.OPERATOR_ID,operatorId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxOperatorPermissionDto>> getByPkCk1Async(/*partition key*/ String operatorId
	                            /*clustering key*/ , String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.OPERATOR_ID,operatorId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<IdxOperatorPermissionDto> getByCk1(/*clustering key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxOperatorPermissionDto>> getByCk1Async(/*clustering key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<IdxOperatorPermissionDto> getByPkCk2(/*partition key*/ String operatorId
	                              /*clustering key*/ , String tenantId, String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.OPERATOR_ID,operatorId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxOperatorPermissionDto>> getByPkCk2Async(/*partition key*/ String operatorId
	                            /*clustering key*/ , String tenantId, String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.OPERATOR_ID,operatorId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<IdxOperatorPermissionDto> getByCk2(/*clustering key*/ String tenantId, String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxOperatorPermissionDto>> getByCk2Async(/*clustering key*/ String tenantId, String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<IdxOperatorPermissionDto> getByPkCk3(/*partition key*/ String operatorId
	                              /*clustering key*/ , String tenantId, String landscape, String pgroup) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.OPERATOR_ID,operatorId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.PGROUP,pgroup))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxOperatorPermissionDto>> getByPkCk3Async(/*partition key*/ String operatorId
	                            /*clustering key*/ , String tenantId, String landscape, String pgroup) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.OPERATOR_ID,operatorId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.PGROUP,pgroup))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<IdxOperatorPermissionDto> getByCk3(/*clustering key*/ String tenantId, String landscape, String pgroup) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.PGROUP,pgroup))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<IdxOperatorPermissionDto>> getByCk3Async(/*clustering key*/ String tenantId, String landscape, String pgroup) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(IdxOperatorPermissionTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(IdxOperatorPermissionTable.PGROUP,pgroup))
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
    public Pair<PagingState,List<IdxOperatorPermissionDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<IdxOperatorPermissionDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<IdxOperatorPermissionDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<IdxOperatorPermissionDto> resultList = new ArrayList<IdxOperatorPermissionDto>();
        for (IdxOperatorPermissionDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<IdxOperatorPermissionDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<IdxOperatorPermissionDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<IdxOperatorPermissionDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<IdxOperatorPermissionDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(IdxOperatorPermissionTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<IdxOperatorPermissionDto>>> queryCertainPageAsync(
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
    protected Future<List<IdxOperatorPermissionDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<IdxOperatorPermissionDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<IdxOperatorPermissionDto>>) rs -> {
                    Result<IdxOperatorPermissionDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<IdxOperatorPermissionDto> resultList = new ArrayList<IdxOperatorPermissionDto>();
                    for (IdxOperatorPermissionDto dto : results) {
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
    protected Future<Pair<PagingState,List<IdxOperatorPermissionDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<IdxOperatorPermissionDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<IdxOperatorPermissionDto>>>) rs -> {
                    Result<IdxOperatorPermissionDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<IdxOperatorPermissionDto> resultList = new ArrayList<IdxOperatorPermissionDto>();
                    for (IdxOperatorPermissionDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<IdxOperatorPermissionDto>>(newPagingState,resultList);
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

