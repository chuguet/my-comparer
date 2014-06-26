//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.02.27 a las 01:35:24 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin;

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
 *         &lt;element ref="{}sport" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="timezone" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="last_modified" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="date_format" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sport"
})
@XmlRootElement(name = "odds")
public class Odds {

    @XmlElement(required = true)
    protected List<Sport> sport;
    @XmlAttribute(name = "timezone", required = true)
    protected String timezone;
    @XmlAttribute(name = "last_modified", required = true)
    protected String lastModified;
    @XmlAttribute(name = "date_format", required = true)
    protected String dateFormat;

    /**
     * Gets the value of the sport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sport }
     * 
     * 
     */
    public List<Sport> getSport() {
        if (sport == null) {
            sport = new ArrayList<Sport>();
        }
        return this.sport;
    }

    /**
     * Obtiene el valor de la propiedad timezone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Define el valor de la propiedad timezone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimezone(String value) {
        this.timezone = value;
    }

    /**
     * Obtiene el valor de la propiedad lastModified.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModified() {
        return lastModified;
    }

    /**
     * Define el valor de la propiedad lastModified.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModified(String value) {
        this.lastModified = value;
    }

    /**
     * Obtiene el valor de la propiedad dateFormat.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * Define el valor de la propiedad dateFormat.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFormat(String value) {
        this.dateFormat = value;
    }

}
