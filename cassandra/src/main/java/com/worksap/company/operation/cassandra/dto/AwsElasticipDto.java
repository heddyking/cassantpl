package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.AwsElasticipTable;
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
@Table(name = AwsElasticipTable._NAME)
public class AwsElasticipDto {

@PartitionKey(0)
@Column(name = AwsElasticipTable.AWS_ACCESS_KEY)
private String awsAccessKey;

@ClusteringColumn(0)
@Column(name = AwsElasticipTable.REGION)
private String region;

@ClusteringColumn(1)
@Column(name = AwsElasticipTable.ELASTICIP)
private String elasticip;

@Column(name = AwsElasticipTable.ENI_ID)
private String eniId;

@Column(name = AwsElasticipTable.PRIVATE_ID_ADDR)
private String privateIdAddr;

@Column(name = AwsElasticipTable.PUBLIC_DNS)
private String publicDns;
}
