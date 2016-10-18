package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.InfoTenantSublicenseTable;
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
@Table(name = InfoTenantSublicenseTable._NAME)
public class InfoTenantSublicenseDto {

@PartitionKey(0)
@Column(name = InfoTenantSublicenseTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = InfoTenantSublicenseTable.SUBLICENSE_ID)
private UUID sublicenseId;

//@SecondaryIndex
@Column(name = InfoTenantSublicenseTable.RECORD_STATE)
private Boolean recordState;

@Column(name = InfoTenantSublicenseTable.SUBLICENSE_END_TIME)
private Date sublicenseEndTime;

@Column(name = InfoTenantSublicenseTable.SUBLICENSE_NAME)
private Map<String,String> sublicenseName;

@Column(name = InfoTenantSublicenseTable.SUBLICENSE_START_TIME)
private Date sublicenseStartTime;

@Column(name = InfoTenantSublicenseTable.SUBLICENSE_USERNUM)
private Integer sublicenseUsernum;
}
