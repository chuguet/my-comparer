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
 *         &lt;element ref="{}Event" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TopLevelName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TimeStamp" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MasterName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MasterID" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MasterEventURL" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "event"
})
@XmlRootElement(name = "MasterEvents")
public class MasterEvents {

    @XmlElement(name = "Event", required = true)
    protected List<Event> event;
    @XmlAttribute(name = "TopLevelName")
    protected String topLevelName;
    @XmlAttribute(name = "TimeStamp", required = true)
    protected String timeStamp;
    @XmlAttribute(name = "MasterName", required = true)
    protected String masterName;
    @XmlAttribute(name = "MasterID", required = true)
    protected int masterID;
    @XmlAttribute(name = "MasterEventURL", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String masterEventURL;

    /**
     * Gets the value of the event property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the event property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Event }
     * 
     * 
     */
    public List<Event> getEvent() {
        if (event == null) {
            event = new ArrayList<Event>();
        }
        return this.event;
    }

    /**
     * Obtiene el valor de la propiedad topLevelName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTopLevelName() {
        return topLevelName;
    }

    /**
     * Define el valor de la propiedad topLevelName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTopLevelName(String value) {
        this.topLevelName = value;
    }

    /**
     * Obtiene el valor de la propiedad timeStamp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Define el valor de la propiedad timeStamp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
    }

    /**
     * Obtiene el valor de la propiedad masterName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterName() {
        return masterName;
    }

    /**
     * Define el valor de la propiedad masterName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterName(String value) {
        this.masterName = value;
    }

    /**
     * Obtiene el valor de la propiedad masterID.
     * 
     */
    public int getMasterID() {
        return masterID;
    }

    /**
     * Define el valor de la propiedad masterID.
     * 
     */
    public void setMasterID(int value) {
        this.masterID = value;
    }

    /**
     * Obtiene el valor de la propiedad masterEventURL.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterEventURL() {
        return masterEventURL;
    }

    /**
     * Define el valor de la propiedad masterEventURL.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterEventURL(String value) {
        this.masterEventURL = value;
    }

}
