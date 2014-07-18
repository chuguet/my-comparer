/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.valuebet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.server.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.junit.Test;
import org.springframework.test.web.server.request.DefaultRequestBuilder;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.request.ValueBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.response.ValueBetResponseTo;
import com.google.gson.Gson;

public class ValueBetControllerTest extends AbstractTrMvcControllerTest {

	/**
	 * Test value bet controller.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public final void testValueBetController() throws Exception {
//		ValueBetRequestTo valueBetRequestTo = new ValueBetRequestTo();
//		Gson gson = new Gson();
//		DefaultRequestBuilder requestBuilder = postJson(
//				"/valueBetController/getValueBet", valueBetRequestTo);
//		ValueBetResponseTo valueBetResponseTo = gson.fromJson(
//				super.perform(requestBuilder).andReturn().getResponse()
//						.getContentAsString(), ValueBetResponseTo.class);
//		
//		List<TableResponseRowTo> rows =  valueBetResponseTo.getTableResponseTo().getRows();
//		assertNotNull(rows);
//		
//		List<TableResponseCellTo> cellList;
//		TableResponseCellTo event;
//		TableResponseCellTo betType;
//		TableResponseCellTo result;		
//		TableResponseCellTo bookmaker;
//		TableResponseCellTo odds;
//		TableResponseCellTo probability;
//		TableResponseCellTo mathematicalExpectation;
//		for (TableResponseRowTo row : rows) {
//			if(row.getObjectToId().getId().equals("21229219")) {
//				cellList = row.getCellList();
//				assertNotNull(cellList);
//				assertEquals(cellList.size(), 7);
//				event = cellList.get(0);
//				betType = cellList.get(1);			
//				result = cellList.get(2);
//				bookmaker = cellList.get(3);
//				odds = cellList.get(4);
//				probability = cellList.get(5);
//				mathematicalExpectation = cellList.get(6);
//				
//				assertNotNull(row.getObjectToId());
//				assertEquals(row.getObjectToId().getId(), "21229219");
//				assertNotNull(event.getValueTo());
//				assertNotNull(event.getValueTo().getDate());
//				assertNotNull(event.getLinkTo());
//				String name = event.getLinkTo().getName();
//				assertNotNull(name);
//				assertEquals(name, "Atletico de Madrid Vs Malaga|Fútbol|España|La liga");
//				assertNotNull(event.getLinkTo().getObjectToId());
//				assertNotNull(event.getLinkTo().getObjectToId().getId());
//				assertEquals(event.getLinkTo().getObjectToId().getId(), "21229");
//				// Bet type id
//				assertNotNull(event.getLinkTo().getObjectToIdAux());
//				assertNotNull(event.getLinkTo().getObjectToIdAux().getId());
//				assertEquals(event.getLinkTo().getObjectToIdAux().getId(), "1");
//				// Bet type event id
//				assertNotNull(event.getLinkTo().getObjectToIdAux2());
//				assertNotNull(event.getLinkTo().getObjectToIdAux2().getId());
//				assertEquals(event.getLinkTo().getObjectToIdAux2().getId(), "1");
//				
//				assertNotNull(betType.getValueTo());
//				assertNotNull(betType.getValueTo().getValueStr());
//				assertEquals(betType.getValueTo().getValueStr(), "1 x 2");
//				
//				assertNotNull(result.getValueTo());
//				assertNotNull(result.getValueTo().getValueStr());
//				assertEquals(result.getValueTo().getValueStr(), "Empate");
//
//				assertNotNull(bookmaker.getExternalLinkTo());
//				assertNotNull(bookmaker.getExternalLinkTo().getLinkImgLocation());
//				assertNotNull(bookmaker.getExternalLinkTo().getUrl());
//				
//				assertNotNull(odds.getExternalLinkTo());
//				assertNotNull(odds.getExternalLinkTo().getLinkText());
//				assertNotNull(odds.getExternalLinkTo().getUrl());
//				
//				assertNotNull(probability.getValueTo());
//				assertNotNull(probability.getValueTo().getValueStr());
//				
//				assertNotNull(mathematicalExpectation.getValueTo());
//				assertNotNull(mathematicalExpectation.getValueTo().getValueStr());
//			}
//
//		}
		
	}
	
}
