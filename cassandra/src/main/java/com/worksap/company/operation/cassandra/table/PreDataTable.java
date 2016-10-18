package com.worksap.company.operation.cassandra.table;

/**
 * @generated 
 */
public interface PreDataTable {

    public final String _NAME="pre_data";

    public final String TENANT_ID="tenant_id";

    public final String LANDSCAPE="landscape";

    public final String TS="ts";

    public final String AWS_ACCESS_KEY_ID="aws_access_key_id";

    public final String AWS_GENERAL_KEYPAIR="aws_general_keypair";

    public final String AWS_INSTANCE_PREFIX="aws_instance_prefix";

    public final String AWS_SECRET_ACCESS_KEY="aws_secret_access_key";

    public final String AWS_VPC_INDEX="aws_vpc_index";

    public final String AWS_WORK_TERMINAL_KEYPAIR="aws_work_terminal_keypair";

    public final String CASSANDRA_CLUSTER_PREFIX="cassandra_cluster_prefix";

    public final String CASSANDRA_HOSTS_AC_COMMON1="cassandra_hosts_ac_common1";

    public final String CASSANDRA_HOSTS_AC_COMMON2="cassandra_hosts_ac_common2";

    public final String CASSANDRA_HOSTS_AC_COMMON3="cassandra_hosts_ac_common3";

    public final String CASSANDRA_HOSTS_BT="cassandra_hosts_bt";

    public final String CASSANDRA_HOSTS_HR_COMMON1="cassandra_hosts_hr_common1";

    public final String CASSANDRA_HOSTS_HR_COMMON2="cassandra_hosts_hr_common2";

    public final String CASSANDRA_JMX_PASSWORD="cassandra_jmx_password";

    public final String CASSANDRA_KEYSPACE_NAME="cassandra_keyspace_name";

    public final String CASSANDRA_REPLICATION_FACTOR="cassandra_replication_factor";

    public final String CONFIG_SERVER_GIT_REPOSITORY="config_server_git_repository";

    public final String CONFIG_SERVER_LOCAL_GIT_DIR="config_server_local_git_dir";

    public final String CONFIG_SERVER_URL="config_server_url";

    public final String DATASYNC_HUE_DOMAIN="datasync_hue_domain";

    public final String DICINGSEARCH_API_KEY="dicingsearch_api_key";

    public final String DOCKER_REGISTRY_S3_ACCESS_KEY_ID="docker_registry_s3_access_key_id";

    public final String DOCKER_REGISTRY_S3_BUCKET_NAME="docker_registry_s3_bucket_name";

    public final String DOCKER_REGISTRY_S3_REGION="docker_registry_s3_region";

    public final String DOCKER_REGISTRY_S3_SECRET_ACCESS_KEY="docker_registry_s3_secret_access_key";

    public final String EDP2_CONFIGBRANCH="edp2_configbranch";

    public final String EDP2_WEBSERVER_URL="edp2_webserver_url";

    public final String EKISPA_URL="ekispa_url";

    public final String ELASTICSEARCH_CLUSTER_NAME="elasticsearch_cluster_name";

    public final String ELASTICSEARCH_HOST="elasticsearch_host";

    public final String ELASTICSEARCH_INDEX_NAME="elasticsearch_index_name";

    public final String ELASTICSEARCH_INSTALL_FROM_SCRATCH="elasticsearch_install_from_scratch";

    public final String ENABLE_CASSANDRA_JMX="enable_cassandra_jmx";

    public final String FLOW_ID="flow_id";

    public final String FRONT_ELB_ACCESSIBLE_CIDR_LIST="front_elb_accessible_cidr_list";

    public final String GIT_SERVER_HTTP_AUTH_PASS="git_server_http_auth_pass";

    public final String GIT_SERVER_HTTP_AUTH_USER="git_server_http_auth_user";

    public final String GIT_SERVER_REPOSITORY_PATH="git_server_repository_path";

    public final String HDFS_NAMENODE_IP="hdfs_namenode_ip";

    public final String HUE_BT_VERSION="hue_bt_version";

    public final String HUE_CONTEXT_PATH="hue_context_path";

    public final String HUE_PRODUCT_VERSION="hue_product_version";

    public final String HUEDRIVE_S3_ACCESS_KEY_ID="huedrive_s3_access_key_id";

    public final String HUEDRIVE_S3_BUCKET_NAME="huedrive_s3_bucket_name";

