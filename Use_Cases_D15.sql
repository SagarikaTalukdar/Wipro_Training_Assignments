-- <1> Active Users Without Login
CREATE DATABASE Use_Cases;
USE Use_Cases;
CREATE TABLE users (
user_id INT PRIMARY KEY,
user_name VARCHAR(50),
email VARCHAR(50),
status VARCHAR(50),
last_login DATETIME
);
INSERT INTO users (user_id, user_name, email, status, last_login)
VALUES
(1, 'Rahul', 'rahul@gmail.com', "ACTIVE", NULL),
(2, 'Sneha', 'sneha@gmail.com', "ACTIVE", "2026-05-01 10:00:00"),
(3, 'Aman', 'aman@gmail.com', "INACTIVE", NULL),
(4, 'Priya', 'sneha@gmail.com', "ACTIVE", NULL);

select * from users;

SELECT user_name, email 
FROM users
WHERE status = "ACTIVE"
AND last_login IS NULL;

-- <2> High Value Customers
CREATE TABLE customers (
customer_id INT PRIMARY KEY,
customer_name VARCHAR(100)
);
INSERT INTO customers 
VALUES
(101, 'Arjun'),
(102, 'Neha'),
(103, 'Rohit');
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    order_amount DECIMAL(10,2)
);
INSERT INTO orders 
VALUES
(1, 101, 30000),
(2, 101, 25000),
(3, 102, 15000),
(4, 103, 60000);

SELECT c.customer_name,
       SUM(o.order_amount) AS total_order_amount
FROM customers c
JOIN orders o
ON c.customer_id = o.customer_id
GROUP BY c.customer_name
HAVING SUM(o.order_amount) > 50000;

-- <3> Salary Audit Report
CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DECIMAL(10,2)
);
INSERT INTO employees VALUES
(1, 'Ravi', 'IT', 80000),
(2, 'Anjali', 'HR', 50000),
(3, 'Karan', 'IT', 90000),
(4, 'Meera', 'Finance', 75000),
(5, 'Vikas', 'Testing', 65000);

SELECT name, salary
FROM employees
WHERE salary > (
    SELECT AVG(salary)
    FROM employees
)
ORDER BY salary DESC
LIMIT 3;

-- <4> Department-wise Employee Count [table of Q3]
SELECT department,
       COUNT(emp_id) AS employee_count
FROM employees
GROUP BY department;

-- <5> Orders Without Customer [same table from Q2]
INSERT INTO orders VALUES
(5, 999, 20000);

SELECT o.order_id
FROM orders o
LEFT JOIN customers c
ON o.customer_id = c.customer_id
WHERE c.customer_id IS NULL;

-- <6> Recently Joined Employees [ same table from Q4]
CREATE TABLE employee_joining (
    emp_id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    joining_date DATE
);
INSERT INTO employee_joining VALUES
(1, 'Rahul', 'IT', '2024-01-10'),
(2, 'Sneha', 'HR', '2024-05-12'),
(3, 'Aman', 'Finance', '2023-11-20'),
(4, 'Priya', 'Testing', '2024-03-15'),
(5, 'Kunal', 'IT', '2024-06-01'),
(6, 'Riya', 'HR', '2024-07-18');

SELECT *
FROM employee_joining
WHERE YEAR(joining_date) = 2024
ORDER BY joining_date DESC
LIMIT 5;

-- <7> Duplicate Email Detection [same table from Q1]
SELECT email,
       COUNT(*) AS duplicate_count
FROM users
GROUP BY email
HAVING COUNT(*) > 1;

-- drop DATABASE Use_Cases;