package com.example.model;


public class Client {
    private String name;         // Client's name
    private String phone;        // Client's phone number
    private String mail;         // Client's email address
    private CreditCard creditCard; // Reference to a CreditCard object

    // Constructor
    public Client(int clientId, String name, String phone, String mail, CreditCard creditCard) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.creditCard = creditCard;
    }

    // Getter and setter methods for each attribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    // Override toString() method for easy printing
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }
}
