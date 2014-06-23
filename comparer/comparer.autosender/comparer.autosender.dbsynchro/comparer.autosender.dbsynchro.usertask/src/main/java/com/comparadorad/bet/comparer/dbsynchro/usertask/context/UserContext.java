/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.dbsynchro.usertask.context;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.dbsynchro.usertask.state.IState;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
import com.comparadorad.bet.comparer.model.autosender.bean.User;

/**
 * The Class UserContext.
 */
@Service
public class UserContext implements IUserContext {

	/** The action to execute. */
	private Integer actionToExecute;

	@Inject
	private List<IState> states;

	/** The user. */
	private User user;

	private IState state;

	/**
	 * Gets the user.
	 * 
	 * @return the user {@inheritDoc}
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 * 
	 * @param pUser
	 *            the new user {@inheritDoc}
	 */
	public void setUser(User pUser) {
		this.user = pUser;
	}

	/**
	 * Inits the.
	 */
	@PostConstruct
	public void init() {
		for (IState userState : states) {
			userState.setUserContext(this);
		}
		setStateByActionTypeName(null);
	}

	/**
	 * Gets the user state.
	 * 
	 * @param actionTypeName
	 *            the action type name
	 * @return the user state
	 */
	@Override
	public void setStateByActionTypeName(ActionTypeName actionTypeName) {
		IState userStateTmp = null;
		for (IState actualState : states) {
			if (actualState.getActionType() != null
					&& actualState.getActionType().equals(actionTypeName)) {
				userStateTmp = actualState;
				break;
			} else if (actualState.getActionType() == null) {
				userStateTmp = actualState;
			}
		}
		this.state = userStateTmp;

	}

	/**
	 * Gets the action to execute.
	 * 
	 * @return the action to execute {@inheritDoc}
	 */
	@Override
	public Integer getActionToExecute() {
		return this.actionToExecute;
	}

	/**
	 * Sets the action to execute.
	 * 
	 * @param action
	 *            the new action to execute {@inheritDoc}
	 */
	@Override
	public void setActionToExecute(Integer action) {
		this.actionToExecute = action;
	}

	@Override
	public IState getUserState() {
		return state;
	}

}
