package service;

import employee.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee getEmployeeMaxSalary(Integer departmentId) {
        return new Employee("Johan", 5554548, 5);
    }
}
