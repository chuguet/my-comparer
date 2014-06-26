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
 *         &lt;element ref="{}spread_visiting"/>
 *         &lt;element ref="{}spread_adjust_visiting"/>
 *         &lt;element ref="{}spread_home"/>
 *         &lt;element ref="{}spread_adjust_home"/>
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
    "spreadVisiting",
    "spreadAdjustVisiting",
    "spreadHome",
    "spreadAdjustHome"
})
@XmlRootElement(name = "spread")
public class Spread {

    @XmlElement(name = "spread_visiting", required = true)
    protected BigDecimal spreadVisiting;
    @XmlElement(name = "spread_adjust_visiting")
    protected short spreadAdjustVisiting;
    @XmlElement(name = "spread_home", required = true)
    protected BigDecimal spreadHome;
    @XmlElement(name = "spread_adjust_home")
    protected short spreadAdjustHome;

    /**
     * Obtiene el valor de la propiedad spreadVisiting.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpreadVisiting() {
        return spreadVisiting;
    }

    /**
     * Define el valor de la propiedad spreadVisiting.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpreadVisiting(BigDecimal value) {
        this.spreadVisiting = value;
    }

    /**
     * Obtiene el valor de la propiedad spreadAdjustVisiting.
     * 
     */
    public short getSpreadAdjustVisiting() {
        return spreadAdjustVisiting;
    }

    /**
     * Define el valor de la propiedad spreadAdjustVisiting.
     * 
     */
    public void setSpreadAdjustVisiting(short value) {
        this.spreadAdjustVisiting = value;
    }

    /**
     * Obtiene el valor de la propiedad spreadHome.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSpreadHome() {
        return spreadHome;
    }

    /**
     * Define el valor de la propiedad spreadHome.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSpreadHome(BigDecimal value) {
        this.spreadHome = value;
    }

    /**
     * Obtiene el valor de la propiedad spreadAdjustHome.
     * 
     */
    public short getSpreadAdjustHome() {
        return spreadAdjustHome;
    }

    /**
     * Define el valor de la propiedad spreadAdjustHome.
     * 
     */
    public void setSpreadAdjustHome(short value) {
        this.spreadAdjustHome = value;
    }

}
