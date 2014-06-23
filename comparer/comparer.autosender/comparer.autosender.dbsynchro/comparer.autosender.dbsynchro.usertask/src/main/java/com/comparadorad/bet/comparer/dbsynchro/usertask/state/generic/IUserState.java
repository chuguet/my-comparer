/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.state.generic;

import com.comparadorad.bet.comparer.dbsynchro.usertask.exception.StateException;

/**
 * The Interface IUserState.
 */
public interface IUserState {
	/**
	 * Creates the.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void createUserState() throws StateException;

	/**
	 * Delete.
	 * 
	 * @throws StateException
	 *             the user state exception
	 */
	void deleteUserState() throws StateException;

}
