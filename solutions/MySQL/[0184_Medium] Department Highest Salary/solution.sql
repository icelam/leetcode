SELECT
  Department.name AS Department,
  Employee.name AS Employee,
  Employee.salary
FROM Employee
LEFT JOIN Department ON Employee.departmentId = Department.id
WHERE (Employee.departmentId , Employee.salary) IN (
  SELECT
    Employee.departmentId,
    MAX(Employee.salary)
  FROM Employee
  GROUP BY Employee.departmentId
);
