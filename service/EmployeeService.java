package service;

import employee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface EmployeeService {

    Employee add(String firstName, int department, int salary);

    Employee delete(String firstName, int department, int salary);

    Employee find(String firstName, int department, int salary);

    Collection<Employee> findAll();

    Employee getEmployeeMaxSalary(Integer departmentId);

    Employee getEmployeeMinSalary(Integer departmentId);

    List<Employee> getAllEmployees(Integer departmentId);

    Map<Integer, List<Employee>> getAllEmployeesDepatment();
}
