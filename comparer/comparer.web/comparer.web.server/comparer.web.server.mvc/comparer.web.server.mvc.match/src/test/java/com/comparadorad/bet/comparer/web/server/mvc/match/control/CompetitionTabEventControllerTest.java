/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.junit.Test;
import org.springframework.test.web.server.request.DefaultRequestBuilder;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.HeadResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CompetitionRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseDataTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * The Class EventOddsControllerTest.
 */
public class CompetitionTabEventControllerTest extends
		AbstractTrMvcControllerTest {

	/**
	 * Gets the bet odds1 x2 test.
	 * 
	 * @return the bet odds1 x2 test
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getBetOdds1X2Test() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		String betTypeId = "1"; // 1X2
		competitionRequestTo.setBetTypeIdFirstLevel(new ObjectToId(betTypeId));
		competitionRequestTo.setCompetitionId(new ObjectToId("48"));
		List<TableResponseTo> tables = getCompetitionTabEventTable(competitionRequestTo);
		for (TableResponseTo table : tables) {
			// Controlar que la tabla viene con id, titulo y rows
			assertNotNull(table.getObjectToId());
			assertNotNull(table.getTitle());
			assertNotNull(table.getRows());

			// Celda 0 del titulo - Fecha
			assertNotNull(table.getTitle().getCellList());
			assertNotNull(table.getTitle().getCellList().get(0));
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo());
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo()
					.getDate());

			// Controlar las filas de la tabla
			List<String> rowIds = new ArrayList<String>();
			for (TableResponseRowTo row : table.getRows()) {
				// Controlar que la fila tiene id (unico) y 5 celdas
				assertNotNull(row);
				assertNotNull(row.getCellList());
				assertEquals(row.getCellList().size(), 5);
				assertNotNull(row.getObjectToId());
				assertNotNull(row.getObjectToId().getId());
				assertTrue(!row.getObjectToId().getId().isEmpty());
				assertTrue(!rowIds.contains(row.getObjectToId().getId()));
				rowIds.add(row.getObjectToId().getId());

				// Celda 0 - Fecha
				assertNotNull(row.getCellList().get(0));
				assertNotNull(row.getCellList().get(0).getValueTo());
				assertNotNull(row.getCellList().get(0).getValueTo().getDate());

				// Celda 1 - Internal Link con id del evento y de la apuesta
				assertNotNull(row.getCellList().get(1));
				assertNotNull(row.getCellList().get(1).getLinkTo());
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToId()); // Id del evento
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToId().getId());
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToIdAux()); // Id de la apuesta
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToIdAux().getId());
				assertEquals(row.getCellList().get(1).getLinkTo()
						.getObjectToIdAux().getId(), betTypeId);
				assertNotNull(row.getCellList().get(1).getLinkTo().getName());

				// Celda 2 a 4 - External link
				for (int i = 2; i < row.getCellList().size(); i++) {
					TableResponseCellTo cell = row.getCellList().get(i);
					assertNotNull(cell);
					assertNotNull(cell.getExternalLinkTo());
					assertNotNull(cell.getExternalLinkTo().getLinkImgLocation());
					assertNotNull(cell.getExternalLinkTo().getLinkText());
					assertNotNull(cell.getExternalLinkTo().getUrl());
					assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
					assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
				}
			}
		}
	}

	/**
	 * Gets the bet odds ganador partido test.
	 * 
	 * @return the bet odds ganador partido test
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getBetOddsGanadorPartidoTest() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		String betTypeId = "2"; // Ganador de Partido
		competitionRequestTo.setBetTypeIdFirstLevel(new ObjectToId(betTypeId));
		competitionRequestTo.setCompetitionId(new ObjectToId("48"));
		List<TableResponseTo> tables = getCompetitionTabEventTable(competitionRequestTo);

		for (TableResponseTo table : tables) {
			// Controlar que la tabla viene con id, titulo y rows
			assertNotNull(table.getObjectToId());
			assertNotNull(table.getTitle());
			assertNotNull(table.getRows());

			// Celda 0 - Fecha
			assertNotNull(table.getTitle().getCellList());
			assertNotNull(table.getTitle().getCellList().get(0));
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo());
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo()
					.getDate());

			// Controlar las filas de la tabla
			List<String> rowIds = new ArrayList<String>();
			for (TableResponseRowTo row : table.getRows()) {
				// Controlar que la fila tiene id (unico) y 4 celdas
				assertNotNull(row);
				assertNotNull(row.getCellList());
				assertEquals(row.getCellList().size(), 4);
				assertNotNull(row.getObjectToId());
				assertNotNull(row.getObjectToId().getId());
				assertTrue(!row.getObjectToId().getId().isEmpty());
				assertTrue(!rowIds.contains(row.getObjectToId().getId()));
				rowIds.add(row.getObjectToId().getId());

				// Celda 0 - Fecha
				assertNotNull(row.getCellList().get(0));
				assertNotNull(row.getCellList().get(0).getValueTo());
				assertNotNull(row.getCellList().get(0).getValueTo().getDate());

				// Celda 1 - Internal Link con id del evento y de la apuesta
				assertNotNull(row.getCellList().get(1));
				assertNotNull(row.getCellList().get(1).getLinkTo());
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToId()); // Id del evento
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToId().getId());
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToIdAux()); // Id de la apuesta
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToIdAux().getId());
				assertEquals(row.getCellList().get(1).getLinkTo()
						.getObjectToIdAux().getId(), betTypeId);
				assertNotNull(row.getCellList().get(1).getLinkTo().getName());

				// Celda 2 a 3 - External link
				for (int i = 2; i < row.getCellList().size(); i++) {
					TableResponseCellTo cell = row.getCellList().get(i);
					assertNotNull(cell);
					assertNotNull(cell.getExternalLinkTo());
					assertNotNull(cell.getExternalLinkTo().getLinkImgLocation());
					assertNotNull(cell.getExternalLinkTo().getLinkText());
					assertNotNull(cell.getExternalLinkTo().getUrl());
					assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
					assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
				}
			}
		}
	}

	/**
	 * Gets the bet odds test.
	 * 
	 * @return the bet odds test
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getBetOddsGanadorTest() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo();
		String betTypeId = "3"; // Ganador
		competitionRequestTo.setBetTypeIdFirstLevel(new ObjectToId(betTypeId));
		competitionRequestTo.setCompetitionId(new ObjectToId("48"));
		List<TableResponseTo> tables = getCompetitionTabEventTable(competitionRequestTo);
		for (TableResponseTo table : tables) {

			// Controlar que la tabla viene con id, titulo y rows
			assertNotNull(table.getObjectToId());
			assertNotNull(table.getTitle());
			assertNotNull(table.getRows());

			// Celda 0 del titulo - Fecha
			assertNotNull(table.getTitle().getCellList());
			assertNotNull(table.getTitle().getCellList().get(0));
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo());
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo()
					.getDate());

			// Controlar las filas de la tabla
			List<String> rowIds = new ArrayList<String>();
			for (TableResponseRowTo row : table.getRows()) {
				// Controlar que la fila tiene id y que sea unico
				assertNotNull(row);
				assertNotNull(row.getObjectToId());
				assertNotNull(row.getObjectToId().getId());
				assertTrue(!row.getObjectToId().getId().isEmpty());
				assertTrue(!rowIds.contains(row.getObjectToId().getId()));
				rowIds.add(row.getObjectToId().getId());

				// Celda 0 - Fecha
				assertNotNull(row.getCellList());
				assertNotNull(row.getCellList().get(0));
				assertNotNull(row.getCellList().get(0).getValueTo());
				assertNotNull(row.getCellList().get(0).getValueTo().getDate());

				// Celda 1 - Internal Link con id del evento y de la apuesta
				assertNotNull(row.getCellList().get(1));
				assertNotNull(row.getCellList().get(1).getLinkTo());
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToId()); // Id del evento
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToId().getId());
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToIdAux()); // Id de la apuesta
				assertNotNull(row.getCellList().get(1).getLinkTo()
						.getObjectToIdAux().getId());
				assertEquals(row.getCellList().get(1).getLinkTo()
						.getObjectToIdAux().getId(), betTypeId);
				assertNotNull(row.getCellList().get(1).getLinkTo().getName());

				// Celda 2 a 4 - External link, verificar que las celdas con la
				// couta estan ordenadas
				// ascendentemente
				String oddOld = "0"; // Valor inicial alto
				String oddNew;
				for (int i = 2; i < row.getCellList().size(); i++) {
					TableResponseCellTo cell = row.getCellList().get(i);
					assertNotNull(cell);
					assertNotNull(cell.getExternalLinkTo());
					assertNotNull(cell.getExternalLinkTo().getLinkImgLocation());
					assertNotNull(cell.getExternalLinkTo().getLinkText());
					assertNotNull(cell.getExternalLinkTo().getUrl());
					assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
					assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
					oddNew = cell.getExternalLinkTo().getLinkText()
							.replace(",", ".");
					assertTrue(Double.valueOf(oddNew) >= Double.valueOf(oddOld));
					oddOld = oddNew;
				}
			}
		}
	}

	/**
	 * Test.
	 * 
	 * @return the bet types test
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getBetTypesTest() throws Exception {
		CompetitionRequestTo competitionRequestTo = new CompetitionRequestTo(
				new ObjectToId("48"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/competitionEventController/getBetTypes", competitionRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		TabResponseTo tabResponse = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), TabResponseTo.class);

		assertEquals(2, tabResponse.getTabs().size());
		for (TabResponseDataTo tab : tabResponse.getTabs()) {
			assertNotNull(tab.getName());
			assertNotNull(tab.getId());
			assertNotNull(tab.getId().getId());
		}
		// Orden debe ser 1x2, Gandor Partido, Ganador
		assertEquals("1 x 2" , tabResponse.getTabs().get(0).getName());
		assertEquals("1" , tabResponse.getTabs().get(0).getId().getId());
		assertEquals("Ganador de partido" , tabResponse.getTabs().get(1).getName());
		assertEquals("2" , tabResponse.getTabs().get(1).getId().getId());
	}

	/**
	 * Gets the competition tab event table.
	 * 
	 * @param competitionRequestTo
	 *            the competition request to
	 * @return the competition tab event table
	 * @throws Exception
	 *             the exception
	 */
	private List<TableResponseTo> getCompetitionTabEventTable(
			CompetitionRequestTo competitionRequestTo) throws Exception {
		DefaultRequestBuilder requestBuilder = postJson(
				"/competitionEventController/getBetOdds", competitionRequestTo);
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, TableResponseTo.class);
		return mapper.readValue(super.perform(requestBuilder).andReturn()
				.getResponse().getContentAsString(), type);
	}

	/**
	 * Gets the head test.
	 * 
	 * @return the head test
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getHeadTest() throws Exception {
		CompetitionRequestTo viewToCompetition = new CompetitionRequestTo();
		viewToCompetition.setCompetitionId(new ObjectToId("48"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/competitionEventController/getHead", viewToCompetition);
		ObjectMapper mapper = new ObjectMapper();

		HeadResponseTo headResponse = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), HeadResponseTo.class);
		assertNotNull(headResponse);
	}
}
