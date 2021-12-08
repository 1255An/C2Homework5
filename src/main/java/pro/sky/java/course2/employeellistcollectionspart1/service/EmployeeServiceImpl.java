package pro.sky.java.course2.employeellistcollectionspart1.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeExistException;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    int size;

    List<Employee> employeesList;

    public EmployeeServiceImpl() {
        employeesList = new ArrayList<>();
    }

    @Override
    public Employee add(String firstName, String lastName) {
        if (!employeeExist(firstName, lastName)) {
            size++;
            employeesList.add(new Employee(firstName, lastName));
            return new Employee(firstName, lastName);
        }
        throw new EmployeeExistException();
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        int index = employeesList.indexOf(new Employee(firstName, lastName));
        if (index != -1 && employeeExist(firstName, lastName)) {
            size--;
            employeesList.remove(new Employee(firstName, lastName));
            return new Employee(firstName, lastName);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        int index = employeesList.indexOf(new Employee(firstName, lastName));
        if (index != -1) {
            size--;
            return employeesList.get(index);
        }
        throw new EmployeeNotFoundException();
    }

    public boolean employeeExist(String firstName, String lastName) {
        if (employeesList.contains(new Employee(firstName, lastName))) {
            return true;
        } else {
            return false;
        }
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }
}
