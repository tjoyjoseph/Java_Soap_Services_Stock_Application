
package docwebservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CurrencyConversionWS", targetNamespace = "http://DOCwebServices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CurrencyConversionWS {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     * @throws ParseException_Exception
     * @throws IOException_Exception
     */
    @WebMethod(operationName = "GetConversionRate")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetConversionRate", targetNamespace = "http://DOCwebServices/", className = "docwebservices.GetConversionRate")
    @ResponseWrapper(localName = "GetConversionRateResponse", targetNamespace = "http://DOCwebServices/", className = "docwebservices.GetConversionRateResponse")
    @Action(input = "http://DOCwebServices/CurrencyConversionWS/GetConversionRateRequest", output = "http://DOCwebServices/CurrencyConversionWS/GetConversionRateResponse", fault = {
        @FaultAction(className = IOException_Exception.class, value = "http://DOCwebServices/CurrencyConversionWS/GetConversionRate/Fault/IOException"),
        @FaultAction(className = ParseException_Exception.class, value = "http://DOCwebServices/CurrencyConversionWS/GetConversionRate/Fault/ParseException")
    })
    public double getConversionRate(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1)
        throws IOException_Exception, ParseException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(operationName = "GetCurrencyCodes")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetCurrencyCodes", targetNamespace = "http://DOCwebServices/", className = "docwebservices.GetCurrencyCodes")
    @ResponseWrapper(localName = "GetCurrencyCodesResponse", targetNamespace = "http://DOCwebServices/", className = "docwebservices.GetCurrencyCodesResponse")
    @Action(input = "http://DOCwebServices/CurrencyConversionWS/GetCurrencyCodesRequest", output = "http://DOCwebServices/CurrencyConversionWS/GetCurrencyCodesResponse")
    public List<String> getCurrencyCodes();

}
