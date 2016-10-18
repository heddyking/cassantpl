drop keyspace if exists elephas;
create keyspace elephas with replication={ 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
use elephas;



drop table if exists db_version;
create table db_version
(
ptk varchar,
type varchar,
developer_id varchar,
current_ts varchar,
PRIMARY KEY (ptk, type, developer_id)
);




drop table if exists info_operator;
create table info_operator
(
operator_id varchar,
hash blob,
salt blob,
operator_name varchar,
operator_email varchar,
operator_telephone varchar,
operator_department varchar,
record_state boolean,
PRIMARY KEY (operator_id)
);
create index on info_operator(record_state);


drop table if exists info_pcode;
create table info_pcode
(
pcode1 varchar,
pcode2 varchar,
pcode3 varchar,
pgroups set<varchar>,
record_state boolean,
PRIMARY KEY (pcode1,pcode2,pcode3)
);
create index on info_pcode(record_state);


drop table if exists info_pgroup;
create table info_pgroup
(
pgroup varchar,
pcodes set<varchar>,
record_state boolean,
PRIMARY KEY (pgroup)
);
create index on info_pgroup(record_state);


drop table if exists info_corporation;
create table info_corporation
(
corporation_id varchar,
corporation_name varchar,
corporation_address varchar,
corporation_email varchar,
corporation_phone varchar,
record_state boolean,
PRIMARY KEY (corporation_id)
);
create index on info_corporation(record_state);


drop table if exists info_tenant;
create table info_tenant
(
tenant_id varchar,
corporation_id varchar,
tenant_name varchar,
tenant_address varchar,
tenant_email varchar,
tenant_phone varchar,
tenant_type varchar,
license_id uuid,
license_name  map<varchar,varchar>,
                     --en
                     --ch
                     --jp
license_usernum int,
license_start_time timestamp,
license_end_time timestamp,
record_state boolean,
PRIMARY KEY (tenant_id)
);
create index on info_tenant(corporation_id);
create index on info_tenant(record_state);


drop table if exists info_tenant_sublicense;
create table info_tenant_sublicense
(
tenant_id varchar,
sublicense_id uuid,
sublicense_name map<varchar,varchar>,
        --en
        --ch
        --jp
sublicense_usernum int,
sublicense_start_time timestamp,
sublicense_end_time timestamp,
record_state boolean,
PRIMARY KEY (tenant_id, sublicense_id)
);
create index on info_tenant_sublicense(record_state);


drop table if exists info_license;
create table info_license
(
ptk varchar,
license_id uuid,
license_name map<varchar,varchar>,
license_detail varchar,
record_state boolean,
PRIMARY KEY (ptk, license_id)
);
create index on info_license(record_state);


drop table if exists info_sublicense;
create table info_sublicense
(
ptk varchar,
sublicense_id uuid,
license_id uuid,
sublicense_name map<varchar,varchar>,
sublicense_detail varchar,
record_state boolean,
PRIMARY KEY (ptk, sublicense_id)
);
create index on info_sublicense(license_id);
create index on info_sublicense(record_state);


drop table if exists info_landscape;
create table info_landscape
(
ptk varchar,
landscape varchar,
description varchar,
record_state boolean,
PRIMARY KEY (ptk, landscape)
);
create index on info_landscape(record_state);


drop table if exists idx_operator_permission;
create table idx_operator_permission
(
operator_id varchar,
tenant_id varchar,
landscape varchar,
pgroup varchar,
PRIMARY KEY (operator_id, tenant_id, landscape, pgroup)
);







drop table if exists idx_tenant_landscape_current;
create table idx_tenant_landscape_current
(
tenant_id varchar,
landscape varchar,
ts timeuuid,
try_ts timeuuid,
try_type  varchar,
PRIMARY KEY (tenant_id, landscape)
);



drop table if exists idx_tenant_landscape_version;
create table idx_tenant_landscape_version
(
tenant_id varchar,
landscape varchar,
version varchar,
ts timeuuid,
PRIMARY KEY (tenant_id, landscape, version)
);






drop table if exists aws_key;
create table aws_key
(
ptk varchar,
aws_access_key varchar,
aws_secret_key varchar,
PRIMARY KEY (ptk, aws_access_key,aws_secret_key)
);


drop table if exists aws_region;
create table aws_region
(
ptk varchar,
region varchar,
PRIMARY KEY (ptk, region)
);


drop table if exists aws_ami;
create table aws_ami
(
aws_access_key varchar,
region varchar,
ami_id varchar,
ami_name varchar,
status varchar,
creation_data varchar,
root_device_name varchar,
root_device_type varchar,
block_devices varchar,
image_size varchar,
platform varchar,
virtualization varchar,
description varchar,
PRIMARY KEY (aws_access_key, region, ami_id)
);


drop table if exists aws_instancetype;
create table aws_instancetype
(
aws_access_key varchar,
region varchar,
family varchar,
instancetype varchar,
platform varchar,
vcpus varchar,
memory varchar,
instance_storage varchar,
ebs_optimized boolean,
network varchar,
os_platform varchar,
price_on_demand varchar,
PRIMARY KEY (aws_access_key, region, family, instancetype, os_platform)
);


drop table if exists aws_keypair;
create table aws_keypair
(
aws_access_key varchar,
region varchar,
keyname varchar,
pub varchar,
pem varchar,
PRIMARY KEY (aws_access_key,region, keyname)
);


drop table if exists aws_elasticip;
create table aws_elasticip
(
aws_access_key varchar,
region varchar,
elasticip varchar,
eni_id varchar,
private_id_addr varchar,
public_dns varchar,
PRIMARY KEY (aws_access_key,region, elasticip)
);




drop table if exists pre_data;
create table pre_data
(
tenant_id varchar,
landscape varchar,
ts timeuuid,

aws_access_key_id varchar,
aws_secret_access_key varchar,
aws_instance_prefix varchar,
aws_work_terminal_keypair varchar,
aws_general_keypair varchar,
shipment_s3_access_key_id varchar,
shipment_s3_secret_access_key varchar,
shipment_s3_bucket_name varchar,
shipment_s3_region varchar,
use_self_signed_certificates varchar,
docker_registry_s3_access_key_id varchar,
docker_registry_s3_secret_access_key varchar,
docker_registry_s3_bucket_name varchar,
docker_registry_s3_region varchar,
huedrive_s3_access_key_id varchar,
huedrive_s3_secret_access_key varchar,
huedrive_s3_bucket_name varchar,
huedrive_s3_region varchar,
huepreheat_s3_access_key_id varchar,
huepreheat_s3_secret_access_key varchar,
huepreheat_s3_bucket_name varchar,
huepreheat_s3_region varchar,
huelog_s3_access_key_id varchar,
huelog_s3_secret_access_key varchar,
huelog_s3_bucket_name varchar,
huelog_s3_region varchar,
elasticsearch_install_from_scratch varchar,
cassandra_cluster_prefix varchar,
cassandra_keyspace_name varchar,
cassandra_replication_factor varchar,
enable_cassandra_jmx varchar,
cassandra_jmx_password varchar,
mailman_api_user varchar,
mailman_api_pass varchar,
elasticsearch_index_name varchar,
ekispa_url varchar,
windows_work_terminal_ami_id varchar,
edp2_configbranch varchar,
logmanager_port varchar,
postgres_ip varchar,
dicingsearch_api_key varchar,
mailman_port varchar,
mailman_version varchar,
ocrus_web_hostname varchar,
postgresql_port varchar,
postgresql_tenant_id varchar,
hue_context_path varchar,
nginx_node_port varchar,
terminal_shipment_file_dir varchar,
git_server_repository_path varchar,
git_server_http_auth_user varchar,
git_server_http_auth_pass varchar,
config_server_git_repository varchar,
config_server_local_git_dir varchar,

flow_id varchar,
tenant_name varchar,
tenant_account varchar,
number_of_users varchar,
landscape_name varchar,
user_id varchar,
aws_vpc_index varchar,
elasticsearch_cluster_name varchar,
front_elb_accessible_cidr_list varchar,
config_server_url varchar,
hdfs_namenode_ip varchar,
yarn_resouce_manager_ip varchar,
edp2_webserver_url varchar,
logmanager_host varchar,
elasticsearch_host varchar,
kafka_hosts varchar,
redis_host varchar,
vpc_ip_prefix varchar,
zookeeper_cluster varchar,
zookeeper_nodes varchar,
datasync_hue_domain varchar,
smtp_host varchar,
mailman_host varchar,
postgresql_host varchar,
cassandra_hosts_bt varchar,
cassandra_hosts_ac_common1 varchar,
cassandra_hosts_ac_common2 varchar,
cassandra_hosts_ac_common3 varchar,
cassandra_hosts_hr_common1 varchar,
cassandra_hosts_hr_common2 varchar,
terminal_current_shipment_file_dir varchar,
terminal_current_batch_jar_dir varchar,
terminal_current_edp2_dir varchar,
terminal_current_elasticsearch_dir varchar,
terminal_current_cassandra_dir varchar,
remote_property_file_dir varchar,
remote_batch_jar_dir varchar,
version varchar,
hue_bt_version varchar,
hue_product_version varchar,
migrator_version varchar,
migrate_to_version varchar,
remote_shipment_file_dir varchar,
PRIMARY KEY (tenant_id, landscape, ts)
);

drop table if exists pre_data_default;
create table pre_data_default
(
landscape varchar,

aws_access_key_id varchar,
aws_secret_access_key varchar,
aws_instance_prefix varchar,
aws_work_terminal_keypair varchar,
aws_general_keypair varchar,
shipment_s3_access_key_id varchar,
shipment_s3_secret_access_key varchar,
shipment_s3_bucket_name varchar,
shipment_s3_region varchar,
use_self_signed_certificates varchar,
docker_registry_s3_access_key_id varchar,
docker_registry_s3_secret_access_key varchar,
docker_registry_s3_bucket_name varchar,
docker_registry_s3_region varchar,
huedrive_s3_access_key_id varchar,
huedrive_s3_secret_access_key varchar,
huedrive_s3_bucket_name varchar,
huedrive_s3_region varchar,
huepreheat_s3_access_key_id varchar,
huepreheat_s3_secret_access_key varchar,
huepreheat_s3_bucket_name varchar,
huepreheat_s3_region varchar,
huelog_s3_access_key_id varchar,
huelog_s3_secret_access_key varchar,
huelog_s3_bucket_name varchar,
huelog_s3_region varchar,
elasticsearch_install_from_scratch varchar,
cassandra_cluster_prefix varchar,
cassandra_keyspace_name varchar,
cassandra_replication_factor varchar,
enable_cassandra_jmx varchar,
cassandra_jmx_password varchar,
mailman_api_user varchar,
mailman_api_pass varchar,
elasticsearch_index_name varchar,
ekispa_url varchar,
windows_work_terminal_ami_id varchar,
edp2_configbranch varchar,
logmanager_port varchar,
postgres_ip varchar,
dicingsearch_api_key varchar,
mailman_port varchar,
mailman_version varchar,
ocrus_web_hostname varchar,
postgresql_port varchar,
postgresql_tenant_id varchar,
hue_context_path varchar,
nginx_node_port varchar,
terminal_shipment_file_dir varchar,
git_server_repository_path varchar,
git_server_http_auth_user varchar,
git_server_http_auth_pass varchar,
config_server_git_repository varchar,
config_server_local_git_dir varchar,
PRIMARY KEY (landscape)
);

drop table if exists pre_vpc;
create table pre_vpc
(
tenant_id varchar,
landscape varchar,
ts timeuuid,

aws_access_key varchar,
aws_secret_key varchar,
region varchar,
vpc_prefix varchar,
security_group_prefix varchar,
ip_prefix varchar,
private_ip_address_suffix varchar,
igw_name_prefix varchar,
private_rt_name_prefix varchar,
public_rt_name_prefix varchar,
bucket_name_prefix varchar,
source_root varchar,
destination_root varchar,
cidr_block_suffix varchar,
PRIMARY KEY (tenant_id, landscape, ts)
);


drop table if exists pre_vpc_default;
create table pre_vpc_default
(
landscape varchar,
aws_access_key varchar,
aws_secret_key varchar,
region varchar,
vpc_prefix varchar,
security_group_prefix varchar,
ip_prefix varchar,
private_ip_address_suffix varchar,
igw_name_prefix varchar,
private_rt_name_prefix varchar,
public_rt_name_prefix varchar,
bucket_name_prefix varchar,
source_root varchar,
destination_root varchar,
cidr_block_suffix varchar,
PRIMARY KEY (landscape)
);


drop table if exists pre_security;
create table pre_security
(
tenant_id varchar,
landscape varchar,
ts timeuuid,
security_name_prefix varchar,

proto varchar,
from_port varchar,
to_port varchar,
cidr_ip varchar,
PRIMARY KEY (tenant_id, landscape, ts, security_name_prefix)
);


drop table if exists pre_security_default;
create table pre_security_default
(
landscape varchar,
security_name_prefix varchar,

proto varchar,
from_port varchar,
to_port varchar,
cidr_ip varchar,
PRIMARY KEY (landscape, security_name_prefix)
);


drop table if exists pre_subnet;
create table pre_subnet
(
tenant_id varchar,
landscape varchar,
ts timeuuid,
subnet_name_suffix varchar,

subnet_cidr_suffix varchar,
sub_region varchar,
PRIMARY KEY (tenant_id, landscape, ts, subnet_name_suffix)
);


drop table if exists pre_subnet_default;
create table pre_subnet_default
(
landscape varchar,
subnet_name_suffix varchar,

subnet_cidr_suffix varchar,
sub_region varchar,
PRIMARY KEY (landscape, subnet_name_suffix)
);


drop table if exists pre_instance;
create table pre_instance
(
tenant_id varchar,
landscape varchar,
ts timeuuid,
instance_name_suffix varchar,

key_name varchar,
image_id varchar,
instance_type varchar,
num int,
volumes list<frozen<map<varchar,varchar>>>,
        --volume_size
        --volume_type
        --device_name
PRIMARY KEY (tenant_id, landscape, ts, instance_name_suffix)
);


drop table if exists pre_instance_default;
create table pre_instance_default
(
landscape varchar,
instance_name_suffix varchar,

key_name varchar,
image_id varchar,
instance_type varchar,
num int,
volumes list<frozen<map<varchar,varchar>>>,
        --volume_size
        --volume_type
        --device_name
PRIMARY KEY (landscape, instance_name_suffix)
);


drop table if exists pre_msa;
create table pre_msa
(
tenant_id varchar,
landscape varchar,
ts timeuuid,

PRIMARY KEY (tenant_id, landscape, ts)
);


drop table if exists pre_msa_default;
create table pre_msa_default
(
landscape varchar,

PRIMARY KEY (landscape)
);






drop table if exists post_vpc;
create table post_vpc
(
tenant_id varchar,
landscape varchar,
ts timeuuid,

vpc_id varchar,

aws_access_key varchar,
aws_secret_key varchar,

region varchar,
vpc_prefix varchar,
security_group_prefix varchar,
ip_prefix varchar,
private_ip_address_suffix varchar,
igw_name_prefix varchar,
private_rt_name_prefix varchar,
public_rt_name_prefix varchar,
bucket_name_prefix varchar,
source_root varchar,
destination_root varchar,
cidr_block_suffix varchar,
PRIMARY KEY (tenant_id, landscape, ts)
);
create index on post_vpc(vpc_id);


drop table if exists post_security;
create table post_security
(
tenant_id varchar,
landscape varchar,
ts timeuuid,
security_id varchar,

vpc_id varchar,
security_name_prefix varchar,

proto varchar,
from_port varchar,
to_port varchar,
cidr_ip varchar,
PRIMARY KEY (tenant_id, landscape, ts, security_id)
);
create index on post_security(vpc_id);


drop table if exists post_subnet;
create table post_subnet
(
tenant_id varchar,
landscape varchar,
ts timeuuid,
subnet_id varchar,

vpc_id varchar,
subnet_name_suffix varchar,
subnet_cidr_suffix varchar,
sub_region varchar,

availability_zone varchar,
available_ip_address_count int,
cidr_block varchar,
default_for_az boolean,
map_public_ip_on_launch boolean,
state varchar,
tags map<varchar,varchar>,
        --Name
PRIMARY KEY (tenant_id, landscape, ts, subnet_id)
);
create index on post_subnet(vpc_id);


drop table if exists post_instance;
create table post_instance
(
tenant_id varchar,
landscape varchar,
ts timeuuid,
instance_id varchar,

vpc_id varchar,
region varchar,
key_name varchar,

instance_name_suffix varchar,
image_id varchar,
instance_type varchar,
volumes list<frozen<map<varchar,varchar>>>,
        --volume_size
        --volume_type
        --device_name

ami_launch_index int,
architecture varchar,
client_token varchar,
ebs_optimized boolean,
groups list<frozen<map<varchar,varchar>>>,
        --id
        --name
hypervisor varchar,
instance_profile varchar,
interfaces list<frozen<map<varchar,varchar>>>,
        --id
        --name
kernel varchar,
launch_time timestamp,
monitoring_state varchar,
persistent boolean,
placement map<varchar,varchar>,
        --tenancy
        --zone
private_dns_name varchar,
private_ip_address varchar,
public_dns_name varchar,
ramdisk varchar,
requester_id varchar,
root_device_type varchar,
source_destination_check boolean,
spot_instance_request_id varchar,
state varchar,
tags map<varchar,varchar>,
        --Name
virtualization_type varchar,

PRIMARY KEY (tenant_id, landscape, ts, instance_id)
);
create index on post_instance(vpc_id);


drop table if exists post_route;
create table post_route
(
tenant_id varchar,
landscape varchar,
ts timeuuid,
route_id varchar,

vpc_id varchar,

routes list<frozen<map<varchar,varchar>>>,
        --destination_cidr_block
        --gateway_id
        --instance_id
        --interface_id
        --origin
        --state
        --vpc_peering_connection_id
tags map<varchar,varchar>,
        --Name

PRIMARY KEY (tenant_id, landscape, ts, route_id)
);
create index on post_route(vpc_id);


drop table if exists post_elb;
create table post_elb
(
tenant_id varchar,
landscape varchar,
ts timeuuid,
elb_name varchar,

vpc_id varchar,

canonical_hosted_zone_name varchar,
canonical_hosted_zone_name_id varchar,
dns_name varchar,
health_check map<varchar,varchar>,
          --"healthy_threshold": 10,
          --"interval": 30,
          --"ping_path": "/healthz/ping",
          --"ping_port": 8080,
          --"ping_protocol": "http",
          --"response_timeout": 5,
          --"unhealthy_threshold": 2
instances list<varchar>,
instances_inservice list<varchar>,
instances_inservice_count int,
instances_inservice_percent double,
instances_outofservice list<varchar>,
instances_outofservice_count int,
listeners list<frozen<map<varchar,varchar>>>,
          --"instance_port": 8080,
          --"load_balancer_port": 8080,
          --"protocol": "HTTP"
scheme varchar,
security_groups list<varchar>,
subnets list<varchar>,
zones list<varchar>,

PRIMARY KEY (tenant_id, landscape, ts, elb_name)
);
create index on post_elb(vpc_id);


drop table if exists post_msa;
create table post_msa
(
tenant_id varchar,
landscape varchar,
ts timeuuid,

vpc_id varchar,

PRIMARY KEY (tenant_id, landscape, ts)
);
