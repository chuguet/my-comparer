//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.08.14 a las 02:21:52 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betathome;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
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
 *         &lt;element name="OddsObject" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Sport">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Category">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Tournament">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="MatchId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="AC" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                   &lt;element name="OddsType">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="betTypeId" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                           &lt;attribute name="oddType" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="betTypeGroup" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="defaultName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="groupName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="betName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="OddsData">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="HomeTeam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AwayTeam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Handicap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="HomeOdds" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                                     &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="DrawOdds" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                                     &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="AwayOdds" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                                     &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Outcomes" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Outcome" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                                               &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="UnderOdds" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                                     &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="OverOdds" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                                     &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="SpreadHome" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="SpreadAway" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="SpreadOddsHome" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                                     &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="SpreadOddsAway" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
 *                                     &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="generatedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "oddsObject"
})
@XmlRootElement(name = "List")
public class List {

    @XmlElement(name = "OddsObject")
    protected java.util.List<List.OddsObject> oddsObject;
    @XmlAttribute(name = "generatedAt")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar generatedAt;

    /**
     * Gets the value of the oddsObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oddsObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOddsObject().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link List.OddsObject }
     * 
     * 
     */
    public java.util.List<List.OddsObject> getOddsObject() {
        if (oddsObject == null) {
            oddsObject = new ArrayList<List.OddsObject>();
        }
        return this.oddsObject;
    }

    /**
     * Obtiene el valor de la propiedad generatedAt.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGeneratedAt() {
        return generatedAt;
    }

    /**
     * Define el valor de la propiedad generatedAt.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGeneratedAt(XMLGregorianCalendar value) {
        this.generatedAt = value;
    }


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
     *         &lt;element name="Sport">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Category">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}short" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Tournament">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}short" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="MatchId" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="AC" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *         &lt;element name="OddsType">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="betTypeId" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                 &lt;attribute name="oddType" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="betTypeGroup" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="defaultName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="groupName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="betName" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="OddsData">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="HomeTeam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AwayTeam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Handicap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="HomeOdds" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                           &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="DrawOdds" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                           &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="AwayOdds" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                           &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Outcomes" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Outcome" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                                     &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="UnderOdds" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                           &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="OverOdds" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                           &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="SpreadHome" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="SpreadAway" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="SpreadOddsHome" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                           &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="SpreadOddsAway" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
     *                           &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "sport",
        "category",
        "tournament",
        "matchId",
        "date",
        "ac",
        "oddsType",
        "oddsData"
    })
    public static class OddsObject {

        @XmlElement(name = "Sport", required = true)
        protected List.OddsObject.Sport sport;
        @XmlElement(name = "Category", required = true)
        protected List.OddsObject.Category category;
        @XmlElement(name = "Tournament", required = true)
        protected List.OddsObject.Tournament tournament;
        @XmlElement(name = "MatchId")
        protected int matchId;
        @XmlElement(name = "Date", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar date;
        @XmlElement(name = "AC")
        protected byte ac;
        @XmlElement(name = "OddsType", required = true)
        protected List.OddsObject.OddsType oddsType;
        @XmlElement(name = "OddsData", required = true)
        protected List.OddsObject.OddsData oddsData;

        /**
         * Obtiene el valor de la propiedad sport.
         * 
         * @return
         *     possible object is
         *     {@link List.OddsObject.Sport }
         *     
         */
        public List.OddsObject.Sport getSport() {
            return sport;
        }

        /**
         * Define el valor de la propiedad sport.
         * 
         * @param value
         *     allowed object is
         *     {@link List.OddsObject.Sport }
         *     
         */
        public void setSport(List.OddsObject.Sport value) {
            this.sport = value;
        }

        /**
         * Obtiene el valor de la propiedad category.
         * 
         * @return
         *     possible object is
         *     {@link List.OddsObject.Category }
         *     
         */
        public List.OddsObject.Category getCategory() {
            return category;
        }

        /**
         * Define el valor de la propiedad category.
         * 
         * @param value
         *     allowed object is
         *     {@link List.OddsObject.Category }
         *     
         */
        public void setCategory(List.OddsObject.Category value) {
            this.category = value;
        }

        /**
         * Obtiene el valor de la propiedad tournament.
         * 
         * @return
         *     possible object is
         *     {@link List.OddsObject.Tournament }
         *     
         */
        public List.OddsObject.Tournament getTournament() {
            return tournament;
        }

