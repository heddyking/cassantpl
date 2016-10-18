package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.JarMetaDataTable;
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
@Table(name = JarMetaDataTable._NAME)
public class JarMetaDataDto {

@PartitionKey(0)
@Column(name = JarMetaDataTable.PTK)
private String ptk;

@ClusteringColumn(0)
@Column(name = JarMetaDataTable.GROUP_ID)
private String groupId;

@ClusteringColumn(1)
@Column(name = JarMetaDataTable.ARTIFACT_ID)
private String artifactId;

@ClusteringColumn(2)
@Column(name = JarMetaDataTable.VERSION)
private String version;

@Column(name = JarMetaDataTable.JAR)
private String jar;

@Column(name = JarMetaDataTable.NEXUS)
private String nexus;

@Column(name = JarMetaDataTable.ORG)
private String org;

@Column(name = JarMetaDataTable.TS)
private Date ts;

@Column(name = JarMetaDataTable.URL)
private String url;
}
