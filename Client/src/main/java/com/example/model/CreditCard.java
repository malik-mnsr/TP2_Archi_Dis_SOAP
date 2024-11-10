package com.example.model;


public class CreditCard {
    private String name;            // Name on the card
    private String number;          // Card number
    private String cvv;             // CVV code

    // Constructor
    public CreditCard(String name, String number, String cvv) {
        this.name = name;
        this.number = number;
        this.cvv = cvv;
    }

    // Getter and setter methods for each attribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }


    // Override toString() method for easy printing
    @Override
    public String toString() {
        return "CreditCard{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
