//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.04 a las 04:59:13 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline;

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
 *         &lt;element ref="{}period_description"/>
 *         &lt;element ref="{}periodcutoff_datetimeGMT"/>
 *         &lt;element ref="{}period_status"/>
 *         &lt;element ref="{}spread"/>
 *         &lt;element ref="{}total"/>
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
    "periodDescription",
    "periodcutoffDatetimeGMT",
    "periodStatus",
    "spread",
    "total"
})
@XmlRootElement(name = "period")
public class Period {

    @XmlElement(name = "period_description", required = true)
    protected String periodDescription;
    @XmlElement(name = "periodcutoff_datetimeGMT", required = true)
    protected String periodcutoffDatetimeGMT;
    @XmlElement(name = "period_status", required = true)
    protected String periodStatus;
    @XmlElement(required = true)
    protected Spread spread;
    @XmlElement(required = true)
    protected Total total;

    /**
     * Obtiene el valor de la propiedad periodDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodDescription() {
        return periodDescription;
    }

    /**
     * Define el valor de la propiedad periodDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodDescription(String value) {
        this.periodDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad periodcutoffDatetimeGMT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodcutoffDatetimeGMT() {
        return periodcutoffDatetimeGMT;
    }

    /**
     * Define el valor de la propiedad periodcutoffDatetimeGMT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodcutoffDatetimeGMT(String value) {
        this.periodcutoffDatetimeGMT = value;
    }

    /**
     * Obtiene el valor de la propiedad periodStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriodStatus() {
        return periodStatus;
    }

    /**
     * Define el valor de la propiedad periodStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriodStatus(String value) {
        this.periodStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad spread.
     * 
     * @return
     *     possible object is
     *     {@link Spread }
     *     
     */
    public Spread getSpread() {
        return spread;
    }

    /**
     * Define el valor de la propiedad spread.
     * 
     * @param value
     *     allowed object is
     *     {@link Spread }
     *     
     */
    public void setSpread(Spread value) {
        this.spread = value;
    }

    /**
     * Obtiene el valor de la propiedad total.
     * 
     * @return
     *     possible object is
     *     {@link Total }
     *     
     */
    public Total getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     * @param value
     *     allowed object is
     *     {@link Total }
     *     
     */
    public void setTotal(Total value) {
        this.total = value;
    }

}
