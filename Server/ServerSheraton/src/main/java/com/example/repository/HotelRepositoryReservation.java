package com.example.repository;

import com.example.exception.*;
import com.example.model.Reservation;

import javax.xml.datatype.XMLGregorianCalendar;

public interface HotelRepositoryReservation {
    Reservation makeReservation(String name, XMLGregorianCalendar startDate, XMLGregorianCalendar endDate, String offer_id) throws ReservationFailedException;
}
