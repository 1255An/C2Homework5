package pro.sky.java.course2.employeellistcollectionspart1.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeExistException;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
            employees.put(getFullName(employee.getFirstName(), employee.getLastName()), employee);
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
            employees.remove(getFullName(employee.getFirstName(), employee.getLastName()), employee);
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
        return employees.containsKey(getFullName(employee.getFirstName(), employee.getLastName()));
    }

    public Collection<Employee> getAllEmployees() {
        for (Map.Entry<String, Employee> employeeBook : employees.entrySet()) {
        }
        return employees.values();
    }


    private static String getFullName(String name, String lastName) {
        String fullName = name + lastName;
        return fullName;
    }
}

