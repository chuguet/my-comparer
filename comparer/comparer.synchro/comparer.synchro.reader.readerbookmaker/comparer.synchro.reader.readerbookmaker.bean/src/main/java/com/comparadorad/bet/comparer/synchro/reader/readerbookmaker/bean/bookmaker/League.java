//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.28 a las 12:15:40 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bookmaker;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Moneyline;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Spread;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports.Total;


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
 *         &lt;element ref="{}banner" maxOccurs="unbounded"/>
 *         &lt;element ref="{}game" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="IdLeague" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="IdSport" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "league")
public class League {

	 @XmlElementRefs({
		 	@XmlElementRef(name = "banner", type = Banner.class, required = false),
		 	@XmlElementRef(name = "game", type = Game.class, required = false)
	    })

	 protected List<Object> content;
	
    @XmlAttribute(name = "IdLeague", required = true)
    protected int idLeague;
    @XmlAttribute(name = "IdSport", required = true)
    protected String idSport;
    @XmlAttribute(name = "Description")
    protected String description;

    public List<Object> getContent() {
        if (content == null) {
        	content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Obtiene el valor de la propiedad idLeague.
     * 
     */
    public int getIdLeague() {
        return idLeague;
    }

    /**
     * Define el valor de la propiedad idLeague.
     * 
     */
    public void setIdLeague(int value) {
        this.idLeague = value;
    }

    /**
     * Obtiene el valor de la propiedad idSport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSport() {
        return idSport;
    }

    /**
     * Define el valor de la propiedad idSport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSport(String value) {
        this.idSport = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
