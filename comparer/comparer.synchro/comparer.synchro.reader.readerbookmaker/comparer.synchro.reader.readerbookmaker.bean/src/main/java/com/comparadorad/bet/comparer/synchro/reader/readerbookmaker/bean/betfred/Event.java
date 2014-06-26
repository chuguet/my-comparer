//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.02.28 a las 10:41:58 AM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betfred;

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
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;enumeration value="1100"/>
 *             &lt;enumeration value="1500"/>
 *             &lt;enumeration value="1600"/>
 *             &lt;enumeration value="1700"/>
 *             &lt;enumeration value="1800"/>
 *             &lt;enumeration value="1900"/>
 *             &lt;enumeration value="2000"/>
 *             &lt;enumeration value="2030"/>
 *             &lt;enumeration value="2100"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Deportivo v Real Zaragoza"/>
 *             &lt;enumeration value="Espanyol v Real Valladolid"/>
 *             &lt;enumeration value="Getafe v Real Zaragoza"/>
 *             &lt;enumeration value="Granada v Mallorca"/>
 *             &lt;enumeration value="Malaga v Atletico Madrid"/>
 *             &lt;enumeration value="Osasuna v Athletic Bilbao"/>
 *             &lt;enumeration value="Real Madrid v Barcelona"/>
 *             &lt;enumeration value="Real Sociedad v Real Betis"/>
 *             &lt;enumeration value="Sevilla v Celta Vigo"/>
 *             &lt;enumeration value="Valencia v Levante"/>
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
 *             &lt;enumeration value="2318362.2"/>
 *             &lt;enumeration value="2320396.2"/>
 *             &lt;enumeration value="2320403.2"/>
 *             &lt;enumeration value="2320410.2"/>
 *             &lt;enumeration value="2320415.2"/>
 *             &lt;enumeration value="2320423.2"/>
 *             &lt;enumeration value="2320429.2"/>
 *             &lt;enumeration value="2320433.2"/>
 *             &lt;enumeration value="2320436.2"/>
 *             &lt;enumeration value="2320441.2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="date" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;enumeration value="20130301"/>
 *             &lt;enumeration value="20130302"/>
 *             &lt;enumeration value="20130303"/>
 *             &lt;enumeration value="20130304"/>
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
     */
    public String getTime() {
        return time;
    }

    /**
     * Define el valor de la propiedad time.
     * 
     */
    public void setTime(String value) {
        this.time = value;
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
     */
    public String getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     */
    public void setDate(String value) {
        this.date = value;
    }

}
