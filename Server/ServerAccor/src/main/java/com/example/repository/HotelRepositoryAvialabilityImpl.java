package com.example.repository;

import com.example.exception.InvalidAgencyCredentialsException;
import com.example.exception.NoAvailabilityException;
import com.example.exception.NoOfferInThisDateException;
import com.example.exception.PersonException;
import com.example.model.Adresse;
import com.example.model.Chambre;
import com.example.model.Offer;
import com.example.model.Reservation;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class HotelRepositoryAvialabilityImpl implements HotelRepositoryAvailability {

    private static final String URL = "jdbc:mysql://localhost:3306/TP2";
    private static final String USER = "root"; // your MySQL username
    private static final String PASSWORD = ""; // your MySQL password
    int agence_id = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String result;
    String name = "";
    int stars = 0;
    int numberofBeds = 0;
    Adresse adresse = new Adresse();
    int adress_id = 0;
    ArrayList<Chambre> chambres = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    ArrayList<Offer> offers = new ArrayList<>();
    String agency_username = "";
    String agency_password = "";
    XMLGregorianCalendar availabilityStart;
    XMLGregorianCalendar availabilityEnd;
    String pic;



    public HotelRepositoryAvialabilityImpl(int ID) throws ClassNotFoundException {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection successful To DATABASE!");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Hotel where hotel_id=" + ID);
                if (rs.next()) {
                    name = rs.getString("name");
                    stars = rs.getInt("stars");
                    numberofBeds = rs.getInt("numberofBeds");
                    adress_id = rs.getInt("adresse_id");
                }
                rs = stmt.executeQuery("select * from Adresse where adresse_id=" + adress_id);
                if (rs.next()) {
                    adresse.setCountry(rs.getString("country"));
                    adresse.setCity(rs.getString("city"));
                    adresse.setStreet(rs.getString("street"));
                    adresse.setPositionGPS(rs.getString("gpsposition"));
                }
                rs = stmt.executeQuery("select * from Chambre where hotel_id=" + ID);
                if (rs.next()) {
                    Chambre chambre = new Chambre();
                    chambre.setIdChambre(rs.getInt("idChambre"));
                    chambre.setNumeroEtage(rs.getInt("numeroEtage"));
                    chambre.setPrice(rs.getInt("price"));
                    chambre.setNumberOfBed(rs.getInt("numberOfBed"));
                    chambre.setPic(rs.getString("Pic"));
                    chambres.add(chambre);
                }
                rs = stmt.executeQuery("select * from Offer where hotel_id=" + ID);
                while (rs.next()) {
                    Offer offer = new Offer();
                    offer.setId(rs.getInt("id"));
                    offer.setAgency_username(rs.getString("agency_username"));
                    agency_username = rs.getString("agency_username");
                    offer.setAgency_password(rs.getString("agency_password"));
                    agency_password = rs.getString("agency_password");
                    offer.setNewPrice(rs.getInt("newPrice"));
                    offer.setAvailabilityStart(rs.getDate("availabilityStart"));
                    availabilityStart = dateToXMLGregorianCalendar(rs.getDate("availabilityStart"));
                    offer.setAvailabilityEnd(rs.getDate("availabilityEnd"));
                    availabilityEnd= dateToXMLGregorianCalendar(rs.getDate("availabilityEnd"));
                    offer.setNumberOfBeds(rs.getInt("numberOfBeds"));
                    numberofBeds = (rs.getInt("numberOfBeds"));
                    offer.setAgency_id(rs.getInt("agency_id"));
                    agence_id=rs.getInt("agency_id");
                    pic=rs.getString("pic");
                    offer.setGetPictureUrl(rs.getString("pic"));
                    offers.add(offer);
                }

                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        @Override
        public String checkAvailability(int agence_id, String username, String password, XMLGregorianCalendar startDate, XMLGregorianCalendar
        endDate, int numberOfPersons)
            throws InvalidAgencyCredentialsException, NoAvailabilityException, PersonException, NoOfferInThisDateException {

            // Check agency credentials
            if (((((agence_id != 1) && agence_id != 2)) && agence_id != 3)) {
                throw new InvalidAgencyCredentialsException("Invalid credentials provided for the agency.");
            }

            // Validate the number of persons
            if (numberOfPersons <= 0 || numberOfPersons > numberofBeds) {
                throw new PersonException("Number of persons must be greater than zero or lower than number of Beds. ");
            }
            ArrayList<Offer> off = new ArrayList<>();

            if (offers.isEmpty()) {
                throw new NoAvailabilityException("No available offers for the specified date range and number of persons.");
            }
            for (Offer offer : offers) {

                if (((startDate.compare(availabilityStart) >= 0) && (endDate.compare(availabilityEnd) <= 0))) {
                    throw new NoOfferInThisDateException("No available offers for the specified date range");
                }

                if (agence_id == offer.getAgency_id()) {
                    off.add(offer);

                }

            }
            return off.toString();
        }


        public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) {
            try {
                // Step 1: Create a GregorianCalendar instance with the Date object
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTime(date);

                // Step 2: Use DatatypeFactory to create an XMLGregorianCalendar from the GregorianCalendar
                return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
            } catch (Exception e) {
                e.printStackTrace();
                return null; // Return null or handle the error as needed
            }
        }
    }




























/*

    @Override
    public String checkAvailability (int agence_id, String username, String password, Date startDate, Date
            endDate, int numberOfPersons)
            throws InvalidAgencyCredentialsException, NoAvailabilityException, PersonException {



    private List<Offer> findAvailableOffers (Date startDate, Date endDate,int numberOfPersons){
        List<Offer> offers = new ArrayList<>();

        String query = "SELECT id, agency_username, agency_password, newPrice, availabilityStart, availabilityEnd, numberOfBeds, chambre_id, agency_id FROM Offer";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(query);


            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String agencyUsername = rs.getString("agency_username");
                    String agencyPassword = rs.getString("agency_password");
                    double newPrice = rs.getDouble("newPrice");
                    Date availabilityStart = rs.getDate("availabilityStart");
                    Date availabilityEnd = rs.getDate("availabilityEnd");
                    int numberOfBeds = rs.getInt("numberOfBeds");
                    int chambreId = rs.getInt("chambre_id");
                    int agencyId = rs.getInt("agency_id");

                    offers.add(new Offer(id, newPrice, availabilityStart, availabilityEnd, numberOfBeds));
                }
            }
        } catch (SQLException e) {
            // Log the exception or throw a custom exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return offers;
    }



    }


*/