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
 *         &lt;element ref="{}PinnacleFeedTime"/>
 *         &lt;element ref="{}lastContest"/>
 *         &lt;element ref="{}lastGame"/>
 *         &lt;element ref="{}events"/>
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
    "pinnacleFeedTime",
    "lastContest",
    "lastGame",
    "events"
})
@XmlRootElement(name = "pinnacle_line_feed")
public class PinnacleLineFeed {

    @XmlElement(name = "PinnacleFeedTime")
    protected long pinnacleFeedTime;
    protected int lastContest;
    protected int lastGame;
    @XmlElement(required = true)
    protected Events events;

    /**
     * Obtiene el valor de la propiedad pinnacleFeedTime.
     * 
     */
    public long getPinnacleFeedTime() {
        return pinnacleFeedTime;
    }

    /**
     * Define el valor de la propiedad pinnacleFeedTime.
     * 
     */
    public void setPinnacleFeedTime(long value) {
        this.pinnacleFeedTime = value;
    }

    /**
     * Obtiene el valor de la propiedad lastContest.
     * 
     */
    public int getLastContest() {
        return lastContest;
    }

    /**
     * Define el valor de la propiedad lastContest.
     * 
     */
    public void setLastContest(int value) {
        this.lastContest = value;
    }

    /**
     * Obtiene el valor de la propiedad lastGame.
     * 
     */
    public int getLastGame() {
        return lastGame;
    }

    /**
     * Define el valor de la propiedad lastGame.
     * 
     */
    public void setLastGame(int value) {
        this.lastGame = value;
    }

    /**
     * Obtiene el valor de la propiedad events.
     * 
     * @return
     *     possible object is
     *     {@link Events }
     *     
     */
    public Events getEvents() {
        return events;
    }

    /**
     * Define el valor de la propiedad events.
     * 
     * @param value
     *     allowed object is
     *     {@link Events }
     *     
     */
    public void setEvents(Events value) {
        this.events = value;
    }

}
