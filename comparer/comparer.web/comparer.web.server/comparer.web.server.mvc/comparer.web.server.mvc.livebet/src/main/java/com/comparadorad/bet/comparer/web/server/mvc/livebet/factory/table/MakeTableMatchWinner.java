package com.comparadorad.bet.comparer.web.server.mvc.livebet.factory.table;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.literal.CommonLiterals;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.beans.UserDataCover;
@Component
public class MakeTableMatchWinner extends AbstractMakeTable {

	@Override
	public CfgBetTypeId getBetType() {
		return CfgBetTypeId.GANADOR_PARTIDO;
	}

	@Override
	protected List<TableResponseRowTo> makeBet(RtMarket rtmarket,UserDataCover uData, String categoryAnalytics) {
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();

		result.add(addRow(rtmarket,CommonLiterals.getLocal(),true,false, categoryAnalytics));
		result.add(addRow(rtmarket,CommonLiterals.getVisitante(),false,true, categoryAnalytics));

		return result;
	}

}
