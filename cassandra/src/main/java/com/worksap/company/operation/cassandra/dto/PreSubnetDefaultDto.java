package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreSubnetDefaultTable;
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
@Table(name = PreSubnetDefaultTable._NAME)
public class PreSubnetDefaultDto {

@PartitionKey(0)
@Column(name = PreSubnetDefaultTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(0)
@Column(name = PreSubnetDefaultTable.SUBNET_NAME_SUFFIX)
private String subnetNameSuffix;

@Column(name = PreSubnetDefaultTable.SUB_REGION)
private String subRegion;

@Column(name = PreSubnetDefaultTable.SUBNET_CIDR_SUFFIX)
private String subnetCidrSuffix;
}
