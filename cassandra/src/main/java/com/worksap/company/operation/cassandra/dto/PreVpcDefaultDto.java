package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreVpcDefaultTable;
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
@Table(name = PreVpcDefaultTable._NAME)
public class PreVpcDefaultDto {

@PartitionKey(0)
@Column(name = PreVpcDefaultTable.LANDSCAPE)
private String landscape;

@Column(name = PreVpcDefaultTable.AWS_ACCESS_KEY)
private String awsAccessKey;

@Column(name = PreVpcDefaultTable.AWS_SECRET_KEY)
private String awsSecretKey;

@Column(name = PreVpcDefaultTable.BUCKET_NAME_PREFIX)
private String bucketNamePrefix;

@Column(name = PreVpcDefaultTable.CIDR_BLOCK_SUFFIX)
private String cidrBlockSuffix;

@Column(name = PreVpcDefaultTable.DESTINATION_ROOT)
private String destinationRoot;

@Column(name = PreVpcDefaultTable.IGW_NAME_PREFIX)
private String igwNamePrefix;

@Column(name = PreVpcDefaultTable.IP_PREFIX)
private String ipPrefix;

@Column(name = PreVpcDefaultTable.PRIVATE_IP_ADDRESS_SUFFIX)
private String privateIpAddressSuffix;

@Column(name = PreVpcDefaultTable.PRIVATE_RT_NAME_PREFIX)
private String privateRtNamePrefix;

@Column(name = PreVpcDefaultTable.PUBLIC_RT_NAME_PREFIX)
private String publicRtNamePrefix;

@Column(name = PreVpcDefaultTable.REGION)
private String region;

@Column(name = PreVpcDefaultTable.SECURITY_GROUP_PREFIX)
private String securityGroupPrefix;

@Column(name = PreVpcDefaultTable.SOURCE_ROOT)
private String sourceRoot;

@Column(name = PreVpcDefaultTable.VPC_PREFIX)
private String vpcPrefix;
}
