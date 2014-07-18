/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.imageslider.table;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.CfgImageSlider;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * The Class MakeTableWinnerMatch.
 */
@Component
public class MakeTableImageSliderGanadorPartido extends
		AbstractMakeTableImageSlider {

	/**
	 * Gets the bet type id.
	 * 
	 * @return the bet type id {@inheritDoc}
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetType.CfgBetTypeId.GANADOR_PARTIDO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.imageslider.table.
	 * AbstractMakeTableImageSlider
	 * #getRows(com.comparadorad.bet.comparer.model.bet.bean.ImageSliderConfig,
	 * com.comparadorad.bet.comparer.model.core.bean.user.UserData)
	 */
	@Override
	public TableResponseTo getRows(CfgImageSlider view, UserData userData) {
		TableResponseTo result = new TableResponseTo();
		RtMarket market = null;
		String categoryAnalytics = view.getMatch().getMatchId().getCompetition().getSport().getName(null)+view.getMatch().getMatchId().getCompetition().getName(null)+view.getMatch().getName(null);
		for (RtMarket marketIterator : view.getMatch().getRtMarkets()) {
			if (isMarket(marketIterator, view.getBetType(),
					view.getBetTypeEvent())) {
				market = marketIterator;
				categoryAnalytics=categoryAnalytics+view.getBetType();
				break;
			}
		}

		result.add(getrow(findBestOdd(true, false, market), userData, false, categoryAnalytics));
		result.add(getrow(findBestOdd(false, true, market), userData, false, categoryAnalytics));

		return result;
	}
}
