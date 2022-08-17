select employee_id from (SELECT employee_id FROM employees e
where employee_id not in (select employee_id from salaries)
UNION
SELECT employee_id FROM salaries where  employee_id not in (select employee_id from employees)) as t order by t.employee_id asc;
