package controller;

import employee.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

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
}
