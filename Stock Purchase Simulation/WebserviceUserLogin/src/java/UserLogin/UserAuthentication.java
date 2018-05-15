/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserLogin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.netbeans.xml.schema.shows.UserDetail;
import org.netbeans.xml.schema.shows.Users;       
/**
 *
 * @author Toby Joseph
 */
@WebService(serviceName = "UserAuthentication")
@Stateless()
public class UserAuthentication {
    private static Users users = new Users();

    private static String userFileName = "C:\\Users\\Toby Joseph\\OneDrive - Nottingham Trent University\\Year 3\\Server Centric Computing\\Server Centric Computing\\Assesment One\\WebServices_v6_Complete\\WebserviceUserLogin\\userDetails.xml";

    private List<String> getUserDetails (String username){
        
        
        
        return null;
    }
    
    private static void marshallFile()
    {
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(users.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            
            File userFile = new File(userFileName);
            marshaller.marshal(users, userFile);
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
            //System.out.println(ex);
        }
    
    }
    
    private static void unMarshallFile()
    {
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(users.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            
              
            users = (Users) unmarshaller.unmarshal(new java.io.File(userFileName)); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
            //System.out.println(ex);
        }
        
    
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "UserAuthenticate")
    public Boolean UserAuthenticate(@WebParam(name = "username") String username, @WebParam(name = "password") String password) throws IOException {
        //TODO write your implementation code here:
        boolean found = false;
        if (!(username == " ")&&!(username == null) && !(password == " ") && !(password == null)){
            unMarshallFile();
            
            URL oracle = new URL("http://localhost:8080/RestWSPassHash/webresources/passhash?password="+password);
            BufferedReader in = new BufferedReader(
            new InputStreamReader(oracle.openStream()));
            String hashedPass = in.readLine();
            in.close();

            for (int i = 0; i < users.getUserDetails().size(); i++ )
            {
                if (username.toUpperCase().equals(users.getUserDetails().get(i).getUsername().toUpperCase()))
                {
                    if (hashedPass.equals(users.getUserDetails().get(i).getPassword())){
                        found = true;
                        break;
                    }
                }
            }
        }
        
        if (found == false)
        {
            return false;
        }else {
            return true;
        }

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CreateUser")
    public Boolean CreateUser(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "fname") String fname) throws IOException {
        //TODO write your implementation code here:
        Boolean userExists = false;
        
        if(new File(userFileName).exists()){  
            unMarshallFile();
            
            for (int i = 0; i < users.getUserDetails().size(); i++ )
            {
                if (username.toUpperCase().equals(users.getUserDetails().get(i).getUsername().toUpperCase()))
                {
                    userExists = true;
                    break;
                }
            }
            
        }
        
        if (userExists == false){
        UserDetail tempUserDetail = new UserDetail();
        
        tempUserDetail.setFname(fname);
        
        URL oracle = new URL("http://localhost:8080/RestWSPassHash/webresources/passhash?password="+password);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(oracle.openStream()));
        String hashedPass = in.readLine();
        in.close();
        
        //System.out.println(hashedPass);
        
        tempUserDetail.setPassword(hashedPass);
        tempUserDetail.setUsername(username);
        
        
        users.getUserDetails().add(tempUserDetail);
        
        marshallFile();
        return true;
        }else{
            return false;
        }
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFirstName")
    public String getFirstName(@WebParam(name = "username") String username) {
        //TODO write your implementation code here:
        
        String fname = "";
        
        for (int i = 0; i < users.getUserDetails().size(); i++ )
        {
            if (username.toUpperCase().equals(users.getUserDetails().get(i).getUsername().toUpperCase()))
            {
                fname = users.getUserDetails().get(i).getFname();
                break;
            }
        }
        
        return fname;
    }
    
    
    
}
