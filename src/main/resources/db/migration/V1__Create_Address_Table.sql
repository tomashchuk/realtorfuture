create table address
(
    id bigint not null
        constraint address_pkey
            primary key,
    first_line varchar(255),
    index varchar(255),
    latitude numeric(19,2),
    longitude numeric(19,2),
    second_line varchar(255)
);

alter table address owner to realtor_user;

