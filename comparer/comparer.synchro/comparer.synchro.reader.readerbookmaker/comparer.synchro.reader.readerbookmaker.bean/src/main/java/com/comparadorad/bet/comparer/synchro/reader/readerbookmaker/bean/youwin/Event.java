//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.02.27 a las 01:35:24 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin;

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
 *         &lt;element ref="{}bet" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="eventid" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="betend" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "bet"
})
@XmlRootElement(name = "event")
public class Event {

    @XmlElement(required = true)
    protected List<Bet> bet;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "eventid", required = true)
    protected BigDecimal eventid;
    @XmlAttribute(name = "betend", required = true)
    protected String betend;

    /**
     * Gets the value of the bet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bet }
     * 
     * 
     */
    public List<Bet> getBet() {
        if (bet == null) {
            bet = new ArrayList<Bet>();
        }
        return this.bet;
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
     * Obtiene el valor de la propiedad betend.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBetend() {
        return betend;
    }

    /**
     * Define el valor de la propiedad betend.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBetend(String value) {
        this.betend = value;
    }

}
