//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.06.04 a las 11:54:25 AM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{}LEAGUE"/>
 *       &lt;/sequence>
 *       &lt;attribute name="NAME" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Baseball"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "league"
})
@XmlRootElement(name = "KINDOFSPORT")
public class KINDOFSPORT {

    @XmlElement(name = "LEAGUE", required = true)
    protected LEAGUE league;
    @XmlAttribute(name = "NAME", required = true)
    protected String name;

    /**
     * Obtiene el valor de la propiedad league.
     * 
     * @return
     *     possible object is
     *     {@link LEAGUE }
     *     
     */
    public LEAGUE getLEAGUE() {
        return league;
    }

    /**
     * Define el valor de la propiedad league.
     * 
     * @param value
     *     allowed object is
     *     {@link LEAGUE }
     *     
     */
    public void setLEAGUE(LEAGUE value) {
        this.league = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
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
    public void setNAME(String value) {
        this.name = value;
    }

}
