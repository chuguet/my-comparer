/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.dummy;

import java.util.List;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CountryRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.service.ICountryEventsService;

/**
 * The Class SportCountriesDummyService.
 */
public class MainCountryEventsDummyService implements
		ICountryEventsService {

	@Override
	public void getHead(CountryRequestTo pCountryRequestTo,
			MethodCallback<HeadResponseTo> pCallback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getCountryEventsCompetition(CountryRequestTo pCountryRequestTo,
			MethodCallback<TableResponseTo> pCallback) {
		CountryCompetitionDummy dummy = new CountryCompetitionDummy();
		TableResponseTo tableResponseTo = dummy.getCountryEventsCompetition(
				pCountryRequestTo.getSportId().getId(), pCountryRequestTo
						.getCountryId().getId());
		pCallback.onSuccess(null, tableResponseTo);
		
	}

	@Override
	public void getCountryEventsEvent(CountryRequestTo pCountryRequestTo,
			MethodCallback<List<TableResponseTo>> pCallback) {
		CountryEventsBetOddsDummy dummy = new CountryEventsBetOddsDummy();
		List<TableResponseTo> tableResponseTo = dummy.getCountryEventsEvent(
				pCountryRequestTo.getCompetitionId().getId());
		pCallback.onSuccess(null, tableResponseTo);
	}
	
}
