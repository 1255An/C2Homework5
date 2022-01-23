package pro.sky.java.course2.employeellistcollectionspart1.service;

import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer departmentId, Integer salary);

    Employee addEmployee(Employee employee);

    Employee removeEmployee(String firstName, String lastName);

    Employee removeEmployee(Employee employee);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();


}
