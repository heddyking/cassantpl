package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PostRouteTable;
import com.datastax.driver.mapping.annotations.*;
import lombok.*;
import java.util.*;
import java.math.*;
import java.net.*;
import java.nio.*;

/**
 * @generated 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = PostRouteTable._NAME)
public class PostRouteDto {

@PartitionKey(0)
@Column(name = PostRouteTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PostRouteTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PostRouteTable.TS)
private UUID ts;

@ClusteringColumn(2)
@Column(name = PostRouteTable.ROUTE_ID)
private String routeId;

@Frozen("list<frozen<map<string,string>>>")
@Column(name = PostRouteTable.ROUTES)
private List<Map<String,String>> routes;

@Column(name = PostRouteTable.TAGS)
private Map<String,String> tags;

//@SecondaryIndex
@Column(name = PostRouteTable.VPC_ID)
private String vpcId;
}
