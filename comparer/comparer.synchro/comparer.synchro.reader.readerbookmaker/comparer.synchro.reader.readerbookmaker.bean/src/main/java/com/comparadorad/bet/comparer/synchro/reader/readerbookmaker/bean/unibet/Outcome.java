//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.03.07 a las 04:57:25 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.unibet;

import java.math.BigDecimal;
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
 *         &lt;element ref="{http://www.unibet.com/sportsbook-odds-feed}price"/>
 *       &lt;/sequence>
 *       &lt;attribute name="updated_date" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="start_no" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="participant_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="participant_id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="label" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="is_scratched" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="handicap_line" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "price"
})
@XmlRootElement(name = "outcome")
public class Outcome {

    @XmlElement(required = true)
    protected Price price;
    @XmlAttribute(name = "updated_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedDate;
    @XmlAttribute(name = "start_no")
    protected Byte startNo;
    @XmlAttribute(name = "participant_name")
    protected String participantName;
    @XmlAttribute(name = "participant_id")
    protected Integer participantId;
    @XmlAttribute(name = "label", required = true)
    protected String label;
    @XmlAttribute(name = "is_scratched")
    protected Boolean isScratched;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "handicap_line")
    protected BigDecimal handicapLine;

    /**
     * Obtiene el valor de la propiedad price.
     * 
     * @return
     *     possible object is
     *     {@link Price }
     *     
     */
    public Price getPrice() {
        return price;
    }

    /**
     * Define el valor de la propiedad price.
     * 
     * @param value
     *     allowed object is
     *     {@link Price }
     *     
     */
    public void setPrice(Price value) {
        this.price = value;
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
     * Obtiene el valor de la propiedad startNo.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getStartNo() {
        return startNo;
    }

    /**
     * Define el valor de la propiedad startNo.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setStartNo(Byte value) {
        this.startNo = value;
    }

    /**
     * Obtiene el valor de la propiedad participantName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipantName() {
        return participantName;
    }

    /**
     * Define el valor de la propiedad participantName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipantName(String value) {
        this.participantName = value;
    }

    /**
     * Obtiene el valor de la propiedad participantId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getParticipantId() {
        return participantId;
    }

    /**
     * Define el valor de la propiedad participantId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setParticipantId(Integer value) {
        this.participantId = value;
    }

    /**
     * Obtiene el valor de la propiedad label.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Define el valor de la propiedad label.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Obtiene el valor de la propiedad isScratched.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsScratched() {
        return isScratched;
    }

    /**
     * Define el valor de la propiedad isScratched.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsScratched(Boolean value) {
        this.isScratched = value;
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
     * Obtiene el valor de la propiedad handicapLine.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getHandicapLine() {
        return handicapLine;
    }

    /**
     * Define el valor de la propiedad handicapLine.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setHandicapLine(BigDecimal value) {
        this.handicapLine = value;
    }

}
