package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreMsaTable;
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
@Table(name = PreMsaTable._NAME)
public class PreMsaDto {

@PartitionKey(0)
@Column(name = PreMsaTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PreMsaTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PreMsaTable.TS)
private UUID ts;
}
