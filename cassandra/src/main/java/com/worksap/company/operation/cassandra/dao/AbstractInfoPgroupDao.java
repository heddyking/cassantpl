package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.InfoPgroupDto;
import com.worksap.company.operation.cassandra.table.InfoPgroupTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractInfoPgroupDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<InfoPgroupDto> mapper;

    public AbstractInfoPgroupDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(InfoPgroupDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(InfoPgroupDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(InfoPgroupDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public InfoPgroupDto get(String pgroup) {
        return mapper.get(pgroup);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<InfoPgroupDto> getAsync(String pgroup) {
        return mapper.getAsync(pgroup);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String pgroup) {
        mapper.delete(pgroup);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String pgroup) {
        return mapper.deleteAsync(pgroup);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(InfoPgroupDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(InfoPgroupDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<InfoPgroupDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<InfoPgroupDto> list) {
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
    public boolean saveLwt(InfoPgroupDto dto){
        Statement query = QueryBuilder.insertInto(InfoPgroupTable._NAME)
                .value(InfoPgroupTable.PGROUP, dto.getPgroup())
                .value(InfoPgroupTable.PCODES, dto.getPcodes())
                .value(InfoPgroupTable.RECORD_STATE, dto.getRecordState())
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
    public Future<Boolean> saveLwtAsync(InfoPgroupDto dto){
        Statement query = QueryBuilder.insertInto(InfoPgroupTable._NAME)
                .value(InfoPgroupTable.PGROUP, dto.getPgroup())
                .value(InfoPgroupTable.PCODES, dto.getPcodes())
                .value(InfoPgroupTable.RECORD_STATE, dto.getRecordState())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<InfoPgroupDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<InfoPgroupDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<InfoPgroupDto> getByPk(/*partition key*/ String pgroup) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME)
				.where(QueryBuilder.eq(InfoPgroupTable.PGROUP,pgroup))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPgroupDto>> getByPkAsync(/*partition key*/ String pgroup) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME)
				.where(QueryBuilder.eq(InfoPgroupTable.PGROUP,pgroup))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoPgroupDto> getByPkIdx(/*partition index*/ String pgroup
	                              /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME)
				.where(QueryBuilder.eq(InfoPgroupTable.PGROUP,pgroup))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPgroupTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPgroupDto>> getByPkIdxAsync(/*partition key*/ String pgroup
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME)
				.where(QueryBuilder.eq(InfoPgroupTable.PGROUP,pgroup))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPgroupTable.RECORD_STATE,recordState));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoPgroupDto> getByIdx(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(recordState!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(InfoPgroupTable.RECORD_STATE,recordState));
		}
		else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoPgroupTable.RECORD_STATE,recordState));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPgroupDto>> getByIdxAsync(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(recordState!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(InfoPgroupTable.RECORD_STATE,recordState));
        }
        else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoPgroupTable.RECORD_STATE,recordState));
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
    public Pair<PagingState,List<InfoPgroupDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<InfoPgroupDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<InfoPgroupDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<InfoPgroupDto> resultList = new ArrayList<InfoPgroupDto>();
        for (InfoPgroupDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<InfoPgroupDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<InfoPgroupDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoPgroupDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<InfoPgroupDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPgroupTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoPgroupDto>>> queryCertainPageAsync(
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
    protected Future<List<InfoPgroupDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<InfoPgroupDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<InfoPgroupDto>>) rs -> {
                    Result<InfoPgroupDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoPgroupDto> resultList = new ArrayList<InfoPgroupDto>();
                    for (InfoPgroupDto dto : results) {
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
    protected Future<Pair<PagingState,List<InfoPgroupDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<InfoPgroupDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<InfoPgroupDto>>>) rs -> {
                    Result<InfoPgroupDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoPgroupDto> resultList = new ArrayList<InfoPgroupDto>();
                    for (InfoPgroupDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<InfoPgroupDto>>(newPagingState,resultList);
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

