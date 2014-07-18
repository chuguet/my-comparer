/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.model.valuebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;

/**
 * The Class TableFactory1X2Handicap.
 */
@Service
public class TableFactory1X2Handicap extends AbstractTableValuebetFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory
	 * .AbstractTableValuebetFactory
	 * #makeResulCell(com.comparadorad.bet.comparer.model.bet.bean.RtBet,
	 * com.comparadorad.bet.comparer.model.core.bean.user.UserData)
	 */
	@Override
	public TableResponseCellTo makeResulCell(RtBet bet, UserData userData) {
		TableResponseCellTo result = new TableResponseCellTo();
		ValueTo valueTo = new ValueTo();

		Rt1X2HandicapAttribute rt1x2HandicapAttribute = (Rt1X2HandicapAttribute) bet
				.getAttribute();
		valueTo.setValueStr(rt1x2HandicapAttribute.getResult().getNameId());
		result.setValueTo(valueTo);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.valuebet.control.factory
	 * .AbstractTableValuebetFactory#getBetType()
	 */
	@Override
	public CfgBetTypeId getBetType() {
		return CfgBetTypeId.UNO_X_DOS_HANDICAP;
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
				.append(((Rt1X2HandicapAttribute) bet.getAttribute())
						.getResult().getNameId())
				.append(bet.getBookmaker().getObjectId().toString()).toString());
	}

}
