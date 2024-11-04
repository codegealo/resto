CREATE DATABASE restaurant;

CREATE SCHEMA resto;

CREATE TABLE resto.customer (
    id serial PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE resto.order (
    id serial PRIMARY KEY,
    customer_id integer REFERENCES resto.customer(id),
	status VARCHAR(10) DEFAULT 'NEW' NOT NULL,
	details text
);