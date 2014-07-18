/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.table.event.tabevent;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class MakeTableEventGanador.
 */
@Component
public final class MakeTableEventGanador extends MakeTableEventDecoratorPart {
	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetTypeId.GANADOR;
	}

}
