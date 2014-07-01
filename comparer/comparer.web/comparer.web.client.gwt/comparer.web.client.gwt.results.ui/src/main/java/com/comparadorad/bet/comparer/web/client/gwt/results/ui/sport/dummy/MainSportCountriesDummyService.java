/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.sport.dummy;

import java.util.List;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.SportRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.sport.service.ISportCountriesService;

/**
 * The Class SportCountriesDummyService.
 */
public class MainSportCountriesDummyService implements ISportCountriesService {

	/** {@inheritDoc} */
	@Override
	public void getHead(SportRequestTo pSportRequestTo,
			MethodCallback<HeadResponseTo> pCallback) {
		SportHeadDummy dummy = new SportHeadDummy();
		HeadResponseTo headResponseTo = dummy.getHeadData(pSportRequestTo
				.getSportId().getId());
		pCallback.onSuccess(null, headResponseTo);

	}

	/** {@inheritDoc} */
	@Override
	public void getSportCountriesBetOdds(SportRequestTo pSportRequestTo,
			MethodCallback<List<TableResponseTo>> pCallback) {
		SportBetOddsDummy dummy = new SportBetOddsDummy();
		List<TableResponseTo> tableResponseTo = dummy
				.getCountryEventsEvent(pSportRequestTo.getCompetitionId()
						.getId());
		pCallback.onSuccess(null, tableResponseTo);
	}

	/** {@inheritDoc} */
	@Override
	public void getSportCountriesCompetitions(SportRequestTo pSportRequestTo,
			MethodCallback<TableResponseTo> pCallback) {
		SportCompetitionDummy dummy = new SportCompetitionDummy();
		TableResponseTo tableResponseTo = dummy.getSportCountriesCompetitions(
				pSportRequestTo.getSportId().getId(), pSportRequestTo
						.getCountryId().getId());
		pCallback.onSuccess(null, tableResponseTo);

	}

	/** {@inheritDoc} */
	@Override
	public void getSportCountriesCountries(SportRequestTo pSportRequestTo,
			MethodCallback<TableResponseTo> pCallback) {
		SportCountriesDummy dummy = new SportCountriesDummy();
		TableResponseTo tableResponseTo = dummy
				.getSportCountriesCountries(pSportRequestTo.getSportId()
						.getId());
		pCallback.onSuccess(null, tableResponseTo);
	}

}
