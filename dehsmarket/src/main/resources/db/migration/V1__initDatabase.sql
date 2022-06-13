CREATE SCHEMA dehsmarket;

CREATE TABLE dehsmarket.product(

    id bigserial primary key,
    name character varying(200) not null,
    price numeric(6,2) not null,
    turned_on boolean default true

);