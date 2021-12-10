package pro.sky.java.course2.employeellistcollectionspart1.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeExistException;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeesList;

    public EmployeeServiceImpl() {
        employeesList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        if (!employeeExist(firstName, lastName)) {
            Employee employeeAdded = new Employee(firstName, lastName);
          employeesList.add(employeeAdded);
            return employeeAdded;
        }
        throw new EmployeeExistException();
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        int index = employeesList.indexOf(new Employee(firstName, lastName));
        if (employeeExist(firstName, lastName)) {
            Employee emloyeeRemoved = new Employee(firstName,lastName);
            employeesList.remove(emloyeeRemoved);
            return emloyeeRemoved;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        int index = employeesList.indexOf(new Employee(firstName, lastName));
        if (employeeExist(firstName, lastName)) {
            return employeesList.get(index);
        }
        throw new EmployeeNotFoundException();
    }

    public boolean employeeExist(String firstName, String lastName) {
            return employeesList.contains(new Employee(firstName, lastName));
        }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }
}
