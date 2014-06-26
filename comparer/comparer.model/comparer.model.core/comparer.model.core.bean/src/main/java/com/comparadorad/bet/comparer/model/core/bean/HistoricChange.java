/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class HistoricChangeData.
 */
@SuppressWarnings("serial")
public class HistoricChange implements IHistoricChange, Serializable {

	/** The creation action. */
	@Field
	private boolean creationAction = false;

	/** The data. */
	@Field
	private Object data;

	/** The data ref. */
	@DBRef
	private Object dataRef;

	/** The date. */
	@Field
	private Date date;

	/** The user. */
	@Field
	private String user;

	/**
	 * Instantiates a new historic change.
	 */
	public HistoricChange() {
		super();
	}

	/**
	 * Instantiates a new historic change.
	 * 
	 * @param pUser
	 *            the user
	 * @param pDate
	 *            the date
	 * @param pCreationAction
	 *            the creation action
	 */
	public HistoricChange(String pUser, Date pDate, boolean pCreationAction) {
		super();
		user = pUser;
		date = pDate;
		creationAction = pCreationAction;
	}

	/**
	 * Instantiates a new historic change.
	 * 
	 * @param pUser
	 *            the user
	 * @param pDate
	 *            the date
	 * @param pData
	 *            the data
	 * @param pCreationAction
	 *            the creation action
	 */
	public HistoricChange(String pUser, Date pDate, Object pData,
			boolean pCreationAction) {
		super();
		user = pUser;
		date = pDate;
		data = pData;
		creationAction = pCreationAction;
	}

	/**
	 * Gets the data.
	 * 
	 * @return the data {@inheritDoc}
	 */
	@Override
	public Object getData() {
		return data;
	}

	/** {@inheritDoc} */
	@Override
	public Object getDataRef() {
		return dataRef;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date {@inheritDoc}
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user {@inheritDoc}
	 */
	@Override
	public String getUser() {
		return user;
	}

	/**
	 * Checks if is creation action.
	 * 
	 * @return true, if is creation action {@inheritDoc}
	 */
	@Override
	public boolean isCreationAction() {
		return creationAction;
	}

	/**
	 * Sets the creation action.
	 * 
	 * @param pCreationAction
	 *            the new creation action {@inheritDoc}
	 */
	@Override
	public void setCreationAction(boolean pCreationAction) {
		creationAction = pCreationAction;
	}

	/**
	 * Sets the data.
	 * 
	 * @param pData
	 *            the new data {@inheritDoc}
	 */
	@Override
	public void setData(Object pData) {
		data = pData;
	}

	/** {@inheritDoc} */
	@Override
	public void setDataRef(Object pDataRef) {
		dataRef = pDataRef;
	}

	/**
	 * Sets the date.
	 * 
	 * @param pDate
	 *            the new date {@inheritDoc}
	 */
	@Override
	public void setDate(final Date pDate) {
		this.date = pDate;
	}

	/**
	 * Sets the user.
	 * 
	 * @param pUser
	 *            the new user {@inheritDoc}
	 */
	@Override
	public void setUser(final String pUser) {
		this.user = pUser;
	}

}
