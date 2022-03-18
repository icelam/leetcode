SELECT Employee.name AS Employee FROM Employee
JOIN Employee Manager ON Employee.managerId = Manager.id
WHERE Employee.salary > Manager.salary;
