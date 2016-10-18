package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreSubnetTable;
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
@Table(name = PreSubnetTable._NAME)
public class PreSubnetDto {

@PartitionKey(0)
@Column(name = PreSubnetTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PreSubnetTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PreSubnetTable.TS)
private UUID ts;

@ClusteringColumn(2)
@Column(name = PreSubnetTable.SUBNET_NAME_SUFFIX)
private String subnetNameSuffix;

@Column(name = PreSubnetTable.SUB_REGION)
private String subRegion;

@Column(name = PreSubnetTable.SUBNET_CIDR_SUFFIX)
private String subnetCidrSuffix;
}
