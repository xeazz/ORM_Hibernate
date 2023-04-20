CREATE TABLE IF NOT EXISTS Hibernate.orders
(
    id           INT AUTO_INCREMENT,
    date         VARCHAR(256) NOT NULL,
    customer_id  INT,
    product_name VARCHAR(256) NOT NULL,
    amount       INT,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers (id)
);