package com.example.model;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;

public class DateConversion {
    public static XMLGregorianCalendar toXMLGregorianCalendar(LocalDate localDate) {
        try {
            return DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(localDate.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

