CREATE DATABASE primesoft_cef;
CREATE USER cef_user WITH ENCRYPTED PASSWORD 'cef_user';
GRANT ALL PRIVILEGES ON DATABASE primesoft_cef TO cef_user;

set search_path = 'primesoft_cef';
-- interviewed_by details

CREATE TABLE IF NOT EXISTS candidate_datails
(

    id integer NOT NULL primary key,
    name varchar  NOT NULL,
    email varchar NOT NULL,
    mobile varchar NOT null,
    communication_skills varchar NOT NULL,
    domain_knowldge varchar,
    collaboration_skills varchar NOT NULL,
    culture_fit varchar NOT NULL
);


CREATE TABLE IF NOT EXISTS interview_round
(
 round_id int not null primary key,
 round_no varchar not null default 'FIRST',
 rating numeric,
 candidate_id int references candidate_datails(id),
 interviewed_by int references employee(emp_id),
 is_selected varchar,
 created_at timestamp not null,
 created_by varchar not null,
 updated_at timestamp,
 updated_by varchar
);

CREATE TABLE IF NOT EXISTS interview_questions
(
 question_id int not null primary key,
 question_name varchar not null,
 feedback varchar not null,
 iterview_round_no int references interview_round(round_id),
 created_at timestamp not null,
 created_by varchar not null,
 updated_at timestamp,
 updated_by varchar
);

CREATE TABLE IF NOT EXISTS employee
(
 emp_id int not null primary key,
 emp_name varchar not null,
 email varchar not null,
 created_at timestamp not null,
 created_by varchar not null,
 updated_at timestamp,
 updated_by varchar
);

--CREATE TABLE IF NOT EXISTS candidate_subject_skills
--(
--    id integer NOT NULL,
--    subject varchar  NOT NULL,
--    rating integer,
--    feedback varchar ,
--    is_applicable boolean,
--    candidate_id integer references candidate_datails(id)
--);

--CREATE TABLE IF NOT EXISTS primary_skills
--(
--    id integer NOT NULL,
--    name varchar  NOT NULL,
--    created_at timestamp without time zone,
--    updated_at timestamp without time zone,
--    created_by varchar ,
--    updated_by varchar ,
--    technology integer,
--    CONSTRAINT primary_skills_pkey PRIMARY KEY (id),
--    CONSTRAINT primary_skills_name_key UNIQUE (name)
--);

--CREATE TABLE IF NOT EXISTS technologies
--(
--    id integer NOT NULL,
--    name varchar  NOT NULL,
--    created_at timestamp without time zone,
--    updated_at timestamp without time zone,
--    created_by varchar ,
--    updated_by varchar ,
--    CONSTRAINT technologies_pkey PRIMARY KEY (id),
--    CONSTRAINT technologies_name_key UNIQUE (name)
--);



commit;
