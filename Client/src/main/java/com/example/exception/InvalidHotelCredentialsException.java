package com.example.exception;

public class InvalidHotelCredentialsException extends Exception{
    private static final long serialVersionUID = 1L;

    public InvalidHotelCredentialsException(String msg) {
        super(msg);
    }
}
