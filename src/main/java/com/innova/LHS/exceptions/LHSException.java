package com.innova.LHS.exceptions;

import lombok.Getter;

@Getter
public class LHSException extends  Exception {
    private static final long serialVersionUID = 1L;

    private final int code;
    private final String status;

    public LHSException(int code, String status, String message){
        super(message);
        this.code = code;
        this.status = status;
    }
}
