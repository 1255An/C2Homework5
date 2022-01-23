package pro.sky.java.course2.employeellistcollectionspart1.data;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private Integer departmentId;
    private Integer salary;

    public Employee(String firstName, String lastName) {
        this(firstName, lastName, 0, 0);
    }

    public Employee(String firstName, String lastName, Integer departmentId, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Integer getSalary() {
        return salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId &&
                salary == employee.salary &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + departmentId +
                ", salary=" + salary +
                '}';
    }


}
