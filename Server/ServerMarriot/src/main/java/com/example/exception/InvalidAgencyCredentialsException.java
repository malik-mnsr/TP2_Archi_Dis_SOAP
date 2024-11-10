package com.example.exception;
public class InvalidAgencyCredentialsException extends Exception {
    public InvalidAgencyCredentialsException(String message) {
        super(message);
    }
}
