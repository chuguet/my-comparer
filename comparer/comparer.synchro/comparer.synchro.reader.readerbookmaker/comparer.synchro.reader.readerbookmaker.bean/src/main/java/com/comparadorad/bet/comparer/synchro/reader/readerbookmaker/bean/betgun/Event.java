//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.06.04 a las 08:48:54 AM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betgun;

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
 *         &lt;element ref="{}subevent" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="time" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="hometeam" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="eventName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="datetime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="awayteam" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subevent"
})
@XmlRootElement(name = "event")
public class Event {

    @XmlElement(required = true)
    protected List<Subevent> subevent;
    @XmlAttribute(name = "time", required = true)
    protected String time;
    @XmlAttribute(name = "hometeam", required = true)
    protected String hometeam;
    @XmlAttribute(name = "eventName", required = true)
    protected String eventName;
    @XmlAttribute(name = "datetime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datetime;
    @XmlAttribute(name = "date", required = true)
    protected String date;
    @XmlAttribute(name = "awayteam", required = true)
    protected String awayteam;

    /**
     * Gets the value of the subevent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subevent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubevent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Subevent }
     * 
     * 
     */
    public List<Subevent> getSubevent() {
        if (subevent == null) {
            subevent = new ArrayList<Subevent>();
        }
        return this.subevent;
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
     * Obtiene el valor de la propiedad hometeam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHometeam() {
        return hometeam;
    }

    /**
     * Define el valor de la propiedad hometeam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHometeam(String value) {
        this.hometeam = value;
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
     * Obtiene el valor de la propiedad datetime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatetime() {
        return datetime;
    }

    /**
     * Define el valor de la propiedad datetime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatetime(XMLGregorianCalendar value) {
        this.datetime = value;
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

    /**
     * Obtiene el valor de la propiedad awayteam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwayteam() {
        return awayteam;
    }

    /**
     * Define el valor de la propiedad awayteam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwayteam(String value) {
        this.awayteam = value;
    }

}
