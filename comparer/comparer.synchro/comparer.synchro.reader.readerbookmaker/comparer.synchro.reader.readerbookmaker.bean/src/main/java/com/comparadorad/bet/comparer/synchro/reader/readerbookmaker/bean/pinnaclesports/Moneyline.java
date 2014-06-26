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
 *         &lt;element ref="{}moneyline_visiting"/>
 *         &lt;element ref="{}moneyline_home"/>
 *         &lt;element ref="{}moneyline_draw" minOccurs="0"/>
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
    "moneylineVisiting",
    "moneylineHome",
    "moneylineDraw"
})
@XmlRootElement(name = "moneyline")
public class Moneyline {

    @XmlElement(name = "moneyline_visiting")
    protected short moneylineVisiting;
    @XmlElement(name = "moneyline_home")
    protected short moneylineHome;
    @XmlElement(name = "moneyline_draw")
    protected Short moneylineDraw;

    /**
     * Obtiene el valor de la propiedad moneylineVisiting.
     * 
     */
    public short getMoneylineVisiting() {
        return moneylineVisiting;
    }

    /**
     * Define el valor de la propiedad moneylineVisiting.
     * 
     */
    public void setMoneylineVisiting(short value) {
        this.moneylineVisiting = value;
    }

    /**
     * Obtiene el valor de la propiedad moneylineHome.
     * 
     */
    public short getMoneylineHome() {
        return moneylineHome;
    }

    /**
     * Define el valor de la propiedad moneylineHome.
     * 
     */
    public void setMoneylineHome(short value) {
        this.moneylineHome = value;
    }

    /**
     * Obtiene el valor de la propiedad moneylineDraw.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getMoneylineDraw() {
        return moneylineDraw;
    }

    /**
     * Define el valor de la propiedad moneylineDraw.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setMoneylineDraw(Short value) {
        this.moneylineDraw = value;
    }

}
