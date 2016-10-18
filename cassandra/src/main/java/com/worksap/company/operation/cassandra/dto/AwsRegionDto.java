package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.AwsRegionTable;
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
@Table(name = AwsRegionTable._NAME)
public class AwsRegionDto {

@PartitionKey(0)
@Column(name = AwsRegionTable.PTK)
private String ptk;

@ClusteringColumn(0)
@Column(name = AwsRegionTable.REGION)
private String region;
}
