package com.worksap.company.operation.cassandra.dto;

import com.worksap.company.operation.cassandra.table.PreDataTable;
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
@Table(name = PreDataTable._NAME)
public class PreDataDto {

@PartitionKey(0)
@Column(name = PreDataTable.TENANT_ID)
private String tenantId;

@ClusteringColumn(0)
@Column(name = PreDataTable.LANDSCAPE)
private String landscape;

@ClusteringColumn(1)
@Column(name = PreDataTable.TS)
private UUID ts;

@Column(name = PreDataTable.AWS_ACCESS_KEY_ID)
private String awsAccessKeyId;

@Column(name = PreDataTable.AWS_GENERAL_KEYPAIR)
private String awsGeneralKeypair;

@Column(name = PreDataTable.AWS_INSTANCE_PREFIX)
private String awsInstancePrefix;

@Column(name = PreDataTable.AWS_SECRET_ACCESS_KEY)
private String awsSecretAccessKey;

@Column(name = PreDataTable.AWS_VPC_INDEX)
private String awsVpcIndex;

@Column(name = PreDataTable.AWS_WORK_TERMINAL_KEYPAIR)
private String awsWorkTerminalKeypair;

@Column(name = PreDataTable.CASSANDRA_CLUSTER_PREFIX)
private String cassandraClusterPrefix;

@Column(name = PreDataTable.CASSANDRA_HOSTS_AC_COMMON1)
private String cassandraHostsAcCommon1;

@Column(name = PreDataTable.CASSANDRA_HOSTS_AC_COMMON2)
private String cassandraHostsAcCommon2;

@Column(name = PreDataTable.CASSANDRA_HOSTS_AC_COMMON3)
private String cassandraHostsAcCommon3;

@Column(name = PreDataTable.CASSANDRA_HOSTS_BT)
private String cassandraHostsBt;

@Column(name = PreDataTable.CASSANDRA_HOSTS_HR_COMMON1)
private String cassandraHostsHrCommon1;

@Column(name = PreDataTable.CASSANDRA_HOSTS_HR_COMMON2)
private String cassandraHostsHrCommon2;

@Column(name = PreDataTable.CASSANDRA_JMX_PASSWORD)
private String cassandraJmxPassword;

@Column(name = PreDataTable.CASSANDRA_KEYSPACE_NAME)
private String cassandraKeyspaceName;

@Column(name = PreDataTable.CASSANDRA_REPLICATION_FACTOR)
private String cassandraReplicationFactor;

@Column(name = PreDataTable.CONFIG_SERVER_GIT_REPOSITORY)
private String configServerGitRepository;

@Column(name = PreDataTable.CONFIG_SERVER_LOCAL_GIT_DIR)
private String configServerLocalGitDir;

@Column(name = PreDataTable.CONFIG_SERVER_URL)
private String configServerUrl;

@Column(name = PreDataTable.DATASYNC_HUE_DOMAIN)
private String datasyncHueDomain;

@Column(name = PreDataTable.DICINGSEARCH_API_KEY)
private String dicingsearchApiKey;

@Column(name = PreDataTable.DOCKER_REGISTRY_S3_ACCESS_KEY_ID)
private String dockerRegistryS3AccessKeyId;

@Column(name = PreDataTable.DOCKER_REGISTRY_S3_BUCKET_NAME)
private String dockerRegistryS3BucketName;

@Column(name = PreDataTable.DOCKER_REGISTRY_S3_REGION)
private String dockerRegistryS3Region;

@Column(name = PreDataTable.DOCKER_REGISTRY_S3_SECRET_ACCESS_KEY)
private String dockerRegistryS3SecretAccessKey;

@Column(name = PreDataTable.EDP2_CONFIGBRANCH)
private String edp2Configbranch;

@Column(name = PreDataTable.EDP2_WEBSERVER_URL)
private String edp2WebserverUrl;

@Column(name = PreDataTable.EKISPA_URL)
private String ekispaUrl;

@Column(name = PreDataTable.ELASTICSEARCH_CLUSTER_NAME)
private String elasticsearchClusterName;

@Column(name = PreDataTable.ELASTICSEARCH_HOST)
private String elasticsearchHost;

@Column(name = PreDataTable.ELASTICSEARCH_INDEX_NAME)
private String elasticsearchIndexName;

@Column(name = PreDataTable.ELASTICSEARCH_INSTALL_FROM_SCRATCH)
private String elasticsearchInstallFromScratch;

@Column(name = PreDataTable.ENABLE_CASSANDRA_JMX)
private String enableCassandraJmx;

@Column(name = PreDataTable.FLOW_ID)
private String flowId;

@Column(name = PreDataTable.FRONT_ELB_ACCESSIBLE_CIDR_LIST)
private String frontElbAccessibleCidrList;

@Column(name = PreDataTable.GIT_SERVER_HTTP_AUTH_PASS)
private String gitServerHttpAuthPass;

@Column(name = PreDataTable.GIT_SERVER_HTTP_AUTH_USER)
private String gitServerHttpAuthUser;

@Column(name = PreDataTable.GIT_SERVER_REPOSITORY_PATH)
private String gitServerRepositoryPath;

@Column(name = PreDataTable.HDFS_NAMENODE_IP)
private String hdfsNamenodeIp;

@Column(name = PreDataTable.HUE_BT_VERSION)
private String hueBtVersion;

@Column(name = PreDataTable.HUE_CONTEXT_PATH)
private String hueContextPath;

@Column(name = PreDataTable.HUE_PRODUCT_VERSION)
private String hueProductVersion;

@Column(name = PreDataTable.HUEDRIVE_S3_ACCESS_KEY_ID)
private String huedriveS3AccessKeyId;

@Column(name = PreDataTable.HUEDRIVE_S3_BUCKET_NAME)
private String huedriveS3BucketName;

@Column(name = PreDataTable.HUEDRIVE_S3_REGION)
private String huedriveS3Region;

@Column(name = PreDataTable.HUEDRIVE_S3_SECRET_ACCESS_KEY)
private String huedriveS3SecretAccessKey;

@Column(name = PreDataTable.HUELOG_S3_ACCESS_KEY_ID)
private String huelogS3AccessKeyId;

@Column(name = PreDataTable.HUELOG_S3_BUCKET_NAME)
private String huelogS3BucketName;

@Column(name = PreDataTable.HUELOG_S3_REGION)
private String huelogS3Region;

@Column(name = PreDataTable.HUELOG_S3_SECRET_ACCESS_KEY)
private String huelogS3SecretAccessKey;

@Column(name = PreDataTable.HUEPREHEAT_S3_ACCESS_KEY_ID)
private String huepreheatS3AccessKeyId;

@Column(name = PreDataTable.HUEPREHEAT_S3_BUCKET_NAME)
private String huepreheatS3BucketName;

@Column(name = PreDataTable.HUEPREHEAT_S3_REGION)
private String huepreheatS3Region;

@Column(name = PreDataTable.HUEPREHEAT_S3_SECRET_ACCESS_KEY)
private String huepreheatS3SecretAccessKey;

@Column(name = PreDataTable.KAFKA_HOSTS)
private String kafkaHosts;

@Column(name = PreDataTable.LANDSCAPE_NAME)
private String landscapeName;

@Column(name = PreDataTable.LOGMANAGER_HOST)
private String logmanagerHost;

@Column(name = PreDataTable.LOGMANAGER_PORT)
private String logmanagerPort;

@Column(name = PreDataTable.MAILMAN_API_PASS)
private String mailmanApiPass;

@Column(name = PreDataTable.MAILMAN_API_USER)
private String mailmanApiUser;

@Column(name = PreDataTable.MAILMAN_HOST)
private String mailmanHost;

@Column(name = PreDataTable.MAILMAN_PORT)
private String mailmanPort;

@Column(name = PreDataTable.MAILMAN_VERSION)
private String mailmanVersion;

@Column(name = PreDataTable.MIGRATE_TO_VERSION)
private String migrateToVersion;

@Column(name = PreDataTable.MIGRATOR_VERSION)
private String migratorVersion;

@Column(name = PreDataTable.NGINX_NODE_PORT)
private String nginxNodePort;

@Column(name = PreDataTable.NUMBER_OF_USERS)
private String numberOfUsers;

@Column(name = PreDataTable.OCRUS_WEB_HOSTNAME)
private String ocrusWebHostname;

@Column(name = PreDataTable.POSTGRES_IP)
private String postgresIp;

@Column(name = PreDataTable.POSTGRESQL_HOST)
private String postgresqlHost;

@Column(name = PreDataTable.POSTGRESQL_PORT)
private String postgresqlPort;

@Column(name = PreDataTable.POSTGRESQL_TENANT_ID)
private String postgresqlTenantId;

@Column(name = PreDataTable.REDIS_HOST)
private String redisHost;

@Column(name = PreDataTable.REMOTE_BATCH_JAR_DIR)
private String remoteBatchJarDir;

@Column(name = PreDataTable.REMOTE_PROPERTY_FILE_DIR)
private String remotePropertyFileDir;

@Column(name = PreDataTable.REMOTE_SHIPMENT_FILE_DIR)
private String remoteShipmentFileDir;

@Column(name = PreDataTable.SHIPMENT_S3_ACCESS_KEY_ID)
private String shipmentS3AccessKeyId;

@Column(name = PreDataTable.SHIPMENT_S3_BUCKET_NAME)
private String shipmentS3BucketName;

@Column(name = PreDataTable.SHIPMENT_S3_REGION)
private String shipmentS3Region;

@Column(name = PreDataTable.SHIPMENT_S3_SECRET_ACCESS_KEY)
private String shipmentS3SecretAccessKey;

@Column(name = PreDataTable.SMTP_HOST)
private String smtpHost;

@Column(name = PreDataTable.TENANT_ACCOUNT)
private String tenantAccount;

@Column(name = PreDataTable.TENANT_NAME)
private String tenantName;

@Column(name = PreDataTable.TERMINAL_CURRENT_BATCH_JAR_DIR)
private String terminalCurrentBatchJarDir;

@Column(name = PreDataTable.TERMINAL_CURRENT_CASSANDRA_DIR)
private String terminalCurrentCassandraDir;

@Column(name = PreDataTable.TERMINAL_CURRENT_EDP2_DIR)
private String terminalCurrentEdp2Dir;

@Column(name = PreDataTable.TERMINAL_CURRENT_ELASTICSEARCH_DIR)
private String terminalCurrentElasticsearchDir;

@Column(name = PreDataTable.TERMINAL_CURRENT_SHIPMENT_FILE_DIR)
private String terminalCurrentShipmentFileDir;

@Column(name = PreDataTable.TERMINAL_SHIPMENT_FILE_DIR)
private String terminalShipmentFileDir;

@Column(name = PreDataTable.USE_SELF_SIGNED_CERTIFICATES)
private String useSelfSignedCertificates;

@Column(name = PreDataTable.USER_ID)
private String userId;

@Column(name = PreDataTable.VERSION)
private String version;

@Column(name = PreDataTable.VPC_IP_PREFIX)
private String vpcIpPrefix;

@Column(name = PreDataTable.WINDOWS_WORK_TERMINAL_AMI_ID)
private String windowsWorkTerminalAmiId;

@Column(name = PreDataTable.YARN_RESOUCE_MANAGER_IP)
private String yarnResouceManagerIp;

@Column(name = PreDataTable.ZOOKEEPER_CLUSTER)
private String zookeeperCluster;

@Column(name = PreDataTable.ZOOKEEPER_NODES)
private String zookeeperNodes;
}
