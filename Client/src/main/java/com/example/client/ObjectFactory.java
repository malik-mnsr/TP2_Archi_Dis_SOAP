
package com.example.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PersonException_QNAME = new QName("http://service.example.com/", "PersonException");
    private final static QName _CheckAvailability_QNAME = new QName("http://service.example.com/", "checkAvailability");
    private final static QName _CheckAvailabilityResponse_QNAME = new QName("http://service.example.com/", "checkAvailabilityResponse");
    private final static QName _InvalidAgencyCredentialsException_QNAME = new QName("http://service.example.com/", "InvalidAgencyCredentialsException");
    private final static QName _NoAvailabilityException_QNAME = new QName("http://service.example.com/", "NoAvailabilityException");
    private final static QName _NoOfferInThisDateException_QNAME = new QName("http://service.example.com/", "NoOfferInThisDateException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NoOfferInThisDateException }
     * 
     */
    public NoOfferInThisDateException createNoOfferInThisDateException() {
        return new NoOfferInThisDateException();
    }

    /**
     * Create an instance of {@link CheckAvailabilityResponse }
     * 
     */
    public CheckAvailabilityResponse createCheckAvailabilityResponse() {
        return new CheckAvailabilityResponse();
    }

    /**
     * Create an instance of {@link PersonException }
     * 
     */
    public PersonException createPersonException() {
        return new PersonException();
    }

    /**
     * Create an instance of {@link CheckAvailability }
     * 
     */
    public CheckAvailability createCheckAvailability() {
        return new CheckAvailability();
    }

    /**
     * Create an instance of {@link NoAvailabilityException }
     * 
     */
    public NoAvailabilityException createNoAvailabilityException() {
        return new NoAvailabilityException();
    }

    /**
     * Create an instance of {@link InvalidAgencyCredentialsException }
     * 
     */
    public InvalidAgencyCredentialsException createInvalidAgencyCredentialsException() {
        return new InvalidAgencyCredentialsException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "PersonException")
    public JAXBElement<PersonException> createPersonException(PersonException value) {
        return new JAXBElement<PersonException>(_PersonException_QNAME, PersonException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAvailability }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "checkAvailability")
    public JAXBElement<CheckAvailability> createCheckAvailability(CheckAvailability value) {
        return new JAXBElement<CheckAvailability>(_CheckAvailability_QNAME, CheckAvailability.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAvailabilityResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "checkAvailabilityResponse")
    public JAXBElement<CheckAvailabilityResponse> createCheckAvailabilityResponse(CheckAvailabilityResponse value) {
        return new JAXBElement<CheckAvailabilityResponse>(_CheckAvailabilityResponse_QNAME, CheckAvailabilityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidAgencyCredentialsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "InvalidAgencyCredentialsException")
    public JAXBElement<InvalidAgencyCredentialsException> createInvalidAgencyCredentialsException(InvalidAgencyCredentialsException value) {
        return new JAXBElement<InvalidAgencyCredentialsException>(_InvalidAgencyCredentialsException_QNAME, InvalidAgencyCredentialsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoAvailabilityException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "NoAvailabilityException")
    public JAXBElement<NoAvailabilityException> createNoAvailabilityException(NoAvailabilityException value) {
        return new JAXBElement<NoAvailabilityException>(_NoAvailabilityException_QNAME, NoAvailabilityException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoOfferInThisDateException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.example.com/", name = "NoOfferInThisDateException")
    public JAXBElement<NoOfferInThisDateException> createNoOfferInThisDateException(NoOfferInThisDateException value) {
        return new JAXBElement<NoOfferInThisDateException>(_NoOfferInThisDateException_QNAME, NoOfferInThisDateException.class, null, value);
    }

}
