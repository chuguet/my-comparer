//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.06.03 a las 11:12:51 AM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{}Sport"/>
 *         &lt;element ref="{}Category"/>
 *         &lt;element ref="{}Tournament"/>
 *         &lt;element ref="{}MatchId"/>
 *         &lt;element ref="{}Date"/>
 *         &lt;element ref="{}AC"/>
 *         &lt;element ref="{}OddsType"/>
 *         &lt;element ref="{}OddsData"/>
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
    "sport",
    "category",
    "tournament",
    "matchId",
    "date",
    "ac",
    "oddsType",
    "oddsData"
})
@XmlRootElement(name = "OddsObject")
public class OddsObject {

    @XmlElement(name = "Sport", required = true)
    protected String sport;
    @XmlElement(name = "Category", required = true)
    protected String category;
    @XmlElement(name = "Tournament", required = true)
    protected String tournament;
    @XmlElement(name = "MatchId")
    protected int matchId;
    @XmlElement(name = "Date", required = true)
    protected XMLGregorianCalendar date;
    @XmlElement(name = "AC")
    protected byte ac;
    @XmlElement(name = "OddsType", required = true)
    protected String oddsType;
    @XmlElement(name = "OddsData", required = true)
    protected OddsData oddsData;

    /**
     * Obtiene el valor de la propiedad sport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSport() {
        return sport;
    }

    /**
     * Define el valor de la propiedad sport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSport(String value) {
        this.sport = value;
    }

    /**
     * Obtiene el valor de la propiedad category.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Define el valor de la propiedad category.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Obtiene el valor de la propiedad tournament.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTournament() {
        return tournament;
    }

    /**
     * Define el valor de la propiedad tournament.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTournament(String value) {
        this.tournament = value;
    }

    /**
     * Obtiene el valor de la propiedad matchId.
     * 
     */
    public int getMatchId() {
        return matchId;
    }

    /**
     * Define el valor de la propiedad matchId.
     * 
     */
    public void setMatchId(int value) {
        this.matchId = value;
    }

    /**
     * Obtiene el valor de la propiedad date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtiene el valor de la propiedad ac.
     * 
     */
    public byte getAC() {
        return ac;
    }

    /**
     * Define el valor de la propiedad ac.
     * 
     */
    public void setAC(byte value) {
        this.ac = value;
    }

    /**
     * Obtiene el valor de la propiedad oddsType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOddsType() {
        return oddsType;
    }

    /**
     * Define el valor de la propiedad oddsType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOddsType(String value) {
        this.oddsType = value;
    }

    /**
     * Obtiene el valor de la propiedad oddsData.
     * 
     * @return
     *     possible object is
     *     {@link OddsData }
     *     
     */
    public OddsData getOddsData() {
        return oddsData;
    }

    /**
     * Define el valor de la propiedad oddsData.
     * 
     * @param value
     *     allowed object is
     *     {@link OddsData }
     *     
     */
    public void setOddsData(OddsData value) {
        this.oddsData = value;
    }

}
