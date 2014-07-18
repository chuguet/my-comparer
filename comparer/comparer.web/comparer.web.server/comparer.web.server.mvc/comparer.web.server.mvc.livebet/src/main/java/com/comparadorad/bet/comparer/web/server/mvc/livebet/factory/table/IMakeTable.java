package com.comparadorad.bet.comparer.web.server.mvc.livebet.factory.table;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.beans.UserDataCover;

public interface IMakeTable {
	
	TableResponseTo makeTable(RtMatch rtMatch, UserDataCover uData, RtMarket rtmarket);
	
	CfgBetType.CfgBetTypeId getBetType();

}
