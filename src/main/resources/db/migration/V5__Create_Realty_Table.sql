create table realty
(
    id bigint not null
        constraint realty_pkey
            primary key,
    description varchar(255),
    is_sold boolean,
    name varchar(255),
    price numeric(19,2),
    address_id bigint
        constraint fk3fqu5gnom2ba1nbs2ki60303f
            references address,
    broker_id bigint
        constraint fk5mthusmx92y6ape9i0hlt03uf
            references broker,
    type_id bigint
        constraint fk5bavmpil31coj0l79kqynrmqn
            references type
);

alter table realty owner to realtor_user;

