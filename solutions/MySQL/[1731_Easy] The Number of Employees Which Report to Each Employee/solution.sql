SELECT
  Managers.employee_id,
  Managers.name,
  COUNT(Employees.reports_to) AS reports_count,
  ROUND(AVG(Employees.age), 0) AS average_age
FROM Employees Managers
JOIN Employees ON Managers.employee_id = Employees.reports_to
GROUP BY Managers.employee_id
ORDER BY Managers.employee_id;

