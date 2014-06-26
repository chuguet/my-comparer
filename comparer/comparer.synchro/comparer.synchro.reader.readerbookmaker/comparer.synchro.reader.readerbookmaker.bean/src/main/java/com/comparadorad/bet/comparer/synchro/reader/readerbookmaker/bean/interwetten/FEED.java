//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.10.03 a las 07:08:09 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.interwetten;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="KINDOFSPORT">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LEAGUE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="EVENT" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BET" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                               &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                               &lt;attribute name="TYPEID" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                               &lt;attribute name="TYPENAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="PLAYER1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="PLAYER2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="TIP" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="QUOTE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="START_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                                     &lt;attribute name="OPEN_TILL" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *                                     &lt;attribute name="EVENTID" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DESCRIPTION" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LAST_REFRESH" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="NEXT_REFRESH" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="DOMAIN" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="LANGUAGE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "kindofsport"
})
@XmlRootElement(name = "FEED")
public class FEED {

    @XmlElement(name = "KINDOFSPORT", required = true)
    protected FEED.KINDOFSPORT kindofsport;
    @XmlAttribute(name = "NAME")
    protected String name;
    @XmlAttribute(name = "DESCRIPTION")
    protected String description;
    @XmlAttribute(name = "LAST_REFRESH")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastrefresh;
    @XmlAttribute(name = "NEXT_REFRESH")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextrefresh;
    @XmlAttribute(name = "DOMAIN")
    @XmlSchemaType(name = "anyURI")
    protected String domain;
    @XmlAttribute(name = "LANGUAGE")
    protected String language;

    /**
     * Obtiene el valor de la propiedad kindofsport.
     * 
     * @return
     *     possible object is
     *     {@link FEED.KINDOFSPORT }
     *     
     */
    public FEED.KINDOFSPORT getKINDOFSPORT() {
        return kindofsport;
    }

    /**
     * Define el valor de la propiedad kindofsport.
     * 
     * @param value
     *     allowed object is
     *     {@link FEED.KINDOFSPORT }
     *     
     */
    public void setKINDOFSPORT(FEED.KINDOFSPORT value) {
        this.kindofsport = value;
    }

    /**
     * Obtiene el valor de la propiedad name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
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
    public void setNAME(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCRIPTION() {
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
    public void setDESCRIPTION(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad lastrefresh.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLASTREFRESH() {
        return lastrefresh;
    }

    /**
     * Define el valor de la propiedad lastrefresh.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLASTREFRESH(XMLGregorianCalendar value) {
        this.lastrefresh = value;
    }

    /**
     * Obtiene el valor de la propiedad nextrefresh.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNEXTREFRESH() {
        return nextrefresh;
    }

    /**
     * Define el valor de la propiedad nextrefresh.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNEXTREFRESH(XMLGregorianCalendar value) {
        this.nextrefresh = value;
    }

    /**
     * Obtiene el valor de la propiedad domain.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOMAIN() {
        return domain;
    }

    /**
     * Define el valor de la propiedad domain.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOMAIN(String value) {
        this.domain = value;
    }

    /**
     * Obtiene el valor de la propiedad language.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLANGUAGE() {
        return language;
    }

    /**
     * Define el valor de la propiedad language.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLANGUAGE(String value) {
        this.language = value;
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
     *         &lt;element name="LEAGUE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="EVENT" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="BET" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                     &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                                     &lt;attribute name="TYPEID" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                                     &lt;attribute name="TYPENAME" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="PLAYER1" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="PLAYER2" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="TIP" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="QUOTE" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="START_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *                           &lt;attribute name="OPEN_TILL" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
     *                           &lt;attribute name="EVENTID" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}int" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "league"
    })
    public static class KINDOFSPORT {

        @XmlElement(name = "LEAGUE")
        protected List<FEED.KINDOFSPORT.LEAGUE> league;
        @XmlAttribute(name = "NAME")
        protected String name;

        /**
         * Gets the value of the league property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the league property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLEAGUE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FEED.KINDOFSPORT.LEAGUE }
         * 
         * 
         */
        public List<FEED.KINDOFSPORT.LEAGUE> getLEAGUE() {
            if (league == null) {
                league = new ArrayList<FEED.KINDOFSPORT.LEAGUE>();
            }
            return this.league;
        }

        /**
         * Obtiene el valor de la propiedad name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNAME() {
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
        public void setNAME(String value) {
            this.name = value;
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
         *         &lt;element name="EVENT" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="BET" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;simpleContent>
         *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                           &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                           &lt;attribute name="TYPEID" type="{http://www.w3.org/2001/XMLSchema}int" />
         *                           &lt;attribute name="TYPENAME" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="PLAYER1" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="PLAYER2" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="TIP" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="QUOTE" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/extension>
         *                       &lt;/simpleContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="START_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
         *                 &lt;attribute name="OPEN_TILL" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
         *                 &lt;attribute name="EVENTID" type="{http://www.w3.org/2001/XMLSchema}int" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}int" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "event"
        })
        public static class LEAGUE {

            @XmlElement(name = "EVENT")
            protected List<FEED.KINDOFSPORT.LEAGUE.EVENT> event;
            @XmlAttribute(name = "NAME")
            protected String name;
            @XmlAttribute(name = "ID")
            protected Integer id;

            /**
             * Gets the value of the event property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the event property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEVENT().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link FEED.KINDOFSPORT.LEAGUE.EVENT }
             * 
             * 
             */
            public List<FEED.KINDOFSPORT.LEAGUE.EVENT> getEVENT() {
                if (event == null) {
                    event = new ArrayList<FEED.KINDOFSPORT.LEAGUE.EVENT>();
                }
                return this.event;
            }

