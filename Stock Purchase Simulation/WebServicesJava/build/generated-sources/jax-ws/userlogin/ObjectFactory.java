
package userlogin;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the userlogin package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateUser_QNAME = new QName("http://UserLogin/", "CreateUser");
    private final static QName _CreateUserResponse_QNAME = new QName("http://UserLogin/", "CreateUserResponse");
    private final static QName _UserAuthenticate_QNAME = new QName("http://UserLogin/", "UserAuthenticate");
    private final static QName _UserAuthenticateResponse_QNAME = new QName("http://UserLogin/", "UserAuthenticateResponse");
    private final static QName _GetFirstName_QNAME = new QName("http://UserLogin/", "getFirstName");
    private final static QName _GetFirstNameResponse_QNAME = new QName("http://UserLogin/", "getFirstNameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: userlogin
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateUser }
     * 
     */
    public CreateUser createCreateUser() {
        return new CreateUser();
    }

    /**
     * Create an instance of {@link CreateUserResponse }
     * 
     */
    public CreateUserResponse createCreateUserResponse() {
        return new CreateUserResponse();
    }

    /**
     * Create an instance of {@link UserAuthenticate }
     * 
     */
    public UserAuthenticate createUserAuthenticate() {
        return new UserAuthenticate();
    }

    /**
     * Create an instance of {@link UserAuthenticateResponse }
     * 
     */
    public UserAuthenticateResponse createUserAuthenticateResponse() {
        return new UserAuthenticateResponse();
    }

    /**
     * Create an instance of {@link GetFirstName }
     * 
     */
    public GetFirstName createGetFirstName() {
        return new GetFirstName();
    }

    /**
     * Create an instance of {@link GetFirstNameResponse }
     * 
     */
    public GetFirstNameResponse createGetFirstNameResponse() {
        return new GetFirstNameResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserLogin/", name = "CreateUser")
    public JAXBElement<CreateUser> createCreateUser(CreateUser value) {
        return new JAXBElement<CreateUser>(_CreateUser_QNAME, CreateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserLogin/", name = "CreateUserResponse")
    public JAXBElement<CreateUserResponse> createCreateUserResponse(CreateUserResponse value) {
        return new JAXBElement<CreateUserResponse>(_CreateUserResponse_QNAME, CreateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAuthenticate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserLogin/", name = "UserAuthenticate")
    public JAXBElement<UserAuthenticate> createUserAuthenticate(UserAuthenticate value) {
        return new JAXBElement<UserAuthenticate>(_UserAuthenticate_QNAME, UserAuthenticate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAuthenticateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserLogin/", name = "UserAuthenticateResponse")
    public JAXBElement<UserAuthenticateResponse> createUserAuthenticateResponse(UserAuthenticateResponse value) {
        return new JAXBElement<UserAuthenticateResponse>(_UserAuthenticateResponse_QNAME, UserAuthenticateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFirstName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserLogin/", name = "getFirstName")
    public JAXBElement<GetFirstName> createGetFirstName(GetFirstName value) {
        return new JAXBElement<GetFirstName>(_GetFirstName_QNAME, GetFirstName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFirstNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://UserLogin/", name = "getFirstNameResponse")
    public JAXBElement<GetFirstNameResponse> createGetFirstNameResponse(GetFirstNameResponse value) {
        return new JAXBElement<GetFirstNameResponse>(_GetFirstNameResponse_QNAME, GetFirstNameResponse.class, null, value);
    }

}
