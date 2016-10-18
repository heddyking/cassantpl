package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.AmiMetaDataTable;
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
@Table(name = AmiMetaDataTable._NAME)
public class AmiMetaDataDto {

@PartitionKey(0)
@Column(name = AmiMetaDataTable.PTK)
private String ptk;

@ClusteringColumn(0)
@Column(name = AmiMetaDataTable.IMAGE_ID)
private String imageId;

@Column(name = AmiMetaDataTable.ARCHITECTURE)
private String architecture;

@Column(name = AmiMetaDataTable.DESCRIPTION)
private String description;

@Column(name = AmiMetaDataTable.HYPERVISOR)
private String hypervisor;

@Column(name = AmiMetaDataTable.IMAGE_LOCATION)
private String imageLocation;

@Column(name = AmiMetaDataTable.IMAGE_TYPE)
private String imageType;

@Column(name = AmiMetaDataTable.NAME)
private String name;

@Column(name = AmiMetaDataTable.OWNER_ID)
private String ownerId;

@Column(name = AmiMetaDataTable.STATE)
private String state;

@Column(name = AmiMetaDataTable.TS)
private Date ts;

@Column(name = AmiMetaDataTable.VIRTUALIZATION_TYPE)
private String virtualizationType;
}
