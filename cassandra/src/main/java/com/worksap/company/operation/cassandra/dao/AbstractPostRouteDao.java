package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PostRouteDto;
import com.worksap.company.operation.cassandra.table.PostRouteTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPostRouteDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PostRouteDto> mapper;

    public AbstractPostRouteDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PostRouteDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PostRouteDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PostRouteDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PostRouteDto get(String tenantId, String landscape, UUID ts, String routeId) {
        return mapper.get(tenantId, landscape, ts, routeId);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PostRouteDto> getAsync(String tenantId, String landscape, UUID ts, String routeId) {
        return mapper.getAsync(tenantId, landscape, ts, routeId);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape, UUID ts, String routeId) {
        mapper.delete(tenantId, landscape, ts, routeId);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape, UUID ts, String routeId) {
        return mapper.deleteAsync(tenantId, landscape, ts, routeId);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PostRouteDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PostRouteDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PostRouteDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PostRouteDto> list) {
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
    public boolean saveLwt(PostRouteDto dto){
        Statement query = QueryBuilder.insertInto(PostRouteTable._NAME)
                .value(PostRouteTable.TENANT_ID, dto.getTenantId())
                .value(PostRouteTable.LANDSCAPE, dto.getLandscape())
                .value(PostRouteTable.TS, dto.getTs())
                .value(PostRouteTable.ROUTE_ID, dto.getRouteId())
                .value(PostRouteTable.ROUTES, dto.getRoutes())
                .value(PostRouteTable.TAGS, dto.getTags())
                .value(PostRouteTable.VPC_ID, dto.getVpcId())
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
    public Future<Boolean> saveLwtAsync(PostRouteDto dto){
        Statement query = QueryBuilder.insertInto(PostRouteTable._NAME)
                .value(PostRouteTable.TENANT_ID, dto.getTenantId())
                .value(PostRouteTable.LANDSCAPE, dto.getLandscape())
                .value(PostRouteTable.TS, dto.getTs())
                .value(PostRouteTable.ROUTE_ID, dto.getRouteId())
                .value(PostRouteTable.ROUTES, dto.getRoutes())
                .value(PostRouteTable.TAGS, dto.getTags())
                .value(PostRouteTable.VPC_ID, dto.getVpcId())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PostRouteDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PostRouteDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByPkIdx(/*partition index*/ String tenantId
	                              /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByPkIdxAsync(/*partition key*/ String tenantId
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByIdx(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(vpcId!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
		}
		else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByIdxAsync(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(vpcId!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
        }
        else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
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
    public List<PostRouteDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByPkCk1Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByPkCk1IdxAsync(/*partition key*/ String tenantId
	                            , String landscape
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByCk1Idx(/*clustering key*/ String landscape
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByCk1IdxAsync(/*clustering key*/ String landscape
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByPkCk2Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByPkCk2IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByCk2Idx(/*clustering key*/ String landscape, UUID ts
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByCk2IdxAsync(/*clustering key*/ String landscape, UUID ts
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByPkCk3(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String routeId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				.and(QueryBuilder.eq(PostRouteTable.ROUTE_ID,routeId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByPkCk3Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts, String routeId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				.and(QueryBuilder.eq(PostRouteTable.ROUTE_ID,routeId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByCk3(/*clustering key*/ String landscape, UUID ts, String routeId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				.and(QueryBuilder.eq(PostRouteTable.ROUTE_ID,routeId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByCk3Async(/*clustering key*/ String landscape, UUID ts, String routeId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				.and(QueryBuilder.eq(PostRouteTable.ROUTE_ID,routeId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByPkCk3Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String routeId
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				.and(QueryBuilder.eq(PostRouteTable.ROUTE_ID,routeId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByPkCk3IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts, String routeId
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
				.where(QueryBuilder.eq(PostRouteTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				.and(QueryBuilder.eq(PostRouteTable.ROUTE_ID,routeId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostRouteDto> getByCk3Idx(/*clustering key*/ String landscape, UUID ts, String routeId
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				.and(QueryBuilder.eq(PostRouteTable.ROUTE_ID,routeId))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostRouteDto>> getByCk3IdxAsync(/*clustering key*/ String landscape, UUID ts, String routeId
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostRouteTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostRouteTable.TS,ts))
				.and(QueryBuilder.eq(PostRouteTable.ROUTE_ID,routeId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostRouteTable.VPC_ID,vpcId));
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
    public Pair<PagingState,List<PostRouteDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PostRouteDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PostRouteDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PostRouteDto> resultList = new ArrayList<PostRouteDto>();
        for (PostRouteDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PostRouteDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PostRouteDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PostRouteDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PostRouteDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostRouteTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PostRouteDto>>> queryCertainPageAsync(
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
    protected Future<List<PostRouteDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PostRouteDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PostRouteDto>>) rs -> {
                    Result<PostRouteDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostRouteDto> resultList = new ArrayList<PostRouteDto>();
                    for (PostRouteDto dto : results) {
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
    protected Future<Pair<PagingState,List<PostRouteDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PostRouteDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PostRouteDto>>>) rs -> {
                    Result<PostRouteDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostRouteDto> resultList = new ArrayList<PostRouteDto>();
                    for (PostRouteDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PostRouteDto>>(newPagingState,resultList);
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

