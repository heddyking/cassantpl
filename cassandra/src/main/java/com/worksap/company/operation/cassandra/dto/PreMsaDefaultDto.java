package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreMsaDefaultTable;
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
@Table(name = PreMsaDefaultTable._NAME)
public class PreMsaDefaultDto {

@PartitionKey(0)
@Column(name = PreMsaDefaultTable.LANDSCAPE)
private String landscape;
}
