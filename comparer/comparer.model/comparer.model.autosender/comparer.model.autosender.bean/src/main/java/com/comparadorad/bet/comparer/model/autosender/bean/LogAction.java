/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class LogAction.
 */
@Entity
@Table(name = "LOG_ACTION")
public class LogAction extends AbstractRelacional implements IAutoSender {

	/**
	 * The Enum isCorrect.
	 */
	public enum isCorrect {

		/** The SUCCESS. */
		SUCCESS(),
		/** The WRONG. */
		WRONG();
	};

	/** The log action id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LOG_ACTION_ID")
	private Integer logActionId;

	/** The trace. */
	@Basic
	@Column(nullable = true, length = 255, name = "TRACE")
	private String trace;

	/** The user action. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private UserAction userAction;

	/** The correct. */
	@Basic
	@Column(nullable = true, length = 30, name = "CORRECT")
	private isCorrect correct;
	
	

	/**
	 * Gets the correct.
	 *
	 * @return the correct
	 */
	public isCorrect getCorrect() {
		return correct;
	}

	/**
	 * Sets the correct.
	 *
	 * @param correct the new correct
	 */
	public void setCorrect(isCorrect correct) {
		this.correct = correct;
	}

	/**
	 * Gets the user action.
	 *
	 * @return the user action
	 */
	public UserAction getUserAction() {
		return userAction;
	}

	/**
	 * Sets the user action.
	 *
	 * @param userAction the new user action
	 */
	public void setUserAction(UserAction userAction) {
		this.userAction = userAction;
	}

	/**
	 * Gets the trace.
	 *
	 * @return the trace
	 */
	public String getTrace() {
		return trace;
	}

	/**
	 * Sets the trace.
	 *
	 * @param trace the new trace
	 */
	public void setTrace(String trace) {
		this.trace = trace;
	}

	/**
	 * Gets the log action id.
	 *
	 * @return the log action id
	 */
	public Integer getLogActionId() {
		return logActionId;
	}

	/**
	 * Sets the log action id.
	 *
	 * @param logActionId the new log action id
	 */
	public void setLogActionId(Integer logActionId) {
		this.logActionId = logActionId;
	}

	@Override
	public String toString() {
		return "LogAction [logActionId=" + logActionId + ", trace=" + trace
				+ ", userAction=" + userAction + ", correct=" + correct + "]";
	}
	
	

	// /**
	// * The Enum isCorrect.
	// */
	// public enum isCorrect {
	//
	// /** The SUCCESS. */
	// SUCCESS(),
	// /** The WRONG. */
	// WRONG();
	// };
	//
	// /** The correct. */
	// private isCorrect correct;
	//
	// /** The trace. */
	// private String trace;
	//
	// /** The user action. */
	// private UserAction userAction;

}
