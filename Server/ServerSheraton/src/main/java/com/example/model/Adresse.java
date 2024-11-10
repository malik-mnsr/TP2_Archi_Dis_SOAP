package com.example.model;


public class Adresse {
    private String country;      // Country of the address
    private String city;         // City of the address
    private String street;       // Street of the address
    private String positionGPS;   // GPS position of the address

    // Constructor
    public  Adresse() {

    }
    public Adresse(String country, String city, String street, String positionGPS) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.positionGPS = positionGPS;
    }

    // Getter for country
    public String getCountry() {
        return country;
    }

    // Setter for country
    public void setCountry(String country) {
        this.country = country;
    }

    // Getter for city
    public String getCity() {
        return city;
    }

    // Setter for city
    public void setCity(String city) {
        this.city = city;
    }

    // Getter for street
    public String getStreet() {
        return street;
    }

    // Setter for street
    public void setStreet(String street) {
        this.street = street;
    }

    // Getter for positionGPS
    public String getPositionGPS() {
        return positionGPS;
    }

    // Setter for positionGPS
    public void setPositionGPS(String positionGPS) {
        this.positionGPS = positionGPS;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Adresse{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", positionGPS='" + positionGPS + '\'' +
                '}';
    }
}
