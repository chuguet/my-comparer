/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;

/**
 * The Class RtBetTypeEvent.
 */
@SuppressWarnings("serial")
public class RtBetTypeEvent extends AbstractBetBean {

	/** The bet type event. */
	@DBRef
	@NotNull
	private CfgBetTypeEvent betTypeEvent;

	/**
	 * Gets the bet type event.
	 * 
	 * @return the bet type event
	 */
	public CfgBetTypeEvent getBetTypeEvent() {
		if( betTypeEvent == null ){
			betTypeEvent = new CfgBetTypeEvent();
			betTypeEvent.setNameId( CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO.nameId());
			betTypeEvent.setObjectId(CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO.objectId());
		}
		return betTypeEvent;
	}

	/**
	 * Sets the bet type event.
	 * 
	 * @param pBetTypeEvent
	 *            the new bet type event
	 */
	public void setBetTypeEvent(CfgBetTypeEvent pBetTypeEvent) {
		betTypeEvent = pBetTypeEvent;
	}

	@Override
	public String toString() {
		return "RtBetTypeEvent [betTypeEvent=" + betTypeEvent + "]";
	}
}
