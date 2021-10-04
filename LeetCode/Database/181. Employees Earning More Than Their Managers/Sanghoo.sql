SELECT employer.name AS Employee
  FROM Employee employer
     , Employee manager
 WHERE employer.managerId = manager.id
   AND employer.salary > manager.salary;