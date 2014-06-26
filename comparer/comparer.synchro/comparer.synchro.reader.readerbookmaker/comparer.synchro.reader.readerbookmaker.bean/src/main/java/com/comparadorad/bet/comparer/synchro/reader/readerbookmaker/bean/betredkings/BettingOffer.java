//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.03 a las 04:13:49 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betredkings;

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
 *         &lt;element ref="{}Odds" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="typeId" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;enumeration value="11"/>
 *             &lt;enumeration value="113"/>
 *             &lt;enumeration value="114"/>
 *             &lt;enumeration value="115"/>
 *             &lt;enumeration value="139"/>
 *             &lt;enumeration value="149"/>
 *             &lt;enumeration value="152"/>
 *             &lt;enumeration value="163"/>
 *             &lt;enumeration value="32"/>
 *             &lt;enumeration value="33"/>
 *             &lt;enumeration value="35"/>
 *             &lt;enumeration value="43"/>
 *             &lt;enumeration value="45"/>
 *             &lt;enumeration value="46"/>
 *             &lt;enumeration value="47"/>
 *             &lt;enumeration value="48"/>
 *             &lt;enumeration value="503"/>
 *             &lt;enumeration value="507"/>
 *             &lt;enumeration value="7"/>
 *             &lt;enumeration value="75"/>
 *             &lt;enumeration value="77"/>
 *             &lt;enumeration value="79"/>
 *             &lt;enumeration value="8"/>
 *             &lt;enumeration value="9"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Asian Handicap"/>
 *             &lt;enumeration value="Correct Score"/>
 *             &lt;enumeration value="Double Chance"/>
 *             &lt;enumeration value="Goal/No Goal"/>
 *             &lt;enumeration value="Half Time - Full Time"/>
 *             &lt;enumeration value="Home Away With Impossible Draw"/>
 *             &lt;enumeration value="Home Draw Away"/>
 *             &lt;enumeration value="Home Draw Away With Handicap"/>
 *             &lt;enumeration value="Next Goal"/>
 *             &lt;enumeration value="Odd Or Even"/>
 *             &lt;enumeration value="Over Under"/>
 *             &lt;enumeration value="Unexpected type"/>
 *             &lt;enumeration value="Winner"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="scopeId" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="0"/>
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="3"/>
 *             &lt;enumeration value="4"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="scope" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="First half"/>
 *             &lt;enumeration value="Full event"/>
 *             &lt;enumeration value="Full time excluding overtime"/>
 *             &lt;enumeration value="Second half"/>
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
    "odds"
})
@XmlRootElement(name = "BettingOffer")
public class BettingOffer {

    @XmlElement(name = "Odds", required = true)
    protected List<Odds> odds;
    @XmlAttribute(name = "typeId", required = true)
    protected short typeId;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "scopeId", required = true)
    protected byte scopeId;
    @XmlAttribute(name = "scope", required = true)
    protected String scope;

    /**
     * Gets the value of the odds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the odds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOdds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Odds }
     * 
     * 
     */
    public List<Odds> getOdds() {
        if (odds == null) {
            odds = new ArrayList<Odds>();
        }
        return this.odds;
    }

    /**
     * Obtiene el valor de la propiedad typeId.
     * 
     */
    public short getTypeId() {
        return typeId;
    }

    /**
     * Define el valor de la propiedad typeId.
     * 
     */
    public void setTypeId(short value) {
        this.typeId = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad scopeId.
     * 
     */
    public byte getScopeId() {
        return scopeId;
    }

    /**
     * Define el valor de la propiedad scopeId.
     * 
     */
    public void setScopeId(byte value) {
        this.scopeId = value;
    }

    /**
     * Obtiene el valor de la propiedad scope.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScope() {
        return scope;
    }

    /**
     * Define el valor de la propiedad scope.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScope(String value) {
        this.scope = value;
    }

}
