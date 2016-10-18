package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.AwsKeypairTable;
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
@Table(name = AwsKeypairTable._NAME)
public class AwsKeypairDto {

@PartitionKey(0)
@Column(name = AwsKeypairTable.AWS_ACCESS_KEY)
private String awsAccessKey;

@ClusteringColumn(0)
@Column(name = AwsKeypairTable.REGION)
private String region;

@ClusteringColumn(1)
@Column(name = AwsKeypairTable.KEYNAME)
private String keyname;

@Column(name = AwsKeypairTable.PEM)
private String pem;

@Column(name = AwsKeypairTable.PUB)
private String pub;
}
