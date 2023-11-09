CREATE TABLE IF NOT EXISTS t_orders
(
    id      bigserial not null,
    time    timestamp(6),
    status  integer,
    user_id bigint,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS t_orders_products
(
    order_id    bigint not null,
    products_id bigint not null
);

CREATE TABLE IF NOT EXISTS t_permissions
(
    id   bigserial not null,
    role varchar(255),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS t_products
(
    id          bigserial not null,
    description varchar(255),
    name        varchar(255),
    price       float(53),
    category_id bigint,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS t_users
(
    id        bigserial not null,
    email     varchar(255),
    full_name varchar(255),
    password  varchar(255),
    role      integer,
    status    boolean,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS t_users_permissions
(
    user_id        bigint not null,
    permissions_id bigint not null
);

CREATE TABLE IF NOT EXISTS t_users_products
(
    user_id     bigint not null,
    products_id bigint not null
);

CREATE TABLE IF NOT EXISTS t_category
(
    id   bigserial PRIMARY KEY,
    name varchar(255)
);

alter table if exists t_orders
    add constraint FKb1q2qvle7ntunntqjqufg4kp2 foreign key (user_id) references t_users;

alter table if exists t_orders_products
    add constraint FKf6f1jl0e8vcef8j1g2k0hgfx0 foreign key (products_id) references t_products;

alter table if exists t_orders_products
    add constraint FKbgidjf1f0u1m1mc3qe78pbfq1 foreign key (order_id) references t_orders;

alter table if exists t_products
    add constraint FKkvci4q1p9fqvao4bqvyxj4yfu foreign key (category_id) references t_category;

alter table if exists t_users_permissions
    add constraint FKpmfc242wvr5kwdv44324cdbna foreign key (permissions_id) references t_permissions;

alter table if exists t_users_permissions
    add constraint FK1aqgc2651y14fjqdvq9ytfwc1 foreign key (user_id) references t_users;
alter table if exists t_users_products
    add constraint FKhlgm3f79tewpvcsnfjwx44l0u foreign key (products_id) references t_products;
alter table if exists t_users_products
    add constraint FKlbdmfs1358fdnexr6kec0bw0v foreign key (user_id) references t_users;