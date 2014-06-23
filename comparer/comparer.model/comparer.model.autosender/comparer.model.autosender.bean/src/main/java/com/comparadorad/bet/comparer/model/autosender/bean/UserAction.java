/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class UserAction.
 */
@Entity
@Table(name = "USER_ACTION")
public class UserAction extends AbstractRelacional implements IAutoSender {
	
	/** The User action id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ACTION_ID")
	private Integer UserActionId;
	
	/** The log action. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private LogAction logAction;
	
	/** The user. */
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	
	/** The action type. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ActionType actionType;

	/**
	 * Gets the user action id.
	 *
	 * @return the user action id
	 */
	public Integer getUserActionId() {
		return UserActionId;
	}

	/**
	 * Sets the user action id.
	 *
	 * @param userActionId the new user action id
	 */
	public void setUserActionId(Integer userActionId) {
		UserActionId = userActionId;
	}

	/**
	 * Gets the log action.
	 *
	 * @return the log action
	 */
	public LogAction getLogAction() {
		return logAction;
	}

	/**
	 * Sets the log action.
	 *
	 * @param logAction the new log action
	 */
	public void setLogAction(LogAction logAction) {
		this.logAction = logAction;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the action type.
	 *
	 * @return the action type
	 */
	public ActionType getActionType() {
		return actionType;
	}

	/**
	 * Sets the action type.
	 *
	 * @param actionType the new action type
	 */
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

}
