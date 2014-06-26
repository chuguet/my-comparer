//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.06.03 a las 11:12:51 AM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HomeTeam_QNAME = new QName("", "HomeTeam");
    private final static QName _AwayOdds_QNAME = new QName("", "AwayOdds");
    private final static QName _DrawOdds_QNAME = new QName("", "DrawOdds");
    private final static QName _HomeOdds_QNAME = new QName("", "HomeOdds");
    private final static QName _AC_QNAME = new QName("", "AC");
    private final static QName _SpreadAway_QNAME = new QName("", "SpreadAway");
    private final static QName _Category_QNAME = new QName("", "Category");
    private final static QName _SpreadOddsHome_QNAME = new QName("", "SpreadOddsHome");
    private final static QName _Date_QNAME = new QName("", "Date");
    private final static QName _AwayTeam_QNAME = new QName("", "AwayTeam");
    private final static QName _Tournament_QNAME = new QName("", "Tournament");
    private final static QName _OverOdds_QNAME = new QName("", "OverOdds");
    private final static QName _OddsType_QNAME = new QName("", "OddsType");
    private final static QName _Sport_QNAME = new QName("", "Sport");
    private final static QName _UnderOdds_QNAME = new QName("", "UnderOdds");
    private final static QName _SpreadHome_QNAME = new QName("", "SpreadHome");
    private final static QName _Total_QNAME = new QName("", "Total");
    private final static QName _SpreadOddsAway_QNAME = new QName("", "SpreadOddsAway");
    private final static QName _MatchId_QNAME = new QName("", "MatchId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betboo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OddsObject }
     * 
     */
    public OddsObject createOddsObject() {
        return new OddsObject();
    }

    /**
     * Create an instance of {@link OddsData }
     * 
     */
    public OddsData createOddsData() {
        return new OddsData();
    }

    /**
     * Create an instance of {@link Competitor }
     * 
     */
    public Competitor createCompetitor() {
        return new Competitor();
    }

    /**
     * Create an instance of {@link List }
     * 
     */
    public List createList() {
        return new List();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HomeTeam")
    public JAXBElement<String> createHomeTeam(String value) {
        return new JAXBElement<String>(_HomeTeam_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AwayOdds")
    public JAXBElement<BigDecimal> createAwayOdds(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_AwayOdds_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "DrawOdds")
    public JAXBElement<BigDecimal> createDrawOdds(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DrawOdds_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "HomeOdds")
    public JAXBElement<BigDecimal> createHomeOdds(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_HomeOdds_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AC")
    public JAXBElement<Byte> createAC(Byte value) {
        return new JAXBElement<Byte>(_AC_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SpreadAway")
    public JAXBElement<String> createSpreadAway(String value) {
        return new JAXBElement<String>(_SpreadAway_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Category")
    public JAXBElement<String> createCategory(String value) {
        return new JAXBElement<String>(_Category_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SpreadOddsHome")
    public JAXBElement<String> createSpreadOddsHome(String value) {
        return new JAXBElement<String>(_SpreadOddsHome_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Date")
    public JAXBElement<XMLGregorianCalendar> createDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Date_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "AwayTeam")
    public JAXBElement<String> createAwayTeam(String value) {
        return new JAXBElement<String>(_AwayTeam_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Tournament")
    public JAXBElement<String> createTournament(String value) {
        return new JAXBElement<String>(_Tournament_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OverOdds")
    public JAXBElement<String> createOverOdds(String value) {
        return new JAXBElement<String>(_OverOdds_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OddsType")
    public JAXBElement<String> createOddsType(String value) {
        return new JAXBElement<String>(_OddsType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Sport")
    public JAXBElement<String> createSport(String value) {
        return new JAXBElement<String>(_Sport_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "UnderOdds")
    public JAXBElement<String> createUnderOdds(String value) {
        return new JAXBElement<String>(_UnderOdds_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SpreadHome")
    public JAXBElement<String> createSpreadHome(String value) {
        return new JAXBElement<String>(_SpreadHome_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Total")
    public JAXBElement<String> createTotal(String value) {
        return new JAXBElement<String>(_Total_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SpreadOddsAway")
    public JAXBElement<String> createSpreadOddsAway(String value) {
        return new JAXBElement<String>(_SpreadOddsAway_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MatchId")
    public JAXBElement<Integer> createMatchId(Integer value) {
        return new JAXBElement<Integer>(_MatchId_QNAME, Integer.class, null, value);
    }

}
