/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.shares;

import com.sun.xml.fastinfoset.util.StringArray;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.persistence.Table;
import javax.swing.JTable;
import shareCompanies.ShareTrade;
import java.lang.String;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import shareCompanies.CompanyShare;
import Shares.SharesUnmarshall;
import Shares.XMLFileHandler;
import docwebservices.CurrencyConversionWSService;
import docwebservices.IOException_Exception;
import docwebservices.ParseException_Exception;
import java.io.IOException;
import static java.lang.Math.round;
import java.text.DecimalFormat;
import javax.xml.ws.WebServiceRef;
import org.kohsuke.rngom.digested.Main;
import static sun.misc.Version.println;
import sun.util.logging.resources.logging;
import userlogin.UserAuthentication_Service;



/**
 *
 * @author Toby Joseph
 */
@WebService(serviceName = "PurchaseShares")
@Stateless()
public class PurchaseShares {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/UserAuthentication/UserAuthentication.wsdl")
    private UserAuthentication_Service service;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CurrencyConvertor/CurrencyConversionWSService.wsdl")
    private CurrencyConversionWSService currencyConversionWSService;
    private DecimalFormat df = new DecimalFormat("#.##");

    
    private boolean compareTexts(String subject, String comparingValue)
    {
        boolean match = false;
        
        //int ShortestString = comparingValue.length();
        
        if (comparingValue.length() > subject.length()){
            //ShortestString = subject.length();
            match = false;
        } else {
            
            for (int i = 0;i < comparingValue.length(); i++)
            {
                if (subject.toUpperCase().charAt(i) == comparingValue.toUpperCase().charAt(i))
                {
                    match = true;
                }
                else
                {
                    match = false;
                    break;
                }
            }
            
        }
        
        return match;
        
    }
    
    private void test(){
        currencyConversionWSService.getCurrencyConversionWSPort().getCurrencyCodes();
    }
    
