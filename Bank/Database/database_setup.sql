CREATE DATABASE bankk;

USE bankk;

CREATE TABLE bankk (
    acc_no INT PRIMARY KEY,
    acc_name VARCHAR(50),
    phone_no BIGINT,
    balance DOUBLE,
    email VARCHAR(100),
    pin INT,
    bank_name VARCHAR(50)
);
