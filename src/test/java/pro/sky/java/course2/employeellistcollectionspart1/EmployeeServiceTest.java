package pro.sky.java.course2.employeellistcollectionspart1;

import net.bytebuddy.pool.TypePool;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeExistException;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.employeellistcollectionspart1.service.EmployeeService;
import pro.sky.java.course2.employeellistcollectionspart1.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private EmployeeService out;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee("Ivan", "Ivanov", 1, 50000);
        employee2 = new Employee("Zoya", "Zoykina", 2, 60000);
        employee3 = new Employee("Petya", "Petrovich", 1, 70000);

        out = new EmployeeServiceImpl();

        out.addEmployee(employee1);
        out.addEmployee(employee2);
        out.addEmployee(employee3);
    }

    @Test
    public void addEmployeeTest() {

        Collection<Employee> expected = out.getAllEmployees();
        Collection<Employee> actual = new ArrayList<>();

        actual.add(employee1);
        actual.add(employee2);
        actual.add(employee3);

        assertTrue(CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void addEmployeeTestIfEmployeeAlreadyExist() {
        assertThrows(EmployeeExistException.class, () -> out.addEmployee(employee1));
    }

    @Test
    public void removeEmployeeTest() {
        Collection<Employee> expected = out.getAllEmployees();
        expected.remove(employee3);
        Collection<Employee> actual = new ArrayList<>();
        actual.add(employee1);
        actual.add(employee2);
        assertTrue(CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void removeEmployeeTestIfItNotFound() {
        Collection<Employee> expected = out.getAllEmployees();
        expected.remove(employee3);
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(employee3));
    }

    @Test
    public void findEmployeeTest() {
        Employee result = out.findEmployee("Zoya", "Zoykina");
        assertEquals(employee2, result);
    }

    @Test
    public void findEmployeeTestIfItNotFound() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee("Vasya", "Vasilev"));
    }

    @Test
    public void getAllEmployeesTestNotNull() {
        Collection<Employee> expected = out.getAllEmployees();
        assertNotNull(expected);
    }
}
