//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.02.26 a las 06:04:59 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.boylesports;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}bettype" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="venue" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="time" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *             &lt;enumeration value="1245"/>
 *             &lt;enumeration value="1345"/>
 *             &lt;enumeration value="1400"/>
 *             &lt;enumeration value="1500"/>
 *             &lt;enumeration value="1600"/>
 *             &lt;enumeration value="1700"/>
 *             &lt;enumeration value="1800"/>
 *             &lt;enumeration value="1900"/>
 *             &lt;enumeration value="1930"/>
 *             &lt;enumeration value="1945"/>
 *             &lt;enumeration value="2005"/>
 *             &lt;enumeration value="2015"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="sporttype" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Football"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="sport" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Football Europe"/>
 *             &lt;enumeration value="Football International"/>
 *             &lt;enumeration value="Football Ireland"/>
 *             &lt;enumeration value="Football U.K."/>
 *             &lt;enumeration value="Football Uefa"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Airtricity 1st Division 2013"/>
 *             &lt;enumeration value="Airtricity Premier Division 2013"/>
 *             &lt;enumeration value="Blue Square Premier League 2012/2013"/>
 *             &lt;enumeration value="Borussia Dortmund v Shakhtar Donetsk"/>
 *             &lt;enumeration value="Capital One Cup 2012/2013"/>
 *             &lt;enumeration value="Champions League 2012/2013"/>
 *             &lt;enumeration value="Championship 2012/2013"/>
 *             &lt;enumeration value="Europa League 2012/2013"/>
 *             &lt;enumeration value="FA Cup 2012/2013"/>
 *             &lt;enumeration value="FAI Intermediate Cup 2012/2013"/>
 *             &lt;enumeration value="FAI Junior Cup 2012/2013"/>
 *             &lt;enumeration value="French -  Ligue 1 2012/2013"/>
 *             &lt;enumeration value="Holland -  Eredivisie 2012/2013"/>
 *             &lt;enumeration value="Italy -  Serie A 2012/2013"/>
 *             &lt;enumeration value="Johnstones Paint Trophy 2012/2013"/>
 *             &lt;enumeration value="League One 2012/2013"/>
 *             &lt;enumeration value="League Two 2012/2013"/>
 *             &lt;enumeration value="Liverpool v Zenit St Petersburg"/>
 *             &lt;enumeration value="Midweek Bonus Accumulators"/>
 *             &lt;enumeration value="Multiple Trophies 2012/2013"/>
 *             &lt;enumeration value="Paris St Germain v Valencia"/>
 *             &lt;enumeration value="Portugal - Super Liga 2012/2013"/>
 *             &lt;enumeration value="Premier League 2012/2013"/>
 *             &lt;enumeration value="Premier League 2013/2014"/>
 *             &lt;enumeration value="Scottish Communities League Cup"/>
 *             &lt;enumeration value="Scottish Division 1 2012/2013"/>
 *             &lt;enumeration value="Scottish Division 3 2012/2013"/>
 *             &lt;enumeration value="Scottish FA Cup 2012/2013"/>
 *             &lt;enumeration value="Scottish Premier 2012/2013"/>
 *             &lt;enumeration value="Setanta Sports Cup 2013"/>
 *             &lt;enumeration value="World Cup 2014 - Outright"/>
 *             &lt;enumeration value="World Cup 2014 - Qualifying Groups"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="meeting" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="eventid" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="1282073.1"/>
 *             &lt;enumeration value="1600087.1"/>
 *             &lt;enumeration value="1630624.1"/>
 *             &lt;enumeration value="1630627.1"/>
 *             &lt;enumeration value="1630628.1"/>
 *             &lt;enumeration value="1631302.1"/>
 *             &lt;enumeration value="1631363.1"/>
 *             &lt;enumeration value="1631372.1"/>
 *             &lt;enumeration value="1631399.1"/>
 *             &lt;enumeration value="1631412.1"/>
 *             &lt;enumeration value="1640624.1"/>
 *             &lt;enumeration value="1641940.1"/>
 *             &lt;enumeration value="1642261.1"/>
 *             &lt;enumeration value="1647911.1"/>
 *             &lt;enumeration value="1647943.1"/>
 *             &lt;enumeration value="1660024.1"/>
 *             &lt;enumeration value="1670744.1"/>
 *             &lt;enumeration value="1674915.1"/>
 *             &lt;enumeration value="1744547.1"/>
 *             &lt;enumeration value="1744650.1"/>
 *             &lt;enumeration value="1744721.1"/>
 *             &lt;enumeration value="1749995.1"/>
 *             &lt;enumeration value="1801634.1"/>
 *             &lt;enumeration value="1842454.1"/>
 *             &lt;enumeration value="1868772.1"/>
 *             &lt;enumeration value="1872334.1"/>
 *             &lt;enumeration value="1926130.1"/>
 *             &lt;enumeration value="1948339.1"/>
 *             &lt;enumeration value="1950103.1"/>
 *             &lt;enumeration value="1951201.1"/>
 *             &lt;enumeration value="1951762.1"/>
 *             &lt;enumeration value="923287.1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="date" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *             &lt;enumeration value="20130213"/>
 *             &lt;enumeration value="20130220"/>
 *             &lt;enumeration value="20130221"/>
 *             &lt;enumeration value="20130222"/>
 *             &lt;enumeration value="20130223"/>
 *             &lt;enumeration value="20130224"/>
 *             &lt;enumeration value="20130227"/>
 *             &lt;enumeration value="20130302"/>
 *             &lt;enumeration value="20130304"/>
 *             &lt;enumeration value="20130305"/>
 *             &lt;enumeration value="20130306"/>
 *             &lt;enumeration value="20130311"/>
 *             &lt;enumeration value="20130317"/>
 *             &lt;enumeration value="20131122"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bettype"
})
@XmlRootElement(name = "event")
public class Event {

