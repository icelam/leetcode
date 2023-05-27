SELECT Manager.name FROM Employee
LEFT JOIN Employee AS Manager ON Employee.managerId = Manager.id
GROUP BY Manager.name
HAVING COUNT(Manager.name) >= 5;
