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
 *         &lt;element ref="{}Title"/>
 *         &lt;element ref="{}Event" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type_minbet" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="0.0"/>
 *             &lt;enumeration value="0.1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="type_maxbet" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="0.0"/>
 *             &lt;enumeration value="1000.0"/>
 *             &lt;enumeration value="2000.0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="type_id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;enumeration value="4220"/>
 *             &lt;enumeration value="4232"/>
 *             &lt;enumeration value="4257"/>
 *             &lt;enumeration value="4260"/>
 *             &lt;enumeration value="4262"/>
 *             &lt;enumeration value="4264"/>
 *             &lt;enumeration value="4269"/>
 *             &lt;enumeration value="4276"/>
 *             &lt;enumeration value="4282"/>
 *             &lt;enumeration value="4285"/>
 *             &lt;enumeration value="4286"/>
 *             &lt;enumeration value="4288"/>
 *             &lt;enumeration value="4289"/>
 *             &lt;enumeration value="4297"/>
 *             &lt;enumeration value="4302"/>
 *             &lt;enumeration value="4304"/>
 *             &lt;enumeration value="4307"/>
 *             &lt;enumeration value="4311"/>
 *             &lt;enumeration value="4320"/>
 *             &lt;enumeration value="4324"/>
 *             &lt;enumeration value="4327"/>
 *             &lt;enumeration value="4330"/>
 *             &lt;enumeration value="4438"/>
 *             &lt;enumeration value="4439"/>
 *             &lt;enumeration value="4446"/>
 *             &lt;enumeration value="4524"/>
 *             &lt;enumeration value="4562"/>
 *             &lt;enumeration value="4621"/>
 *             &lt;enumeration value="4741"/>
 *             &lt;enumeration value="4743"/>
 *             &lt;enumeration value="4818"/>
 *             &lt;enumeration value="5433"/>
 *             &lt;enumeration value="5542"/>
 *             &lt;enumeration value="5601"/>
 *             &lt;enumeration value="5650"/>
 *             &lt;enumeration value="5804"/>
 *             &lt;enumeration value="5856"/>
 *             &lt;enumeration value="6026"/>
 *             &lt;enumeration value="6158"/>
 *             &lt;enumeration value="6187"/>
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
    "title",
    "event"
})
@XmlRootElement(name = "Type")
public class Type {

    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "Event", required = true)
    protected List<Event> event;
    @XmlAttribute(name = "type_minbet", required = true)
    protected BigDecimal typeMinbet;
    @XmlAttribute(name = "type_maxbet", required = true)
    protected BigDecimal typeMaxbet;
    @XmlAttribute(name = "type_id", required = true)
    protected short typeId;

    /**
     * Obtiene el valor de la propiedad title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Define el valor de la propiedad title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the event property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Event }
     * 
     * 
     */
    public List<Event> getEvent() {
        if (event == null) {
            event = new ArrayList<Event>();
        }
        return this.event;
    }

    /**
     * Obtiene el valor de la propiedad typeMinbet.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTypeMinbet() {
        return typeMinbet;
    }

    /**
     * Define el valor de la propiedad typeMinbet.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTypeMinbet(BigDecimal value) {
        this.typeMinbet = value;
    }

    /**
     * Obtiene el valor de la propiedad typeMaxbet.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTypeMaxbet() {
        return typeMaxbet;
    }

    /**
     * Define el valor de la propiedad typeMaxbet.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTypeMaxbet(BigDecimal value) {
        this.typeMaxbet = value;
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

}
