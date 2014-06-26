//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.19 at 01:14:38 PM CET 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.nordicbet;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.nordicbet package. 
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

    private final static QName _GameStartTime_QNAME = new QName("", "GameStartTime");
    private final static QName _BettingEndTime_QNAME = new QName("", "BettingEndTime");
    private final static QName _Region_QNAME = new QName("", "Region");
    private final static QName _ExternalComment_QNAME = new QName("", "ExternalComment");
    private final static QName _Season_QNAME = new QName("", "Season");
    private final static QName _Sport_QNAME = new QName("", "Sport");
    private final static QName _LiveBet_QNAME = new QName("", "LiveBet");
    private final static QName _OptionalValue1_QNAME = new QName("", "OptionalValue1");
    private final static QName _BreadCrumbs_QNAME = new QName("", "BreadCrumbs");
    private final static QName _OptionalValue2_QNAME = new QName("", "OptionalValue2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.nordicbet
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutcomeSet }
     * 
     */
    public OutcomeSet createOutcomeSet() {
        return new OutcomeSet();
    }

    /**
     * Create an instance of {@link Outcome }
     * 
     */
    public Outcome createOutcome() {
        return new Outcome();
    }

    /**
     * Create an instance of {@link Participant }
     * 
     */
    public Participant createParticipant() {
        return new Participant();
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
    }

    /**
     * Create an instance of {@link Odds }
     * 
     */
    public Odds createOdds() {
        return new Odds();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "GameStartTime")
    public JAXBElement<String> createGameStartTime(String value) {
        return new JAXBElement<String>(_GameStartTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BettingEndTime")
    public JAXBElement<String> createBettingEndTime(String value) {
        return new JAXBElement<String>(_BettingEndTime_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Region")
    public JAXBElement<String> createRegion(String value) {
        return new JAXBElement<String>(_Region_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ExternalComment")
    public JAXBElement<String> createExternalComment(String value) {
        return new JAXBElement<String>(_ExternalComment_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Season")
    public JAXBElement<String> createSeason(String value) {
        return new JAXBElement<String>(_Season_QNAME, String.class, null, value);
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
    @XmlElementDecl(namespace = "", name = "LiveBet")
    public JAXBElement<String> createLiveBet(String value) {
        return new JAXBElement<String>(_LiveBet_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OptionalValue1")
    public JAXBElement<BigDecimal> createOptionalValue1(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OptionalValue1_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "BreadCrumbs")
    public JAXBElement<String> createBreadCrumbs(String value) {
        return new JAXBElement<String>(_BreadCrumbs_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "OptionalValue2")
    public JAXBElement<BigDecimal> createOptionalValue2(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_OptionalValue2_QNAME, BigDecimal.class, null, value);
    }

}