CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE mykeyspace;


CREATE TABLE person (
    id text PRIMARY KEY,
    name text,
    age int
);