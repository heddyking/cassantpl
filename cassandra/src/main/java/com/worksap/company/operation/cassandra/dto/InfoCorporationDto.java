package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.InfoCorporationTable;
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
@Table(name = InfoCorporationTable._NAME)
public class InfoCorporationDto {

@PartitionKey(0)
@Column(name = InfoCorporationTable.CORPORATION_ID)
private String corporationId;

@Column(name = InfoCorporationTable.CORPORATION_ADDRESS)
private String corporationAddress;

@Column(name = InfoCorporationTable.CORPORATION_EMAIL)
private String corporationEmail;

@Column(name = InfoCorporationTable.CORPORATION_NAME)
private String corporationName;

@Column(name = InfoCorporationTable.CORPORATION_PHONE)
private String corporationPhone;

@Column(name = InfoCorporationTable.CREATED_AT)
private Date createdAt;

//@SecondaryIndex
@Column(name = InfoCorporationTable.RECORD_STATE)
private Boolean recordState;
}
