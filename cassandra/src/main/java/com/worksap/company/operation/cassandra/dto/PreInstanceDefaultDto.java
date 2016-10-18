package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreInstanceDefaultTable;
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
@Table(name = PreInstanceDefaultTable._NAME)
public class PreInstanceDefaultDto {

@PartitionKey(0)
@Column(name = PreInstanceDefaultTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(0)
@Column(name = PreInstanceDefaultTable.INSTANCE_NAME_SUFFIX)
private String instanceNameSuffix;

@Column(name = PreInstanceDefaultTable.IMAGE_ID)
private String imageId;

@Column(name = PreInstanceDefaultTable.INSTANCE_TYPE)
private String instanceType;

@Column(name = PreInstanceDefaultTable.KEY_NAME)
private String keyName;

@Column(name = PreInstanceDefaultTable.NUM)
private Integer num;

@Frozen("list<frozen<map<string,string>>>")
@Column(name = PreInstanceDefaultTable.VOLUMES)
private List<Map<String,String>> volumes;
}
