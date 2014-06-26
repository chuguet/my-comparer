//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.02.27 a las 01:35:24 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="selectionid" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="priceup" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="pricedown" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="odd" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="handicap" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "selection")
public class Selection {

    @XmlAttribute(name = "selectionid", required = true)
    protected BigDecimal selectionid;
    @XmlAttribute(name = "priceup", required = true)
    protected short priceup;
    @XmlAttribute(name = "pricedown", required = true)
    protected short pricedown;
    @XmlAttribute(name = "odd", required = true)
    protected BigDecimal odd;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "handicap")
    protected BigDecimal handicap;

    /**
     * Obtiene el valor de la propiedad selectionid.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSelectionid() {
        return selectionid;
    }

    /**
     * Define el valor de la propiedad selectionid.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSelectionid(BigDecimal value) {
        this.selectionid = value;
    }

    /**
     * Obtiene el valor de la propiedad priceup.
     * 
     */
    public short getPriceup() {
        return priceup;
    }

    /**
     * Define el valor de la propiedad priceup.
     * 
     */
    public void setPriceup(short value) {
        this.priceup = value;
    }

    /**
     * Obtiene el valor de la propiedad pricedown.
     * 
     */
    public short getPricedown() {
        return pricedown;
    }

    /**
     * Define el valor de la propiedad pricedown.
     * 
     */
    public void setPricedown(short value) {
        this.pricedown = value;
    }

    /**
     * Obtiene el valor de la propiedad odd.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOdd() {
        return odd;
    }

    /**
     * Define el valor de la propiedad odd.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOdd(BigDecimal value) {
        this.odd = value;
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
     * Obtiene el valor de la propiedad handicap.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHandicap() {
        return handicap;
    }

    /**
     * Define el valor de la propiedad handicap.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHandicap(BigDecimal value) {
        this.handicap = value;
    }

}
