package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.InfoTenantSublicenseDto;
import com.worksap.company.operation.cassandra.table.InfoTenantSublicenseTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractInfoTenantSublicenseDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<InfoTenantSublicenseDto> mapper;

    public AbstractInfoTenantSublicenseDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(InfoTenantSublicenseDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(InfoTenantSublicenseDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(InfoTenantSublicenseDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public InfoTenantSublicenseDto get(String tenantId, UUID sublicenseId) {
        return mapper.get(tenantId, sublicenseId);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<InfoTenantSublicenseDto> getAsync(String tenantId, UUID sublicenseId) {
        return mapper.getAsync(tenantId, sublicenseId);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, UUID sublicenseId) {
        mapper.delete(tenantId, sublicenseId);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, UUID sublicenseId) {
        return mapper.deleteAsync(tenantId, sublicenseId);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(InfoTenantSublicenseDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(InfoTenantSublicenseDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<InfoTenantSublicenseDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<InfoTenantSublicenseDto> list) {
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
    public boolean saveLwt(InfoTenantSublicenseDto dto){
        Statement query = QueryBuilder.insertInto(InfoTenantSublicenseTable._NAME)
                .value(InfoTenantSublicenseTable.TENANT_ID, dto.getTenantId())
                .value(InfoTenantSublicenseTable.SUBLICENSE_ID, dto.getSublicenseId())
                .value(InfoTenantSublicenseTable.RECORD_STATE, dto.getRecordState())
                .value(InfoTenantSublicenseTable.SUBLICENSE_END_TIME, dto.getSublicenseEndTime())
                .value(InfoTenantSublicenseTable.SUBLICENSE_NAME, dto.getSublicenseName())
                .value(InfoTenantSublicenseTable.SUBLICENSE_START_TIME, dto.getSublicenseStartTime())
                .value(InfoTenantSublicenseTable.SUBLICENSE_USERNUM, dto.getSublicenseUsernum())
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
    public Future<Boolean> saveLwtAsync(InfoTenantSublicenseDto dto){
        Statement query = QueryBuilder.insertInto(InfoTenantSublicenseTable._NAME)
                .value(InfoTenantSublicenseTable.TENANT_ID, dto.getTenantId())
                .value(InfoTenantSublicenseTable.SUBLICENSE_ID, dto.getSublicenseId())
                .value(InfoTenantSublicenseTable.RECORD_STATE, dto.getRecordState())
                .value(InfoTenantSublicenseTable.SUBLICENSE_END_TIME, dto.getSublicenseEndTime())
                .value(InfoTenantSublicenseTable.SUBLICENSE_NAME, dto.getSublicenseName())
                .value(InfoTenantSublicenseTable.SUBLICENSE_START_TIME, dto.getSublicenseStartTime())
                .value(InfoTenantSublicenseTable.SUBLICENSE_USERNUM, dto.getSublicenseUsernum())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<InfoTenantSublicenseDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<InfoTenantSublicenseDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<InfoTenantSublicenseDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantSublicenseDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoTenantSublicenseDto> getByPkIdx(/*partition index*/ String tenantId
	                              /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.TENANT_ID,tenantId))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantSublicenseDto>> getByPkIdxAsync(/*partition key*/ String tenantId
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.TENANT_ID,tenantId))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoTenantSublicenseDto> getByIdx(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(recordState!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
		}
		else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantSublicenseDto>> getByIdxAsync(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(recordState!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
        }
        else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
        }
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<InfoTenantSublicenseDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , UUID sublicenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(InfoTenantSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantSublicenseDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , UUID sublicenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(InfoTenantSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<InfoTenantSublicenseDto> getByCk1(/*clustering key*/ UUID sublicenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantSublicenseDto>> getByCk1Async(/*clustering key*/ UUID sublicenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoTenantSublicenseDto> getByPkCk1Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , UUID sublicenseId
								  /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(InfoTenantSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantSublicenseDto>> getByPkCk1IdxAsync(/*partition key*/ String tenantId
	                            , UUID sublicenseId
								/*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(InfoTenantSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoTenantSublicenseDto> getByCk1Idx(/*clustering key*/ UUID sublicenseId
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;

		if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantSublicenseDto>> getByCk1IdxAsync(/*clustering key*/ UUID sublicenseId
	                           /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoTenantSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantSublicenseTable.RECORD_STATE,recordState));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

    /**
     * get next page and new pagestate synchronously
     * @param size
     * @param pagingState
     */
    public Pair<PagingState,List<InfoTenantSublicenseDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<InfoTenantSublicenseDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<InfoTenantSublicenseDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<InfoTenantSublicenseDto> resultList = new ArrayList<InfoTenantSublicenseDto>();
        for (InfoTenantSublicenseDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<InfoTenantSublicenseDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<InfoTenantSublicenseDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoTenantSublicenseDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<InfoTenantSublicenseDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantSublicenseTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoTenantSublicenseDto>>> queryCertainPageAsync(
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
    protected Future<List<InfoTenantSublicenseDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<InfoTenantSublicenseDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<InfoTenantSublicenseDto>>) rs -> {
                    Result<InfoTenantSublicenseDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoTenantSublicenseDto> resultList = new ArrayList<InfoTenantSublicenseDto>();
                    for (InfoTenantSublicenseDto dto : results) {
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
    protected Future<Pair<PagingState,List<InfoTenantSublicenseDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<InfoTenantSublicenseDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<InfoTenantSublicenseDto>>>) rs -> {
                    Result<InfoTenantSublicenseDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoTenantSublicenseDto> resultList = new ArrayList<InfoTenantSublicenseDto>();
                    for (InfoTenantSublicenseDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<InfoTenantSublicenseDto>>(newPagingState,resultList);
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

