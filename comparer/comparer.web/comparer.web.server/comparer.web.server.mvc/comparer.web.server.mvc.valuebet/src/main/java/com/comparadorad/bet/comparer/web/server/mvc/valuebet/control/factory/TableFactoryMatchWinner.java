/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;

/**
 * The Class TableFactoryMatchWinner.
 */
@Service
public class TableFactoryMatchWinner extends AbstractTableValuebetFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory
	 * .AbstractTableValuebetFactory#getBetType()
	 */
	@Override
	public CfgBetTypeId getBetType() {
		return CfgBetTypeId.GANADOR_PARTIDO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory
	 * .AbstractTableValuebetFactory
	 * #makeObjectId(com.comparadorad.bet.comparer.model
	 * .valuebet.bean.InfoMatch,
	 * com.comparadorad.bet.comparer.model.bet.bean.RtBet)
	 */
	@Override
	public ObjectToId makeObjectId(InfoMatch match, RtBet bet) {
		return new ObjectToId(new StringBuffer()
				.append(match.getObjectId().toString())
				.append(((RtGanadorPartidoAttribute) bet.getAttribute())
						.getResult().getNameId())
				.append(bet.getBookmaker().getObjectId().toString()).toString());
	}

}
