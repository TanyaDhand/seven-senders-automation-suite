--SQL Task

--problem 1: Return Employee record with highest salary--
select * from employee
where salary in(select max(salary) from employee);

----problem 2: Return the highest salary in employee table--
select max(salary) from employee

--problem 3: Return the highest salary in employee table--
select * from employee e1
where 1=(select count(distinct salary) from employee e2
where e2.salary>e1.salary)

--problem 4: Select range of employees based on id--
select * from employee where emp_id between 10001 and 10007;

--problem 5: Return an employee with highest salary and the employee’s department name--
select e.*, d.department_name from employee e
join department d on
e.department_id = d.department_id
where e.salary = (select max(salary) from employee)

--problem 6: Return highest salary, employee_name, department_name for EACH department--
select ee.first_name, ee.last_name, dd.department_name,
dd.maxsalary
from (
select max(e.salary) as maxsalary,
d.department_name, d.department_id from
employee e join department d on
e.department_id = d.department_id
group by d.department_id,d.department_name) as dd
join employee ee
on ee.department_id=dd.department_id and ee.salary=dd.maxsalary