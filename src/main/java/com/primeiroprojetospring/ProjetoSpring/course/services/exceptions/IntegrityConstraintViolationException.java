package com.primeiroprojetospring.ProjetoSpring.course.services.exceptions;

public class IntegrityConstraintViolationException extends RuntimeException {
    public IntegrityConstraintViolationException(String message) {
        super(message);
    }
}
