package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.IdxOperatorPermissionTable;
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
@Table(name = IdxOperatorPermissionTable._NAME)
public class IdxOperatorPermissionDto {

@PartitionKey(0)
@Column(name = IdxOperatorPermissionTable.OPERATOR_ID)
private String operatorId;

@ClusteringColumn(0)
@Column(name = IdxOperatorPermissionTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(1)
@Column(name = IdxOperatorPermissionTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(2)
@Column(name = IdxOperatorPermissionTable.PGROUP)
private String pgroup;
}
