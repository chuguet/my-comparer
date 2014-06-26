/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import com.comparadorad.bet.comparer.model.core.bean.ObjectState.ObjectStateEnum;

/**
 * The Interface IObjectStateContainer.
 */
public interface IObjectStateContainer {

	/**
	 * Gets the object state.
	 * 
	 * @return the object state
	 */
	ObjectState getObjectState();

	/**
	 * Checks if is updated.
	 * 
	 * @return true, if is updated
	 */
	boolean isUpdated();

	/**
	 * Sets the object state.
	 * 
	 * @param pObjectState
	 *            the new object state
	 */
	void setObjectState(ObjectStateEnum pObjectState);

	/**
	 * Sets the updated.
	 * 
	 * @param pUpdated
	 *            the new updated
	 */
	void setUpdated(boolean pUpdated);
}
