/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlBookmakerEvents.
 */
public class XmlBookmakerEvents extends AbstractXmlData {

	/**
	 * Sets the xml matchs.
	 * 
	 * @param xmlMatchs
	 *            the new xml matchs
	 */
	public void setXmlMatchs(Collection<XmlMatch> xmlMatchs) {
		this.xmlMatchs = xmlMatchs;
	}

	/** The file date. */
	private XmlDate fileDate;

	/** The xml bookmaker. */
	private XmlBookmaker xmlBookmaker;

	/** The xml matchs. */
	private Collection<XmlMatch> xmlMatchs;

	/**
	 * Instantiates a new xml bookmaker events.
	 */
	public XmlBookmakerEvents() {
		super();
	}

	/**
	 * Instantiates a new xml bookmaker events.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBookmakerEvents(BmInternalId pBmInternalId) {
		super(pBmInternalId);
	}

	/**
	 * Instantiates a new xml bookmaker events.
	 * 
	 * @param pFileDate
	 *            the file date
	 */
	public XmlBookmakerEvents(final Date pFileDate) {
		super();
		fileDate = new XmlDate(pFileDate);
	}

	/**
	 * Instantiates a new xml bookmaker events.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlBookmakerEvents(String pName) {
		super(pName);
	}

	/**
	 * Instantiates a new xml bookmaker events.
	 * 
	 * @param pName
	 *            the name
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBookmakerEvents(String pName, BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
	}

	/**
	 * Instantiates a new xml bookmaker events.
	 * 
	 * @param pName
	 *            the name
	 * @param pBookmaker
	 *            the bookmaker
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlBookmakerEvents(String pName, final XmlBookmaker pBookmaker,
			BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
		this.xmlBookmaker = pBookmaker;
	}

	/**
	 * Instantiates a new xml bookmaker events.
	 * 
	 * @param pFileDate
	 *            the file date
	 */
	public XmlBookmakerEvents(final XmlDate pFileDate) {
		super();
		fileDate = pFileDate;
	}

	/**
	 * Adds the xml matchs.
	 * 
	 * @param pXmlMatch
	 *            the xml match
	 */
	public void addXmlMatch(XmlMatch pXmlMatch) {
		if (this.xmlMatchs == null) {
			this.xmlMatchs = new ArrayList<XmlMatch>();
		}
		if (pXmlMatch != null) {
			pXmlMatch.setParent(this);
			this.xmlMatchs.add(pXmlMatch);
		}
	}

	/**
	 * Gets the file date.
	 * 
	 * @return the file date
	 */
	public XmlDate getFileDate() {
		return fileDate;
	}

	/**
	 * Gets the xml bookmaker.
	 * 
	 * @return the xml bookmaker
	 */
	public XmlBookmaker getXmlBookmaker() {
		return xmlBookmaker;
	}

	/**
	 * Gets the xml matchs.
	 * 
	 * @return the xml matchs
	 */
	public Collection<XmlMatch> getXmlMatchs() {
		if (xmlMatchs == null) {
			xmlMatchs = new ArrayList<XmlMatch>();
		}
		return xmlMatchs;
	}

	/**
	 * Sets the file date.
	 * 
	 * @param pFileDate
	 *            the new file date
	 */
	public void setFileDate(XmlDate pFileDate) {
		fileDate = pFileDate;
	}

	/**
	 * Sets the xml bookmaker.
	 * 
	 * @param pXmlBookmaker
	 *            the new xml bookmaker
	 */
	public void setXmlBookmaker(XmlBookmaker pXmlBookmaker) {
		xmlBookmaker = pXmlBookmaker;
	}
}
