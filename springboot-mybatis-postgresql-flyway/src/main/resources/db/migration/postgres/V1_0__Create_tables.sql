create table IF NOT EXISTS public.sysuser(
  id integer,
  name character varying(255),
  age integer,
  password character varying(60)
);

create table IF NOT EXISTS public.person (
    id int not null,
    name varchar(100) not null
);