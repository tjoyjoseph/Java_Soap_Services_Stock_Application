/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shares;

import java.util.ArrayList;
import java.util.List;
import shareCompanies.CompanyShare;
import shareCompanies.ShareTrade;

/**
 *
 * @author Toby Joseph
 */
public class SharesUnmarshall {
    private static List<CompanyShare> companies = new ArrayList<>();
    private static List<String> allShares = new ArrayList<>()  ;
    
    private static final SharesUnmarshall unmarhsallShares =  new SharesUnmarshall();
    
    private SharesUnmarshall()
    {
        //allShares = getSharesData();
    }
    
    public static List<String>  getShares()
    {
        return allShares;
    }
    
    public static List<List<String>>  getSharesData()
    {
        
        ShareTrade allCompanies = new ShareTrade();
        List<String> tempShare = new ArrayList<>()  ;
        List<List<String>> tempShares = new ArrayList<>();
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allCompanies.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            allCompanies = (ShareTrade) unmarshaller.unmarshal(new java.io.File("C:\\Users\\Toby Joseph\\OneDrive - Nottingham Trent University\\Year 3\\Server Centric Computing\\Server Centric Computing\\Assesment One\\WebServicesJava\\AllCompanyShares.txt")); //NOI18N
            
            companies =  allCompanies.getCompanyShares();
            
            
            for (int i =0; i < companies.size(); i++)
             {
                tempShare.add(companies.get(i).getCompanyName());
                tempShare.add(companies.get(i).getCompanySymbol());
                tempShare.add(Integer.toString(companies.get(i).getNumOfAvailShares()));
                tempShare.add(companies.get(i).getSharePrice().getCurrency());
                tempShare.add(companies.get(i).getSharePrice().getDateOfLastUpdate());
                tempShare.add(Double.toString(companies.get(i).getSharePrice().getValue()));
                //tempShares.add("carrot");
                tempShares.add(tempShare);
             }
            
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        return tempShares;
    }
    
     public static void main(String[] args) {
         ShareTrade allCompanies = new ShareTrade();
         
         
         ///jaxbu
         try {
             javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allCompanies.getClass().getPackage().getName());
             javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
             allCompanies = (ShareTrade) unmarshaller.unmarshal(new java.io.File("C:\\Users\\Toby Joseph\\OneDrive - Nottingham Trent University\\Year 3\\Server Centric Computing\\Server Centric Computing\\Assesment One\\WebServicesJava\\AllCompanyShares.txt")); //NOI18N
             
             List<CompanyShare> companies =  allCompanies.getCompanyShares();
             
             for (int i =0; i < companies.size(); i++)
             {
                 System.out.println(companies.get(i).getCompanyName());
                 System.out.println(companies.get(i).getCompanySymbol());
                 System.out.println(companies.get(i).getNumOfAvailShares());
                 System.out.println(companies.get(i).getSharePrice().getCurrency());
                 System.out.println(companies.get(i).getSharePrice().getDateOfLastUpdate());
                 System.out.println(companies.get(i).getSharePrice().getValue()+"\n");
                 
             }
             
         } catch (javax.xml.bind.JAXBException ex) {
             // XXXTODO Handle exception
             java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
         }
         
     
     }
    
}
