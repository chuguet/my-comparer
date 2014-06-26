//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.06.28 a las 12:15:40 PM CEST 
//

package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bookmaker;

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
 *         &lt;element ref="{}line" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="vtm" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="htm" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="idgm" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="idgmtyp" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="gmtm" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="gmdt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="gpd" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "line" })
@XmlRootElement(name = "game")
public class Game {

	/** The evtyp. */
	@XmlAttribute(name = "evtyp")
	protected String evtyp;

	/** The gdesc. */
	@XmlAttribute(name = "gdesc")
	protected String gdesc;

	/** The gmdt. */
	@XmlAttribute(name = "gmdt")
	protected String gmdt;

	/** The gmtm. */
	@XmlAttribute(name = "gmtm")
	protected String gmtm;

	/** The gpd. */
	@XmlAttribute(name = "gpd")
	protected String gpd;

	/** The hnum. */
	@XmlAttribute(name = "hnum")
	protected String hnum;

	/** The hpt. */
	@XmlAttribute(name = "hpt")
	protected String hpt;

	/** The htm. */
	@XmlAttribute(name = "htm", required = true)
	protected String htm;

	/** The idgm. */
	@XmlAttribute(name = "idgm")
	protected Integer idgm;

	/** The idgmtyp. */
	@XmlAttribute(name = "idgmtyp")
	protected Integer idgmtyp;

	/** The idgp. */
	@XmlAttribute(name = "idgp")
	protected String idgp;

	/** The idlg. */
	@XmlAttribute(name = "idlg")
	protected String idlg;

	/** The idspt. */
	@XmlAttribute(name = "idspt")
	protected String idspt;

	/** The line. */
	@XmlElement(required = true)
	protected List<Line> line;

	/** The stats. */
	@XmlAttribute(name = "stats")
	protected String stats;

	/** The vnum. */
	@XmlAttribute(name = "vnum")
	protected String vnum;

	/** The vpt. */
	@XmlAttribute(name = "vpt")
	protected String vpt;

	/** The vtm. */
	@XmlAttribute(name = "vtm", required = true)
	protected String vtm;

	/**
	 * Gets the evtyp.
	 * 
	 * @return the evtyp
	 */
	public String getEvtyp() {
		return evtyp;
	}

	/**
	 * Gets the gdesc.
	 * 
	 * @return the gdesc
	 */
	public String getGdesc() {
		return gdesc;
	}

	/**
	 * Obtiene el valor de la propiedad gmdt.
	 * 
	 * @return the gmdt possible object is {@link String }
	 */
	public String getGmdt() {
		return gmdt;
	}

	/**
	 * Obtiene el valor de la propiedad gmtm.
	 * 
	 * @return the gmtm possible object is {@link String }
	 */
	public String getGmtm() {
		return gmtm;
	}

	/**
	 * Obtiene el valor de la propiedad gpd.
	 * 
	 * @return the gpd possible object is {@link String }
	 */
	public String getGpd() {
		return gpd;
	}

	/**
	 * Gets the hnum.
	 * 
	 * @return the hnum
	 */
	public String getHnum() {
		return hnum;
	}

	/**
	 * Gets the hpt.
	 * 
	 * @return the hpt
	 */
	public String getHpt() {
		return hpt;
	}

	/**
	 * Obtiene el valor de la propiedad htm.
	 * 
	 * @return the htm possible object is {@link String }
	 */
	public String getHtm() {
		return htm;
	}

	/**
	 * Obtiene el valor de la propiedad idgm.
	 * 
	 * @return the idgm possible object is {@link Integer }
	 */
	public Integer getIdgm() {
		return idgm;
	}

	/**
	 * Obtiene el valor de la propiedad idgmtyp.
	 * 
	 * @return the idgmtyp possible object is {@link Integer }
	 */
	public Integer getIdgmtyp() {
		return idgmtyp;
	}

	/**
	 * Gets the idgp.
	 * 
	 * @return the idgp
	 */
	public String getIdgp() {
		return idgp;
	}

	/**
	 * Gets the idlg.
	 * 
	 * @return the idlg
	 */
	public String getIdlg() {
		return idlg;
	}

	/**
	 * Gets the idspt.
	 * 
	 * @return the idspt
	 */
	public String getIdspt() {
		return idspt;
	}

	/**
	 * Gets the value of the line property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the line property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getLine().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * 
	 * @return the line {@link Line }
	 */
	public List<Line> getLine() {
		if (line == null) {
			line = new ArrayList<Line>();
		}
		return this.line;
	}

	/**
	 * Gets the stats.
	 * 
	 * @return the stats
	 */
	public String getStats() {
		return stats;
	}

	/**
	 * Gets the vnum.
	 * 
	 * @return the vnum
	 */
	public String getVnum() {
		return vnum;
	}

