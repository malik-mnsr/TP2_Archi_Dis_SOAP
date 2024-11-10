package com.example.main;

import com.example.client.*;
import com.example.exception.*;
import com.example.model.Agency;

import javax.swing.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.example.model.*;

import static com.example.model.DateConversion.toXMLGregorianCalendar;

public class DatabaseConnection {

    public static void main(String[] args) throws MalformedURLException,  InvalidHotelCredentialsException {
        String url = "jdbc:mysql://localhost:3306/TP2";
        String user = "root";
        String password = "";
        int agencyId = 0;
        String username = "";
        String agencyPassword = "";
        LocalDate startDate = LocalDate.parse("1980-01-01");
        LocalDate endDate = LocalDate.parse("1980-01-01");
        int numberOfPersons = 0;
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        XMLGregorianCalendar xmlstartDate = toXMLGregorianCalendar(startDate);
        XMLGregorianCalendar xmlendDate = toXMLGregorianCalendar(endDate);
        String name;
        int client_id;


        try {
            URL url1 = new URL("http://localhost:8080/ServerHotelSheraton/Availability?wsdl");
            HotelServiceAvailabilityImplService avImpl1 = new HotelServiceAvailabilityImplService(url1);
            HotelServiceAvailability proxyav1 = avImpl1.getHotelServiceAvailabilityImplPort();
            URL url2 = new URL("http://localhost:8080/ServerHotelSheraton/Reservation?wsdl");
            HotelServiceReservationImplService rsImpl1 = new HotelServiceReservationImplService(url2);
            HotelServiceReservation proxyrs1 = rsImpl1.getHotelServiceReservationImplPort();


            URL url3 = new URL("http://localhost:8081/ServerMarriot/Availability?wsdl");
            HotelServiceAvailabilityImplService avImpl2 = new HotelServiceAvailabilityImplService(url3);
            HotelServiceAvailability proxyav2 = avImpl2.getHotelServiceAvailabilityImplPort();
            URL url4 = new URL("http://localhost:8081/ServerMarriot/Reservation?wsdl");
            HotelServiceReservationImplService rsImpl2 = new HotelServiceReservationImplService(url4);
            HotelServiceReservation proxyrs2 = rsImpl2.getHotelServiceReservationImplPort();
            Class.forName("com.mysql.cj.jdbc.Driver");

            URL url5 = new URL("http://localhost:8082/ServerAccor/Availability?wsdl");
            HotelServiceAvailabilityImplService avImpl3 = new HotelServiceAvailabilityImplService(url3);
            HotelServiceAvailability proxyav3 = avImpl3.getHotelServiceAvailabilityImplPort();
            URL url6 = new URL("http://localhost:8082/ServerAccor/Reservation?wsdl");
            HotelServiceReservationImplService rsImpl3 = new HotelServiceReservationImplService(url4);
            HotelServiceReservation proxyrs3 = rsImpl3.getHotelServiceReservationImplPort();
            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");


            Statement stmt = conn.createStatement();


            String agencySql = "SELECT agency_id, username, password, name FROM Agency";
            ResultSet agencyRs = stmt.executeQuery(agencySql);


            List<Agency> agencies = new ArrayList<>();

            System.out.println("Available Agencies:");

            while (agencyRs.next()) {
                agencyId = agencyRs.getInt("agency_id");
                username = agencyRs.getString("username");
                agencyPassword = agencyRs.getString("password");
                String agencyName = agencyRs.getString("name");


                Agency agency = new Agency(agencyId, username, agencyPassword, agencyName);
                agencies.add(agency);


                System.out.println(agencyId + ": " + agencyName);
            }


            System.out.print("Which agency do you want to use? (Enter the agency number): ");
            int agencyChoice = scanner.nextInt();
            scanner.nextLine();

            // Process the result set for agencies
            Agency selectedAgency = null;
            for (Agency agency : agencies) {
                if (agency.getAgencyId() == agencyChoice) {
                    selectedAgency = agency;
                    break;
                }
            }
            String hotelSql = "SELECT hotel_id, name, stars, numberofBeds FROM Hotel";
            ResultSet hotelRs = stmt.executeQuery(hotelSql);

            List<Hotel> hotels = new ArrayList<>();

            System.out.println("Available Hotels:");

            while (hotelRs.next()) {
                int hotelId = hotelRs.getInt("hotel_id");
                String hotelName = hotelRs.getString("name");
                int stars = hotelRs.getInt("stars");
                int numberOfBeds = hotelRs.getInt("numberofBeds");

                Hotel hotel = new Hotel(hotelId, hotelName, stars, numberOfBeds);
                hotels.add(hotel);

                System.out.println(hotelId + ": " + hotelName + " (" + stars + " stars, " + numberOfBeds + " beds)");
            }

            System.out.print("Which hotel do you want to use? (Enter the hotel number): ");
            int hotelChoice = scanner.nextInt();
            scanner.nextLine();


            Hotel selectedHotel = null;
            for (Hotel hotel : hotels) {
                if (hotel.getId() == hotelChoice) {
                    selectedHotel = hotel;
                    break;
                }

                if (selectedHotel.getId() == 1 || selectedHotel.getId() == 2 || selectedHotel.getId() == 3) {
                    System.out.println("You selected: " + selectedHotel.getName() + " (" + selectedHotel.getStars() + " stars, " + selectedHotel.getNumberofBeds() + " beds)");
                }


            }


            if (selectedAgency != null) {

                System.out.println("You have selected: " + selectedAgency.getName() + " ID: " + selectedAgency.getAgencyId());
                System.out.println("Login Please");

                System.out.print("Enter your email: ");
                String email = scanner.nextLine();
                System.out.print("Enter your phone number: ");
                String phone = scanner.nextLine();


                String clientSql = "SELECT * FROM Client WHERE mail = '" + email + "' AND phone = '" + phone + "'";
                ResultSet clientRs = stmt.executeQuery(clientSql);
                if (selectedAgency.getAgencyId() == 1 || selectedAgency.getAgencyId() == 2 || selectedAgency.getAgencyId() == 3) {
                    if (clientRs.next()) {

                        System.out.println("Login successful! Welcome, " + clientRs.getString("name"));
                        name = clientRs.getString("name");
                        System.out.println("Would you like to see availabilite Offers or make a reservation\n");
                        client_id = clientRs.getInt("client_id");
                        System.out.println("Type 1: Avialability Service\n");
                        String choice = scanner.nextLine();
                        switch (choice) {
                            case "1":
                                try {
                                    System.out.print("Enter start date (YYYY-MM-DD): \n");
                                    startDate = LocalDate.parse(scanner.nextLine(), formatter);
                                    System.out.print("Enter end date (YYYY-MM-DD): \n");
                                    endDate = LocalDate.parse(scanner.nextLine(), formatter);
                                    System.out.print("Enter the number of persons: \n");
                                    numberOfPersons = scanner.nextInt();
                                } catch (Exception e) {
                                    System.out.println("Invalid input. Please ensure dates are in YYYY-MM-DD format.");
                                }

                                if (proxyav1.checkAvailability(selectedAgency.getAgencyId(), username, agencyPassword, xmlstartDate, xmlendDate, numberOfPersons) != null) {
                                    System.out.println("Offers Avialable");
                                    System.out.println(proxyav1.checkAvailability(selectedAgency.getAgencyId(), username, agencyPassword, xmlstartDate, xmlendDate, numberOfPersons));

                                    List<Offer> offers = OfferParser.parseOffers(proxyav1.checkAvailability(selectedAgency.getAgencyId(), username, agencyPassword, xmlstartDate, xmlendDate, numberOfPersons));
                                    SwingUtilities.invokeLater(() -> {
                                        OfferViewer viewer = new OfferViewer(offers);
                                        viewer.setVisible(true);
                                    });
                                    System.out.println("Would you like to make a reservation type 1, To exit type 0");
                                    int choice1 = scanner.nextInt();
                                    int offerid;
                                    if (choice1 == 1) {
                                        try {
                                            System.out.println("Choose offer with id");
                                            offerid = scanner.nextInt();
                                            System.out.println("Add your Credit Card info:\n");
                                            System.out.println("Number: \n");
                                            int number = scanner.nextInt();
                                            System.out.println("CVV: \n");
                                            int cvv = scanner.nextInt();
                                            String sql1 = "INSERT INTO CreditCard (client_id, name,number, cvv) VALUES (?, ?, ?, ?)";
                                            PreparedStatement add = conn.prepareStatement(sql1);
                                            add.setInt(1, client_id);
                                            add.setString(2, name);
                                            add.setInt(3, number);
                                            add.setInt(4, cvv);
                                            int rowsInserted = add.executeUpdate();
                                            if (rowsInserted > 0) {
                                                System.out.println("A new credit card was inserted successfully!");
                                            }
                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }

                                        try {
                                            System.out.println("Reservation Confirmed " + proxyrs1.makeReservation(name, xmlstartDate, xmlendDate, String.valueOf(offerid)));
                                            System.out.println("Reference for your reservation");
                                            String Sql = "SELECT reference FROM Reservation";
                                            PreparedStatement add1 = conn.prepareStatement(Sql);
                                            ResultSet Rs = add1.executeQuery(Sql);
                                            Rs.next();
                                            int ref = Rs.getInt("Reference");
                                            System.out.println(ref);
                                        } catch (ReservationFailedException_Exception e) {
                                            throw new RuntimeException(e);
                                        }

                                    } else {
                                        System.out.println("GoodBye");
                                        clientRs.close();
                                        agencyRs.close();
                                        stmt.close();
                                        conn.close();


                                    }

                                }
                                break;
                            default:
                                System.out.println("Type a valid number");
                                break;
                        }

                    }
                    stmt.close();
                    conn.close();
                } else {
                    System.out.println("Invalid email or phone number. Please try again.");
                }
                clientRs.close();
            } else {

                throw new InvalidHotelCredentialsException("Invalid agency number selected.");
            }




        } catch (PersonException_Exception | InvalidAgencyCredentialsException_Exception |
                 NoOfferInThisDateException_Exception | NoAvailabilityException_Exception | ClassNotFoundException |
                 SQLException e) {
            throw new RuntimeException(e);


        }
    }
}
















