SELECT Employee.name AS Employee FROM Employee, Employee AS Manager
WHERE Employee.managerId = Manager.id AND Employee.salary > Manager.salary;
