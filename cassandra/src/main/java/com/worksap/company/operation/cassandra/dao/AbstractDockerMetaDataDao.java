package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.DockerMetaDataDto;
import com.worksap.company.operation.cassandra.table.DockerMetaDataTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractDockerMetaDataDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<DockerMetaDataDto> mapper;

    public AbstractDockerMetaDataDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(DockerMetaDataDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(DockerMetaDataDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(DockerMetaDataDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public DockerMetaDataDto get(String ptk, String namespace, String repository) {
        return mapper.get(ptk, namespace, repository);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<DockerMetaDataDto> getAsync(String ptk, String namespace, String repository) {
        return mapper.getAsync(ptk, namespace, repository);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String ptk, String namespace, String repository) {
        mapper.delete(ptk, namespace, repository);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String ptk, String namespace, String repository) {
        return mapper.deleteAsync(ptk, namespace, repository);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(DockerMetaDataDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(DockerMetaDataDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<DockerMetaDataDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<DockerMetaDataDto> list) {
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
    public boolean saveLwt(DockerMetaDataDto dto){
        Statement query = QueryBuilder.insertInto(DockerMetaDataTable._NAME)
                .value(DockerMetaDataTable.PTK, dto.getPtk())
                .value(DockerMetaDataTable.NAMESPACE, dto.getNamespace())
                .value(DockerMetaDataTable.REPOSITORY, dto.getRepository())
                .value(DockerMetaDataTable.TAGS, dto.getTags())
                .value(DockerMetaDataTable.TS, dto.getTs())
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
    public Future<Boolean> saveLwtAsync(DockerMetaDataDto dto){
        Statement query = QueryBuilder.insertInto(DockerMetaDataTable._NAME)
                .value(DockerMetaDataTable.PTK, dto.getPtk())
                .value(DockerMetaDataTable.NAMESPACE, dto.getNamespace())
                .value(DockerMetaDataTable.REPOSITORY, dto.getRepository())
                .value(DockerMetaDataTable.TAGS, dto.getTags())
                .value(DockerMetaDataTable.TS, dto.getTs())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<DockerMetaDataDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<DockerMetaDataDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<DockerMetaDataDto> getByPk(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
				.where(QueryBuilder.eq(DockerMetaDataTable.PTK,ptk))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<DockerMetaDataDto>> getByPkAsync(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
				.where(QueryBuilder.eq(DockerMetaDataTable.PTK,ptk))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<DockerMetaDataDto> getByPkCk1(/*partition key*/ String ptk
	                              /*clustering key*/ , String namespace) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
				.where(QueryBuilder.eq(DockerMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(DockerMetaDataTable.NAMESPACE,namespace))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<DockerMetaDataDto>> getByPkCk1Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String namespace) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
				.where(QueryBuilder.eq(DockerMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(DockerMetaDataTable.NAMESPACE,namespace))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<DockerMetaDataDto> getByCk1(/*clustering key*/ String namespace) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(DockerMetaDataTable.NAMESPACE,namespace))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<DockerMetaDataDto>> getByCk1Async(/*clustering key*/ String namespace) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(DockerMetaDataTable.NAMESPACE,namespace))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<DockerMetaDataDto> getByPkCk2(/*partition key*/ String ptk
	                              /*clustering key*/ , String namespace, String repository) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
				.where(QueryBuilder.eq(DockerMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(DockerMetaDataTable.NAMESPACE,namespace))
				.and(QueryBuilder.eq(DockerMetaDataTable.REPOSITORY,repository))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<DockerMetaDataDto>> getByPkCk2Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String namespace, String repository) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
				.where(QueryBuilder.eq(DockerMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(DockerMetaDataTable.NAMESPACE,namespace))
				.and(QueryBuilder.eq(DockerMetaDataTable.REPOSITORY,repository))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<DockerMetaDataDto> getByCk2(/*clustering key*/ String namespace, String repository) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(DockerMetaDataTable.NAMESPACE,namespace))
				.and(QueryBuilder.eq(DockerMetaDataTable.REPOSITORY,repository))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<DockerMetaDataDto>> getByCk2Async(/*clustering key*/ String namespace, String repository) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(DockerMetaDataTable.NAMESPACE,namespace))
				.and(QueryBuilder.eq(DockerMetaDataTable.REPOSITORY,repository))
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
    public Pair<PagingState,List<DockerMetaDataDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<DockerMetaDataDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<DockerMetaDataDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<DockerMetaDataDto> resultList = new ArrayList<DockerMetaDataDto>();
        for (DockerMetaDataDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<DockerMetaDataDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<DockerMetaDataDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<DockerMetaDataDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<DockerMetaDataDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(DockerMetaDataTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<DockerMetaDataDto>>> queryCertainPageAsync(
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
    protected Future<List<DockerMetaDataDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<DockerMetaDataDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<DockerMetaDataDto>>) rs -> {
                    Result<DockerMetaDataDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<DockerMetaDataDto> resultList = new ArrayList<DockerMetaDataDto>();
                    for (DockerMetaDataDto dto : results) {
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
    protected Future<Pair<PagingState,List<DockerMetaDataDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<DockerMetaDataDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<DockerMetaDataDto>>>) rs -> {
                    Result<DockerMetaDataDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<DockerMetaDataDto> resultList = new ArrayList<DockerMetaDataDto>();
                    for (DockerMetaDataDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<DockerMetaDataDto>>(newPagingState,resultList);
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

