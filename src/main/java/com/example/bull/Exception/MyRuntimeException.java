package com.example.bull.Exception;

public class MyRuntimeException extends RuntimeException {

    private Integer code;

    private String  message;


    public MyRuntimeException(Integer code) {
        this.code = code;
    }

    public MyRuntimeException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public MyRuntimeException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public MyRuntimeException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }

    public MyRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
