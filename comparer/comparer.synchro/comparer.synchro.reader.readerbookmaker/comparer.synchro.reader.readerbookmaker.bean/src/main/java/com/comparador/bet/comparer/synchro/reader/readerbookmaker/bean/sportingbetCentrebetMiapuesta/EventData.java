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
 *         &lt;element ref="{}MasterEvents" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="EventURL" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "masterEvents"
})
@XmlRootElement(name = "EventData")
public class EventData {

    @XmlElement(name = "MasterEvents", required = true)
    protected List<MasterEvents> masterEvents;
    @XmlAttribute(name = "EventURL", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String eventURL;

    /**
     * Gets the value of the masterEvents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the masterEvents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMasterEvents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MasterEvents }
     * 
     * 
     */
    public List<MasterEvents> getMasterEvents() {
        if (masterEvents == null) {
            masterEvents = new ArrayList<MasterEvents>();
        }
        return this.masterEvents;
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

}
