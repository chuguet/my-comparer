/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.state;

import com.comparadorad.bet.comparer.dbsynchro.usertask.context.IUserContext;
import com.comparadorad.bet.comparer.dbsynchro.usertask.state.generic.IContentState;
import com.comparadorad.bet.comparer.dbsynchro.usertask.state.generic.ILiferayState;
import com.comparadorad.bet.comparer.dbsynchro.usertask.state.generic.IPaymentState;
import com.comparadorad.bet.comparer.dbsynchro.usertask.state.generic.IRefererState;
import com.comparadorad.bet.comparer.dbsynchro.usertask.state.generic.IUserState;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;

/**
 * The Interface IState.
 */
public interface IState extends IContentState, IUserState, IPaymentState,
		IRefererState, ILiferayState {
	/**
	 * Gets the action type.
	 * 
	 * @return the action type
	 */
	ActionType.ActionTypeName getActionType();

	/**
	 * Gets the user context.
	 * 
	 * @return the user context
	 */
	IUserContext getUserContext();

	/**
	 * Sets the user context.
	 * 
	 * @param userContext
	 *            the new user context
	 */
	void setUserContext(IUserContext userContext);

}
