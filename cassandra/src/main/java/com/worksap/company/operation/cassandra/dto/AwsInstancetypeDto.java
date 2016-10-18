package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.AwsInstancetypeTable;
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
@Table(name = AwsInstancetypeTable._NAME)
public class AwsInstancetypeDto {

@PartitionKey(0)
@Column(name = AwsInstancetypeTable.AWS_ACCESS_KEY)
private String awsAccessKey;

@ClusteringColumn(0)
@Column(name = AwsInstancetypeTable.REGION)
private String region;

@ClusteringColumn(1)
@Column(name = AwsInstancetypeTable.FAMILY)
private String family;

@ClusteringColumn(2)
@Column(name = AwsInstancetypeTable.INSTANCETYPE)
private String instancetype;

@ClusteringColumn(3)
@Column(name = AwsInstancetypeTable.OS_PLATFORM)
private String osPlatform;

@Column(name = AwsInstancetypeTable.EBS_OPTIMIZED)
private Boolean ebsOptimized;

@Column(name = AwsInstancetypeTable.INSTANCE_STORAGE)
private String instanceStorage;

@Column(name = AwsInstancetypeTable.MEMORY)
private String memory;

@Column(name = AwsInstancetypeTable.NETWORK)
private String network;

@Column(name = AwsInstancetypeTable.PLATFORM)
private String platform;

@Column(name = AwsInstancetypeTable.PRICE_ON_DEMAND)
private String priceOnDemand;

@Column(name = AwsInstancetypeTable.VCPUS)
private String vcpus;
}
