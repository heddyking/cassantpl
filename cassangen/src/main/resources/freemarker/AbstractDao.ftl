package com.worksap.company.operation.cassandra.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.*;
import com.datastax.driver.mapping.*;
import java.util.concurrent.Future;
import com.google.common.base.Function;
import com.google.common.util.concurrent.*;
import com.worksap.company.operation.cassandra.dto.${tableClass}Dto;
import com.worksap.company.operation.cassandra.table.${tableClass}Table;
import javafx.util.Pair;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated <#--on ${.now}-->
 */
public abstract class Abstract${tableClass}Dao {

    protected final Session session;

    protected final Future<Session> sessionAsync;

    protected final MappingManager manager;

    protected final Mapper<${tableClass}Dto> mapper;

    public Abstract${tableClass}Dao(Session session, Future<Session> sessionAsync, MappingManager manager) {
        this.session = session;
        this.sessionAsync = sessionAsync;
        this.manager = manager;
        this.mapper = manager.mapper(${tableClass}Dto.class);
    }

    /**
     * save dto synchronously
     * @param dto
     */
    public void save(${tableClass}Dto dto) {
        mapper.save(dto);
    }

    /**
     * save dto asynchronously
     * @param dto
     */
    public Future<Void> saveAsync(${tableClass}Dto dto) {
        return mapper.saveAsync(dto);
    }

