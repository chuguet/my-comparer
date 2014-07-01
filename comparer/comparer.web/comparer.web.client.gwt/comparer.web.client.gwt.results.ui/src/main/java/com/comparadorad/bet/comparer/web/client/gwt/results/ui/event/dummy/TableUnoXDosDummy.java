package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.dummy;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetTypeEvent;

public class TableUnoXDosDummy extends GenericDummy {

	public List<TableResponseTo> getTableData(String pBetTypeEventId) {

		List<TableResponseTo> list = new ArrayList<TableResponseTo>();
		
		if (pBetTypeEventId
				.equalsIgnoreCase(BetTypeEvent.FINAL_PARTIDO.getId())) {
			TableResponseTo tableResponseTo = new TableResponseTo();
			tableResponseTo.setObjectToId(new ObjectToId("11"));
			tableResponseTo.add(getRow("betFred",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] { getRandom(10, 99), "3.5",
							getRandom(10, 99) }, new String[] {
							"http://www.betfred.com", "http://www.betfred.com",
							getRandomUrl() }, "98%"));
			tableResponseTo.add(getRow("bet365", getRandomBookmakerImgSmall(),
					"Betfred", getRandomUrl(), new String[] {
							getRandom(10, 99), "3.5", getRandom(10, 99) },
					new String[] { "http://www.betfred.com",
							"http://www.betfred.com", getRandomUrl()}, getRandomPayout()));
			tableResponseTo.add(getRow("10bet", getRandomBookmakerImgSmall(),
					"Betfred", "http://www.betfred.com", new String[] { "1.2",
							getRandom(10, 99), getRandom(10, 99) },
					new String[] { "http://www.betfred.com",
							"http://www.betfred.com", getRandomUrl()}, "92%"));
			tableResponseTo.add(getRow("comeon",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] { getRandom(10, 99),
							"3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com", "http://www.betfred.com",
							getRandomUrl()}, "95%"));
			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2"}));
			list.add(tableResponseTo);

//			tableResponseTo = new TableResponseTo();
//			tableResponseTo.setObjectToId(new ObjectToId("12"));
//			tableResponseTo.add(getRow("betFred",
//					"comparer/bookmaker/betfred.gif", "Betfred",
//					"http://www.betfred.com", new String[] { getRandom(10, 99), "3.5",
//							getRandom(10, 99) }, new String[] {
//							"http://www.betfred.com", "http://www.betfred.com",
//							getRandomUrl() }, "98%"));
//			tableResponseTo.add(getRow("bet365", getRandomBookmakerImg(),
//					"Betfred", getRandomUrl(), new String[] {
//							getRandom(10, 99), "3.5", getRandom(10, 99) },
//					new String[] { "http://www.betfred.com",
//							"http://www.betfred.com", getRandomUrl()}, getRandomPayout()));
//			tableResponseTo.add(getRow("10bet", getRandomBookmakerImg(),
//					"Betfred", "http://www.betfred.com", new String[] { "1.2",
//							getRandom(10, 99), getRandom(10, 99) },
//					new String[] { "http://www.betfred.com",
//							"http://www.betfred.com", getRandomUrl()}, "92%"));
//			tableResponseTo.add(getRow("comeon",
//					"comparer/bookmaker/betfred.gif", "Betfred",
//					"http://www.betfred.com", new String[] { getRandom(10, 99),
//							"3.5", getRandom(10, 99) }, new String[] {
//							"http://www.betfred.com", "http://www.betfred.com",
//							getRandomUrl()}, "95%"));
//			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
//			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
//			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2"}));
//			list.add(tableResponseTo);
//
//			tableResponseTo = new TableResponseTo();
//			tableResponseTo.setObjectToId(new ObjectToId("13"));
//			tableResponseTo.add(getRow("betFred",
//					"comparer/bookmaker/betfred.gif", "Betfred",
//					"http://www.betfred.com", new String[] { getRandom(10, 99), "3.5",
//							getRandom(10, 99) }, new String[] {
//							"http://www.betfred.com", "http://www.betfred.com",
//							getRandomUrl() }, "98%"));
//			tableResponseTo.add(getRow("bet365", getRandomBookmakerImg(),
//					"Betfred", getRandomUrl(), new String[] {
//							getRandom(10, 99), "3.5", getRandom(10, 99) },
//					new String[] { "http://www.betfred.com",
//							"http://www.betfred.com", getRandomUrl()}, getRandomPayout()));
//			tableResponseTo.add(getRow("10bet", getRandomBookmakerImg(),
//					"Betfred", "http://www.betfred.com", new String[] { "1.2",
//							getRandom(10, 99), getRandom(10, 99) },
//					new String[] { "http://www.betfred.com",
//							"http://www.betfred.com", getRandomUrl()}, "92%"));
//			tableResponseTo.add(getRow("comeon",
//					"comparer/bookmaker/betfred.gif", "Betfred",
//					"http://www.betfred.com", new String[] { getRandom(10, 99),
//							"3.5", getRandom(10, 99) }, new String[] {
//							"http://www.betfred.com", "http://www.betfred.com",
//							getRandomUrl()}, "95%"));
//			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
//			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
//			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2"}));
//			list.add(tableResponseTo);

		}
		else if (pBetTypeEventId
				.equalsIgnoreCase(BetTypeEvent.FINAL_PRIMERA_PARTE.getId())) {
			TableResponseTo tableResponseTo = new TableResponseTo();
			tableResponseTo.setObjectToId(new ObjectToId("21"));
			tableResponseTo.add(getRow("betFred",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] { getRandom(10, 99), "3.5",
							getRandom(10, 99) }, new String[] {
							"http://www.betfred.com", "http://www.betfred.com",
							getRandomUrl() }, "98%"));
			tableResponseTo.add(getRow("bet365", getRandomBookmakerImgSmall(),
					"Betfred", getRandomUrl(), new String[] {
							getRandom(10, 99), "3.5", getRandom(10, 99) },
					new String[] { "http://www.betfred.com",
							"http://www.betfred.com", getRandomUrl()}, getRandomPayout()));
			tableResponseTo.add(getRow("10bet", getRandomBookmakerImgSmall(),
					"Betfred", "http://www.betfred.com", new String[] { "1.2",
							getRandom(10, 99), getRandom(10, 99) },
					new String[] { "http://www.betfred.com",
							"http://www.betfred.com", getRandomUrl()}, "92%"));
			tableResponseTo.add(getRow("comeon",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] { getRandom(10, 99),
							"3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com", "http://www.betfred.com",
							getRandomUrl()}, "95%"));
			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2"}));
			list.add(tableResponseTo);
		}
		else if (pBetTypeEventId
				.equalsIgnoreCase(BetTypeEvent.FINAL_SEGUNDA_PARTE.getId())) {
			TableResponseTo tableResponseTo = new TableResponseTo();
			tableResponseTo.setObjectToId(new ObjectToId("31"));
			tableResponseTo.add(getRow("betFred",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] { getRandom(10, 99), "3.5",
							getRandom(10, 99) }, new String[] {
							"http://www.betfred.com", "http://www.betfred.com",
							getRandomUrl() }, "98%"));
			tableResponseTo.add(getRow("bet365", getRandomBookmakerImgSmall(),
					"Betfred", getRandomUrl(), new String[] {
							getRandom(10, 99), "3.5", getRandom(10, 99) },
					new String[] { "http://www.betfred.com",
							"http://www.betfred.com", getRandomUrl()}, getRandomPayout()));
			tableResponseTo.add(getRow("10bet", getRandomBookmakerImgSmall(),
					"Betfred", "http://www.betfred.com", new String[] { "1.2",
							getRandom(10, 99), getRandom(10, 99) },
					new String[] { "http://www.betfred.com",
							"http://www.betfred.com", getRandomUrl()}, "92%"));
			tableResponseTo.add(getRow("comeon",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] { getRandom(10, 99),
							"3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com", "http://www.betfred.com",
							getRandomUrl()}, "95%"));
			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2", "93%"}));
			tableResponseTo.add(getRow(new String[] {getRandom(10,99), "6.2", "1.2"}));
			list.add(tableResponseTo);
		}

		return list;
	}

}
