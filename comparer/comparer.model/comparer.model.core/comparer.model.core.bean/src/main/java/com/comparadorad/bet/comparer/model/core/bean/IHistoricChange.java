/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.util.Date;

/**
 * The Interface IHistoricChangeData.
 */
public interface IHistoricChange {

	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	Object getData();

	/**
	 * Gets the data ref.
	 * 
	 * @return the data ref
	 */
	Object getDataRef();

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	Date getDate();

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	String getUser();

	/**
	 * Checks if is creation action.
	 * 
	 * @return true, if is creation action
	 */
	boolean isCreationAction();

	/**
	 * Sets the creation action.
	 * 
	 * @param isCreationAction
	 *            the new creation action
	 */
	void setCreationAction(boolean isCreationAction);

	/**
	 * Sets the data.
	 * 
	 * @param pData
	 *            the new data
	 */
	void setData(Object pData);

	/**
	 * Sets the data ref.
	 * 
	 * @param pDataRef
	 *            the new data ref
	 */
	void setDataRef(Object pDataRef);

	/**
	 * Sets the date.
	 * 
	 * @param pDate
	 *            the new date
	 */
	void setDate(final Date pDate);

	/**
	 * Sets the user.
	 * 
	 * @param pUser
	 *            the new user
	 */
	void setUser(final String pUser);
}
