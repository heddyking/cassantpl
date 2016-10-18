package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.InfoLicenseDto;
import com.worksap.company.operation.cassandra.table.InfoLicenseTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractInfoLicenseDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<InfoLicenseDto> mapper;

    public AbstractInfoLicenseDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(InfoLicenseDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(InfoLicenseDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(InfoLicenseDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public InfoLicenseDto get(String ptk, UUID licenseId) {
        return mapper.get(ptk, licenseId);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<InfoLicenseDto> getAsync(String ptk, UUID licenseId) {
        return mapper.getAsync(ptk, licenseId);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String ptk, UUID licenseId) {
        mapper.delete(ptk, licenseId);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String ptk, UUID licenseId) {
        return mapper.deleteAsync(ptk, licenseId);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(InfoLicenseDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(InfoLicenseDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<InfoLicenseDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<InfoLicenseDto> list) {
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
    public boolean saveLwt(InfoLicenseDto dto){
        Statement query = QueryBuilder.insertInto(InfoLicenseTable._NAME)
                .value(InfoLicenseTable.PTK, dto.getPtk())
                .value(InfoLicenseTable.LICENSE_ID, dto.getLicenseId())
                .value(InfoLicenseTable.LICENSE_DETAIL, dto.getLicenseDetail())
                .value(InfoLicenseTable.LICENSE_NAME, dto.getLicenseName())
                .value(InfoLicenseTable.RECORD_STATE, dto.getRecordState())
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
    public Future<Boolean> saveLwtAsync(InfoLicenseDto dto){
        Statement query = QueryBuilder.insertInto(InfoLicenseTable._NAME)
                .value(InfoLicenseTable.PTK, dto.getPtk())
                .value(InfoLicenseTable.LICENSE_ID, dto.getLicenseId())
                .value(InfoLicenseTable.LICENSE_DETAIL, dto.getLicenseDetail())
                .value(InfoLicenseTable.LICENSE_NAME, dto.getLicenseName())
                .value(InfoLicenseTable.RECORD_STATE, dto.getRecordState())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<InfoLicenseDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<InfoLicenseDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<InfoLicenseDto> getByPk(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
				.where(QueryBuilder.eq(InfoLicenseTable.PTK,ptk))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLicenseDto>> getByPkAsync(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
				.where(QueryBuilder.eq(InfoLicenseTable.PTK,ptk))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoLicenseDto> getByPkIdx(/*partition index*/ String ptk
	                              /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
				.where(QueryBuilder.eq(InfoLicenseTable.PTK,ptk))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLicenseDto>> getByPkIdxAsync(/*partition key*/ String ptk
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
				.where(QueryBuilder.eq(InfoLicenseTable.PTK,ptk))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoLicenseDto> getByIdx(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(recordState!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
		}
		else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLicenseDto>> getByIdxAsync(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(recordState!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
        }
        else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
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
    public List<InfoLicenseDto> getByPkCk1(/*partition key*/ String ptk
	                              /*clustering key*/ , UUID licenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
				.where(QueryBuilder.eq(InfoLicenseTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoLicenseTable.LICENSE_ID,licenseId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLicenseDto>> getByPkCk1Async(/*partition key*/ String ptk
	                            /*clustering key*/ , UUID licenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
				.where(QueryBuilder.eq(InfoLicenseTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoLicenseTable.LICENSE_ID,licenseId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<InfoLicenseDto> getByCk1(/*clustering key*/ UUID licenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoLicenseTable.LICENSE_ID,licenseId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLicenseDto>> getByCk1Async(/*clustering key*/ UUID licenseId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoLicenseTable.LICENSE_ID,licenseId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoLicenseDto> getByPkCk1Idx(/*partition key*/ String ptk
	                              /*clustering key*/ , UUID licenseId
								  /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
				.where(QueryBuilder.eq(InfoLicenseTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoLicenseTable.LICENSE_ID,licenseId))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLicenseDto>> getByPkCk1IdxAsync(/*partition key*/ String ptk
	                            , UUID licenseId
								/*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
				.where(QueryBuilder.eq(InfoLicenseTable.PTK,ptk))
				.and(QueryBuilder.eq(InfoLicenseTable.LICENSE_ID,licenseId))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoLicenseDto> getByCk1Idx(/*clustering key*/ UUID licenseId
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoLicenseTable.LICENSE_ID,licenseId))
				;

		if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoLicenseDto>> getByCk1IdxAsync(/*clustering key*/ UUID licenseId
	                           /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoLicenseTable.LICENSE_ID,licenseId))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoLicenseTable.RECORD_STATE,recordState));
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
    public Pair<PagingState,List<InfoLicenseDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<InfoLicenseDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<InfoLicenseDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<InfoLicenseDto> resultList = new ArrayList<InfoLicenseDto>();
        for (InfoLicenseDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<InfoLicenseDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<InfoLicenseDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoLicenseDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<InfoLicenseDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoLicenseTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoLicenseDto>>> queryCertainPageAsync(
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
    protected Future<List<InfoLicenseDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<InfoLicenseDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<InfoLicenseDto>>) rs -> {
                    Result<InfoLicenseDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoLicenseDto> resultList = new ArrayList<InfoLicenseDto>();
                    for (InfoLicenseDto dto : results) {
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
    protected Future<Pair<PagingState,List<InfoLicenseDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<InfoLicenseDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<InfoLicenseDto>>>) rs -> {
                    Result<InfoLicenseDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoLicenseDto> resultList = new ArrayList<InfoLicenseDto>();
                    for (InfoLicenseDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<InfoLicenseDto>>(newPagingState,resultList);
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

