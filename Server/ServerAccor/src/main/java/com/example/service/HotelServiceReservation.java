package com.example.service;

import com.example.exception.ReservationFailedException;
import com.example.model.Reservation;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;

@WebService
public interface HotelServiceReservation {
    @WebMethod
    Reservation makeReservation(String name, XMLGregorianCalendar startDate, XMLGregorianCalendar endDate, String offer_id) throws ReservationFailedException;
}
