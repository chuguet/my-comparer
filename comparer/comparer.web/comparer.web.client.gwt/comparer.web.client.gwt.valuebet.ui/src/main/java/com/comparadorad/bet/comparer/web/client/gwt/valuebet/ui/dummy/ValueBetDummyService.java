/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.dummy;

import org.fusesource.restygwt.client.MethodCallback;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.request.ValueBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.response.ValueBetResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.ui.service.IValueBetService;

/**
 * The Class ValueBetDummyService.
 */
public class ValueBetDummyService extends GenericDummy implements
		IValueBetService {

	/**
	 * Gets the value bet.
	 * 
	 * @param pValueBetRequestTo
	 *            the value bet request to
	 * @param pCallback
	 *            the callback
	 * @return the value bet {@inheritDoc}
	 */
	@Override
	public void getValueBet(ValueBetRequestTo pValueBetRequestTo,
			MethodCallback<ValueBetResponseTo> pCallback) {
		ValueBetResponseTo valueBetResponseTo = new ValueBetResponseTo();
		valueBetResponseTo.setNoPaymentUser(false);
		int maxRecords = 95;
		// if (pValueBetRequestTo.getPageNum() == 1) {
		// maxRecords = 67;
		// }
		// else if (pValueBetRequestTo.getPageNum() == 4 ||
		// pValueBetRequestTo.getPageNum() == 3) {
		// maxRecords = 35;
		// }
		valueBetResponseTo.setCount(new Long(maxRecords));
		String[] quotas = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		TableResponseTo tableResponseTo = new TableResponseTo();
		int start;
		int end;
		if (pValueBetRequestTo.getPageNum() > ((double) maxRecords / 10)) {
			pValueBetRequestTo.setPageNum((int) ((double) maxRecords / 10));
		}
		start = (int) ((pValueBetRequestTo.getPageNum() * 10) + 1);
		end = start + 9;
		if (end >= maxRecords) {
			end = maxRecords;
		}
		// names: para testear salto de linea si el nombre del participante es
		// muy largo
		String[] names = { "y", "yyyyyyyyy", "yyy", "yyyy", "yyyyy", "yyyyyy",
				"yyyyyy", "yyyyyyyyyyy", "", "" };
		for (int i = start, rowNum = 0; i <= end; i++, rowNum++) {
			tableResponseTo.add(setRow("evento" + i, "Evento xxxxxxx" + i
					+ " Evento yyyy " + names[rowNum] + i
					+ "| Sport|Country|Competition", "13/06/2013 22:55",
					"Mas/Menos|5.5", "5", "Paris - Saint Germain",
					getRandomBookmakerImgMedium(), "http://www.google.es",
					pValueBetRequestTo.getPageNum() + quotas[rowNum], "6%",
					getRandom(10, 99)));
		}
		valueBetResponseTo.setTableResponseTo(tableResponseTo);
		pCallback.onSuccess(null, valueBetResponseTo);
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
	 * @param probability
	 *            the probability
	 * @param esperanza
	 *            the esperanza
	 * @return the table response row to
	 */
	private TableResponseRowTo setRow(String rowId, String eventName,
			String date, String betType, String betTypeId, String result,
			String extLinkImg, String url, String quota, String probability,
			String esperanza) {
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
		row.add(getNewCell(null, null, null, null, null, null, url, null,
				extLinkImg, null));
		row.add(getNewCell(null, null, null, null, null, null, url, quota,
				null, null));
		row.add(getNewCell(null, probability, null, null, null, null, null,
				null, null, null));
		row.add(getNewCell(null, esperanza, null, null, null, null, null, null,
				null, null));
		return row;
	}

}