        /**
         * Define el valor de la propiedad tournament.
         * 
         * @param value
         *     allowed object is
         *     {@link List.OddsObject.Tournament }
         *     
         */
        public void setTournament(List.OddsObject.Tournament value) {
            this.tournament = value;
        }

        /**
         * Obtiene el valor de la propiedad matchId.
         * 
         */
        public int getMatchId() {
            return matchId;
        }

        /**
         * Define el valor de la propiedad matchId.
         * 
         */
        public void setMatchId(int value) {
            this.matchId = value;
        }

        /**
         * Obtiene el valor de la propiedad date.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDate() {
            return date;
        }

        /**
         * Define el valor de la propiedad date.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDate(XMLGregorianCalendar value) {
            this.date = value;
        }

        /**
         * Obtiene el valor de la propiedad ac.
         * 
         */
        public byte getAC() {
            return ac;
        }

        /**
         * Define el valor de la propiedad ac.
         * 
         */
        public void setAC(byte value) {
            this.ac = value;
        }

        /**
         * Obtiene el valor de la propiedad oddsType.
         * 
         * @return
         *     possible object is
         *     {@link List.OddsObject.OddsType }
         *     
         */
        public List.OddsObject.OddsType getOddsType() {
            return oddsType;
        }

        /**
         * Define el valor de la propiedad oddsType.
         * 
         * @param value
         *     allowed object is
         *     {@link List.OddsObject.OddsType }
         *     
         */
        public void setOddsType(List.OddsObject.OddsType value) {
            this.oddsType = value;
        }

        /**
         * Obtiene el valor de la propiedad oddsData.
         * 
         * @return
         *     possible object is
         *     {@link List.OddsObject.OddsData }
         *     
         */
        public List.OddsObject.OddsData getOddsData() {
            return oddsData;
        }

        /**
         * Define el valor de la propiedad oddsData.
         * 
         * @param value
         *     allowed object is
         *     {@link List.OddsObject.OddsData }
         *     
         */
        public void setOddsData(List.OddsObject.OddsData value) {
            this.oddsData = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}short" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Category {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected Short id;

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtiene el valor de la propiedad id.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getId() {
                return id;
            }

            /**
             * Define el valor de la propiedad id.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setId(Short value) {
                this.id = value;
            }            

        }


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
         *         &lt;element name="HomeTeam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AwayTeam" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Handicap" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="HomeOdds" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *                 &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="DrawOdds" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *                 &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="AwayOdds" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *                 &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Outcomes" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Outcome" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *                           &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="Total" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="UnderOdds" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *                 &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="OverOdds" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *                 &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="SpreadHome" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="SpreadAway" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="SpreadOddsHome" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *                 &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="SpreadOddsAway" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
         *                 &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "homeTeam",
            "awayTeam",
            "handicap",
            "homeOdds",
            "drawOdds",
            "awayOdds",
            "outcomes",
            "total",
            "underOdds",
            "overOdds",
            "spreadHome",
            "spreadAway",
            "spreadOddsHome",
            "spreadOddsAway"
        })
        public static class OddsData {

            @XmlElement(name = "HomeTeam")
            protected String homeTeam;
            @XmlElement(name = "AwayTeam")
            protected String awayTeam;
            @XmlElement(name = "Handicap")
            protected String handicap;
            @XmlElement(name = "HomeOdds")
            protected List.OddsObject.OddsData.HomeOdds homeOdds;
            @XmlElement(name = "DrawOdds")
            protected List.OddsObject.OddsData.DrawOdds drawOdds;
            @XmlElement(name = "AwayOdds")
            protected List.OddsObject.OddsData.AwayOdds awayOdds;
            @XmlElement(name = "Outcomes")
            protected List.OddsObject.OddsData.Outcomes outcomes;
            @XmlElement(name = "Total")
            protected Float total;
            @XmlElement(name = "UnderOdds")
            protected List.OddsObject.OddsData.UnderOdds underOdds;
            @XmlElement(name = "OverOdds")
            protected List.OddsObject.OddsData.OverOdds overOdds;
            @XmlElement(name = "SpreadHome")
            protected Float spreadHome;
            @XmlElement(name = "SpreadAway")
            protected Float spreadAway;
            @XmlElement(name = "SpreadOddsHome")
            protected List.OddsObject.OddsData.SpreadOddsHome spreadOddsHome;
            @XmlElement(name = "SpreadOddsAway")
            protected List.OddsObject.OddsData.SpreadOddsAway spreadOddsAway;

            /**
             * Obtiene el valor de la propiedad homeTeam.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHomeTeam() {
                return homeTeam;
            }

            /**
             * Define el valor de la propiedad homeTeam.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHomeTeam(String value) {
                this.homeTeam = value;
            }

            /**
             * Obtiene el valor de la propiedad awayTeam.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAwayTeam() {
                return awayTeam;
            }

            /**
             * Define el valor de la propiedad awayTeam.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAwayTeam(String value) {
                this.awayTeam = value;
            }

            /**
             * Obtiene el valor de la propiedad handicap.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getHandicap() {
                return handicap;
            }

            /**
             * Define el valor de la propiedad handicap.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setHandicap(String value) {
                this.handicap = value;
            }

            /**
             * Obtiene el valor de la propiedad homeOdds.
             * 
             * @return
             *     possible object is
             *     {@link List.OddsObject.OddsData.HomeOdds }
             *     
             */
            public List.OddsObject.OddsData.HomeOdds getHomeOdds() {
                return homeOdds;
            }

