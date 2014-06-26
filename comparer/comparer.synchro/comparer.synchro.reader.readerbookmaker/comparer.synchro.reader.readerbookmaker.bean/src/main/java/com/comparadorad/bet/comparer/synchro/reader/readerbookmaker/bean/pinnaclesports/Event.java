//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.02.28 a las 04:23:47 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.pinnaclesports;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{}event_datetimeGMT"/>
 *         &lt;element ref="{}gamenumber"/>
 *         &lt;element ref="{}sporttype"/>
 *         &lt;element ref="{}league"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element ref="{}contest_maximum"/>
 *             &lt;element ref="{}description"/>
 *             &lt;element ref="{}participants"/>
 *             &lt;element ref="{}total" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element ref="{}IsLive"/>
 *             &lt;element ref="{}participants"/>
 *             &lt;element ref="{}periods"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
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
@XmlRootElement(name = "event")
public class Event {

    @XmlElementRefs({
        @XmlElementRef(name = "contest_maximum", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "gamenumber", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "participants", type = Participants.class, required = false),
        @XmlElementRef(name = "league", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "total", type = Total.class, required = false),
        @XmlElementRef(name = "description", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sporttype", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "IsLive", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "periods", type = Periods.class, required = false),
        @XmlElementRef(name = "event_datetimeGMT", type = JAXBElement.class, required = false)
    })
    protected List<Object> content;

    /**
     * Obtiene el resto del modelo de contenido. 
     * 
     * <p>
     * Ha obtenido esta propiedad que permite capturar todo por el siguiente motivo: 
     * El nombre de campo "Participants" se está utilizando en dos partes diferentes de un esquema. Consulte: 
     * línea 7559 de file:/D:/des/proy/com.comparadorad.bet/workspace/comparer/comparer.synchro/comparer.synchro.reader.readerbookmaker/comparer.synchro.reader.readerbookmaker.bean/src/main/resources/com/comparadorad/bet/comparer/synchro/reader/readerbookmaker/bean/schema/pinnaclesports.xsd
     * línea 7554 de file:/D:/des/proy/com.comparadorad.bet/workspace/comparer/comparer.synchro/comparer.synchro.reader.readerbookmaker/comparer.synchro.reader.readerbookmaker.bean/src/main/resources/com/comparadorad/bet/comparer/synchro/reader/readerbookmaker/bean/schema/pinnaclesports.xsd
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
     * {@link JAXBElement }{@code <}{@link Short }{@code >}
     * {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * {@link Participants }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Total }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link Periods }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

}
