package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PostMsaTable;
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
@Table(name = PostMsaTable._NAME)
public class PostMsaDto {

@PartitionKey(0)
@Column(name = PostMsaTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PostMsaTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PostMsaTable.TS)
private UUID ts;

@Column(name = PostMsaTable.VPC_ID)
private String vpcId;
}
