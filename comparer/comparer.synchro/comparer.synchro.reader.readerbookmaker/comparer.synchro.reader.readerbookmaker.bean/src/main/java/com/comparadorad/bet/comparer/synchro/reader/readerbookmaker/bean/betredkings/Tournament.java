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
 *         &lt;element ref="{}StartDate"/>
 *         &lt;choice>
 *           &lt;element ref="{}Match" maxOccurs="unbounded"/>
 *           &lt;sequence>
 *             &lt;element ref="{}Participants"/>
 *             &lt;element ref="{}TournamentOdds"/>
 *             &lt;element ref="{}Match" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="sortName" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="null"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="1. Division 2013"/>
 *             &lt;enumeration value="2. Division Norrland 2013"/>
 *             &lt;enumeration value="2. Divisjon 2013 Group 1"/>
 *             &lt;enumeration value="2. Divisjon 2013 Group 2"/>
 *             &lt;enumeration value="3. Division 2013, Group 1"/>
 *             &lt;enumeration value="3. Division 2013, Group 5"/>
 *             &lt;enumeration value="3. Division 2013, Group 6"/>
 *             &lt;enumeration value="A Lyga 2013"/>
 *             &lt;enumeration value="Allsvenskan 2013"/>
 *             &lt;enumeration value="Bundesliga 2013/2014"/>
 *             &lt;enumeration value="CONCACAF World Cup Qualification 2014"/>
 *             &lt;enumeration value="Championship 2013/2014"/>
 *             &lt;enumeration value="DBU Cup 2012/2013"/>
 *             &lt;enumeration value="Damallsvenskan 2013"/>
 *             &lt;enumeration value="Druha League 2012/2013"/>
 *             &lt;enumeration value="FA Cup 2013/2014"/>
 *             &lt;enumeration value="FIFA Confederations Cup 2013"/>
 *             &lt;enumeration value="FIFA Confederations Cup 2013 Group A"/>
 *             &lt;enumeration value="FIFA Confederations Cup 2013 Group B"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group A"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group B"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group C"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group D"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group E"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group F"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group G"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group H"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group I"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - CAF Group J"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - UEFA  Group A"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - UEFA Group B"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - UEFA Group C"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - UEFA Group E"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - UEFA Group F"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - UEFA Group G"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - UEFA Group H"/>
 *             &lt;enumeration value="FIFA World Cup 2014 Qualification - UEFA Group I"/>
 *             &lt;enumeration value="FIFA World Cup Qualification - CONMEBOL 2011/13"/>
 *             &lt;enumeration value="Friendly International 2013"/>
 *             &lt;enumeration value="J League 2 2013"/>
 *             &lt;enumeration value="Juniorska liga 2012/2013"/>
 *             &lt;enumeration value="Kakkonen Etela 2013"/>
 *             &lt;enumeration value="Kakkonen Ita 2013"/>
 *             &lt;enumeration value="Kakkonen Lansi 2013"/>
 *             &lt;enumeration value="League 1 2013/2014"/>
 *             &lt;enumeration value="League 2 2013/2014 "/>
 *             &lt;enumeration value="Liga Postobon 2013"/>
 *             &lt;enumeration value="MLS 2013"/>
 *             &lt;enumeration value="Oberliga Westfalen 2012/2013"/>
 *             &lt;enumeration value="Premier Division 2013"/>
 *             &lt;enumeration value="Premier League 2012/2013"/>
 *             &lt;enumeration value="Premier League 2013/2014"/>
 *             &lt;enumeration value="Primera B Nacional 2012/2013"/>
 *             &lt;enumeration value="Primera Division 2013"/>
 *             &lt;enumeration value="Regionalliga 2012/2013"/>
 *             &lt;enumeration value="Serie A 2013"/>
 *             &lt;enumeration value="Serie B 2013"/>
 *             &lt;enumeration value="Super League 2012/2013"/>
 *             &lt;enumeration value="Superettan 2013"/>
 *             &lt;enumeration value="Superliga 2013/2014"/>
 *             &lt;enumeration value="Tippeligaen 2013"/>
 *             &lt;enumeration value="Torneo Inicial 2012/2013"/>
 *             &lt;enumeration value="Toulon Tournament 2013, Group A"/>
 *             &lt;enumeration value="UEFA U19 Championship 2012/2013, Group 3"/>
 *             &lt;enumeration value="UEFA U19 Championship 2012/2013, Group 4"/>
 *             &lt;enumeration value="UEFA U19 Championship 2012/2013, Group 5"/>
 *             &lt;enumeration value="UEFA U21 Championship 2013"/>
 *             &lt;enumeration value="UEFA U21 Championship 2013 Qualifying Round"/>
 *             &lt;enumeration value="UEFA U21 Championship 2013, Group 1"/>
 *             &lt;enumeration value="UEFA U21 Championship 2013, Group 10"/>
 *             &lt;enumeration value="UEFA U21 Championship 2013, Group 2"/>
 *             &lt;enumeration value="UEFA U21 Championship 2013, Group 4"/>
 *             &lt;enumeration value="UEFA U21 Championship 2013, Group 6"/>
 *             &lt;enumeration value="UEFA U21 Championship 2013, Group 8"/>
 *             &lt;enumeration value="World Cup Qualification - AFC, Group A 2014"/>
 *             &lt;enumeration value="World Cup Qualification - AFC, Group B 2014"/>
 *             &lt;enumeration value="Ykkonen 2013"/>
 *             &lt;enumeration value="Úrvalsdeild 2013"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;enumeration value="190208147"/>
 *             &lt;enumeration value="190403307"/>
 *             &lt;enumeration value="190403310"/>
 *             &lt;enumeration value="190403311"/>
 *             &lt;enumeration value="190403319"/>
 *             &lt;enumeration value="190403320"/>
 *             &lt;enumeration value="190403321"/>
 *             &lt;enumeration value="190403322"/>
 *             &lt;enumeration value="190403323"/>
 *             &lt;enumeration value="191490163"/>
 *             &lt;enumeration value="192448691"/>
 *             &lt;enumeration value="192528717"/>
 *             &lt;enumeration value="192528726"/>
 *             &lt;enumeration value="192528729"/>
 *             &lt;enumeration value="192528739"/>
 *             &lt;enumeration value="192528755"/>
 *             &lt;enumeration value="192528764"/>
 *             &lt;enumeration value="192528765"/>
 *             &lt;enumeration value="192528773"/>
 *             &lt;enumeration value="192528774"/>
 *             &lt;enumeration value="192528783"/>
 *             &lt;enumeration value="192655358"/>
 *             &lt;enumeration value="192984496"/>
 *             &lt;enumeration value="192984691"/>
 *             &lt;enumeration value="193630256"/>
 *             &lt;enumeration value="195609596"/>
 *             &lt;enumeration value="197357710"/>
 *             &lt;enumeration value="201033913"/>
 *             &lt;enumeration value="202267379"/>
 *             &lt;enumeration value="202268533"/>
 *             &lt;enumeration value="203088515"/>
 *             &lt;enumeration value="203687278"/>
 *             &lt;enumeration value="203687418"/>
 *             &lt;enumeration value="203748355"/>
 *             &lt;enumeration value="203888237"/>
 *             &lt;enumeration value="203941139"/>
 *             &lt;enumeration value="203944751"/>
 *             &lt;enumeration value="204140027"/>
 *             &lt;enumeration value="204140302"/>
 *             &lt;enumeration value="204360015"/>
 *             &lt;enumeration value="204371410"/>
 *             &lt;enumeration value="204371741"/>
 *             &lt;enumeration value="204372152"/>
 *             &lt;enumeration value="204728101"/>
 *             &lt;enumeration value="205054420"/>
 *             &lt;enumeration value="205054423"/>
 *             &lt;enumeration value="205839377"/>
 *             &lt;enumeration value="205839607"/>
 *             &lt;enumeration value="205839626"/>
 *             &lt;enumeration value="205840562"/>
 *             &lt;enumeration value="205877801"/>
 *             &lt;enumeration value="205877808"/>
 *             &lt;enumeration value="205877815"/>
 *             &lt;enumeration value="205878062"/>
 *             &lt;enumeration value="205878292"/>
 *             &lt;enumeration value="205878335"/>
 *             &lt;enumeration value="206369842"/>
 *             &lt;enumeration value="206444877"/>
 *             &lt;enumeration value="206515267"/>
 *             &lt;enumeration value="206515350"/>
 *             &lt;enumeration value="206515381"/>
 *             &lt;enumeration value="206515387"/>
 *             &lt;enumeration value="206600535"/>
 *             &lt;enumeration value="206603666"/>
 *             &lt;enumeration value="206644396"/>
 *             &lt;enumeration value="206644397"/>
 *             &lt;enumeration value="206644777"/>
 *             &lt;enumeration value="206644780"/>
 *             &lt;enumeration value="206644783"/>
 *             &lt;enumeration value="206664367"/>
 *             &lt;enumeration value="206685580"/>
 *             &lt;enumeration value="206685581"/>
 *             &lt;enumeration value="206685586"/>
 *             &lt;enumeration value="206695844"/>
 *             &lt;enumeration value="206710465"/>
 *             &lt;enumeration value="206732652"/>
 *             &lt;enumeration value="206736066"/>
 *             &lt;enumeration value="206743952"/>
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
    "content"
})
@XmlRootElement(name = "Tournament")
public class Tournament {

