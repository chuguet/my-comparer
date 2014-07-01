package com.comparadorad.bet.comparer.web.client.gwt.results.ui.event.dummy;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.ui.dummy.GenericDummy;
import com.comparadorad.bet.comparer.web.client.gwt.results.ui.view.table.TableFactory.BetTypeEvent;

public class TableHandicapAsiaticoDummy extends GenericDummy{

	public List<TableResponseTo> getTableData(String pBetTypeEventId) {
		List<TableResponseTo> list = new ArrayList<TableResponseTo>();

		if (pBetTypeEventId
				.equalsIgnoreCase(BetTypeEvent.FINAL_PARTIDO.getId())) {
			TableResponseTo tableResponseTo = new TableResponseTo();
			tableResponseTo.setObjectToId(new ObjectToId("HandAs1"));
			tableResponseTo.add(getRowWithBetValue("betFred",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] {
							"3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com",
							getRandomUrl() }, "98%", "+1.5"));
			tableResponseTo.add(getRowWithBetValue("bet365", getRandomBookmakerImgSmall(),
					"Betfred", getRandomUrl(), new String[] {
							"3.5", getRandom(10, 99) },
					new String[] {
							"http://www.betfred.com", getRandomUrl() },
					getRandomPayout(), "+1.5"));
			tableResponseTo.add(getRowWithBetValue("10bet", getRandomBookmakerImgSmall(),
					"Betfred", "http://www.betfred.com", new String[] { "1.2",
							getRandom(10, 99) },
					new String[] { "http://www.betfred.com",
							getRandomUrl() }, "92%", "+1.5"));
			tableResponseTo.add(getRowWithBetValue("comeon",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] {
							"3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com",
							getRandomUrl() }, "95%", "+1.5"));
			tableResponseTo.add(getRow(new String[] {"6.2",
					"1.2", "93%" }));
			tableResponseTo.add(getRow(new String[] { getRandom(10, 99),
					"1.2", "93%" }));
			tableResponseTo.add(getRow(new String[] { "6.2",
					"1.2" }));
			list.add(tableResponseTo);
		}
		
		if (pBetTypeEventId
				.equalsIgnoreCase(BetTypeEvent.FINAL_PRIMERA_PARTE.getId())) {
			TableResponseTo tableResponseTo = new TableResponseTo();
			tableResponseTo.setObjectToId(new ObjectToId("HandAs2"));
			tableResponseTo.add(getRowWithBetValue("betFred",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] {
							"3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com",
							getRandomUrl() }, "98%", "+1.5"));
			tableResponseTo.add(getRowWithBetValue("bet365", getRandomBookmakerImgSmall(),
					"Betfred", getRandomUrl(), new String[] {
							"3.5", getRandom(10, 99) },
					new String[] {
							"http://www.betfred.com", getRandomUrl() },
					getRandomPayout(), "+1.5"));
			tableResponseTo.add(getRowWithBetValue("10bet", getRandomBookmakerImgSmall(),
					"Betfred", "http://www.betfred.com", new String[] { "1.2",
							getRandom(10, 99) },
					new String[] { "http://www.betfred.com",
							getRandomUrl() }, "92%", "+1.5"));
			tableResponseTo.add(getRowWithBetValue("comeon",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] {
							"3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com",
							getRandomUrl() }, "95%", "+1.5"));
			tableResponseTo.add(getRow(new String[] {"6.2",
					"1.2", "93%" }));
			tableResponseTo.add(getRow(new String[] { getRandom(10, 99),
					"1.2", "93%" }));
			tableResponseTo.add(getRow(new String[] { "6.2",
					"1.2" }));
			list.add(tableResponseTo);
		}
		
		if (pBetTypeEventId
				.equalsIgnoreCase(BetTypeEvent.FINAL_SEGUNDA_PARTE.getId())) {
			TableResponseTo tableResponseTo = new TableResponseTo();
			tableResponseTo.setObjectToId(new ObjectToId("HandAs3"));
			tableResponseTo.add(getRowWithBetValue("betFred",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] {
							"3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com",
							getRandomUrl() }, "98%", "+1.5"));
			tableResponseTo.add(getRowWithBetValue("bet365", getRandomBookmakerImgSmall(),
					"Betfred", getRandomUrl(), new String[] {
							"3.5", getRandom(10, 99) },
					new String[] {
							"http://www.betfred.com", getRandomUrl() },
					getRandomPayout(), "+1.5"));
			tableResponseTo.add(getRowWithBetValue("10bet", getRandomBookmakerImgSmall(),
					"Betfred", "http://www.betfred.com", new String[] { "1.2",
							getRandom(10, 99) },
					new String[] { "http://www.betfred.com",
							getRandomUrl() }, "92%", "+1.5"));
			tableResponseTo.add(getRowWithBetValue("comeon",
					"comparer/bookmaker/betfred.gif", "Betfred",
					"http://www.betfred.com", new String[] {
							"3.5", getRandom(10, 99) }, new String[] {
							"http://www.betfred.com",
							getRandomUrl() }, "95%", "+1.5"));
			tableResponseTo.add(getRow(new String[] {"6.2",
					"1.2", "93%" }));
			tableResponseTo.add(getRow(new String[] { getRandom(10, 99),
					"1.2", "93%" }));
			tableResponseTo.add(getRow(new String[] { "6.2",
					"1.2" }));
			list.add(tableResponseTo);
		}
		
		return list;
	}
	
}
