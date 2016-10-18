package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.AwsInstancetypeDto;
import com.worksap.company.operation.cassandra.table.AwsInstancetypeTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractAwsInstancetypeDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<AwsInstancetypeDto> mapper;

    public AbstractAwsInstancetypeDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(AwsInstancetypeDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(AwsInstancetypeDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(AwsInstancetypeDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public AwsInstancetypeDto get(String awsAccessKey, String region, String family, String instancetype, String osPlatform) {
        return mapper.get(awsAccessKey, region, family, instancetype, osPlatform);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<AwsInstancetypeDto> getAsync(String awsAccessKey, String region, String family, String instancetype, String osPlatform) {
        return mapper.getAsync(awsAccessKey, region, family, instancetype, osPlatform);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String awsAccessKey, String region, String family, String instancetype, String osPlatform) {
        mapper.delete(awsAccessKey, region, family, instancetype, osPlatform);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String awsAccessKey, String region, String family, String instancetype, String osPlatform) {
        return mapper.deleteAsync(awsAccessKey, region, family, instancetype, osPlatform);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(AwsInstancetypeDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(AwsInstancetypeDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<AwsInstancetypeDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<AwsInstancetypeDto> list) {
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
    public boolean saveLwt(AwsInstancetypeDto dto){
        Statement query = QueryBuilder.insertInto(AwsInstancetypeTable._NAME)
                .value(AwsInstancetypeTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(AwsInstancetypeTable.REGION, dto.getRegion())
                .value(AwsInstancetypeTable.FAMILY, dto.getFamily())
                .value(AwsInstancetypeTable.INSTANCETYPE, dto.getInstancetype())
                .value(AwsInstancetypeTable.OS_PLATFORM, dto.getOsPlatform())
                .value(AwsInstancetypeTable.EBS_OPTIMIZED, dto.getEbsOptimized())
                .value(AwsInstancetypeTable.INSTANCE_STORAGE, dto.getInstanceStorage())
                .value(AwsInstancetypeTable.MEMORY, dto.getMemory())
                .value(AwsInstancetypeTable.NETWORK, dto.getNetwork())
                .value(AwsInstancetypeTable.PLATFORM, dto.getPlatform())
                .value(AwsInstancetypeTable.PRICE_ON_DEMAND, dto.getPriceOnDemand())
                .value(AwsInstancetypeTable.VCPUS, dto.getVcpus())
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
    public Future<Boolean> saveLwtAsync(AwsInstancetypeDto dto){
        Statement query = QueryBuilder.insertInto(AwsInstancetypeTable._NAME)
                .value(AwsInstancetypeTable.AWS_ACCESS_KEY, dto.getAwsAccessKey())
                .value(AwsInstancetypeTable.REGION, dto.getRegion())
                .value(AwsInstancetypeTable.FAMILY, dto.getFamily())
                .value(AwsInstancetypeTable.INSTANCETYPE, dto.getInstancetype())
                .value(AwsInstancetypeTable.OS_PLATFORM, dto.getOsPlatform())
                .value(AwsInstancetypeTable.EBS_OPTIMIZED, dto.getEbsOptimized())
                .value(AwsInstancetypeTable.INSTANCE_STORAGE, dto.getInstanceStorage())
                .value(AwsInstancetypeTable.MEMORY, dto.getMemory())
                .value(AwsInstancetypeTable.NETWORK, dto.getNetwork())
                .value(AwsInstancetypeTable.PLATFORM, dto.getPlatform())
                .value(AwsInstancetypeTable.PRICE_ON_DEMAND, dto.getPriceOnDemand())
                .value(AwsInstancetypeTable.VCPUS, dto.getVcpus())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<AwsInstancetypeDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<AwsInstancetypeDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<AwsInstancetypeDto> getByPk(/*partition key*/ String awsAccessKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsInstancetypeDto>> getByPkAsync(/*partition key*/ String awsAccessKey) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsInstancetypeDto> getByPkCk1(/*partition key*/ String awsAccessKey
	                              /*clustering key*/ , String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsInstancetypeDto>> getByPkCk1Async(/*partition key*/ String awsAccessKey
	                            /*clustering key*/ , String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsInstancetypeDto> getByCk1(/*clustering key*/ String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsInstancetypeDto>> getByCk1Async(/*clustering key*/ String region) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsInstancetypeDto> getByPkCk2(/*partition key*/ String awsAccessKey
	                              /*clustering key*/ , String region, String family) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsInstancetypeDto>> getByPkCk2Async(/*partition key*/ String awsAccessKey
	                            /*clustering key*/ , String region, String family) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsInstancetypeDto> getByCk2(/*clustering key*/ String region, String family) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsInstancetypeDto>> getByCk2Async(/*clustering key*/ String region, String family) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsInstancetypeDto> getByPkCk3(/*partition key*/ String awsAccessKey
	                              /*clustering key*/ , String region, String family, String instancetype) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				.and(QueryBuilder.eq(AwsInstancetypeTable.INSTANCETYPE,instancetype))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsInstancetypeDto>> getByPkCk3Async(/*partition key*/ String awsAccessKey
	                            /*clustering key*/ , String region, String family, String instancetype) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				.and(QueryBuilder.eq(AwsInstancetypeTable.INSTANCETYPE,instancetype))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsInstancetypeDto> getByCk3(/*clustering key*/ String region, String family, String instancetype) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				.and(QueryBuilder.eq(AwsInstancetypeTable.INSTANCETYPE,instancetype))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsInstancetypeDto>> getByCk3Async(/*clustering key*/ String region, String family, String instancetype) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				.and(QueryBuilder.eq(AwsInstancetypeTable.INSTANCETYPE,instancetype))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsInstancetypeDto> getByPkCk4(/*partition key*/ String awsAccessKey
	                              /*clustering key*/ , String region, String family, String instancetype, String osPlatform) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				.and(QueryBuilder.eq(AwsInstancetypeTable.INSTANCETYPE,instancetype))
				.and(QueryBuilder.eq(AwsInstancetypeTable.OS_PLATFORM,osPlatform))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsInstancetypeDto>> getByPkCk4Async(/*partition key*/ String awsAccessKey
	                            /*clustering key*/ , String region, String family, String instancetype, String osPlatform) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
				.where(QueryBuilder.eq(AwsInstancetypeTable.AWS_ACCESS_KEY,awsAccessKey))
				.and(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				.and(QueryBuilder.eq(AwsInstancetypeTable.INSTANCETYPE,instancetype))
				.and(QueryBuilder.eq(AwsInstancetypeTable.OS_PLATFORM,osPlatform))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<AwsInstancetypeDto> getByCk4(/*clustering key*/ String region, String family, String instancetype, String osPlatform) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				.and(QueryBuilder.eq(AwsInstancetypeTable.INSTANCETYPE,instancetype))
				.and(QueryBuilder.eq(AwsInstancetypeTable.OS_PLATFORM,osPlatform))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<AwsInstancetypeDto>> getByCk4Async(/*clustering key*/ String region, String family, String instancetype, String osPlatform) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(AwsInstancetypeTable.REGION,region))
				.and(QueryBuilder.eq(AwsInstancetypeTable.FAMILY,family))
				.and(QueryBuilder.eq(AwsInstancetypeTable.INSTANCETYPE,instancetype))
				.and(QueryBuilder.eq(AwsInstancetypeTable.OS_PLATFORM,osPlatform))
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
    public Pair<PagingState,List<AwsInstancetypeDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<AwsInstancetypeDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<AwsInstancetypeDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<AwsInstancetypeDto> resultList = new ArrayList<AwsInstancetypeDto>();
        for (AwsInstancetypeDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<AwsInstancetypeDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<AwsInstancetypeDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<AwsInstancetypeDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<AwsInstancetypeDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(AwsInstancetypeTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<AwsInstancetypeDto>>> queryCertainPageAsync(
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
    protected Future<List<AwsInstancetypeDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<AwsInstancetypeDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<AwsInstancetypeDto>>) rs -> {
                    Result<AwsInstancetypeDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AwsInstancetypeDto> resultList = new ArrayList<AwsInstancetypeDto>();
                    for (AwsInstancetypeDto dto : results) {
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
    protected Future<Pair<PagingState,List<AwsInstancetypeDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<AwsInstancetypeDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<AwsInstancetypeDto>>>) rs -> {
                    Result<AwsInstancetypeDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<AwsInstancetypeDto> resultList = new ArrayList<AwsInstancetypeDto>();
                    for (AwsInstancetypeDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<AwsInstancetypeDto>>(newPagingState,resultList);
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

