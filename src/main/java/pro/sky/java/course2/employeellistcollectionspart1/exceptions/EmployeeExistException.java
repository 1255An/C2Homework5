package pro.sky.java.course2.employeellistcollectionspart1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeExistException extends RuntimeException {

    public EmployeeExistException() {
        super("Employee list has already this employee");
    }
}
