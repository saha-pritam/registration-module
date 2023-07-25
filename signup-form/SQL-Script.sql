drop database if exists jspdb ;
create database jspdb;
use jspdb;
create table users
(
	id integer primary key auto_increment,
	username varchar(50) unique,
	about varchar(50),
	first_name varchar(50),
	last_name varchar(50),
	email varchar(50) unique,
	country varchar(50),
	street_address varchar(50),
	city varchar(50),
	region varchar(50),
	postal_code varchar(50),
	comments varchar(50),
	candidates varchar(50),
	offers varchar(50),
	push_notifications varchar(50)
);