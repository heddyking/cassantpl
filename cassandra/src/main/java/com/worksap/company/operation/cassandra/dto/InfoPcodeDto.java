package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.InfoPcodeTable;
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
@Table(name = InfoPcodeTable._NAME)
public class InfoPcodeDto {

@PartitionKey(0)
@Column(name = InfoPcodeTable.PCODE1)
private String pcode1;

@ClusteringColumn(0)
@Column(name = InfoPcodeTable.PCODE2)
private String pcode2;

@ClusteringColumn(1)
@Column(name = InfoPcodeTable.PCODE3)
private String pcode3;

@Column(name = InfoPcodeTable.PGROUPS)
private Set<String> pgroups;

//@SecondaryIndex
@Column(name = InfoPcodeTable.RECORD_STATE)
private Boolean recordState;
}
