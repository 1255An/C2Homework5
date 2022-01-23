package pro.sky.java.course2.employeellistcollectionspart1.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.employeellistcollectionspart1.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee getMaxSalaryEmployeeInDepartment(Integer departmentId);

    Employee getMinSalaryEmployeeInDepartment(Integer departmentId);

    Collection<Employee> getAllEmployeesFromDepartment(Integer department);

    Map<Integer, List<Employee>> getAllEmployeesDividedByDepartment();
}
