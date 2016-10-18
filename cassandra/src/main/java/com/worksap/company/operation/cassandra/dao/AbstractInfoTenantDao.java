package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.InfoTenantDto;
import com.worksap.company.operation.cassandra.table.InfoTenantTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractInfoTenantDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<InfoTenantDto> mapper;

    public AbstractInfoTenantDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(InfoTenantDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(InfoTenantDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(InfoTenantDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public InfoTenantDto get(String tenantId) {
        return mapper.get(tenantId);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<InfoTenantDto> getAsync(String tenantId) {
        return mapper.getAsync(tenantId);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId) {
        mapper.delete(tenantId);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId) {
        return mapper.deleteAsync(tenantId);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(InfoTenantDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(InfoTenantDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<InfoTenantDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<InfoTenantDto> list) {
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
    public boolean saveLwt(InfoTenantDto dto){
        Statement query = QueryBuilder.insertInto(InfoTenantTable._NAME)
                .value(InfoTenantTable.TENANT_ID, dto.getTenantId())
                .value(InfoTenantTable.CORPORATION_ID, dto.getCorporationId())
                .value(InfoTenantTable.CREATED_AT, dto.getCreatedAt())
                .value(InfoTenantTable.LICENSE_END_TIME, dto.getLicenseEndTime())
                .value(InfoTenantTable.LICENSE_ID, dto.getLicenseId())
                .value(InfoTenantTable.LICENSE_NAME, dto.getLicenseName())
                .value(InfoTenantTable.LICENSE_START_TIME, dto.getLicenseStartTime())
                .value(InfoTenantTable.LICENSE_USERNUM, dto.getLicenseUsernum())
                .value(InfoTenantTable.RECORD_STATE, dto.getRecordState())
                .value(InfoTenantTable.TENANT_ADDRESS, dto.getTenantAddress())
                .value(InfoTenantTable.TENANT_EMAIL, dto.getTenantEmail())
                .value(InfoTenantTable.TENANT_NAME, dto.getTenantName())
                .value(InfoTenantTable.TENANT_PHONE, dto.getTenantPhone())
                .value(InfoTenantTable.TENANT_TYPE, dto.getTenantType())
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
    public Future<Boolean> saveLwtAsync(InfoTenantDto dto){
        Statement query = QueryBuilder.insertInto(InfoTenantTable._NAME)
                .value(InfoTenantTable.TENANT_ID, dto.getTenantId())
                .value(InfoTenantTable.CORPORATION_ID, dto.getCorporationId())
                .value(InfoTenantTable.CREATED_AT, dto.getCreatedAt())
                .value(InfoTenantTable.LICENSE_END_TIME, dto.getLicenseEndTime())
                .value(InfoTenantTable.LICENSE_ID, dto.getLicenseId())
                .value(InfoTenantTable.LICENSE_NAME, dto.getLicenseName())
                .value(InfoTenantTable.LICENSE_START_TIME, dto.getLicenseStartTime())
                .value(InfoTenantTable.LICENSE_USERNUM, dto.getLicenseUsernum())
                .value(InfoTenantTable.RECORD_STATE, dto.getRecordState())
                .value(InfoTenantTable.TENANT_ADDRESS, dto.getTenantAddress())
                .value(InfoTenantTable.TENANT_EMAIL, dto.getTenantEmail())
                .value(InfoTenantTable.TENANT_NAME, dto.getTenantName())
                .value(InfoTenantTable.TENANT_PHONE, dto.getTenantPhone())
                .value(InfoTenantTable.TENANT_TYPE, dto.getTenantType())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<InfoTenantDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<InfoTenantDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<InfoTenantDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME)
				.where(QueryBuilder.eq(InfoTenantTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME)
				.where(QueryBuilder.eq(InfoTenantTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoTenantDto> getByPkIdx(/*partition index*/ String tenantId
	                              /*secondary index*/ , String corporationId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME)
				.where(QueryBuilder.eq(InfoTenantTable.TENANT_ID,tenantId))
				;

        if(corporationId!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantTable.CORPORATION_ID,corporationId));
        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantDto>> getByPkIdxAsync(/*partition key*/ String tenantId
	                            /*secondary index*/ , String corporationId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME)
				.where(QueryBuilder.eq(InfoTenantTable.TENANT_ID,tenantId))
				;

        if(corporationId!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantTable.CORPORATION_ID,corporationId));
        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantTable.RECORD_STATE,recordState));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoTenantDto> getByIdx(/*secondary index*/ String corporationId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(corporationId!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(InfoTenantTable.CORPORATION_ID,corporationId));
		}
		else if(corporationId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantTable.CORPORATION_ID,corporationId));
		}
		if(recordState!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(InfoTenantTable.RECORD_STATE,recordState));
		}
		else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantTable.RECORD_STATE,recordState));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoTenantDto>> getByIdxAsync(/*secondary index*/ String corporationId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(corporationId!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(InfoTenantTable.CORPORATION_ID,corporationId));
        }
        else if(corporationId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantTable.CORPORATION_ID,corporationId));
        }
        if(recordState!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(InfoTenantTable.RECORD_STATE,recordState));
        }
        else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoTenantTable.RECORD_STATE,recordState));
        }
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
    public Pair<PagingState,List<InfoTenantDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<InfoTenantDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<InfoTenantDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<InfoTenantDto> resultList = new ArrayList<InfoTenantDto>();
        for (InfoTenantDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<InfoTenantDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<InfoTenantDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoTenantDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<InfoTenantDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoTenantTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoTenantDto>>> queryCertainPageAsync(
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
    protected Future<List<InfoTenantDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<InfoTenantDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<InfoTenantDto>>) rs -> {
                    Result<InfoTenantDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoTenantDto> resultList = new ArrayList<InfoTenantDto>();
                    for (InfoTenantDto dto : results) {
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
    protected Future<Pair<PagingState,List<InfoTenantDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<InfoTenantDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<InfoTenantDto>>>) rs -> {
                    Result<InfoTenantDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoTenantDto> resultList = new ArrayList<InfoTenantDto>();
                    for (InfoTenantDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<InfoTenantDto>>(newPagingState,resultList);
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

