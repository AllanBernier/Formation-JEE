
CREATE DATABASE IF NOT EXISTS myapp;
USE myapp;

DROP TABLE IF EXISTS  Product;

CREATE TABLE Product(
	id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
	description VARCHAR(255),
	price FLOAT
)


INSERT INTO product(name, description, price) VALUES
("tel", "apareil telephonique", 180.5),
("citrouille", "legumes", 2.8),
("carottes", "legumes", 1.5)
