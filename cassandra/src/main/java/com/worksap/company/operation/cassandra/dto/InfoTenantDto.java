package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.InfoTenantTable;
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
@Table(name = InfoTenantTable._NAME)
public class InfoTenantDto {

@PartitionKey(0)
@Column(name = InfoTenantTable.TENANT_ID)
private String tenantId;

//@SecondaryIndex
@Column(name = InfoTenantTable.CORPORATION_ID)
private String corporationId;

@Column(name = InfoTenantTable.CREATED_AT)
private Date createdAt;

@Column(name = InfoTenantTable.LICENSE_END_TIME)
private Date licenseEndTime;

@Column(name = InfoTenantTable.LICENSE_ID)
private UUID licenseId;

@Column(name = InfoTenantTable.LICENSE_NAME)
private Map<String,String> licenseName;

@Column(name = InfoTenantTable.LICENSE_START_TIME)
private Date licenseStartTime;

@Column(name = InfoTenantTable.LICENSE_USERNUM)
private Integer licenseUsernum;

//@SecondaryIndex
@Column(name = InfoTenantTable.RECORD_STATE)
private Boolean recordState;

@Column(name = InfoTenantTable.TENANT_ADDRESS)
private String tenantAddress;

@Column(name = InfoTenantTable.TENANT_EMAIL)
private String tenantEmail;

@Column(name = InfoTenantTable.TENANT_NAME)
private String tenantName;

@Column(name = InfoTenantTable.TENANT_PHONE)
private String tenantPhone;

@Column(name = InfoTenantTable.TENANT_TYPE)
private String tenantType;
}
