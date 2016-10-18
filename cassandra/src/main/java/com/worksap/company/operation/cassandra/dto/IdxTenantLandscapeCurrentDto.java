package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.IdxTenantLandscapeCurrentTable;
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
@Table(name = IdxTenantLandscapeCurrentTable._NAME)
public class IdxTenantLandscapeCurrentDto {

@PartitionKey(0)
@Column(name = IdxTenantLandscapeCurrentTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = IdxTenantLandscapeCurrentTable.LANDSCAPE)
private String landscape;

@Column(name = IdxTenantLandscapeCurrentTable.TRY_TS)
private UUID tryTs;

@Column(name = IdxTenantLandscapeCurrentTable.TRY_TYPE)
private String tryType;

@Column(name = IdxTenantLandscapeCurrentTable.TS)
private UUID ts;
}
