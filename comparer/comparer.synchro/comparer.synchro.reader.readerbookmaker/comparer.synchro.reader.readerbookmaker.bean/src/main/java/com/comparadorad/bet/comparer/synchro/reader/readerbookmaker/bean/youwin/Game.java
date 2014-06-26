//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.02.26 a las 12:12:17 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin;

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
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}type"/>
 *         &lt;element ref="{}alternatives"/>
 *       &lt;/sequence>
 *       &lt;attribute name="time" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="date" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
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
    "type",
    "alternatives"
})
@XmlRootElement(name = "game")
public class Game {

    @XmlElement(required = true)
    protected Description description;
    @XmlElement(required = true)
    protected Type type;
    @XmlElement(required = true)
    protected Alternatives alternatives;
    @XmlAttribute(name = "time", required = true)
    protected short time;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "date", required = true)
    protected int date;

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link Description }
     *     
     */
    public Description getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link Description }
     *     
     */
    public void setDescription(Description value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad alternatives.
     * 
     * @return
     *     possible object is
     *     {@link Alternatives }
     *     
     */
    public Alternatives getAlternatives() {
        return alternatives;
    }

    /**
     * Define el valor de la propiedad alternatives.
     * 
     * @param value
     *     allowed object is
     *     {@link Alternatives }
     *     
     */
    public void setAlternatives(Alternatives value) {
        this.alternatives = value;
    }

    /**
     * Obtiene el valor de la propiedad time.
     * 
     */
    public short getTime() {
        return time;
    }

    /**
     * Define el valor de la propiedad time.
     * 
     */
    public void setTime(short value) {
        this.time = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad date.
     * 
     */
    public int getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     */
    public void setDate(int value) {
        this.date = value;
    }

}
