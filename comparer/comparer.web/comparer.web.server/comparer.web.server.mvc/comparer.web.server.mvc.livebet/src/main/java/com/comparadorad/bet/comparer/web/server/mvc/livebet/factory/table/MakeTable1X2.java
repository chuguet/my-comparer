/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.livebet.factory.table;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.literal.CommonLiterals;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.server.mvc.livebet.beans.UserDataCover;

/**
 * The Class MakeTable1X2.
 */
@Component
public class MakeTable1X2 extends AbstractMakeTable {

	 /** {@inheritDoc} */ 
	@Override
	public CfgBetTypeId getBetType() {
		return CfgBetTypeId.UNO_X_DOS;
	}


	 /** {@inheritDoc} */ 
	@Override
	protected List<TableResponseRowTo> makeBet(RtMarket rtmarket, UserDataCover uData, String categoryAnalytics) {
		List<TableResponseRowTo> result = new ArrayList<TableResponseRowTo>();
		
		result.add(addRow(rtmarket,CommonLiterals.getLocal(),true,false, categoryAnalytics));
		result.add(addRow(rtmarket,CommonLiterals.getEmpate(),false,false, categoryAnalytics));
		result.add(addRow(rtmarket,CommonLiterals.getVisitante(),false,true, categoryAnalytics));
		
		return result;
	}









 
}
