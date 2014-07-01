/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.dummy;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;

/**
 * The Class TableGanadorYMaximoGoleadorDummy.
 */
public class TableGanadorYMaximoGoleadorDummy extends GenericDummy {

	/** The participant ids. */
	private String[] participantIds = { "RealMadrid", "Valencia", "Barcelona",
			"Athletic", "Levante", "Getafe", "Zaragoza", "Malaga" };

	/**
	 * Gets the final row.
	 * 
	 * @param values
	 *            the values
	 * @return the final row
	 */
	private TableResponseRowTo getFinalRow(String... values) {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		int colNum = 0;
		for (String value : values) {
			if (colNum < participantIds.length) {
				tableResponseRowTo.add(getNewCell(participantIds[colNum],
						value, null, null, null, null, null, null, null, null));
			} else {
				tableResponseRowTo.add(getNewCell(null, value, null, null,
						null, null, null, null, null, null));
			}

			colNum++;
		}
		return tableResponseRowTo;
	}

	/**
	 * Gets the row.
	 * 
	 * @param bookmakerId
	 *            the bookmaker id
	 * @param bookmakerLocation
	 *            the bookmaker location
	 * @param bookmakerName
	 *            the bookmaker name
	 * @param pago
	 *            the pago
	 * @param odds
	 *            the odds
	 * @return the row
	 */
	private TableResponseRowTo getRow(String bookmakerId,
			String bookmakerLocation, String bookmakerName, int pago,
			String... odds) {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		tableResponseRowTo.setObjectToId(new ObjectToId(bookmakerId));
		tableResponseRowTo.add(getNewCell(bookmakerId, null, null, null, null,
				null, "http://www.google.es", bookmakerName, bookmakerLocation,
				null));
		int i = 0;
		for (String odd : odds) {
			tableResponseRowTo.add(getNewCell(participantIds[i], null, null,
					null, null, null, "http://www.google.es", odd, null, null));
			i++;
		}
		tableResponseRowTo.add(getNewCell(null,
				new StringBuffer(String.valueOf(pago)).append("%").toString(),
				null, null, null, null, null, null, null, null));
		return tableResponseRowTo;
	}

	/**
	 * Gets the table data.
	 * 
	 * @param pBetTypeEventId
	 *            the bet type event id
	 * @return the table data
	 */
	public List<TableResponseTo> getTableData(String pBetTypeEventId) {

		List<TableResponseTo> list = new ArrayList<TableResponseTo>();

		TableResponseTo tableResponseTo = new TableResponseTo();
		tableResponseTo.setObjectToId(new ObjectToId("1"));

		if (pBetTypeEventId == null) {
			TableResponseRowTitleTo titleRow = setTitleRowWithIdAndColName(
					"Real Madrid", "Valencia", "Barcelona", "Athletic",
					"Levante", "Getafe", "Zaragoza", "Malaga");
			tableResponseTo.setTitle(titleRow);

			tableResponseTo.add(getRow("BetFredId",
					"comparer/bookmaker/betfred.gif", "BetFred", 98,
					getRandom(10, 99), "2.4", "4.5", getRandom(10, 99), "4.3",
					"2.1", "5.7", "2.3"));
			tableResponseTo.add(getRow("BetRkId",
					"comparer/bookmaker/betrk.gif", "BetRk", 87, "5.2", "2.4",
					"4.5", "1.0", "4.3", "2.1", "5.7", "2.3"));
			tableResponseTo.add(getRow("BWinId", "comparer/bookmaker/bwin.gif",
					"BWin", 34, "2.2", getRandom(10, 99), getRandom(10, 99),
					"1.0", "4.3", "2.1", "5.7", "2.3"));

			tableResponseTo.add(getRow("comeonId",
					"comparer/bookmaker/comeon.gif", "Comeon", 78, "6.8",
					"2.4", "4.5", "1.0", "4.3", "2.1", "5.7", "2.3"));
			tableResponseTo.add(getRow("TitanBetId",
					"comparer/bookmaker/titanbet.gif", "TitanBet", 98, "4.2",
					"2.4", "4.5", "1.0", "4.3", "2.1", "5.7", "2.3"));
			tableResponseTo
					.add(getRow("LadbrokesId",
							"comparer/bookmaker/ladbrokes.gif", "Ladbrokes",
							99, "5.1", "2.4", "4.5", "1.0", "4.3", "2.1",
							"5.7", getRandom(10, 99)));
			tableResponseTo.add(getRow("10BetId",
					"comparer/bookmaker/10bet.gif", "10Bet", 96, "3.6", "2.4",
					"4.5", "1.0", "4.3", "2.1", "5.7", "2.3"));
			tableResponseTo.add(getFinalRow(getRandom(10, 99), "7.67",
					getRandom(10, 99), "3.9", "5,4", "5.7", "11.01", "13.05",
					"98%"));
			tableResponseTo.add(getFinalRow("1.12", getRandom(10, 99), "17.23",
					"3.9", "5,4", "5.7", "11.01", "13.05", "97%"));
			tableResponseTo.add(getFinalRow("1.12%", "7.67%", "3.9%", "5,4%",
					"5.7%", "11.01%", "13.05%", "1.12%"));
		}
		list.add(tableResponseTo);
		return list;
	}

}
