package pro.sky.java.course2.employeellistcollectionspart1.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeExistException;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees;


    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        if (employeeExist(employee)) {
            throw new EmployeeExistException();
        } else {
            employees.put(employee.getFullName(
                    employee.getFirstName(),
                    employee.getLastName()), employee);
            return employee;
        }
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        if (!employeeExist(employee)) {
            throw new EmployeeNotFoundException();
        } else {
            employees.remove(employee.getFullName(
                    employee.getFirstName(),
                    employee.getLastName()), employee);
            return employee;
        }
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employeeExist(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public boolean employeeExist(Employee employee) {
        return employees.containsKey(employee.getFullName(
                employee.getFirstName(),
                employee.getLastName()));
    }

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }
}

