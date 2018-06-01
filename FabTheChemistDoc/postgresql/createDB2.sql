CREATE SEQUENCE customer_seq;
CREATE TABLE customer (
  id BIGINT NOT NULL DEFAULT nextval('customer_seq'),  
  firstname VARCHAR(255),
  lastname VARCHAR(255),
  email VARCHAR(255),
  PRIMARY KEY (id)
  );
CREATE UNIQUE INDEX idx_customer_email ON CUSTOMER (email ASC);
CREATE SEQUENCE address_seq;
CREATE TABLE address (
    id BIGINT NOT NULL DEFAULT nextval('address_seq') PRIMARY KEY,
  customer_id BIGINT CONSTRAINT address_customer_ref REFERENCES customer (id),
  street VARCHAR(255),
  city VARCHAR(255),
  country VARCHAR(255)
)
;
CREATE SEQUENCE product_seq;
create table product(
id BIGINT NOT NULL DEFAULT nextval('product_seq')  PRIMARY KEY,
name varchar(250),
description varchar(250),
price integer
)
;
CREATE SEQUENCE product_attribute_seq;
create table product_attributes(
id BIGINT NOT NULL DEFAULT nextval('product_attribute_seq') PRIMARY KEY,
attributes_key 	varchar(250),
attributes 	varchar(250),
product_id  BIGINT CONSTRAINT fk_product_attribute REFERENCES product (id)
)
;
create SEQUENCE order_seq;
create table orders (
id BIGINT NOT NULL DEFAULT nextval('order_seq') PRIMARY KEY,
customer_id BIGINT CONSTRAINT FK_ORDER_CUSTOMER REFERENCES customer (id),
shipping_address_id BIGINT  CONSTRAINT FK_ORDER_ADDRESS REFERENCES address (id)
);
create SEQUENCE line_item_seq;
create table line_item (
id  integer NOT NULL DEFAULT nextval('line_item_seq') PRIMARY KEY,
product_id  BIGINT CONSTRAINT fk_product_line REFERENCES product (id) ,
amount integer,
price integer
)
;
create SEQUENCE cart_seq;
create table cart (
id  integer NOT NULL DEFAULT nextval('cart_seq') PRIMARY KEY,
line_items integer REFERENCES line_item(id),
customer_id integer REFERENCES customer (id)
);
  
INSERT INTO customer(id, first_name, last_name, email) VALUES(100, 'John', 'Doe', 'john@doe.com');
INSERT INTO customer(id, first_name, last_name, email) VALUES(101, 'Jane', 'Doe', 'jane@doe.com');
INSERT INTO customer(id, first_name, last_name, email) VALUES(102, 'Bob', 'Doe', 'bob@doe.com');
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

insert into order (id, customer_id, shippingaddress_id) values (1, 1, 2);
insert into line_item(id, product_id, amount, order_id, price) values (1, 1, 2, 1, 499.0);
insert into line_item(id, product_id, amount, order_id, price) values (2, 2, 1, 1, 1299.0);
  