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
 *         &lt;element ref="{}total_points"/>
 *         &lt;element ref="{}over_adjust"/>
 *         &lt;element ref="{}under_adjust"/>
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
    "totalPoints",
    "overAdjust",
    "underAdjust"
})
@XmlRootElement(name = "total")
public class Total {

    @XmlElement(name = "total_points", required = true)
    protected String totalPoints;
    @XmlElement(name = "over_adjust", required = true)
    protected String overAdjust;
    @XmlElement(name = "under_adjust", required = true)
    protected String underAdjust;

    /**
     * Obtiene el valor de la propiedad totalPoints.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotalPoints() {
        return totalPoints;
    }

    /**
     * Define el valor de la propiedad totalPoints.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotalPoints(String value) {
        this.totalPoints = value;
    }

    /**
     * Obtiene el valor de la propiedad overAdjust.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverAdjust() {
        return overAdjust;
    }

    /**
     * Define el valor de la propiedad overAdjust.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverAdjust(String value) {
        this.overAdjust = value;
    }

    /**
     * Obtiene el valor de la propiedad underAdjust.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderAdjust() {
        return underAdjust;
    }

    /**
     * Define el valor de la propiedad underAdjust.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderAdjust(String value) {
        this.underAdjust = value;
    }

}
