package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.AwsElasticipDto;
import com.worksap.company.operation.cassandra.table.AwsElasticipTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractAwsElasticipDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<AwsElasticipDto> mapper;

    public AbstractAwsElasticipDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(AwsElasticipDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(AwsElasticipDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(AwsElasticipDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public AwsElasticipDto get(String awsAccessKey, String region, String elasticip) {
        return mapper.get(awsAccessKey, region, elasticip);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<AwsElasticipDto> getAsync(String awsAccessKey, String region, String elasticip) {
        return mapper.getAsync(awsAccessKey, region, elasticip);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String awsAccessKey, String region, String elasticip) {
        mapper.delete(awsAccessKey, region, elasticip);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String awsAccessKey, String region, String elasticip) {
        return mapper.deleteAsync(awsAccessKey, region, elasticip);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(AwsElasticipDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(AwsElasticipDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<AwsElasticipDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<AwsElasticipDto> list) {
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
    public boolean saveLwt(AwsElasticipDto dto){
        Statement query = QueryBuilder.insertInto(AwsElasticipTable._NAME)
                .value(AwsElasticipTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(AwsElasticipTable.REGION, dto.getRegion())
                .value(AwsElasticipTable.ELASTICIP, dto.getElasticip())
                .value(AwsElasticipTable.ENI_ID, dto.getEniId())
                .value(AwsElasticipTable.PRIVATE_ID_ADDR, dto.getPrivateIdAddr())
                .value(AwsElasticipTable.PUBLIC_DNS, dto.getPublicDns())
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
    public Future<Boolean> saveLwtAsync(AwsElasticipDto dto){
        Statement query = QueryBuilder.insertInto(AwsElasticipTable._NAME)
                .value(AwsElasticipTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(AwsElasticipTable.REGION, dto.getRegion())
                .value(AwsElasticipTable.ELASTICIP, dto.getElasticip())
                .value(AwsElasticipTable.ENI_ID, dto.getEniId())
                .value(AwsElasticipTable.PRIVATE_ID_ADDR, dto.getPrivateIdAddr())
                .value(AwsElasticipTable.PUBLIC_DNS, dto.getPublicDns())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<AwsElasticipDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<AwsElasticipDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<AwsElasticipDto> getByPk(/*partition key*/ String awsAccessKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
				.where(QueryBuilder.eq(AwsElasticipTable.AWS_ACCESS_KEY,awsAccessKey))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsElasticipDto>> getByPkAsync(/*partition key*/ String awsAccessKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
				.where(QueryBuilder.eq(AwsElasticipTable.AWS_ACCESS_KEY,awsAccessKey))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsElasticipDto> getByPkCk1(/*partition key*/ String awsAccessKey
	                              /*clustering key*/ , String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
				.where(QueryBuilder.eq(AwsElasticipTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsElasticipTable.REGION,region))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsElasticipDto>> getByPkCk1Async(/*partition key*/ String awsAccessKey
	                            /*clustering key*/ , String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
				.where(QueryBuilder.eq(AwsElasticipTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsElasticipTable.REGION,region))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsElasticipDto> getByCk1(/*clustering key*/ String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsElasticipTable.REGION,region))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsElasticipDto>> getByCk1Async(/*clustering key*/ String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsElasticipTable.REGION,region))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsElasticipDto> getByPkCk2(/*partition key*/ String awsAccessKey
	                              /*clustering key*/ , String region, String elasticip) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
				.where(QueryBuilder.eq(AwsElasticipTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsElasticipTable.REGION,region))
				.and(QueryBuilder.eq(AwsElasticipTable.ELASTICIP,elasticip))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsElasticipDto>> getByPkCk2Async(/*partition key*/ String awsAccessKey
	                            /*clustering key*/ , String region, String elasticip) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
				.where(QueryBuilder.eq(AwsElasticipTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsElasticipTable.REGION,region))
				.and(QueryBuilder.eq(AwsElasticipTable.ELASTICIP,elasticip))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsElasticipDto> getByCk2(/*clustering key*/ String region, String elasticip) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsElasticipTable.REGION,region))
				.and(QueryBuilder.eq(AwsElasticipTable.ELASTICIP,elasticip))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsElasticipDto>> getByCk2Async(/*clustering key*/ String region, String elasticip) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsElasticipTable.REGION,region))
				.and(QueryBuilder.eq(AwsElasticipTable.ELASTICIP,elasticip))
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
    public Pair<PagingState,List<AwsElasticipDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<AwsElasticipDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<AwsElasticipDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<AwsElasticipDto> resultList = new ArrayList<AwsElasticipDto>();
        for (AwsElasticipDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<AwsElasticipDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<AwsElasticipDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<AwsElasticipDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<AwsElasticipDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsElasticipTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<AwsElasticipDto>>> queryCertainPageAsync(
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
    protected Future<List<AwsElasticipDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<AwsElasticipDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<AwsElasticipDto>>) rs -> {
                    Result<AwsElasticipDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AwsElasticipDto> resultList = new ArrayList<AwsElasticipDto>();
                    for (AwsElasticipDto dto : results) {
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
    protected Future<Pair<PagingState,List<AwsElasticipDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<AwsElasticipDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<AwsElasticipDto>>>) rs -> {
                    Result<AwsElasticipDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AwsElasticipDto> resultList = new ArrayList<AwsElasticipDto>();
                    for (AwsElasticipDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<AwsElasticipDto>>(newPagingState,resultList);
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

