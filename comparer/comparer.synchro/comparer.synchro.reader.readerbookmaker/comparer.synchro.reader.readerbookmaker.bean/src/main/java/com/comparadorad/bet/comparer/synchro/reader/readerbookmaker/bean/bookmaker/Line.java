//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.28 a las 12:15:40 PM CEST 
//

package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bookmaker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;/sequence>
 *       &lt;attribute name="hoddst" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="voddst" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vspoddst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="hsprdt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vsprdt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="hsprdoddst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ovt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="unt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ovoddst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="unoddst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="vsprdoddst" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "line")
public class Line {

	/** The hoddst. */
	@XmlAttribute(name = "hoddst", required = true)
	protected String hoddst;

	/** The hspoddst. */
	@XmlAttribute(name = "hspoddst")
	protected String hspoddst;

	/** The hsprdoddst. */
	@XmlAttribute(name = "hsprdoddst")
	protected String hsprdoddst;

	/** The hsprdt. */
	@XmlAttribute(name = "hsprdt")
	protected String hsprdt;

	/** The odds. */
	@XmlAttribute(name = "odds")
	protected String odds;

	/** The oddsh. */
	@XmlAttribute(name = "oddsh")
	protected String oddsh;

	/** The ovoddst. */
	@XmlAttribute(name = "ovoddst")
	protected String ovoddst;

	/** The ovt. */
	@XmlAttribute(name = "ovt")
	protected String ovt;

	/** The tmname. */
	@XmlAttribute(name = "tmname")
	protected String tmname;

	/** The unoddst. */
	@XmlAttribute(name = "unoddst")
	protected String unoddst;

	/** The unt. */
	@XmlAttribute(name = "unt")
	protected String unt;

	/** The voddst. */
	@XmlAttribute(name = "voddst", required = true)
	protected String voddst;

	/** The vspoddst. */
	@XmlAttribute(name = "vspoddst")
	protected String vspoddst;

	/** The vsprdoddst. */
	@XmlAttribute(name = "vsprdoddst")
	protected String vsprdoddst;

	/** The vsprdt. */
	@XmlAttribute(name = "vsprdt")
	protected String vsprdt;

	/**
	 * Gets the hoddst.
	 * 
	 * @return the hoddst
	 */
	public String getHoddst() {
		return hoddst;
	}

	/**
	 * Gets the hspoddst.
	 * 
	 * @return the hspoddst
	 */
	public String getHspoddst() {
		return hspoddst;
	}

	/**
	 * Obtiene el valor de la propiedad hsprdoddst.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHsprdoddst() {
		return hsprdoddst;
	}

	/**
	 * Obtiene el valor de la propiedad hsprdt.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getHsprdt() {
		return hsprdt;
	}

	/**
	 * Gets the odds.
	 * 
	 * @return the odds
	 */
	public String getOdds() {
		return odds;
	}

	/**
	 * Obtiene el valor de la propiedad hoddst.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOddsh() {
		return oddsh;
	}

	/**
	 * Obtiene el valor de la propiedad ovoddst.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOvoddst() {
		return ovoddst;
	}

	/**
	 * Obtiene el valor de la propiedad ovt.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOvt() {
		return ovt;
	}

	/**
	 * Gets the tmname.
	 * 
	 * @return the tmname
	 */
	public String getTmname() {
		return tmname;
	}

	/**
	 * Obtiene el valor de la propiedad unoddst.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUnoddst() {
		return unoddst;
	}

	/**
	 * Obtiene el valor de la propiedad unt.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUnt() {
		return unt;
	}

	/**
	 * Obtiene el valor de la propiedad voddst.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVoddst() {
		return voddst;
	}

	/**
	 * Obtiene el valor de la propiedad vspoddst.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVspoddst() {
		return vspoddst;
	}

	/**
	 * Obtiene el valor de la propiedad vsprdoddst.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVsprdoddst() {
		return vsprdoddst;
	}

	/**
	 * Obtiene el valor de la propiedad vsprdt.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVsprdt() {
		return vsprdt;
	}

	/**
	 * Define el valor de la propiedad hoddst.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHoddst(String value) {
		this.hoddst = value;
	}

	/**
	 * Sets the hspoddst.
	 * 
	 * @param pHspoddst
	 *            the new hspoddst
	 */
	public void setHspoddst(String pHspoddst) {
		hspoddst = pHspoddst;
	}

	/**
	 * Define el valor de la propiedad hsprdoddst.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHsprdoddst(String value) {
		this.hsprdoddst = value;
	}

	/**
	 * Define el valor de la propiedad hsprdt.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHsprdt(String value) {
		this.hsprdt = value;
	}

	/**
	 * Sets the odds.
	 * 
	 * @param value
	 *            the new odds
	 */
	public void setOdds(String value) {
		this.odds = value;
	}

	/**
	 * Sets the oddsh.
	 * 
	 * @param value
	 *            the new oddsh
	 */
	public void setOddsh(String value) {
		this.oddsh = value;
	}

	/**
	 * Define el valor de la propiedad ovoddst.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOvoddst(String value) {
		this.ovoddst = value;
	}

	/**
	 * Define el valor de la propiedad ovt.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOvt(String value) {
		this.ovt = value;
	}

	/**
	 * Sets the tmname.
	 * 
	 * @param value
	 *            the new tmname
	 */
	public void setTmname(String value) {
		this.tmname = value;
	}

	/**
	 * Define el valor de la propiedad unoddst.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUnoddst(String value) {
		this.unoddst = value;
	}

	/**
	 * Define el valor de la propiedad unt.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setUnt(String value) {
		this.unt = value;
	}

	/**
	 * Define el valor de la propiedad voddst.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVoddst(String value) {
		this.voddst = value;
	}

	/**
	 * Define el valor de la propiedad vspoddst.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVspoddst(String value) {
		this.vspoddst = value;
	}

	/**
	 * Define el valor de la propiedad vsprdoddst.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVsprdoddst(String value) {
		this.vsprdoddst = value;
	}

	/**
	 * Define el valor de la propiedad vsprdt.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVsprdt(String value) {
		this.vsprdt = value;
	}

}
