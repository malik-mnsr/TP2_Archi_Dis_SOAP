package com.example.exception;
public class ReservationFailedException extends Exception {
    public ReservationFailedException(String message) {
        super(message);
    }
}