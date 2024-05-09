package service;

import employee.Employee;
import exception.EmployeeNotFoundException;
import exception.InvalidNameException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = List.of(
            new Employee("Владимир", 10000, 1),
            new Employee("Дмитрий", 15000, 2),
            new Employee("Алена", 18000, 4),
            new Employee("Наталья", 13000, 2),
            new Employee("Татьяна", 11000, 5)
    );

    public Employee getEmployeeMaxSalary(Integer departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Данный сотрудник отсутствует"));
    }

    @Override
    public Employee getEmployeeMinSalary(Integer departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException("Данный сотрудник отсутствует"));
    }

    @Override
    public List<Employee> getAllEmployees(Integer departmentId) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesDepatment() {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee add(String firstName, int department, int salary) {
        return null;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        validateNames(firstName, lastName);
        return null;
    }

    @Override
    public Employee delete(String firstName, int department, int salary) {
        Employee newEmployee = new Employee(firstName, department, salary);
        boolean deleted = false;
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.equals(newEmployee)) {
                employees.remove(i);
            }
        }

        return newEmployee;
    }

    @Override
    public Employee find(String firstName, int department, int salary) {
        Employee newEmployee = new Employee(firstName, department, salary);
        for (Employee employee : employees) {
            if (employee.equals(newEmployee)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудника не смогли найти" + firstName);
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }

    private void validateNames(String... names) {
        for (String name : names) {
            if (!isAlpha(name)) {
                throw new InvalidNameException(name);
            }
        }
    }

}
