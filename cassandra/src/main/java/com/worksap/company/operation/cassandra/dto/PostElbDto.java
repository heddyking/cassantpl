package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PostElbTable;
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
@Table(name = PostElbTable._NAME)
public class PostElbDto {

@PartitionKey(0)
@Column(name = PostElbTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PostElbTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PostElbTable.TS)
private UUID ts;

@ClusteringColumn(2)
@Column(name = PostElbTable.ELB_NAME)
private String elbName;

@Column(name = PostElbTable.CANONICAL_HOSTED_ZONE_NAME)
private String canonicalHostedZoneName;

@Column(name = PostElbTable.CANONICAL_HOSTED_ZONE_NAME_ID)
private String canonicalHostedZoneNameId;

@Column(name = PostElbTable.DNS_NAME)
private String dnsName;

@Column(name = PostElbTable.HEALTH_CHECK)
private Map<String,String> healthCheck;

@Column(name = PostElbTable.INSTANCES)
private List<String> instances;

@Column(name = PostElbTable.INSTANCES_INSERVICE)
private List<String> instancesInservice;

@Column(name = PostElbTable.INSTANCES_INSERVICE_COUNT)
private Integer instancesInserviceCount;

@Column(name = PostElbTable.INSTANCES_INSERVICE_PERCENT)
private Double instancesInservicePercent;

@Column(name = PostElbTable.INSTANCES_OUTOFSERVICE)
private List<String> instancesOutofservice;

@Column(name = PostElbTable.INSTANCES_OUTOFSERVICE_COUNT)
private Integer instancesOutofserviceCount;

@Frozen("list<frozen<map<string,string>>>")
@Column(name = PostElbTable.LISTENERS)
private List<Map<String,String>> listeners;

@Column(name = PostElbTable.SCHEME)
private String scheme;

@Column(name = PostElbTable.SECURITY_GROUPS)
private List<String> securityGroups;

@Column(name = PostElbTable.SUBNETS)
private List<String> subnets;

//@SecondaryIndex
@Column(name = PostElbTable.VPC_ID)
private String vpcId;

@Column(name = PostElbTable.ZONES)
private List<String> zones;
}
