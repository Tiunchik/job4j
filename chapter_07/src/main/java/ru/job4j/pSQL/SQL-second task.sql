drop table if exists product cascade;
drop table if exists typeProd cascade;

create table typeProd(
	id_type			serial primary key, 
	nameType		varchar(100) unique
);

create table product(
	id_prod 		serial primary key, 
	nameProd 		varchar(100), 
	type_id 		integer references typeProd(id_type), 
	expired_date 	date, 
	price 			int4,
	quantity		int4
);

insert into typeProd(nameType) values ('СЫР'), ('МОЛОКО'), ('ШОКОЛАД'), ('МЯСО');
insert into product (nameProd, type_id, expired_date, price, quantity) values
('Мороженное мясо',
(select id_type from typeProd where nametype = 'МЯСО'),
('2020-10-24'),
(4500),
(15)),
('Мороженное эскимо',
(select id_type from typeProd where nametype = 'МОЛОКО'),
('2020-03-31'),
(45),
(24)),
('Российский',
(select id_type from typeProd where nametype = 'СЫР'),
('2020-05-31'),
(450),
(7)),
('Пискарёвское молоко',
(select id_type from typeProd where nametype = 'МОЛОКО'),
('2020-02-10'),
(70),
(2))
;

create view print AS
select * from product, typeProd
where product.type_id = typeProd.id_type;

select * from print;

--1. Написать запрос получение всех продуктов с типом "СЫР"
select * from product 
where type_id = (select id_type from typeProd where nameType = 'СЫР');

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product 
where nameProd similar to '%(М|м)ороженное%'; --чрез like, как я понял, узор не сделать, судя по главе 9.7. Pattern Matching из руководства

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from print
where expired_date < '2020-02-29'

--4. Написать запрос, который выводит самый дорогой продукт.
select * from product
where price = (select max(price) from product);

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select count(type_id) from product
where type_id = (select id_type from typeProd where nameType = 'МОЛОКО');

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from print
where type_id = (select id_type from typeProd where nameType = 'МОЛОКО') or type_id = (select id_type from typeProd where nameType = 'СЫР');

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select * from product
where quantity <= 10;

--8. Вывести все продукты и их тип.
select product.nameprod, typeprod.nametype from
product,
typeprod
where product.type_id = typeProd.id_type;