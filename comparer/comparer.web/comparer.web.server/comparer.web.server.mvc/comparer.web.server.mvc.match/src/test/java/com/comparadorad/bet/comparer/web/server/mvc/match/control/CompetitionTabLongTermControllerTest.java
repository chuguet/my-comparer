/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.test.web.server.request.DefaultRequestBuilder;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * The Class CompetitionTabLongTermControllerTest.
 */
public class CompetitionTabLongTermControllerTest extends
		AbstractTrMvcControllerTest {

	/**
	 * Test get country events competition.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetOdds() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		ObjectToId betTypeId = new ObjectToId();
		betTypeId.setId("3");
		competitionRequestTo.setBetTypeIdFirstLevel(betTypeId);
		ObjectToId eventId = new ObjectToId();
		eventId.setId("25203425201276359656751413882");
		competitionRequestTo.setEventId(eventId);
		DefaultRequestBuilder requestBuilder = postJson(
				"/competitionLongTermController/getBetOdds",
				competitionRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		TableResponseTo table = mapper.readValue(super.perform(requestBuilder)
				.andReturn().getResponse().getContentAsString(),
				TableResponseTo.class);

		// Controlar que la tabla viene con rows
		assertNotNull(table);
		assertNotNull(table.getRows());

		String oddOld = "0";
		String oddNew;

		// Controlar las filas de la tabla
		List<String> rowIds = new ArrayList<String>();
		for (TableResponseRowTo row : table.getRows()) {

			// Controlar que la fila tiene id (unico) y entre 4 y 6 celdas
			assertNotNull(row);
			assertNotNull(row.getObjectToId());
			assertNotNull(row.getObjectToId().getId());
			assertTrue(!row.getObjectToId().getId().isEmpty());
			assertTrue(!rowIds.contains(row.getObjectToId().getId()));
			rowIds.add(row.getObjectToId().getId());

			assertNotNull(row.getCellList());
			assertTrue(row.getCellList().size() >= 4);
			assertTrue(row.getCellList().size() <= 6);

			// Celda 0, 1 y 2 - ValueStr
			for (int colNum = 0; colNum < 3; colNum++) {
				TableResponseCellTo cell = row.getCellList().get(colNum);
				assertNotNull(cell.getValueTo());
				assertNotNull(cell.getValueTo().getValueStr());
				assertTrue(!cell.getValueTo().getValueStr().isEmpty());
				// Verificar que las celdas con la couta estan ordenadas
				// ascendentemente
				if (colNum == 2) {
					oddNew = cell.getValueTo().getValueStr().replace(",", ".");
					assertTrue(Double.valueOf(oddNew) >= Double.valueOf(oddOld));
					oddOld = oddNew;
				}
			}

			// Celda 3 (4 y 5) - External link con imagen
			for (int colNum = 3; colNum < row.getCellList().size(); colNum++) {
				TableResponseCellTo cell = row.getCellList().get(colNum);
				assertNotNull(cell);
				assertNotNull(cell.getExternalLinkTo());
				assertNotNull(cell.getExternalLinkTo().getLinkImgLocation());
				assertNotNull(cell.getExternalLinkTo().getUrl());
				assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
				assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
			}
		}
	}

	/**
	 * Test get country tab event1.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetTypes() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		competitionRequestTo.setEventId(new ObjectToId(
				"25203425201276359656751413882"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/competitionLongTermController/getBetTypes",
				competitionRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		TableResponseTo table = mapper.readValue(super.perform(requestBuilder)
				.andReturn().getResponse().getContentAsString(),
				TableResponseTo.class);

		assertNotNull(table);
		for (TableResponseRowTo row : table.getRows()) {
			assertNotNull(row.getObjectToId().getId());
			int i = 0;
			for (TableResponseCellTo cell : row.getCellList()) {
				if (i != 0) {
					assertNotNull(cell.getValueTo().getValueStr());
				}
				i++;
			}
		}

	}

	/**
	 * Test get head.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetHead() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		competitionRequestTo.setCompetitionId(new ObjectToId("26"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/competitionLongTermController/getHead", competitionRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		HeadResponseTo head = mapper.readValue(super.perform(requestBuilder)
				.andReturn().getResponse().getContentAsString(),
				HeadResponseTo.class);

		assertNotNull(head);
		assertNotNull(head.getResourceTo().getLocation());
		assertNotNull(head.getTitle());
		int i = 0;
		for (LinkTo link : head.getLinkTos()) {
			assertNotNull(link.getName());
			assertNotNull(link.getObjectToId().getId());
			if (i == 1) {
				assertNotNull(link.getObjectToIdAux().getId());
			}
			i++;
		}
	}
	
	/**
	 * Gets the head bug4167 test.
	 *
	 * @return the head bug4167 test
	 * @throws Exception the exception
	 */
	@Test
	public void getHeadBug4167Test() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		competitionRequestTo.setCompetitionId(new ObjectToId("48"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/competitionLongTermController/getHead", competitionRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		HeadResponseTo head = mapper.readValue(super.perform(requestBuilder)
				.andReturn().getResponse().getContentAsString(),
				HeadResponseTo.class);

		assertNotNull(head);
		assertNotNull(head.getResourceTo().getLocation());
		assertNotNull(head.getTitle());
		int i = 0;
		for (LinkTo link : head.getLinkTos()) {
			assertNotNull(link.getName());
			assertNotNull(link.getObjectToId().getId());
			if (i == 1) {
				assertNotNull(link.getObjectToIdAux().getId());
			}
			i++;
		}
	}

	/**
	 * Test get country tab event3.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetMatchs() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		competitionRequestTo.setCompetitionId(new ObjectToId("26"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/competitionLongTermController/getMatchs",
				competitionRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		TableResponseTo table = mapper.readValue(super.perform(requestBuilder)
				.andReturn().getResponse().getContentAsString(),
				TableResponseTo.class);

		assertNotNull(table);
		for (TableResponseRowTo row : table.getRows()) {
			assertNotNull(row.getObjectToId().getId());
			int i = 0;
			for (TableResponseCellTo cell : row.getCellList()) {
				switch (i) {
				case 0:
					assertNotNull(cell.getResources().get(0).getLocation());
					break;
				case 1:
					assertNotNull(cell.getLinkTo().getObjectToId().getId());
					assertNotNull(cell.getLinkTo().getName());
					break;
				case 2:
					assertNotNull(cell.getValueTo().getValueStr());
					break;
				}
				i++;
			}
		}

	}
	
	/**
	 * Gets the matchs bug4167 test. 
	 *
	 * @return the matchs bug4167 test
	 * @throws Exception the exception
	 */
	@Test
	public void getMatchsBug4167Test() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		competitionRequestTo.setCompetitionId(new ObjectToId("48"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/competitionLongTermController/getMatchs",
				competitionRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		TableResponseTo table = mapper.readValue(super.perform(requestBuilder)
				.andReturn().getResponse().getContentAsString(),
				TableResponseTo.class);

		assertNotNull(table);
		assertNull(table.getRows());

	}
	
}
