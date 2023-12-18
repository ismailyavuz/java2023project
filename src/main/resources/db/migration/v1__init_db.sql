
create table address (id bigint generated by default as identity, primary key (id));
create table basket (id bigint generated by default as identity, user_id bigint unique, primary key (id));
create table basket_item (line_order integer not null, quantity integer not null, basket_id bigint, id bigint generated by default as identity, product_id bigint, primary key (id));
create table orders (id bigint generated by default as identity, primary key (id));
create table payment (id bigint generated by default as identity, primary key (id));
create table product (price numeric(38,2), stock integer not null, id bigint generated by default as identity, description varchar(255), name varchar(255), primary key (id));
create table users (id bigint generated by default as identity, email varchar(255), name varchar(255), password varchar(255), role varchar(255) check (role in ('BUYER','SELLER')), primary key (id));
create table users_products (products_id bigint not null, user_id bigint not null);

alter table if exists basket add constraint FK810a8gq30miyp6j1eub97qm6k foreign key (user_id) references users;
alter table if exists basket_item add constraint FKara19f2xv7ml3a24f50v6bsk2 foreign key (basket_id) references basket;
alter table if exists basket_item add constraint FKh4prhjkyv0umn63ebttoq9wl3 foreign key (product_id) references product;
alter table if exists users_products add constraint FKb030yd0nllplfio4h94r6ys8p foreign key (products_id) references product;
alter table if exists users_products add constraint FK7j1q4wj87yy0fmovuwq4yf7it foreign key (user_id) references users;

insert into users(email,password,role,name)
values ('user1@example.com', 'abcde1234', 'BUYER', 'enes');