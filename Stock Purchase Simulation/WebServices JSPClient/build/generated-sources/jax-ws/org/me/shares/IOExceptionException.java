
package org.me.shares;

import javax.xml.ws.WebFault;
import docwebservices.IOException;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "IOException", targetNamespace = "http://DOCwebServices/")
public class IOExceptionException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private IOException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public IOExceptionException(String message, IOException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public IOExceptionException(String message, IOException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: docwebservices.IOException
     */
    public IOException getFaultInfo() {
        return faultInfo;
    }

}