package pro.sky.java.course2.employeellistcollectionspart1.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private final EmployeeService employeeService;


    public Employee getMaxSalaryEmployeeInDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Employee getMinSalaryEmployeeInDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    public Collection<Employee> getAllEmployeesFromDepartment(Integer departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .collect(Collectors.toList());
    }

    public Collection<Employee> getAllEmployeesInDepartment() {
        return employeeService.getAllEmployees().stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .collect(Collectors.toList());

    }

}
