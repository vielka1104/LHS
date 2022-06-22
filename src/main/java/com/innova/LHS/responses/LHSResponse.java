package com.innova.LHS.responses;

import java.io.Serializable;

public class LHSResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;
    private String status;
    private String message;
    private T data;

    public LHSResponse(int code, String status,String message, T data){
        this.status = status;
        this.code = code ;
        this.message = message;
        this.data = data;

    }

    public LHSResponse(int code, String status, String message){
        this.status = status;
        this.code = code ;
        this.message = message;
    }
}
