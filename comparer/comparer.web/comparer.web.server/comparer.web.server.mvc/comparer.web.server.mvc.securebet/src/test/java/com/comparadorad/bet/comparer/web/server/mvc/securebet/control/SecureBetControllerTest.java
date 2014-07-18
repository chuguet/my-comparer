/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.securebet.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.test.web.server.request.DefaultRequestBuilder;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.request.SureBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.response.SureBetResponseTo;

/**
 * The Class SecureBetControllerTest.
 */
public class SecureBetControllerTest extends AbstractTrMvcControllerTest {

	/**
	 * Test get all sure bets.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public final void testGetAllSureBets() throws Exception {
//		SureBetRequestTo request = new SureBetRequestTo();
//		request.setPageNum(0l);
//		DefaultRequestBuilder requestBuilder = postJson(
//				"/secureBetController/getAllSureBet", request);
//
//		ObjectMapper mapper = new ObjectMapper();
//		SureBetResponseTo secureBetResponseTo = mapper.readValue(
//				super.perform(requestBuilder).andReturn().getResponse()
//						.getContentAsString(), SureBetResponseTo.class);
//		assertNotNull(secureBetResponseTo);
//		assertNotNull(secureBetResponseTo.getCount());
//		assertNotNull(secureBetResponseTo.getTableResponseTo().getRows());
//
//		for (TableResponseRowTo row : secureBetResponseTo.getTableResponseTo()
//				.getRows()) {
//			assertNotNull(row.getObjectToId().getId());
//			int i = 0;
//			for (TableResponseCellTo cell : row.getCellList()) {
//				switch (i) {
//				case 0:
//					assertNotNull(cell.getValueTo());
//					assertNotNull(cell.getValueTo().getDate());
//					assertNotNull(cell.getLinkTo());
//					assertNotNull(cell.getLinkTo().getName());
//					assertNotNull(cell.getLinkTo().getObjectToId());
//					assertNotNull(cell.getLinkTo().getObjectToId().getId());
//					// Bet type id
//					assertNotNull(cell.getLinkTo().getObjectToIdAux());
//					assertNotNull(cell.getLinkTo().getObjectToIdAux().getId());
//					// Bet type event id
//					assertNotNull(cell.getLinkTo().getObjectToIdAux2());
//					assertNotNull(cell.getLinkTo().getObjectToIdAux2().getId());
//					break;
//				case 1:
//					assertNotNull(cell.getValueTo().getValueStr());
//					break;
//				case 2:
//					assertNotNull(cell.getValueTo().getValueStr());
//					break;
//				case 3:
//					for (ExternalLinkTo externalLinkTo : cell
//							.getExternalLinkToList()) {
//						assertNotNull(externalLinkTo.getUrl());
//						assertNotNull(externalLinkTo.getBookmakerName());
//						assertNotNull(externalLinkTo.getLinkImgLocation());
//					}
//					break;
//				case 4:
//					for (ExternalLinkTo externalLinkTo : cell
//							.getExternalLinkToList()) {
//						assertNotNull(externalLinkTo.getLinkText());
//						assertNotNull(externalLinkTo.getBookmakerName());
//						assertNotNull(externalLinkTo.getUrl());
//					}
//					break;
//				case 5:
//					assertNotNull(cell.getValueTo().getValueStr());
//					break;
//				}
//				i++;
//			}
//		}
	}

	/**
	 * Test get one sure bet.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public final void testGetOneSureBet() throws Exception {
		SureBetRequestTo request = new SureBetRequestTo();

		request.setSureBetId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/secureBetController/getOneSureBet", request);

		ObjectMapper mapper = new ObjectMapper();
		SureBetResponseTo secureBetResponseTo = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), SureBetResponseTo.class);

		assertNotNull(secureBetResponseTo);
		assertNotNull(secureBetResponseTo.getTableResponseTo());
		assertNotNull(secureBetResponseTo.getTableResponseTo().getRows());
		assertEquals(secureBetResponseTo.getTableResponseTo().getRows().size(),
				1);

		TableResponseRowTo row = secureBetResponseTo.getTableResponseTo()
				.getRows().get(0);
		assertNotNull(row.getObjectToId().getId());
		int i = 0;
		for (TableResponseCellTo cell : row.getCellList()) {
			switch (i) {
			case 0:
				assertNotNull(cell.getValueTo());
				assertNotNull(cell.getValueTo().getDate());
				assertNotNull(cell.getLinkTo());
				assertNotNull(cell.getLinkTo().getName());
				assertNotNull(cell.getLinkTo().getObjectToId());
				assertNotNull(cell.getLinkTo().getObjectToId().getId());
				// Bet type id
				assertNotNull(cell.getLinkTo().getObjectToIdAux());
				assertNotNull(cell.getLinkTo().getObjectToIdAux().getId());
				// Bet type event id
				assertNotNull(cell.getLinkTo().getObjectToIdAux2());
				assertNotNull(cell.getLinkTo().getObjectToIdAux2().getId());
				break;
			case 1:
				assertNotNull(cell.getValueTo().getValueStr());
				break;
			case 2:
				assertNotNull(cell.getValueTo().getValueStr());
				break;
			case 3:
				for (ExternalLinkTo externalLinkTo : cell
						.getExternalLinkToList()) {
					assertNotNull(externalLinkTo.getUrl());
					assertNotNull(externalLinkTo.getActionAnalytics());
					assertNotNull(externalLinkTo.getCategoryAnalytics());
					assertNotNull(externalLinkTo.getLinkImgLocation());
				}
				break;
			case 4:
				for (ExternalLinkTo externalLinkTo : cell
						.getExternalLinkToList()) {
					assertNotNull(externalLinkTo.getLinkText());
					assertNotNull(externalLinkTo.getActionAnalytics());
					assertNotNull(externalLinkTo.getCategoryAnalytics());
					assertNotNull(externalLinkTo.getUrl());
				}
				break;
			case 5:
				assertNotNull(cell.getValueTo().getValueStr());
				break;
			}
			i++;
		}
	}

	/**
	 * Test get one sure bet invalid id.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public final void testGetOneSureBetInvalidId() throws Exception {
		SureBetRequestTo request = new SureBetRequestTo();

		request.setSureBetId(new ObjectToId("37649754a87f656f"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/secureBetController/getOneSureBet", request);

		ObjectMapper mapper = new ObjectMapper();
		SureBetResponseTo secureBetResponseTo = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), SureBetResponseTo.class);

		assertNotNull(secureBetResponseTo);
		assertNotNull(secureBetResponseTo.getTableResponseTo());
		assertNull(secureBetResponseTo.getTableResponseTo().getRows());
	}

}