            /**
             * Define el valor de la propiedad homeOdds.
             * 
             * @param value
             *     allowed object is
             *     {@link List.OddsObject.OddsData.HomeOdds }
             *     
             */
            public void setHomeOdds(List.OddsObject.OddsData.HomeOdds value) {
                this.homeOdds = value;
            }

            /**
             * Obtiene el valor de la propiedad drawOdds.
             * 
             * @return
             *     possible object is
             *     {@link List.OddsObject.OddsData.DrawOdds }
             *     
             */
            public List.OddsObject.OddsData.DrawOdds getDrawOdds() {
                return drawOdds;
            }

            /**
             * Define el valor de la propiedad drawOdds.
             * 
             * @param value
             *     allowed object is
             *     {@link List.OddsObject.OddsData.DrawOdds }
             *     
             */
            public void setDrawOdds(List.OddsObject.OddsData.DrawOdds value) {
                this.drawOdds = value;
            }

            /**
             * Obtiene el valor de la propiedad awayOdds.
             * 
             * @return
             *     possible object is
             *     {@link List.OddsObject.OddsData.AwayOdds }
             *     
             */
            public List.OddsObject.OddsData.AwayOdds getAwayOdds() {
                return awayOdds;
            }

            /**
             * Define el valor de la propiedad awayOdds.
             * 
             * @param value
             *     allowed object is
             *     {@link List.OddsObject.OddsData.AwayOdds }
             *     
             */
            public void setAwayOdds(List.OddsObject.OddsData.AwayOdds value) {
                this.awayOdds = value;
            }

            /**
             * Obtiene el valor de la propiedad outcomes.
             * 
             * @return
             *     possible object is
             *     {@link List.OddsObject.OddsData.Outcomes }
             *     
             */
            public List.OddsObject.OddsData.Outcomes getOutcomes() {
                return outcomes;
            }

            /**
             * Define el valor de la propiedad outcomes.
             * 
             * @param value
             *     allowed object is
             *     {@link List.OddsObject.OddsData.Outcomes }
             *     
             */
            public void setOutcomes(List.OddsObject.OddsData.Outcomes value) {
                this.outcomes = value;
            }

            /**
             * Obtiene el valor de la propiedad total.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public Float getTotal() {
                return total;
            }

            /**
             * Define el valor de la propiedad total.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setTotal(Float value) {
                this.total = value;
            }

            /**
             * Obtiene el valor de la propiedad underOdds.
             * 
             * @return
             *     possible object is
             *     {@link List.OddsObject.OddsData.UnderOdds }
             *     
             */
            public List.OddsObject.OddsData.UnderOdds getUnderOdds() {
                return underOdds;
            }

            /**
             * Define el valor de la propiedad underOdds.
             * 
             * @param value
             *     allowed object is
             *     {@link List.OddsObject.OddsData.UnderOdds }
             *     
             */
            public void setUnderOdds(List.OddsObject.OddsData.UnderOdds value) {
                this.underOdds = value;
            }

            /**
             * Obtiene el valor de la propiedad overOdds.
             * 
             * @return
             *     possible object is
             *     {@link List.OddsObject.OddsData.OverOdds }
             *     
             */
            public List.OddsObject.OddsData.OverOdds getOverOdds() {
                return overOdds;
            }

