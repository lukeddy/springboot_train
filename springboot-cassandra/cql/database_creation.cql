CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE mykeyspace;

drop table IF EXISTS mykeyspace.person;

CREATE TABLE mykeyspace.person (
    id text PRIMARY KEY,
    name text,
    age int
);