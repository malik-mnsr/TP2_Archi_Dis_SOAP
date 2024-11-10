package com.example.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private int id;
    private LocalDate dateIn;
    private LocalDate dateOut;

    private int offerId;
    private int chambreid;
    // Total price calculated from the offer price

    // Date formatter for parsing and formatting dates in YYYY-MM-DD format
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Constructor with date strings
    public Reservation(int id, String dateInStr, String dateOutStr, int offerId, int chambreid) {
        this.id = id;
        this.dateIn = LocalDate.parse(dateInStr, DATE_FORMATTER);
        this.dateOut = LocalDate.parse(dateOutStr, DATE_FORMATTER);

        this.offerId = offerId;
        this.chambreid = chambreid;
    }

    // Method to calculate total price based on the offer's price and the number of nights
    private double calculateTotalPrice(double offerPrice) {
        long nights = ChronoUnit.DAYS.between(dateIn, dateOut);
        return offerPrice * nights;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateInStr) {
        this.dateIn = LocalDate.parse(dateInStr, DATE_FORMATTER);
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOutStr) {
        this.dateOut = LocalDate.parse(dateOutStr, DATE_FORMATTER);
    }


    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getChambreid() {
        return chambreid;
    }

    public void setChambreid(int chambreid) {
        this.chambreid = chambreid;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateIn=" + dateIn.format(DATE_FORMATTER) +
                ", dateOut=" + dateOut.format(DATE_FORMATTER) +
                ", offerId=" + offerId +
                ", chambre=" + chambreid +
                '}';
    }
}
