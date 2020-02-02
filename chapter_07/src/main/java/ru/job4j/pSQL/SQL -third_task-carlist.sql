drop table if exists carlist cascade;
drop table if exists carbody cascade;
drop table if exists engine cascade;
drop table if exists transmission cascade;

create table carbody(
		id 				serial primary key,
		typecar 		varchar(80) unique
);

create table engine(
		id 				serial primary key,
		engine 			varchar(80) unique
);

create table transmission (
		id 				serial primary key,
		transmission  	varchar(80) unique
);

create table carlist (
		id 				serial primary key,
		modek_name		varchar(150),
		typecar			int2 references carbody(id),
		engine			int2 references engine(id),
		transmission	int2 references transmission(id)
);

insert into carbody (typecar) values ('sedan'), ('coupe'), ('hatchback'), ('crossover');
insert into engine (engine) values ('4A-GE'), ('1JZ-GE'), ('B16B'), ('2JZ-GTE'), ('S50B30');
insert into transmission (transmission) values ('AT'), ('MT'), ('AM'), ('CVT');
insert into carlist (modek_name, typecar, engine, transmission) values (
	'Toyota Levin',
	(select id from carbody where carbody.typecar = 'coupe'),
	(select id from engine where engine.engine = '4A-GE'),
	(select id from transmission where transmission.transmission = 'MT')),
(	'Toyota Mark2',
	(select id from carbody where carbody.typecar = 'sedan'),
	(select id from engine where engine.engine = '1JZ-GE'),
	(select id from transmission where transmission.transmission = 'AT')),
(	'Honda Civic',
	(select id from carbody where carbody.typecar = 'hatchback'),
	(select id from engine where engine.engine = 'B16B'),
	(select id from transmission where transmission.transmission = 'MT'));


select cr.modek_name, cb.typecar, en.engine, tr.transmission  
from carlist as cr left outer 	join carbody as cb on cr.typecar = cb.id  
						  	 	join engine as en on cr.engine = en.id 
						  	 	join transmission as tr on cr.transmission = tr.id;


select carbody.typecar, engine.engine, transmission.transmission  from carlist full outer join carbody on carlist.typecar = carbody.id  
						  full outer join engine on carlist.engine = engine.id 
						  full outer join transmission on carlist.transmission = transmission.id
						  where carlist.modek_name is null;
						 
						 