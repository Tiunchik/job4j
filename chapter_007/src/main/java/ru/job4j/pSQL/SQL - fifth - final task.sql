drop table if exists users cascade;
drop table if exists meetings cascade;
drop table if exists attends cascade;
drop table if exists status cascade;


--1. Есть таблица встреч(id, name), есть таблица юзеров(id, name).
--Нужно доработать модель базы данных, так чтобы пользователи могли учавствовать во встречах. У каждого участника встречи может быть разный статус участия - например подтвердил участие, отклонил.
create table if not exists meetings (
	id serial primary key,
	names varchar(200)
);

create table if not exists users (
	id serial primary key,
	names varchar(200)
);

create table if not exists attends (
	id serial primary key,
	meeting_id integer not null references meetings(id),
	users_id integer not null references users(id)
);

create table if not exists status (
	attends_id integer references attends(id),
	status varchar(30) check (
		status = 'accept' or
		status = 'denied' or
		status = 'notrespond'
	)
);


select * from attends;
insert into meetings (names) values ('first meeting'), ('second meeting'), ('third meeting');
insert into users (names) values ('Adam'), ('Alan'), ('Mark');
insert into attends (meeting_id, users_id) values (1,1), (1,2), (1,3), (2,1), (2,2), (2,3) ,(3,1), (3,2), (3,3);
insert into status (attends_id, status) values (1,'accept'), (2,'accept'), (3,'denied'), (4,'denied'), (5,'denied'), (6,'notrespond'), (7,'denied'), (8,'accept'), (9,'notrespond');
insert into meetings (names) values ('forth meeting'), ('fiveth meeting');
--insert into status (attends_id, status) values (10,'notrespond'), (11,'notrespond'), (12,'notrespond'), (13,'denied'), (14,'denied'), (15,'notrespond');
insert into attends (users_id, meeting_id) values ((select id from users where users.names ='Adam'), (select id from meetings where meetings.names ='fiveth meeting') );

insert into status (attends_id, status) values ((select id from attends where users_id=(select id from users where users.names ='Adam')
												 and meeting_id =(select id from meetings where meetings.names ='fiveth meeting') ),'denied');

--2. Нужно написать запрос, который получит список всех заяков и количество подтвердивших участников.
select meetings.names, tbs.accepted from meetings left outer join (select meetings.names as names, count(status.status) as accepted
			 from meetings left outer join attends on meetings.id = attends.meeting_id right outer join
			 status on status.attends_id = attends.id where status.status = 'accept' group by meetings.names) as tbs on meetings.names = tbs.names;


--3. Нужно получить все совещания, где не было ни одной заявки на посещения
select aa from (select meetings.names as aa, count(attends.meeting_id) from meetings left outer join attends on meetings.id = attends.meeting_id
														left outer join status on attends.id = status.attends_id group by meetings.names) as OneTable
left outer join
(select meetings.names as bb, count(status.status) from meetings left outer join attends on meetings.id = attends.meeting_id
														left outer join status on attends.id = status.attends_id where status.status = 'accept'
														group by meetings.names) as TwoTable
on aa=bb where bb is null;
