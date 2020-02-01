CREATE DATABASE MyPSQLServer
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

DROP TABLE IF EXISTS states CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS Items CASCADE;
DROP TABLE IF EXISTS Users CASCADE;
DROP TABLE IF EXISTS  attaches CASCADE;
DROP TABLE IF EXISTS  myComments CASCADE;
DROP TABLE IF EXISTS  roles_rules CASCADE;
DROP TABLE IF EXISTS  Rules CASCADE;
DROP TABLE IF EXISTS  roles CASCADE;

create table Rules (
		id serial primary key,
		rule_description varchar (500)
);

create table Roles (
		id serial primary key,
		role_name varchar (150)
);

create table Roles_Rules (
		id serial primary key,
		roles_id integer references Roles(id),
		rules_id integer references Rules(id)
);

create table Users (
		id serial primary key,
		name_surname varchar (200),
		age int,
		role_id integer references Roles(id)
);

create table States (
		id serial primary key,
		description text
);

create table Category (
		id serial primary key,
		type_item int4
);

create table Items (
		id serial primary key,
		name_item varchar (100),
		belongUser integer references Users(id),
		haveState integer references States(id),
		inCategory integer references Category(id)
);

create table Attaches (
		id serial primary key,
		address text,
		belongsItem integer references Items(id)
);

create table myComments (
		id serial primary key,
		comment_from text,
		belongsItem integer references Items(id)
);

insert into roles (role_name) values ('Reader'),('Writer'),('Rewriter');
insert into rules (rule_description) values ('Read'),('Write');
insert into roles_rules (roles_id, rules_id) values (
	(select id from roles where role_name = 'Reader'),
	(select id from rules where rule_description ='Read')
);
insert into roles_rules (roles_id, rules_id) values (
	(select id from roles where role_name = 'Writer'),
	(select id from rules where rule_description ='Write')
);
insert into roles_rules (roles_id, rules_id) values (
	(select id from roles where role_name = 'Rewriter'),
	(select id from rules where rule_description ='Write')
);
insert into roles_rules (roles_id, rules_id) values (
	(select id from roles where role_name = 'Rewriter'),
	(select id from rules where rule_description ='Read')
);
insert into users (name_surname, age , role_id) values (
	'Tiunchik',
	32,
	(select id from roles where role_name = 'Reader')
);
insert into states (description) values ('Ready for shipment') ,('Unready for shipment');
insert into category (type_item) values (1), (2), (3);

insert into items (name_item, belongUser, haveState, inCategory) values (
	'SQL-table',
	(select id from users where name_surname = 'Tiunchik'),
	(select id from states where description = 'Unready for shipment'),
	(select id from category where type_item = 3)
);
insert into Attaches (address ,	belongsItem) values (
		'c:\java\users.java',
		(select id from items where name_item = 'SQL-table')
);
insert into myComments (comment_from ,	belongsItem) values (
		'КГ/АМ',
		(select id from items where name_item = 'SQL-table')
);
--select * from users;
--select * from items;
--select * from attaches;
--select * from myComments;
