package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.InfoLicenseTable;
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
@Table(name = InfoLicenseTable._NAME)
public class InfoLicenseDto {

@PartitionKey(0)
@Column(name = InfoLicenseTable.PTK)
private String ptk;

@ClusteringColumn(0)
@Column(name = InfoLicenseTable.LICENSE_ID)
private UUID licenseId;

@Column(name = InfoLicenseTable.LICENSE_DETAIL)
private String licenseDetail;

@Column(name = InfoLicenseTable.LICENSE_NAME)
private Map<String,String> licenseName;

//@SecondaryIndex
@Column(name = InfoLicenseTable.RECORD_STATE)
private Boolean recordState;
}
