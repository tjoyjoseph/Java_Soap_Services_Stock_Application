
package org.me.shares;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.shares package. 
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

    private final static QName _IOException_QNAME = new QName("http://shares.me.org/", "IOException");
    private final static QName _AddStock_QNAME = new QName("http://shares.me.org/", "addStock");
    private final static QName _AddStockResponse_QNAME = new QName("http://shares.me.org/", "addStockResponse");
    private final static QName _AddUser_QNAME = new QName("http://shares.me.org/", "addUser");
    private final static QName _AddUserResponse_QNAME = new QName("http://shares.me.org/", "addUserResponse");
    private final static QName _BuyShares_QNAME = new QName("http://shares.me.org/", "buyShares");
    private final static QName _BuySharesResponse_QNAME = new QName("http://shares.me.org/", "buySharesResponse");
    private final static QName _GetCurrencyNames_QNAME = new QName("http://shares.me.org/", "getCurrencyNames");
    private final static QName _GetCurrencyNamesResponse_QNAME = new QName("http://shares.me.org/", "getCurrencyNamesResponse");
    private final static QName _GetFname_QNAME = new QName("http://shares.me.org/", "getFname");
    private final static QName _GetFnameResponse_QNAME = new QName("http://shares.me.org/", "getFnameResponse");
    private final static QName _GetShares_QNAME = new QName("http://shares.me.org/", "getShares");
    private final static QName _GetSharesResponse_QNAME = new QName("http://shares.me.org/", "getSharesResponse");
    private final static QName _UserLogin_QNAME = new QName("http://shares.me.org/", "userLogin");
    private final static QName _UserLoginResponse_QNAME = new QName("http://shares.me.org/", "userLoginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.shares
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link AddStock }
     * 
     */
    public AddStock createAddStock() {
        return new AddStock();
    }

    /**
     * Create an instance of {@link AddStockResponse }
     * 
     */
    public AddStockResponse createAddStockResponse() {
        return new AddStockResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link BuyShares }
     * 
     */
    public BuyShares createBuyShares() {
        return new BuyShares();
    }

    /**
     * Create an instance of {@link BuySharesResponse }
     * 
     */
    public BuySharesResponse createBuySharesResponse() {
        return new BuySharesResponse();
    }

    /**
     * Create an instance of {@link GetCurrencyNames }
     * 
     */
    public GetCurrencyNames createGetCurrencyNames() {
        return new GetCurrencyNames();
    }

    /**
     * Create an instance of {@link GetCurrencyNamesResponse }
     * 
     */
    public GetCurrencyNamesResponse createGetCurrencyNamesResponse() {
        return new GetCurrencyNamesResponse();
    }

    /**
     * Create an instance of {@link GetFname }
     * 
     */
    public GetFname createGetFname() {
        return new GetFname();
    }

    /**
     * Create an instance of {@link GetFnameResponse }
     * 
     */
    public GetFnameResponse createGetFnameResponse() {
        return new GetFnameResponse();
    }

    /**
     * Create an instance of {@link GetShares }
     * 
     */
    public GetShares createGetShares() {
        return new GetShares();
    }

    /**
     * Create an instance of {@link GetSharesResponse }
     * 
     */
    public GetSharesResponse createGetSharesResponse() {
        return new GetSharesResponse();
    }

    /**
     * Create an instance of {@link UserLogin }
     * 
     */
    public UserLogin createUserLogin() {
        return new UserLogin();
    }

    /**
     * Create an instance of {@link UserLoginResponse }
     * 
     */
    public UserLoginResponse createUserLoginResponse() {
        return new UserLoginResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "addStock")
    public JAXBElement<AddStock> createAddStock(AddStock value) {
        return new JAXBElement<AddStock>(_AddStock_QNAME, AddStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "addStockResponse")
    public JAXBElement<AddStockResponse> createAddStockResponse(AddStockResponse value) {
        return new JAXBElement<AddStockResponse>(_AddStockResponse_QNAME, AddStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuyShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "buyShares")
    public JAXBElement<BuyShares> createBuyShares(BuyShares value) {
        return new JAXBElement<BuyShares>(_BuyShares_QNAME, BuyShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BuySharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "buySharesResponse")
    public JAXBElement<BuySharesResponse> createBuySharesResponse(BuySharesResponse value) {
        return new JAXBElement<BuySharesResponse>(_BuySharesResponse_QNAME, BuySharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyNames }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "getCurrencyNames")
    public JAXBElement<GetCurrencyNames> createGetCurrencyNames(GetCurrencyNames value) {
        return new JAXBElement<GetCurrencyNames>(_GetCurrencyNames_QNAME, GetCurrencyNames.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCurrencyNamesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "getCurrencyNamesResponse")
    public JAXBElement<GetCurrencyNamesResponse> createGetCurrencyNamesResponse(GetCurrencyNamesResponse value) {
        return new JAXBElement<GetCurrencyNamesResponse>(_GetCurrencyNamesResponse_QNAME, GetCurrencyNamesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "getFname")
    public JAXBElement<GetFname> createGetFname(GetFname value) {
        return new JAXBElement<GetFname>(_GetFname_QNAME, GetFname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "getFnameResponse")
    public JAXBElement<GetFnameResponse> createGetFnameResponse(GetFnameResponse value) {
        return new JAXBElement<GetFnameResponse>(_GetFnameResponse_QNAME, GetFnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetShares }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "getShares")
    public JAXBElement<GetShares> createGetShares(GetShares value) {
        return new JAXBElement<GetShares>(_GetShares_QNAME, GetShares.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSharesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "getSharesResponse")
    public JAXBElement<GetSharesResponse> createGetSharesResponse(GetSharesResponse value) {
        return new JAXBElement<GetSharesResponse>(_GetSharesResponse_QNAME, GetSharesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "userLogin")
    public JAXBElement<UserLogin> createUserLogin(UserLogin value) {
        return new JAXBElement<UserLogin>(_UserLogin_QNAME, UserLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://shares.me.org/", name = "userLoginResponse")
    public JAXBElement<UserLoginResponse> createUserLoginResponse(UserLoginResponse value) {
        return new JAXBElement<UserLoginResponse>(_UserLoginResponse_QNAME, UserLoginResponse.class, null, value);
    }

}
