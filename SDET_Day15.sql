Create database Employees_DB;
Show databases;
select database();
use Employees_DB;
 
CREATE table Employees(
emp_id INT primary KEY,
emp_name varchar (80),
department varchar(100),
salary decimal(10, 2),
email varchar(200),
joining_date DATE
);
 
select * from Employees;
 
INSERT INTO Employees(emp_id, emp_name, department, salary, email, joining_date)
values
(102, 'Sonali', 'IT', 60000, 'renusai.corptrainer@gmail.com', '2026-06-22'),
(103, 'Radhya', 'Testing', 60000, 'renusai.corptrainer@gmail.com', '2026-06-22'),
(104, 'Renu', 'IT', 60000, NULL, '2026-06-22'),
(105, 'Sai', 'Testing', 60000, 'renusai.corptrainer@gmail.com', '2026-06-22');

-- DROP database Employees_DB;
SET SQL_SAFE_UPDATES = 0;
-- <1> Fetch all employees from the IT department.
SELECT emp_name FROM Employees 
WHERE department = "IT";

-- <2> Update salary for employees in the Testing department.
UPDATE Employees 
SET salary = salary + 3000
WHERE department = "Testing";

-- <3> Delete an employee who resigned from the company.
ALTER TABLE Employees
ADD status VARCHAR(30);
UPDATE Employees
SET status = 'Resigned'
WHERE emp_id = 102;
DELETE FROM Employees
WHERE status = "Resigned";

-- <4> Display employees sorted by highest salary.
SELECT * FROM Employees
ORDER BY salary DESC;

-- <5> Fetch the top 2 highest-paid employees.
SELECT * FROM Employees
ORDER BY salary DESC 
LIMIT 2;

-- <6> Count total employees in the Employees table.
SELECT COUNT(*) AS total_employees
FROM Employees;

-- <7> Calculate average salary of employees.
SELECT AVG(salary) AS average_salary
FROM Employees;

-- <8> Find highest and lowest salary in the company.
SELECT 
MAX(salary) AS highest_salary, 
MIN(salary) AS lowest_salary 
FROM Employees;

-- <9> Count employees department-wise using GROUP BY.
SELECT department, COUNT(*) AS total_employees
FROM Employees
GROUP BY department;

-- <10> Display departments having more than one employee using HAVING.
SELECT department, COUNT(*) AS total_employees
FROM Employees
GROUP BY department
HAVING COUNT(*) > 1;

-- <11> Find employees whose email IDs are NULL.
SELECT * FROM Employees
WHERE email IS NULL;

-- <12> Fetch employees whose names start with the letter ‘R’.
SELECT * FROM Employees
WHERE emp_name LIKE 'R%';

-- <13> Find employees whose salary is between 40000 and 60000.
SELECT * FROM Employees
WHERE salary BETWEEN 40000 AND 60000;

-- <14> Fetch employees belonging to HR and IT departments.
SELECT * FROM Employees
WHERE department IN ('HR', 'IT');

-- <15> Add a new column mobile_number to the Employees table.
ALTER TABLE Employees
ADD mobile_number VARCHAR(15);

-- <16> Rename column emp_name to employee_name.
ALTER TABLE Employees
RENAME COLUMN emp_name TO employee_name;

-- <17> Remove mobile_number column from Employees table.
ALTER TABLE Employees
DROP COLUMN mobile_number;

-- <18> Delete all records from Employees table using TRUNCATE.
-- TRUNCATE TABLE Employees;

-- <19> Permanently delete Employees table.
-- DROP TABLE Employees;

-- <20> Fetch employee names along with department names using JOIN.
SELECT e.employee_name, d.department_name
FROM Employees e
JOIN Departments d
ON e.department_id = d.department_id;

-- <21> Find employees earning more than average salary using subquery.
SELECT * FROM Employees
WHERE salary >
(
    SELECT AVG(salary)
    FROM Employees
);

-- <22> Find duplicate email records in Employees table.
SELECT email, COUNT(*) AS duplicate_count
FROM Employees
GROUP BY email
HAVING COUNT(*) > 1;

-- <23> Verify employee data inserted successfully after API execution.
SELECT * FROM Employees
WHERE employee_id = 101;

-- <24> Delete employees having NULL email IDs.
DELETE FROM Employees
WHERE email IS NULL;

-- <25> Create backup of Employees table.
CREATE TABLE Employees_Backup AS
SELECT * FROM Employees;
