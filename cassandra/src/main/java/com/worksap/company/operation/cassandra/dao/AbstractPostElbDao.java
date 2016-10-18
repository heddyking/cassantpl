package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PostElbDto;
import com.worksap.company.operation.cassandra.table.PostElbTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPostElbDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PostElbDto> mapper;

    public AbstractPostElbDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PostElbDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PostElbDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PostElbDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PostElbDto get(String tenantId, String landscape, UUID ts, String elbName) {
        return mapper.get(tenantId, landscape, ts, elbName);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PostElbDto> getAsync(String tenantId, String landscape, UUID ts, String elbName) {
        return mapper.getAsync(tenantId, landscape, ts, elbName);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape, UUID ts, String elbName) {
        mapper.delete(tenantId, landscape, ts, elbName);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape, UUID ts, String elbName) {
        return mapper.deleteAsync(tenantId, landscape, ts, elbName);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PostElbDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PostElbDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PostElbDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PostElbDto> list) {
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
    public boolean saveLwt(PostElbDto dto){
        Statement query = QueryBuilder.insertInto(PostElbTable._NAME)
                .value(PostElbTable.TENANT_ID, dto.getTenantId())
                .value(PostElbTable.LANDSCAPE, dto.getLandscape())
                .value(PostElbTable.TS, dto.getTs())
                .value(PostElbTable.ELB_NAME, dto.getElbName())
                .value(PostElbTable.CANONICAL_HOSTED_ZONE_NAME, dto.getCanonicalHostedZoneName())
                .value(PostElbTable.CANONICAL_HOSTED_ZONE_NAME_ID, dto.getCanonicalHostedZoneNameId())
                .value(PostElbTable.DNS_NAME, dto.getDnsName())
                .value(PostElbTable.HEALTH_CHECK, dto.getHealthCheck())
                .value(PostElbTable.INSTANCES, dto.getInstances())
                .value(PostElbTable.INSTANCES_INSERVICE, dto.getInstancesInservice())
                .value(PostElbTable.INSTANCES_INSERVICE_COUNT, dto.getInstancesInserviceCount())
                .value(PostElbTable.INSTANCES_INSERVICE_PERCENT, dto.getInstancesInservicePercent())
                .value(PostElbTable.INSTANCES_OUTOFSERVICE, dto.getInstancesOutofservice())
                .value(PostElbTable.INSTANCES_OUTOFSERVICE_COUNT, dto.getInstancesOutofserviceCount())
                .value(PostElbTable.LISTENERS, dto.getListeners())
                .value(PostElbTable.SCHEME, dto.getScheme())
                .value(PostElbTable.SECURITY_GROUPS, dto.getSecurityGroups())
                .value(PostElbTable.SUBNETS, dto.getSubnets())
                .value(PostElbTable.VPC_ID, dto.getVpcId())
                .value(PostElbTable.ZONES, dto.getZones())
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
    public Future<Boolean> saveLwtAsync(PostElbDto dto){
        Statement query = QueryBuilder.insertInto(PostElbTable._NAME)
                .value(PostElbTable.TENANT_ID, dto.getTenantId())
                .value(PostElbTable.LANDSCAPE, dto.getLandscape())
                .value(PostElbTable.TS, dto.getTs())
                .value(PostElbTable.ELB_NAME, dto.getElbName())
                .value(PostElbTable.CANONICAL_HOSTED_ZONE_NAME, dto.getCanonicalHostedZoneName())
                .value(PostElbTable.CANONICAL_HOSTED_ZONE_NAME_ID, dto.getCanonicalHostedZoneNameId())
                .value(PostElbTable.DNS_NAME, dto.getDnsName())
                .value(PostElbTable.HEALTH_CHECK, dto.getHealthCheck())
                .value(PostElbTable.INSTANCES, dto.getInstances())
                .value(PostElbTable.INSTANCES_INSERVICE, dto.getInstancesInservice())
                .value(PostElbTable.INSTANCES_INSERVICE_COUNT, dto.getInstancesInserviceCount())
                .value(PostElbTable.INSTANCES_INSERVICE_PERCENT, dto.getInstancesInservicePercent())
                .value(PostElbTable.INSTANCES_OUTOFSERVICE, dto.getInstancesOutofservice())
                .value(PostElbTable.INSTANCES_OUTOFSERVICE_COUNT, dto.getInstancesOutofserviceCount())
                .value(PostElbTable.LISTENERS, dto.getListeners())
                .value(PostElbTable.SCHEME, dto.getScheme())
                .value(PostElbTable.SECURITY_GROUPS, dto.getSecurityGroups())
                .value(PostElbTable.SUBNETS, dto.getSubnets())
                .value(PostElbTable.VPC_ID, dto.getVpcId())
                .value(PostElbTable.ZONES, dto.getZones())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PostElbDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PostElbDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByPkIdx(/*partition index*/ String tenantId
	                              /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByPkIdxAsync(/*partition key*/ String tenantId
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByIdx(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(vpcId!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
		}
		else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByIdxAsync(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(vpcId!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
        }
        else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
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
    public List<PostElbDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByPkCk1Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByPkCk1IdxAsync(/*partition key*/ String tenantId
	                            , String landscape
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByCk1Idx(/*clustering key*/ String landscape
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByCk1IdxAsync(/*clustering key*/ String landscape
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByPkCk2Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByPkCk2IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByCk2Idx(/*clustering key*/ String landscape, UUID ts
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByCk2IdxAsync(/*clustering key*/ String landscape, UUID ts
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByPkCk3(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String elbName) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				.and(QueryBuilder.eq(PostElbTable.ELB_NAME,elbName))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByPkCk3Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts, String elbName) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				.and(QueryBuilder.eq(PostElbTable.ELB_NAME,elbName))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByCk3(/*clustering key*/ String landscape, UUID ts, String elbName) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				.and(QueryBuilder.eq(PostElbTable.ELB_NAME,elbName))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByCk3Async(/*clustering key*/ String landscape, UUID ts, String elbName) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				.and(QueryBuilder.eq(PostElbTable.ELB_NAME,elbName))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByPkCk3Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String elbName
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				.and(QueryBuilder.eq(PostElbTable.ELB_NAME,elbName))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByPkCk3IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts, String elbName
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
				.where(QueryBuilder.eq(PostElbTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				.and(QueryBuilder.eq(PostElbTable.ELB_NAME,elbName))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostElbDto> getByCk3Idx(/*clustering key*/ String landscape, UUID ts, String elbName
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				.and(QueryBuilder.eq(PostElbTable.ELB_NAME,elbName))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostElbDto>> getByCk3IdxAsync(/*clustering key*/ String landscape, UUID ts, String elbName
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostElbTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostElbTable.TS,ts))
				.and(QueryBuilder.eq(PostElbTable.ELB_NAME,elbName))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostElbTable.VPC_ID,vpcId));
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
    public Pair<PagingState,List<PostElbDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PostElbDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PostElbDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PostElbDto> resultList = new ArrayList<PostElbDto>();
        for (PostElbDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PostElbDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PostElbDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PostElbDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PostElbDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostElbTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PostElbDto>>> queryCertainPageAsync(
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
    protected Future<List<PostElbDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PostElbDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PostElbDto>>) rs -> {
                    Result<PostElbDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostElbDto> resultList = new ArrayList<PostElbDto>();
                    for (PostElbDto dto : results) {
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
    protected Future<Pair<PagingState,List<PostElbDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PostElbDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PostElbDto>>>) rs -> {
                    Result<PostElbDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostElbDto> resultList = new ArrayList<PostElbDto>();
                    for (PostElbDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PostElbDto>>(newPagingState,resultList);
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

