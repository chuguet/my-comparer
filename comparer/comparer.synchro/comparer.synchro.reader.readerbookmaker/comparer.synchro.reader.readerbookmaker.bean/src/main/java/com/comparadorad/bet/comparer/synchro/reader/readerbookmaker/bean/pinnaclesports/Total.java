//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.02.28 a las 04:23:47 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports;

import java.math.BigDecimal;
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
 *         &lt;choice>
 *           &lt;element ref="{}units"/>
 *           &lt;sequence>
 *             &lt;element ref="{}over_adjust"/>
 *             &lt;element ref="{}under_adjust"/>
 *           &lt;/sequence>
 *         &lt;/choice>
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
    "units",
    "overAdjust",
    "underAdjust"
})
@XmlRootElement(name = "total")
public class Total {

    @XmlElement(name = "total_points", required = true)
    protected BigDecimal totalPoints;
    protected String units;
    @XmlElement(name = "over_adjust")
    protected Short overAdjust;
    @XmlElement(name = "under_adjust")
    protected Short underAdjust;

    /**
     * Obtiene el valor de la propiedad totalPoints.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPoints() {
        return totalPoints;
    }

    /**
     * Define el valor de la propiedad totalPoints.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPoints(BigDecimal value) {
        this.totalPoints = value;
    }

    /**
     * Obtiene el valor de la propiedad units.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnits() {
        return units;
    }

    /**
     * Define el valor de la propiedad units.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnits(String value) {
        this.units = value;
    }

    /**
     * Obtiene el valor de la propiedad overAdjust.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getOverAdjust() {
        return overAdjust;
    }

    /**
     * Define el valor de la propiedad overAdjust.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setOverAdjust(Short value) {
        this.overAdjust = value;
    }

    /**
     * Obtiene el valor de la propiedad underAdjust.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getUnderAdjust() {
        return underAdjust;
    }

    /**
     * Define el valor de la propiedad underAdjust.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setUnderAdjust(Short value) {
        this.underAdjust = value;
    }

}
