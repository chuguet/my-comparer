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
 * The Interface ILiferayState.
 */
public interface ILiferayState {

	/**
	 * Change roles.
	 * 
	 * @throws StateException
	 *             the state exception
	 */
	void changeRoles() throws StateException;

}
