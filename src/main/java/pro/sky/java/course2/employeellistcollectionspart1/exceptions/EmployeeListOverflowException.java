package pro.sky.java.course2.employeellistcollectionspart1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class EmployeeListOverflowException extends RuntimeException {

    public EmployeeListOverflowException() {
        super("Employee list is full");
    }
}
