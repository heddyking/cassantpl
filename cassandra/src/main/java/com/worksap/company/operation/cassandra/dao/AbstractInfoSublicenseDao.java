package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.InfoSublicenseDto;
import com.worksap.company.operation.cassandra.table.InfoSublicenseTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractInfoSublicenseDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<InfoSublicenseDto> mapper;

    public AbstractInfoSublicenseDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(InfoSublicenseDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(InfoSublicenseDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(InfoSublicenseDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public InfoSublicenseDto get(String ptk, UUID sublicenseId) {
        return mapper.get(ptk, sublicenseId);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<InfoSublicenseDto> getAsync(String ptk, UUID sublicenseId) {
        return mapper.getAsync(ptk, sublicenseId);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String ptk, UUID sublicenseId) {
        mapper.delete(ptk, sublicenseId);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String ptk, UUID sublicenseId) {
        return mapper.deleteAsync(ptk, sublicenseId);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(InfoSublicenseDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(InfoSublicenseDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<InfoSublicenseDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<InfoSublicenseDto> list) {
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
    public boolean saveLwt(InfoSublicenseDto dto){
        Statement query = QueryBuilder.insertInto(InfoSublicenseTable._NAME)
                .value(InfoSublicenseTable.PTK, dto.getPtk())
                .value(InfoSublicenseTable.SUBLICENSE_ID, dto.getSublicenseId())
                .value(InfoSublicenseTable.LICENSE_ID, dto.getLicenseId())
                .value(InfoSublicenseTable.RECORD_STATE, dto.getRecordState())
                .value(InfoSublicenseTable.SUBLICENSE_DETAIL, dto.getSublicenseDetail())
                .value(InfoSublicenseTable.SUBLICENSE_NAME, dto.getSublicenseName())
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
    public Future<Boolean> saveLwtAsync(InfoSublicenseDto dto){
        Statement query = QueryBuilder.insertInto(InfoSublicenseTable._NAME)
                .value(InfoSublicenseTable.PTK, dto.getPtk())
                .value(InfoSublicenseTable.SUBLICENSE_ID, dto.getSublicenseId())
                .value(InfoSublicenseTable.LICENSE_ID, dto.getLicenseId())
                .value(InfoSublicenseTable.RECORD_STATE, dto.getRecordState())
                .value(InfoSublicenseTable.SUBLICENSE_DETAIL, dto.getSublicenseDetail())
                .value(InfoSublicenseTable.SUBLICENSE_NAME, dto.getSublicenseName())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<InfoSublicenseDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<InfoSublicenseDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<InfoSublicenseDto> getByPk(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoSublicenseTable.PTK,ptk))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoSublicenseDto>> getByPkAsync(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoSublicenseTable.PTK,ptk))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoSublicenseDto> getByPkIdx(/*partition index*/ String ptk
	                              /*secondary index*/ , UUID licenseId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoSublicenseTable.PTK,ptk))
				;

        if(licenseId!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoSublicenseDto>> getByPkIdxAsync(/*partition key*/ String ptk
	                            /*secondary index*/ , UUID licenseId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoSublicenseTable.PTK,ptk))
				;

        if(licenseId!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoSublicenseDto> getByIdx(/*secondary index*/ UUID licenseId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(licenseId!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
		}
		else if(licenseId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
		}
		if(recordState!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
		}
		else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoSublicenseDto>> getByIdxAsync(/*secondary index*/ UUID licenseId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(licenseId!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
        }
        else if(licenseId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
        }
        if(recordState!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
        }
        else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
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
    public List<InfoSublicenseDto> getByPkCk1(/*partition key*/ String ptk
	                              /*clustering key*/ , UUID sublicenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoSublicenseTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoSublicenseDto>> getByPkCk1Async(/*partition key*/ String ptk
	                            /*clustering key*/ , UUID sublicenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoSublicenseTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<InfoSublicenseDto> getByCk1(/*clustering key*/ UUID sublicenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoSublicenseDto>> getByCk1Async(/*clustering key*/ UUID sublicenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoSublicenseDto> getByPkCk1Idx(/*partition key*/ String ptk
	                              /*clustering key*/ , UUID sublicenseId
								  /*secondary index*/ , UUID licenseId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoSublicenseTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;

        if(licenseId!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoSublicenseDto>> getByPkCk1IdxAsync(/*partition key*/ String ptk
	                            , UUID sublicenseId
								/*secondary index*/ , UUID licenseId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
				.where(QueryBuilder.eq(InfoSublicenseTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;

        if(licenseId!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoSublicenseDto> getByCk1Idx(/*clustering key*/ UUID sublicenseId
	                            /*secondary index*/ , UUID licenseId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;

		if(licenseId!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
		if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoSublicenseDto>> getByCk1IdxAsync(/*clustering key*/ UUID sublicenseId
	                           /*secondary index*/ , UUID licenseId, Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoSublicenseTable.SUBLICENSE_ID,sublicenseId))
				;

        if(licenseId!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.LICENSE_ID,licenseId));
        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoSublicenseTable.RECORD_STATE,recordState));
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
    public Pair<PagingState,List<InfoSublicenseDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<InfoSublicenseDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<InfoSublicenseDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<InfoSublicenseDto> resultList = new ArrayList<InfoSublicenseDto>();
        for (InfoSublicenseDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<InfoSublicenseDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<InfoSublicenseDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoSublicenseDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<InfoSublicenseDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoSublicenseTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoSublicenseDto>>> queryCertainPageAsync(
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
    protected Future<List<InfoSublicenseDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<InfoSublicenseDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<InfoSublicenseDto>>) rs -> {
                    Result<InfoSublicenseDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoSublicenseDto> resultList = new ArrayList<InfoSublicenseDto>();
                    for (InfoSublicenseDto dto : results) {
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
    protected Future<Pair<PagingState,List<InfoSublicenseDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<InfoSublicenseDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<InfoSublicenseDto>>>) rs -> {
                    Result<InfoSublicenseDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoSublicenseDto> resultList = new ArrayList<InfoSublicenseDto>();
                    for (InfoSublicenseDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<InfoSublicenseDto>>(newPagingState,resultList);
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