            /**
             * Obtiene el valor de la propiedad name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNAME() {
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
            public void setNAME(String value) {
                this.name = value;
            }

            /**
             * Obtiene el valor de la propiedad id.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getID() {
                return id;
            }

            /**
             * Define el valor de la propiedad id.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setID(Integer value) {
                this.id = value;
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
             *         &lt;element name="BET" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;simpleContent>
             *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                 &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}int" />
             *                 &lt;attribute name="TYPEID" type="{http://www.w3.org/2001/XMLSchema}int" />
             *                 &lt;attribute name="TYPENAME" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="PLAYER1" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="PLAYER2" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="TIP" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="QUOTE" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/extension>
             *             &lt;/simpleContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="START_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="OPEN_TILL" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
             *       &lt;attribute name="EVENTID" type="{http://www.w3.org/2001/XMLSchema}int" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "bet"
            })
            public static class EVENT {

                @XmlElement(name = "BET")
                protected List<FEED.KINDOFSPORT.LEAGUE.EVENT.BET> bet;
                @XmlAttribute(name = "NAME")
                protected String name;
                @XmlAttribute(name = "START_TIME")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar starttime;
                @XmlAttribute(name = "OPEN_TILL")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar opentill;
                @XmlAttribute(name = "EVENTID")
                protected Integer eventid;

                /**
                 * Gets the value of the bet property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the bet property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getBET().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link FEED.KINDOFSPORT.LEAGUE.EVENT.BET }
                 * 
                 * 
                 */
                public List<FEED.KINDOFSPORT.LEAGUE.EVENT.BET> getBET() {
                    if (bet == null) {
                        bet = new ArrayList<FEED.KINDOFSPORT.LEAGUE.EVENT.BET>();
                    }
                    return this.bet;
                }

                /**
                 * Obtiene el valor de la propiedad name.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNAME() {
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
                public void setNAME(String value) {
                    this.name = value;
                }

                /**
                 * Obtiene el valor de la propiedad starttime.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getSTARTTIME() {
                    return starttime;
                }

                /**
                 * Define el valor de la propiedad starttime.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setSTARTTIME(XMLGregorianCalendar value) {
                    this.starttime = value;
                }

                /**
                 * Obtiene el valor de la propiedad opentill.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getOPENTILL() {
                    return opentill;
                }

                /**
                 * Define el valor de la propiedad opentill.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setOPENTILL(XMLGregorianCalendar value) {
                    this.opentill = value;
                }

                /**
                 * Obtiene el valor de la propiedad eventid.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getEVENTID() {
                    return eventid;
                }

                /**
                 * Define el valor de la propiedad eventid.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setEVENTID(Integer value) {
                    this.eventid = value;
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
                 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}int" />
                 *       &lt;attribute name="TYPEID" type="{http://www.w3.org/2001/XMLSchema}int" />
                 *       &lt;attribute name="TYPENAME" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="PLAYER1" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="PLAYER2" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="TIP" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="QUOTE" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                public static class BET {

                    @XmlValue
                    protected String value;
                    @XmlAttribute(name = "ID")
                    protected Integer id;
                    @XmlAttribute(name = "TYPEID")
                    protected Integer typeid;
                    @XmlAttribute(name = "TYPENAME")
                    protected String typename;
                    @XmlAttribute(name = "PLAYER1")
                    protected String player1;
                    @XmlAttribute(name = "PLAYER2")
                    protected String player2;
                    @XmlAttribute(name = "TIP")
                    protected String tip;
                    @XmlAttribute(name = "QUOTE")
                    protected String quote;

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
                     *     {@link Integer }
                     *     
                     */
                    public Integer getID() {
                        return id;
                    }

                    /**
                     * Define el valor de la propiedad id.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Integer }
                     *     
                     */
                    public void setID(Integer value) {
                        this.id = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad typeid.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Integer }
                     *     
                     */
                    public Integer getTYPEID() {
                        return typeid;
                    }

                    /**
                     * Define el valor de la propiedad typeid.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Integer }
                     *     
                     */
                    public void setTYPEID(Integer value) {
                        this.typeid = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad typename.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTYPENAME() {
                        return typename;
                    }

                    /**
                     * Define el valor de la propiedad typename.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTYPENAME(String value) {
                        this.typename = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad player1.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPLAYER1() {
                        return player1;
                    }

                    /**
                     * Define el valor de la propiedad player1.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPLAYER1(String value) {
                        this.player1 = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad player2.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPLAYER2() {
                        return player2;
                    }

                    /**
                     * Define el valor de la propiedad player2.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPLAYER2(String value) {
                        this.player2 = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad tip.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTIP() {
                        return tip;
                    }

                    /**
                     * Define el valor de la propiedad tip.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTIP(String value) {
                        this.tip = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad quote.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getQUOTE() {
                        return quote;
                    }

                    /**
                     * Define el valor de la propiedad quote.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setQUOTE(String value) {
                        this.quote = value;
                    }

					@Override
					public String toString() {
						return "BET [value=" + value + ", id=" + id
								+ ", typeid=" + typeid + ", typename="
								+ typename + ", player1=" + player1
								+ ", player2=" + player2 + ", tip=" + tip
								+ ", quote=" + quote + "]";
					}

                }

            }

        }

    }

}
