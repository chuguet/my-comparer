/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.io.Serializable;

/**
 * The Class CfgBookmakerMasterWordConfig.
 */
@SuppressWarnings("serial")
public class CfgBookmakerMasterWordConfig implements Serializable {

	/** The could create master word. */
	private Boolean couldCreateMasterWord = false;

	/** The creation priority. */
	private Integer creationPriority;

	/**
	 * Instantiates a new cfg bookmaker master word config.
	 */
	public CfgBookmakerMasterWordConfig() {
		super();

	}

	/**
	 * Instantiates a new cfg bookmaker master word config.
	 * 
	 * @param pCouldCreateMasterWord
	 *            the could create master word
	 * @param pCreationPriority
	 *            the creation priority
	 */
	public CfgBookmakerMasterWordConfig(Boolean pCouldCreateMasterWord,
			Integer pCreationPriority) {
		super();
		couldCreateMasterWord = pCouldCreateMasterWord;
		creationPriority = pCreationPriority;
	}

	/**
	 * Gets the could create master word.
	 * 
	 * @return the could create master word
	 */
	public Boolean getCouldCreateMasterWord() {
		return couldCreateMasterWord;
	}

	public boolean isCouldCreateMasterWord() {
		return couldCreateMasterWord;
	}

	/**
	 * Gets the creation priority.
	 * 
	 * @return the creation priority
	 */
	public Integer getCreationPriority() {
		return creationPriority;
	}

	/**
	 * Sets the could create master word.
	 * 
	 * @param pCouldCreateMasterWord
	 *            the new could create master word
	 */
	public void setCouldCreateMasterWord(Boolean pCouldCreateMasterWord) {
		couldCreateMasterWord = pCouldCreateMasterWord;
	}

	/**
	 * Sets the creation priority.
	 * 
	 * @param pCreationPriority
	 *            the new creation priority
	 */
	public void setCreationPriority(Integer pCreationPriority) {
		creationPriority = pCreationPriority;
	}
}
