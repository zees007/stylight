drop table if exists url_lookups;

create table url_lookups (
  id bigint not null primary key,
  parameterizedurl varchar ,
  prettyurl varchar
)
