package com.primeiroprojetospring.ProjetoSpring.course.services.exceptions;

public class DataBaseException extends RuntimeException{

    public DataBaseException(String msg){
        super(msg);
    }
}
