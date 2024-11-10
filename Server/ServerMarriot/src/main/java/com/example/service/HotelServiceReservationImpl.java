package com.example.service;

import com.example.exception.ReservationFailedException;
import com.example.model.Reservation;
import com.example.repository.HotelRepositoryReservation;
import com.example.repository.HotelRepositoryReservationImpl;

import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;
@WebService(endpointInterface = "com.example.service.HotelServiceReservation")

public class HotelServiceReservationImpl implements HotelServiceReservation{
    private HotelRepositoryReservation repository1;

    public HotelServiceReservationImpl(HotelRepositoryReservation repository){
        this.repository1=repository;
    }
    public HotelServiceReservationImpl(int ID) throws ClassNotFoundException {
        this.repository1=new HotelRepositoryReservationImpl(ID);
    }

    @Override
    public Reservation makeReservation(String name, XMLGregorianCalendar startDate, XMLGregorianCalendar endDate, String offer_id) throws ReservationFailedException {
        return repository1.makeReservation(name, startDate, endDate, offer_id);
    }
}
