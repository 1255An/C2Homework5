package pro.sky.java.course2.employeellistcollectionspart1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.add(firstName, lastName);
        return getMessage(result, "successfully added");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.remove(firstName, lastName);
        return getMessage(result, "successfully removed");
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    private String getMessage(Employee employee, String status) {
        return String.format("Employee %s %s %s.", employee.getFirstName(), employee.getLastName(), status);
    }

    @GetMapping("/get")
    public List<Employee> getEmployeesList() {
        return employeeService.getEmployeesList();
    }
}
