package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.AwsAmiTable;
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
@Table(name = AwsAmiTable._NAME)
public class AwsAmiDto {

@PartitionKey(0)
@Column(name = AwsAmiTable.AWS_ACCESS_KEY)
private String awsAccessKey;

@ClusteringColumn(0)
@Column(name = AwsAmiTable.REGION)
private String region;

@ClusteringColumn(1)
@Column(name = AwsAmiTable.AMI_ID)
private String amiId;

@Column(name = AwsAmiTable.AMI_NAME)
private String amiName;

@Column(name = AwsAmiTable.BLOCK_DEVICES)
private String blockDevices;

@Column(name = AwsAmiTable.CREATION_DATA)
private String creationData;

@Column(name = AwsAmiTable.DESCRIPTION)
private String description;

@Column(name = AwsAmiTable.IMAGE_SIZE)
private String imageSize;

@Column(name = AwsAmiTable.PLATFORM)
private String platform;

@Column(name = AwsAmiTable.ROOT_DEVICE_NAME)
private String rootDeviceName;

@Column(name = AwsAmiTable.ROOT_DEVICE_TYPE)
private String rootDeviceType;

@Column(name = AwsAmiTable.STATUS)
private String status;

@Column(name = AwsAmiTable.VIRTUALIZATION)
private String virtualization;
}
