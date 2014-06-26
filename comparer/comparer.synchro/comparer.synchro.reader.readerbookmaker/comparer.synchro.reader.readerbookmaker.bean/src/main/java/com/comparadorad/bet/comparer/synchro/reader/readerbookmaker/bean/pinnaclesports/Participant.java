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
 *         &lt;element ref="{}participant_name"/>
 *         &lt;element ref="{}contestantnum"/>
 *         &lt;element ref="{}rotnum"/>
 *         &lt;choice>
 *           &lt;element ref="{}odds"/>
 *           &lt;sequence>
 *             &lt;element ref="{}visiting_home_draw"/>
 *             &lt;element ref="{}pitcher" minOccurs="0"/>
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
    "participantName",
    "contestantnum",
    "rotnum",
    "odds",
    "visitingHomeDraw",
    "pitcher"
})
@XmlRootElement(name = "participant")
public class Participant {

    @XmlElement(name = "participant_name", required = true)
    protected String participantName;
    protected int contestantnum;
    protected short rotnum;
    protected Odds odds;
    @XmlElement(name = "visiting_home_draw")
    protected String visitingHomeDraw;
    protected String pitcher;

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
     * Obtiene el valor de la propiedad contestantnum.
     * 
     */
    public int getContestantnum() {
        return contestantnum;
    }

    /**
     * Define el valor de la propiedad contestantnum.
     * 
     */
    public void setContestantnum(int value) {
        this.contestantnum = value;
    }

    /**
     * Obtiene el valor de la propiedad rotnum.
     * 
     */
    public short getRotnum() {
        return rotnum;
    }

    /**
     * Define el valor de la propiedad rotnum.
     * 
     */
    public void setRotnum(short value) {
        this.rotnum = value;
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
     * Obtiene el valor de la propiedad pitcher.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPitcher() {
        return pitcher;
    }

    /**
     * Define el valor de la propiedad pitcher.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPitcher(String value) {
        this.pitcher = value;
    }

}
