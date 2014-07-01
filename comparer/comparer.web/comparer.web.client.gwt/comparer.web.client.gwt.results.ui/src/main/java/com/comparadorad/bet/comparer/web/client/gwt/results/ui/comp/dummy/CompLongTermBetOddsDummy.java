/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.dummy;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;

/**
 * The Class CompLongTermBetOddsDummy.
 */
public class CompLongTermBetOddsDummy extends GenericDummy {

	/**
	 * Instantiates a new comp long term bet odds dummy.
	 */
	public CompLongTermBetOddsDummy() {

	}

	/**
	 * Gets the row.
	 * 
	 * @param partId
	 *            the part id
	 * @param partName
	 *            the part name
	 * @param media
	 *            the media
	 * @param odd
	 *            the odd
	 * @param imgLocations
	 *            the img locations
	 * @param urls
	 *            the urls
	 * @return the row
	 */
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

	/**
	 * Gets the table data.
	 * 
	 * @param pId
	 *            the id
	 * @param pId2
	 *            the id2
	 * @return the table data
	 */
	public TableResponseTo getTableData(String pId, String pId2) {
		TableResponseTo tableResponseTo = new TableResponseTo();

		tableResponseTo.add(getRow("RealMadrid", "Real Madrid", "1.72", "2.2",
				new String[] { "comparer/bookmaker/bet365.gif",
				getRandomBookmakerImgSmall() }, new String[] {
						"http://www.bet365.com", "http://www.google.es" }));
		tableResponseTo.add(getRow("Barcelona", "Barcelona", "1.52", "2.1",
				new String[] { "comparer/bookmaker/bet365.gif" },
				new String[] { "http://www.bet365.com" }));
		tableResponseTo.add(getRow("Valencia", "Valencia", "1.80", "1.4",
				new String[] { "comparer/bookmaker/bet365.gif",
				getRandomBookmakerImgSmall(), getRandomBookmakerImgSmall() },
				new String[] { "http://www.bet365.com", "http://www.google.es",
						"http://www.google.es" }));
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

}
