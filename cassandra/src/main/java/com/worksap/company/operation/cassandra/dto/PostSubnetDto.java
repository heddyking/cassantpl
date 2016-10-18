package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PostSubnetTable;
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
@Table(name = PostSubnetTable._NAME)
public class PostSubnetDto {

@PartitionKey(0)
@Column(name = PostSubnetTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PostSubnetTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PostSubnetTable.TS)
private UUID ts;

@ClusteringColumn(2)
@Column(name = PostSubnetTable.SUBNET_ID)
private String subnetId;

@Column(name = PostSubnetTable.AVAILABILITY_ZONE)
private String availabilityZone;

@Column(name = PostSubnetTable.AVAILABLE_IP_ADDRESS_COUNT)
private Integer availableIpAddressCount;

@Column(name = PostSubnetTable.CIDR_BLOCK)
private String cidrBlock;

@Column(name = PostSubnetTable.DEFAULT_FOR_AZ)
private Boolean defaultForAz;

@Column(name = PostSubnetTable.MAP_PUBLIC_IP_ON_LAUNCH)
private Boolean mapPublicIpOnLaunch;

@Column(name = PostSubnetTable.STATE)
private String state;

@Column(name = PostSubnetTable.SUB_REGION)
private String subRegion;

@Column(name = PostSubnetTable.SUBNET_CIDR_SUFFIX)
private String subnetCidrSuffix;

@Column(name = PostSubnetTable.SUBNET_NAME_SUFFIX)
private String subnetNameSuffix;

@Column(name = PostSubnetTable.TAGS)
private Map<String,String> tags;

//@SecondaryIndex
@Column(name = PostSubnetTable.VPC_ID)
private String vpcId;
}
