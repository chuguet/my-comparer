/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.country.dummy;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;

/**
 * The Class CountryBetTypeLongTermDummyService.
 */
public class CountryLongTermBetOddsDummy extends GenericDummy {

	public CountryLongTermBetOddsDummy() {

	}

	public TableResponseTo getCountryLongTermEvent(String pId, String pId2) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		tableResponseTo.add(getRow("RealMadrid", "Real Madrid", "1.72", "2.2",
				new String[] { "comparer/bookmaker/bet365.gif",
				getRandomBookmakerImgSmall() }, new String[] {
						"http://www.bet365.com", "http://www.google.es" }));
		tableResponseTo.add(getRow("Barcelona", "Barcelona", "1.52", "2.1",
				new String[] { "comparer/bookmaker/bet365.gif"}, new String[] {
						"http://www.bet365.com"}));
		tableResponseTo.add(getRow("Valencia", "Valencia", "1.80", "1.4",
				new String[] { "comparer/bookmaker/bet365.gif",
				getRandomBookmakerImgSmall(), getRandomBookmakerImgSmall()}, new String[] {
						"http://www.bet365.com", "http://www.google.es", "http://www.google.es"}));
		tableResponseTo.add(getRow("Malaga", "Málaga", "1.72", "2.2",
				new String[] { "comparer/bookmaker/bet365.gif",
				getRandomBookmakerImgSmall() }, new String[] {
						"http://www.bet365.com", "http://www.google.es" }));
		tableResponseTo.add(getRow("Sevilla", "Sevilla", "1.50", "3.1",
				new String[] { "comparer/bookmaker/bet365.gif",
				getRandomBookmakerImgSmall() }, new String[] {
						"http://www.bet365.com", "http://www.google.es" }));
		return tableResponseTo;
	}

	private TableResponseRowTo getRow(String partId, String partName,
			String media, String odd, String[] imgLocations, String[] urls) {
		TableResponseRowTo row = new TableResponseRowTo();
		row.setObjectToId(new ObjectToId(partId));
		row.add(getNewCell(null, partName, null, null, null, null, null, null,
				null, null));
		row.add(getNewCell(null, media, null, null, null, null, null, null,
				null, null));
		row.add(getNewCell(null, odd, null, null, null, null, null, null, null,
				null));
		for (int i = 0; i < urls.length; i++) {
			row.add(getNewCell(null, null, null, null, null, null, urls[i],
					null, imgLocations[i], null));
		}
		return row;
	}

}
