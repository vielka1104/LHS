package com.innova.LHS.exceptions;

public class InternalServerErrorException extends LHSException {

    public InternalServerErrorException(String message){
        super(500,"INTERNAL_SERVER_ERROR",message);
    }
}
