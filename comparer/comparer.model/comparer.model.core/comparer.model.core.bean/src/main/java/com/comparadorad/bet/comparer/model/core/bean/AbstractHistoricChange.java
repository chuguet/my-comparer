/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class AbstractHistoricChange.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class AbstractHistoricChange extends AbstractId implements
		IDocument, IModel {

	/** The historic. */
	@Field
	private IHistoric historic;

	/**
	 * Instantiates a new abstract historic change.
	 */
	public AbstractHistoricChange() {
		super();

	}

	/**
	 * Instantiates a new abstract historic change.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractHistoricChange(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new abstract historic change.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractHistoricChange(IObjectIdEnum pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new abstract historic change.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractHistoricChange(String pObjectId) {
		super(pObjectId);
	}

	/**
	 * Gets the historic.
	 * 
	 * @return the historic
	 */
	public IHistoric getHistoric() {
		return historic;
	}

	/**
	 * Sets the historic.
	 * 
	 * @param pHistoric
	 *            the new historic
	 */
	public void setHistoric(IHistoric pHistoric) {
		historic = pHistoric;
	}

	/**
	 * Sets the historic creation data.
	 * 
	 * @param pUser
	 *            the new historic creation data
	 */
	public void setHistoricCreationData(String pUser) {
		setHistoricCreationData(pUser, new Date());
	}

	public void setHistoricCreationData(String pUser, Date date) {
		if (historic == null) {
			historic = new Historic();
		}
		HistoricChange historicChange = new HistoricChange(pUser, date, true);
		historic.add(historicChange);
	}

	/**
	 * Sets the historic udate data.
	 * 
	 * @param pUser
	 *            the new historic udate data
	 */
	public void setHistoricUdateData(String pUser) {
		if (historic == null) {
			historic = new Historic();
		}
		HistoricChange historicChange = new HistoricChange(pUser, new Date(),
				false);
		historic.add(historicChange);
	}
}