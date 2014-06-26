//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.04 a las 04:59:13 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}event_datetimeGMT"/>
 *         &lt;element ref="{}sporttype"/>
 *         &lt;element ref="{}scheduletext"/>
 *         &lt;element ref="{}league"/>
 *         &lt;element ref="{}participant" maxOccurs="unbounded"/>
 *         &lt;element ref="{}drawrotnum"/>
 *         &lt;element ref="{}drawmoneyline"/>
 *         &lt;element ref="{}drawTitle"/>
 *         &lt;element ref="{}period"/>
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
    "eventDatetimeGMT",
    "sporttype",
    "scheduletext",
    "league",
    "participant",
    "drawrotnum",
    "drawmoneyline",
    "drawTitle",
    "period"
})
@XmlRootElement(name = "event")
public class Event {

    @XmlElement(name = "event_datetimeGMT", required = true)
    protected String eventDatetimeGMT;
    @XmlElement(required = true)
    protected String sporttype;
    @XmlElement(required = true)
    protected String scheduletext;
    @XmlElement(required = true)
    protected String league;
    @XmlElement(required = true)
    protected List<Participant> participant;
    @XmlElement(required = true)
    protected String drawrotnum;
    @XmlElement(required = true)
    protected String drawmoneyline;
    @XmlElement(required = true)
    protected DrawTitle drawTitle;
    @XmlElement(required = true)
    protected Period period;

    /**
     * Obtiene el valor de la propiedad eventDatetimeGMT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDatetimeGMT() {
        return eventDatetimeGMT;
    }

    /**
     * Define el valor de la propiedad eventDatetimeGMT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDatetimeGMT(String value) {
        this.eventDatetimeGMT = value;
    }

    /**
     * Obtiene el valor de la propiedad sporttype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSporttype() {
        return sporttype;
    }

    /**
     * Define el valor de la propiedad sporttype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSporttype(String value) {
        this.sporttype = value;
    }

    /**
     * Obtiene el valor de la propiedad scheduletext.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduletext() {
        return scheduletext;
    }

    /**
     * Define el valor de la propiedad scheduletext.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduletext(String value) {
        this.scheduletext = value;
    }

    /**
     * Obtiene el valor de la propiedad league.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeague() {
        return league;
    }

    /**
     * Define el valor de la propiedad league.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeague(String value) {
        this.league = value;
    }

    /**
     * Gets the value of the participant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the participant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticipant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Participant }
     * 
     * 
     */
    public List<Participant> getParticipant() {
        if (participant == null) {
            participant = new ArrayList<Participant>();
        }
        return this.participant;
    }

    /**
     * Obtiene el valor de la propiedad drawrotnum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrawrotnum() {
        return drawrotnum;
    }

    /**
     * Define el valor de la propiedad drawrotnum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrawrotnum(String value) {
        this.drawrotnum = value;
    }

    /**
     * Obtiene el valor de la propiedad drawmoneyline.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrawmoneyline() {
        return drawmoneyline;
    }

    /**
     * Define el valor de la propiedad drawmoneyline.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrawmoneyline(String value) {
        this.drawmoneyline = value;
    }

    /**
     * Obtiene el valor de la propiedad drawTitle.
     * 
     * @return
     *     possible object is
     *     {@link DrawTitle }
     *     
     */
    public DrawTitle getDrawTitle() {
        return drawTitle;
    }

    /**
     * Define el valor de la propiedad drawTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link DrawTitle }
     *     
     */
    public void setDrawTitle(DrawTitle value) {
        this.drawTitle = value;
    }

    /**
     * Obtiene el valor de la propiedad period.
     * 
     * @return
     *     possible object is
     *     {@link Period }
     *     
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Define el valor de la propiedad period.
     * 
     * @param value
     *     allowed object is
     *     {@link Period }
     *     
     */
    public void setPeriod(Period value) {
        this.period = value;
    }

}
