package com.example.repository;

import com.example.exception.ReservationFailedException;
import com.example.model.Offer;
import com.example.model.Reservation;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class HotelRepositoryReservationImpl implements HotelRepositoryReservation {
    private static final String URL = "jdbc:mysql://localhost:3306/TP2";
    private static final String USER = "root"; // your MySQL username
    private static final String PASSWORD = ""; // your MySQL password
    XMLGregorianCalendar availabilityStart;
    XMLGregorianCalendar availabilityEnd;
    int offerId;
    int agencyId;
    ArrayList<Offer> offers = new ArrayList();
    int chambreId;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public HotelRepositoryReservationImpl(int ID) throws ClassNotFoundException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful To DATABASE!");
            Statement stmt = conn.createStatement();
            ResultSet rs =
                    rs = stmt.executeQuery("select * from Offer where hotel_id=" + ID);
            if (rs.next()) {
                Offer offer = new Offer();
                offerId = rs.getInt("id");
                offer.setId(rs.getInt("id"));
                offer.setAgency_username(rs.getString("agency_username"));
                offer.setAgency_password(rs.getString("agency_password"));
                offer.setNewPrice(rs.getInt("newPrice"));
                offer.setAvailabilityStart(rs.getDate("availabilityStart"));
                availabilityStart = dateToXMLGregorianCalendar(rs.getDate("availabilityStart"));
                offer.setAvailabilityEnd(rs.getDate("availabilityEnd"));
                availabilityEnd = dateToXMLGregorianCalendar(rs.getDate("availabilityEnd"));
                offer.setNumberOfBeds(rs.getInt("numberOfBeds"));
                chambreId = rs.getInt("chambre_id");
                agencyId = rs.getInt("agency_id");
                offer.setAgency_id(rs.getInt("agency_id"));
                offers.add(offer);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reservation makeReservation(String name, XMLGregorianCalendar startDate, XMLGregorianCalendar endDate, String offer_id) throws ReservationFailedException {
        if (offer_id == null || offer_id.isEmpty()) {
            throw new ReservationFailedException("Invalid offer ID provided.");
        }

        if (((startDate.compare(availabilityStart) >= 0) && (endDate.compare(availabilityEnd) <= 0))) {
            throw new ReservationFailedException("End date must be after the start date.");
        }
        int reservationId = Math.abs(UUID.randomUUID().hashCode());
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");


            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection successful to the database!");

            // SQL query to insert a new reservation
            String sql = "INSERT INTO Reservation (inDate, outDate, idChambre, offer_id, reference) VALUES (?, ?, ?, ?, ?)";

            // Prepare the statement
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Set the values for the parameters
            pstmt.setDate(1, convertXMLGregorianCalendarToSQLDate(startDate));
            pstmt.setDate(2, convertXMLGregorianCalendarToSQLDate(endDate));
            pstmt.setInt(3, chambreId);
            pstmt.setInt(4, offerId);
            pstmt.setString(5, String.valueOf(reservationId));

            // Execute the insert statement
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new reservation was inserted successfully!");
            }
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


        return new Reservation(
                reservationId,
                convertXMLGregorianCalendarToString(startDate),
                convertXMLGregorianCalendarToString(endDate),
                offerId,
                chambreId

        );

    }
    public static java.sql.Date convertXMLGregorianCalendarToSQLDate(XMLGregorianCalendar xmlGregorianCalendar) {
        if (xmlGregorianCalendar == null) {
            return null;  // Return null if the XMLGregorianCalendar is null
        }


        GregorianCalendar gregorianCalendar = xmlGregorianCalendar.toGregorianCalendar();


        return new java.sql.Date(gregorianCalendar.getTimeInMillis());
    }
        public static String convertXMLGregorianCalendarToString(XMLGregorianCalendar xmlGregorianCalendar) {
        // Convert XMLGregorianCalendar to LocalDate
        LocalDate localDate = xmlGregorianCalendar.toGregorianCalendar().toZonedDateTime().toLocalDate();

        // Return the formatted date as a String
        return localDate.format(DATE_FORMATTER);
    }
    public static XMLGregorianCalendar dateToXMLGregorianCalendar(Date date) {
        try {

            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(date);


            return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error as needed
        }
    }
}
  /*
        return new Reservation(
                reservationId,
                agencyId,
                offerId,
                startDate,
                endDate,
                "Confirmed"
        );
    }
    */