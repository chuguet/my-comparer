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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *         &lt;element ref="{http://www.unibet.com/sportsbook-odds-feed}pool" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.unibet.com/sportsbook-odds-feed}country" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.unibet.com/sportsbook-odds-feed}pool"/>
 *         &lt;element ref="{http://www.unibet.com/sportsbook-odds-feed}country"/>
 *         &lt;element ref="{http://www.unibet.com/sportsbook-odds-feed}pool" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="main_group_id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
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
@XmlRootElement(name = "sport")
public class Sport {

    @XmlElementRefs({
        @XmlElementRef(name = "country", namespace = "http://www.unibet.com/sportsbook-odds-feed", type = Country.class, required = false),
        @XmlElementRef(name = "pool", namespace = "http://www.unibet.com/sportsbook-odds-feed", type = Pool.class, required = false)
    })
    protected List<Object> content;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "main_group_id", required = true)
    protected int mainGroupId;
    @XmlAttribute(name = "id", required = true)
    protected int id;

    /**
     * Obtiene el resto del modelo de contenido. 
     * 
     * <p>
     * Ha obtenido esta propiedad que permite capturar todo por el siguiente motivo: 
     * El nombre de campo "Pool" se está utilizando en dos partes diferentes de un esquema. Consulte: 
     * línea 9 de file:/D:/des/proy/com.bfdarts.bet/workspace_sprint73/comparer/comparer.synchro/comparer.synchro.reader.readerbookmaker/comparer.synchro.reader.readerbookmaker.bean/src/main/resources/com/comparadorad/bet/comparer/synchro/reader/readerbookmaker/bean/schema/unibet.xsd
     * línea 7 de file:/D:/des/proy/com.bfdarts.bet/workspace_sprint73/comparer/comparer.synchro/comparer.synchro.reader.readerbookmaker/comparer.synchro.reader.readerbookmaker.bean/src/main/resources/com/comparadorad/bet/comparer/synchro/reader/readerbookmaker/bean/schema/unibet.xsd
     * <p>
     * Para deshacerse de esta propiedad, aplique una personalización de propiedad a una
     * de las dos declaraciones siguientes para cambiarles de nombre: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Country }
     * {@link Pool }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
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
     * Obtiene el valor de la propiedad mainGroupId.
     * 
     */
    public int getMainGroupId() {
        return mainGroupId;
    }

    /**
     * Define el valor de la propiedad mainGroupId.
     * 
     */
    public void setMainGroupId(int value) {
        this.mainGroupId = value;
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

}
