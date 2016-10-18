package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PostInstanceDto;
import com.worksap.company.operation.cassandra.table.PostInstanceTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPostInstanceDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PostInstanceDto> mapper;

    public AbstractPostInstanceDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PostInstanceDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PostInstanceDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PostInstanceDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PostInstanceDto get(String tenantId, String landscape, UUID ts, String instanceId) {
        return mapper.get(tenantId, landscape, ts, instanceId);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PostInstanceDto> getAsync(String tenantId, String landscape, UUID ts, String instanceId) {
        return mapper.getAsync(tenantId, landscape, ts, instanceId);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape, UUID ts, String instanceId) {
        mapper.delete(tenantId, landscape, ts, instanceId);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape, UUID ts, String instanceId) {
        return mapper.deleteAsync(tenantId, landscape, ts, instanceId);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PostInstanceDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PostInstanceDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PostInstanceDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PostInstanceDto> list) {
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
    public boolean saveLwt(PostInstanceDto dto){
        Statement query = QueryBuilder.insertInto(PostInstanceTable._NAME)
                .value(PostInstanceTable.TENANT_ID, dto.getTenantId())
                .value(PostInstanceTable.LANDSCAPE, dto.getLandscape())
                .value(PostInstanceTable.TS, dto.getTs())
                .value(PostInstanceTable.INSTANCE_ID, dto.getInstanceId())
                .value(PostInstanceTable.AMI_LAUNCH_INDEX, dto.getAmiLaunchIndex())
                .value(PostInstanceTable.ARCHITECTURE, dto.getArchitecture())
                .value(PostInstanceTable.CLIENT_TOKEN, dto.getClientToken())
                .value(PostInstanceTable.EBS_OPTIMIZED, dto.getEbsOptimized())
                .value(PostInstanceTable.GROUPS, dto.getGroups())
                .value(PostInstanceTable.HYPERVISOR, dto.getHypervisor())
                .value(PostInstanceTable.IMAGE_ID, dto.getImageId())
                .value(PostInstanceTable.INSTANCE_NAME_SUFFIX, dto.getInstanceNameSuffix())
                .value(PostInstanceTable.INSTANCE_PROFILE, dto.getInstanceProfile())
                .value(PostInstanceTable.INSTANCE_TYPE, dto.getInstanceType())
                .value(PostInstanceTable.INTERFACES, dto.getInterfaces())
                .value(PostInstanceTable.KERNEL, dto.getKernel())
                .value(PostInstanceTable.KEY_NAME, dto.getKeyName())
                .value(PostInstanceTable.LAUNCH_TIME, dto.getLaunchTime())
                .value(PostInstanceTable.MONITORING_STATE, dto.getMonitoringState())
                .value(PostInstanceTable.PERSISTENT, dto.getPersistent())
                .value(PostInstanceTable.PLACEMENT, dto.getPlacement())
                .value(PostInstanceTable.PRIVATE_DNS_NAME, dto.getPrivateDnsName())
                .value(PostInstanceTable.PRIVATE_IP_ADDRESS, dto.getPrivateIpAddress())
                .value(PostInstanceTable.PUBLIC_DNS_NAME, dto.getPublicDnsName())
                .value(PostInstanceTable.RAMDISK, dto.getRamdisk())
                .value(PostInstanceTable.REGION, dto.getRegion())
                .value(PostInstanceTable.REQUESTER_ID, dto.getRequesterId())
                .value(PostInstanceTable.ROOT_DEVICE_TYPE, dto.getRootDeviceType())
                .value(PostInstanceTable.SOURCE_DESTINATION_CHECK, dto.getSourceDestinationCheck())
                .value(PostInstanceTable.SPOT_INSTANCE_REQUEST_ID, dto.getSpotInstanceRequestId())
                .value(PostInstanceTable.STATE, dto.getState())
                .value(PostInstanceTable.TAGS, dto.getTags())
                .value(PostInstanceTable.VIRTUALIZATION_TYPE, dto.getVirtualizationType())
                .value(PostInstanceTable.VOLUMES, dto.getVolumes())
                .value(PostInstanceTable.VPC_ID, dto.getVpcId())
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
    public Future<Boolean> saveLwtAsync(PostInstanceDto dto){
        Statement query = QueryBuilder.insertInto(PostInstanceTable._NAME)
                .value(PostInstanceTable.TENANT_ID, dto.getTenantId())
                .value(PostInstanceTable.LANDSCAPE, dto.getLandscape())
                .value(PostInstanceTable.TS, dto.getTs())
                .value(PostInstanceTable.INSTANCE_ID, dto.getInstanceId())
                .value(PostInstanceTable.AMI_LAUNCH_INDEX, dto.getAmiLaunchIndex())
                .value(PostInstanceTable.ARCHITECTURE, dto.getArchitecture())
                .value(PostInstanceTable.CLIENT_TOKEN, dto.getClientToken())
                .value(PostInstanceTable.EBS_OPTIMIZED, dto.getEbsOptimized())
                .value(PostInstanceTable.GROUPS, dto.getGroups())
                .value(PostInstanceTable.HYPERVISOR, dto.getHypervisor())
                .value(PostInstanceTable.IMAGE_ID, dto.getImageId())
                .value(PostInstanceTable.INSTANCE_NAME_SUFFIX, dto.getInstanceNameSuffix())
                .value(PostInstanceTable.INSTANCE_PROFILE, dto.getInstanceProfile())
                .value(PostInstanceTable.INSTANCE_TYPE, dto.getInstanceType())
                .value(PostInstanceTable.INTERFACES, dto.getInterfaces())
                .value(PostInstanceTable.KERNEL, dto.getKernel())
                .value(PostInstanceTable.KEY_NAME, dto.getKeyName())
                .value(PostInstanceTable.LAUNCH_TIME, dto.getLaunchTime())
                .value(PostInstanceTable.MONITORING_STATE, dto.getMonitoringState())
                .value(PostInstanceTable.PERSISTENT, dto.getPersistent())
                .value(PostInstanceTable.PLACEMENT, dto.getPlacement())
                .value(PostInstanceTable.PRIVATE_DNS_NAME, dto.getPrivateDnsName())
                .value(PostInstanceTable.PRIVATE_IP_ADDRESS, dto.getPrivateIpAddress())
                .value(PostInstanceTable.PUBLIC_DNS_NAME, dto.getPublicDnsName())
                .value(PostInstanceTable.RAMDISK, dto.getRamdisk())
                .value(PostInstanceTable.REGION, dto.getRegion())
                .value(PostInstanceTable.REQUESTER_ID, dto.getRequesterId())
                .value(PostInstanceTable.ROOT_DEVICE_TYPE, dto.getRootDeviceType())
                .value(PostInstanceTable.SOURCE_DESTINATION_CHECK, dto.getSourceDestinationCheck())
                .value(PostInstanceTable.SPOT_INSTANCE_REQUEST_ID, dto.getSpotInstanceRequestId())
                .value(PostInstanceTable.STATE, dto.getState())
                .value(PostInstanceTable.TAGS, dto.getTags())
                .value(PostInstanceTable.VIRTUALIZATION_TYPE, dto.getVirtualizationType())
                .value(PostInstanceTable.VOLUMES, dto.getVolumes())
                .value(PostInstanceTable.VPC_ID, dto.getVpcId())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PostInstanceDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PostInstanceDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByPkIdx(/*partition index*/ String tenantId
	                              /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByPkIdxAsync(/*partition key*/ String tenantId
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByIdx(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(vpcId!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
		}
		else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByIdxAsync(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(vpcId!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
        }
        else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
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
    public List<PostInstanceDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByPkCk1Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByPkCk1IdxAsync(/*partition key*/ String tenantId
	                            , String landscape
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByCk1Idx(/*clustering key*/ String landscape
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByCk1IdxAsync(/*clustering key*/ String landscape
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByPkCk2Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByPkCk2IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByCk2Idx(/*clustering key*/ String landscape, UUID ts
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByCk2IdxAsync(/*clustering key*/ String landscape, UUID ts
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByPkCk3(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String instanceId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PostInstanceTable.INSTANCE_ID,instanceId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByPkCk3Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts, String instanceId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PostInstanceTable.INSTANCE_ID,instanceId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByCk3(/*clustering key*/ String landscape, UUID ts, String instanceId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PostInstanceTable.INSTANCE_ID,instanceId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByCk3Async(/*clustering key*/ String landscape, UUID ts, String instanceId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PostInstanceTable.INSTANCE_ID,instanceId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByPkCk3Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String instanceId
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PostInstanceTable.INSTANCE_ID,instanceId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByPkCk3IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts, String instanceId
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
				.where(QueryBuilder.eq(PostInstanceTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PostInstanceTable.INSTANCE_ID,instanceId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostInstanceDto> getByCk3Idx(/*clustering key*/ String landscape, UUID ts, String instanceId
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PostInstanceTable.INSTANCE_ID,instanceId))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostInstanceDto>> getByCk3IdxAsync(/*clustering key*/ String landscape, UUID ts, String instanceId
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostInstanceTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostInstanceTable.TS,ts))
				.and(QueryBuilder.eq(PostInstanceTable.INSTANCE_ID,instanceId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostInstanceTable.VPC_ID,vpcId));
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
    public Pair<PagingState,List<PostInstanceDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PostInstanceDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PostInstanceDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PostInstanceDto> resultList = new ArrayList<PostInstanceDto>();
        for (PostInstanceDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PostInstanceDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PostInstanceDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PostInstanceDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PostInstanceDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostInstanceTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PostInstanceDto>>> queryCertainPageAsync(
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
    protected Future<List<PostInstanceDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PostInstanceDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PostInstanceDto>>) rs -> {
                    Result<PostInstanceDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostInstanceDto> resultList = new ArrayList<PostInstanceDto>();
                    for (PostInstanceDto dto : results) {
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
    protected Future<Pair<PagingState,List<PostInstanceDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PostInstanceDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PostInstanceDto>>>) rs -> {
                    Result<PostInstanceDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostInstanceDto> resultList = new ArrayList<PostInstanceDto>();
                    for (PostInstanceDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PostInstanceDto>>(newPagingState,resultList);
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

