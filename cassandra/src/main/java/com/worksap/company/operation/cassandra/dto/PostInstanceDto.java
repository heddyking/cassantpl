package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PostInstanceTable;
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
@Table(name = PostInstanceTable._NAME)
public class PostInstanceDto {

@PartitionKey(0)
@Column(name = PostInstanceTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PostInstanceTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PostInstanceTable.TS)
private UUID ts;

@ClusteringColumn(2)
@Column(name = PostInstanceTable.INSTANCE_ID)
private String instanceId;

@Column(name = PostInstanceTable.AMI_LAUNCH_INDEX)
private Integer amiLaunchIndex;

@Column(name = PostInstanceTable.ARCHITECTURE)
private String architecture;

@Column(name = PostInstanceTable.CLIENT_TOKEN)
private String clientToken;

@Column(name = PostInstanceTable.EBS_OPTIMIZED)
private Boolean ebsOptimized;

@Frozen("list<frozen<map<string,string>>>")
@Column(name = PostInstanceTable.GROUPS)
private List<Map<String,String>> groups;

@Column(name = PostInstanceTable.HYPERVISOR)
private String hypervisor;

@Column(name = PostInstanceTable.IMAGE_ID)
private String imageId;

@Column(name = PostInstanceTable.INSTANCE_NAME_SUFFIX)
private String instanceNameSuffix;

@Column(name = PostInstanceTable.INSTANCE_PROFILE)
private String instanceProfile;

@Column(name = PostInstanceTable.INSTANCE_TYPE)
private String instanceType;

@Frozen("list<frozen<map<string,string>>>")
@Column(name = PostInstanceTable.INTERFACES)
private List<Map<String,String>> interfaces;

@Column(name = PostInstanceTable.KERNEL)
private String kernel;

@Column(name = PostInstanceTable.KEY_NAME)
private String keyName;

@Column(name = PostInstanceTable.LAUNCH_TIME)
private Date launchTime;

@Column(name = PostInstanceTable.MONITORING_STATE)
private String monitoringState;

@Column(name = PostInstanceTable.PERSISTENT)
private Boolean persistent;

@Column(name = PostInstanceTable.PLACEMENT)
private Map<String,String> placement;

@Column(name = PostInstanceTable.PRIVATE_DNS_NAME)
private String privateDnsName;

@Column(name = PostInstanceTable.PRIVATE_IP_ADDRESS)
private String privateIpAddress;

@Column(name = PostInstanceTable.PUBLIC_DNS_NAME)
private String publicDnsName;

@Column(name = PostInstanceTable.RAMDISK)
private String ramdisk;

@Column(name = PostInstanceTable.REGION)
private String region;

@Column(name = PostInstanceTable.REQUESTER_ID)
private String requesterId;

@Column(name = PostInstanceTable.ROOT_DEVICE_TYPE)
private String rootDeviceType;

@Column(name = PostInstanceTable.SOURCE_DESTINATION_CHECK)
private Boolean sourceDestinationCheck;

@Column(name = PostInstanceTable.SPOT_INSTANCE_REQUEST_ID)
private String spotInstanceRequestId;

@Column(name = PostInstanceTable.STATE)
private String state;

@Column(name = PostInstanceTable.TAGS)
private Map<String,String> tags;

@Column(name = PostInstanceTable.VIRTUALIZATION_TYPE)
private String virtualizationType;

@Frozen("list<frozen<map<string,string>>>")
@Column(name = PostInstanceTable.VOLUMES)
private List<Map<String,String>> volumes;

//@SecondaryIndex
@Column(name = PostInstanceTable.VPC_ID)
private String vpcId;
}
