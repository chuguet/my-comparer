//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: AM.02.28 a las 10:41:58 AM CET 
//

package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betfred;

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
 *             &lt;enumeration value="1st Half Under/Over 0.5 Goals"/>
 *             &lt;enumeration value="1st Half Under/Over 1.5 Goals"/>
 *             &lt;enumeration value="Clean Sheet"/>
 *             &lt;enumeration value="Correct Score"/>
 *             &lt;enumeration value="Double Chance"/>
 *             &lt;enumeration value="Double Result"/>
 *             &lt;enumeration value="Draw No Bet"/>
 *             &lt;enumeration value="First Goalscorer"/>
 *             &lt;enumeration value="H/T Betting"/>
 *             &lt;enumeration value="Last Goalscorer"/>
 *             &lt;enumeration value="Match Betting"/>
 *             &lt;enumeration value="Match Handicap"/>
 *             &lt;enumeration value="Match Handicap 2"/>
 *             &lt;enumeration value="Odd or Even Corners"/>
 *             &lt;enumeration value="Odd or Even Total Goals"/>
 *             &lt;enumeration value="Player to Score 2 or More Goals"/>
 *             &lt;enumeration value="Score 1st Goal"/>
 *             &lt;enumeration value="Score Anytime"/>
 *             &lt;enumeration value="To Score A Hat-trick"/>
 *             &lt;enumeration value="Total Goals"/>
 *             &lt;enumeration value="Under/Over 1.5"/>
 *             &lt;enumeration value="Under/Over 2.5"/>
 *             &lt;enumeration value="Under/Over 3.5"/>
 *             &lt;enumeration value="Under/Over 4.5"/>
 *             &lt;enumeration value="Which Half Most Goals"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="inrunning" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="handicap">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="-1"/>
 *             &lt;enumeration value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="bettypeid" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal">
 *             &lt;enumeration value="5750597.2"/>
 *             &lt;enumeration value="5750599.2"/>
 *             &lt;enumeration value="5750600.2"/>
 *             &lt;enumeration value="5750602.2"/>
 *             &lt;enumeration value="5750603.2"/>
 *             &lt;enumeration value="5750604.2"/>
 *             &lt;enumeration value="5750605.2"/>
 *             &lt;enumeration value="5750606.2"/>
 *             &lt;enumeration value="5750607.2"/>
 *             &lt;enumeration value="5750608.2"/>
 *             &lt;enumeration value="5750609.2"/>
 *             &lt;enumeration value="5750610.2"/>
 *             &lt;enumeration value="5750611.2"/>
 *             &lt;enumeration value="5750612.2"/>
 *             &lt;enumeration value="5750613.2"/>
 *             &lt;enumeration value="5750614.2"/>
 *             &lt;enumeration value="5750615.2"/>
 *             &lt;enumeration value="5750616.2"/>
 *             &lt;enumeration value="5750618.2"/>
 *             &lt;enumeration value="5750619.2"/>
 *             &lt;enumeration value="5750620.2"/>
 *             &lt;enumeration value="5750621.2"/>
 *             &lt;enumeration value="5750622.2"/>
 *             &lt;enumeration value="5750624.2"/>
 *             &lt;enumeration value="5750627.2"/>
 *             &lt;enumeration value="5755168.2"/>
 *             &lt;enumeration value="5755172.2"/>
 *             &lt;enumeration value="5755187.2"/>
 *             &lt;enumeration value="5755193.2"/>
 *             &lt;enumeration value="5755195.2"/>
 *             &lt;enumeration value="5755294.2"/>
 *             &lt;enumeration value="5755296.2"/>
 *             &lt;enumeration value="5755297.2"/>
 *             &lt;enumeration value="5755298.2"/>
 *             &lt;enumeration value="5755300.2"/>
 *             &lt;enumeration value="5755393.2"/>
 *             &lt;enumeration value="5755395.2"/>
 *             &lt;enumeration value="5755396.2"/>
 *             &lt;enumeration value="5755397.2"/>
 *             &lt;enumeration value="5755398.2"/>
 *             &lt;enumeration value="5755418.2"/>
 *             &lt;enumeration value="5755421.2"/>
 *             &lt;enumeration value="5755425.2"/>
 *             &lt;enumeration value="5755433.2"/>
 *             &lt;enumeration value="5755436.2"/>
 *             &lt;enumeration value="5755455.2"/>
 *             &lt;enumeration value="5755457.2"/>
 *             &lt;enumeration value="5755458.2"/>
 *             &lt;enumeration value="5755460.2"/>
 *             &lt;enumeration value="5755462.2"/>
 *             &lt;enumeration value="5755463.2"/>
 *             &lt;enumeration value="5755465.2"/>
 *             &lt;enumeration value="5755467.2"/>
 *             &lt;enumeration value="5755468.2"/>
 *             &lt;enumeration value="5755470.2"/>
 *             &lt;enumeration value="5755471.2"/>
 *             &lt;enumeration value="5755473.2"/>
 *             &lt;enumeration value="5755477.2"/>
 *             &lt;enumeration value="5755482.2"/>
 *             &lt;enumeration value="5755583.2"/>
 *             &lt;enumeration value="5755586.2"/>
 *             &lt;enumeration value="5755593.2"/>
 *             &lt;enumeration value="5755594.2"/>
 *             &lt;enumeration value="5755595.2"/>
 *             &lt;enumeration value="5755667.2"/>
 *             &lt;enumeration value="5755669.2"/>
 *             &lt;enumeration value="5755673.2"/>
 *             &lt;enumeration value="5755674.2"/>
 *             &lt;enumeration value="5755675.2"/>
 *             &lt;enumeration value="5755708.2"/>
 *             &lt;enumeration value="5755711.2"/>
 *             &lt;enumeration value="5755712.2"/>
 *             &lt;enumeration value="5755716.2"/>
 *             &lt;enumeration value="5755717.2"/>
 *             &lt;enumeration value="5755718.2"/>
 *             &lt;enumeration value="5755724.2"/>
 *             &lt;enumeration value="5755725.2"/>
 *             &lt;enumeration value="5755726.2"/>
 *             &lt;enumeration value="5755727.2"/>
 *             &lt;enumeration value="5755728.2"/>
 *             &lt;enumeration value="5755729.2"/>
 *             &lt;enumeration value="5755730.2"/>
 *             &lt;enumeration value="5755732.2"/>
 *             &lt;enumeration value="5755733.2"/>
 *             &lt;enumeration value="5755734.2"/>
 *             &lt;enumeration value="5755735.2"/>
 *             &lt;enumeration value="5755736.2"/>
 *             &lt;enumeration value="5755738.2"/>
 *             &lt;enumeration value="5755741.2"/>
 *             &lt;enumeration value="5755754.2"/>
 *             &lt;enumeration value="5755756.2"/>
 *             &lt;enumeration value="5755757.2"/>
 *             &lt;enumeration value="5755759.2"/>
 *             &lt;enumeration value="5755763.2"/>
 *             &lt;enumeration value="5755764.2"/>
 *             &lt;enumeration value="5755773.2"/>
 *             &lt;enumeration value="5755774.2"/>
 *             &lt;enumeration value="5755775.2"/>
 *             &lt;enumeration value="5755776.2"/>
 *             &lt;enumeration value="5755777.2"/>
 *             &lt;enumeration value="5755778.2"/>
 *             &lt;enumeration value="5755779.2"/>
 *             &lt;enumeration value="5755781.2"/>
 *             &lt;enumeration value="5755782.2"/>
 *             &lt;enumeration value="5755783.2"/>
 *             &lt;enumeration value="5755784.2"/>
 *             &lt;enumeration value="5755785.2"/>
 *             &lt;enumeration value="5755787.2"/>
 *             &lt;enumeration value="5755790.2"/>
 *             &lt;enumeration value="5755840.2"/>
 *             &lt;enumeration value="5755844.2"/>
 *             &lt;enumeration value="5755853.2"/>
 *             &lt;enumeration value="5755855.2"/>
 *             &lt;enumeration value="5755856.2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="bet-start-time">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;enumeration value="1100"/>
 *             &lt;enumeration value="1500"/>
 *             &lt;enumeration value="1700"/>
 *             &lt;enumeration value="1800"/>
 *             &lt;enumeration value="2000"/>
 *             &lt;enumeration value="2030"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="bet-start-date">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;enumeration value="20130301"/>
 *             &lt;enumeration value="20130302"/>
 *             &lt;enumeration value="20130303"/>
 *             &lt;enumeration value="20130304"/>
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
	@XmlAttribute(name = "suspended", required = true)
	protected boolean suspended;
	@XmlAttribute(name = "name", required = true)
	protected String name;
	@XmlAttribute(name = "inrunning", required = true)
	protected byte inrunning;
	@XmlAttribute(name = "handicap")
	protected String handicap;
	@XmlAttribute(name = "bettypeid", required = true)
	protected BigDecimal bettypeid;
	@XmlAttribute(name = "bet-start-time")
	protected Short betStartTime;
	@XmlAttribute(name = "bet-start-date")
	protected Integer betStartDate;

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
	 * Obtiene el valor de la propiedad suspended.
	 * 
	 */
	public boolean isSuspended() {
		return suspended;
	}

	/**
	 * Define el valor de la propiedad suspended.
	 * 
	 */
	public void setSuspended(boolean value) {
		this.suspended = value;
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
	 * Obtiene el valor de la propiedad inrunning.
	 * 
	 */
	public byte getInrunning() {
		return inrunning;
	}

	/**
	 * Define el valor de la propiedad inrunning.
	 * 
	 */
	public void setInrunning(byte value) {
		this.inrunning = value;
	}

	/**
	 * Obtiene el valor de la propiedad handicap.
	 * 
	 * @return possible object is {@link Byte }
	 * 
	 */
	public String getHandicap() {
		return handicap;
	}

	/**
	 * Define el valor de la propiedad handicap.
	 * 
	 * @param value
	 *            allowed object is {@link Byte }
	 * 
	 */
	public void setHandicap(String value) {
		this.handicap = value;
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
	 * Obtiene el valor de la propiedad betStartTime.
	 * 
	 * @return possible object is {@link Short }
	 * 
	 */
	public Short getBetStartTime() {
		return betStartTime;
	}

	/**
	 * Define el valor de la propiedad betStartTime.
	 * 
	 * @param value
	 *            allowed object is {@link Short }
	 * 
	 */
	public void setBetStartTime(Short value) {
		this.betStartTime = value;
	}

	/**
	 * Obtiene el valor de la propiedad betStartDate.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getBetStartDate() {
		return betStartDate;
	}

	/**
	 * Define el valor de la propiedad betStartDate.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setBetStartDate(Integer value) {
		this.betStartDate = value;
	}

}
