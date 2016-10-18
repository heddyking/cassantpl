package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.DockerMetaDataTable;
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
@Table(name = DockerMetaDataTable._NAME)
public class DockerMetaDataDto {

@PartitionKey(0)
@Column(name = DockerMetaDataTable.PTK)
private String ptk;

@ClusteringColumn(0)
@Column(name = DockerMetaDataTable.NAMESPACE)
private String namespace;

@ClusteringColumn(1)
@Column(name = DockerMetaDataTable.REPOSITORY)
private String repository;

@Column(name = DockerMetaDataTable.TAGS)
private List<String> tags;

@Column(name = DockerMetaDataTable.TS)
private Date ts;
}
