package pro.sky.java.course2.employeellistcollectionspart1.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeExistException;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.InvalidName;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer departmentId, Integer salary) {
        if (isNameValid(firstName, lastName)) {
            Employee newEmployee = new Employee(StringUtils.capitalize(firstName),
                    StringUtils.capitalize(lastName),
                    departmentId, salary);
            return addEmployee(newEmployee);
        } else {
            throw new InvalidName();
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        String key = getKey(employee);
        if (!employeeExist(employee)) {
            employees.put(key, employee);
            return employee;
        } else {
            throw new EmployeeExistException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, Integer departmentId, Integer salary) {
        Employee newEmployee = new Employee(firstName, lastName, departmentId, salary);
        return removeEmployee(newEmployee);
    }

    @Override
    public Employee removeEmployee(Employee employee) {
        String key = getKey(employee);
        if (!employeeExist(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(key, employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, Integer departmentId, Integer salary) {
        String key = getKey(firstName, lastName);
        Employee employee = employees.get(key);
        if (!employeeExist(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> getAllEmployees() {
        return employees.values();
    }

    private String getKey(Employee employee) {
        return getKey(employee.getFirstName(), employee.getLastName());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public boolean employeeExist(Employee employee) {
        String key = getKey(employee);
        return employees.containsKey(key);
    }

    public boolean isNameValid(String firstName, String lastName) {
        return (StringUtils.isAlphaSpace(firstName) && StringUtils.isAlphaSpace(lastName));
    }
}

