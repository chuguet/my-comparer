//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.12.13 a las 02:36:37 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.intertops;

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
 *       &lt;attribute name="utc" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="sportId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="matchId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="legend" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="includeFraction" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="includeCent" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="deltaUtc" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="delta" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="catId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "params")
public class Params {

    @XmlAttribute(name = "utc", required = true)
    protected String utc;
    @XmlAttribute(name = "sportId", required = true)
    protected String sportId;
    @XmlAttribute(name = "matchId", required = true)
    protected String matchId;
    @XmlAttribute(name = "legend", required = true)
    protected String legend;
    @XmlAttribute(name = "includeFraction", required = true)
    protected String includeFraction;
    @XmlAttribute(name = "includeCent", required = true)
    protected String includeCent;
    @XmlAttribute(name = "deltaUtc", required = true)
    protected String deltaUtc;
    @XmlAttribute(name = "delta", required = true)
    protected String delta;
    @XmlAttribute(name = "catId", required = true)
    protected String catId;

    /**
     * Obtiene el valor de la propiedad utc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtc() {
        return utc;
    }

    /**
     * Define el valor de la propiedad utc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtc(String value) {
        this.utc = value;
    }

    /**
     * Obtiene el valor de la propiedad sportId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSportId() {
        return sportId;
    }

    /**
     * Define el valor de la propiedad sportId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSportId(String value) {
        this.sportId = value;
    }

    /**
     * Obtiene el valor de la propiedad matchId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchId() {
        return matchId;
    }

    /**
     * Define el valor de la propiedad matchId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchId(String value) {
        this.matchId = value;
    }

    /**
     * Obtiene el valor de la propiedad legend.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegend() {
        return legend;
    }

    /**
     * Define el valor de la propiedad legend.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegend(String value) {
        this.legend = value;
    }

    /**
     * Obtiene el valor de la propiedad includeFraction.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludeFraction() {
        return includeFraction;
    }

    /**
     * Define el valor de la propiedad includeFraction.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeFraction(String value) {
        this.includeFraction = value;
    }

    /**
     * Obtiene el valor de la propiedad includeCent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncludeCent() {
        return includeCent;
    }

    /**
     * Define el valor de la propiedad includeCent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncludeCent(String value) {
        this.includeCent = value;
    }

    /**
     * Obtiene el valor de la propiedad deltaUtc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeltaUtc() {
        return deltaUtc;
    }

    /**
     * Define el valor de la propiedad deltaUtc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeltaUtc(String value) {
        this.deltaUtc = value;
    }

    /**
     * Obtiene el valor de la propiedad delta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelta() {
        return delta;
    }

    /**
     * Define el valor de la propiedad delta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelta(String value) {
        this.delta = value;
    }

    /**
     * Obtiene el valor de la propiedad catId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCatId() {
        return catId;
    }

    /**
     * Define el valor de la propiedad catId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCatId(String value) {
        this.catId = value;
    }

}
