/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.tabs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.web.server.mvc.match.enums.BetTypesView;

/**
 * The Class MakeTabsEvent.
 */
@Component
public class MakeTabsEvent extends AbstractMakeTabs {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.match.tabs.IMakeTabs#
	 * getBetTypesView()
	 */
	@Override
	public BetTypesView getBetTypesView() {
		return BetTypesView.EVENT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.mvc.match.tabs.AbstractMakeTabs
	 * #getBetTypesKept(java.util.List)
	 */
	@Override
	protected List<CfgBetType> getBetTypesKept(List<CfgBetType> betTypes) {
		List<CfgBetType> result = new ArrayList<CfgBetType>();
		for (CfgBetType betType : betTypes) {
			if (betType.getNameId().equals(CfgBetTypeId.GANADOR.nameId())
					|| betType.getNameId().equals(
							CfgBetTypeId.MAXIMO_GOLEADOR.nameId())
					|| betType.getNameId().equals(
							CfgBetTypeId.HANDICAP_ASIATICO.nameId())
					|| betType.getNameId().equals(
							CfgBetTypeId.UNO_X_DOS.nameId())
					|| betType.getNameId().equals(
							CfgBetTypeId.UNO_X_DOS_HANDICAP.nameId())
					|| betType.getNameId().equals(
							CfgBetTypeId.GANADOR_PARTIDO.nameId())
					|| betType.getNameId().equals(
							CfgBetTypeId.MAS_MENOS.nameId())) {
				result.add(betType);
			}
		}
		return result;
	}

}
