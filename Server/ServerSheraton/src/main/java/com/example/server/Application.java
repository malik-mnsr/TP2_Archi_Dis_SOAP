package com.example.server;


import com.example.service.HotelServiceAvailabilityImpl;
import com.example.service.HotelServiceReservation;
import com.example.service.HotelServiceReservationImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication(scanBasePackages = {
        "com.example.exception",
        "com.example.model", //
        "com.example.server", //
        "com.example.service", //
        "com.example.repository"
})
public class Application {
    public static void main(String[] args) throws ClassNotFoundException {
        String SERVICE1_URI =
                "http://localhost:8080/ServerHotelSheraton/Availability"; // URI du service
        String SERVICE2_URI =
                "http://localhost:8080/ServerHotelSheraton/Reservation";
        // Publication du service web
        Endpoint.publish(SERVICE1_URI, new HotelServiceAvailabilityImpl(1));
        System.err.println("Web Service 1 successfully published at: " +
                SERVICE1_URI);

        Endpoint.publish(SERVICE2_URI, new HotelServiceReservationImpl(1));
        System.err.println("Web Service 2 successfully published at: " +
                SERVICE2_URI);

        System.err.println("Server ready!");
    }
}




