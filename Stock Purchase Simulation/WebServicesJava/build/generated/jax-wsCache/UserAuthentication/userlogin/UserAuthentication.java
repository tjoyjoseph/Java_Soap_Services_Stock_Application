
package userlogin;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "UserAuthentication", targetNamespace = "http://UserLogin/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UserAuthentication {


    /**
     * 
     * @param password
     * @param username
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "UserAuthenticate")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "UserAuthenticate", targetNamespace = "http://UserLogin/", className = "userlogin.UserAuthenticate")
    @ResponseWrapper(localName = "UserAuthenticateResponse", targetNamespace = "http://UserLogin/", className = "userlogin.UserAuthenticateResponse")
    @Action(input = "http://UserLogin/UserAuthentication/UserAuthenticateRequest", output = "http://UserLogin/UserAuthentication/UserAuthenticateResponse")
    public Boolean userAuthenticate(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password);

    /**
     * 
     * @param fname
     * @param password
     * @param username
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(operationName = "CreateUser")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "CreateUser", targetNamespace = "http://UserLogin/", className = "userlogin.CreateUser")
    @ResponseWrapper(localName = "CreateUserResponse", targetNamespace = "http://UserLogin/", className = "userlogin.CreateUserResponse")
    @Action(input = "http://UserLogin/UserAuthentication/CreateUserRequest", output = "http://UserLogin/UserAuthentication/CreateUserResponse")
    public Boolean createUser(
        @WebParam(name = "username", targetNamespace = "")
        String username,
        @WebParam(name = "password", targetNamespace = "")
        String password,
        @WebParam(name = "fname", targetNamespace = "")
        String fname);

    /**
     * 
     * @param username
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFirstName", targetNamespace = "http://UserLogin/", className = "userlogin.GetFirstName")
    @ResponseWrapper(localName = "getFirstNameResponse", targetNamespace = "http://UserLogin/", className = "userlogin.GetFirstNameResponse")
    @Action(input = "http://UserLogin/UserAuthentication/getFirstNameRequest", output = "http://UserLogin/UserAuthentication/getFirstNameResponse")
    public String getFirstName(
        @WebParam(name = "username", targetNamespace = "")
        String username);

}
