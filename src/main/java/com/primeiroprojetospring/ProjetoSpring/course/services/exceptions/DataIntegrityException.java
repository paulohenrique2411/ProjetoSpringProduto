package com.primeiroprojetospring.ProjetoSpring.course.services.exceptions;

public class DataIntegrityException extends RuntimeException {
    public DataIntegrityException(String message) {
        super(message);
    }
}
