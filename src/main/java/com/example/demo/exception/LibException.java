package com.example.demo.exception;

public abstract class LibException extends Exception{
	

    private String code;

    private String field;

    private String message;

    public LibException(String code, String field, String message) {
        this.code = code;
        this.field = field;
        this.message = message;
    }

    public LibException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
