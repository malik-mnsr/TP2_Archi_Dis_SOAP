package com.example.model;


public class Chambre {
    private int idChambre;          // Unique identifier for the room
    private int numeroEtage;        // Floor number of the room
    private double price;            // Price of the room
    private int numberOfBed;         // Number of beds in the room
    private String pic;              // Picture of the room (file path or URL)

    // Constructor
    public Chambre(){

    }
    public Chambre(int idChambre, int numeroEtage, double price, int numberOfBed, String pic) {
        this.idChambre = idChambre;
        this.numeroEtage = numeroEtage;
        this.price = price;
        this.numberOfBed = numberOfBed;
        this.pic = pic; // Initialize the picture field
    }

    // Getter for idChambre
    public int getIdChambre() {
        return idChambre;
    }

    // Setter for idChambre
    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    // Getter for numéroEtage
    public int getNumeroEtage() {
        return numeroEtage;
    }

    // Setter for numeroEtage
    public void setNumeroEtage(int numeroEtage) {
        this.numeroEtage = numeroEtage;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for numberOfBed
    public int getNumberOfBed() {
        return numberOfBed;
    }

    // Setter for numberOfBed
    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    // Getter for pic
    public String getPic() {
        return pic;
    }

    // Setter for pic
    public void setPic(String pic) {
        this.pic = pic;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Chambre{" +
                "idChambre=" + idChambre +
                ", numéroEtage=" + numeroEtage +
                ", price=" + price +
                ", numberOfBed=" + numberOfBed +
                ", pic='" + pic + '\'' + // Include the picture field in the string representation
                '}';
    }
}
