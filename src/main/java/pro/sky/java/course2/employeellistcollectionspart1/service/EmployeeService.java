package pro.sky.java.course2.employeellistcollectionspart1.service;

import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee remove(Employee employee);

    Employee find(String firstName, String lastName);
}
