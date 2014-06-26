//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.04 a las 04:59:13 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline package. 
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

    private final static QName _Drawrotnum_QNAME = new QName("", "drawrotnum");
    private final static QName _PeriodStatus_QNAME = new QName("", "period_status");
    private final static QName _SpreadAdjustHome_QNAME = new QName("", "spread_adjust_home");
    private final static QName _VisitingHomeDraw_QNAME = new QName("", "visiting_home_draw");
    private final static QName _SpreadAdjustVisiting_QNAME = new QName("", "spread_adjust_visiting");
    private final static QName _Drawmoneyline_QNAME = new QName("", "drawmoneyline");
    private final static QName _League_QNAME = new QName("", "league");
    private final static QName _SpreadVisiting_QNAME = new QName("", "spread_visiting");
    private final static QName _EventDatetimeGMT_QNAME = new QName("", "event_datetimeGMT");
    private final static QName _UnderAdjust_QNAME = new QName("", "under_adjust");
    private final static QName _Scheduletext_QNAME = new QName("", "scheduletext");
    private final static QName _OverAdjust_QNAME = new QName("", "over_adjust");
    private final static QName _ParticipantName_QNAME = new QName("", "participant_name");
    private final static QName _Moneyline_QNAME = new QName("", "moneyline");
    private final static QName _SpreadHome_QNAME = new QName("", "spread_home");
    private final static QName _Rotnum_QNAME = new QName("", "rotnum");
    private final static QName _TotalPoints_QNAME = new QName("", "total_points");
    private final static QName _PeriodDescription_QNAME = new QName("", "period_description");
    private final static QName _Sporttype_QNAME = new QName("", "sporttype");
    private final static QName _PeriodcutoffDatetimeGMT_QNAME = new QName("", "periodcutoff_datetimeGMT");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betonline
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Total }
     * 
     */
    public Total createTotal() {
        return new Total();
    }

    /**
     * Create an instance of {@link Pitcher }
     * 
     */
    public Pitcher createPitcher() {
        return new Pitcher();
    }

    /**
     * Create an instance of {@link Odds }
     * 
     */
    public Odds createOdds() {
        return new Odds();
    }

    /**
     * Create an instance of {@link BestlinesportsLineFeed }
     * 
     */
    public BestlinesportsLineFeed createBestlinesportsLineFeed() {
        return new BestlinesportsLineFeed();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link Participant }
     * 
     */
    public Participant createParticipant() {
        return new Participant();
    }

    /**
     * Create an instance of {@link DrawTitle }
     * 
     */
    public DrawTitle createDrawTitle() {
        return new DrawTitle();
    }

    /**
     * Create an instance of {@link Period }
     * 
     */
    public Period createPeriod() {
        return new Period();
    }

    /**
     * Create an instance of {@link Spread }
     * 
     */
    public Spread createSpread() {
        return new Spread();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "drawrotnum")
    public JAXBElement<String> createDrawrotnum(String value) {
        return new JAXBElement<String>(_Drawrotnum_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "period_status")
    public JAXBElement<String> createPeriodStatus(String value) {
        return new JAXBElement<String>(_PeriodStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "spread_adjust_home")
    public JAXBElement<String> createSpreadAdjustHome(String value) {
        return new JAXBElement<String>(_SpreadAdjustHome_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "visiting_home_draw")
    public JAXBElement<String> createVisitingHomeDraw(String value) {
        return new JAXBElement<String>(_VisitingHomeDraw_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "spread_adjust_visiting")
    public JAXBElement<String> createSpreadAdjustVisiting(String value) {
        return new JAXBElement<String>(_SpreadAdjustVisiting_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "drawmoneyline")
    public JAXBElement<String> createDrawmoneyline(String value) {
        return new JAXBElement<String>(_Drawmoneyline_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "league")
    public JAXBElement<String> createLeague(String value) {
        return new JAXBElement<String>(_League_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "spread_visiting")
    public JAXBElement<String> createSpreadVisiting(String value) {
        return new JAXBElement<String>(_SpreadVisiting_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "event_datetimeGMT")
    public JAXBElement<String> createEventDatetimeGMT(String value) {
        return new JAXBElement<String>(_EventDatetimeGMT_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "under_adjust")
    public JAXBElement<String> createUnderAdjust(String value) {
        return new JAXBElement<String>(_UnderAdjust_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "scheduletext")
    public JAXBElement<String> createScheduletext(String value) {
        return new JAXBElement<String>(_Scheduletext_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "over_adjust")
    public JAXBElement<String> createOverAdjust(String value) {
        return new JAXBElement<String>(_OverAdjust_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "participant_name")
    public JAXBElement<String> createParticipantName(String value) {
        return new JAXBElement<String>(_ParticipantName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "moneyline")
    public JAXBElement<String> createMoneyline(String value) {
        return new JAXBElement<String>(_Moneyline_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "spread_home")
    public JAXBElement<String> createSpreadHome(String value) {
        return new JAXBElement<String>(_SpreadHome_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rotnum")
    public JAXBElement<String> createRotnum(String value) {
        return new JAXBElement<String>(_Rotnum_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "total_points")
    public JAXBElement<String> createTotalPoints(String value) {
        return new JAXBElement<String>(_TotalPoints_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "period_description")
    public JAXBElement<String> createPeriodDescription(String value) {
        return new JAXBElement<String>(_PeriodDescription_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sporttype")
    public JAXBElement<String> createSporttype(String value) {
        return new JAXBElement<String>(_Sporttype_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "periodcutoff_datetimeGMT")
    public JAXBElement<String> createPeriodcutoffDatetimeGMT(String value) {
        return new JAXBElement<String>(_PeriodcutoffDatetimeGMT_QNAME, String.class, null, value);
    }

}
