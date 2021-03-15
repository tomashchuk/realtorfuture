create table broker
(
    id bigint not null
        constraint broker_pkey
            primary key,
    birthday timestamp,
    description varchar(255),
    email varchar(255),
    name varchar(255),
    number varchar(255),
    patronic varchar(255),
    position varchar(255),
    started_work timestamp,
    surname varchar(255)
);

alter table broker owner to realtor_user;

