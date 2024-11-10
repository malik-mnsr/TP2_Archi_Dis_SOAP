package com.example.model;


import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Offer {
    private int id;                  // Unique identifier for the offer
    private double newPrice;         // New price for the offer
    private Date availabilityStart;   // Start date of availability for the offer
    private Date availabilityEnd;     // End date of availability for the offer
    private int numberOfBeds;        // Number of beds in the offer
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String agency_username;
    private String agency_password;
    private int agency_id;
    private String getPictureUrl;
    // Constructor

    public Offer(){

    }
    public Offer(int id, double newPrice, Date availabilityStart, Date availabilityEnd, int numberOfBeds, int agency_id, String getPictureUrl) {
        this.id = id;
        this.newPrice = newPrice;
        this.availabilityStart = availabilityStart;
        this.availabilityEnd = availabilityEnd;
        this.numberOfBeds = numberOfBeds;
        this.agency_id=agency_id;
        this.getPictureUrl=getPictureUrl;
    }

    public Offer(int id, String agency_username, String agency_password, double newPrice, Date availabilityStart, Date availabilityEnd, int numberOfBeds) {
        this.id = id;
        this.agency_username = agency_username;
        this.agency_password = agency_password;
        this.newPrice = newPrice;
        this.availabilityStart = availabilityStart;
        this.availabilityEnd = availabilityEnd;
        this.numberOfBeds = numberOfBeds;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for newPrice
    public double getNewPrice() {
        return newPrice;
    }

    // Setter for newPrice
    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    // Getter for availabilityStart
    public Date getAvailabilityStart() {
        return availabilityStart;
    }

    // Setter for availabilityStart
    public void setAvailabilityStart(Date availabilityStart) {
        this.availabilityStart = availabilityStart;
    }

    // Getter for availabilityEnd
    public Date getAvailabilityEnd() {
        return availabilityEnd;
    }

    // Setter for availabilityEnd
    public void setAvailabilityEnd(Date availabilityEnd) {
        this.availabilityEnd = availabilityEnd;
    }

    // Getter for numberOfBeds
    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    // Setter for numberOfBeds
    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", newPrice=" + newPrice +
                ", availabilityStart=" + availabilityStart +
                ", availabilityEnd=" + availabilityEnd +
                ", numberOfBeds=" + numberOfBeds +
                ", Pic Link= " +getPictureUrl+
                '}';
    }

    public String getAgency_username() {
        return agency_username;
    }

    public void setAgency_username(String agency_username) {
        this.agency_username = agency_username;
    }

    public String getAgency_password() {
        return agency_password;
    }

    public void setAgency_password(String agency_password) {
        this.agency_password = agency_password;
    }

    public int getAgency_id() {
        return agency_id;
    }

    public void setAgency_id(int agency_id) {
        this.agency_id = agency_id;
    }

    public String getGetPictureUrl() {
        return getPictureUrl;
    }

    public void setGetPictureUrl(String getPictureUrl) {
        this.getPictureUrl = getPictureUrl;
    }
}
