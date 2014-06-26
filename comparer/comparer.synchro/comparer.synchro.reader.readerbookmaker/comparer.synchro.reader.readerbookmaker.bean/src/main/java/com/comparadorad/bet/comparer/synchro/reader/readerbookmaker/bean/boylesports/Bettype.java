//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.02.26 a las 06:04:59 PM CET 
//

package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.boylesports;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para anonymous complex type.
 * 
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}bet" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="suspended" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="name" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Betting W/O Celtic"/>
 *             &lt;enumeration value="Betting W/O Rangers"/>
 *             &lt;enumeration value="Betting w/o Man City &amp; Man Utd"/>
 *             &lt;enumeration value="Competition Outright"/>
 *             &lt;enumeration value="Group A Winner"/>
 *             &lt;enumeration value="Group B Winner"/>
 *             &lt;enumeration value="Group C Winner"/>
 *             &lt;enumeration value="Group D Winner"/>
 *             &lt;enumeration value="Group E Winner"/>
 *             &lt;enumeration value="Group F Winner"/>
 *             &lt;enumeration value="Group G Winner"/>
 *             &lt;enumeration value="Group H Winner"/>
 *             &lt;enumeration value="Group I Betting"/>
 *             &lt;enumeration value="Man Utd Trophies"/>
 *             &lt;enumeration value="Most Assists"/>
 *             &lt;enumeration value="Outright Betting"/>
 *             &lt;enumeration value="Straight Forcast"/>
 *             &lt;enumeration value="Thursday's TV Treats"/>
 *             &lt;enumeration value="To Be Relegated"/>
 *             &lt;enumeration value="To Finish Bottom"/>
 *             &lt;enumeration value="To Qualify For Next Round"/>
 *             &lt;enumeration value="Top 4 Finish"/>
 *             &lt;enumeration value="Top 6 Finish"/>
 *             &lt;enumeration value="Top Goalscorer"/>
 *             &lt;enumeration value="Top London Club"/>
 *             &lt;enumeration value="Top Midlands Club"/>
 *             &lt;enumeration value="Top Promoted Club"/>
 *             &lt;enumeration value="Wednesday's 'Good Things'"/>
 *             &lt;enumeration value="Without The Big 6"/>
 *             &lt;enumeration value="World Cup 2014 Winner"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="inrunning" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="-1"/>
 *             &lt;enumeration value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ewreduction">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="3"/>
 *             &lt;enumeration value="4"/>
 *             &lt;enumeration value="5"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ewplaceterms">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="3"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="eachway">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="1/2 Odds Place 1,2"/>
 *             &lt;enumeration value="1/3 Odds Place 1,2"/>
 *             &lt;enumeration value="1/4 Odds Place 1,2"/>
 *             &lt;enumeration value="1/4 Odds Place 1,2,3"/>
 *             &lt;enumeration value="1/5 Odds Place 1,2,3"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="bettypeid" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="3059656.1"/>
 *             &lt;enumeration value="4982438.1"/>
 *             &lt;enumeration value="4982439.1"/>
 *             &lt;enumeration value="4982440.1"/>
 *             &lt;enumeration value="4982441.1"/>
 *             &lt;enumeration value="4982442.1"/>
 *             &lt;enumeration value="4982443.1"/>
 *             &lt;enumeration value="4982444.1"/>
 *             &lt;enumeration value="4982445.1"/>
 *             &lt;enumeration value="4982446.1"/>
 *             &lt;enumeration value="7217432.1"/>
 *             &lt;enumeration value="7398591.1"/>
 *             &lt;enumeration value="7398592.1"/>
 *             &lt;enumeration value="7398599.1"/>
 *             &lt;enumeration value="7398613.1"/>
 *             &lt;enumeration value="7398616.1"/>
 *             &lt;enumeration value="7402543.1"/>
 *             &lt;enumeration value="7402657.1"/>
 *             &lt;enumeration value="7402677.1"/>
 *             &lt;enumeration value="7402938.1"/>
 *             &lt;enumeration value="7403223.1"/>
 *             &lt;enumeration value="7454021.1"/>
 *             &lt;enumeration value="7454031.1"/>
 *             &lt;enumeration value="7454032.1"/>
 *             &lt;enumeration value="7454034.1"/>
 *             &lt;enumeration value="7454201.1"/>
 *             &lt;enumeration value="7454203.1"/>
 *             &lt;enumeration value="7454242.1"/>
 *             &lt;enumeration value="7462682.1"/>
 *             &lt;enumeration value="7463580.1"/>
 *             &lt;enumeration value="7496379.1"/>
 *             &lt;enumeration value="7571712.1"/>
 *             &lt;enumeration value="7621887.1"/>
 *             &lt;enumeration value="7621996.1"/>
 *             &lt;enumeration value="7630971.1"/>
 *             &lt;enumeration value="7720375.1"/>
 *             &lt;enumeration value="7822210.1"/>
 *             &lt;enumeration value="7827064.1"/>
 *             &lt;enumeration value="8128390.1"/>
 *             &lt;enumeration value="8129447.1"/>
 *             &lt;enumeration value="8130356.1"/>
 *             &lt;enumeration value="8166123.1"/>
 *             &lt;enumeration value="8559983.1"/>
 *             &lt;enumeration value="8863962.1"/>
 *             &lt;enumeration value="9053665.1"/>
 *             &lt;enumeration value="9503298.1"/>
 *             &lt;enumeration value="9506415.1"/>
 *             &lt;enumeration value="9506416.1"/>
 *             &lt;enumeration value="9542819.1"/>
 *             &lt;enumeration value="9745326.1"/>
 *             &lt;enumeration value="9784452.1"/>
 *             &lt;enumeration value="9784454.1"/>
 *             &lt;enumeration value="9839474.1"/>
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
@XmlType(name = "", propOrder = { "bet" })
@XmlRootElement(name = "bettype")
public class Bettype {

