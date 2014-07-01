/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.dummy;

import java.util.ArrayList;
import java.util.List;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.request.SureBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.response.SureBetResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.service.ISecureBetService;

/**
 * The Class SecureBetDummyService.
 */
public class SecureBetDummyService extends GenericDummy implements
		ISecureBetService {

	/**
	 * Gets the secure bet.
	 * 
	 * @param pSecureBetRequestTo
	 *            the secure bet request to
	 * @param pCallback
	 *            the callback
	 * @return the secure bet {@inheritDoc}
	 */
	@Override
	public void getAllSureBet(SureBetRequestTo pSecureBetRequestTo,
			MethodCallback<SureBetResponseTo> pCallback) {
		SureBetResponseTo secureBetResponseTo = new SureBetResponseTo();
		TableResponseTo tableResponseTo = new TableResponseTo();
		secureBetResponseTo.setNoPaymentUser(false);

		int maxRecords = 95;
		secureBetResponseTo.setCount(new Long(maxRecords));
		int start;
		int end;
		if (pSecureBetRequestTo.getPageNum() > ((double) maxRecords / 10)) {
			pSecureBetRequestTo.setPageNum((long) ((double) maxRecords / 10));
		}
		start = (int) ((pSecureBetRequestTo.getPageNum() * 10) + 1);
		end = start + 9;
		if (end >= maxRecords) {
			end = maxRecords;
		}
		for (int i = start; i <= end; i++) {
			tableResponseTo.add(setRow("evento" + i, "Evento vs evento2 | Sport|Country|Competition", "13/06/2013 22:55",
					"Mas/Menos|5.5|Partido completo", "5", "1.35", new String[] {
							getRandomBookmakerImgSmall(),
							"comparer/bookmaker/bet365.gif",
							"comparer/bookmaker/bet365.gif"}, new String[] {
							"http://www.google.es", "http://www.google.es",
							"http://www.google.es"},"casaApuestas",
					new String[] { getRandom(10, 99), getRandom(10, 99),
							getRandom(10, 99) }, "41 min", "1.37", "calculadora"));
		}

		secureBetResponseTo.setTableResponseTo(tableResponseTo);
		pCallback.onSuccess(null, secureBetResponseTo);
	}

	/** {@inheritDoc} */
	@Override
	public void getOneSureBet(SureBetRequestTo pSecureBetRequestTo,
			MethodCallback<SureBetResponseTo> pCallback) {
		SureBetResponseTo secureBetResponseTo = new SureBetResponseTo();
		TableResponseTo tableResponseTo = new TableResponseTo();

		tableResponseTo.add(setRow(
				"evento1",
				"Evento 1 vs Evento 2" + "| Sport|Country|Competition",
				"13/06/2013 22:55",
				"Mas/Menos|5.5|Partido Completo",
				"5",
				"1.35",
				new String[] { getRandomBookmakerImgMedium(),
						"comparer/bookmaker/bet365.gif",
						"comparer/bookmaker/bet365.gif"},
				new String[] { "http://www.google.es", "http://www.google.es",
						"http://www.google.es"}, "casaApuestas",
				new String[] { getRandom(10, 99), getRandom(10, 99),
						getRandom(10, 99) }, "41 min", "1.37", "calculadora"));

		secureBetResponseTo.setTableResponseTo(tableResponseTo);
		pCallback.onSuccess(null, secureBetResponseTo);
	}

	/**
	 * Sets the row.
	 * 
	 * @param rowId
	 *            the row id
	 * @param eventName
	 *            the event name
	 * @param date
	 *            the date
	 * @param betType
	 *            the bet type
	 * @param betTypeId
	 *            the bet type id
	 * @param result
	 *            the result
	 * @param extLinkImg
	 *            the ext link img
	 * @param url
	 *            the url
	 * @param quota
	 *            the quota
	 * @param desde
	 *            the desde
	 * @param esperanza
	 *            the esperanza
	 * @return the table response row to
	 */
	private TableResponseRowTo setRow(String rowId, String eventName,
			String date, String betType, String betTypeId, String result,
			String[] extLinkImg, String[] url, String casaApuestas, String[] quota, String desde,
			String esperanza, String calculadora) {
		TableResponseRowTo row = new TableResponseRowTo();
		row.setObjectToId(new ObjectToId(rowId));
		row.add(getNewCell(null, null, date, eventName, new ObjectToId(rowId),
				new ObjectToId(betTypeId), null, null, null, null));
		// Bet type event id
		row.getCellList().get(0).getLinkTo()
				.setObjectToIdAux2(new ObjectToId(betTypeId));
		row.add(getNewCell(null, betType, null, null, null, null, null, null,
				null, null));
		row.add(getNewCell(null, result, null, null, null, null, null, null,
				null, null));
		row.add(getNewCell(null, null, null, null, null, null, null, null,
				null, null));
		TableResponseCellTo cell3 = row.getCellList().get(3);
		List<ExternalLinkTo> links = new ArrayList<ExternalLinkTo>();
		for (int numLink = 0; numLink < url.length; numLink++) {
			ExternalLinkTo link = new ExternalLinkTo();
			link.setLinkImgLocation(extLinkImg[numLink]);
			link.setActionAnalytics(casaApuestas);
			link.setCategoryAnalytics("surebets");
			link.setUrl(url[numLink]);
			links.add(link);
		}
		cell3.setExternalLinkToList(links);
		row.add(getNewCell(null, null, null, null, null, null, null, null,
				null, null));
		TableResponseCellTo cell4 = row.getCellList().get(4);
		links = new ArrayList<ExternalLinkTo>();

		for (int numLink = 0; numLink < url.length; numLink++) {
			ExternalLinkTo link = new ExternalLinkTo();
			link.setUrl(url[numLink]);
			link.setLinkText(quota[numLink]);
			link.setActionAnalytics(casaApuestas);
			link.setCategoryAnalytics("surebets");
			links.add(link);
		}
		cell4.setExternalLinkToList(links);
		row.add(getNewCell(null, desde, null, null, null, null, null, null,
				null, null));
		return row;
	}

}
