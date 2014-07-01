/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.dummy;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CountryRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.service.ICountryLongTermService;

/**
 * The Class SportCountriesDummyService.
 */
public class MainCountryLongTermDummyService implements ICountryLongTermService {

	@Override
	public void getCountryLongTermCompetition(
			CountryRequestTo pCountryRequestTo,
			MethodCallback<TableResponseTo> pCallback) {
		CountryCompetitionDummy dummy = new CountryCompetitionDummy();
		TableResponseTo tableResponseTo = dummy.getCountryLongTermCompetition(
				pCountryRequestTo.getSportId().getId(), pCountryRequestTo
						.getCountryId().getId());
		pCallback.onSuccess(null, tableResponseTo);
	}

	@Override
	public void getCountryLongTermBetType(CountryRequestTo pCountryRequestTo,
			MethodCallback<TableResponseTo> pCallback) {
		CountryBetTypeDummy dummy = new CountryBetTypeDummy();
		TableResponseTo tableResponseTo = dummy.getCountryLongTermBetType(
				pCountryRequestTo.getCompetitionId().getId());
		pCallback.onSuccess(null, tableResponseTo);
	}

	@Override
	public void getHead(CountryRequestTo pCountryRequestTo,
			MethodCallback<HeadResponseTo> pCallback) {
		CountryHeadDummy dummy = new CountryHeadDummy();
		HeadResponseTo headResponseTo = dummy
				.getHeadData(pCountryRequestTo.getSportId().getId(),
						pCountryRequestTo.getCountryId().getId());
		pCallback.onSuccess(null, headResponseTo);

	}

	@Override
	public void getCountryLongTermEvent(CountryRequestTo pCountryRequestTo,
			MethodCallback<TableResponseTo> pCallback) {
		CountryLongTermBetOddsDummy dummy = new CountryLongTermBetOddsDummy();
		TableResponseTo tableResponseTo = dummy.getCountryLongTermEvent(
				pCountryRequestTo.getCompetitionId().getId(), pCountryRequestTo.getBetTypeId().getId());
		pCallback.onSuccess(null, tableResponseTo);
	}
}
