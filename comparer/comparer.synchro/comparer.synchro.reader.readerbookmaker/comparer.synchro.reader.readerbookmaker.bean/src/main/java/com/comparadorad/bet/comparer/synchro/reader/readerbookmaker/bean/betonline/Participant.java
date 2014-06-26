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
 *         &lt;element ref="{}participant_name"/>
 *         &lt;element ref="{}rotnum"/>
 *         &lt;element ref="{}visiting_home_draw"/>
 *         &lt;element ref="{}odds"/>
 *         &lt;element ref="{}pitcher"/>
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
    "participantName",
    "rotnum",
    "visitingHomeDraw",
    "odds",
    "pitcher"
})
@XmlRootElement(name = "participant")
public class Participant {

    @XmlElement(name = "participant_name", required = true)
    protected String participantName;
    @XmlElement(required = true)
    protected String rotnum;
    @XmlElement(name = "visiting_home_draw", required = true)
    protected String visitingHomeDraw;
    @XmlElement(required = true)
    protected Odds odds;
    @XmlElement(required = true)
    protected Pitcher pitcher;

    /**
     * Obtiene el valor de la propiedad participantName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipantName() {
        return participantName;
    }

    /**
     * Define el valor de la propiedad participantName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipantName(String value) {
        this.participantName = value;
    }

    /**
     * Obtiene el valor de la propiedad rotnum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRotnum() {
        return rotnum;
    }

    /**
     * Define el valor de la propiedad rotnum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRotnum(String value) {
        this.rotnum = value;
    }

    /**
     * Obtiene el valor de la propiedad visitingHomeDraw.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisitingHomeDraw() {
        return visitingHomeDraw;
    }

    /**
     * Define el valor de la propiedad visitingHomeDraw.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisitingHomeDraw(String value) {
        this.visitingHomeDraw = value;
    }

    /**
     * Obtiene el valor de la propiedad odds.
     * 
     * @return
     *     possible object is
     *     {@link Odds }
     *     
     */
    public Odds getOdds() {
        return odds;
    }

    /**
     * Define el valor de la propiedad odds.
     * 
     * @param value
     *     allowed object is
     *     {@link Odds }
     *     
     */
    public void setOdds(Odds value) {
        this.odds = value;
    }

    /**
     * Obtiene el valor de la propiedad pitcher.
     * 
     * @return
     *     possible object is
     *     {@link Pitcher }
     *     
     */
    public Pitcher getPitcher() {
        return pitcher;
    }

    /**
     * Define el valor de la propiedad pitcher.
     * 
     * @param value
     *     allowed object is
     *     {@link Pitcher }
     *     
     */
    public void setPitcher(Pitcher value) {
        this.pitcher = value;
    }

}
