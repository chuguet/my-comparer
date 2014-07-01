/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.dummy;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;

/**
 * The Class CountryBetTypeLongTermDummyService.
 */
public class CountryEventsBetOddsDummy extends GenericDummy {

	/**
	 * Gets the country events event.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @return the country events event
	 */
	public List<TableResponseTo> getCountryEventsEvent(String competitionId) {
		// if (competitionId.equalsIgnoreCase("ligaBBVA")) {
		List<TableResponseTo> list = new ArrayList<TableResponseTo>();

		String[] odds = { getRandom(10, 99), "1.2", getRandom(10, 99) };
		String[] urls = { "http://www.betfred.com/", getRandomUrl(),
				"https://www.bwin.es/" };
		String[] imgLocations = { getRandomBookmakerImgSmall(),
				"comparer/bookmaker/betrk.gif", "comparer/bookmaker/bwin.gif" };

		TableResponseTo tableResponseTo = new TableResponseTo();
		tableResponseTo.setObjectToId(new ObjectToId("1UnoXDos"));
		TableResponseRowTitleTo titleRow = getTitleRowWithBetType();
		tableResponseTo.setTitle(titleRow);

		tableResponseTo.add(getRow1x2("eventId11", "17:15",
				"Barcelona VS Real Madrid", "eventId11", odds, urls,
				imgLocations));
		tableResponseTo
				.add(getRow1x2("eventId12", "18:15", "Valencia VS Barcelona",
						"eventId12", odds, urls, imgLocations));
		tableResponseTo.add(getRow1x2("eventId13", "21:00",
				"Real Betis VS Rayo", "eventId13", odds, urls, imgLocations));
		tableResponseTo.add(getRow1x2("eventId14", "21:30", "Málaga VS Bilbao",
				"eventId14", odds, urls, imgLocations));
		list.add(tableResponseTo);

		/***********************************************************/
		tableResponseTo = new TableResponseTo();
		tableResponseTo.setObjectToId(new ObjectToId("2UnoXDos"));
		titleRow = getTitleRowWithBetType();
		tableResponseTo.setTitle(titleRow);

		tableResponseTo.add(getRow1x2("eventId11", "17:15",
				"Barcelona VS Real Madrid", "eventId11", odds, urls,
				imgLocations));
		tableResponseTo
				.add(getRow1x2("eventId12", "18:15", "Valencia VS Barcelona",
						"eventId12", odds, urls, imgLocations));
		tableResponseTo.add(getRow1x2("eventId13", "21:00",
				"Real Betis VS Rayo", "eventId13", odds, urls, imgLocations));
		tableResponseTo.add(getRow1x2("eventId14", "21:30", "Málaga VS Bilbao",
				"eventId14", odds, urls, imgLocations));
		list.add(tableResponseTo);

		return list;
		// }
		// return null;
	}

	/**
	 * Gets the row1x2.
	 * 
	 * @param rowId
	 *            the row id
	 * @param hora
	 *            the hora
	 * @param intlinkEventName
	 *            the intlink event name
	 * @param intLinkId
	 *            the int link id
	 * @param odds
	 *            the odds
	 * @param urls
	 *            the urls
	 * @param imgLocations
	 *            the img locations
	 * @return the row1x2
	 */
	private TableResponseRowTo getRow1x2(String rowId, String hora,
			String intlinkEventName, String intLinkId, String[] odds,
			String[] urls, String[] imgLocations) {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		tableResponseRowTo.setObjectToId(new ObjectToId(rowId));
		tableResponseRowTo.add(getNewCell(null, null, hora, null, null, null,
				null, null, null, null));
		tableResponseRowTo.add(getNewCell(null, null, null, intlinkEventName,
				new ObjectToId(intLinkId), new ObjectToId("1X2"), null, null,
				null, null));
		int i;
		for (i = 0; i < odds.length; i++) {
			tableResponseRowTo.add(getNewCell(null, null, null, null, null,
					null, urls[i], odds[i], imgLocations[i], null));
		}
		return tableResponseRowTo;
	}

	/**
	 * Gets the title row with bet type.
	 * 
	 * @return the title row with bet type
	 */
	public TableResponseRowTitleTo getTitleRowWithBetType() {
		TableResponseRowTitleTo title = new TableResponseRowTitleTo();
		ValueTo valueTo = new ValueTo(null, "1X2");
		TableResponseCellTo cell = new TableResponseCellTo();
		cell.setValueTo(valueTo);
		cell.setId(new ObjectToId("1"));
		title.add(cell);
		return title;
	}

}
