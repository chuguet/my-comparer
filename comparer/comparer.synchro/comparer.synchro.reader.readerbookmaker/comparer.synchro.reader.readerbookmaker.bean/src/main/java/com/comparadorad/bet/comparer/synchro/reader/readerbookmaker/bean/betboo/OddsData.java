//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.06.03 a las 11:12:51 AM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo;

import java.math.BigDecimal;
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
 *       &lt;choice minOccurs="0">
 *         &lt;element ref="{}Competitor" maxOccurs="unbounded"/>
 *         &lt;sequence>
 *           &lt;element ref="{}HomeTeam"/>
 *           &lt;element ref="{}AwayTeam"/>
 *           &lt;choice>
 *             &lt;sequence>
 *               &lt;element ref="{}Total"/>
 *               &lt;element ref="{}UnderOdds"/>
 *               &lt;element ref="{}OverOdds"/>
 *             &lt;/sequence>
 *             &lt;sequence>
 *               &lt;element ref="{}SpreadHome"/>
 *               &lt;element ref="{}SpreadAway"/>
 *               &lt;element ref="{}SpreadOddsHome"/>
 *               &lt;element ref="{}SpreadOddsAway"/>
 *             &lt;/sequence>
 *             &lt;sequence>
 *               &lt;element ref="{}HomeOdds"/>
 *               &lt;element ref="{}DrawOdds" minOccurs="0"/>
 *               &lt;element ref="{}AwayOdds"/>
 *             &lt;/sequence>
 *           &lt;/choice>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "competitor",
    "homeTeam",
    "awayTeam",
    "total",
    "underOdds",
    "overOdds",
    "spreadHome",
    "spreadAway",
    "spreadOddsHome",
    "spreadOddsAway",
    "homeOdds",
    "drawOdds",
    "awayOdds"
})
@XmlRootElement(name = "OddsData")
public class OddsData {

    @XmlElement(name = "Competitor")
    protected List<Competitor> competitor;
    @XmlElement(name = "HomeTeam")
    protected String homeTeam;
    @XmlElement(name = "AwayTeam")
    protected String awayTeam;
    @XmlElement(name = "Total")
    protected String total;
    @XmlElement(name = "UnderOdds")
    protected String underOdds;
    @XmlElement(name = "OverOdds")
    protected String overOdds;
    @XmlElement(name = "SpreadHome")
    protected String spreadHome;
    @XmlElement(name = "SpreadAway")
    protected String spreadAway;
    @XmlElement(name = "SpreadOddsHome")
    protected String spreadOddsHome;
    @XmlElement(name = "SpreadOddsAway")
    protected String spreadOddsAway;
    @XmlElement(name = "HomeOdds")
    protected BigDecimal homeOdds;
    @XmlElement(name = "DrawOdds")
    protected BigDecimal drawOdds;
    @XmlElement(name = "AwayOdds")
    protected BigDecimal awayOdds;

    /**
     * Gets the value of the competitor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the competitor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCompetitor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Competitor }
     * 
     * 
     */
    public List<Competitor> getCompetitor() {
        if (competitor == null) {
            competitor = new ArrayList<Competitor>();
        }
        return this.competitor;
    }

    /**
     * Obtiene el valor de la propiedad homeTeam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeTeam() {
        return homeTeam;
    }

    /**
     * Define el valor de la propiedad homeTeam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeTeam(String value) {
        this.homeTeam = value;
    }

    /**
     * Obtiene el valor de la propiedad awayTeam.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwayTeam() {
        return awayTeam;
    }

    /**
     * Define el valor de la propiedad awayTeam.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwayTeam(String value) {
        this.awayTeam = value;
    }

    /**
     * Obtiene el valor de la propiedad total.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTotal() {
        return total;
    }

    /**
     * Define el valor de la propiedad total.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTotal(String value) {
        this.total = value;
    }

    /**
     * Obtiene el valor de la propiedad underOdds.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnderOdds() {
        return underOdds;
    }

    /**
     * Define el valor de la propiedad underOdds.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnderOdds(String value) {
        this.underOdds = value;
    }

    /**
     * Obtiene el valor de la propiedad overOdds.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverOdds() {
        return overOdds;
    }

    /**
     * Define el valor de la propiedad overOdds.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverOdds(String value) {
        this.overOdds = value;
    }

    /**
     * Obtiene el valor de la propiedad spreadHome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadHome() {
        return spreadHome;
    }

    /**
     * Define el valor de la propiedad spreadHome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadHome(String value) {
        this.spreadHome = value;
    }

    /**
     * Obtiene el valor de la propiedad spreadAway.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadAway() {
        return spreadAway;
    }

    /**
     * Define el valor de la propiedad spreadAway.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadAway(String value) {
        this.spreadAway = value;
    }

    /**
     * Obtiene el valor de la propiedad spreadOddsHome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadOddsHome() {
        return spreadOddsHome;
    }

    /**
     * Define el valor de la propiedad spreadOddsHome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadOddsHome(String value) {
        this.spreadOddsHome = value;
    }

    /**
     * Obtiene el valor de la propiedad spreadOddsAway.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpreadOddsAway() {
        return spreadOddsAway;
    }

    /**
     * Define el valor de la propiedad spreadOddsAway.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpreadOddsAway(String value) {
        this.spreadOddsAway = value;
    }

    /**
     * Obtiene el valor de la propiedad homeOdds.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHomeOdds() {
        return homeOdds;
    }

    /**
     * Define el valor de la propiedad homeOdds.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHomeOdds(BigDecimal value) {
        this.homeOdds = value;
    }

    /**
     * Obtiene el valor de la propiedad drawOdds.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDrawOdds() {
        return drawOdds;
    }

    /**
     * Define el valor de la propiedad drawOdds.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDrawOdds(BigDecimal value) {
        this.drawOdds = value;
    }

    /**
     * Obtiene el valor de la propiedad awayOdds.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAwayOdds() {
        return awayOdds;
    }

    /**
     * Define el valor de la propiedad awayOdds.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAwayOdds(BigDecimal value) {
        this.awayOdds = value;
    }

}
