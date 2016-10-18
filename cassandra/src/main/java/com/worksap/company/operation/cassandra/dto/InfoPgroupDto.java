package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.InfoPgroupTable;
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
@Table(name = InfoPgroupTable._NAME)
public class InfoPgroupDto {

@PartitionKey(0)
@Column(name = InfoPgroupTable.PGROUP)
private String pgroup;

@Column(name = InfoPgroupTable.PCODES)
private Set<String> pcodes;

//@SecondaryIndex
@Column(name = InfoPgroupTable.RECORD_STATE)
private Boolean recordState;
}
