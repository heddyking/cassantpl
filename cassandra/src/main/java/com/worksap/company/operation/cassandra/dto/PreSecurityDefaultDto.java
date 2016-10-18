package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreSecurityDefaultTable;
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
@Table(name = PreSecurityDefaultTable._NAME)
public class PreSecurityDefaultDto {

@PartitionKey(0)
@Column(name = PreSecurityDefaultTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(0)
@Column(name = PreSecurityDefaultTable.SECURITY_NAME_PREFIX)
private String securityNamePrefix;

@Column(name = PreSecurityDefaultTable.CIDR_IP)
private String cidrIp;

@Column(name = PreSecurityDefaultTable.FROM_PORT)
private String fromPort;

@Column(name = PreSecurityDefaultTable.PROTO)
private String proto;

@Column(name = PreSecurityDefaultTable.TO_PORT)
private String toPort;
}
