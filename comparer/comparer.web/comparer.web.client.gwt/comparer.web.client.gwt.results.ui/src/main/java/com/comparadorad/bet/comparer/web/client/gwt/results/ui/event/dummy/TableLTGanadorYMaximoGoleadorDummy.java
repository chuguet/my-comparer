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

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTitleTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.core.encrypt.EncryptUtil;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetType;

/**
 * The Class TableLTGanadorYMaximoGoleadorDummy.
 */
public class TableLTGanadorYMaximoGoleadorDummy extends GenericDummy {

	private static final int NUM_BOOKMAKERS = 4;

	private static final int NUM_PARTICIPANTS = 2;

	/** The Constant REFRESH_ADD_NEW_COL. */
	private static final int REFRESH_ADD_NEW_COL = 2;
	
	private String[] bookmakers = { "BetClick", "Pinnacle", "Bet365",
			"Bet10", "NordicBet", "YouWin", "BetFred", "BetRk"};

	
	/** The num refreshs. */
	private int numRefreshs;

	/** The participant ids. */
	private String[] participants = { "RealMadrid", "Valencia", "Barcelona",
			"Athletic", "Levante", "Getafe", "Zaragoza", "Malaga", "Rayo" };

	/**
	 * Instantiates a new table lt ganador y maximo goleador dummy.
	 * 
	 * @param pCont
	 *            the cont
	 */
	public TableLTGanadorYMaximoGoleadorDummy(int pCont) {
		numRefreshs = pCont;
	}
	
	/**
	 * Gets the final row.
	 * @param porcetage 
	 * 
	 * @param values
	 *            the values
	 * @return the final row
	 */
	private TableResponseRowTo getFinalRow(boolean porcentage) {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		for (int colNum = 0; colNum < NUM_PARTICIPANTS + 1; colNum++) {
			String value = getRandom(10,99);
			String cellId = null;
			if (colNum != NUM_PARTICIPANTS) {
				cellId = new StringBuffer(participants[colNum]).append("Id").toString();
			}
			if (porcentage) {
				value = value + " %";
				if (colNum != NUM_PARTICIPANTS) {
					tableResponseRowTo.add(getNewCell(cellId, value,
							null, null, null, null, null, null, null, null));
				}
			}
			else {
				tableResponseRowTo.add(getNewCell(cellId, value,
					null, null, null, null, null, null, null, null));
			}
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
	 * @param odds
	 *            the odds
	 * @return the row
	 */
	private TableResponseRowTo getRow(String bookmakerId,
			String bookmakerLocation, String bookmakerName) {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		tableResponseRowTo.setObjectToId(new ObjectToId(bookmakerId));
		tableResponseRowTo.add(getNewCell(bookmakerId, null, null, null, null,
				null, EncryptUtil.encryptString("http://www.google.es"),
				bookmakerName, bookmakerLocation, null));
		for (int i = 0; i < NUM_PARTICIPANTS; i++) {
			tableResponseRowTo.add(getNewCell(new StringBuffer(participants[i]).append("Id").toString(), null, null,
					null, null, null,
					EncryptUtil.encryptString("http://www.google.es"), getRandom(10, 99),
					null, null));
		}
		tableResponseRowTo.add(getNewCell(null, getRandom(10, 99), null,
				null, null, null,
				null, null,
				null, null));
		return tableResponseRowTo;
	}

	/**
	 * Gets the table data.
	 * 
	 * @param eventId
	 *            the event id
	 * @param betTypeId
	 *            the bet type id
	 * @return the table data
	 */
	public List<TableResponseTo> getTableData(String eventId, String betTypeId) {
		List<TableResponseTo> list = new ArrayList<TableResponseTo>();
		
		TableResponseTo tableResponseTo = new TableResponseTo();
		tableResponseTo.setObjectToId(new ObjectToId("1"));
		if (betTypeId.equalsIgnoreCase(BetType.GANADOR.getId())
				|| betTypeId.equalsIgnoreCase(BetType.MAXIMO_GOLEADOR.getId())) {
			
				TableResponseRowTitleTo titleRow = setTitleRow();
				tableResponseTo.setTitle(titleRow);

				for (int i = 0; i < NUM_BOOKMAKERS; i++) {
					tableResponseTo.add(getRow(new StringBuffer(bookmakers[i]).append("Id").toString(),
							new StringBuffer("comparer/bookmaker/small/").append(bookmakers[i]).append("_65x65.jpg").toString(), bookmakers[i]));
				}
				
//				tableResponseTo.add(getRow("BetFredId",
//						"comparer/bookmaker/betfred.gif", "BetFred",
//						getRandom(10, 99), "2.4", "4.5", getRandom(10, 99),
//						"4.3", "2.1", "5.7", "2.3"));
				
				tableResponseTo.add(getFinalRow(false));
				tableResponseTo.add(getFinalRow(false));
				tableResponseTo.add(getFinalRow(true));
			
		}
		list.add(tableResponseTo);
		return list;
	}
	
	private TableResponseRowTitleTo setTitleRow() {
		TableResponseRowTitleTo row = new TableResponseRowTitleTo();
		int max = Math.min(participants.length, NUM_PARTICIPANTS);
		for (int i = 0; i < max; i++) {
			TableResponseCellTo field = new TableResponseCellTo(new ObjectToId(
					(participants[i] + "Id").replaceAll("\\s", "")), new ValueTo(null, participants[i]));
			row.add(field);
		}
		return row;
	}

}
