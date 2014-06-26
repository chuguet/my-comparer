//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.03.07 a las 04:57:25 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.unibet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://www.unibet.com/sportsbook-odds-feed}sport"/>
 *       &lt;/sequence>
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
@XmlRootElement(name = "odds_list")
public class OddsList {

    @XmlElement(required = true)
    protected Sport sport;

    /**
     * Obtiene el valor de la propiedad sport.
     * 
     * @return
     *     possible object is
     *     {@link Sport }
     *     
     */
    public Sport getSport() {
        return sport;
    }

    /**
     * Define el valor de la propiedad sport.
     * 
     * @param value
     *     allowed object is
     *     {@link Sport }
     *     
     */
    public void setSport(Sport value) {
        this.sport = value;
    }

}
