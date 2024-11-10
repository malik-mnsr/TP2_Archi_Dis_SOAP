package com.example.service;

import com.example.exception.InvalidAgencyCredentialsException;
import com.example.exception.NoAvailabilityException;
import com.example.exception.PersonException;
import com.example.exception.*;
import com.example.model.Offer;
import com.example.repository.HotelRepositoryAvailability;
import com.example.repository.HotelRepositoryAvialabilityImpl;

import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebService(endpointInterface = "com.example.service.HotelServiceAvailability")
public class HotelServiceAvailabilityImpl implements HotelServiceAvailability {
    private HotelRepositoryAvailability repository;

    public HotelServiceAvailabilityImpl(HotelRepositoryAvailability repository){
        this.repository=repository;
    }
    public HotelServiceAvailabilityImpl(int ID) throws ClassNotFoundException {
        this.repository=new HotelRepositoryAvialabilityImpl(ID);
    }


    @Override
    public String checkAvailability(int agence_id, String username, String password, XMLGregorianCalendar startDate, XMLGregorianCalendar endDate, int numberOfPersons) throws InvalidAgencyCredentialsException, NoAvailabilityException, PersonException, NoOfferInThisDateException {
        return repository.checkAvailability(agence_id, username, password, startDate, endDate, numberOfPersons);
    }
}