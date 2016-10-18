package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreDataDefaultTable;
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
@Table(name = PreDataDefaultTable._NAME)
public class PreDataDefaultDto {

@PartitionKey(0)
@Column(name = PreDataDefaultTable.LANDSCAPE)
private String landscape;

@Column(name = PreDataDefaultTable.AWS_ACCESS_KEY_ID)
private String awsAccessKeyId;

@Column(name = PreDataDefaultTable.AWS_GENERAL_KEYPAIR)
private String awsGeneralKeypair;

@Column(name = PreDataDefaultTable.AWS_INSTANCE_PREFIX)
private String awsInstancePrefix;

@Column(name = PreDataDefaultTable.AWS_SECRET_ACCESS_KEY)
private String awsSecretAccessKey;

@Column(name = PreDataDefaultTable.AWS_WORK_TERMINAL_KEYPAIR)
private String awsWorkTerminalKeypair;

@Column(name = PreDataDefaultTable.CASSANDRA_CLUSTER_PREFIX)
private String cassandraClusterPrefix;

@Column(name = PreDataDefaultTable.CASSANDRA_JMX_PASSWORD)
private String cassandraJmxPassword;

@Column(name = PreDataDefaultTable.CASSANDRA_KEYSPACE_NAME)
private String cassandraKeyspaceName;

@Column(name = PreDataDefaultTable.CASSANDRA_REPLICATION_FACTOR)
private String cassandraReplicationFactor;

@Column(name = PreDataDefaultTable.CONFIG_SERVER_GIT_REPOSITORY)
private String configServerGitRepository;

@Column(name = PreDataDefaultTable.CONFIG_SERVER_LOCAL_GIT_DIR)
private String configServerLocalGitDir;

@Column(name = PreDataDefaultTable.DICINGSEARCH_API_KEY)
private String dicingsearchApiKey;

@Column(name = PreDataDefaultTable.DOCKER_REGISTRY_S3_ACCESS_KEY_ID)
private String dockerRegistryS3AccessKeyId;

@Column(name = PreDataDefaultTable.DOCKER_REGISTRY_S3_BUCKET_NAME)
private String dockerRegistryS3BucketName;

@Column(name = PreDataDefaultTable.DOCKER_REGISTRY_S3_REGION)
private String dockerRegistryS3Region;

@Column(name = PreDataDefaultTable.DOCKER_REGISTRY_S3_SECRET_ACCESS_KEY)
private String dockerRegistryS3SecretAccessKey;

@Column(name = PreDataDefaultTable.EDP2_CONFIGBRANCH)
private String edp2Configbranch;

@Column(name = PreDataDefaultTable.EKISPA_URL)
private String ekispaUrl;

@Column(name = PreDataDefaultTable.ELASTICSEARCH_INDEX_NAME)
private String elasticsearchIndexName;

@Column(name = PreDataDefaultTable.ELASTICSEARCH_INSTALL_FROM_SCRATCH)
private String elasticsearchInstallFromScratch;

@Column(name = PreDataDefaultTable.ENABLE_CASSANDRA_JMX)
private String enableCassandraJmx;

@Column(name = PreDataDefaultTable.GIT_SERVER_HTTP_AUTH_PASS)
private String gitServerHttpAuthPass;

@Column(name = PreDataDefaultTable.GIT_SERVER_HTTP_AUTH_USER)
private String gitServerHttpAuthUser;

@Column(name = PreDataDefaultTable.GIT_SERVER_REPOSITORY_PATH)
private String gitServerRepositoryPath;

@Column(name = PreDataDefaultTable.HUE_CONTEXT_PATH)
private String hueContextPath;

@Column(name = PreDataDefaultTable.HUEDRIVE_S3_ACCESS_KEY_ID)
private String huedriveS3AccessKeyId;

@Column(name = PreDataDefaultTable.HUEDRIVE_S3_BUCKET_NAME)
private String huedriveS3BucketName;

@Column(name = PreDataDefaultTable.HUEDRIVE_S3_REGION)
private String huedriveS3Region;

@Column(name = PreDataDefaultTable.HUEDRIVE_S3_SECRET_ACCESS_KEY)
private String huedriveS3SecretAccessKey;

@Column(name = PreDataDefaultTable.HUELOG_S3_ACCESS_KEY_ID)
private String huelogS3AccessKeyId;

@Column(name = PreDataDefaultTable.HUELOG_S3_BUCKET_NAME)
private String huelogS3BucketName;

@Column(name = PreDataDefaultTable.HUELOG_S3_REGION)
private String huelogS3Region;

@Column(name = PreDataDefaultTable.HUELOG_S3_SECRET_ACCESS_KEY)
private String huelogS3SecretAccessKey;

@Column(name = PreDataDefaultTable.HUEPREHEAT_S3_ACCESS_KEY_ID)
private String huepreheatS3AccessKeyId;

@Column(name = PreDataDefaultTable.HUEPREHEAT_S3_BUCKET_NAME)
private String huepreheatS3BucketName;

@Column(name = PreDataDefaultTable.HUEPREHEAT_S3_REGION)
private String huepreheatS3Region;

@Column(name = PreDataDefaultTable.HUEPREHEAT_S3_SECRET_ACCESS_KEY)
private String huepreheatS3SecretAccessKey;

@Column(name = PreDataDefaultTable.LOGMANAGER_PORT)
private String logmanagerPort;

@Column(name = PreDataDefaultTable.MAILMAN_API_PASS)
private String mailmanApiPass;

@Column(name = PreDataDefaultTable.MAILMAN_API_USER)
private String mailmanApiUser;

@Column(name = PreDataDefaultTable.MAILMAN_PORT)
private String mailmanPort;

@Column(name = PreDataDefaultTable.MAILMAN_VERSION)
private String mailmanVersion;

@Column(name = PreDataDefaultTable.NGINX_NODE_PORT)
private String nginxNodePort;

@Column(name = PreDataDefaultTable.OCRUS_WEB_HOSTNAME)
private String ocrusWebHostname;

@Column(name = PreDataDefaultTable.POSTGRES_IP)
private String postgresIp;

@Column(name = PreDataDefaultTable.POSTGRESQL_PORT)
private String postgresqlPort;

@Column(name = PreDataDefaultTable.POSTGRESQL_TENANT_ID)
private String postgresqlTenantId;

@Column(name = PreDataDefaultTable.SHIPMENT_S3_ACCESS_KEY_ID)
private String shipmentS3AccessKeyId;

@Column(name = PreDataDefaultTable.SHIPMENT_S3_BUCKET_NAME)
private String shipmentS3BucketName;

@Column(name = PreDataDefaultTable.SHIPMENT_S3_REGION)
private String shipmentS3Region;

@Column(name = PreDataDefaultTable.SHIPMENT_S3_SECRET_ACCESS_KEY)
private String shipmentS3SecretAccessKey;

@Column(name = PreDataDefaultTable.TERMINAL_SHIPMENT_FILE_DIR)
private String terminalShipmentFileDir;

@Column(name = PreDataDefaultTable.USE_SELF_SIGNED_CERTIFICATES)
private String useSelfSignedCertificates;

@Column(name = PreDataDefaultTable.WINDOWS_WORK_TERMINAL_AMI_ID)
private String windowsWorkTerminalAmiId;
}
