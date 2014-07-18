package com.comparadorad.bet.comparer.web.server.mvc.match.table.country.tablongterm;


import java.util.List;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.match.table.IMakeTable;

public interface IMakeTableCountryLT extends IMakeTable {

	TableResponseTo makeTable(List<RtMarket> markets,UserData userData);
	
}
