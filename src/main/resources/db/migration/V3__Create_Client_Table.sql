create table client
(
    id bigint not null
        constraint client_pkey
            primary key,
    birthday timestamp,
    created_at timestamp,
    description varchar(255),
    email varchar(255),
    name varchar(255),
    number varchar(255),
    patronic varchar(255),
    surname varchar(255)
);

alter table client owner to realtor_user;

