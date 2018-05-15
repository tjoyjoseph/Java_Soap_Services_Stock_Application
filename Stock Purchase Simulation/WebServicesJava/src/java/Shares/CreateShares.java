package Shares;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.io.BufferedReader;
import shareCompanies.ShareTrade;
import shareCompanies.CompanyShare;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import static javax.ws.rs.client.Entity.json;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author n0562762
 */
public class CreateShares {
    
    
    
    private static ShareTrade allCompanies = new ShareTrade();
    private static List<CompanyShare> companies =  allCompanies.getCompanyShares();
    private static CompanyShare company;
    private static CompanyShare.SharePrice companySharePrice;
    
    private static void createShare(String companyName, String symbol, int volume, String currency, String date, double value){
        
        company = new CompanyShare();
        company.setCompanyName(companyName);
        company.setCompanySymbol(symbol);
        company.setNumOfAvailShares(volume);

        companySharePrice = new CompanyShare.SharePrice();
        companySharePrice.setCurrency(currency);
        companySharePrice.setDateOfLastUpdate(date);
        companySharePrice.setValue(value);

        company.setSharePrice(companySharePrice);
        companies.add(company);

        
    }
    
    private static double getUpdatedCurrencyRate(String currencyType) throws IOException, ParseException
    {
        URL oracle = new URL("https://v3.exchangerate-api.com/bulk/3141620ff299d6c616763fc3/GBP");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        String allConverstionRates = in.readLine();
        in.close();
        
        JSONParser parser = new JSONParser();
        Object allRates = parser.parse(allConverstionRates);
        JSONObject rateDetails = (JSONObject)allRates;
        
        System.out.println(rateDetails.get("result"));
        if (!(rateDetails.get("error").equals("quota-exceeded")))
        {
            allRates = parser.parse(rateDetails.get("rates").toString());
            rateDetails = (JSONObject)allRates;
            return Double.parseDouble(rateDetails.get(currencyType).toString());
        }else{
            return 0;
        }
        
        
        //System.err.println(rateDetails.get(currencyType));
        
        
    }
    
    
    public static List<String> getCompanyDetails(String companySymbol) throws  IOException, ParseException
    {
        
        
        ArrayList<String> StockInfo = new ArrayList<>();
        
        URL oracle = new URL("https://api.iextrading.com/1.0/stock/"+companySymbol+"/quote");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        String allCompanyDetails = in.readLine();
        in.close();
        
        JSONParser parser = new JSONParser();
        Object allCompanys = parser.parse(allCompanyDetails);
        JSONObject companyDetails = (JSONObject)allCompanys;
        
        //System.out.println(companyDetails.toString());
        
        StockInfo.add(companyDetails.get("companyName").toString());
        StockInfo.add(companyDetails.get("symbol").toString());
        StockInfo.add(companyDetails.get("latestVolume").toString());
        
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(companyDetails.get("latestUpdate").toString()));

        String mYear = String.valueOf(calendar.get(Calendar.YEAR));
        String mMonth = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String mDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        
        StockInfo.add(mDay+"/"+mMonth+"/"+mYear);
        StockInfo.add(companyDetails.get("latestPrice").toString());
        
        
        
        System.out.println(StockInfo);
        return StockInfo;
    
    }
    
    public static String getRandomCompanySymbol() throws IOException, ParseException
    {
        
        String companySymbol = "";
        
        URL oracle = new URL("https://api.iextrading.com/1.0/ref-data/symbols");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        String allCompanyDetails = in.readLine();
        in.close();
        

        JSONParser parser = new JSONParser();
        Object allCompanys = parser.parse(allCompanyDetails);
        
        JSONArray companyArray = (JSONArray)allCompanys;
        
        Random randSymbol = new Random();
        int n = randSymbol.nextInt(companyArray.size()-1) + 0;
        
        
        JSONObject companyDetails = (JSONObject)companyArray.get(n);
        
        //System.out.println(companyArray.get(1));

        //System.out.println(companyDetails.get("symbol"));    
        

        return companySymbol = companyDetails.get("symbol").toString();
    }
    
    
    
    public static void main(String[] args) throws IOException, ParseException {
        
        URL oracle = new URL("http://localhost:8080/RestWSPassHash/webresources/passhash?password=hello");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        String hashedPass = in.readLine();
        in.close();
        
        System.out.println(hashedPass);
        
        getUpdatedCurrencyRate("GBP");
        //System.out.println(getRandomCompanySymbol());
        
        for (int i = 0; i < 5; i ++){
        List<String> companyInfo = getCompanyDetails(getRandomCompanySymbol());
        createShare(companyInfo.get(0), companyInfo.get(1), Integer.parseInt(companyInfo.get(2)), "GBP", companyInfo.get(3), Double.parseDouble(companyInfo.get(4)));
        }
        
        for (int x = 0; x < companies.size(); x++ )
        {
            for (int m = 1; m < (companies.size() - x); m++ )
            {
                if (companies.get(m).getCompanyName().compareTo(companies.get(m-1).getCompanyName()) < 0){
                    
                    CompanyShare tempCompany = companies.get(m);
                    companies.set(m, companies.get(m-1));
                    companies.set(m-1,tempCompany);
                    
                }

            }
        }
        
        
//        createShare("Aac Holdings Inc", "AAC", 115400, "GBP", "2017-12-20", 8.490);
//        createShare("Barrick Gold Corp", "ABX", 5620500, "GBP", "2018-01-1", 14.47);
//        createShare("Amtrust Financial Services Inc", "AFS-A", 8800, "GBP", "2018-01-1", 20.60);
//        createShare("Evoqua Water Technologies Corp.", "AQUA", 153600, "GBP", "2018-01-1", 23.71);
//        createShare("Barnes Group", "B", 165000, "GBP", "2018-01-1", 63.27);
//        createShare("Boeing Company", "BA", 1824500, "GBP", "2018-01-1", 294.9);
//        createShare("Alibaba Group Holding Ltd", "BABA", 9704500, "GBP", "2018-01-1", 172.4);
        
        //System.out.println(updateCompanyDetails("A"));
     
      
      //System.out.println(companies.get(0).getCompanyName());
      
      try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(allCompanies.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Writing the whole XML document to file
            File StockFile = new File("AllCompanyShares.xml");
            marshaller.marshal(allCompanies, StockFile);

            //print out only company with more than  7 million shares available
            CompanyShare nextCompany = new CompanyShare();
            Iterator itr = companies.iterator();
            while(itr.hasNext()) {
                nextCompany = (CompanyShare) itr.next();
                if(nextCompany.getNumOfAvailShares() > 7000000) {
                    //System.out.println(nextCompany.getNumOfAvailShares()+ " @ " + nextCompany.getCompanyName());
                }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
      
        
    
    }

   

    

   

    
     
}