    public final String HUEDRIVE_S3_REGION="huedrive_s3_region";

    public final String HUEDRIVE_S3_SECRET_ACCESS_KEY="huedrive_s3_secret_access_key";

    public final String HUELOG_S3_ACCESS_KEY_ID="huelog_s3_access_key_id";

    public final String HUELOG_S3_BUCKET_NAME="huelog_s3_bucket_name";

    public final String HUELOG_S3_REGION="huelog_s3_region";

    public final String HUELOG_S3_SECRET_ACCESS_KEY="huelog_s3_secret_access_key";

    public final String HUEPREHEAT_S3_ACCESS_KEY_ID="huepreheat_s3_access_key_id";

    public final String HUEPREHEAT_S3_BUCKET_NAME="huepreheat_s3_bucket_name";

    public final String HUEPREHEAT_S3_REGION="huepreheat_s3_region";

    public final String HUEPREHEAT_S3_SECRET_ACCESS_KEY="huepreheat_s3_secret_access_key";

    public final String KAFKA_HOSTS="kafka_hosts";

    public final String LANDSCAPE_NAME="landscape_name";

    public final String LOGMANAGER_HOST="logmanager_host";

    public final String LOGMANAGER_PORT="logmanager_port";

    public final String MAILMAN_API_PASS="mailman_api_pass";

    public final String MAILMAN_API_USER="mailman_api_user";

    public final String MAILMAN_HOST="mailman_host";

    public final String MAILMAN_PORT="mailman_port";

    public final String MAILMAN_VERSION="mailman_version";

    public final String MIGRATE_TO_VERSION="migrate_to_version";

    public final String MIGRATOR_VERSION="migrator_version";

    public final String NGINX_NODE_PORT="nginx_node_port";

    public final String NUMBER_OF_USERS="number_of_users";

    public final String OCRUS_WEB_HOSTNAME="ocrus_web_hostname";

    public final String POSTGRES_IP="postgres_ip";

    public final String POSTGRESQL_HOST="postgresql_host";

    public final String POSTGRESQL_PORT="postgresql_port";

    public final String POSTGRESQL_TENANT_ID="postgresql_tenant_id";

    public final String REDIS_HOST="redis_host";

    public final String REMOTE_BATCH_JAR_DIR="remote_batch_jar_dir";

    public final String REMOTE_PROPERTY_FILE_DIR="remote_property_file_dir";

    public final String REMOTE_SHIPMENT_FILE_DIR="remote_shipment_file_dir";

    public final String SHIPMENT_S3_ACCESS_KEY_ID="shipment_s3_access_key_id";

    public final String SHIPMENT_S3_BUCKET_NAME="shipment_s3_bucket_name";

    public final String SHIPMENT_S3_REGION="shipment_s3_region";

    public final String SHIPMENT_S3_SECRET_ACCESS_KEY="shipment_s3_secret_access_key";

    public final String SMTP_HOST="smtp_host";

    public final String TENANT_ACCOUNT="tenant_account";

    public final String TENANT_NAME="tenant_name";

    public final String TERMINAL_CURRENT_BATCH_JAR_DIR="terminal_current_batch_jar_dir";

    public final String TERMINAL_CURRENT_CASSANDRA_DIR="terminal_current_cassandra_dir";

    public final String TERMINAL_CURRENT_EDP2_DIR="terminal_current_edp2_dir";

    public final String TERMINAL_CURRENT_ELASTICSEARCH_DIR="terminal_current_elasticsearch_dir";

    public final String TERMINAL_CURRENT_SHIPMENT_FILE_DIR="terminal_current_shipment_file_dir";

    public final String TERMINAL_SHIPMENT_FILE_DIR="terminal_shipment_file_dir";

    public final String USE_SELF_SIGNED_CERTIFICATES="use_self_signed_certificates";

    public final String USER_ID="user_id";

    public final String VERSION="version";

    public final String VPC_IP_PREFIX="vpc_ip_prefix";

    public final String WINDOWS_WORK_TERMINAL_AMI_ID="windows_work_terminal_ami_id";

    public final String YARN_RESOUCE_MANAGER_IP="yarn_resouce_manager_ip";

    public final String ZOOKEEPER_CLUSTER="zookeeper_cluster";

    public final String ZOOKEEPER_NODES="zookeeper_nodes";
}
