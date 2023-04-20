SELECT Employee.name, Bonus.bonus FROM Employee
LEFT JOIN Bonus ON Employee.empId = Bonus.empId
WHERE Bonus.bonus IS null OR Bonus.bonus < 1000;
