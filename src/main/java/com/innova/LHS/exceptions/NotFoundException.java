package com.innova.LHS.exceptions;

public class NotFoundException extends LHSException {

    public NotFoundException(String message){
        super(404, "NOT_FOUND",message);
    }
}
