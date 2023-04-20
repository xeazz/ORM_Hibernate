CREATE TABLE IF NOT EXISTS Hibernate.person
(
    name           VARCHAR(256) NOT NULL,
    surname        VARCHAR(256) NOT NULL,
    age            INT NOT NULL CHECK (age > 0),
    phone_number   VARCHAR(256),
    city_in_living VARCHAR(256),
    PRIMARY KEY (name, surname, age)
);