    @XmlElement(required = true)
    protected List<Bettype> bettype;
    @XmlAttribute(name = "venue", required = true)
    protected String venue;
    @XmlAttribute(name = "time", required = true)
    protected String time;
    @XmlAttribute(name = "sporttype", required = true)
    protected String sporttype;
    @XmlAttribute(name = "sport", required = true)
    protected String sport;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "meeting", required = true)
    protected String meeting;
    @XmlAttribute(name = "eventid", required = true)
    protected BigDecimal eventid;
    @XmlAttribute(name = "date", required = true)
    protected String date;

    /**
     * Gets the value of the bettype property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bettype property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBettype().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bettype }
     * 
     * 
     */
    public List<Bettype> getBettype() {
        if (bettype == null) {
            bettype = new ArrayList<Bettype>();
        }
        return this.bettype;
    }

    /**
     * Obtiene el valor de la propiedad venue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVenue() {
        return venue;
    }

    /**
     * Define el valor de la propiedad venue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVenue(String value) {
        this.venue = value;
    }

    /**
     * Obtiene el valor de la propiedad time.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Define el valor de la propiedad time.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Obtiene el valor de la propiedad sporttype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSporttype() {
        return sporttype;
    }

    /**
     * Define el valor de la propiedad sporttype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSporttype(String value) {
        this.sporttype = value;
    }

    /**
     * Obtiene el valor de la propiedad sport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSport() {
        return sport;
    }

    /**
     * Define el valor de la propiedad sport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSport(String value) {
        this.sport = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
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
     * Define el valor de la propiedad name.
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
     * Obtiene el valor de la propiedad meeting.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeeting() {
        return meeting;
    }

    /**
     * Define el valor de la propiedad meeting.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeeting(String value) {
        this.meeting = value;
    }

    /**
     * Obtiene el valor de la propiedad eventid.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEventid() {
        return eventid;
    }

    /**
     * Define el valor de la propiedad eventid.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEventid(BigDecimal value) {
        this.eventid = value;
    }

    /**
     * Obtiene el valor de la propiedad date.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
    }

}
