package com.example.service;


import com.example.exception.InvalidAgencyCredentialsException;
import com.example.exception.NoAvailabilityException;
import com.example.exception.NoOfferInThisDateException;
import com.example.exception.PersonException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;

@WebService
public interface HotelServiceAvailability {
    @WebMethod
    String checkAvailability(int agence_id, String username , String password , XMLGregorianCalendar startDate, XMLGregorianCalendar endDate, int numberOfPersons
    ) throws InvalidAgencyCredentialsException, NoAvailabilityException, PersonException, NoOfferInThisDateException;

}
