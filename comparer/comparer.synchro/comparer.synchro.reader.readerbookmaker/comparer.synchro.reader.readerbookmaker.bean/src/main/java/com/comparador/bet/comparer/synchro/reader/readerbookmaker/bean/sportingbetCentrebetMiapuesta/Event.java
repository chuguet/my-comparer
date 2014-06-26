//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.06.03 a las 10:53:25 AM CEST 
//


package com.comparador.bet.comparer.synchro.reader.readerbookmaker.bean.sportingbetCentrebetMiapuesta;

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
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Competitor" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Venue" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LocalTime" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LocalDate" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ISODate" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="EventURL" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="EventType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="EventName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="EventID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "competitor"
})
@XmlRootElement(name = "Event")
public class Event {

    @XmlElement(name = "Competitor", required = true)
    protected List<Competitor> competitor;
    @XmlAttribute(name = "Venue", required = true)
    protected String venue;
    @XmlAttribute(name = "LocalTime", required = true)
    protected String localTime;
    @XmlAttribute(name = "LocalDate", required = true)
    protected String localDate;
    @XmlAttribute(name = "ISODate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar isoDate;
    @XmlAttribute(name = "EventURL", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String eventURL;
    @XmlAttribute(name = "EventType", required = true)
    protected String eventType;
    @XmlAttribute(name = "EventName", required = true)
    protected String eventName;
    @XmlAttribute(name = "EventID", required = true)
    protected int eventID;

    /**
     * Gets the value of the competitor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the competitor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompetitor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Competitor }
     * 
     * 
     */
    public List<Competitor> getCompetitor() {
        if (competitor == null) {
            competitor = new ArrayList<Competitor>();
        }
        return this.competitor;
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
     * Obtiene el valor de la propiedad localTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalTime() {
        return localTime;
    }

    /**
     * Define el valor de la propiedad localTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalTime(String value) {
        this.localTime = value;
    }

    /**
     * Obtiene el valor de la propiedad localDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalDate() {
        return localDate;
    }

    /**
     * Define el valor de la propiedad localDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalDate(String value) {
        this.localDate = value;
    }

    /**
     * Obtiene el valor de la propiedad isoDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getISODate() {
        return isoDate;
    }

    /**
     * Define el valor de la propiedad isoDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setISODate(XMLGregorianCalendar value) {
        this.isoDate = value;
    }

    /**
     * Obtiene el valor de la propiedad eventURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventURL() {
        return eventURL;
    }

    /**
     * Define el valor de la propiedad eventURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventURL(String value) {
        this.eventURL = value;
    }

    /**
     * Obtiene el valor de la propiedad eventType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Define el valor de la propiedad eventType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventType(String value) {
        this.eventType = value;
    }

    /**
     * Obtiene el valor de la propiedad eventName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Define el valor de la propiedad eventName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventName(String value) {
        this.eventName = value;
    }

    /**
     * Obtiene el valor de la propiedad eventID.
     * 
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * Define el valor de la propiedad eventID.
     * 
     */
    public void setEventID(int value) {
        this.eventID = value;
    }

}
