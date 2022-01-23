package pro.sky.java.course2.employeellistcollectionspart1;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;
import pro.sky.java.course2.employeellistcollectionspart1.exceptions.EmployeeNotFoundException;
import pro.sky.java.course2.employeellistcollectionspart1.service.DepartmentServiceImpl;
import pro.sky.java.course2.employeellistcollectionspart1.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.employeellistcollectionspart1.DataForDepartmentTest.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    public void setUp() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn
                (List.of(new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1),
                        new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_ID_2, SALARY_2)));
    }

    @Test
    public void getMaxSalaryEmployeeInDepartmentTest() {
        Employee actual = out.getMaxSalaryEmployeeInDepartment(DEPARTMENT_ID_1);
        Employee expected = new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_ID_2, SALARY_2);
        assertEquals(actual, expected);
    }

    @Test
    public void getMaxSalaryEmployeeInDepartmentTestWhenDepartmentIsEmpty() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getMaxSalaryEmployeeInDepartment(5));
    }

    @Test
    public void getMinSalaryEmployeeInDepartmentTest() {
        Employee actual = out.getMinSalaryEmployeeInDepartment(DEPARTMENT_ID_1);
        Employee expected = new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1);
        assertEquals(actual, expected);
    }

    @Test
    public void getMinSalaryEmployeeInDepartmentTestWhenDepartmentIsEmpty() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getMinSalaryEmployeeInDepartment(5));
    }

    @Test
    public void getAllEmployeesFromDepartmentTest () {
        Collection<Employee> actual = out.getAllEmployeesFromDepartment(DEPARTMENT_ID_1);
        Collection<Employee> expected = List.of(new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1),
                new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_ID_1, SALARY_2));
        assertTrue(CollectionUtils.isEqualCollection(expected, actual));
    }

    @Test
    public void getAllEmployeesFromDepartmentTestWhenDepartmentIsEmpty() {
        Collection<Employee> actual = out.getAllEmployeesFromDepartment(5);
        List<Employee> expected = Collections.emptyList();
        assertEquals(expected, actual);
    }

    @Test
    public void getAllEmployeesDividedByDepartmentTest () {
        Map<Integer, List <Employee>> actual = out.getAllEmployeesDividedByDepartment();
        Map<Integer, List <Employee>> expected = Map.of(
                DEPARTMENT_ID_1,
                List.of(new Employee(FIRST_NAME_1, LAST_NAME_1, DEPARTMENT_ID_1, SALARY_1),
                        new Employee(FIRST_NAME_2, LAST_NAME_2, DEPARTMENT_ID_1, SALARY_2)));
        assertEquals(expected, actual);
    }
}