/*                    switch (choice) {
                        case "1":
                            try {
                                System.out.print("Enter start date (YYYY-MM-DD): \n");
                                startDate = LocalDate.parse(scanner.nextLine(), formatter);
                                System.out.print("Enter end date (YYYY-MM-DD): \n");
                                endDate = LocalDate.parse(scanner.nextLine(), formatter);
                                System.out.print("Enter the number of persons: \n");
                                numberOfPersons = scanner.nextInt();
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please ensure dates are in YYYY-MM-DD format.");
                            }
                            if (proxyav1.checkAvailability(agencyId, username, agencyPassword, xmlstartDate, xmlendDate, numberOfPersons) != null) {
                                System.out.println("Offers Avialable");
                                System.out.println(proxyav1.checkAvailability(agencyId, username, agencyPassword, xmlstartDate, xmlendDate, numberOfPersons));
                                System.out.println("Would you like to make a reservation type 1, To exit type 0");
                                int choice1 = scanner.nextInt();

                                if (choice1 == 1) {

                                    System.out.println("Choose offer with id");
                                    int offerid = scanner.nextInt();
                                    System.out.println("Add your Credit Card info:\n");
                                    System.out.println("Number: \n");
                                    int number = scanner.nextInt();
                                    System.out.println("CVV: \n");
                                    int cvv = scanner.nextInt();
                                    String sql1 = "INSERT INTO CreditCard (client_id, name,number, cvv) VALUES (?, ?, ?, ?)";
                                    PreparedStatement add = conn.prepareStatement(sql1);
                                    {

                                        add.setInt(1, client_id);
                                        add.setString(2, name);
                                        add.setInt(3, number);
                                        add.setInt(4, cvv);
                                        int rowsInserted = add.executeUpdate();
                                        if (rowsInserted > 0) {
                                            System.out.println("A new credit card was inserted successfully!");
                                        }
                                    }
                                    try {
                                        System.out.println("Reservation Confirmed " + proxyrs1.makeReservation(name, xmlstartDate, xmlendDate, String.valueOf(offerid)));
                                        System.out.println("Reference for your reservation");
                                        String Sql = "SELECT reference FROM Reservation";
                                        PreparedStatement add1 = conn.prepareStatement(Sql);
                                        ResultSet Rs = add1.executeQuery(Sql);
                                        Rs.next();
                                        int ref = Rs.getInt("Reference");
                                        System.out.println(ref);
                                    } catch (ReservationFailedException_Exception e) {

                                    }

                                } else {
                                    System.out.println("GoodBye");
                                    clientRs.close();
                                    agencyRs.close();
                                    stmt.close();
                                    conn.close();


                                }
                            }
                            break;
                        default:
                            System.out.println("Make sure you add an avialable number");
                            break; */