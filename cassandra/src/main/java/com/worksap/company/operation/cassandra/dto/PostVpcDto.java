package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PostVpcTable;
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
@Table(name = PostVpcTable._NAME)
public class PostVpcDto {

@PartitionKey(0)
@Column(name = PostVpcTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PostVpcTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PostVpcTable.TS)
private UUID ts;

@Column(name = PostVpcTable.AWS_ACCESS_KEY)
private String awsAccessKey;

@Column(name = PostVpcTable.AWS_SECRET_KEY)
private String awsSecretKey;

@Column(name = PostVpcTable.BUCKET_NAME_PREFIX)
private String bucketNamePrefix;

@Column(name = PostVpcTable.CIDR_BLOCK_SUFFIX)
private String cidrBlockSuffix;

@Column(name = PostVpcTable.DESTINATION_ROOT)
private String destinationRoot;

@Column(name = PostVpcTable.IGW_NAME_PREFIX)
private String igwNamePrefix;

@Column(name = PostVpcTable.IP_PREFIX)
private String ipPrefix;

@Column(name = PostVpcTable.PRIVATE_IP_ADDRESS_SUFFIX)
private String privateIpAddressSuffix;

@Column(name = PostVpcTable.PRIVATE_RT_NAME_PREFIX)
private String privateRtNamePrefix;

@Column(name = PostVpcTable.PUBLIC_RT_NAME_PREFIX)
private String publicRtNamePrefix;

@Column(name = PostVpcTable.REGION)
private String region;

@Column(name = PostVpcTable.SECURITY_GROUP_PREFIX)
private String securityGroupPrefix;

@Column(name = PostVpcTable.SOURCE_ROOT)
private String sourceRoot;

//@SecondaryIndex
@Column(name = PostVpcTable.VPC_ID)
private String vpcId;

@Column(name = PostVpcTable.VPC_PREFIX)
private String vpcPrefix;
}
