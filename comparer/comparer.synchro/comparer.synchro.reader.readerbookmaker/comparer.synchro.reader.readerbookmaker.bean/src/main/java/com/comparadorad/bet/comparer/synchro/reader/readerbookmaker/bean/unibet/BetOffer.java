//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.03.07 a las 04:57:25 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.unibet;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element ref="{http://www.unibet.com/sportsbook-odds-feed}outcome" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="updated_date" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="type_name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="to_be_placed" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="is_live" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="external_description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="criterion_id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="criteria" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="bet_closes" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "outcome"
})
@XmlRootElement(name = "betOffer")
public class BetOffer {

    @XmlElement(required = true)
    protected List<Outcome> outcome;
    @XmlAttribute(name = "updated_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedDate;
    @XmlAttribute(name = "type_name", required = true)
    protected String typeName;
    @XmlAttribute(name = "type", required = true)
    protected byte type;
    @XmlAttribute(name = "to_be_placed")
    protected Byte toBePlaced;
    @XmlAttribute(name = "is_live", required = true)
    protected boolean isLive;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "external_description")
    protected String externalDescription;
    @XmlAttribute(name = "criterion_id", required = true)
    protected int criterionId;
    @XmlAttribute(name = "criteria", required = true)
    protected String criteria;
    @XmlAttribute(name = "bet_closes", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar betCloses;

    /**
     * Gets the value of the outcome property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outcome property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutcome().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Outcome }
     * 
     * 
     */
    public List<Outcome> getOutcome() {
        if (outcome == null) {
            outcome = new ArrayList<Outcome>();
        }
        return this.outcome;
    }

    /**
     * Obtiene el valor de la propiedad updatedDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdatedDate() {
        return updatedDate;
    }

    /**
     * Define el valor de la propiedad updatedDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdatedDate(XMLGregorianCalendar value) {
        this.updatedDate = value;
    }

    /**
     * Obtiene el valor de la propiedad typeName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Define el valor de la propiedad typeName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeName(String value) {
        this.typeName = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     */
    public byte getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     */
    public void setType(byte value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad toBePlaced.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getToBePlaced() {
        return toBePlaced;
    }

    /**
     * Define el valor de la propiedad toBePlaced.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setToBePlaced(Byte value) {
        this.toBePlaced = value;
    }

    /**
     * Obtiene el valor de la propiedad isLive.
     * 
     */
    public boolean isIsLive() {
        return isLive;
    }

    /**
     * Define el valor de la propiedad isLive.
     * 
     */
    public void setIsLive(boolean value) {
        this.isLive = value;
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
     * Obtiene el valor de la propiedad externalDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalDescription() {
        return externalDescription;
    }

    /**
     * Define el valor de la propiedad externalDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalDescription(String value) {
        this.externalDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad criterionId.
     * 
     */
    public int getCriterionId() {
        return criterionId;
    }

    /**
     * Define el valor de la propiedad criterionId.
     * 
     */
    public void setCriterionId(int value) {
        this.criterionId = value;
    }

    /**
     * Obtiene el valor de la propiedad criteria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCriteria() {
        return criteria;
    }

    /**
     * Define el valor de la propiedad criteria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCriteria(String value) {
        this.criteria = value;
    }

    /**
     * Obtiene el valor de la propiedad betCloses.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBetCloses() {
        return betCloses;
    }

    /**
     * Define el valor de la propiedad betCloses.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBetCloses(XMLGregorianCalendar value) {
        this.betCloses = value;
    }

}
