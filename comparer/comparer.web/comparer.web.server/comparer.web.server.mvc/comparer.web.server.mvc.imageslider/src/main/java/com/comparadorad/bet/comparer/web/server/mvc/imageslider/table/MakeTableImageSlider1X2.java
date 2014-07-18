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
 * The Class MakeTableOneXTwo.
 */
@Component
public class MakeTableImageSlider1X2 extends AbstractMakeTableImageSlider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.imageslider.table.
	 * IMakeTableImageSlider#getBetTypeId()
	 */
	@Override
	public CfgBetTypeId getBetTypeId() {
		return CfgBetType.CfgBetTypeId.UNO_X_DOS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.web.server.mvc.imageslider.table.
	 * AbstractMakeTableImageSlider
	 * #getRows(com.comparadorad.bet.comparer.model.bet.bean.CfgImageSlider,
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

		result.add(getrow(findBestOdd(true, false, market), userData, true, categoryAnalytics));
		result.add(getrow(findBestOdd(false, false, market), userData, true, categoryAnalytics));
		result.add(getrow(findBestOdd(false, true, market), userData, true, categoryAnalytics));

		return result;
	}

}
