//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.06.04 a las 11:54:25 AM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{}BET" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="START_TIME" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *             &lt;enumeration value="2013-06-04T01:05:00"/>
 *             &lt;enumeration value="2013-06-04T01:10:00"/>
 *             &lt;enumeration value="2013-06-04T02:10:00"/>
 *             &lt;enumeration value="2013-06-04T02:15:00"/>
 *             &lt;enumeration value="2013-06-04T04:05:00"/>
 *             &lt;enumeration value="2013-06-04T04:10:00"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="OPEN_TILL" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime">
 *             &lt;enumeration value="2013-06-04T01:05:00"/>
 *             &lt;enumeration value="2013-06-04T01:10:00"/>
 *             &lt;enumeration value="2013-06-04T02:10:00"/>
 *             &lt;enumeration value="2013-06-04T02:15:00"/>
 *             &lt;enumeration value="2013-06-04T04:05:00"/>
 *             &lt;enumeration value="2013-06-04T04:10:00"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NAME" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Atlanta Braves - Pittsburgh Pirates"/>
 *             &lt;enumeration value="Cincinnati Reds - Colorado Rockies"/>
 *             &lt;enumeration value="LA Angels - Houston Astros"/>
 *             &lt;enumeration value="LA Dodgers - San Diego Padres"/>
 *             &lt;enumeration value="Milwaukee Brewers - Oakland Athletics"/>
 *             &lt;enumeration value="New York Yankees - Cleveland Indians"/>
 *             &lt;enumeration value="Philadelphia Phillies - Miami Marlins"/>
 *             &lt;enumeration value="Seattle Mariners - Chicago White Sox"/>
 *             &lt;enumeration value="St Louis Cardinals - Arizona Diamondbacks"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="EVENTID" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;enumeration value="9797124"/>
 *             &lt;enumeration value="9797125"/>
 *             &lt;enumeration value="9797126"/>
 *             &lt;enumeration value="9797127"/>
 *             &lt;enumeration value="9797128"/>
 *             &lt;enumeration value="9797129"/>
 *             &lt;enumeration value="9797132"/>
 *             &lt;enumeration value="9797133"/>
 *             &lt;enumeration value="9797134"/>
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
    "bet"
})
@XmlRootElement(name = "EVENT")
public class EVENT {

    @XmlElement(name = "BET", required = true)
    protected List<BET> bet;
    @XmlAttribute(name = "START_TIME", required = true)
    protected XMLGregorianCalendar starttime;
    @XmlAttribute(name = "OPEN_TILL", required = true)
    protected XMLGregorianCalendar opentill;
    @XmlAttribute(name = "NAME", required = true)
    protected String name;
    @XmlAttribute(name = "EVENTID", required = true)
    protected int eventid;

    /**
     * Gets the value of the bet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBET().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BET }
     * 
     * 
     */
    public List<BET> getBET() {
        if (bet == null) {
            bet = new ArrayList<BET>();
        }
        return this.bet;
    }

    /**
     * Obtiene el valor de la propiedad starttime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSTARTTIME() {
        return starttime;
    }

    /**
     * Define el valor de la propiedad starttime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSTARTTIME(XMLGregorianCalendar value) {
        this.starttime = value;
    }

    /**
     * Obtiene el valor de la propiedad opentill.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOPENTILL() {
        return opentill;
    }

    /**
     * Define el valor de la propiedad opentill.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOPENTILL(XMLGregorianCalendar value) {
        this.opentill = value;
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

    /**
     * Obtiene el valor de la propiedad eventid.
     * 
     */
    public int getEVENTID() {
        return eventid;
    }

    /**
     * Define el valor de la propiedad eventid.
     * 
     */
    public void setEVENTID(int value) {
        this.eventid = value;
    }

}
