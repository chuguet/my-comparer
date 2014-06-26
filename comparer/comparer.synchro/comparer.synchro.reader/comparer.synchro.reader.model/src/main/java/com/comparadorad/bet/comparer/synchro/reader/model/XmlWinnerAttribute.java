/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class XMLWinnerAttribute.
 */
@Component
@SuppressWarnings("serial")
public class XmlWinnerAttribute extends AbstractXMLAttribute {

	/** The cfg bet type id. */
	private String cfgBetTypeId;

	/** The winner. */
	private XmlMatchParticipant winner;

	/**
	 * Instantiates a new xml winner attribute.
	 */
	public XmlWinnerAttribute() {
		super();
		this.cfgBetTypeId = CfgBetTypeId.GANADOR.nameId();
	}
	
	public XmlWinnerAttribute(XmlMatchParticipant participant) {
		super();
		this.winner = participant;
		this.cfgBetTypeId = CfgBetTypeId.GANADOR.nameId();
	}

	/**
	 * Gets the winner.
	 * 
	 * @return the winner
	 */
	public XmlMatchParticipant getWinner() {
		return winner;
	}

	/**
	 * Sets the winner.
	 * 
	 * @param pWinner
	 *            the new winner
	 */
	public void setWinner(XmlMatchParticipant pWinner) {
		winner = pWinner;
	}

	/** {@inheritDoc} */
	@Override
	public String getCfgBetTypeId() {
		return cfgBetTypeId;
	}

}