            /**
             * Define el valor de la propiedad overOdds.
             * 
             * @param value
             *     allowed object is
             *     {@link List.OddsObject.OddsData.OverOdds }
             *     
             */
            public void setOverOdds(List.OddsObject.OddsData.OverOdds value) {
                this.overOdds = value;
            }

            /**
             * Obtiene el valor de la propiedad spreadHome.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public Float getSpreadHome() {
                return spreadHome;
            }

            /**
             * Define el valor de la propiedad spreadHome.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setSpreadHome(Float value) {
                this.spreadHome = value;
            }

            /**
             * Obtiene el valor de la propiedad spreadAway.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public Float getSpreadAway() {
                return spreadAway;
            }

            /**
             * Define el valor de la propiedad spreadAway.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setSpreadAway(Float value) {
                this.spreadAway = value;
            }

            /**
             * Obtiene el valor de la propiedad spreadOddsHome.
             * 
             * @return
             *     possible object is
             *     {@link List.OddsObject.OddsData.SpreadOddsHome }
             *     
             */
            public List.OddsObject.OddsData.SpreadOddsHome getSpreadOddsHome() {
                return spreadOddsHome;
            }

            /**
             * Define el valor de la propiedad spreadOddsHome.
             * 
             * @param value
             *     allowed object is
             *     {@link List.OddsObject.OddsData.SpreadOddsHome }
             *     
             */
            public void setSpreadOddsHome(List.OddsObject.OddsData.SpreadOddsHome value) {
                this.spreadOddsHome = value;
            }

            /**
             * Obtiene el valor de la propiedad spreadOddsAway.
             * 
             * @return
             *     possible object is
             *     {@link List.OddsObject.OddsData.SpreadOddsAway }
             *     
             */
            public List.OddsObject.OddsData.SpreadOddsAway getSpreadOddsAway() {
                return spreadOddsAway;
            }

