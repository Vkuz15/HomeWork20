package service;

import employee.Employee;


public interface EmployeeService {
    Employee getEmployeeMaxSalary(Integer departmentId);
}