    @XmlElementRefs({
        @XmlElementRef(name = "Participants", type = Participants.class, required = false),
        @XmlElementRef(name = "StartDate", type = StartDate.class, required = false),
        @XmlElementRef(name = "TournamentOdds", type = TournamentOdds.class, required = false),
        @XmlElementRef(name = "Match", type = Match.class, required = false)
    })
    protected List<Object> content;
    @XmlAttribute(name = "sortName", required = true)
    protected String sortName;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected int id;

    /**
     * Obtiene el resto del modelo de contenido. 
     * 
     * <p>
     * Ha obtenido esta propiedad que permite capturar todo por el siguiente motivo: 
     * El nombre de campo "Match" se está utilizando en dos partes diferentes de un esquema. Consulte: 
     * línea 510 de file:/D:/des/proy/com.comparadorad.bet/workspace/comparer/comparer.synchro/comparer.synchro.reader.readerbookmaker/comparer.synchro.reader.readerbookmaker.bean/src/main/resources/com/comparadorad/bet/comparer/synchro/reader/readerbookmaker/bean/schema/betredkings.xsd
     * línea 506 de file:/D:/des/proy/com.comparadorad.bet/workspace/comparer/comparer.synchro/comparer.synchro.reader.readerbookmaker/comparer.synchro.reader.readerbookmaker.bean/src/main/resources/com/comparadorad/bet/comparer/synchro/reader/readerbookmaker/bean/schema/betredkings.xsd
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
     * {@link TournamentOdds }
     * {@link Match }
     * {@link Participants }
     * {@link StartDate }
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
     * Obtiene el valor de la propiedad sortName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSortName() {
        return sortName;
    }

    /**
     * Define el valor de la propiedad sortName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSortName(String value) {
        this.sortName = value;
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
