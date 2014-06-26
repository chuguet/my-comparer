//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.06.03 a las 10:53:25 AM CEST 
//


package com.comparador.bet.comparer.synchro.reader.readerbookmaker.bean.sportingbetCentrebetMiapuesta;

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
 *         &lt;element ref="{}BetType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="CompetitorName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="BetID" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "betType"
})
@XmlRootElement(name = "Competitor")
public class Competitor {

    @XmlElement(name = "BetType", required = true)
    protected BetType betType;
    @XmlAttribute(name = "CompetitorName", required = true)
    protected String competitorName;
    @XmlAttribute(name = "BetID", required = true)
    protected long betID;

    /**
     * Obtiene el valor de la propiedad betType.
     * 
     * @return
     *     possible object is
     *     {@link BetType }
     *     
     */
    public BetType getBetType() {
        return betType;
    }

    /**
     * Define el valor de la propiedad betType.
     * 
     * @param value
     *     allowed object is
     *     {@link BetType }
     *     
     */
    public void setBetType(BetType value) {
        this.betType = value;
    }

    /**
     * Obtiene el valor de la propiedad competitorName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompetitorName() {
        return competitorName;
    }

    /**
     * Define el valor de la propiedad competitorName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompetitorName(String value) {
        this.competitorName = value;
    }

    /**
     * Obtiene el valor de la propiedad betID.
     * 
     */
    public long getBetID() {
        return betID;
    }

    /**
     * Define el valor de la propiedad betID.
     * 
     */
    public void setBetID(long value) {
        this.betID = value;
    }

}
