CREATE DATABASE db_example;
CREATE USER 'test'@'localhost'
  IDENTIFIED BY 'test@MYSQL2018';
GRANT ALL ON db_example.* TO 'test'@'localhost';

CREATE TABLE test (
  id   BIGINT(20) NOT NULL,
  name VARCHAR(20)
);

INSERT INTO test VALUES (1, test),
  (2, hello), (3, world);
