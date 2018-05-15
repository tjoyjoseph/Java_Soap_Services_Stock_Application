/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordHash;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * REST Web Service
 *
 * @author Toby Joseph
 */
@Path("passhash")
public class Passhash {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Passhash
     */
    public Passhash() {
    }

    /**
     * Retrieves representation of an instance of PasswordHash.Passhash
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml(@QueryParam("password")String password) throws NoSuchAlgorithmException {
    //COMPLETE THE CODE
    
        String tempPassword = "";
        
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes());
        String encryptedPassword = new String(messageDigest.digest());
        
//        for (int i = 0; i < password.length(); i++){
//            char chrPass = password.charAt(i);
//            chrPass = (char) (chrPass + 5);
//            tempPassword = tempPassword + chrPass;
//        }
    
        return encryptedPassword;
    }

    /**
     * PUT method for updating or creating an instance of Passhash
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
}
