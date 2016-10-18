package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PostSecurityTable;
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
@Table(name = PostSecurityTable._NAME)
public class PostSecurityDto {

@PartitionKey(0)
@Column(name = PostSecurityTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PostSecurityTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PostSecurityTable.TS)
private UUID ts;

@ClusteringColumn(2)
@Column(name = PostSecurityTable.SECURITY_ID)
private String securityId;

@Column(name = PostSecurityTable.CIDR_IP)
private String cidrIp;

@Column(name = PostSecurityTable.FROM_PORT)
private String fromPort;

@Column(name = PostSecurityTable.PROTO)
private String proto;

@Column(name = PostSecurityTable.SECURITY_NAME_PREFIX)
private String securityNamePrefix;

@Column(name = PostSecurityTable.TO_PORT)
private String toPort;

//@SecondaryIndex
@Column(name = PostSecurityTable.VPC_ID)
private String vpcId;
}
