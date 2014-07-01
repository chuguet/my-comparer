/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.comp.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;

/**
 * The Class CompEventsBetOddsDummy.
 */
public class CompEventsBetOddsDummy extends GenericDummy {

	/** The Constant REFRESH_ADD_NEW_ROW. */
	private static final int REFRESH_ADD_NEW_ROW = 2;

	/** The Constant REFRESH_ADD_NEW_ROW2. */
	private static final int REFRESH_ADD_NEW_ROW2 = 4;

	/** The num refreshs. */
	private int numRefreshs;

	/**
	 * Instantiates a new comp events bet odds dummy.
	 * 
	 * @param pNumRefreshs
	 *            the num refreshs
	 */
	public CompEventsBetOddsDummy(int pNumRefreshs) {
		numRefreshs = pNumRefreshs;
	}

	/**
	 * Gets the row.
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
	 * @param participantNames
	 *            the participant names
	 * @return the row
	 */
	private TableResponseRowTo getRow(String rowId, String hora,
			String intlinkEventName, String intLinkId, String[] odds,
			String[] urls, String[] imgLocations, String[] participantNames) {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		tableResponseRowTo.setObjectToId(new ObjectToId(rowId));
		tableResponseRowTo.add(getNewCell(null, null, hora, null, null, null,
				null, null, null, null));
		tableResponseRowTo.add(getNewCell(null, null, null, intlinkEventName,
				new ObjectToId(intLinkId), new ObjectToId("idBetType"), null,
				null, null, null));
		int i;
		for (i = 0; i < odds.length - 1; i++) {
			tableResponseRowTo.add(getNewCell(null, participantNames[i], null,
					null, null, null, urls[i], odds[i], imgLocations[i], null));
		}
		return tableResponseRowTo;
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
	 * Gets the table data.
	 * 
	 * @param competitionId
	 *            the competition id
	 * @param betTypeId1
	 *            the bet type id1
	 * @return the table data
	 */
	public List<TableResponseTo> getTableData(String competitionId,
			String betTypeId1) {
		Log.debug("numberOfRefreshCalls = " + numRefreshs);
		List<TableResponseTo> list = new ArrayList<TableResponseTo>();

		if (competitionId.equalsIgnoreCase("ligaBBVA")) {
			if (betTypeId1.equalsIgnoreCase(BetType.GANADOR.getId())) {
				String[] odds = { getRandom(10, 99), "1.2", getRandom(10, 99) };
				String[] urls = { "http://www.betfred.com/",
						"http:www.google.es", "https://www.bwin.es/" };
				String[] imgLocations = { getRandomBookmakerImgSmall(),
						getRandomBookmakerImgSmall(),
						"comparer/bookmaker/bwin.gif" };
				String[] participantNames = { "Anders Jansson", "Erik Nilsson",
						"Jonas Lindstrom" };

				TableResponseTo tableResponseTo = new TableResponseTo();
				TableResponseRowTitleTo title = new TableResponseRowTitleTo();
				TableResponseCellTo cell = new TableResponseCellTo();
				cell.setValueTo(new ValueTo("17 de agosto", null));
				title.add(cell);
				tableResponseTo.setTitle(title);

				tableResponseTo.setObjectToId(new ObjectToId("1Ganador"));
				tableResponseTo.add(getRow("eventId11", "15:00",
						"Partido multiequipo Ronda 1", "eventId11", odds, urls,
						imgLocations, participantNames));
				tableResponseTo.add(getRow("eventId12", "15.30",
						"Partido multiequipo Ronda 2", "eventId12", odds, urls,
						imgLocations, participantNames));
				tableResponseTo.add(getRow("eventId13", "19:00",
						"Partido multiequipo Ronda 3", "eventId13", odds, urls,
						imgLocations, participantNames));
				tableResponseTo.add(getRow("eventId14", "19:30",
						"Partido multiequipo Ronda 4", "eventId14", odds, urls,
						imgLocations, participantNames));
				if (numRefreshs == REFRESH_ADD_NEW_ROW) {
					tableResponseTo.add(getRow("eventId15", "21:30",
							"Partido multiequipo Ronda 5", "eventId15", odds,
							urls, imgLocations, participantNames));
				}
				list.add(tableResponseTo);

				/***********************************************************/

				tableResponseTo = new TableResponseTo();
				title = new TableResponseRowTitleTo();
				cell = new TableResponseCellTo();
				cell.setValueTo(new ValueTo("18 de agosto", null));
				title.add(cell);
				tableResponseTo.add(title);
				tableResponseTo.setObjectToId(new ObjectToId("2Ganador"));
				tableResponseTo.add(getRow("eventId21", "15.30",
						"Partido multiequipo Ronda 1", "eventId21", odds, urls,
						imgLocations, participantNames));
				tableResponseTo.add(getRow("eventId22", "19:00",
						"Partido multiequipo Ronda 2", "eventId22", odds, urls,
						imgLocations, participantNames));
				tableResponseTo.add(getRow("eventId23", "19:30",
						"Partido multiequipo Ronda 3", "eventId23", odds, urls,
						imgLocations, participantNames));
				if (numRefreshs == REFRESH_ADD_NEW_ROW2) {
					tableResponseTo.add(getRow("eventId24", "21:30",
							"Partido multiequipo Ronda 4", "eventId24", odds,
							urls, imgLocations, participantNames));
				}
				tableResponseTo.setTitle(title);

			}

			if (betTypeId1.equalsIgnoreCase(BetType.UNO_X_DOS.getId())) {
				String[] odds = { getRandom(10, 99), "1.2", getRandom(10, 99) };
				String[] urls = { "http://www.betfred.com/", getRandomUrl(),
						"https://www.bwin.es/" };
				String[] imgLocations = { getRandomBookmakerImgSmall(),
						getRandomBookmakerImgSmall(),
						"comparer/bookmaker/bwin.gif" };

				TableResponseTo tableResponseTo = new TableResponseTo();
				tableResponseTo.setObjectToId(new ObjectToId("1UnoXDos"));
				TableResponseRowTitleTo titleRow = getTitleRowWithDate();
				tableResponseTo.setTitle(titleRow);

				tableResponseTo.add(getRow1x2("eventId11", "17:15",
						"Barcelona VS Real Madrid", "eventId11", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId12", "18:15",
						"Valencia VS Barcelona", "eventId12", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId13", "21:00",
						"Real Betis VS Rayo", "eventId13", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId14", "21:30",
						"Málaga VS Bilbao", "eventId14", odds, urls,
						imgLocations));
				if (numRefreshs == REFRESH_ADD_NEW_ROW) {
					tableResponseTo.add(getRow1x2("eventId15", "21:00",
							"Zaragoza VS Levante", "eventId15", odds, urls,
							imgLocations));
				}
				list.add(tableResponseTo);

				/***********************************************************/
				tableResponseTo = new TableResponseTo();
				tableResponseTo.setObjectToId(new ObjectToId("2UnoXDos"));
				titleRow = getTitleRowWithDate();
				tableResponseTo.setTitle(titleRow);

				tableResponseTo.add(getRow1x2("eventId11", "17:15",
						"Barcelona VS Real Madrid", "eventId11", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId12", "18:15",
						"Valencia VS Barcelona", "eventId12", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId13", "21:00",
						"Real Betis VS Rayo", "eventId13", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId14", "21:30",
						"Málaga VS Bilbao", "eventId14", odds, urls,
						imgLocations));
				if (numRefreshs == REFRESH_ADD_NEW_ROW2) {
					tableResponseTo.add(getRow1x2("eventId15", "21:00",
							"Zaragoza VS Levante", "eventId15", odds, urls,
							imgLocations));
				}
				list.add(tableResponseTo);
			}

			if (betTypeId1.equalsIgnoreCase(BetType.GANADOR_DE_PARTIDO.getId())) {
				String[] odds = { getRandom(10, 99), "1.2" };
				String[] urls = { "http://www.betfred.com/", getRandomUrl() };
				String[] imgLocations = { getRandomBookmakerImgSmall(),
						getRandomBookmakerImgSmall() };

				TableResponseTo tableResponseTo = new TableResponseTo();
				tableResponseTo
						.setObjectToId(new ObjectToId("1GanadorPartido"));
				TableResponseRowTitleTo titleRow = getTitleRowWithDate();
				tableResponseTo.setTitle(titleRow);

				tableResponseTo.add(getRow1x2("eventId11", "17:15",
						"Barcelona VS Real Madrid", "eventId11", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId12", "18:15",
						"Valencia VS Barcelona", "eventId12", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId13", "21:00",
						"Real Betis VS Rayo", "eventId13", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId14", "21:30",
						"Málaga VS Bilbao", "eventId14", odds, urls,
						imgLocations));
				if (numRefreshs == REFRESH_ADD_NEW_ROW) {
					tableResponseTo.add(getRow1x2("eventId15", "21:00",
							"Zaragoza VS Levante", "eventId15", odds, urls,
							imgLocations));
				}
				list.add(tableResponseTo);

				/***********************************************************/
				tableResponseTo = new TableResponseTo();
				tableResponseTo
						.setObjectToId(new ObjectToId("2GanadorPartido"));
				titleRow = getTitleRowWithDate();
				tableResponseTo.setTitle(titleRow);

				tableResponseTo.add(getRow1x2("eventId11", "17:15",
						"Barcelona VS Real Madrid", "eventId11", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId12", "18:15",
						"Valencia VS Barcelona", "eventId12", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId13", "21:00",
						"Real Betis VS Rayo", "eventId13", odds, urls,
						imgLocations));
				tableResponseTo.add(getRow1x2("eventId14", "21:30",
						"Málaga VS Bilbao", "eventId14", odds, urls,
						imgLocations));
				if (numRefreshs == REFRESH_ADD_NEW_ROW2) {
					tableResponseTo.add(getRow1x2("eventId15", "21:00",
							"Zaragoza VS Levante", "eventId15", odds, urls,
							imgLocations));
				}
				list.add(tableResponseTo);

			}
		}
		return list;
	}

	/**
	 * Gets the title row with date.
	 * 
	 * @return the title row with date
	 */
	public TableResponseRowTitleTo getTitleRowWithDate() {
		TableResponseRowTitleTo title = new TableResponseRowTitleTo();
		ValueTo valueTo = new ValueTo(DATE.format(new Date()), null);
		TableResponseCellTo cell = new TableResponseCellTo();
		cell.setValueTo(valueTo);
		title.add(cell);
		return title;
	}

}
