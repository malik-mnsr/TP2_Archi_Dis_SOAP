package com.example.repository;

import com.example.exception.InvalidAgencyCredentialsException;
import com.example.exception.NoAvailabilityException;
import com.example.exception.NoOfferInThisDateException;
import com.example.exception.PersonException;


import javax.xml.datatype.XMLGregorianCalendar;

public interface HotelRepositoryAvailability {
    String checkAvailability(int agence_id, String username , String password , XMLGregorianCalendar startDate, XMLGregorianCalendar endDate, int numberOfPersons)
            throws InvalidAgencyCredentialsException, NoAvailabilityException, PersonException, NoOfferInThisDateException;
}
