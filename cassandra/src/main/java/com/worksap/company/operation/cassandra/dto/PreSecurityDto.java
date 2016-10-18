package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreSecurityTable;
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
@Table(name = PreSecurityTable._NAME)
public class PreSecurityDto {

@PartitionKey(0)
@Column(name = PreSecurityTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PreSecurityTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PreSecurityTable.TS)
private UUID ts;

@ClusteringColumn(2)
@Column(name = PreSecurityTable.SECURITY_NAME_PREFIX)
private String securityNamePrefix;

@Column(name = PreSecurityTable.CIDR_IP)
private String cidrIp;

@Column(name = PreSecurityTable.FROM_PORT)
private String fromPort;

@Column(name = PreSecurityTable.PROTO)
private String proto;

@Column(name = PreSecurityTable.TO_PORT)
private String toPort;
}
