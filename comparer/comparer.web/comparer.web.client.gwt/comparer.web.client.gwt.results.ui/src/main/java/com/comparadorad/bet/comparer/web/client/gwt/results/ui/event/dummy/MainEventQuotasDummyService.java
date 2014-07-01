/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.dummy;

import java.util.List;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.EventRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.service.IEventQuotasService;

/**
 * The Class EventQuotasDummyService.
 */
public class MainEventQuotasDummyService implements IEventQuotasService {

	/** {@inheritDoc} */
	@Override
	public void getBetOdds(EventRequestTo pEventRequestTo,
			MethodCallback<List<TableResponseTo>> pCallback) {
		EventQuotasBetOddsDummy dummy = new EventQuotasBetOddsDummy();
		List<TableResponseTo> list = dummy.getTableData(pEventRequestTo
				.getEventId().getId(), pEventRequestTo.getBetTypeId().getId(),
				pEventRequestTo.getBetTypeEventId().getId());
		pCallback.onSuccess(null, list);
	}

	/** {@inheritDoc} */
	@Override
	public void getBetTypeEvent(EventRequestTo pEventRequestTo,
			MethodCallback<TabResponseTo> pCallback) {
		BetTypeEventsDummy dummy = new BetTypeEventsDummy();
		TabResponseTo tabResposeTo = dummy.getTabData(pEventRequestTo
				.getEventId().getId(), pEventRequestTo.getBetTypeId().getId());
		pCallback.onSuccess(null, tabResposeTo);
	}

	/** {@inheritDoc} */
	@Override
	public void getBetTypes(EventRequestTo pEventRequestTo,
			MethodCallback<TabResponseTo> pCallback) {
		EventQuotasBetTypesDummy dummy = new EventQuotasBetTypesDummy();
		TabResponseTo tabResposeTo = dummy.getTabData(pEventRequestTo
				.getEventId().getId());
		pCallback.onSuccess(null, tabResposeTo);
	}

	/** {@inheritDoc} */
	@Override
	public void getHead(EventRequestTo pEventRequestTo,
			MethodCallback<HeadResponseTo> pCallback) {
		EventHeadDummy dummy = new EventHeadDummy();
		HeadResponseTo headResponseTo = dummy.getHeadData(pEventRequestTo
				.getEventId().getId());
		pCallback.onSuccess(null, headResponseTo);
	}

}
