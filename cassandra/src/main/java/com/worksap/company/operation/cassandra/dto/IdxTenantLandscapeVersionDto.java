package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.IdxTenantLandscapeVersionTable;
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
@Table(name = IdxTenantLandscapeVersionTable._NAME)
public class IdxTenantLandscapeVersionDto {

@PartitionKey(0)
@Column(name = IdxTenantLandscapeVersionTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = IdxTenantLandscapeVersionTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = IdxTenantLandscapeVersionTable.VERSION)
private String version;

@Column(name = IdxTenantLandscapeVersionTable.TS)
private UUID ts;
}
