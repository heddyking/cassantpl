drop keyspace if exists elephas;
CREATE KEYSPACE elephas WITH REPLICATION = { 'class' : 'org.apache.cassandra.locator.SimpleStrategy', 'replication_factor': '1' } AND DURABLE_WRITES = true;

CREATE TABLE elephas.pre_data_default (
    landscape text,
    aws_access_key_id text,
    aws_general_keypair text,
    aws_instance_prefix text,
    aws_secret_access_key text,
    aws_work_terminal_keypair text,
    cassandra_cluster_prefix text,
    cassandra_jmx_password text,
    cassandra_keyspace_name text,
    cassandra_replication_factor text,
    config_server_git_repository text,
    config_server_local_git_dir text,
    dicingsearch_api_key text,
    docker_registry_s3_access_key_id text,
    docker_registry_s3_bucket_name text,
    docker_registry_s3_region text,
    docker_registry_s3_secret_access_key text,
    edp2_configbranch text,
    ekispa_url text,
    elasticsearch_index_name text,
    elasticsearch_install_from_scratch text,
    enable_cassandra_jmx text,
    git_server_http_auth_pass text,
    git_server_http_auth_user text,
    git_server_repository_path text,
    hue_context_path text,
    huedrive_s3_access_key_id text,
    huedrive_s3_bucket_name text,
    huedrive_s3_region text,
    huedrive_s3_secret_access_key text,
    huelog_s3_access_key_id text,
    huelog_s3_bucket_name text,
    huelog_s3_region text,
    huelog_s3_secret_access_key text,
    huepreheat_s3_access_key_id text,
    huepreheat_s3_bucket_name text,
    huepreheat_s3_region text,
    huepreheat_s3_secret_access_key text,
    logmanager_port text,
    mailman_api_pass text,
    mailman_api_user text,
    mailman_port text,
    mailman_version text,
    nginx_node_port text,
    ocrus_web_hostname text,
    postgres_ip text,
    postgresql_port text,
    postgresql_tenant_id text,
    shipment_s3_access_key_id text,
    shipment_s3_bucket_name text,
    shipment_s3_region text,
    shipment_s3_secret_access_key text,
    terminal_shipment_file_dir text,
    use_self_signed_certificates text,
    windows_work_terminal_ami_id text,
    PRIMARY KEY (landscape)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.info_pcode (
    pcode1 text,
    pcode2 text,
    pcode3 text,
    pgroups set<text>,
    record_state boolean,
    PRIMARY KEY (pcode1, pcode2, pcode3)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX info_pcode_record_state_idx ON elephas.info_pcode (record_state);

CREATE TABLE elephas.pre_subnet (
    tenant_id text,
    landscape text,
    ts timeuuid,
    subnet_name_suffix text,
    sub_region text,
    subnet_cidr_suffix text,
    PRIMARY KEY (tenant_id, landscape, ts, subnet_name_suffix)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.pre_vpc_default (
    landscape text,
    aws_access_key text,
    aws_secret_key text,
    bucket_name_prefix text,
    cidr_block_suffix text,
    destination_root text,
    igw_name_prefix text,
    ip_prefix text,
    private_ip_address_suffix text,
    private_rt_name_prefix text,
    public_rt_name_prefix text,
    region text,
    security_group_prefix text,
    source_root text,
    vpc_prefix text,
    PRIMARY KEY (landscape)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.aws_instancetype (
    aws_access_key text,
    region text,
    family text,
    instancetype text,
    os_platform text,
    ebs_optimized boolean,
    instance_storage text,
    memory text,
    network text,
    platform text,
    price_on_demand text,
    vcpus text,
    PRIMARY KEY (aws_access_key, region, family, instancetype, os_platform)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.pre_data (
    tenant_id text,
    landscape text,
    ts timeuuid,
    aws_access_key_id text,
    aws_general_keypair text,
    aws_instance_prefix text,
    aws_secret_access_key text,
    aws_vpc_index text,
    aws_work_terminal_keypair text,
    cassandra_cluster_prefix text,
    cassandra_hosts_ac_common1 text,
    cassandra_hosts_ac_common2 text,
    cassandra_hosts_ac_common3 text,
    cassandra_hosts_bt text,
    cassandra_hosts_hr_common1 text,
    cassandra_hosts_hr_common2 text,
    cassandra_jmx_password text,
    cassandra_keyspace_name text,
    cassandra_replication_factor text,
    config_server_git_repository text,
    config_server_local_git_dir text,
    config_server_url text,
    datasync_hue_domain text,
    dicingsearch_api_key text,
    docker_registry_s3_access_key_id text,
    docker_registry_s3_bucket_name text,
    docker_registry_s3_region text,
    docker_registry_s3_secret_access_key text,
    edp2_configbranch text,
    edp2_webserver_url text,
    ekispa_url text,
    elasticsearch_cluster_name text,
    elasticsearch_host text,
    elasticsearch_index_name text,
    elasticsearch_install_from_scratch text,
    enable_cassandra_jmx text,
    flow_id text,
    front_elb_accessible_cidr_list text,
    git_server_http_auth_pass text,
    git_server_http_auth_user text,
    git_server_repository_path text,
    hdfs_namenode_ip text,
    hue_bt_version text,
    hue_context_path text,
    hue_product_version text,
    huedrive_s3_access_key_id text,
    huedrive_s3_bucket_name text,
    huedrive_s3_region text,
    huedrive_s3_secret_access_key text,
    huelog_s3_access_key_id text,
    huelog_s3_bucket_name text,
    huelog_s3_region text,
    huelog_s3_secret_access_key text,
    huepreheat_s3_access_key_id text,
    huepreheat_s3_bucket_name text,
    huepreheat_s3_region text,
    huepreheat_s3_secret_access_key text,
    kafka_hosts text,
    landscape_name text,
    logmanager_host text,
    logmanager_port text,
    mailman_api_pass text,
    mailman_api_user text,
    mailman_host text,
    mailman_port text,
    mailman_version text,
    migrate_to_version text,
    migrator_version text,
    nginx_node_port text,
    number_of_users text,
    ocrus_web_hostname text,
    postgres_ip text,
    postgresql_host text,
    postgresql_port text,
    postgresql_tenant_id text,
    redis_host text,
    remote_batch_jar_dir text,
    remote_property_file_dir text,
    remote_shipment_file_dir text,
    shipment_s3_access_key_id text,
    shipment_s3_bucket_name text,
    shipment_s3_region text,
    shipment_s3_secret_access_key text,
    smtp_host text,
    tenant_account text,
    tenant_name text,
    terminal_current_batch_jar_dir text,
    terminal_current_cassandra_dir text,
    terminal_current_edp2_dir text,
    terminal_current_elasticsearch_dir text,
    terminal_current_shipment_file_dir text,
    terminal_shipment_file_dir text,
    use_self_signed_certificates text,
    user_id text,
    version text,
    vpc_ip_prefix text,
    windows_work_terminal_ami_id text,
    yarn_resouce_manager_ip text,
    zookeeper_cluster text,
    zookeeper_nodes text,
    PRIMARY KEY (tenant_id, landscape, ts)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.info_operator (
    operator_id text,
    created_at timestamp,
    hash blob,
    operator_department text,
    operator_email text,
    operator_name text,
    operator_telephone text,
    record_state boolean,
    salt blob,
    PRIMARY KEY (operator_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX info_operator_record_state_idx ON elephas.info_operator (record_state);

CREATE TABLE elephas.post_instance (
    tenant_id text,
    landscape text,
    ts timeuuid,
    instance_id text,
    ami_launch_index int,
    architecture text,
    client_token text,
    ebs_optimized boolean,
    groups list<frozen<map<text, text>>>,
    hypervisor text,
    image_id text,
    instance_name_suffix text,
    instance_profile text,
    instance_type text,
    interfaces list<frozen<map<text, text>>>,
    kernel text,
    key_name text,
    launch_time timestamp,
    monitoring_state text,
    persistent boolean,
    placement map<text, text>,
    private_dns_name text,
    private_ip_address text,
    public_dns_name text,
    ramdisk text,
    region text,
    requester_id text,
    root_device_type text,
    source_destination_check boolean,
    spot_instance_request_id text,
    state text,
    tags map<text, text>,
    virtualization_type text,
    volumes list<frozen<map<text, text>>>,
    vpc_id text,
    PRIMARY KEY (tenant_id, landscape, ts, instance_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX post_instance_vpc_id_idx ON elephas.post_instance (vpc_id);

CREATE TABLE elephas.pre_instance_default (
    landscape text,
    instance_name_suffix text,
    image_id text,
    instance_type text,
    key_name text,
    num int,
    volumes list<frozen<map<text, text>>>,
    PRIMARY KEY (landscape, instance_name_suffix)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.info_corporation (
    corporation_id text,
    corporation_address text,
    corporation_email text,
    corporation_name text,
    corporation_phone text,
    created_at timestamp,
    record_state boolean,
    PRIMARY KEY (corporation_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX info_corporation_record_state_idx ON elephas.info_corporation (record_state);

CREATE TABLE elephas.aws_key (
    ptk text,
    aws_access_key text,
    aws_secret_key text,
    PRIMARY KEY (ptk, aws_access_key, aws_secret_key)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.idx_tenant_landscape_current (
    tenant_id text,
    landscape text,
    try_ts timeuuid,
    try_type text,
    ts timeuuid,
    PRIMARY KEY (tenant_id, landscape)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.docker_meta_data (
    ptk text,
    namespace text,
    repository text,
    tags list<text>,
    ts timestamp,
    PRIMARY KEY (ptk, namespace, repository)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.info_landscape (
    ptk text,
    landscape text,
    description text,
    record_state boolean,
    PRIMARY KEY (ptk, landscape)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX info_landscape_record_state_idx ON elephas.info_landscape (record_state);

CREATE TABLE elephas.post_elb (
    tenant_id text,
    landscape text,
    ts timeuuid,
    elb_name text,
    canonical_hosted_zone_name text,
    canonical_hosted_zone_name_id text,
    dns_name text,
    health_check map<text, text>,
    instances list<text>,
    instances_inservice list<text>,
    instances_inservice_count int,
    instances_inservice_percent double,
    instances_outofservice list<text>,
    instances_outofservice_count int,
    listeners list<frozen<map<text, text>>>,
    scheme text,
    security_groups list<text>,
    subnets list<text>,
    vpc_id text,
    zones list<text>,
    PRIMARY KEY (tenant_id, landscape, ts, elb_name)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX post_elb_vpc_id_idx ON elephas.post_elb (vpc_id);

CREATE TABLE elephas.idx_operator_permission (
    operator_id text,
    tenant_id text,
    landscape text,
    pgroup text,
    PRIMARY KEY (operator_id, tenant_id, landscape, pgroup)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.pre_security (
    tenant_id text,
    landscape text,
    ts timeuuid,
    security_name_prefix text,
    cidr_ip text,
    from_port text,
    proto text,
    to_port text,
    PRIMARY KEY (tenant_id, landscape, ts, security_name_prefix)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.info_tenant_sublicense (
    tenant_id text,
    sublicense_id uuid,
    record_state boolean,
    sublicense_end_time timestamp,
    sublicense_name map<text, text>,
    sublicense_start_time timestamp,
    sublicense_usernum int,
    PRIMARY KEY (tenant_id, sublicense_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX info_tenant_sublicense_record_state_idx ON elephas.info_tenant_sublicense (record_state);

CREATE TABLE elephas.info_license (
    ptk text,
    license_id uuid,
    license_detail text,
    license_name map<text, text>,
    record_state boolean,
    PRIMARY KEY (ptk, license_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX info_license_record_state_idx ON elephas.info_license (record_state);

CREATE TABLE elephas.pre_msa (
    tenant_id text,
    landscape text,
    ts timeuuid,
    PRIMARY KEY (tenant_id, landscape, ts)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.pre_subnet_default (
    landscape text,
    subnet_name_suffix text,
    sub_region text,
    subnet_cidr_suffix text,
    PRIMARY KEY (landscape, subnet_name_suffix)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.post_subnet (
    tenant_id text,
    landscape text,
    ts timeuuid,
    subnet_id text,
    availability_zone text,
    available_ip_address_count int,
    cidr_block text,
    default_for_az boolean,
    map_public_ip_on_launch boolean,
    state text,
    sub_region text,
    subnet_cidr_suffix text,
    subnet_name_suffix text,
    tags map<text, text>,
    vpc_id text,
    PRIMARY KEY (tenant_id, landscape, ts, subnet_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX post_subnet_vpc_id_idx ON elephas.post_subnet (vpc_id);

CREATE TABLE elephas.jar_meta_data (
    ptk text,
    group_id text,
    artifact_id text,
    version text,
    jar text,
    nexus text,
    org text,
    ts timestamp,
    url text,
    PRIMARY KEY (ptk, group_id, artifact_id, version)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.post_security (
    tenant_id text,
    landscape text,
    ts timeuuid,
    security_id text,
    cidr_ip text,
    from_port text,
    proto text,
    security_name_prefix text,
    to_port text,
    vpc_id text,
    PRIMARY KEY (tenant_id, landscape, ts, security_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX post_security_vpc_id_idx ON elephas.post_security (vpc_id);

CREATE TABLE elephas.post_vpc (
    tenant_id text,
    landscape text,
    ts timeuuid,
    aws_access_key text,
    aws_secret_key text,
    bucket_name_prefix text,
    cidr_block_suffix text,
    destination_root text,
    igw_name_prefix text,
    ip_prefix text,
    private_ip_address_suffix text,
    private_rt_name_prefix text,
    public_rt_name_prefix text,
    region text,
    security_group_prefix text,
    source_root text,
    vpc_id text,
    vpc_prefix text,
    PRIMARY KEY (tenant_id, landscape, ts)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX post_vpc_vpc_id_idx ON elephas.post_vpc (vpc_id);

CREATE TABLE elephas.pre_msa_default (
    landscape text,
    PRIMARY KEY (landscape)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.ami_meta_data (
    ptk text,
    image_id text,
    architecture text,
    description text,
    hypervisor text,
    image_location text,
    image_type text,
    name text,
    owner_id text,
    state text,
    ts timestamp,
    virtualization_type text,
    PRIMARY KEY (ptk, image_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.pre_security_default (
    landscape text,
    security_name_prefix text,
    cidr_ip text,
    from_port text,
    proto text,
    to_port text,
    PRIMARY KEY (landscape, security_name_prefix)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.info_pgroup (
    pgroup text,
    pcodes set<text>,
    record_state boolean,
    PRIMARY KEY (pgroup)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX info_pgroup_record_state_idx ON elephas.info_pgroup (record_state);

CREATE TABLE elephas.pre_vpc (
    tenant_id text,
    landscape text,
    ts timeuuid,
    aws_access_key text,
    aws_secret_key text,
    bucket_name_prefix text,
    cidr_block_suffix text,
    destination_root text,
    igw_name_prefix text,
    ip_prefix text,
    private_ip_address_suffix text,
    private_rt_name_prefix text,
    public_rt_name_prefix text,
    region text,
    security_group_prefix text,
    source_root text,
    vpc_prefix text,
    PRIMARY KEY (tenant_id, landscape, ts)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.aws_region (
    ptk text,
    region text,
    PRIMARY KEY (ptk, region)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.post_route (
    tenant_id text,
    landscape text,
    ts timeuuid,
    route_id text,
    routes list<frozen<map<text, text>>>,
    tags map<text, text>,
    vpc_id text,
    PRIMARY KEY (tenant_id, landscape, ts, route_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX post_route_vpc_id_idx ON elephas.post_route (vpc_id);

CREATE TABLE elephas.pre_instance (
    tenant_id text,
    landscape text,
    ts timeuuid,
    instance_name_suffix text,
    image_id text,
    instance_type text,
    key_name text,
    num int,
    volumes list<frozen<map<text, text>>>,
    PRIMARY KEY (tenant_id, landscape, ts, instance_name_suffix)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.aws_ami (
    aws_access_key text,
    region text,
    ami_id text,
    ami_name text,
    block_devices text,
    creation_data text,
    description text,
    image_size text,
    platform text,
    root_device_name text,
    root_device_type text,
    status text,
    virtualization text,
    PRIMARY KEY (aws_access_key, region, ami_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.aws_elasticip (
    aws_access_key text,
    region text,
    elasticip text,
    eni_id text,
    private_id_addr text,
    public_dns text,
    PRIMARY KEY (aws_access_key, region, elasticip)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.post_msa (
    tenant_id text,
    landscape text,
    ts timeuuid,
    vpc_id text,
    PRIMARY KEY (tenant_id, landscape, ts)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.idx_tenant_landscape_version (
    tenant_id text,
    landscape text,
    version text,
    ts timeuuid,
    PRIMARY KEY (tenant_id, landscape, version)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.info_tenant (
    tenant_id text,
    corporation_id text,
    created_at timestamp,
    license_end_time timestamp,
    license_id uuid,
    license_name map<text, text>,
    license_start_time timestamp,
    license_usernum int,
    record_state boolean,
    tenant_address text,
    tenant_email text,
    tenant_name text,
    tenant_phone text,
    tenant_type text,
    PRIMARY KEY (tenant_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX info_tenant_corporation_id_idx ON elephas.info_tenant (corporation_id);
CREATE INDEX info_tenant_record_state_idx ON elephas.info_tenant (record_state);

CREATE TABLE elephas.aws_keypair (
    aws_access_key text,
    region text,
    keyname text,
    pem text,
    pub text,
    PRIMARY KEY (aws_access_key, region, keyname)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;

CREATE TABLE elephas.info_sublicense (
    ptk text,
    sublicense_id uuid,
    license_id uuid,
    record_state boolean,
    sublicense_detail text,
    sublicense_name map<text, text>,
    PRIMARY KEY (ptk, sublicense_id)
) WITH read_repair_chance = 0.0
   AND dclocal_read_repair_chance = 0.1
   AND gc_grace_seconds = 864000
   AND bloom_filter_fp_chance = 0.01
   AND caching = { 'keys' : 'ALL', 'rows_per_partition' : 'NONE' }
   AND comment = ''
   AND compaction = { 'class' : 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy' }
   AND compression = { 'sstable_compression' : 'org.apache.cassandra.io.compress.LZ4Compressor' }
   AND default_time_to_live = 0
   AND speculative_retry = '99.0PERCENTILE'
   AND min_index_interval = 128
   AND max_index_interval = 2048;
CREATE INDEX info_sublicense_license_id_idx ON elephas.info_sublicense (license_id);
CREATE INDEX info_sublicense_record_state_idx ON elephas.info_sublicense (record_state);