    /**
     * get dto by pk synchronously
     * @param {primarykeys}
     */
    public ${tableClass}Dto get(<#list columns as column><#if column.keyType="PartitionKey" || column.keyType="ClusteringColumn">${column.type} ${column.columnField}<#if column_has_next && (columns[column_index+1].keyType="PartitionKey" || columns[column_index+1].keyType="ClusteringColumn")>, </#if></#if></#list>) {
        return mapper.get(<#list columns as column><#if column.keyType="PartitionKey" || column.keyType="ClusteringColumn">${column.columnField}<#if column_has_next && (columns[column_index+1].keyType="PartitionKey" || columns[column_index+1].keyType="ClusteringColumn")>, </#if></#if></#list>);
    }

    /**
     * get dto by pk asynchronously
     * @param {primarykeys}
     */
    public Future<${tableClass}Dto> getAsync(<#list columns as column><#if column.keyType="PartitionKey" || column.keyType="ClusteringColumn">${column.type} ${column.columnField}<#if column_has_next && (columns[column_index+1].keyType="PartitionKey" || columns[column_index+1].keyType="ClusteringColumn")>, </#if></#if></#list>) {
        return mapper.getAsync(<#list columns as column><#if column.keyType="PartitionKey" || column.keyType="ClusteringColumn">${column.columnField}<#if column_has_next && (columns[column_index+1].keyType="PartitionKey" || columns[column_index+1].keyType="ClusteringColumn")>, </#if></#if></#list>);
    }

    /**
     * delete by pk synchronously
     * @param {primarykeys}
     */
    public void delete(<#list columns as column><#if column.keyType="PartitionKey" || column.keyType="ClusteringColumn">${column.type} ${column.columnField}<#if column_has_next && (columns[column_index+1].keyType="PartitionKey" || columns[column_index+1].keyType="ClusteringColumn")>, </#if></#if></#list>) {
        mapper.delete(<#list columns as column><#if column.keyType="PartitionKey" || column.keyType="ClusteringColumn">${column.columnField}<#if column_has_next && (columns[column_index+1].keyType="PartitionKey" || columns[column_index+1].keyType="ClusteringColumn")>, </#if></#if></#list>);
    }

    /**
     * delete by pk asynchronously
     * @param {primarykeys}
     */
    public Future<Void> deleteAsync(<#list columns as column><#if column.keyType="PartitionKey" || column.keyType="ClusteringColumn">${column.type} ${column.columnField}<#if column_has_next && (columns[column_index+1].keyType="PartitionKey" || columns[column_index+1].keyType="ClusteringColumn")>, </#if></#if></#list>) {
        return mapper.deleteAsync(<#list columns as column><#if column.keyType="PartitionKey" || column.keyType="ClusteringColumn">${column.columnField}<#if column_has_next && (columns[column_index+1].keyType="PartitionKey" || columns[column_index+1].keyType="ClusteringColumn")>, </#if></#if></#list>);
    }

    /**
     * delete dto synchronously
     * @param dto
     */
    public void delete(${tableClass}Dto dto) {
        mapper.delete(dto);
    }

    /**
     * delete dto asynchronously
     * @param dto
     */
    public Future<Void> deleteAsync(${tableClass}Dto dto) {
        return mapper.deleteAsync(dto);
    }

    /**
     * save dtos in an atomic batch synchronously
     * @param list
     */
    public void saveBatch(List<${tableClass}Dto> list) {
        BatchStatement batch = new BatchStatement();
        list.stream().forEach(dto -> batch.add(mapper.saveQuery(dto)));
        session.execute(batch);
    }

    /**
     * save dtos in an atomic batch asynchronously
     * @param list
     */
    public Future<Void> saveBatchAsync(List<${tableClass}Dto> list) {
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
    public boolean saveLwt(${tableClass}Dto dto){
        Statement query = QueryBuilder.insertInto(${tableClass}Table._NAME)
                <#list columns as column>
                .value(${tableClass}Table.${column.columnConstant}, dto.get${column.columnClass}())
                </#list>
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
    public Future<Boolean> saveLwtAsync(${tableClass}Dto dto){
        Statement query = QueryBuilder.insertInto(${tableClass}Table._NAME)
                <#list columns as column>
                .value(${tableClass}Table.${column.columnConstant}, dto.get${column.columnClass}())
                </#list>
                .ifNotExists()
                ;
        return Futures.transform(session.executeAsync(query),
                (Function<ResultSet, Boolean>) rs -> rs.one().getBool("[applied]"));
    }

    /**
     * get all records synchronously
     */
    public List<${tableClass}Dto> getAll() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME);
        return mapper.map(session.execute(query)).all();
    }

    /**
     * get all records asynchronously
     */
    public Future<List<${tableClass}Dto>> getAllAsync() {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME);
        Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
    }

    /**
     * get records by partition key synchronously
     * @param {partition keys}
     */
    public List<${tableClass}Dto> getByPk(/*partition key*/ <#list columns as column><#if column.keyType="PartitionKey">${column.type} ${column.columnField}<#if column_has_next && columns[column_index+1].keyType="PartitionKey">, </#if></#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="PartitionKey">
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key asynchronously
     * @param {partition keys}
     */
    public Future<List<${tableClass}Dto>> getByPkAsync(/*partition key*/ <#list columns as column><#if column.keyType="PartitionKey">${column.type} ${column.columnField}<#if column_has_next && columns[column_index+1].keyType="PartitionKey">, </#if></#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="PartitionKey">
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}
	<#if idxCount!=0>

	/**
     * get records by partition key and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<${tableClass}Dto> getByPkIdx(/*partition index*/ <#list columns as column><#if column.keyType="PartitionKey">${column.type} ${column.columnField}<#if column_has_next && columns[column_index+1].keyType="PartitionKey">, </#if></#if></#list>
	                              /*secondary index*/ <#list columns as column><#if column.keyType="SecondaryIndex">, ${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="PartitionKey">
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				;

		<#list columns as column>
		<#if column.keyType="SecondaryIndex">
        if(${column.columnField}!=null) query=((Select.Where)query).and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
		</#if>
		</#list>
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<${tableClass}Dto>> getByPkIdxAsync(/*partition key*/ <#list columns as column><#if column.keyType="PartitionKey">${column.type} ${column.columnField}<#if column_has_next && columns[column_index+1].keyType="PartitionKey">, </#if></#if></#list>
	                            /*secondary index*/ <#list columns as column><#if column.keyType="SecondaryIndex">, ${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="PartitionKey">
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				;

		<#list columns as column>
		<#if column.keyType="SecondaryIndex">
        if(${column.columnField}!=null) query=((Select.Where)query).and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
		</#if>
		</#list>
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<${tableClass}Dto> getByIdx(/*secondary index*/ <#assign notFirst = false><#list columns as column><#if column.keyType="SecondaryIndex"><#if notFirst=false><#assign notFirst = true><#else>, </#if>${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
                .allowFiltering();

	    boolean isfirst=true;
		<#list columns as column>
		<#if column.keyType="SecondaryIndex">
		if(${column.columnField}!=null && isfirst==true) {
		    isfirst=false;
			query=((Select)query).where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
		}
		else if(${column.columnField}!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
		}
		</#if>
		</#list>
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<${tableClass}Dto>> getByIdxAsync(/*secondary index*/ <#assign notFirst = false><#list columns as column><#if column.keyType="SecondaryIndex"><#if notFirst=false><#assign notFirst = true><#else>, </#if>${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
                .allowFiltering();

        boolean isfirst=true;
		<#list columns as column>
		<#if column.keyType="SecondaryIndex">
        if(${column.columnField}!=null && isfirst==true) {
            isfirst=false;
            query=((Select)query).where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
        }
        else if(${column.columnField}!=null){
            query=((Select.Where)query).and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
        }
		</#if>
		</#list>
        Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}
	</#if>
	<#if ckCount!=0>
	<#list 1..10 as n>
	<#if n<=ckCount>

	/**
     * get records by partition key and clustering keys synchronously
     * @param {partition keys}
     */
    public List<${tableClass}Dto> getByPkCk${n}(/*partition key*/ <#list columns as column><#if column.keyType="PartitionKey">${column.type} ${column.columnField}<#if column_has_next && columns[column_index+1].keyType="PartitionKey">, </#if></#if></#list>
	                              /*clustering key*/ <#list columns as column><#if column.keyType="ClusteringColumn" && column.keyIndex<n >, ${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="PartitionKey">
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				<#list columns as column>
				<#if column.keyType="ClusteringColumn" && column.keyIndex<n >
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#list>
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<${tableClass}Dto>> getByPkCk${n}Async(/*partition key*/ <#list columns as column><#if column.keyType="PartitionKey">${column.type} ${column.columnField}<#if column_has_next && columns[column_index+1].keyType="PartitionKey">, </#if></#if></#list>
	                            /*clustering key*/ <#list columns as column><#if column.keyType="ClusteringColumn" && column.keyIndex<n >, ${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="PartitionKey">
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				<#list columns as column>
				<#if column.keyType="ClusteringColumn" && column.keyIndex<n >
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#list>
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys synchronously
     * @param {partition keys}
     */
    public List<${tableClass}Dto> getByCk${n}(/*clustering key*/ <#assign notFirst = false><#list columns as column><#if column.keyType="ClusteringColumn" && column.keyIndex<n ><#if notFirst=false><#assign notFirst = true><#else>, </#if>${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
                .allowFiltering()
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="ClusteringColumn" && column.keyIndex<n >
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				;
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys asynchronously
     * @param {partition keys}
     */
    public Future<List<${tableClass}Dto>> getByCk${n}Async(/*clustering key*/ <#assign notFirst = false><#list columns as column><#if column.keyType="ClusteringColumn" && column.keyIndex<n ><#if notFirst=false><#assign notFirst = true><#else>, </#if>${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
                .allowFiltering()
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="ClusteringColumn" && column.keyIndex<n >
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(query));
        return transferFutureResultSet(futureResultSet);
	}
	<#if idxCount!=0>

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<${tableClass}Dto> getByPkCk${n}Idx(/*partition key*/ <#list columns as column><#if column.keyType="PartitionKey">${column.type} ${column.columnField}<#if column_has_next && columns[column_index+1].keyType="PartitionKey">, </#if></#if></#list>
	                              /*clustering key*/ <#list columns as column><#if column.keyType="ClusteringColumn" && column.keyIndex<n >, ${column.type} ${column.columnField}</#if></#list>
								  /*secondary index*/ <#list columns as column><#if column.keyType="SecondaryIndex">, ${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="PartitionKey">
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				<#list columns as column>
				<#if column.keyType="ClusteringColumn" && column.keyIndex<n >
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#list>
				;

		<#list columns as column>
		<#if column.keyType="SecondaryIndex">
        if(${column.columnField}!=null) query=((Select.Where)query).and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
		</#if>
		</#list>
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by partition key and clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<${tableClass}Dto>> getByPkCk${n}IdxAsync(/*partition key*/ <#list columns as column><#if column.keyType="PartitionKey">${column.type} ${column.columnField}<#if column_has_next && columns[column_index+1].keyType="PartitionKey">, </#if></#if></#list>
	                            <#list columns as column><#if column.keyType="ClusteringColumn" && column.keyIndex<n >, ${column.type} ${column.columnField}</#if></#list>
								/*secondary index*/ <#list columns as column><#if column.keyType="SecondaryIndex">, ${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="PartitionKey">
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				<#list columns as column>
				<#if column.keyType="ClusteringColumn" && column.keyIndex<n >
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#list>
				;

		<#list columns as column>
		<#if column.keyType="SecondaryIndex">
        if(${column.columnField}!=null) query=((Select.Where)query).and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
		</#if>
		</#list>
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}

	/**
     * get records by clustering keys and index(s)(index is optional) synchronously
     * @param {partition keys}
     */
    public List<${tableClass}Dto> getByCk${n}Idx(/*clustering key*/ <#assign notFirst = false><#list columns as column><#if column.keyType="ClusteringColumn" && column.keyIndex<n ><#if notFirst=false><#assign notFirst = true><#else>, </#if>${column.type} ${column.columnField}</#if></#list>
	                            /*secondary index*/ <#list columns as column><#if column.keyType="SecondaryIndex">, ${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
                .allowFiltering()
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="ClusteringColumn" && column.keyIndex<n >
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				;

		<#list columns as column>
		<#if column.keyType="SecondaryIndex">
		if(${column.columnField}!=null) query=((Select.Where)query).and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
		</#if>
		</#list>
		return mapper.map(session.execute(query)).all();
	}

	/**
     * get records by clustering keys and index(s)(index is optional) asynchronously
     * @param {partition keys}
     */
    public Future<List<${tableClass}Dto>> getByCk${n}IdxAsync(/*clustering key*/ <#assign notFirst = false><#list columns as column><#if column.keyType="ClusteringColumn" && column.keyIndex<n ><#if notFirst=false><#assign notFirst = true><#else>, </#if>${column.type} ${column.columnField}</#if></#list>
	                           /*secondary index*/ <#list columns as column><#if column.keyType="SecondaryIndex">, ${column.type} ${column.columnField}</#if></#list>) {
	    Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME)
                .allowFiltering()
				<#assign notFirst = false>
				<#list columns as column>
				<#if column.keyType="ClusteringColumn" && column.keyIndex<n >
				<#if notFirst = false>
				<#assign notFirst = true>
				.where(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				<#else>
				.and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}))
				</#if>
				</#if>
				</#list>
				;

		<#list columns as column>
		<#if column.keyType="SecondaryIndex">
        if(${column.columnField}!=null) query=((Select.Where)query).and(QueryBuilder.eq(${tableClass}Table.${column.columnConstant},${column.columnField}));
		</#if>
		</#list>
	    Statement qry=query;
		Future<ResultSet> futureResultSet = Futures.transform((ListenableFuture<Session>)sessionAsync,
                (AsyncFunction<Session, ResultSet>) session -> session.executeAsync(qry));
        return transferFutureResultSet(futureResultSet);
	}
	</#if>
	</#if>
	</#list>
	</#if>

    /**
     * get next page and new pagestate synchronously
     * @param size
     * @param pagingState
     */
    public Pair<PagingState,List<${tableClass}Dto>> getNextPage(Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME);
        return queryNextPage(size, pagingState, query);
    }

    /**
     * query next page and new pagestate synchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Pair<PagingState,List<${tableClass}Dto>> queryNextPage(
            Integer size, Optional<String> pagingState, Statement query) {
        query.setFetchSize(size);
        if (pagingState.isPresent()) {
            query.setPagingState(PagingState.fromString(pagingState.get()));
        }

        ResultSet rs = session.execute(query);

        Result<${tableClass}Dto> results = mapper.map(rs);
        PagingState newPagingState = results.getExecutionInfo().getPagingState();
        List<${tableClass}Dto> resultList = new ArrayList<${tableClass}Dto>();
        for (${tableClass}Dto dto : results) {
            resultList.add(dto);
            if (results.getAvailableWithoutFetching() == 0) {
                break;
            }
        }
        return new Pair<PagingState, List<${tableClass}Dto>>(newPagingState,resultList);
    }

    /**
     * get next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     */
    public Future<Pair<PagingState,List<${tableClass}Dto>>> getNextPageAsync(
            Integer size, Optional<String> pagingState) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME);
        return queryNextPageAsync(size, pagingState, query);
    }

    /**
     * query next page and new pagestate asynchronously
     * @param size
     * @param pagingState
     * @param query
     */
    protected Future<Pair<PagingState,List<${tableClass}Dto>>> queryNextPageAsync(
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
    public Future<Pair<PagingState,List<${tableClass}Dto>>> getCertainPageAsync(Integer size, Integer page) {
        Statement query = QueryBuilder
                .select()
                .all()
                .from(${tableClass}Table._NAME);
        return queryCertainPageAsync(size,page,query);
    }

    /**
     * query a certain page asynchronously
     * @param size
     * @param page
     * @param query
     */
    protected Future<Pair<PagingState,List<${tableClass}Dto>>> queryCertainPageAsync(
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
    protected Future<List<${tableClass}Dto>> transferFutureResultSet(
            Future<ResultSet> futureResultSet) {
        Future<List<${tableClass}Dto>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, List<${tableClass}Dto>>) rs -> {
                    Result<${tableClass}Dto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<${tableClass}Dto> resultList = new ArrayList<${tableClass}Dto>();
                    for (${tableClass}Dto dto : results) {
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
    protected Future<Pair<PagingState,List<${tableClass}Dto>>> transferFutureResultSetWithState(
            Future<ResultSet> futureResultSet) {
        Future<Pair<PagingState,List<${tableClass}Dto>>> futureResutlList = Futures.transform((ListenableFuture<ResultSet>)futureResultSet,
                (Function<ResultSet, Pair<PagingState,List<${tableClass}Dto>>>) rs -> {
                    Result<${tableClass}Dto> results = mapper.map(rs);
                    PagingState newPagingState = results.getExecutionInfo().getPagingState();
                    List<${tableClass}Dto> resultList = new ArrayList<${tableClass}Dto>();
                    for (${tableClass}Dto dto : results) {
                        resultList.add(dto);
                        if (results.getAvailableWithoutFetching() == 0) {
                            break;
                        }
                    }
                    return new Pair<PagingState,List<${tableClass}Dto>>(newPagingState,resultList);
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

