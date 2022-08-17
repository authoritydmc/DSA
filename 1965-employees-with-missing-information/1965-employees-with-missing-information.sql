# select employee_id from (SELECT employee_id FROM employees e
# where employee_id not in (select employee_id from salaries)
# UNION
# SELECT employee_id FROM salaries where  employee_id not in (select employee_id from employees)) as t order by t.employee_id asc;


SELECT T.employee_id
FROM  
  (SELECT * FROM Employees LEFT JOIN Salaries USING(employee_id)
   UNION 
   SELECT * FROM Employees RIGHT JOIN Salaries USING(employee_id))
AS T
WHERE T.salary IS NULL OR T.name IS NULL
ORDER BY employee_id;