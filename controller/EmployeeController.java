package controller;

import employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeMaxSalary(Integer departmentId) {
        return employeeService.getEmployeeMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeMinSalary(Integer departmentId) {
        return employeeService.getEmployeeMinSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(Integer departmentId) {
        return employeeService.getAllEmployees(departmentId);
    }

    @GetMapping("/all-departments")
    public Map<Integer, List<Employee>> getAllEmployeesDepartment() {
        return employeeService.getAllEmployeesDepatment();
    }


}
