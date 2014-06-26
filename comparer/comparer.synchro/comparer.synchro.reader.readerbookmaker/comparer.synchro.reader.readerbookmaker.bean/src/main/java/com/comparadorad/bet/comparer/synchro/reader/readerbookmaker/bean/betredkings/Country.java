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
 *         &lt;element ref="{}Tournament" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="AA"/>
 *             &lt;enumeration value="AA2"/>
 *             &lt;enumeration value="AR"/>
 *             &lt;enumeration value="BR"/>
 *             &lt;enumeration value="CO"/>
 *             &lt;enumeration value="CZ"/>
 *             &lt;enumeration value="DE"/>
 *             &lt;enumeration value="DK"/>
 *             &lt;enumeration value="EU"/>
 *             &lt;enumeration value="FI"/>
 *             &lt;enumeration value="GB1"/>
 *             &lt;enumeration value="ID"/>
 *             &lt;enumeration value="IE"/>
 *             &lt;enumeration value="IS"/>
 *             &lt;enumeration value="JP"/>
 *             &lt;enumeration value="LT"/>
 *             &lt;enumeration value="NO"/>
 *             &lt;enumeration value="PE"/>
 *             &lt;enumeration value="RU"/>
 *             &lt;enumeration value="SE"/>
 *             &lt;enumeration value="SU"/>
 *             &lt;enumeration value="US"/>
 *             &lt;enumeration value="WO"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="10008"/>
 *             &lt;enumeration value="103"/>
 *             &lt;enumeration value="104"/>
 *             &lt;enumeration value="110"/>
 *             &lt;enumeration value="114"/>
 *             &lt;enumeration value="12"/>
 *             &lt;enumeration value="133"/>
 *             &lt;enumeration value="165"/>
 *             &lt;enumeration value="173"/>
 *             &lt;enumeration value="188"/>
 *             &lt;enumeration value="194"/>
 *             &lt;enumeration value="229"/>
 *             &lt;enumeration value="240"/>
 *             &lt;enumeration value="253"/>
 *             &lt;enumeration value="30"/>
 *             &lt;enumeration value="47"/>
 *             &lt;enumeration value="53"/>
 *             &lt;enumeration value="54"/>
 *             &lt;enumeration value="56"/>
 *             &lt;enumeration value="67"/>
 *             &lt;enumeration value="68"/>
 *             &lt;enumeration value="77"/>
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
    "tournament"
})
@XmlRootElement(name = "Country")
public class Country {

    @XmlElement(name = "Tournament", required = true)
    protected List<Tournament> tournament;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected short id;

    /**
     * Gets the value of the tournament property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tournament property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTournament().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Tournament }
     * 
     * 
     */
    public List<Tournament> getTournament() {
        if (tournament == null) {
            tournament = new ArrayList<Tournament>();
        }
        return this.tournament;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
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
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public short getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(short value) {
        this.id = value;
    }

}
