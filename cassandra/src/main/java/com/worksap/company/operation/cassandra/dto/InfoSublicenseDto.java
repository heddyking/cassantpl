package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.InfoSublicenseTable;
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
@Table(name = InfoSublicenseTable._NAME)
public class InfoSublicenseDto {

@PartitionKey(0)
@Column(name = InfoSublicenseTable.PTK)
private String ptk;

@ClusteringColumn(0)
@Column(name = InfoSublicenseTable.SUBLICENSE_ID)
private UUID sublicenseId;

//@SecondaryIndex
@Column(name = InfoSublicenseTable.LICENSE_ID)
private UUID licenseId;

//@SecondaryIndex
@Column(name = InfoSublicenseTable.RECORD_STATE)
private Boolean recordState;

@Column(name = InfoSublicenseTable.SUBLICENSE_DETAIL)
private String sublicenseDetail;

@Column(name = InfoSublicenseTable.SUBLICENSE_NAME)
private Map<String,String> sublicenseName;
}
