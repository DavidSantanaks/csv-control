CREATE TABLE person
(
    person_id SERIAL PRIMARY KEY,
    first_name VARCHAR(200),
    surname VARCHAR(200),
    email VARCHAR(200),
    gender VARCHAR(200),
    access_ip VARCHAR(200),
    age INTEGER,
    birth_date VARCHAR(200)
);