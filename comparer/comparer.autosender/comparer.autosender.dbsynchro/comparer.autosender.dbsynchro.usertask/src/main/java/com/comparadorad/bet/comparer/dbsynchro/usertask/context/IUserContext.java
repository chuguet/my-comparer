/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.context;

import com.comparadorad.bet.comparer.dbsynchro.usertask.state.IState;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
import com.comparadorad.bet.comparer.model.autosender.bean.User;

/**
 * The Interface IUserContext.
 */
public interface IUserContext {

	/**
	 * Gets the action to execute.
	 * 
	 * @return the action to execute
	 */
	Integer getActionToExecute();

	/**
	 * Gets the user dto.
	 * 
	 * @return the user dto
	 */
	User getUser();

	/**
	 * Gets the user state.
	 * 
	 * @return the user state
	 */
	IState getUserState();

	/**
	 * Sets the action to execute.
	 * 
	 * @param action
	 *            the new action to execute
	 */
	void setActionToExecute(Integer action);

	/**
	 * Sets the user dto.
	 * 
	 * @param user
	 *            the new user
	 */
	void setUser(User user);

	/**
	 * Sets the user state by action type name.
	 * 
	 * @param actionTypeName
	 *            the new user state by action type name
	 */
	void setStateByActionTypeName(ActionTypeName actionTypeName);

}
