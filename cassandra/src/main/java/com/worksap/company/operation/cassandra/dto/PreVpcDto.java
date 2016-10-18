package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreVpcTable;
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
@Table(name = PreVpcTable._NAME)
public class PreVpcDto {

@PartitionKey(0)
@Column(name = PreVpcTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PreVpcTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PreVpcTable.TS)
private UUID ts;

@Column(name = PreVpcTable.AWS_ACCESS_KEY)
private String awsAccessKey;

@Column(name = PreVpcTable.AWS_SECRET_KEY)
private String awsSecretKey;

@Column(name = PreVpcTable.BUCKET_NAME_PREFIX)
private String bucketNamePrefix;

@Column(name = PreVpcTable.CIDR_BLOCK_SUFFIX)
private String cidrBlockSuffix;

@Column(name = PreVpcTable.DESTINATION_ROOT)
private String destinationRoot;

@Column(name = PreVpcTable.IGW_NAME_PREFIX)
private String igwNamePrefix;

@Column(name = PreVpcTable.IP_PREFIX)
private String ipPrefix;

@Column(name = PreVpcTable.PRIVATE_IP_ADDRESS_SUFFIX)
private String privateIpAddressSuffix;

@Column(name = PreVpcTable.PRIVATE_RT_NAME_PREFIX)
private String privateRtNamePrefix;

@Column(name = PreVpcTable.PUBLIC_RT_NAME_PREFIX)
private String publicRtNamePrefix;

@Column(name = PreVpcTable.REGION)
private String region;

@Column(name = PreVpcTable.SECURITY_GROUP_PREFIX)
private String securityGroupPrefix;

@Column(name = PreVpcTable.SOURCE_ROOT)
private String sourceRoot;

@Column(name = PreVpcTable.VPC_PREFIX)
private String vpcPrefix;
}