            /**
             * Define el valor de la propiedad spreadOddsAway.
             * 
             * @param value
             *     allowed object is
             *     {@link List.OddsObject.OddsData.SpreadOddsAway }
             *     
             */
            public void setSpreadOddsAway(List.OddsObject.OddsData.SpreadOddsAway value) {
                this.spreadOddsAway = value;
            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
             *       &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class AwayOdds {

                @XmlValue
                protected float value;
                @XmlAttribute(name = "oddId")
                protected String oddId;
                @XmlAttribute(name = "linkId")
                protected String linkId;

                /**
                 * Obtiene el valor de la propiedad value.
                 * 
                 */
                public float getValue() {
                    return value;
                }

                /**
                 * Define el valor de la propiedad value.
                 * 
                 */
                public void setValue(float value) {
                    this.value = value;
                }

                /**
                 * Obtiene el valor de la propiedad oddId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOddId() {
                    return oddId;
                }

                /**
                 * Define el valor de la propiedad oddId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOddId(String value) {
                    this.oddId = value;
                }

                /**
                 * Obtiene el valor de la propiedad linkId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLinkId() {
                    return linkId;
                }

                /**
                 * Define el valor de la propiedad linkId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLinkId(String value) {
                    this.linkId = value;
                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
             *       &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class DrawOdds {

                @XmlValue
                protected float value;
                @XmlAttribute(name = "oddId")
                protected String oddId;
                @XmlAttribute(name = "linkId")
                protected String linkId;

                /**
                 * Obtiene el valor de la propiedad value.
                 * 
                 */
                public float getValue() {
                    return value;
                }

                /**
                 * Define el valor de la propiedad value.
                 * 
                 */
                public void setValue(float value) {
                    this.value = value;
                }

                /**
                 * Obtiene el valor de la propiedad oddId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOddId() {
                    return oddId;
                }

                /**
                 * Define el valor de la propiedad oddId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOddId(String value) {
                    this.oddId = value;
                }

                /**
                 * Obtiene el valor de la propiedad linkId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLinkId() {
                    return linkId;
                }

                /**
                 * Define el valor de la propiedad linkId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLinkId(String value) {
                    this.linkId = value;
                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
             *       &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class HomeOdds {

                @XmlValue
                protected float value;
                @XmlAttribute(name = "oddId")
                protected String oddId;
                @XmlAttribute(name = "linkId")
                protected String linkId;

                /**
                 * Obtiene el valor de la propiedad value.
                 * 
                 */
                public float getValue() {
                    return value;
                }

                /**
                 * Define el valor de la propiedad value.
                 * 
                 */
                public void setValue(float value) {
                    this.value = value;
                }

                /**
                 * Obtiene el valor de la propiedad oddId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOddId() {
                    return oddId;
                }

                /**
                 * Define el valor de la propiedad oddId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOddId(String value) {
                    this.oddId = value;
                }

                /**
                 * Obtiene el valor de la propiedad linkId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLinkId() {
                    return linkId;
                }

                /**
                 * Define el valor de la propiedad linkId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLinkId(String value) {
                    this.linkId = value;
                }

            }


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
             *         &lt;element name="Outcome" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
             *                 &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
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
                "outcome"
            })
            public static class Outcomes {

                @XmlElement(name = "Outcome")
                protected java.util.List<List.OddsObject.OddsData.Outcomes.Outcome> outcome;

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
                 * {@link List.OddsObject.OddsData.Outcomes.Outcome }
                 * 
                 * 
                 */
                public java.util.List<List.OddsObject.OddsData.Outcomes.Outcome> getOutcome() {
                    if (outcome == null) {
                        outcome = new ArrayList<List.OddsObject.OddsData.Outcomes.Outcome>();
                    }
                    return this.outcome;
                }


                /**
                 * <p>Clase Java para anonymous complex type.
                 * 
                 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;simpleContent>
                 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
                 *       &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/extension>
                 *   &lt;/simpleContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "value"
                })
                public static class Outcome {

                    @XmlValue
                    protected float value;
                    @XmlAttribute(name = "oddId")
                    protected String oddId;
                    @XmlAttribute(name = "linkId")
                    protected String linkId;
                    @XmlAttribute(name = "name")
                    protected String name;

                    /**
                     * Obtiene el valor de la propiedad value.
                     * 
                     */
                    public float getValue() {
                        return value;
                    }

                    /**
                     * Define el valor de la propiedad value.
                     * 
                     */
                    public void setValue(float value) {
                        this.value = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad oddId.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getOddId() {
                        return oddId;
                    }

                    /**
                     * Define el valor de la propiedad oddId.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setOddId(String value) {
                        this.oddId = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad linkId.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getLinkId() {
                        return linkId;
                    }

                    /**
                     * Define el valor de la propiedad linkId.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setLinkId(String value) {
                        this.linkId = value;
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

                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
             *       &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class OverOdds {

                @XmlValue
                protected float value;
                @XmlAttribute(name = "oddId")
                protected String oddId;
                @XmlAttribute(name = "linkId")
                protected String linkId;

                /**
                 * Obtiene el valor de la propiedad value.
                 * 
                 */
                public float getValue() {
                    return value;
                }

                /**
                 * Define el valor de la propiedad value.
                 * 
                 */
                public void setValue(float value) {
                    this.value = value;
                }

                /**
                 * Obtiene el valor de la propiedad oddId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOddId() {
                    return oddId;
                }

                /**
                 * Define el valor de la propiedad oddId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOddId(String value) {
                    this.oddId = value;
                }

                /**
                 * Obtiene el valor de la propiedad linkId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLinkId() {
                    return linkId;
                }

                /**
                 * Define el valor de la propiedad linkId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLinkId(String value) {
                    this.linkId = value;
                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
             *       &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class SpreadOddsAway {

                @XmlValue
                protected float value;
                @XmlAttribute(name = "oddId")
                protected String oddId;
                @XmlAttribute(name = "linkId")
                protected String linkId;

                /**
                 * Obtiene el valor de la propiedad value.
                 * 
                 */
                public float getValue() {
                    return value;
                }

                /**
                 * Define el valor de la propiedad value.
                 * 
                 */
                public void setValue(float value) {
                    this.value = value;
                }

                /**
                 * Obtiene el valor de la propiedad oddId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOddId() {
                    return oddId;
                }

                /**
                 * Define el valor de la propiedad oddId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOddId(String value) {
                    this.oddId = value;
                }

                /**
                 * Obtiene el valor de la propiedad linkId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLinkId() {
                    return linkId;
                }

                /**
                 * Define el valor de la propiedad linkId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLinkId(String value) {
                    this.linkId = value;
                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
             *       &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class SpreadOddsHome {

                @XmlValue
                protected float value;
                @XmlAttribute(name = "oddId")
                protected String oddId;
                @XmlAttribute(name = "linkId")
                protected String linkId;

                /**
                 * Obtiene el valor de la propiedad value.
                 * 
                 */
                public float getValue() {
                    return value;
                }

                /**
                 * Define el valor de la propiedad value.
                 * 
                 */
                public void setValue(float value) {
                    this.value = value;
                }

                /**
                 * Obtiene el valor de la propiedad oddId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOddId() {
                    return oddId;
                }

                /**
                 * Define el valor de la propiedad oddId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOddId(String value) {
                    this.oddId = value;
                }

                /**
                 * Obtiene el valor de la propiedad linkId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLinkId() {
                    return linkId;
                }

                /**
                 * Define el valor de la propiedad linkId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLinkId(String value) {
                    this.linkId = value;
                }

            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>float">
             *       &lt;attribute name="oddId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="linkId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class UnderOdds {

                @XmlValue
                protected float value;
                @XmlAttribute(name = "oddId")
                protected String oddId;
                @XmlAttribute(name = "linkId")
                protected String linkId;

                /**
                 * Obtiene el valor de la propiedad value.
                 * 
                 */
                public float getValue() {
                    return value;
                }

                /**
                 * Define el valor de la propiedad value.
                 * 
                 */
                public void setValue(float value) {
                    this.value = value;
                }

                /**
                 * Obtiene el valor de la propiedad oddId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getOddId() {
                    return oddId;
                }

                /**
                 * Define el valor de la propiedad oddId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setOddId(String value) {
                    this.oddId = value;
                }

                /**
                 * Obtiene el valor de la propiedad linkId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLinkId() {
                    return linkId;
                }

                /**
                 * Define el valor de la propiedad linkId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLinkId(String value) {
                    this.linkId = value;
                }

            }

        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="betTypeId" type="{http://www.w3.org/2001/XMLSchema}short" />
         *       &lt;attribute name="oddType" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="betTypeGroup" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="defaultName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="groupName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="betName" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class OddsType {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "betTypeId")
            protected Short betTypeId;
            @XmlAttribute(name = "oddType")
            protected Byte oddType;
            @XmlAttribute(name = "betTypeGroup")
            protected Byte betTypeGroup;
            @XmlAttribute(name = "defaultName")
            protected String defaultName;
            @XmlAttribute(name = "groupName")
            protected String groupName;
            @XmlAttribute(name = "betName")
            protected String betName;

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtiene el valor de la propiedad betTypeId.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getBetTypeId() {
                return betTypeId;
            }

            /**
             * Define el valor de la propiedad betTypeId.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setBetTypeId(Short value) {
                this.betTypeId = value;
            }

            /**
             * Obtiene el valor de la propiedad oddType.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getOddType() {
                return oddType;
            }

            /**
             * Define el valor de la propiedad oddType.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setOddType(Byte value) {
                this.oddType = value;
            }

            /**
             * Obtiene el valor de la propiedad betTypeGroup.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getBetTypeGroup() {
                return betTypeGroup;
            }

            /**
             * Define el valor de la propiedad betTypeGroup.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setBetTypeGroup(Byte value) {
                this.betTypeGroup = value;
            }

            /**
             * Obtiene el valor de la propiedad defaultName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDefaultName() {
                return defaultName;
            }

            /**
             * Define el valor de la propiedad defaultName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDefaultName(String value) {
                this.defaultName = value;
            }

            /**
             * Obtiene el valor de la propiedad groupName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGroupName() {
                return groupName;
            }

            /**
             * Define el valor de la propiedad groupName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGroupName(String value) {
                this.groupName = value;
            }

            /**
             * Obtiene el valor de la propiedad betName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBetName() {
                return betName;
            }

            /**
             * Define el valor de la propiedad betName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBetName(String value) {
                this.betName = value;
            }

        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Sport {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected Byte id;

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtiene el valor de la propiedad id.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getId() {
                return id;
            }

            /**
             * Define el valor de la propiedad id.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setId(Byte value) {
                this.id = value;
            }

        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;simpleContent>
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}short" />
         *     &lt;/extension>
         *   &lt;/simpleContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Tournament {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "id")
            protected Short id;

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Obtiene el valor de la propiedad id.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getId() {
                return id;
            }

            /**
             * Define el valor de la propiedad id.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setId(Short value) {
                this.id = value;
            }

        }

    }

}
