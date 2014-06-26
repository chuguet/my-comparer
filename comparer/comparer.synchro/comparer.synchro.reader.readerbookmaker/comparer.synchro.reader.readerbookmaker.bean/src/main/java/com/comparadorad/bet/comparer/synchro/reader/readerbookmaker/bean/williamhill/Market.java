//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.11 at 05:21:53 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.williamhill;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}participant" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="url" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="time" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lastUpdateTime" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="lastUpdateDate" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="betTillTime" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="betTillDate" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "participant"
})
@XmlRootElement(name = "market")
public class Market {

    @XmlElement(required = true)
    protected List<Participant> participant;
    @XmlAttribute(name = "url", required = true)
    protected String url;
    @XmlAttribute(name = "time", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar time;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "lastUpdateTime", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar lastUpdateTime;
    @XmlAttribute(name = "lastUpdateDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lastUpdateDate;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlAttribute(name = "betTillTime", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar betTillTime;
    @XmlAttribute(name = "betTillDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar betTillDate;

    /**
     * Gets the value of the participant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the participant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticipant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Participant }
     * 
     * 
     */
    public List<Participant> getParticipant() {
        if (participant == null) {
            participant = new ArrayList<Participant>();
        }
        return this.participant;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the lastUpdateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * Sets the value of the lastUpdateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateTime(XMLGregorianCalendar value) {
        this.lastUpdateTime = value;
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastUpdateDate(XMLGregorianCalendar value) {
        this.lastUpdateDate = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the betTillTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBetTillTime() {
        return betTillTime;
    }

    /**
     * Sets the value of the betTillTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBetTillTime(XMLGregorianCalendar value) {
        this.betTillTime = value;
    }

    /**
     * Gets the value of the betTillDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBetTillDate() {
        return betTillDate;
    }

    /**
     * Sets the value of the betTillDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBetTillDate(XMLGregorianCalendar value) {
        this.betTillDate = value;
    }

}