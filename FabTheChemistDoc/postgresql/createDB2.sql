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
  