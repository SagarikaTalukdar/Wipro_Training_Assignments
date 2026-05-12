create database company;
use company;
create table company.employee(
id int primary key,
name varchar(50),
department varchar(50),
salary int
);
select* from company.employee;

DELIMITER //

CREATE PROCEDURE SearchEmployee(IN empid INT)
BEGIN
    SELECT * FROM employee WHERE id = empid;
END //

DELIMITER ;

CREATE TABLE users(
    username VARCHAR(50),
    password VARCHAR(50)
);
INSERT INTO users VALUES
('admin','admin123'),
('rahul','rahul123'),
('amit','amit123');

CREATE TABLE employees(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    department VARCHAR(50),
    salary DOUBLE
);