/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class XMLMatchWinnerAttribute.
 */
@Component
@SuppressWarnings("serial")
public class XmlMatchWinnerAttribute extends AbstractXMLAttribute {

	/** The cfg bet type id. */
	private String cfgBetTypeId;

	/** The result. */
	private Result result;

	/** The winner name. */
	private XmlMatchParticipant winnerName;

	/**
	 * Instantiates a new xml match winner attribute.
	 */
	public XmlMatchWinnerAttribute() {
		super();
		this.cfgBetTypeId = CfgBetTypeId.GANADOR_PARTIDO.nameId();
	}

	/**
	 * Instantiates a new xml match winner attribute.
	 * 
	 * @param result
	 *            the result
	 * @param participant
	 *            the participant
	 */
	public XmlMatchWinnerAttribute(Result result,
			XmlMatchParticipant participant) {
		super();
		this.result = result;
		this.winnerName = participant;
		this.cfgBetTypeId = CfgBetTypeId.GANADOR_PARTIDO.nameId();
	}

	/**
	 * Gets the cfg bet type id.
	 * 
	 * @return the cfg bet type id
	 */
	public String getCfgBetTypeId() {
		return cfgBetTypeId;
	}

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * Gets the winner name.
	 * 
	 * @return the winner name
	 */
	public XmlMatchParticipant getWinnerName() {
		return winnerName;
	}

	/**
	 * Sets the result.
	 * 
	 * @param pResult
	 *            the new result
	 */
	public void setResult(Result pResult) {
		result = pResult;
	}

	/**
	 * Sets the winner name.
	 * 
	 * @param pWinnerName
	 *            the new winner name
	 */
	public void setWinnerName(XmlMatchParticipant pWinnerName) {
		winnerName = pWinnerName;
	}

}
