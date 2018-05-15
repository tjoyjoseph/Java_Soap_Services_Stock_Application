
package org.netbeans.xml.schema.shows;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for companyShare complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="companyShare"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="companySymbol" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="numOfAvailShares" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="sharePrice"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *                   &lt;element name="dateOfLastUpdate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "companyShare", propOrder = {
    "companyName",
    "companySymbol",
    "numOfAvailShares",
    "sharePrice"
})
public class CompanyShare {

    @XmlElement(required = true)
    protected String companyName;
    @XmlElement(required = true)
    protected String companySymbol;
    protected int numOfAvailShares;
    @XmlElement(required = true)
    protected CompanyShare.SharePrice sharePrice;

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the companySymbol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanySymbol() {
        return companySymbol;
    }

    /**
     * Sets the value of the companySymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanySymbol(String value) {
        this.companySymbol = value;
    }

    /**
     * Gets the value of the numOfAvailShares property.
     * 
     */
    public int getNumOfAvailShares() {
        return numOfAvailShares;
    }

    /**
     * Sets the value of the numOfAvailShares property.
     * 
     */
    public void setNumOfAvailShares(int value) {
        this.numOfAvailShares = value;
    }

    /**
     * Gets the value of the sharePrice property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyShare.SharePrice }
     *     
     */
    public CompanyShare.SharePrice getSharePrice() {
        return sharePrice;
    }

    /**
     * Sets the value of the sharePrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyShare.SharePrice }
     *     
     */
    public void setSharePrice(CompanyShare.SharePrice value) {
        this.sharePrice = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
     *         &lt;element name="dateOfLastUpdate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "currency",
        "value",
        "dateOfLastUpdate"
    })
    public static class SharePrice {

        @XmlElement(required = true)
        protected String currency;
        protected double value;
        @XmlElement(required = true)
        protected String dateOfLastUpdate;

        /**
         * Gets the value of the currency property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrency() {
            return currency;
        }

        /**
         * Sets the value of the currency property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrency(String value) {
            this.currency = value;
        }

        /**
         * Gets the value of the value property.
         * 
         */
        public double getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(double value) {
            this.value = value;
        }

        /**
         * Gets the value of the dateOfLastUpdate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDateOfLastUpdate() {
            return dateOfLastUpdate;
        }

        /**
         * Sets the value of the dateOfLastUpdate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDateOfLastUpdate(String value) {
            this.dateOfLastUpdate = value;
        }

    }

}
