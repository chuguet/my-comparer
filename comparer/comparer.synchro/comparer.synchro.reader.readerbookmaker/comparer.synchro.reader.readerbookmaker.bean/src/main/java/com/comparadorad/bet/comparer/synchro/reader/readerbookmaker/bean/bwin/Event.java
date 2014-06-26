//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.01.17 a las 03:33:39 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bwin;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{}games" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="eventlink" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="eventdate" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="01.02.2014 / 12:45"/>
 *             &lt;enumeration value="01.02.2014 / 14:30"/>
 *             &lt;enumeration value="01.02.2014 / 15:00"/>
 *             &lt;enumeration value="01.02.2014 / 17:30"/>
 *             &lt;enumeration value="01.02.2014 / 19:00"/>
 *             &lt;enumeration value="01.06.2014 / 16:00"/>
 *             &lt;enumeration value="01.06.2014 / 17:00"/>
 *             &lt;enumeration value="02.02.2014 / 13:30"/>
 *             &lt;enumeration value="02.02.2014 / 14:00"/>
 *             &lt;enumeration value="02.02.2014 / 14:30"/>
 *             &lt;enumeration value="02.02.2014 / 16:00"/>
 *             &lt;enumeration value="02.02.2014 / 16:30"/>
 *             &lt;enumeration value="03.02.2014 / 20:00"/>
 *             &lt;enumeration value="05.03.2014 / 17:00"/>
 *             &lt;enumeration value="05.03.2014 / 19:00"/>
 *             &lt;enumeration value="05.03.2014 / 19:30"/>
 *             &lt;enumeration value="05.03.2014 / 19:45"/>
 *             &lt;enumeration value="05.03.2014 / 20:00"/>
 *             &lt;enumeration value="10.05.2014 / 13:30"/>
 *             &lt;enumeration value="11.05.2014 / 16:00"/>
 *             &lt;enumeration value="15.05.2014 / 18:45"/>
 *             &lt;enumeration value="16.01.2014 / 12:00"/>
 *             &lt;enumeration value="16.01.2014 / 13:00"/>
 *             &lt;enumeration value="16.01.2014 / 14:00"/>
 *             &lt;enumeration value="16.01.2014 / 14:30"/>
 *             &lt;enumeration value="16.01.2014 / 15:00"/>
 *             &lt;enumeration value="16.01.2014 / 17:00"/>
 *             &lt;enumeration value="16.01.2014 / 18:00"/>
 *             &lt;enumeration value="16.01.2014 / 18:15"/>
 *             &lt;enumeration value="16.01.2014 / 20:00"/>
 *             &lt;enumeration value="17.01.2014 / 19:30"/>
 *             &lt;enumeration value="17.01.2014 / 20:00"/>
 *             &lt;enumeration value="17.05.2014 / 18:00"/>
 *             &lt;enumeration value="18.01.2014 / 12:45"/>
 *             &lt;enumeration value="18.01.2014 / 15:00"/>
 *             &lt;enumeration value="18.01.2014 / 16:00"/>
 *             &lt;enumeration value="18.01.2014 / 17:00"/>
 *             &lt;enumeration value="18.01.2014 / 17:30"/>
 *             &lt;enumeration value="18.01.2014 / 19:00"/>
 *             &lt;enumeration value="18.01.2014 / 19:45"/>
 *             &lt;enumeration value="18.01.2014 / 21:00"/>
 *             &lt;enumeration value="18.02.2014 / 19:45"/>
 *             &lt;enumeration value="18.05.2014 / 10:00"/>
 *             &lt;enumeration value="18.05.2014 / 16:00"/>
 *             &lt;enumeration value="18.05.2014 / 18:45"/>
 *             &lt;enumeration value="19.01.2014 / 11:00"/>
 *             &lt;enumeration value="19.01.2014 / 11:30"/>
 *             &lt;enumeration value="19.01.2014 / 13:00"/>
 *             &lt;enumeration value="19.01.2014 / 13:30"/>
 *             &lt;enumeration value="19.01.2014 / 14:00"/>
 *             &lt;enumeration value="19.01.2014 / 16:00"/>
 *             &lt;enumeration value="19.01.2014 / 18:00"/>
 *             &lt;enumeration value="19.01.2014 / 19:45"/>
 *             &lt;enumeration value="19.01.2014 / 20:00"/>
 *             &lt;enumeration value="19.02.2014 / 19:45"/>
 *             &lt;enumeration value="19.03.2014 / 19:45"/>
 *             &lt;enumeration value="20.01.2014 / 20:00"/>
 *             &lt;enumeration value="20.01.2014 / 21:00"/>
 *             &lt;enumeration value="20.02.2014 / 20:05"/>
 *             &lt;enumeration value="24.01.2014 / 19:30"/>
 *             &lt;enumeration value="24.01.2014 / 20:00"/>
 *             &lt;enumeration value="24.05.2014 / 18:45"/>
 *             &lt;enumeration value="25.01.2014 / 14:30"/>
 *             &lt;enumeration value="25.01.2014 / 15:00"/>
 *             &lt;enumeration value="25.01.2014 / 16:00"/>
 *             &lt;enumeration value="25.01.2014 / 17:00"/>
 *             &lt;enumeration value="25.01.2014 / 17:30"/>
 *             &lt;enumeration value="25.01.2014 / 19:00"/>
 *             &lt;enumeration value="25.01.2014 / 19:45"/>
 *             &lt;enumeration value="25.01.2014 / 21:00"/>
 *             &lt;enumeration value="25.02.2014 / 17:00"/>
 *             &lt;enumeration value="25.02.2014 / 19:45"/>
 *             &lt;enumeration value="26.01.2014 / 11:00"/>
 *             &lt;enumeration value="26.01.2014 / 11:30"/>
 *             &lt;enumeration value="26.01.2014 / 13:00"/>
 *             &lt;enumeration value="26.01.2014 / 14:00"/>
 *             &lt;enumeration value="26.01.2014 / 14:30"/>
 *             &lt;enumeration value="26.01.2014 / 16:00"/>
 *             &lt;enumeration value="26.01.2014 / 16:30"/>
 *             &lt;enumeration value="26.01.2014 / 18:00"/>
 *             &lt;enumeration value="26.01.2014 / 19:45"/>
 *             &lt;enumeration value="26.01.2014 / 20:00"/>
 *             &lt;enumeration value="26.02.2014 / 19:45"/>
 *             &lt;enumeration value="27.01.2014 / 21:00"/>
 *             &lt;enumeration value="28.01.2014 / 19:45"/>
 *             &lt;enumeration value="28.01.2014 / 20:00"/>
 *             &lt;enumeration value="29.01.2014 / 19:00"/>
 *             &lt;enumeration value="29.01.2014 / 19:45"/>
 *             &lt;enumeration value="31.01.2014 / 19:30"/>
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
    "games"
})
@XmlRootElement(name = "event")
public class Event {

    @XmlElement(required = true)
    protected List<Games> games;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "eventlink", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String eventlink;
    @XmlAttribute(name = "eventdate", required = true)
    protected String eventdate;

    /**
     * Gets the value of the games property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the games property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Games }
     * 
     * 
     */
    public List<Games> getGames() {
        if (games == null) {
            games = new ArrayList<Games>();
        }
        return this.games;
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
     * Obtiene el valor de la propiedad eventlink.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventlink() {
        return eventlink;
    }

    /**
     * Define el valor de la propiedad eventlink.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventlink(String value) {
        this.eventlink = value;
    }

    /**
     * Obtiene el valor de la propiedad eventdate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventdate() {
        return eventdate;
    }

    /**
     * Define el valor de la propiedad eventdate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventdate(String value) {
        this.eventdate = value;
    }

}
