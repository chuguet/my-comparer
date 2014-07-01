package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.dummy;

import java.util.List;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.service.ICompetitionEventsService;

public class MainCompEventsDummyService implements ICompetitionEventsService {

	private int numRefreshs = 0;
	
	@Override
	public void getHead(CompetitionRequestTo pCompetitionRequestTo,
			MethodCallback<HeadResponseTo> pCallback) {
		CompHeadDummy dummy = new CompHeadDummy();
		HeadResponseTo headResponseTo = dummy.getHeadData(pCompetitionRequestTo.getCompetitionId().getId());
		pCallback.onSuccess(null, headResponseTo);	
	}

	@Override
	public void getBetTypes(
			CompetitionRequestTo pCompetitionRequestTo,
			MethodCallback<TabResponseTo> pCallback) {
		CompEventsBetTypesDummy dummy = new CompEventsBetTypesDummy();
		TabResponseTo tabResposeTo = dummy.getTabData(pCompetitionRequestTo.getCompetitionId().getId());
		pCallback.onSuccess(null, tabResposeTo);
	}

	@Override
	public void getBetOdds(CompetitionRequestTo pCompetitionRequestTo,
			MethodCallback<List<TableResponseTo>> pCallback) {
		CompEventsBetOddsDummy dummy = new CompEventsBetOddsDummy(numRefreshs);
		List<TableResponseTo> list = dummy.getTableData(pCompetitionRequestTo.getCompetitionId().getId(), pCompetitionRequestTo.getBetTypeIdFirstLevel().getId());
//		if (numRefreshs == 2) {
//			// Para probar como la vista trata un server error
//			pCallback.onFailure(null, null); 
//		}
//		else {
			pCallback.onSuccess(null, list);
//		}
		numRefreshs++;
	}


}
