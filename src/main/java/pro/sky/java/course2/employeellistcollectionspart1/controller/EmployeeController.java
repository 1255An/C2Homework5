package pro.sky.java.course2.employeellistcollectionspart1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam Integer departmentId,
                              @RequestParam Integer salary) {
        Employee result = employeeService.addEmployee(firstName, lastName, departmentId, salary);
        return getMessage(result, "successfully added");
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName) {
        Employee result = employeeService.removeEmployee(firstName, lastName);
        return getMessage(result, "successfully removed");
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/get/employees")
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    private String getMessage(Employee employee, String status) {
        return String.format("Employee %s %s %s %s %s %s %s.",
                employee.getFirstName(),
                employee.getLastName(),
                "department: ", employee.getDepartmentId(),
                "salary: ", employee.getSalary(),
                status);
    }


}
