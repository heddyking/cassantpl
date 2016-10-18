drop table if exists elephas.jar_meta_data;
create table elephas.jar_meta_data
(
ptk varchar,
nexus varchar,
artifact_id varchar,
versions list<varchar>,
PRIMARY KEY (ptk, nexus, artifact_id)
);


drop table if exists elephas.docker_meta_data;
create table elephas.docker_meta_data
(
ptk varchar,
namespace varchar,
repository varchar,
tags list<varchar>,
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
public boolean,
architecture varchar,
image_type varchar,
name varchar,
description varchar,
hypervisor varchar,
virtualization_type varchar,
PRIMARY KEY (ptk, image_id)
);
