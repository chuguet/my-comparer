//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: PM.12.13 a las 02:36:37 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.intertops;

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
 *         &lt;element ref="{}t" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="rot" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="n" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="m" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dt" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "t"
})
@XmlRootElement(name = "m")
public class M {

    @XmlElement(required = true)
    protected List<T> t;
    @XmlAttribute(name = "rot")
    protected String rot;
    @XmlAttribute(name = "n", required = true)
    protected String n;
    @XmlAttribute(name = "mid")
    protected String mid;
    @XmlAttribute(name = "m")
    protected String m;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "dt", required = true)
    protected String dt;

    /**
     * Gets the value of the t property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the t property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link T }
     * 
     * 
     */
    public List<T> getT() {
        if (t == null) {
            t = new ArrayList<T>();
        }
        return this.t;
    }

    /**
     * Obtiene el valor de la propiedad rot.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRot() {
        return rot;
    }

    /**
     * Define el valor de la propiedad rot.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRot(String value) {
        this.rot = value;
    }

    /**
     * Obtiene el valor de la propiedad n.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getN() {
        return n;
    }

    /**
     * Define el valor de la propiedad n.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setN(String value) {
        this.n = value;
    }

    /**
     * Obtiene el valor de la propiedad mid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMid() {
        return mid;
    }

    /**
     * Define el valor de la propiedad mid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMid(String value) {
        this.mid = value;
    }

    /**
     * Obtiene el valor de la propiedad m.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getM() {
        return m;
    }

    /**
     * Define el valor de la propiedad m.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setM(String value) {
        this.m = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad dt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDt() {
        return dt;
    }

    /**
     * Define el valor de la propiedad dt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDt(String value) {
        this.dt = value;
    }

}
