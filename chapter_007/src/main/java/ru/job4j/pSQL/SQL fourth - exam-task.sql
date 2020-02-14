CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id)
);

-- 1) Retrieve in a single query:
-- - names of all persons that are NOT in the company with id = 5
-- - company name for each person
select person.name, company.name from company right outer join person on person.company_id = company.id where person.company_id <> 5;

-- 2) Select the name of the company with the maximum number of persons + number of persons in this company
WITH tbl AS (select company.name as cnames, count(person.company_id) as quant
from company, person where person.company_id = company.id group by company.name)
select * from tbl where quant >= ALL(select quant from tbl);