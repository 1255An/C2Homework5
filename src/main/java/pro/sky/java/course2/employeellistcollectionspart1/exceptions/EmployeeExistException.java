package pro.sky.java.course2.employeellistcollectionspart1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeExistException extends RuntimeException {

    public EmployeeExistException() {
        super("Employee's book already has this employee");
    }
}