	@XmlElement(required = true)
	protected List<Bet> bet;
	@XmlAttribute(name = "bettypeid", required = true)
	protected BigDecimal bettypeid;
	@XmlAttribute(name = "eachway")
	protected String eachway;
	@XmlAttribute(name = "ewplaceterms")
	protected Byte ewplaceterms;
	@XmlAttribute(name = "ewreduction")
	protected Byte ewreduction;
	@XmlAttribute(name = "handicap", required = true)
	protected Double handicap;
	@XmlAttribute(name = "inrunning", required = true)
	protected byte inrunning;
	@XmlAttribute(name = "name", required = true)
	protected String name;
	@XmlAttribute(name = "suspended", required = true)
	protected boolean suspended;

	/**
	 * Gets the value of the bet property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the bet property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getBet().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Bet }
	 * 
	 * 
	 */
	public List<Bet> getBet() {
		if (bet == null) {
			bet = new ArrayList<Bet>();
		}
		return this.bet;
	}

	/**
	 * Obtiene el valor de la propiedad bettypeid.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getBettypeid() {
		return bettypeid;
	}

	/**
	 * Obtiene el valor de la propiedad eachway.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEachway() {
		return eachway;
	}

	/**
	 * Obtiene el valor de la propiedad ewplaceterms.
	 * 
	 * @return possible object is {@link Byte }
	 * 
	 */
	public Byte getEwplaceterms() {
		return ewplaceterms;
	}

	/**
	 * Obtiene el valor de la propiedad ewreduction.
	 * 
	 * @return possible object is {@link Byte }
	 * 
	 */
	public Byte getEwreduction() {
		return ewreduction;
	}

	public Double getHandicap() {
		return handicap;
	}

	/**
	 * Obtiene el valor de la propiedad inrunning.
	 * 
	 */
	public byte getInrunning() {
		return inrunning;
	}

	/**
	 * Obtiene el valor de la propiedad name.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getName() {
		return name;
	}

	/**
	 * Obtiene el valor de la propiedad suspended.
	 * 
	 */
	public boolean isSuspended() {
		return suspended;
	}

	/**
	 * Define el valor de la propiedad bettypeid.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setBettypeid(BigDecimal value) {
		this.bettypeid = value;
	}

	/**
	 * Define el valor de la propiedad eachway.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setEachway(String value) {
		this.eachway = value;
	}

	/**
	 * Define el valor de la propiedad ewplaceterms.
	 * 
	 * @param value
	 *            allowed object is {@link Byte }
	 * 
	 */
	public void setEwplaceterms(Byte value) {
		this.ewplaceterms = value;
	}

	/**
	 * Define el valor de la propiedad ewreduction.
	 * 
	 * @param value
	 *            allowed object is {@link Byte }
	 * 
	 */
	public void setEwreduction(Byte value) {
		this.ewreduction = value;
	}

	public void setHandicap(Double handicap) {
		this.handicap = handicap;
	}

	/**
	 * Define el valor de la propiedad inrunning.
	 * 
	 */
	public void setInrunning(byte value) {
		this.inrunning = value;
	}

	/**
	 * Define el valor de la propiedad name.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setName(String value) {
		this.name = value;
	}

	/**
	 * Define el valor de la propiedad suspended.
	 * 
	 */
	public void setSuspended(boolean value) {
		this.suspended = value;
	}

}
