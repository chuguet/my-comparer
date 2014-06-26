/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import com.comparadorad.bet.comparer.model.config.bean.LongTerm;

/**
 * The Class XmlTournament.
 */
@SuppressWarnings("serial")
public class XmlTournamentEvent extends AbstractXmlData<XmlTournament> {

	/** The end date. */
	private XmlDate endDate;

	/** The long term. */
	private LongTerm longTerm;

	/** The start date. */
	private XmlDate startDate;

	/**
	 * Instantiates a new xml tournament.
	 */
	public XmlTournamentEvent() {
		super();
	}

	/**
	 * Instantiates a new xml tournament.
	 * 
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlTournamentEvent(final BmInternalId pBmInternalId) {
		super(pBmInternalId);
	}

	/**
	 * Instantiates a new xml tournament.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlTournamentEvent(final String pName) {
		super(pName);
	}

	/**
	 * Instantiates a new xml tournament.
	 * 
	 * @param pName
	 *            the name
	 * @param pBmInternalId
	 *            the bm internal id
	 */
	public XmlTournamentEvent(final String pName,
			final BmInternalId pBmInternalId) {
		super(pName, pBmInternalId);
	}

	/**
	 * Gets the end date.
	 * 
	 * @return the end date
	 */
	public XmlDate getEndDate() {
		return endDate;
	}

	/**
	 * Gets the long term.
	 * 
	 * @return the long term
	 */
	public LongTerm getLongTerm() {
		return longTerm;
	}

	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public XmlDate getStartDate() {
		return startDate;
	}

	/**
	 * Sets the end date.
	 * 
	 * @param pEndDate
	 *            the new end date
	 */
	public void setEndDate(XmlDate pEndDate) {
		endDate = pEndDate;
	}

	/**
	 * Sets the long term.
	 * 
	 * @param pLongTerm
	 *            the new long term
	 */
	public void setLongTerm(LongTerm pLongTerm) {
		longTerm = pLongTerm;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param pStartDate
	 *            the new start date
	 */
	public void setStartDate(XmlDate pStartDate) {
		startDate = pStartDate;
	}

}
