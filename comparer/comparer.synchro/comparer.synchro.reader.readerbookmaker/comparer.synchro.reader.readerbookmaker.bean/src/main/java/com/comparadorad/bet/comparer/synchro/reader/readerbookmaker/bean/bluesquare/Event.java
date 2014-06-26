//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.05.23 a las 02:06:29 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bluesquare;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}Description"/>
 *         &lt;element ref="{}Market" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="trifecta" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=" "/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="tracktype" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="start_time" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="2013-05-23 14:30:00"/>
 *             &lt;enumeration value="2013-05-23 16:30:00"/>
 *             &lt;enumeration value="2013-05-23 16:45:00"/>
 *             &lt;enumeration value="2013-05-23 17:00:00"/>
 *             &lt;enumeration value="2013-05-23 17:45:00"/>
 *             &lt;enumeration value="2013-05-23 18:00:00"/>
 *             &lt;enumeration value="2013-05-23 18:05:00"/>
 *             &lt;enumeration value="2013-05-23 18:45:00"/>
 *             &lt;enumeration value="2013-05-23 19:30:00"/>
 *             &lt;enumeration value="2013-05-23 19:45:00"/>
 *             &lt;enumeration value="2013-05-23 23:00:00"/>
 *             &lt;enumeration value="2013-05-23 23:30:00"/>
 *             &lt;enumeration value="2013-05-24 01:15:00"/>
 *             &lt;enumeration value="2013-05-24 01:30:00"/>
 *             &lt;enumeration value="2013-05-24 03:00:00"/>
 *             &lt;enumeration value="2013-05-24 12:30:00"/>
 *             &lt;enumeration value="2013-05-24 17:00:00"/>
 *             &lt;enumeration value="2013-05-24 18:00:00"/>
 *             &lt;enumeration value="2013-05-24 18:20:00"/>
 *             &lt;enumeration value="2013-05-24 19:05:00"/>
 *             &lt;enumeration value="2013-05-24 19:30:00"/>
 *             &lt;enumeration value="2013-05-24 19:45:00"/>
 *             &lt;enumeration value="2013-05-24 20:00:00"/>
 *             &lt;enumeration value="2013-05-24 22:10:00"/>
 *             &lt;enumeration value="2013-05-25 00:15:00"/>
 *             &lt;enumeration value="2013-05-25 06:00:00"/>
 *             &lt;enumeration value="2013-05-25 07:00:00"/>
 *             &lt;enumeration value="2013-05-25 07:30:00"/>
 *             &lt;enumeration value="2013-05-25 09:00:00"/>
 *             &lt;enumeration value="2013-05-25 11:00:00"/>
 *             &lt;enumeration value="2013-05-25 12:00:00"/>
 *             &lt;enumeration value="2013-05-25 13:00:00"/>
 *             &lt;enumeration value="2013-05-25 14:00:00"/>
 *             &lt;enumeration value="2013-05-25 14:30:00"/>
 *             &lt;enumeration value="2013-05-25 15:00:00"/>
 *             &lt;enumeration value="2013-05-25 16:45:00"/>
 *             &lt;enumeration value="2013-05-25 17:00:00"/>
 *             &lt;enumeration value="2013-05-25 18:00:00"/>
 *             &lt;enumeration value="2013-05-25 19:00:00"/>
 *             &lt;enumeration value="2013-05-25 19:45:00"/>
 *             &lt;enumeration value="2013-05-25 22:30:00"/>
 *             &lt;enumeration value="2013-05-26 01:00:00"/>
 *             &lt;enumeration value="2013-05-26 05:00:00"/>
 *             &lt;enumeration value="2013-05-26 08:00:00"/>
 *             &lt;enumeration value="2013-05-26 10:30:00"/>
 *             &lt;enumeration value="2013-05-26 11:00:00"/>
 *             &lt;enumeration value="2013-05-26 11:30:00"/>
 *             &lt;enumeration value="2013-05-26 12:00:00"/>
 *             &lt;enumeration value="2013-05-26 12:45:00"/>
 *             &lt;enumeration value="2013-05-26 14:30:00"/>
 *             &lt;enumeration value="2013-05-26 15:00:00"/>
 *             &lt;enumeration value="2013-05-26 15:15:00"/>
 *             &lt;enumeration value="2013-05-26 16:00:00"/>
 *             &lt;enumeration value="2013-05-26 17:00:00"/>
 *             &lt;enumeration value="2013-05-26 17:15:00"/>
 *             &lt;enumeration value="2013-05-26 17:45:00"/>
 *             &lt;enumeration value="2013-05-26 18:00:00"/>
 *             &lt;enumeration value="2013-05-26 18:10:00"/>
 *             &lt;enumeration value="2013-05-26 19:00:00"/>
 *             &lt;enumeration value="2013-05-26 19:30:00"/>
 *             &lt;enumeration value="2013-05-26 20:00:00"/>
 *             &lt;enumeration value="2013-05-26 20:30:00"/>
 *             &lt;enumeration value="2013-05-26 22:10:00"/>
 *             &lt;enumeration value="2013-05-26 22:30:00"/>
 *             &lt;enumeration value="2013-05-27 01:30:00"/>
 *             &lt;enumeration value="2013-05-27 15:00:00"/>
 *             &lt;enumeration value="2013-05-27 20:00:00"/>
 *             &lt;enumeration value="2013-05-27 22:10:00"/>
 *             &lt;enumeration value="2013-05-28 00:15:00"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="racetype" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="handicap" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=" "/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="going" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ev_minbet" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="0.01"/>
 *             &lt;enumeration value="0.1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ev_maxbet" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="1000.0"/>
 *             &lt;enumeration value="100000.0"/>
 *             &lt;enumeration value="2000.0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ev_id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;enumeration value="3947738"/>
 *             &lt;enumeration value="3954782"/>
 *             &lt;enumeration value="3957483"/>
 *             &lt;enumeration value="3957484"/>
 *             &lt;enumeration value="3957569"/>
 *             &lt;enumeration value="3957573"/>
 *             &lt;enumeration value="3957578"/>
 *             &lt;enumeration value="3957580"/>
 *             &lt;enumeration value="3957583"/>
 *             &lt;enumeration value="3957723"/>
 *             &lt;enumeration value="3957724"/>
 *             &lt;enumeration value="3957725"/>
 *             &lt;enumeration value="3957726"/>
 *             &lt;enumeration value="3957727"/>
 *             &lt;enumeration value="3957728"/>
 *             &lt;enumeration value="3957729"/>
 *             &lt;enumeration value="3957730"/>
 *             &lt;enumeration value="3957731"/>
 *             &lt;enumeration value="3957732"/>
 *             &lt;enumeration value="3957748"/>
 *             &lt;enumeration value="3957749"/>
 *             &lt;enumeration value="3957766"/>
 *             &lt;enumeration value="3957767"/>
 *             &lt;enumeration value="3957785"/>
 *             &lt;enumeration value="3957786"/>
 *             &lt;enumeration value="3957787"/>
 *             &lt;enumeration value="3957788"/>
 *             &lt;enumeration value="3957789"/>
 *             &lt;enumeration value="3957793"/>
 *             &lt;enumeration value="3957794"/>
 *             &lt;enumeration value="3957795"/>
 *             &lt;enumeration value="3957796"/>
 *             &lt;enumeration value="3957797"/>
 *             &lt;enumeration value="3957808"/>
 *             &lt;enumeration value="3957894"/>
 *             &lt;enumeration value="3957895"/>
 *             &lt;enumeration value="3957936"/>
 *             &lt;enumeration value="3957937"/>
 *             &lt;enumeration value="3957938"/>
 *             &lt;enumeration value="3957939"/>
 *             &lt;enumeration value="3957940"/>
 *             &lt;enumeration value="3957941"/>
 *             &lt;enumeration value="3957942"/>
 *             &lt;enumeration value="3957943"/>
 *             &lt;enumeration value="3957944"/>
 *             &lt;enumeration value="3957945"/>
 *             &lt;enumeration value="3957981"/>
 *             &lt;enumeration value="3958179"/>
 *             &lt;enumeration value="3958223"/>
 *             &lt;enumeration value="3958224"/>
 *             &lt;enumeration value="3958225"/>
 *             &lt;enumeration value="3958402"/>
 *             &lt;enumeration value="3958403"/>
 *             &lt;enumeration value="3958404"/>
 *             &lt;enumeration value="3958405"/>
 *             &lt;enumeration value="3958406"/>
 *             &lt;enumeration value="3958407"/>
 *             &lt;enumeration value="3958408"/>
 *             &lt;enumeration value="3958409"/>
 *             &lt;enumeration value="3958410"/>
 *             &lt;enumeration value="3958411"/>
 *             &lt;enumeration value="3958483"/>
 *             &lt;enumeration value="3958497"/>
 *             &lt;enumeration value="3958498"/>
 *             &lt;enumeration value="3958499"/>
 *             &lt;enumeration value="3958500"/>
 *             &lt;enumeration value="3958501"/>
 *             &lt;enumeration value="3958502"/>
 *             &lt;enumeration value="3958515"/>
 *             &lt;enumeration value="3958516"/>
 *             &lt;enumeration value="3958517"/>
 *             &lt;enumeration value="3958518"/>
 *             &lt;enumeration value="3958663"/>
 *             &lt;enumeration value="3958664"/>
 *             &lt;enumeration value="3958665"/>
 *             &lt;enumeration value="3958666"/>
 *             &lt;enumeration value="3958667"/>
 *             &lt;enumeration value="3958670"/>
 *             &lt;enumeration value="3958671"/>
 *             &lt;enumeration value="3958672"/>
 *             &lt;enumeration value="3958673"/>
 *             &lt;enumeration value="3958674"/>
 *             &lt;enumeration value="3958675"/>
 *             &lt;enumeration value="3958676"/>
 *             &lt;enumeration value="3958677"/>
 *             &lt;enumeration value="3958678"/>
 *             &lt;enumeration value="3958679"/>
 *             &lt;enumeration value="3958680"/>
 *             &lt;enumeration value="3958681"/>
 *             &lt;enumeration value="3958682"/>
 *             &lt;enumeration value="3958683"/>
 *             &lt;enumeration value="3958684"/>
 *             &lt;enumeration value="3958685"/>
 *             &lt;enumeration value="3958686"/>
 *             &lt;enumeration value="3958687"/>
 *             &lt;enumeration value="3958688"/>
 *             &lt;enumeration value="3958689"/>
 *             &lt;enumeration value="3958690"/>
 *             &lt;enumeration value="3958691"/>
 *             &lt;enumeration value="3958692"/>
 *             &lt;enumeration value="3958693"/>
 *             &lt;enumeration value="3958694"/>
 *             &lt;enumeration value="3958695"/>
 *             &lt;enumeration value="3958696"/>
 *             &lt;enumeration value="3958697"/>
 *             &lt;enumeration value="3958702"/>
 *             &lt;enumeration value="3958703"/>
 *             &lt;enumeration value="3958704"/>
 *             &lt;enumeration value="3958707"/>
 *             &lt;enumeration value="3958722"/>
 *             &lt;enumeration value="3958723"/>
 *             &lt;enumeration value="3958726"/>
 *             &lt;enumeration value="3958727"/>
 *             &lt;enumeration value="3958729"/>
 *             &lt;enumeration value="3958730"/>
 *             &lt;enumeration value="3958731"/>
 *             &lt;enumeration value="3958733"/>
 *             &lt;enumeration value="3958735"/>
 *             &lt;enumeration value="3958736"/>
 *             &lt;enumeration value="3958737"/>
 *             &lt;enumeration value="3958738"/>
 *             &lt;enumeration value="3958739"/>
 *             &lt;enumeration value="3958740"/>
 *             &lt;enumeration value="3958741"/>
 *             &lt;enumeration value="3958742"/>
 *             &lt;enumeration value="3958743"/>
 *             &lt;enumeration value="3958747"/>
 *             &lt;enumeration value="3958748"/>
 *             &lt;enumeration value="3958755"/>
 *             &lt;enumeration value="3958756"/>
 *             &lt;enumeration value="3958757"/>
 *             &lt;enumeration value="3958758"/>
 *             &lt;enumeration value="3958759"/>
 *             &lt;enumeration value="3958760"/>
 *             &lt;enumeration value="3958761"/>
 *             &lt;enumeration value="3958762"/>
 *             &lt;enumeration value="3958763"/>
 *             &lt;enumeration value="3958764"/>
 *             &lt;enumeration value="3958765"/>
 *             &lt;enumeration value="3958766"/>
 *             &lt;enumeration value="3958773"/>
 *             &lt;enumeration value="3958774"/>
 *             &lt;enumeration value="3958775"/>
 *             &lt;enumeration value="3958779"/>
 *             &lt;enumeration value="3958781"/>
 *             &lt;enumeration value="3958782"/>
 *             &lt;enumeration value="3958783"/>
 *             &lt;enumeration value="3958784"/>
 *             &lt;enumeration value="3958787"/>
 *             &lt;enumeration value="3958788"/>
 *             &lt;enumeration value="3958789"/>
 *             &lt;enumeration value="3958790"/>
 *             &lt;enumeration value="3958791"/>
 *             &lt;enumeration value="3958792"/>
 *             &lt;enumeration value="3958793"/>
 *             &lt;enumeration value="3958794"/>
 *             &lt;enumeration value="3958795"/>
 *             &lt;enumeration value="3958796"/>
 *             &lt;enumeration value="3958797"/>
 *             &lt;enumeration value="3958798"/>
 *             &lt;enumeration value="3958799"/>
 *             &lt;enumeration value="3958800"/>
 *             &lt;enumeration value="3958801"/>
 *             &lt;enumeration value="3958802"/>
 *             &lt;enumeration value="3958820"/>
 *             &lt;enumeration value="3958821"/>
 *             &lt;enumeration value="3958822"/>
 *             &lt;enumeration value="3958824"/>
 *             &lt;enumeration value="3958825"/>
 *             &lt;enumeration value="3958826"/>
 *             &lt;enumeration value="3958827"/>
 *             &lt;enumeration value="3958907"/>
 *             &lt;enumeration value="3958908"/>
 *             &lt;enumeration value="3958909"/>
 *             &lt;enumeration value="3958910"/>
 *             &lt;enumeration value="3958911"/>
 *             &lt;enumeration value="3958912"/>
 *             &lt;enumeration value="3958913"/>
 *             &lt;enumeration value="3958914"/>
 *             &lt;enumeration value="3958915"/>
 *             &lt;enumeration value="3958916"/>
 *             &lt;enumeration value="3958917"/>
 *             &lt;enumeration value="3958918"/>
 *             &lt;enumeration value="3958919"/>
 *             &lt;enumeration value="3958930"/>
 *             &lt;enumeration value="3958931"/>
 *             &lt;enumeration value="3958945"/>
 *             &lt;enumeration value="3958946"/>
 *             &lt;enumeration value="3958957"/>
 *             &lt;enumeration value="3958958"/>
 *             &lt;enumeration value="3958978"/>
 *             &lt;enumeration value="3958979"/>
 *             &lt;enumeration value="3958980"/>
 *             &lt;enumeration value="3958981"/>
 *             &lt;enumeration value="3958982"/>
 *             &lt;enumeration value="3959027"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="eligibility" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="distance" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=""/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="class" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="0"/>
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
    "description",
    "market"
})
@XmlRootElement(name = "Event")
public class Event {

    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Market", required = true)
    protected List<Market> market;
    @XmlAttribute(name = "trifecta", required = true)
    protected String trifecta;
    @XmlAttribute(name = "tracktype", required = true)
    protected String tracktype;
    @XmlAttribute(name = "start_time", required = true)
    protected String startTime;
    @XmlAttribute(name = "racetype", required = true)
    protected String racetype;
    @XmlAttribute(name = "handicap", required = true)
    protected String handicap;
    @XmlAttribute(name = "going", required = true)
    protected byte going;
    @XmlAttribute(name = "ev_minbet", required = true)
    protected BigDecimal evMinbet;
    @XmlAttribute(name = "ev_maxbet", required = true)
    protected BigDecimal evMaxbet;
    @XmlAttribute(name = "ev_id", required = true)
    protected int evId;
    @XmlAttribute(name = "eligibility", required = true)
    protected String eligibility;
    @XmlAttribute(name = "distance", required = true)
    protected String distance;
    @XmlAttribute(name = "class", required = true)
    protected byte clazz;

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the market property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the market property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarket().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Market }
     * 
     * 
     */
    public List<Market> getMarket() {
        if (market == null) {
            market = new ArrayList<Market>();
        }
        return this.market;
    }

    /**
     * Obtiene el valor de la propiedad trifecta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrifecta() {
        return trifecta;
    }

    /**
     * Define el valor de la propiedad trifecta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrifecta(String value) {
        this.trifecta = value;
    }

    /**
     * Obtiene el valor de la propiedad tracktype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTracktype() {
        return tracktype;
    }

    /**
     * Define el valor de la propiedad tracktype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTracktype(String value) {
        this.tracktype = value;
    }

    /**
     * Obtiene el valor de la propiedad startTime.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Define el valor de la propiedad startTime.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * Obtiene el valor de la propiedad racetype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRacetype() {
        return racetype;
    }

    /**
     * Define el valor de la propiedad racetype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRacetype(String value) {
        this.racetype = value;
    }

    /**
     * Obtiene el valor de la propiedad handicap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandicap() {
        return handicap;
    }

    /**
     * Define el valor de la propiedad handicap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandicap(String value) {
        this.handicap = value;
    }

    /**
     * Obtiene el valor de la propiedad going.
     * 
     */
    public byte getGoing() {
        return going;
    }

    /**
     * Define el valor de la propiedad going.
     * 
     */
    public void setGoing(byte value) {
        this.going = value;
    }

    /**
     * Obtiene el valor de la propiedad evMinbet.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEvMinbet() {
        return evMinbet;
    }

    /**
     * Define el valor de la propiedad evMinbet.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEvMinbet(BigDecimal value) {
        this.evMinbet = value;
    }

    /**
     * Obtiene el valor de la propiedad evMaxbet.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getEvMaxbet() {
        return evMaxbet;
    }

    /**
     * Define el valor de la propiedad evMaxbet.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setEvMaxbet(BigDecimal value) {
        this.evMaxbet = value;
    }

    /**
     * Obtiene el valor de la propiedad evId.
     * 
     */
    public int getEvId() {
        return evId;
    }

    /**
     * Define el valor de la propiedad evId.
     * 
     */
    public void setEvId(int value) {
        this.evId = value;
    }

    /**
     * Obtiene el valor de la propiedad eligibility.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEligibility() {
        return eligibility;
    }

    /**
     * Define el valor de la propiedad eligibility.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEligibility(String value) {
        this.eligibility = value;
    }

    /**
     * Obtiene el valor de la propiedad distance.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistance() {
        return distance;
    }

    /**
     * Define el valor de la propiedad distance.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistance(String value) {
        this.distance = value;
    }

    /**
     * Obtiene el valor de la propiedad clazz.
     * 
     */
    public byte getClazz() {
        return clazz;
    }

    /**
     * Define el valor de la propiedad clazz.
     * 
     */
    public void setClazz(byte value) {
        this.clazz = value;
    }

}
