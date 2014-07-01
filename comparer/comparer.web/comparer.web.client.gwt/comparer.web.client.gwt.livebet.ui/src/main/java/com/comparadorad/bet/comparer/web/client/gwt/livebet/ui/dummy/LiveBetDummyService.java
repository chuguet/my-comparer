/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.fusesource.restygwt.client.MethodCallback;

import com.allen_sauer.gwt.log.client.Log;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.literal.CommonLiterals;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.bean.request.LiveBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.ui.service.ILiveBetService;

/**
 * The Class LiveBetDummyService.
 */
public class LiveBetDummyService extends GenericDummy implements
		ILiveBetService {

	/** The num refresh. */
	private int numRefresh = 0;

	/**
	 * Gets the first row.
	 * 
	 * @param date
	 *            the date
	 * @param time
	 *            the time
	 * @param betTypeName
	 *            the bet type name
	 * @return the first row
	 */
	private TableResponseRowTo getFirstRow(String date, String time,
			String betTypeName) {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		tableResponseRowTo.add(getNewCell(null, null, date, null, null, null,
				null, null, null, null));
		tableResponseRowTo.add(getNewCell(null, null, time, null, null, null,
				null, null, null, null));
		tableResponseRowTo.add(getNewCell(null, betTypeName, null, null, null,
				null, null, null, null, null));
		return tableResponseRowTo;
	}

	/** {@inheritDoc} */
	@Override
	public void getLiveBet(LiveBetRequestTo pRequest,
			MethodCallback<List<TableResponseTo>> pCallback) {
		Log.debug("numRefresh = " + numRefresh);
		numRefresh++;
		List<TableResponseTo> list = getTableData(numRefresh);
		pCallback.onSuccess(null, list);
	}

	/**
	 * Gets the row1x2.
	 * 
	 * @param partName
	 *            the part name
	 * @param odd
	 *            the odd
	 * @param revenue
	 *            the revenue
	 * @param extLinkUrl
	 *            the ext link url
	 * @param extLinkImg
	 *            the ext link img
	 * @param literal
	 *            the literal
	 * @return the row1x2
	 */
	private TableResponseRowTo getRow1x2(String partName, String odd,
			String revenue, String extLinkUrl, String extLinkImg, String literal) {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		if (literal == null) {
			tableResponseRowTo.add(getNewCell(null, partName, null, null, null,
					null, null, null, null, null));
		} else {
			tableResponseRowTo.add(getNewCell(null, null, null, null, null,
					null, null, null, null, null));
			tableResponseRowTo.getCellList().get(0)
					.setValueTo(new ValueTo(literal));
		}
		tableResponseRowTo.add(getNewCell(null, odd, null, null, null, null,
				null, null, null, null));
		tableResponseRowTo.add(getNewCell(null, odd, null, null, null, null,
				extLinkUrl, null, extLinkImg, null));
		tableResponseRowTo.add(getNewCell(null, revenue, null, null, null,
				null, null, null, null, null));
		return tableResponseRowTo;
	}

	/**
	 * Gets the second row.
	 * 
	 * @param intlinkEventName
	 *            the intlink event name
	 * @param intLinkId
	 *            the int link id
	 * @return the second row
	 */
	private TableResponseRowTo getSecondRow(String intlinkEventName,
			String intLinkId) {
		TableResponseRowTo tableResponseRowTo = new TableResponseRowTo();
		tableResponseRowTo.add(getNewCell(null, null, null, intlinkEventName,
				new ObjectToId(intLinkId), new ObjectToId("betTypeId"), null,
				null, null, null));
		return tableResponseRowTo;
	}

	/**
	 * Gets the table data.
	 * 
	 * @param numRefresh
	 *            the num refresh
	 * @return the table data
	 */
	private List<TableResponseTo> getTableData(int numRefresh) {
		TableResponseTo tableResponseTo = new TableResponseTo();
		Date dateD = new Date();
		List<TableResponseTo> list = new ArrayList<TableResponseTo>();
		Log.error("numero de refresco: " + numRefresh);
		if (numRefresh < 2) {
			// 1x2
			tableResponseTo.setObjectToId(new ObjectToId("1")); // eventId +
																// fecha +
																// betTypeId
			tableResponseTo.add(getFirstRow(DATE.format(dateD),
					TIME.format(dateD), "1X2"));
			tableResponseTo.add(getSecondRow("Real Madrid CF VS UD Las Palmas",
					"RealMadridCFVSUDLasPalmas"));
			tableResponseTo.add(getRow1x2("Real Madrid CF", getRandom(10, 99),
					"10", getRandomUrl(), getRandomBookmakerImgMedium(), null));
			tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10, 99),
					"http://www.bet365.com", "comparer/bookmaker/bet365.gif",
					CommonLiterals.getEmpate()));
			tableResponseTo.add(getRow1x2("UD Las Palmas", getRandom(10, 99),
					"10", "http://www.comeon.com",
					getRandomBookmakerImgMedium(), null));
			list.add(tableResponseTo);
		}

		// Ganador partido
		tableResponseTo = new TableResponseTo();
		tableResponseTo.setObjectToId(new ObjectToId("2")); // eventId + fecha +
															// betTypeId
		dateD = new Date();

		tableResponseTo.add(getFirstRow(DATE.format(dateD), TIME.format(dateD),
				"12"));
		tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
				"BarcelonaCFVSUDLasPalmas"));
		tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10, 99),
				getRandomUrl(), "comparer/bookmaker/bet365.gif",
				CommonLiterals.getLocal()));
		tableResponseTo.add(getRow1x2(null, getRandom(10, 99), "10",
				"http://www.comeon.com", getRandomBookmakerImgMedium(),
				CommonLiterals.getEmpate()));
		tableResponseTo.add(getRow1x2(null, getRandom(10, 99), "10",
				"http://www.comeon.com", getRandomBookmakerImgMedium(),
				CommonLiterals.getVisitante()));
		list.add(tableResponseTo);

		// // Ganador
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("3"));
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "Ganador"));
		// tableResponseTo.add(getSecondRow("Olympics final, Men 100 meter",
		// "OlympicsfinalMen100meter"));
		// tableResponseTo.add(getRow1x2("Part 1", getRandom(10,99), "10",
		// getRandomUrl(), getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 2", "1.01", getRandom(10,99),
		// "http://www.bet365.com", "comparer/bookmaker/bet365.gif", null));
		// tableResponseTo.add(getRow1x2("Part 3", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 4", "5.3", "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 5", getRandom(10,99), "10",
		// "http://www.comeon.com", "comparer/bookmaker/betfred.gif", null));
		// tableResponseTo.add(getRow1x2("Part 6", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 7", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 8", "5.3", "10",
		// "http://www.comeon.com", "comparer/bookmaker/betdaq.gif", null));
		// tableResponseTo.add(getRow1x2("Part 9", "5.3", "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 10", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 11", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// list.add(tableResponseTo);

		// Ganador partido
		tableResponseTo = new TableResponseTo();
		tableResponseTo.setObjectToId(new ObjectToId("3")); // eventId + fecha +
															// betTypeId
		dateD = new Date();

		tableResponseTo.add(getFirstRow(DATE.format(dateD), TIME.format(dateD),
				"12"));
		tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
				"BarcelonaCFVSUDLasPalmas"));
		tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10, 99),
				getRandomUrl(), "comparer/bookmaker/bet365.gif",
				CommonLiterals.getLocal()));
		tableResponseTo.add(getRow1x2(null, getRandom(10, 99), "10",
				"http://www.comeon.com", getRandomBookmakerImgMedium(),
				CommonLiterals.getVisitante()));
		list.add(tableResponseTo);

		// Ganador partido
		tableResponseTo = new TableResponseTo();
		tableResponseTo.setObjectToId(new ObjectToId("4")); // eventId + fecha +
															// betTypeId
		dateD = new Date();

		tableResponseTo.add(getFirstRow(DATE.format(dateD), TIME.format(dateD),
				"12"));
		tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
				"BarcelonaCFVSUDLasPalmas"));
		tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10, 99),
				getRandomUrl(), "comparer/bookmaker/bet365.gif",
				CommonLiterals.getLocal()));
		tableResponseTo.add(getRow1x2(null, getRandom(10, 99), "10",
				"http://www.comeon.com", getRandomBookmakerImgMedium(),
				CommonLiterals.getVisitante()));
		list.add(tableResponseTo);

		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("4")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("5")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("6")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("7")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("8")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("9")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("10")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "Ganador"));
		// tableResponseTo.add(getSecondRow("Olympics final, Men 100 meter",
		// "OlympicsfinalMen100meter"));
		// tableResponseTo.add(getRow1x2("Part 1111111111111111111111111111111",
		// getRandom(10,99), "10", getRandomUrl(), getRandomBookmakerImg(),
		// null));
		// tableResponseTo.add(getRow1x2("Part 2", "1.01", getRandom(10,99),
		// "http://www.bet365.com", "comparer/bookmaker/bet365.gif", null));
		// tableResponseTo.add(getRow1x2("Part 3", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 4", "5.3", "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 5", getRandom(10,99), "10",
		// "http://www.comeon.com", "comparer/bookmaker/betfred.gif", null));
		// tableResponseTo.add(getRow1x2("Part 6", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 7777777777777777777777777777777777777777777777777777",
		// getRandom(10,99), "10", "http://www.comeon.com",
		// getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 8", "5.3", "10",
		// "http://www.comeon.com", "comparer/bookmaker/betdaq.gif", null));
		// tableResponseTo.add(getRow1x2("Part 9", "5.3", "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 10", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 11", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// list.add(tableResponseTo);
		//
		// // Ganador
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("11")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "Ganador"));
		// tableResponseTo.add(getSecondRow("Olympics final, Men 100 meter",
		// "OlympicsfinalMen100meter"));
		// tableResponseTo.add(getRow1x2("Part 1111111111111111111111111111111",
		// getRandom(10,99), "10", getRandomUrl(), getRandomBookmakerImg(),
		// null));
		// tableResponseTo.add(getRow1x2("Part 2", "1.01", getRandom(10,99),
		// "http://www.bet365.com", "comparer/bookmaker/bet365.gif", null));
		// tableResponseTo.add(getRow1x2("Part 3", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 4", "5.3", "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 5", getRandom(10,99), "10",
		// "http://www.comeon.com", "comparer/bookmaker/betfred.gif", null));
		// tableResponseTo.add(getRow1x2("Part 6", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 7777777777777777777777777777777777777777777777777777",
		// getRandom(10,99), "10", "http://www.comeon.com",
		// getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 8", "5.3", "10",
		// "http://www.comeon.com", "comparer/bookmaker/betdaq.gif", null));
		// tableResponseTo.add(getRow1x2("Part 9", "5.3", "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 10", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// tableResponseTo.add(getRow1x2("Part 11", getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(), null));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("12")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("13")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("14")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("15")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("16")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		// // Ganador partido
		// tableResponseTo = new TableResponseTo();
		// tableResponseTo.setObjectToId(new ObjectToId("17")); // eventId +
		// fecha + betTypeId
		// dateD = new Date();
		//
		// tableResponseTo.add(getFirstRow(DATE.format(dateD),
		// TIME.format(dateD), "12"));
		// tableResponseTo.add(getSecondRow("Barcelona CF VS UD Las Palmas",
		// "BarcelonaCFVSUDLasPalmas"));
		// tableResponseTo.add(getRow1x2(null, "1.01", getRandom(10,99),
		// getRandomUrl(), "comparer/bookmaker/bet365.gif",
		// LiteralTableCommonTo.getLocal()));
		// tableResponseTo.add(getRow1x2(null, getRandom(10,99), "10",
		// "http://www.comeon.com", getRandomBookmakerImg(),
		// LiteralTableCommonTo.getVisitante()));
		// list.add(tableResponseTo);
		//
		return list;
	}

}
