package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.InfoPcodeDto;
import com.worksap.company.operation.cassandra.table.InfoPcodeTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractInfoPcodeDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<InfoPcodeDto> mapper;

    public AbstractInfoPcodeDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(InfoPcodeDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(InfoPcodeDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(InfoPcodeDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public InfoPcodeDto get(String pcode1, String pcode2, String pcode3) {
        return mapper.get(pcode1, pcode2, pcode3);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<InfoPcodeDto> getAsync(String pcode1, String pcode2, String pcode3) {
        return mapper.getAsync(pcode1, pcode2, pcode3);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String pcode1, String pcode2, String pcode3) {
        mapper.delete(pcode1, pcode2, pcode3);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String pcode1, String pcode2, String pcode3) {
        return mapper.deleteAsync(pcode1, pcode2, pcode3);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(InfoPcodeDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(InfoPcodeDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<InfoPcodeDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<InfoPcodeDto> list) {
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
    public boolean saveLwt(InfoPcodeDto dto){
        Statement query = QueryBuilder.insertInto(InfoPcodeTable._NAME)
                .value(InfoPcodeTable.PCODE1, dto.getPcode1())
                .value(InfoPcodeTable.PCODE2, dto.getPcode2())
                .value(InfoPcodeTable.PCODE3, dto.getPcode3())
                .value(InfoPcodeTable.PGROUPS, dto.getPgroups())
                .value(InfoPcodeTable.RECORD_STATE, dto.getRecordState())
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
    public Future<Boolean> saveLwtAsync(InfoPcodeDto dto){
        Statement query = QueryBuilder.insertInto(InfoPcodeTable._NAME)
                .value(InfoPcodeTable.PCODE1, dto.getPcode1())
                .value(InfoPcodeTable.PCODE2, dto.getPcode2())
                .value(InfoPcodeTable.PCODE3, dto.getPcode3())
                .value(InfoPcodeTable.PGROUPS, dto.getPgroups())
                .value(InfoPcodeTable.RECORD_STATE, dto.getRecordState())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<InfoPcodeDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<InfoPcodeDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByPk(/*partition key*/ String pcode1) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByPkAsync(/*partition key*/ String pcode1) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByPkIdx(/*partition index*/ String pcode1
	                              /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByPkIdxAsync(/*partition key*/ String pcode1
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByIdx(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(recordState!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
		}
		else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByIdxAsync(/*secondary index*/ Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(recordState!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
        }
        else if(recordState!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
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
    public List<InfoPcodeDto> getByPkCk1(/*partition key*/ String pcode1
	                              /*clustering key*/ , String pcode2) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByPkCk1Async(/*partition key*/ String pcode1
	                            /*clustering key*/ , String pcode2) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByCk1(/*clustering key*/ String pcode2) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByCk1Async(/*clustering key*/ String pcode2) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByPkCk1Idx(/*partition key*/ String pcode1
	                              /*clustering key*/ , String pcode2
								  /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByPkCk1IdxAsync(/*partition key*/ String pcode1
	                            , String pcode2
								/*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByCk1Idx(/*clustering key*/ String pcode2
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				;

		if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByCk1IdxAsync(/*clustering key*/ String pcode2
	                           /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByPkCk2(/*partition key*/ String pcode1
	                              /*clustering key*/ , String pcode2, String pcode3) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE3,pcode3))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByPkCk2Async(/*partition key*/ String pcode1
	                            /*clustering key*/ , String pcode2, String pcode3) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE3,pcode3))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByCk2(/*clustering key*/ String pcode2, String pcode3) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE3,pcode3))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByCk2Async(/*clustering key*/ String pcode2, String pcode3) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE3,pcode3))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByPkCk2Idx(/*partition key*/ String pcode1
	                              /*clustering key*/ , String pcode2, String pcode3
								  /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE3,pcode3))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByPkCk2IdxAsync(/*partition key*/ String pcode1
	                            , String pcode2, String pcode3
								/*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE1,pcode1))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE3,pcode3))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<InfoPcodeDto> getByCk2Idx(/*clustering key*/ String pcode2, String pcode3
	                            /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE3,pcode3))
				;

		if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<InfoPcodeDto>> getByCk2IdxAsync(/*clustering key*/ String pcode2, String pcode3
	                           /*secondary index*/ , Boolean recordState) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(InfoPcodeTable.PCODE2,pcode2))
				.and(QueryBuilder.eq(InfoPcodeTable.PCODE3,pcode3))
				;

        if(recordState!=null) query=((Select.Where)query).and(QueryBuilder.eq(InfoPcodeTable.RECORD_STATE,recordState));
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
    public Pair<PagingState,List<InfoPcodeDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<InfoPcodeDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<InfoPcodeDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<InfoPcodeDto> resultList = new ArrayList<InfoPcodeDto>();
        for (InfoPcodeDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<InfoPcodeDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<InfoPcodeDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoPcodeDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<InfoPcodeDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(InfoPcodeTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<InfoPcodeDto>>> queryCertainPageAsync(
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
    protected Future<List<InfoPcodeDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<InfoPcodeDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<InfoPcodeDto>>) rs -> {
                    Result<InfoPcodeDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoPcodeDto> resultList = new ArrayList<InfoPcodeDto>();
                    for (InfoPcodeDto dto : results) {
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
    protected Future<Pair<PagingState,List<InfoPcodeDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<InfoPcodeDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<InfoPcodeDto>>>) rs -> {
                    Result<InfoPcodeDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<InfoPcodeDto> resultList = new ArrayList<InfoPcodeDto>();
                    for (InfoPcodeDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<InfoPcodeDto>>(newPagingState,resultList);
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

