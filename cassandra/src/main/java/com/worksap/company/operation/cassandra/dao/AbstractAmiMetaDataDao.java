package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.AmiMetaDataDto;
import com.worksap.company.operation.cassandra.table.AmiMetaDataTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractAmiMetaDataDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<AmiMetaDataDto> mapper;

    public AbstractAmiMetaDataDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(AmiMetaDataDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(AmiMetaDataDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(AmiMetaDataDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public AmiMetaDataDto get(String ptk, String imageId) {
        return mapper.get(ptk, imageId);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<AmiMetaDataDto> getAsync(String ptk, String imageId) {
        return mapper.getAsync(ptk, imageId);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String ptk, String imageId) {
        mapper.delete(ptk, imageId);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String ptk, String imageId) {
        return mapper.deleteAsync(ptk, imageId);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(AmiMetaDataDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(AmiMetaDataDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<AmiMetaDataDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<AmiMetaDataDto> list) {
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
    public boolean saveLwt(AmiMetaDataDto dto){
        Statement query = QueryBuilder.insertInto(AmiMetaDataTable._NAME)
                .value(AmiMetaDataTable.PTK, dto.getPtk())
                .value(AmiMetaDataTable.IMAGE_ID, dto.getImageId())
                .value(AmiMetaDataTable.ARCHITECTURE, dto.getArchitecture())
                .value(AmiMetaDataTable.DESCRIPTION, dto.getDescription())
                .value(AmiMetaDataTable.HYPERVISOR, dto.getHypervisor())
                .value(AmiMetaDataTable.IMAGE_LOCATION, dto.getImageLocation())
                .value(AmiMetaDataTable.IMAGE_TYPE, dto.getImageType())
                .value(AmiMetaDataTable.NAME, dto.getName())
                .value(AmiMetaDataTable.OWNER_ID, dto.getOwnerId())
                .value(AmiMetaDataTable.STATE, dto.getState())
                .value(AmiMetaDataTable.TS, dto.getTs())
                .value(AmiMetaDataTable.VIRTUALIZATION_TYPE, dto.getVirtualizationType())
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
    public Future<Boolean> saveLwtAsync(AmiMetaDataDto dto){
        Statement query = QueryBuilder.insertInto(AmiMetaDataTable._NAME)
                .value(AmiMetaDataTable.PTK, dto.getPtk())
                .value(AmiMetaDataTable.IMAGE_ID, dto.getImageId())
                .value(AmiMetaDataTable.ARCHITECTURE, dto.getArchitecture())
                .value(AmiMetaDataTable.DESCRIPTION, dto.getDescription())
                .value(AmiMetaDataTable.HYPERVISOR, dto.getHypervisor())
                .value(AmiMetaDataTable.IMAGE_LOCATION, dto.getImageLocation())
                .value(AmiMetaDataTable.IMAGE_TYPE, dto.getImageType())
                .value(AmiMetaDataTable.NAME, dto.getName())
                .value(AmiMetaDataTable.OWNER_ID, dto.getOwnerId())
                .value(AmiMetaDataTable.STATE, dto.getState())
                .value(AmiMetaDataTable.TS, dto.getTs())
                .value(AmiMetaDataTable.VIRTUALIZATION_TYPE, dto.getVirtualizationType())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<AmiMetaDataDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<AmiMetaDataDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<AmiMetaDataDto> getByPk(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME)
				.where(QueryBuilder.eq(AmiMetaDataTable.PTK,ptk))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<AmiMetaDataDto>> getByPkAsync(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME)
				.where(QueryBuilder.eq(AmiMetaDataTable.PTK,ptk))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AmiMetaDataDto> getByPkCk1(/*partition key*/ String ptk
	                              /*clustering key*/ , String imageId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME)
				.where(QueryBuilder.eq(AmiMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(AmiMetaDataTable.IMAGE_ID,imageId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AmiMetaDataDto>> getByPkCk1Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String imageId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME)
				.where(QueryBuilder.eq(AmiMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(AmiMetaDataTable.IMAGE_ID,imageId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AmiMetaDataDto> getByCk1(/*clustering key*/ String imageId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AmiMetaDataTable.IMAGE_ID,imageId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AmiMetaDataDto>> getByCk1Async(/*clustering key*/ String imageId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AmiMetaDataTable.IMAGE_ID,imageId))
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
    public Pair<PagingState,List<AmiMetaDataDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<AmiMetaDataDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<AmiMetaDataDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<AmiMetaDataDto> resultList = new ArrayList<AmiMetaDataDto>();
        for (AmiMetaDataDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<AmiMetaDataDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<AmiMetaDataDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<AmiMetaDataDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<AmiMetaDataDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AmiMetaDataTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<AmiMetaDataDto>>> queryCertainPageAsync(
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
    protected Future<List<AmiMetaDataDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<AmiMetaDataDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<AmiMetaDataDto>>) rs -> {
                    Result<AmiMetaDataDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AmiMetaDataDto> resultList = new ArrayList<AmiMetaDataDto>();
                    for (AmiMetaDataDto dto : results) {
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
    protected Future<Pair<PagingState,List<AmiMetaDataDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<AmiMetaDataDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<AmiMetaDataDto>>>) rs -> {
                    Result<AmiMetaDataDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AmiMetaDataDto> resultList = new ArrayList<AmiMetaDataDto>();
                    for (AmiMetaDataDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<AmiMetaDataDto>>(newPagingState,resultList);
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

