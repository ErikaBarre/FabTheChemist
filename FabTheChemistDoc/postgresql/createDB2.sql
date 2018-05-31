CREATE TABLE customer (
  id BIGINT IDENTITY PRIMARY KEY,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  email_address VARCHAR(255));
CREATE UNIQUE INDEX ix_customer_email ON CUSTOMER (email_address ASC);
CREATE TABLE address (
  id BIGINT IDENTITY PRIMARY KEY,
  customer_id BIGINT CONSTRAINT address_customer_ref REFERENCES customer (id),
  street VARCHAR(255),
  city VARCHAR(255),
  country VARCHAR(255));
  
  
  
  CREATE SEQUENCE address_seq;
create table address(
id integer NOT NULL DEFAULT nextval('address_seq') NOT NULL
street varchar(250),
city    varchar(250),
country varchar(250),
customer_id integer REFERENCES customer (id)
)
;
CREATE SEQUENCE email_address_seq;
CREATE TABLE email_address(
id    integer NOT NULL DEFAULT nextval('email_address_seq') NOT NULL
address varchar(250)
customer_id integer REFERENCES customer (id)
)
;
CREATE SEQUENCE customer_seq;
create table customer
id    integer NOT NULL DEFAULT nextval('address_seq') NOT NULL
name    varchar(250),
email_address varchar(250),
addresses varchar(250)
;
CREATE SEQUENCE product_seq;
create table product
id  integer NOT NULL DEFAULT nextval('product_seq') NOT NULL
name varchar(250),
description varchar(250),
attributes varchar(250),
price integer,
line_item_id integer REFERENCES order(id)

;
create SEQUENCE order_seq;
create table order
id  integer NOT NULL DEFAULT nextval('order_seq') NOT NULL
date
customer
shipping_address
billing_addess
line_items
status
customer_id integer REFERENCES customer (id)
;
create SEQUENCE line_item_seq;
create table line_item
id  integer NOT NULL DEFAULT nextval('line_item_seq') NOT NULL
product,
quantity
price
;
create SEQUENCE cart_seq;
create table cart
id  integer NOT NULL DEFAULT nextval('cart_seq') NOT NULL
line_items integer REFERENCES line_item(id)
customer_id integer REFERENCES customer (id)



  
  
INSERT INTO customer(id, first_name, last_name, email_address) VALUES(100, 'John', 'Doe', 'john@doe.com');
INSERT INTO customer(id, first_name, last_name, email_address) VALUES(101, 'Jane', 'Doe', 'jane@doe.com');
INSERT INTO customer(id, first_name, last_name, email_address) VALUES(102, 'Bob', 'Doe', 'bob@doe.com');
ALTER TABLE customer ALTER COLUMN id RESTART WITH 200;
INSERT INTO address(customer_id, street, city, country) VALUES(100, '6 Main St', 'Newtown', 'USA');
INSERT INTO address(customer_id, street, city, country) VALUES(100, '128 N. South St', 'Middletown', 'USA');
INSERT INTO address(customer_id, street, city, country) VALUES(102, '512 North St', 'London', 'UK');
  insert into Customer (id, email, firstname, lastname) values (1, 'dave@dmband.com', 'Dave', 'Matthews');
insert into Customer (id, email, firstname, lastname) values (2, 'carter@dmband.com', 'Carter', 'Beauford');
insert into Customer (id, email, firstname, lastname) values (3, 'boyd@dmband.com', 'Boyd', 'Tinsley');

insert into Address (id, street, city, country, customer_id) values (1, '27 Broadway', 'New York', 'United States', 1);
insert into Address (id, street, city, country, customer_id) values (2, '27 Broadway', 'New York', 'United States', 1);

insert into Product (id, name, description, price) values (1, 'iPad', 'Apple tablet device', 499.0);
insert into Product (id, name, description, price) values (2, 'MacBook Pro', 'Apple notebook', 1299.0);
insert into Product (id, name, description, price) values (3, 'Dock', 'Dock for iPhone/iPad', 49.0);

insert into Product_Attributes (attributes_key, product_id, attributes) values ('connector', 1, 'socket');
insert into Product_Attributes (attributes_key, product_id, attributes) values ('connector', 3, 'plug');

insert into Orders (id, customer_id, shippingaddress_id) values (1, 1, 2);
insert into LineItem (id, product_id, amount, order_id, price) values (1, 1, 2, 1, 499.0);
insert into LineItem (id, product_id, amount, order_id, price) values (2, 2, 1, 1, 1299.0);
  