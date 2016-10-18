package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.InfoOperatorTable;
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
@Table(name = InfoOperatorTable._NAME)
public class InfoOperatorDto {

@PartitionKey(0)
@Column(name = InfoOperatorTable.OPERATOR_ID)
private String operatorId;

@Column(name = InfoOperatorTable.CREATED_AT)
private Date createdAt;

@Column(name = InfoOperatorTable.HASH)
private ByteBuffer hash;

@Column(name = InfoOperatorTable.OPERATOR_DEPARTMENT)
private String operatorDepartment;

@Column(name = InfoOperatorTable.OPERATOR_EMAIL)
private String operatorEmail;

@Column(name = InfoOperatorTable.OPERATOR_NAME)
private String operatorName;

@Column(name = InfoOperatorTable.OPERATOR_TELEPHONE)
private String operatorTelephone;

//@SecondaryIndex
@Column(name = InfoOperatorTable.RECORD_STATE)
private Boolean recordState;

@Column(name = InfoOperatorTable.SALT)
private ByteBuffer salt;
}
