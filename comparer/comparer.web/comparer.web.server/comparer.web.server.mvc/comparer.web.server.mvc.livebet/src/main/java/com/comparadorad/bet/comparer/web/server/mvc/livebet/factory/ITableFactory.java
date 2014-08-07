package com.comparadorad.bet.comparer.web.server.mvc.livebet.factory;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.factory.table.IMakeTable;

public interface ITableFactory {
	
	IMakeTable makeTable(CfgBetType betType);

}
