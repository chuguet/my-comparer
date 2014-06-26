/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class AbstractHistoricChange.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class AbstractDocumentFieldHistoricChange implements
		IDocumentField {

	/** The historic. */
	@Field
	private IHistoric historic;

	/**
	 * Instantiates a new abstract historic change.
	 */
	public AbstractDocumentFieldHistoricChange() {
		super();

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
		setHistoricCreationData(pUser, null);
	}

	/**
	 * Sets the historic creation data.
	 * 
	 * @param pUser
	 *            the user
	 * @param data
	 *            the data
	 */
	public void setHistoricCreationData(String pUser, Object data) {
		if (historic == null) {
			historic = new Historic();
		}
		HistoricChange historicChange = new HistoricChange(pUser, new Date(),
				data, true);
		historic.add(historicChange);
	}

	/**
	 * Sets the historic udate data.
	 * 
	 * @param pUser
	 *            the new historic udate data
	 */
	public void setHistoricUpdateData(String pUser) {
		setHistoricUpdateData(pUser, null);
	}

	/**
	 * Sets the historic update data.
	 * 
	 * @param pUser
	 *            the user
	 * @param data
	 *            the data
	 */
	public void setHistoricUpdateData(String pUser, Object data) {
		if (historic == null) {
			historic = new Historic();
		}
		HistoricChange historicChange = new HistoricChange(pUser, new Date(),
				data, false);
		historic.add(historicChange);

	}
}