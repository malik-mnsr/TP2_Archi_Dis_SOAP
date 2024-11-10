package com.example.model;

import java.util.ArrayList;

public class Hotel {
    private int id;
    private String name;
    private int stars;
    private int numberofBeds;
    private ArrayList<Chambre> chambres;
    private Adresse adresse;


    public Hotel(int id, String namehotel, int stars, int numberofBeds){
        this.id=id;
        this.name=namehotel;
        this.stars=stars;
        this.numberofBeds=numberofBeds;
    }

    public Hotel(int id, String name, int stars, double price, int numberofBeds, ArrayList<Chambre> chambres, Adresse adresse) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.numberofBeds = numberofBeds;
        this.chambres = chambres;
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getStars() {
        return stars;
    }


    public void setStars(int stars) {
        this.stars = stars;
    }


    public int getNumberofBeds() {
        return numberofBeds;
    }


    public void setNumberofBeds(int numberofBeds) {
        this.numberofBeds = numberofBeds;
    }


    public ArrayList<Chambre> getChambres() {
        return chambres;
    }


    public void setChambres(ArrayList<Chambre> chambres) {
        this.chambres = chambres;
    }


    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }



    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", numberofBeds=" + numberofBeds +
                ", chambres=" + chambres +
                ", adresse=" + adresse +
                '}';
    }
}
