package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.PostSecurityDto;
import com.worksap.company.operation.cassandra.table.PostSecurityTable;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
public abstract class AbstractPostSecurityDao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<PostSecurityDto> mapper;

    public AbstractPostSecurityDao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(PostSecurityDto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(PostSecurityDto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(PostSecurityDto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public PostSecurityDto get(String tenantId, String landscape, UUID ts, String securityId) {
        return mapper.get(tenantId, landscape, ts, securityId);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<PostSecurityDto> getAsync(String tenantId, String landscape, UUID ts, String securityId) {
        return mapper.getAsync(tenantId, landscape, ts, securityId);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(String tenantId, String landscape, UUID ts, String securityId) {
        mapper.delete(tenantId, landscape, ts, securityId);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(String tenantId, String landscape, UUID ts, String securityId) {
        return mapper.deleteAsync(tenantId, landscape, ts, securityId);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(PostSecurityDto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(PostSecurityDto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<PostSecurityDto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<PostSecurityDto> list) {
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
    public boolean saveLwt(PostSecurityDto dto){
        Statement query = QueryBuilder.insertInto(PostSecurityTable._NAME)
                .value(PostSecurityTable.TENANT_ID, dto.getTenantId())
                .value(PostSecurityTable.LANDSCAPE, dto.getLandscape())
                .value(PostSecurityTable.TS, dto.getTs())
                .value(PostSecurityTable.SECURITY_ID, dto.getSecurityId())
                .value(PostSecurityTable.CIDR_IP, dto.getCidrIp())
                .value(PostSecurityTable.FROM_PORT, dto.getFromPort())
                .value(PostSecurityTable.PROTO, dto.getProto())
                .value(PostSecurityTable.SECURITY_NAME_PREFIX, dto.getSecurityNamePrefix())
                .value(PostSecurityTable.TO_PORT, dto.getToPort())
                .value(PostSecurityTable.VPC_ID, dto.getVpcId())
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
    public Future<Boolean> saveLwtAsync(PostSecurityDto dto){
        Statement query = QueryBuilder.insertInto(PostSecurityTable._NAME)
                .value(PostSecurityTable.TENANT_ID, dto.getTenantId())
                .value(PostSecurityTable.LANDSCAPE, dto.getLandscape())
                .value(PostSecurityTable.TS, dto.getTs())
                .value(PostSecurityTable.SECURITY_ID, dto.getSecurityId())
                .value(PostSecurityTable.CIDR_IP, dto.getCidrIp())
                .value(PostSecurityTable.FROM_PORT, dto.getFromPort())
                .value(PostSecurityTable.PROTO, dto.getProto())
                .value(PostSecurityTable.SECURITY_NAME_PREFIX, dto.getSecurityNamePrefix())
                .value(PostSecurityTable.TO_PORT, dto.getToPort())
                .value(PostSecurityTable.VPC_ID, dto.getVpcId())
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<PostSecurityDto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<PostSecurityDto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByPk(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByPkAsync(/*partition key*/ String tenantId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByPkIdx(/*partition index*/ String tenantId
	                              /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByPkIdxAsync(/*partition key*/ String tenantId
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByIdx(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		if(vpcId!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
		}
		else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
		}
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByIdxAsync(/*secondary index*/ String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering();

        boolean isfirst=true;
        if(vpcId!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
        }
        else if(vpcId!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
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
    public List<PostSecurityDto> getByPkCk1(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByPkCk1Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByCk1(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByCk1Async(/*clustering key*/ String landscape) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByPkCk1Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByPkCk1IdxAsync(/*partition key*/ String tenantId
	                            , String landscape
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByCk1Idx(/*clustering key*/ String landscape
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByCk1IdxAsync(/*clustering key*/ String landscape
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByPkCk2(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByPkCk2Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByCk2(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByCk2Async(/*clustering key*/ String landscape, UUID ts) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByPkCk2Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByPkCk2IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByCk2Idx(/*clustering key*/ String landscape, UUID ts
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByCk2IdxAsync(/*clustering key*/ String landscape, UUID ts
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByPkCk3(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String securityId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PostSecurityTable.SECURITY_ID,securityId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByPkCk3Async(/*partition key*/ String tenantId
	                            /*clustering key*/ , String landscape, UUID ts, String securityId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PostSecurityTable.SECURITY_ID,securityId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByCk3(/*clustering key*/ String landscape, UUID ts, String securityId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PostSecurityTable.SECURITY_ID,securityId))
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByCk3Async(/*clustering key*/ String landscape, UUID ts, String securityId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PostSecurityTable.SECURITY_ID,securityId))
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByPkCk3Idx(/*partition key*/ String tenantId
	                              /*clustering key*/ , String landscape, UUID ts, String securityId
								  /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PostSecurityTable.SECURITY_ID,securityId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByPkCk3IdxAsync(/*partition key*/ String tenantId
	                            , String landscape, UUID ts, String securityId
								/*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
				.where(QueryBuilder.eq(PostSecurityTable.TENANT_ID,tenantId))
				.and(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PostSecurityTable.SECURITY_ID,securityId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<PostSecurityDto> getByCk3Idx(/*clustering key*/ String landscape, UUID ts, String securityId
	                            /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PostSecurityTable.SECURITY_ID,securityId))
				;

		if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<PostSecurityDto>> getByCk3IdxAsync(/*clustering key*/ String landscape, UUID ts, String securityId
	                           /*secondary index*/ , String vpcId) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME)
                .allowFiltering()
				.where(QueryBuilder.eq(PostSecurityTable.LANDSCAPE,landscape))
				.and(QueryBuilder.eq(PostSecurityTable.TS,ts))
				.and(QueryBuilder.eq(PostSecurityTable.SECURITY_ID,securityId))
				;

        if(vpcId!=null) query=((Select.Where)query).and(QueryBuilder.eq(PostSecurityTable.VPC_ID,vpcId));
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
    public Pair<PagingState,List<PostSecurityDto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<PostSecurityDto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<PostSecurityDto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<PostSecurityDto> resultList = new ArrayList<PostSecurityDto>();
        for (PostSecurityDto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<PostSecurityDto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<PostSecurityDto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<PostSecurityDto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<PostSecurityDto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(PostSecurityTable._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<PostSecurityDto>>> queryCertainPageAsync(
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
    protected Future<List<PostSecurityDto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<PostSecurityDto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<PostSecurityDto>>) rs -> {
                    Result<PostSecurityDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostSecurityDto> resultList = new ArrayList<PostSecurityDto>();
                    for (PostSecurityDto dto : results) {
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
    protected Future<Pair<PagingState,List<PostSecurityDto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<PostSecurityDto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<PostSecurityDto>>>) rs -> {
                    Result<PostSecurityDto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<PostSecurityDto> resultList = new ArrayList<PostSecurityDto>();
                    for (PostSecurityDto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<PostSecurityDto>>(newPagingState,resultList);
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

