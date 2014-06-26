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
 *       &lt;attribute name="TYPENAME" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Handicap USA 1,5"/>
 *             &lt;enumeration value="Match"/>
 *             &lt;enumeration value="Over/Under USA"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="TYPEID" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="13"/>
 *             &lt;enumeration value="88"/>
 *             &lt;enumeration value="92"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="TIP" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value=" "/>
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="QUOTE" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="1,45"/>
 *             &lt;enumeration value="1,50"/>
 *             &lt;enumeration value="1,55"/>
 *             &lt;enumeration value="1,60"/>
 *             &lt;enumeration value="1,65"/>
 *             &lt;enumeration value="1,70"/>
 *             &lt;enumeration value="1,75"/>
 *             &lt;enumeration value="1,80"/>
 *             &lt;enumeration value="1,85"/>
 *             &lt;enumeration value="1,90"/>
 *             &lt;enumeration value="1,95"/>
 *             &lt;enumeration value="2,00"/>
 *             &lt;enumeration value="2,05"/>
 *             &lt;enumeration value="2,10"/>
 *             &lt;enumeration value="2,15"/>
 *             &lt;enumeration value="2,25"/>
 *             &lt;enumeration value="2,35"/>
 *             &lt;enumeration value="2,50"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="PLAYER2" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Arizona Diamondbacks"/>
 *             &lt;enumeration value="Arizona Diamondbacks(+1,5)"/>
 *             &lt;enumeration value="Chicago White Sox"/>
 *             &lt;enumeration value="Chicago White Sox(+1,5)"/>
 *             &lt;enumeration value="Cleveland Indians"/>
 *             &lt;enumeration value="Cleveland Indians(+1,5)"/>
 *             &lt;enumeration value="Colorado Rockies"/>
 *             &lt;enumeration value="Colorado Rockies(+1,5)"/>
 *             &lt;enumeration value="Houston Astros"/>
 *             &lt;enumeration value="Houston Astros(+1,5)"/>
 *             &lt;enumeration value="Miami Marlins"/>
 *             &lt;enumeration value="Miami Marlins(+1,5)"/>
 *             &lt;enumeration value="Oakland Athletics"/>
 *             &lt;enumeration value="Oakland Athletics(+1,5)"/>
 *             &lt;enumeration value="Over 7.5"/>
 *             &lt;enumeration value="Over 8.5"/>
 *             &lt;enumeration value="Pittsburgh Pirates"/>
 *             &lt;enumeration value="San Diego Padres"/>
 *             &lt;enumeration value="San Diego Padres(+1,5)"/>
 *             &lt;enumeration value="Under 7.5"/>
 *             &lt;enumeration value="Under 8.5"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="PLAYER1" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Atlanta Braves "/>
 *             &lt;enumeration value="Atlanta Braves - Pittsburgh Pirates"/>
 *             &lt;enumeration value="Cincinnati Reds "/>
 *             &lt;enumeration value="Cincinnati Reds - Colorado Rockies"/>
 *             &lt;enumeration value="Cincinnati Reds(-1,5) "/>
 *             &lt;enumeration value="LA Angels "/>
 *             &lt;enumeration value="LA Angels - Houston Astros"/>
 *             &lt;enumeration value="LA Angels(-1,5) "/>
 *             &lt;enumeration value="LA Dodgers "/>
 *             &lt;enumeration value="LA Dodgers - San Diego Padres"/>
 *             &lt;enumeration value="LA Dodgers(-1,5) "/>
 *             &lt;enumeration value="Milwaukee Brewers "/>
 *             &lt;enumeration value="Milwaukee Brewers - Oakland Athletics"/>
 *             &lt;enumeration value="Milwaukee Brewers(-1,5) "/>
 *             &lt;enumeration value="New York Yankees "/>
 *             &lt;enumeration value="New York Yankees - Cleveland Indians"/>
 *             &lt;enumeration value="New York Yankees(-1,5) "/>
 *             &lt;enumeration value="Philadelphia Phillies "/>
 *             &lt;enumeration value="Philadelphia Phillies - Miami Marlins"/>
 *             &lt;enumeration value="Philadelphia Phillies(-1,5) "/>
 *             &lt;enumeration value="Seattle Mariners "/>
 *             &lt;enumeration value="Seattle Mariners - Chicago White Sox"/>
 *             &lt;enumeration value="Seattle Mariners(-1,5) "/>
 *             &lt;enumeration value="St Louis Cardinals "/>
 *             &lt;enumeration value="St Louis Cardinals - Arizona Diamondbacks"/>
 *             &lt;enumeration value="St Louis Cardinals(-1,5) "/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ID" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;enumeration value="27747925"/>
 *             &lt;enumeration value="27747926"/>
 *             &lt;enumeration value="27747927"/>
 *             &lt;enumeration value="27747928"/>
 *             &lt;enumeration value="27747929"/>
 *             &lt;enumeration value="27747930"/>
 *             &lt;enumeration value="27747931"/>
 *             &lt;enumeration value="27747932"/>
 *             &lt;enumeration value="27747933"/>
 *             &lt;enumeration value="27747934"/>
 *             &lt;enumeration value="27747935"/>
 *             &lt;enumeration value="27747936"/>
 *             &lt;enumeration value="27747937"/>
 *             &lt;enumeration value="27747938"/>
 *             &lt;enumeration value="27747939"/>
 *             &lt;enumeration value="27747940"/>
 *             &lt;enumeration value="27747941"/>
 *             &lt;enumeration value="27747942"/>
 *             &lt;enumeration value="27747943"/>
 *             &lt;enumeration value="27747944"/>
 *             &lt;enumeration value="27747945"/>
 *             &lt;enumeration value="27747946"/>
 *             &lt;enumeration value="27747947"/>
 *             &lt;enumeration value="27747948"/>
 *             &lt;enumeration value="27747949"/>
 *             &lt;enumeration value="27747950"/>
 *             &lt;enumeration value="27747951"/>
 *             &lt;enumeration value="27747952"/>
 *             &lt;enumeration value="27747953"/>
 *             &lt;enumeration value="27747954"/>
 *             &lt;enumeration value="27747955"/>
 *             &lt;enumeration value="27747956"/>
 *             &lt;enumeration value="27747957"/>
 *             &lt;enumeration value="27747958"/>
 *             &lt;enumeration value="27747959"/>
 *             &lt;enumeration value="27747960"/>
 *             &lt;enumeration value="27748412"/>
 *             &lt;enumeration value="27748413"/>
 *             &lt;enumeration value="27748414"/>
 *             &lt;enumeration value="27748415"/>
 *             &lt;enumeration value="27748416"/>
 *             &lt;enumeration value="27748417"/>
 *             &lt;enumeration value="27748418"/>
 *             &lt;enumeration value="27748419"/>
 *             &lt;enumeration value="27748420"/>
 *             &lt;enumeration value="27748421"/>
 *             &lt;enumeration value="27748422"/>
 *             &lt;enumeration value="27748423"/>
 *             &lt;enumeration value="27748424"/>
 *             &lt;enumeration value="27748425"/>
 *             &lt;enumeration value="27748426"/>
 *             &lt;enumeration value="27748427"/>
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
@XmlType(name = "")
@XmlRootElement(name = "BET")
public class BET {

