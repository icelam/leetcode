SELECT RankedSalary.Department, RankedSalary.Employee, RankedSalary.Salary FROM (
  SELECT
    Department.name AS Department,
    Employee.name AS Employee,
    Employee.salary AS Salary,
    DENSE_RANK() OVER (PARTITION BY Employee.departmentId ORDER BY Employee.departmentId ASC, Employee.salary DESC) AS 'Rank'
  FROM Employee
  LEFT JOIN Department ON Employee.departmentId = Department.id
) AS RankedSalary
WHERE RankedSalary.Rank <= 3;
