package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.AwsKeyTable;
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
@Table(name = AwsKeyTable._NAME)
public class AwsKeyDto {

@PartitionKey(0)
@Column(name = AwsKeyTable.PTK)
private String ptk;

@ClusteringColumn(0)
@Column(name = AwsKeyTable.AWS_ACCESS_KEY)
private String awsAccessKey;

@ClusteringColumn(1)
@Column(name = AwsKeyTable.AWS_SECRET_KEY)
private String awsSecretKey;
}
