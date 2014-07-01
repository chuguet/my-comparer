/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.dummy;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.service.ICompetitionLongTermService;

/**
 * The Class MainCompLongTermDummyService.
 */
public class MainCompLongTermDummyService implements
		ICompetitionLongTermService {

	/**
	 * Gets the bet odds.
	 * 
	 * @param pCompetitionRequestTo
	 *            the competition request to
	 * @param pCallback
	 *            the callback
	 * @return the bet odds {@inheritDoc}
	 */
	@Override
	public void getBetOdds(CompetitionRequestTo pCompetitionRequestTo,
			MethodCallback<TableResponseTo> pCallback) {
		CompLongTermBetOddsDummy dummy = new CompLongTermBetOddsDummy();
		TableResponseTo tableResponseTo = dummy.getTableData(
				pCompetitionRequestTo.getCompetitionId().getId(),
				pCompetitionRequestTo.getBetTypeIdFirstLevel().getId());
		pCallback.onSuccess(null, tableResponseTo);
	}

	/**
	 * Gets the bet types.
	 * 
	 * @param pCompetitionRequestTo
	 *            the competition request to
	 * @param pCallback
	 *            the callback
	 * @return the bet types {@inheritDoc}
	 */
	@Override
	public void getBetTypes(CompetitionRequestTo pCompetitionRequestTo,
			MethodCallback<TableResponseTo> pCallback) {
		CompLongTermBetTypesDummy dummy = new CompLongTermBetTypesDummy();
		TableResponseTo tableResponseTo = dummy
				.getTableData(pCompetitionRequestTo.getEventId().getId());
		pCallback.onSuccess(null, tableResponseTo);
	}

	/**
	 * Gets the head.
	 * 
	 * @param pCompetitionRequestTo
	 *            the competition request to
	 * @param pCallback
	 *            the callback
	 * @return the head {@inheritDoc}
	 */
	@Override
	public void getHead(CompetitionRequestTo pCompetitionRequestTo,
			MethodCallback<HeadResponseTo> pCallback) {
		CompHeadDummy dummy = new CompHeadDummy();
		HeadResponseTo headResponseTo = dummy.getHeadData(pCompetitionRequestTo
				.getCompetitionId().getId());
		pCallback.onSuccess(null, headResponseTo);
	}

	/**
	 * Gets the long term events.
	 * 
	 * @param pCompetitionRequestTo
	 *            the competition request to
	 * @param pCallback
	 *            the callback
	 * @return the long term events {@inheritDoc}
	 */
	@Override
	public void getLongTermEvents(CompetitionRequestTo pCompetitionRequestTo,
			MethodCallback<TableResponseTo> pCallback) {
		CompLongTermEventsDummy dummy = new CompLongTermEventsDummy();
		TableResponseTo tableResponseTo = dummy
				.getTableData(pCompetitionRequestTo.getCompetitionId().getId());
		pCallback.onSuccess(null, tableResponseTo);
	}
}
