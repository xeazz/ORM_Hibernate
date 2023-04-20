CREATE TABLE IF NOT EXISTS Hibernate.customers
(
    id           INT AUTO_INCREMENT,
    name         VARCHAR(256) NOT NULL,
    surname      VARCHAR(256) NOT NULL,
    age          INT          NOT NULL CHECK (age > 0),
    phone_number VARCHAR(256) UNIQUE,
    PRIMARY KEY (id)
);