    private CompanyShare filterCompany(CompanyShare companyShareDetails, String filterVar){
        ///// TODO filter the company shares
        boolean match = compareTexts(companyShareDetails.getCompanyName(), filterVar);
        
        if (match == false){
            match = compareTexts(companyShareDetails.getCompanySymbol(),filterVar);
        }
        
        if (match == false)
        {
            companyShareDetails.setCompanyName("");
            companyShareDetails.setCompanySymbol("");
            companyShareDetails.setNumOfAvailShares(0);
            companyShareDetails.getSharePrice().setCurrency("");
            companyShareDetails.getSharePrice().setDateOfLastUpdate("");
            companyShareDetails.getSharePrice().setValue(0);
        }
                

        return companyShareDetails;
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "getShares")
    public List<CompanyShare> getShares(String filterVar, String currencyType) throws IOException, IOException_Exception, ParseException_Exception {
        //TODO write your implementation code here
        
        List<CompanyShare> allCompanyShareDetails = new ArrayList<>();
        //ShareTrade tempCompanyData = Shares.XMLFileHandler.getCompanyShareDetails();

        //CompanyShare companyShareDetails = Shares.XMLFileHandler.getCompanyShareDetails(index);
        
        for(int i = 0; i< Shares.XMLFileHandler.getCompanyShareDetails().getCompanyShares().size(); i++){
            CompanyShare companyShareDetails = Shares.XMLFileHandler.getCompanyShareDetails().getCompanyShares().get(i);
//            if (companyShareDetails != null)
//            {
                if ( filterVar != null){
                companyShareDetails = filterCompany(companyShareDetails,filterVar);}
                //tempCompanyShareDetails.add(companyShareDetails.getCompanyName());
                //tempCompanyShareDetails.add(companyShareDetails.getCompanySymbol());
                //tempCompanyShareDetails.add(Integer.toString(companyShareDetails.getNumOfAvailShares()));
                if (currencyType != null) 
                {
                    double exchangeRate = currencyConversionWSService.getCurrencyConversionWSPort().getConversionRate(companyShareDetails.getSharePrice().getCurrency().toUpperCase(),currencyType.toUpperCase());
                    companyShareDetails.getSharePrice().setCurrency(currencyType.toUpperCase());
                    //companyShareDetails.getSharePrice().setValue(Math.round(companyShareDetails.getSharePrice().getValue()*exchangeRate)/100);
                    
                    companyShareDetails.getSharePrice().setValue( Double.parseDouble(new DecimalFormat("##.00").format(companyShareDetails.getSharePrice().getValue()*exchangeRate)));
                    
                    //companyShareDetailsString.add(Double.toString(tempValue));

                }//else{
                //companyShareDetailsString.add(companyShareDetails.getSharePrice().getCurrency());
                //companyShareDetailsString.add(Double.toString(companyShareDetails.getSharePrice().getValue()));
                //}
                if (!("".equals(companyShareDetails.getCompanyName()))){
                    allCompanyShareDetails.add(companyShareDetails);}
                //tempCompanyData.getCompanyShares().set(i, companyShareDetails);
                //return allCompanyShareDetails; //Shares.SharesUnmarshall.getSharesData();
//            }
//            else
//            {
//                return null;
//            }
        }
        return allCompanyShareDetails;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "buyShares")
    public String buyShares(@WebParam(name = "companyName") String companyID, @WebParam(name = "sharesWanted") int sharesWanted) throws IOException {
        //TODO write your implementation code here:
        //int index = 0;
        
        //CompanyShare companyShareDetails = Shares.XMLFileHandler.getCompanyShareDetails(index);
//        
//        while(companyShareDetails != null)
//        {
        String returnStatement = "";
        CompanyShare companyShareDetails = new CompanyShare();
        Boolean notFound = true;
        for(int i = 0; i< Shares.XMLFileHandler.getCompanyShareDetails().getCompanyShares().size(); i++){
            companyShareDetails = Shares.XMLFileHandler.getCompanyShareDetails().getCompanyShares().get(i);
            if ((companyShareDetails.getCompanyName().toUpperCase().equals(companyID.toUpperCase()))||(companyShareDetails.getCompanySymbol().toUpperCase().equals(companyID.toUpperCase())))
            {
                if (companyShareDetails.getNumOfAvailShares() >= sharesWanted)
                {
                    companyShareDetails.setNumOfAvailShares(companyShareDetails.getNumOfAvailShares() - sharesWanted);
                    Shares.XMLFileHandler.saveSharesData(companyShareDetails, i);
                }else{
                    returnStatement = "Not enough shares available";
                }
                notFound = false;
                break;
            }
            else{
                notFound = true;
            }
            //index++;
            //companyShareDetails = Shares.XMLFileHandler.getCompanyShareDetails(index);
        }
        if (notFound == true)
        {
            returnStatement =  "No Such Company Found";
        }

        //return "Shares of the amount "+ sharesWanted +" for "+companyShareDetails.getCompanyName()+" have been bought";
        returnStatement =  sharesWanted +" share(s) have been bought from "+companyShareDetails.getCompanyName();
        return  returnStatement;
    }

    private java.util.List<java.lang.String> getCurrencyCodes() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        docwebservices.CurrencyConversionWS port = currencyConversionWSService.getCurrencyConversionWSPort();
        return port.getCurrencyCodes();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCurrencyNames")
    public List<String> getCurrencyNames() {
        //TODO write your implementation code here:
        
        
        return getCurrencyCodes();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "userLogin")
    public Boolean userLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        
        return userAuthenticate(username, password) == true;

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUser")
    public Boolean addUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "firstname") String firstname) {
        //TODO write your implementation code here:

        return createUser(username, password, firstname);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFname")
    public String getFname(@WebParam(name = "username") String username) {
        //TODO write your implementation code here:
        return getFirstName(username);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "addStock")
    public Boolean addStock(@WebParam(name = "name") String name, @WebParam(name = "symbol") String symbol, @WebParam(name = "volume") int volume, @WebParam(name = "value") double value) {
        //TODO write your implementation code here:
 
        return XMLFileHandler.createStock(name, symbol, volume, value);
    }
    

    private Boolean userAuthenticate(java.lang.String username, java.lang.String password) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        userlogin.UserAuthentication port = service.getUserAuthenticationPort();
        return port.userAuthenticate(username, password);
    }

    private Boolean createUser(java.lang.String username, java.lang.String password, java.lang.String fname) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        userlogin.UserAuthentication port = service.getUserAuthenticationPort();
        return port.createUser(username, password, fname);
    }

    private String getFirstName(java.lang.String username) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        userlogin.UserAuthentication port = service.getUserAuthenticationPort();
        return port.getFirstName(username);
    }

    

    
    
    

    
    
}
