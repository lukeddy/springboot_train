CREATE TABLE athletes (
    id BIGSERIAL,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    PRIMARY KEY (id)
);

ALTER TABLE sysuser ADD COLUMN country VARCHAR(200);


CREATE INDEX first_name_idx ON athletes (first_name);