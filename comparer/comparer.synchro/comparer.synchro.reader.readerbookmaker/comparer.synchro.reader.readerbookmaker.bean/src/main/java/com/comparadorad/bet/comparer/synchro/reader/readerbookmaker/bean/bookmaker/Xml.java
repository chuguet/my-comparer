//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.28 a las 12:15:40 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bookmaker;

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
 *         &lt;element ref="{}Leagues" minOccurs="0"/>
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
    "leagues"
})
@XmlRootElement(name = "xml")
public class Xml {

    @XmlElement(name = "Leagues")
    protected Leagues leagues;

    /**
     * Obtiene el valor de la propiedad leagues.
     * 
     * @return
     *     possible object is
     *     {@link Leagues }
     *     
     */
    public Leagues getLeagues() {
        return leagues;
    }

    /**
     * Define el valor de la propiedad leagues.
     * 
     * @param value
     *     allowed object is
     *     {@link Leagues }
     *     
     */
    public void setLeagues(Leagues value) {
        this.leagues = value;
    }

}
