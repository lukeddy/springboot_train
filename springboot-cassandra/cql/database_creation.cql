//创建存储空间（库）
CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

//切换到新建的空间
USE mykeyspace;

//删除以创建的表
drop table IF EXISTS mykeyspace.person;

//新建表
CREATE TABLE mykeyspace.person (
    id text PRIMARY KEY,
    name text,
    age int
);

//初始化数据
INSERT INTO mykeyspace.person (id,  name, age) VALUES ('625b36f0-1d6b-11e6-ac56-aba64e8c1447', '张', 10);
INSERT INTO mykeyspace.person (id,  name, age) VALUES ('625b36f0-1d6b-11e6-ac56-aba64e8c1123', '李', 22);
INSERT INTO mykeyspace.person (id,  name, age)  VALUES ('625b36f0-1d6b-11e6-ac56-aba64e8c1447', '王', 10);

//对要做为过滤条件的字段建立索引
create index on mykeyspace.person (name);
//测试:使用主键字段做为过滤条件：
select * from mykeyspace.person where id='625b36f0-1d6b-11e6-ac56-aba64e8c1447';
//测试：使用索引字段进行过滤
select * from mykeyspace.person where name='晓晓';