package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PostSubnetDto;
import com.worksap.company.operation.cassandra.table.PostSubnetTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPostSubnetDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PostSubnetDto> mapper;

    public AbstractPostSubnetDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PostSubnetDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PostSubnetDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PostSubnetDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PostSubnetDto get(String tenantId, String landscape, UUID ts, String subnetId) {
        return mapper.get(tenantId, landscape, ts, subnetId);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PostSubnetDto> getAsync(String tenantId, String landscape, UUID ts, String subnetId) {
        return mapper.getAsync(tenantId, landscape, ts, subnetId);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape, UUID ts, String subnetId) {
        mapper.delete(tenantId, landscape, ts, subnetId);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape, UUID ts, String subnetId) {
        return mapper.deleteAsync(tenantId, landscape, ts, subnetId);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PostSubnetDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PostSubnetDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PostSubnetDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PostSubnetDto> list) {
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
    public boolean saveLwt(PostSubnetDto dto){
        Statement query = QueryBuilder.insertInto(PostSubnetTable._NAME)
                .value(PostSubnetTable.TENANT_ID, dto.getTenantId())
                .value(PostSubnetTable.LANDSCAPE, dto.getLandscape())
                .value(PostSubnetTable.TS, dto.getTs())
                .value(PostSubnetTable.SUBNET_ID, dto.getSubnetId())
                .value(PostSubnetTable.AVAILABILITY_ZONE, dto.getAvailabilityZone())
                .value(PostSubnetTable.AVAILABLE_IP_ADDRESS_COUNT, dto.getAvailableIpAddressCount())
                .value(PostSubnetTable.CIDR_BLOCK, dto.getCidrBlock())
                .value(PostSubnetTable.DEFAULT_FOR_AZ, dto.getDefaultForAz())
                .value(PostSubnetTable.MAP_PUBLIC_IP_ON_LAUNCH, dto.getMapPublicIpOnLaunch())
                .value(PostSubnetTable.STATE, dto.getState())
                .value(PostSubnetTable.SUB_REGION, dto.getSubRegion())
                .value(PostSubnetTable.SUBNET_CIDR_SUFFIX, dto.getSubnetCidrSuffix())
                .value(PostSubnetTable.SUBNET_NAME_SUFFIX, dto.getSubnetNameSuffix())
                .value(PostSubnetTable.TAGS, dto.getTags())
                .value(PostSubnetTable.VPC_ID, dto.getVpcId())
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
    public Future<Boolean> saveLwtAsync(PostSubnetDto dto){
        Statement query = QueryBuilder.insertInto(PostSubnetTable._NAME)
                .value(PostSubnetTable.TENANT_ID, dto.getTenantId())
                .value(PostSubnetTable.LANDSCAPE, dto.getLandscape())
                .value(PostSubnetTable.TS, dto.getTs())
                .value(PostSubnetTable.SUBNET_ID, dto.getSubnetId())
                .value(PostSubnetTable.AVAILABILITY_ZONE, dto.getAvailabilityZone())
                .value(PostSubnetTable.AVAILABLE_IP_ADDRESS_COUNT, dto.getAvailableIpAddressCount())
                .value(PostSubnetTable.CIDR_BLOCK, dto.getCidrBlock())
                .value(PostSubnetTable.DEFAULT_FOR_AZ, dto.getDefaultForAz())
                .value(PostSubnetTable.MAP_PUBLIC_IP_ON_LAUNCH, dto.getMapPublicIpOnLaunch())
                .value(PostSubnetTable.STATE, dto.getState())
                .value(PostSubnetTable.SUB_REGION, dto.getSubRegion())
                .value(PostSubnetTable.SUBNET_CIDR_SUFFIX, dto.getSubnetCidrSuffix())
                .value(PostSubnetTable.SUBNET_NAME_SUFFIX, dto.getSubnetNameSuffix())
                .value(PostSubnetTable.TAGS, dto.getTags())
                .value(PostSubnetTable.VPC_ID, dto.getVpcId())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PostSubnetDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PostSubnetDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByPkIdx(/*partition index*/ String tenantId
	                              /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByPkIdxAsync(/*partition key*/ String tenantId
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByIdx(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(vpcId!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
		}
		else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByIdxAsync(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(vpcId!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
        }
        else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
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
    public List<PostSubnetDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByPkCk1Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByPkCk1IdxAsync(/*partition key*/ String tenantId
	                            , String landscape
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByCk1Idx(/*clustering key*/ String landscape
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByCk1IdxAsync(/*clustering key*/ String landscape
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByPkCk2Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByPkCk2IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByCk2Idx(/*clustering key*/ String landscape, UUID ts
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByCk2IdxAsync(/*clustering key*/ String landscape, UUID ts
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByPkCk3(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String subnetId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PostSubnetTable.SUBNET_ID,subnetId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByPkCk3Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts, String subnetId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PostSubnetTable.SUBNET_ID,subnetId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByCk3(/*clustering key*/ String landscape, UUID ts, String subnetId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PostSubnetTable.SUBNET_ID,subnetId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByCk3Async(/*clustering key*/ String landscape, UUID ts, String subnetId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PostSubnetTable.SUBNET_ID,subnetId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByPkCk3Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String subnetId
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PostSubnetTable.SUBNET_ID,subnetId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByPkCk3IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts, String subnetId
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
				.where(QueryBuilder.eq(PostSubnetTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PostSubnetTable.SUBNET_ID,subnetId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSubnetDto> getByCk3Idx(/*clustering key*/ String landscape, UUID ts, String subnetId
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PostSubnetTable.SUBNET_ID,subnetId))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSubnetDto>> getByCk3IdxAsync(/*clustering key*/ String landscape, UUID ts, String subnetId
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSubnetTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSubnetTable.TS,ts))
				.and(QueryBuilder.eq(PostSubnetTable.SUBNET_ID,subnetId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSubnetTable.VPC_ID,vpcId));
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
    public Pair<PagingState,List<PostSubnetDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PostSubnetDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PostSubnetDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PostSubnetDto> resultList = new ArrayList<PostSubnetDto>();
        for (PostSubnetDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PostSubnetDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PostSubnetDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PostSubnetDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PostSubnetDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSubnetTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PostSubnetDto>>> queryCertainPageAsync(
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
    protected Future<List<PostSubnetDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PostSubnetDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PostSubnetDto>>) rs -> {
                    Result<PostSubnetDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostSubnetDto> resultList = new ArrayList<PostSubnetDto>();
                    for (PostSubnetDto dto : results) {
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
    protected Future<Pair<PagingState,List<PostSubnetDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PostSubnetDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PostSubnetDto>>>) rs -> {
                    Result<PostSubnetDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostSubnetDto> resultList = new ArrayList<PostSubnetDto>();
                    for (PostSubnetDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PostSubnetDto>>(newPagingState,resultList);
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

