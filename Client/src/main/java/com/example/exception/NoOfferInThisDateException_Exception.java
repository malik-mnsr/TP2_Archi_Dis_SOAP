
package com.example.exception;

import com.example.client.NoOfferInThisDateException;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NoOfferInThisDateException", targetNamespace = "http://service.example.com/")
public class NoOfferInThisDateException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NoOfferInThisDateException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NoOfferInThisDateException_Exception(String message, NoOfferInThisDateException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NoOfferInThisDateException_Exception(String message, NoOfferInThisDateException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.example.client.NoOfferInThisDateException
     */
    public NoOfferInThisDateException getFaultInfo() {
        return faultInfo;
    }

}
