SELECT UnionTable.employee_id FROM (
  SELECT Employees.employee_id FROM Employees
  UNION ALL
  SELECT Salaries.employee_id FROM Salaries
) AS UnionTable
GROUP BY UnionTable.employee_id HAVING COUNT(UnionTable.employee_id) < 2
ORDER BY UnionTable.employee_id ASC;