	/**
	 * Gets the vpt.
	 * 
	 * @return the vpt
	 */
	public String getVpt() {
		return vpt;
	}

	/**
	 * Obtiene el valor de la propiedad vtm.
	 * 
	 * @return the vtm possible object is {@link String }
	 */
	public String getVtm() {
		return vtm;
	}

	/**
	 * Sets the evtyp.
	 * 
	 * @param pEvtyp
	 *            the new evtyp
	 */
	public void setEvtyp(String pEvtyp) {
		evtyp = pEvtyp;
	}

	/**
	 * Sets the gdesc.
	 * 
	 * @param pGdesc
	 *            the new gdesc
	 */
	public void setGdesc(String pGdesc) {
		gdesc = pGdesc;
	}

	/**
	 * Define el valor de la propiedad gmdt.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGmdt(String value) {
		this.gmdt = value;
	}

	/**
	 * Define el valor de la propiedad gmtm.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGmtm(String value) {
		this.gmtm = value;
	}

	/**
	 * Define el valor de la propiedad gpd.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setGpd(String value) {
		this.gpd = value;
	}

	/**
	 * Sets the hnum.
	 * 
	 * @param pHnum
	 *            the new hnum
	 */
	public void setHnum(String pHnum) {
		hnum = pHnum;
	}

	/**
	 * Sets the hpt.
	 * 
	 * @param pHpt
	 *            the new hpt
	 */
	public void setHpt(String pHpt) {
		hpt = pHpt;
	}

	/**
	 * Define el valor de la propiedad htm.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setHtm(String value) {
		this.htm = value;
	}

	/**
	 * Define el valor de la propiedad idgm.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setIdgm(Integer value) {
		this.idgm = value;
	}

	/**
	 * Define el valor de la propiedad idgmtyp.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setIdgmtyp(Integer value) {
		this.idgmtyp = value;
	}

	/**
	 * Sets the idgp.
	 * 
	 * @param pIdgp
	 *            the new idgp
	 */
	public void setIdgp(String pIdgp) {
		idgp = pIdgp;
	}

	/**
	 * Sets the idlg.
	 * 
	 * @param pIdlg
	 *            the new idlg
	 */
	public void setIdlg(String pIdlg) {
		idlg = pIdlg;
	}

	/**
	 * Sets the idspt.
	 * 
	 * @param pIdspt
	 *            the new idspt
	 */
	public void setIdspt(String pIdspt) {
		idspt = pIdspt;
	}

	/**
	 * Sets the line.
	 * 
	 * @param pLine
	 *            the new line
	 */
	public void setLine(List<Line> pLine) {
		line = pLine;
	}

	/**
	 * Sets the stats.
	 * 
	 * @param pStats
	 *            the new stats
	 */
	public void setStats(String pStats) {
		stats = pStats;
	}

	/**
	 * Sets the vnum.
	 * 
	 * @param pVnum
	 *            the new vnum
	 */
	public void setVnum(String pVnum) {
		vnum = pVnum;
	}

	/**
	 * Sets the vpt.
	 * 
	 * @param pVpt
	 *            the new vpt
	 */
	public void setVpt(String pVpt) {
		vpt = pVpt;
	}

	/**
	 * Define el valor de la propiedad vtm.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVtm(String value) {
		this.vtm = value;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Game [");
		
		stringBuffer.append("idgm=");
		stringBuffer.append(idgm);
		stringBuffer.append(", gdesc=");
		stringBuffer.append(gdesc);
		stringBuffer.append(", idgmtyp=");
		stringBuffer.append(idgmtyp);
		stringBuffer.append(", gmdt=");
		stringBuffer.append(gmdt);
		stringBuffer.append(", idlg=");
		stringBuffer.append(idlg);
		stringBuffer.append(", gmtm=");
		stringBuffer.append(gmtm);
		stringBuffer.append(", idspt=");
		stringBuffer.append(idspt);
		stringBuffer.append(", vpt=");
		stringBuffer.append(vpt);
		stringBuffer.append(", hpt=");
		stringBuffer.append(hpt);
		stringBuffer.append(", vnum=");
		stringBuffer.append(vnum);
		stringBuffer.append(", hnum=");
		stringBuffer.append(hnum);
		stringBuffer.append(", evtyp=");
		stringBuffer.append(evtyp);
		stringBuffer.append(", idgp=");
		stringBuffer.append(idgp);
		stringBuffer.append(", gpd=");
		stringBuffer.append(gpd);
		stringBuffer.append(", vtm=");
		stringBuffer.append(vtm);
		stringBuffer.append(", htm=");
		stringBuffer.append(htm);
		stringBuffer.append(", stats=");
		stringBuffer.append(stats);
		
		stringBuffer.append(" ]");
		return stringBuffer.toString();
	}

}
