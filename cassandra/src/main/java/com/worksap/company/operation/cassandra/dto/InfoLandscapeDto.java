package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.InfoLandscapeTable;
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
@Table(name = InfoLandscapeTable._NAME)
public class InfoLandscapeDto {

@PartitionKey(0)
@Column(name = InfoLandscapeTable.PTK)
private String ptk;

@ClusteringColumn(0)
@Column(name = InfoLandscapeTable.LANDSCAPE)
private String landscape;

@Column(name = InfoLandscapeTable.DESCRIPTION)
private String description;

//@SecondaryIndex
@Column(name = InfoLandscapeTable.RECORD_STATE)
private Boolean recordState;
}
