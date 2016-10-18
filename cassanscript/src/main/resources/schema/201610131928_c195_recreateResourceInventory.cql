drop table if exists elephas.jar_meta_data;
create table elephas.jar_meta_data
(
ptk varchar,
group_id varchar,
artifact_id varchar,
nexus varchar,
org varchar,
jar varchar,
version varchar,
url varchar,
ts timestamp,
PRIMARY KEY (ptk, group_id, artifact_id, version)
);


drop table if exists elephas.docker_meta_data;
create table elephas.docker_meta_data
(
ptk varchar,
namespace varchar,
repository varchar,
tags list<varchar>,
ts timestamp,
PRIMARY KEY (ptk, namespace, repository)
);


drop table if exists elephas.ami_meta_data;
create table elephas.ami_meta_data
(
ptk varchar,
image_id varchar,
image_location varchar,
state varchar,
owner_id varchar,
architecture varchar,
image_type varchar,
name varchar,
description varchar,
hypervisor varchar,
virtualization_type varchar,
ts timestamp,
PRIMARY KEY (ptk, image_id)
);
