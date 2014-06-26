//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.02.28 a las 04:23:47 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports;

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
 *         &lt;element ref="{}moneyline_value"/>
 *         &lt;element ref="{}to_base"/>
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
    "moneylineValue",
    "toBase"
})
@XmlRootElement(name = "odds")
public class Odds {

    @XmlElement(name = "moneyline_value", required = true)
    protected String moneylineValue;
    @XmlElement(name = "to_base", required = true)
    protected String toBase;

    /**
     * Obtiene el valor de la propiedad moneylineValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoneylineValue() {
        return moneylineValue;
    }

    /**
     * Define el valor de la propiedad moneylineValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoneylineValue(String value) {
        this.moneylineValue = value;
    }

    /**
     * Obtiene el valor de la propiedad toBase.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToBase() {
        return toBase;
    }

    /**
     * Define el valor de la propiedad toBase.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToBase(String value) {
        this.toBase = value;
    }

}
