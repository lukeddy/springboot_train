update sysuser set country='中国';
update sysuser set country='美国USA' where id=1;

insert into sysuser(id, name, age, password,country) VALUES (3,'aaabbc',22,'123ppp','澳大利亚');

insert into person (id, name) values (4, 'Mr.Awesome');

insert into athletes (id,first_name,last_name) VALUES (2,'Lucy','Lee');
insert into athletes (id,first_name,last_name) VALUES (3,'Lily','Bee');
insert into athletes (id,first_name,last_name) VALUES (4,'小哥','唐');

