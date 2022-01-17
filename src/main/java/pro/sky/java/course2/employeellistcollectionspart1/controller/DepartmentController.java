package pro.sky.java.course2.employeellistcollectionspart1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.service.DepartmentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments/max-salary")
    public Employee getMaxSalaryEmployeeInDepartment(@RequestParam Integer departmentId) {
        return departmentService.getMaxSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("/departments/min-salary")
    public Employee getMinSalaryEmployeeInDepartment(@RequestParam Integer departmentId) {
        return departmentService.getMinSalaryEmployeeInDepartment(departmentId);
    }

    @GetMapping("/departments/getAll")
    public Collection<Employee> getAllEmployeesFromDepartment(@RequestParam Integer departmentId) {
        return departmentService.getAllEmployeesFromDepartment(departmentId);
    }

    @GetMapping("/departments/all")
    public Collection<Employee> getAllEmployeesInDepartment() {
        return departmentService.getAllEmployeesInDepartment();
    }
}
