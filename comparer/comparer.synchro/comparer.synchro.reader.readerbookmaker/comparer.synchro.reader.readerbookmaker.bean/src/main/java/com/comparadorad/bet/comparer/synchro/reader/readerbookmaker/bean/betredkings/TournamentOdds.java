//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.03 a las 04:13:49 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings;

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
 *         &lt;element ref="{}BettingOffer"/>
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
    "bettingOffer"
})
@XmlRootElement(name = "TournamentOdds")
public class TournamentOdds {

    @XmlElement(name = "BettingOffer", required = true)
    protected BettingOffer bettingOffer;

    /**
     * Obtiene el valor de la propiedad bettingOffer.
     * 
     * @return
     *     possible object is
     *     {@link BettingOffer }
     *     
     */
    public BettingOffer getBettingOffer() {
        return bettingOffer;
    }

    /**
     * Define el valor de la propiedad bettingOffer.
     * 
     * @param value
     *     allowed object is
     *     {@link BettingOffer }
     *     
     */
    public void setBettingOffer(BettingOffer value) {
        this.bettingOffer = value;
    }

}
