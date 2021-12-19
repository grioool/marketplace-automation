create sequence user_role_id_seq
    as integer;

alter sequence user_role_id_seq owner to postgres;

create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table role
(
    id        integer default nextval('user_role_id_seq'::regclass) not null
        constraint user_role_pk
            primary key,
    role_name varchar(10)                                           not null
);

alter table role
    owner to postgres;

alter sequence user_role_id_seq owned by role.id;

create table "user"
(
    id            serial
        constraint user_pk
            primary key,
    password      varchar(255) not null,
    email         varchar(255) not null,
    wb_key        varchar(255) not null,
    ozon_key      varchar(255) not null,
    name          varchar(40)  not null,
    role_id       integer      not null
        constraint role_id_fk
            references role
            on update cascade on delete cascade,
    is_blocked    boolean      not null,
    is_subscribed boolean      not null
);

alter table "user"
    owner to postgres;

create unique index user_email_uindex
    on "user" (email);

create unique index user_ozon_key_uindex
    on "user" (ozon_key);

create unique index user_wb_key_uindex
    on "user" (wb_key);

create unique index user_role_role_name_uindex
    on role (role_name);

create table purchase
(
    id            serial
        constraint purchase_pk
            primary key,
    date          timestamp        not null,
    product_name  varchar(20)      not null,
    price_for_one double precision not null,
    amount        integer          not null,
    purchase      integer          not null,
    logistics     double precision not null,
    cost_price    double precision not null,
    batch_price   double precision not null,
    extra         double precision not null
);

alter table purchase
    owner to postgres;

create unique index purchase_id_uindex
    on purchase (id);

create table supply
(
    id          integer          not null
        constraint supply_pk
            primary key,
    purchase_id integer          not null
        constraint supply_purchase_id_fk
            references purchase
            on update cascade on delete cascade,
    date        timestamp        not null,
    product     varchar(20)      not null,
    amount      integer          not null,
    logistics   double precision not null,
    purchase    double precision not null,
    fulfillment double precision not null,
    cost_price  double precision not null
);

alter table supply
    owner to postgres;

create table sale
(
);

alter table sale
    owner to postgres;

create table report
(
    id                  serial
        constraint report_pk
            primary key,
    order_number        integer          not null,
    name                varchar(20)      not null,
    order_price         double precision not null,
    proceeds            double precision not null,
    logistics           double precision not null,
    cost_price          double precision not null,
    commission          double precision not null,
    profit              double precision not null,
    commission_per_cent double precision not null,
    "commission_VAT"    double precision not null,
    date_sale           timestamp        not null,
    date_order          timestamp        not null,
    supply_id           integer          not null
        constraint report_supply_id_fk
            references supply
            on update cascade on delete cascade
);

alter table report
    owner to postgres;

create unique index report_id_uindex
    on report (id);

create table subscription
(
    id         serial
        constraint subscription_pk
            primary key,
    user_id    integer   not null
        constraint subscription_user_id_fk
            references "user"
            on update cascade on delete cascade,
    date_start timestamp not null,
    date_end   integer   not null,
    period     integer   not null
);

alter table subscription
    owner to postgres;

create unique index subscription_id_uindex
    on subscription (id);

create table country
(
    id           serial
        constraint country_pk
            primary key,
    country_name varchar(25) not null
);

alter table country
    owner to postgres;

create unique index country_id_uindex
    on country (id);

create table town
(
    id        serial
        constraint town_pk
            primary key,
    town_name varchar(25) not null
);

alter table town
    owner to postgres;

create table storage
(
    id         serial
        constraint storage_pk
            primary key,
    country_id integer not null
        constraint storage_country_if_fk
            references country
            on update cascade on delete cascade,
    town_id    integer not null
        constraint storage_town_id_fk
            references town
            on update cascade on delete cascade,
    supply_id  integer not null
        constraint storage_supply_id_fk
            references supply
            on update cascade on delete cascade
);

alter table storage
    owner to postgres;

create unique index storage_id_uindex
    on storage (id);

create unique index town_id_uindex
    on town (id);

