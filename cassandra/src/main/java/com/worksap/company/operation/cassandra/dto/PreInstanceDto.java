package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreInstanceTable;
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
@Table(name = PreInstanceTable._NAME)
public class PreInstanceDto {

@PartitionKey(0)
@Column(name = PreInstanceTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PreInstanceTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PreInstanceTable.TS)
private UUID ts;

@ClusteringColumn(2)
@Column(name = PreInstanceTable.INSTANCE_NAME_SUFFIX)
private String instanceNameSuffix;

@Column(name = PreInstanceTable.IMAGE_ID)
private String imageId;

@Column(name = PreInstanceTable.INSTANCE_TYPE)
private String instanceType;

@Column(name = PreInstanceTable.KEY_NAME)
private String keyName;

@Column(name = PreInstanceTable.NUM)
private Integer num;

@Frozen("list<frozen<map<string,string>>>")
@Column(name = PreInstanceTable.VOLUMES)
private List<Map<String,String>> volumes;
}
