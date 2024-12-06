package br.com.yanmuller.estudospringbootcomjavaaula3.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourseNotFoundExceptions extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public ResourseNotFoundExceptions(String ex) {
        super(ex);
    }
}
