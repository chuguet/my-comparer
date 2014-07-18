/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;

/**
 * The Class TableFactory1X2.
 */
@Service
public class TableFactory1X2 extends AbstractTableValuebetFactory {


	/** {@inheritDoc} */ 
	@Override
	public CfgBetTypeId getBetType() {
		return CfgBetTypeId.UNO_X_DOS;
	}


	/** {@inheritDoc} */ 
	@Override
	public ObjectToId makeObjectId(InfoMatch match, RtBet bet) {
		return new ObjectToId(new StringBuffer()
				.append(match.getObjectId().toString())
				.append(((Rt1X2Attribute) bet.getAttribute()).getResult()
						.getNameId())
				.append(bet.getBookmaker().getObjectId().toString()).toString());
	}

}
