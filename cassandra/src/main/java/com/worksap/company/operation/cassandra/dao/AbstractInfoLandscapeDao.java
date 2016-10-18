package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.InfoLandscapeDto;
import com.worksap.company.operation.cassandra.table.InfoLandscapeTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractInfoLandscapeDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<InfoLandscapeDto> mapper;

    public AbstractInfoLandscapeDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(InfoLandscapeDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(InfoLandscapeDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(InfoLandscapeDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public InfoLandscapeDto get(String ptk, String landscape) {
        return mapper.get(ptk, landscape);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<InfoLandscapeDto> getAsync(String ptk, String landscape) {
        return mapper.getAsync(ptk, landscape);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String ptk, String landscape) {
        mapper.delete(ptk, landscape);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String ptk, String landscape) {
        return mapper.deleteAsync(ptk, landscape);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(InfoLandscapeDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(InfoLandscapeDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<InfoLandscapeDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<InfoLandscapeDto> list) {
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
    public boolean saveLwt(InfoLandscapeDto dto){
        Statement query = QueryBuilder.insertInto(InfoLandscapeTable._NAME)
                .value(InfoLandscapeTable.PTK, dto.getPtk())
                .value(InfoLandscapeTable.LANDSCAPE, dto.getLandscape())
                .value(InfoLandscapeTable.DESCRIPTION, dto.getDescription())
                .value(InfoLandscapeTable.RECORD_STATE, dto.getRecordState())
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
    public Future<Boolean> saveLwtAsync(InfoLandscapeDto dto){
        Statement query = QueryBuilder.insertInto(InfoLandscapeTable._NAME)
                .value(InfoLandscapeTable.PTK, dto.getPtk())
                .value(InfoLandscapeTable.LANDSCAPE, dto.getLandscape())
                .value(InfoLandscapeTable.DESCRIPTION, dto.getDescription())
                .value(InfoLandscapeTable.RECORD_STATE, dto.getRecordState())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<InfoLandscapeDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<InfoLandscapeDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<InfoLandscapeDto> getByPk(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
				.where(QueryBuilder.eq(InfoLandscapeTable.PTK,ptk))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLandscapeDto>> getByPkAsync(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
				.where(QueryBuilder.eq(InfoLandscapeTable.PTK,ptk))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoLandscapeDto> getByPkIdx(/*partition index*/ String ptk
	                              /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
				.where(QueryBuilder.eq(InfoLandscapeTable.PTK,ptk))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLandscapeDto>> getByPkIdxAsync(/*partition key*/ String ptk
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
				.where(QueryBuilder.eq(InfoLandscapeTable.PTK,ptk))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoLandscapeDto> getByIdx(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(recordState!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
		}
		else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLandscapeDto>> getByIdxAsync(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(recordState!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
        }
        else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
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
    public List<InfoLandscapeDto> getByPkCk1(/*partition key*/ String ptk
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
				.where(QueryBuilder.eq(InfoLandscapeTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoLandscapeTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLandscapeDto>> getByPkCk1Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
				.where(QueryBuilder.eq(InfoLandscapeTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoLandscapeTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<InfoLandscapeDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoLandscapeTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLandscapeDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoLandscapeTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoLandscapeDto> getByPkCk1Idx(/*partition key*/ String ptk
	                              /*clustering key*/ , String landscape
								  /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
				.where(QueryBuilder.eq(InfoLandscapeTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoLandscapeTable.LANDSCAPE,landscape))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLandscapeDto>> getByPkCk1IdxAsync(/*partition key*/ String ptk
	                            , String landscape
								/*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
				.where(QueryBuilder.eq(InfoLandscapeTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoLandscapeTable.LANDSCAPE,landscape))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoLandscapeDto> getByCk1Idx(/*clustering key*/ String landscape
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoLandscapeTable.LANDSCAPE,landscape))
				;

		if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLandscapeDto>> getByCk1IdxAsync(/*clustering key*/ String landscape
	                           /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoLandscapeTable.LANDSCAPE,landscape))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLandscapeTable.RECORD_STATE,recordState));
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
    public Pair<PagingState,List<InfoLandscapeDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<InfoLandscapeDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<InfoLandscapeDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<InfoLandscapeDto> resultList = new ArrayList<InfoLandscapeDto>();
        for (InfoLandscapeDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<InfoLandscapeDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<InfoLandscapeDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoLandscapeDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<InfoLandscapeDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLandscapeTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoLandscapeDto>>> queryCertainPageAsync(
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
    protected Future<List<InfoLandscapeDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<InfoLandscapeDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<InfoLandscapeDto>>) rs -> {
                    Result<InfoLandscapeDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoLandscapeDto> resultList = new ArrayList<InfoLandscapeDto>();
                    for (InfoLandscapeDto dto : results) {
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
    protected Future<Pair<PagingState,List<InfoLandscapeDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<InfoLandscapeDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<InfoLandscapeDto>>>) rs -> {
                    Result<InfoLandscapeDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoLandscapeDto> resultList = new ArrayList<InfoLandscapeDto>();
                    for (InfoLandscapeDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<InfoLandscapeDto>>(newPagingState,resultList);
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

