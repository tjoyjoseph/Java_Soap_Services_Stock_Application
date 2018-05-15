/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shares;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import shareCompanies.CompanyShare;
import shareCompanies.ShareTrade;

/**
 *
 * @author Toby Joseph
 */
public class XMLFileHandler {

    private static final String fileLocation = "C:\\Users\\Toby Joseph\\OneDrive - Nottingham Trent University\\Year 3\\Server Centric Computing\\Server Centric Computing\\Assesment One\\WebServices_v6_Complete\\WebServicesJava\\AllCompanyShares.xml";

    private static final XMLFileHandler fileHandlerInstance = new XMLFileHandler();

    public static ShareTrade companyData = new ShareTrade();
    private static List<CompanyShare> companies = companyData.getCompanyShares();

    private XMLFileHandler() {
//        companyData = createData();
//        companyData.getCompanyShares().clear();
//        for (int i = 0; i< companies.size(); i++){saveSharesData(companies.get(i), i);}
//        
//        //marshallFile();
//        
//        unmarshallFile();
    }

    public static void updateStockPrice() throws MalformedURLException, IOException {
        unmarshallFile();
        for (int i = 0; i < companyData.getCompanyShares().size(); i++){
            Double companyStockPrice = companyData.getCompanyShares().get(i).getSharePrice().getValue();

            URL oracle = new URL("https://api.iextrading.com/1.0/stock/" + companyData.getCompanyShares().get(i).getCompanySymbol() + "/price");
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(oracle.openStream()));

                //String inputLine;
                //while ((inputLine = in.readLine()) != null)
                companyStockPrice = Double.parseDouble(in.readLine());

                in.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }

            CompanyShare.SharePrice companySharePrice = companyData.getCompanyShares().get(i).getSharePrice();

            //Date calendar = Calendar.getInstance().getTime();
            Calendar calendar = Calendar.getInstance();
            long millis = System.currentTimeMillis() ;//% 1000;
            calendar.setTimeInMillis(Long.parseLong(Long.toString(millis)));

            String mYear = String.valueOf(calendar.get(Calendar.YEAR));
            String mMonth = String.valueOf(calendar.get(Calendar.MONTH)+1);
            String mDay = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));

            companySharePrice.setDateOfLastUpdate(mDay+"/"+mMonth+"/"+mYear);
            companySharePrice.setValue(companyStockPrice);

            companyData.getCompanyShares().get(i).setSharePrice(companySharePrice);
        }

        marshallFile();

    }

    public static ShareTrade getCompanyShareDetails() throws IOException {
        updateStockPrice();

//        if (index < companyData.getCompanyShares().size()) {
//            //System.out.println(companyData.getCompanyShares().get(index));
//            return companyData.getCompanyShares().get(index);
//        } else {
//            return null;
//        }

        return companyData;

    }

    public static void saveSharesData(CompanyShare companyShare, int index) {
        companyData.getCompanyShares().set(index, companyShare);
        marshallFile();
    }

    public static Boolean createStock(String name, String symbol, int volume, double value) {
        Boolean companyExists = false;
        for (int i = 0; i < companyData.getCompanyShares().size(); i++) {
            if (companyData.getCompanyShares().get(i).getCompanySymbol().toUpperCase().equals(symbol.toUpperCase())) {
                companyExists = true;
                break;
            }
        }

        if (companyExists == false) {
            unmarshallFile();

            CompanyShare.SharePrice companySharePrice = new CompanyShare.SharePrice();

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            //System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
            companySharePrice.setCurrency("GBP");
            companySharePrice.setDateOfLastUpdate(dateFormat.format(date));
            companySharePrice.setValue(value);

            CompanyShare company = new CompanyShare();
            company.setCompanyName(name);
            company.setCompanySymbol(symbol);
            company.setNumOfAvailShares(volume);
            company.setSharePrice(companySharePrice);

            companyData.getCompanyShares().add(company);

            marshallFile();
            return true;
        } else {
            return false;
        }

    }

    private static void marshallFile() {

        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(companyData.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Writing the whole XML document to file
            File movieStore = new File(fileLocation);
            marshaller.marshal(companyData, movieStore);

            //print out only company with more than  7 million shares available
//            CompanyShare nextCompany = new CompanyShare();
//            Iterator itr = companies.iterator();
//            while(itr.hasNext()) {
//                nextCompany = (CompanyShare) itr.next();
//                if(nextCompany.getNumOfAvailShares() > 7000000) {
//                    System.out.println(nextCompany.getNumOfAvailShares()+ " @ " + nextCompany.getCompanyName());
//                }
//            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

    }

    private static void unmarshallFile() {
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(companyData.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            companyData = (ShareTrade) unmarshaller.unmarshal(new java.io.File(fileLocation)); //"C:\\Users\\Toby Joseph\\OneDrive - Nottingham Trent University\\Year 3\\Server Centric Computing\\Server Centric Computing\\Assesment One\\WebServicesJava\\AllCompanyShares.txt")); //NOI18N
            //companyData.getCompanyShares().get(0).getCompanyName();
            // companies =  companyData.getCompanyShares();
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
    }

}
