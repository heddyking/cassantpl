package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.JarMetaDataDto;
import com.worksap.company.operation.cassandra.table.JarMetaDataTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractJarMetaDataDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<JarMetaDataDto> mapper;

    public AbstractJarMetaDataDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(JarMetaDataDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(JarMetaDataDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(JarMetaDataDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public JarMetaDataDto get(String ptk, String groupId, String artifactId, String version) {
        return mapper.get(ptk, groupId, artifactId, version);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<JarMetaDataDto> getAsync(String ptk, String groupId, String artifactId, String version) {
        return mapper.getAsync(ptk, groupId, artifactId, version);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String ptk, String groupId, String artifactId, String version) {
        mapper.delete(ptk, groupId, artifactId, version);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String ptk, String groupId, String artifactId, String version) {
        return mapper.deleteAsync(ptk, groupId, artifactId, version);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(JarMetaDataDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(JarMetaDataDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<JarMetaDataDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<JarMetaDataDto> list) {
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
    public boolean saveLwt(JarMetaDataDto dto){
        Statement query = QueryBuilder.insertInto(JarMetaDataTable._NAME)
                .value(JarMetaDataTable.PTK, dto.getPtk())
                .value(JarMetaDataTable.GROUP_ID, dto.getGroupId())
                .value(JarMetaDataTable.ARTIFACT_ID, dto.getArtifactId())
                .value(JarMetaDataTable.VERSION, dto.getVersion())
                .value(JarMetaDataTable.JAR, dto.getJar())
                .value(JarMetaDataTable.NEXUS, dto.getNexus())
                .value(JarMetaDataTable.ORG, dto.getOrg())
                .value(JarMetaDataTable.TS, dto.getTs())
                .value(JarMetaDataTable.URL, dto.getUrl())
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
    public Future<Boolean> saveLwtAsync(JarMetaDataDto dto){
        Statement query = QueryBuilder.insertInto(JarMetaDataTable._NAME)
                .value(JarMetaDataTable.PTK, dto.getPtk())
                .value(JarMetaDataTable.GROUP_ID, dto.getGroupId())
                .value(JarMetaDataTable.ARTIFACT_ID, dto.getArtifactId())
                .value(JarMetaDataTable.VERSION, dto.getVersion())
                .value(JarMetaDataTable.JAR, dto.getJar())
                .value(JarMetaDataTable.NEXUS, dto.getNexus())
                .value(JarMetaDataTable.ORG, dto.getOrg())
                .value(JarMetaDataTable.TS, dto.getTs())
                .value(JarMetaDataTable.URL, dto.getUrl())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<JarMetaDataDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<JarMetaDataDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<JarMetaDataDto> getByPk(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
				.where(QueryBuilder.eq(JarMetaDataTable.PTK,ptk))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<JarMetaDataDto>> getByPkAsync(/*partition key*/ String ptk) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
				.where(QueryBuilder.eq(JarMetaDataTable.PTK,ptk))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<JarMetaDataDto> getByPkCk1(/*partition key*/ String ptk
	                              /*clustering key*/ , String groupId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
				.where(QueryBuilder.eq(JarMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<JarMetaDataDto>> getByPkCk1Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String groupId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
				.where(QueryBuilder.eq(JarMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<JarMetaDataDto> getByCk1(/*clustering key*/ String groupId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<JarMetaDataDto>> getByCk1Async(/*clustering key*/ String groupId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<JarMetaDataDto> getByPkCk2(/*partition key*/ String ptk
	                              /*clustering key*/ , String groupId, String artifactId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
				.where(QueryBuilder.eq(JarMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				.and(QueryBuilder.eq(JarMetaDataTable.ARTIFACT_ID,artifactId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<JarMetaDataDto>> getByPkCk2Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String groupId, String artifactId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
				.where(QueryBuilder.eq(JarMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				.and(QueryBuilder.eq(JarMetaDataTable.ARTIFACT_ID,artifactId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<JarMetaDataDto> getByCk2(/*clustering key*/ String groupId, String artifactId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				.and(QueryBuilder.eq(JarMetaDataTable.ARTIFACT_ID,artifactId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<JarMetaDataDto>> getByCk2Async(/*clustering key*/ String groupId, String artifactId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				.and(QueryBuilder.eq(JarMetaDataTable.ARTIFACT_ID,artifactId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<JarMetaDataDto> getByPkCk3(/*partition key*/ String ptk
	                              /*clustering key*/ , String groupId, String artifactId, String version) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
				.where(QueryBuilder.eq(JarMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				.and(QueryBuilder.eq(JarMetaDataTable.ARTIFACT_ID,artifactId))
				.and(QueryBuilder.eq(JarMetaDataTable.VERSION,version))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<JarMetaDataDto>> getByPkCk3Async(/*partition key*/ String ptk
	                            /*clustering key*/ , String groupId, String artifactId, String version) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
				.where(QueryBuilder.eq(JarMetaDataTable.PTK,ptk))
				.and(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				.and(QueryBuilder.eq(JarMetaDataTable.ARTIFACT_ID,artifactId))
				.and(QueryBuilder.eq(JarMetaDataTable.VERSION,version))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<JarMetaDataDto> getByCk3(/*clustering key*/ String groupId, String artifactId, String version) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				.and(QueryBuilder.eq(JarMetaDataTable.ARTIFACT_ID,artifactId))
				.and(QueryBuilder.eq(JarMetaDataTable.VERSION,version))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<JarMetaDataDto>> getByCk3Async(/*clustering key*/ String groupId, String artifactId, String version) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(JarMetaDataTable.GROUP_ID,groupId))
				.and(QueryBuilder.eq(JarMetaDataTable.ARTIFACT_ID,artifactId))
				.and(QueryBuilder.eq(JarMetaDataTable.VERSION,version))
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
    public Pair<PagingState,List<JarMetaDataDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<JarMetaDataDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<JarMetaDataDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<JarMetaDataDto> resultList = new ArrayList<JarMetaDataDto>();
        for (JarMetaDataDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<JarMetaDataDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<JarMetaDataDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<JarMetaDataDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<JarMetaDataDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(JarMetaDataTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<JarMetaDataDto>>> queryCertainPageAsync(
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
    protected Future<List<JarMetaDataDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<JarMetaDataDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<JarMetaDataDto>>) rs -> {
                    Result<JarMetaDataDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<JarMetaDataDto> resultList = new ArrayList<JarMetaDataDto>();
                    for (JarMetaDataDto dto : results) {
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
    protected Future<Pair<PagingState,List<JarMetaDataDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<JarMetaDataDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<JarMetaDataDto>>>) rs -> {
                    Result<JarMetaDataDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<JarMetaDataDto> resultList = new ArrayList<JarMetaDataDto>();
                    for (JarMetaDataDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<JarMetaDataDto>>(newPagingState,resultList);
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