    @XmlAttribute(name = "TYPENAME", required = true)
    protected String typename;
    @XmlAttribute(name = "TYPEID", required = true)
    protected String typeid;
    @XmlAttribute(name = "TIP", required = true)
    protected String tip;
    @XmlAttribute(name = "QUOTE", required = true)
    protected String quote;
    @XmlAttribute(name = "PLAYER2", required = true)
    protected String player2;
    @XmlAttribute(name = "PLAYER1", required = true)
    protected String player1;
    @XmlAttribute(name = "ID", required = true)
    protected String id;

    /**
     * Obtiene el valor de la propiedad typename.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYPENAME() {
        return typename;
    }

    /**
     * Define el valor de la propiedad typename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYPENAME(String value) {
        this.typename = value;
    }

    /**
     * Obtiene el valor de la propiedad typeid.
     * 
     */
    public String getTYPEID() {
        return typeid;
    }

    /**
     * Define el valor de la propiedad typeid.
     * 
     */
    public void setTYPEID(String value) {
        this.typeid = value;
    }

    /**
     * Obtiene el valor de la propiedad tip.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIP() {
        return tip;
    }

    /**
     * Define el valor de la propiedad tip.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIP(String value) {
        this.tip = value;
    }

    /**
     * Obtiene el valor de la propiedad quote.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQUOTE() {
        return quote;
    }

    /**
     * Define el valor de la propiedad quote.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQUOTE(String value) {
        this.quote = value;
    }

    /**
     * Obtiene el valor de la propiedad player2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLAYER2() {
        return player2;
    }

    /**
     * Define el valor de la propiedad player2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLAYER2(String value) {
        this.player2 = value;
    }

    /**
     * Obtiene el valor de la propiedad player1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPLAYER1() {
        return player1;
    }

    /**
     * Define el valor de la propiedad player1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPLAYER1(String value) {
        this.player1 = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public String getID() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setID(String value) {
        this.id = value;
    }

}
