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

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.EventRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseDataTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * TODO HAY QUE HACER LOS TESTS 1X2 Handicap, Handicap Asiatico y Mas/Menos The
 * Class EventDetailOddsControllerTest.
 */
public class EventTabEventControllerTest extends AbstractTrMvcControllerTest {

	/**
	 * Test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetTypes() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo();
		eventRequestTo.setEventId(new ObjectToId("21229"));
		eventRequestTo.setBetTypeId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetTypes", eventRequestTo);
		TabResponseTo tabs = new ObjectMapper().readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), TabResponseTo.class);
		assertEquals(7, tabs.getTabs().size());
		for (TabResponseDataTo tab : tabs.getTabs()) {
			assertNotNull(tab.getName());
			assertNotNull(tab.getId());
			assertNotNull(tab.getId().getId());
		}
		// Orden
		assertEquals("1 x 2", tabs.getTabs().get(0).getName());
		assertEquals("1", tabs.getTabs().get(0).getId().getId());
		assertEquals("Ganador de partido", tabs.getTabs().get(1).getName());
		assertEquals("2", tabs.getTabs().get(1).getId().getId());
		assertEquals("Ganador", tabs.getTabs().get(2).getName());
		assertEquals("3", tabs.getTabs().get(2).getId().getId());
		assertEquals("Handicap Asiatico", tabs.getTabs().get(3).getName());
		assertEquals("4", tabs.getTabs().get(3).getId().getId());
		assertEquals("1X2 Handicap", tabs.getTabs().get(4).getName());
		assertEquals("5", tabs.getTabs().get(4).getId().getId());
		assertEquals("Mas o menos", tabs.getTabs().get(5).getName());
		assertEquals("6", tabs.getTabs().get(5).getId().getId());
		assertEquals("Maximo goleador", tabs.getTabs().get(6).getName());
		assertEquals("7", tabs.getTabs().get(6).getId().getId());
	}

	/**
	 * Test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetTypeEvent2() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo();
		eventRequestTo.setEventId(new ObjectToId("21"));
		eventRequestTo.setBetTypeId(new ObjectToId("2"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetTypeEvent", eventRequestTo);
		TabResponseTo tabs = new ObjectMapper().readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), TabResponseTo.class);
		assertEquals(6, tabs.getTabs().size());
		for (TabResponseDataTo tab : tabs.getTabs()) {
			assertNotNull(tab.getName());
			assertNotNull(tab.getId());
			assertNotNull(tab.getId().getId());
		}
		// Orden
		assertEquals("Partido Completo", tabs.getTabs().get(0).getName());
		assertEquals("Primer Set", tabs.getTabs().get(1).getName());
		assertEquals("Segundo Set", tabs.getTabs().get(2).getName());
		assertEquals("Tercer Set", tabs.getTabs().get(3).getName());
		assertEquals("Cuarto Set", tabs.getTabs().get(4).getName());
		assertEquals("Quinto Set", tabs.getTabs().get(5).getName());
	}

	@Test
	public void testGetBetTypeEvent1() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo();
		eventRequestTo.setEventId(new ObjectToId("21229"));
		eventRequestTo.setBetTypeId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetTypeEvent", eventRequestTo);
		TabResponseTo tabs = new ObjectMapper().readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), TabResponseTo.class);
		assertEquals(7, tabs.getTabs().size());
		for (TabResponseDataTo tab : tabs.getTabs()) {
			assertNotNull(tab.getName());
			assertNotNull(tab.getId());
			assertNotNull(tab.getId().getId());
		}
		assertEquals("Partido Completo", tabs.getTabs().get(0).getName());
		assertEquals("Quince Minutos", tabs.getTabs().get(1).getName());
		assertEquals("Treinta Minutos", tabs.getTabs().get(2).getName());
		assertEquals("Primera Parte", tabs.getTabs().get(3).getName());
		assertEquals("Segunda Parte", tabs.getTabs().get(4).getName());
		assertEquals("Setenta Minutos", tabs.getTabs().get(5).getName());
		assertEquals("Partido completo y prorroga", tabs.getTabs().get(6)
				.getName());
	}

	/**
	 * Test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetOdds1X2() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo(new ObjectToId(
				"25205207949963658581539328234"));
		eventRequestTo.setBetTypeId(new ObjectToId("1"));
		eventRequestTo.setBetTypeEventId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetOdds", eventRequestTo);
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, TableResponseTo.class);
		List<TableResponseTo> tables = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), type);

		for (TableResponseTo table : tables) {
			List<TableResponseRowTo> rows = table.getRows();
			assertNotNull(rows);
			assertNotNull(table.getObjectToId().getId());

			int i = 0;
			for (TableResponseRowTo row : rows) {
				assertNotNull(row);

				if (i != rows.size() - 1 && i != rows.size() - 2
						&& i != rows.size() - 3) {
					int j = 0;
					assertEquals(row.getCellList().size(), 5);
					for (TableResponseCellTo cell : row.getCellList()) {
						assertNotNull(cell);
						switch (j) {
						case 0:
							assertNotNull(cell.getExternalLinkTo()
									.getLinkImgLocation());
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
							break;
						case 1:
						case 2:
						case 3:
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
							break;
						case 4:
							assertNotNull(cell.getValueTo().getValueStr());
							break;
						}
						j++;
					}
				} else {
					if (i == rows.size() - 3) {
						assertEquals(row.getCellList().size(), 4);
					} else {
						assertEquals(row.getCellList().size(), 3);
					}
					for (TableResponseCellTo cell : row.getCellList()) {
						assertNotNull(cell.getValueTo().getValueStr());
					}
				}
				i++;
			}
		}

	}

	/**
	 * Test get bet odds ganador partido.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetOddsGanadorPartido() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo(new ObjectToId(
				"25205207949963658581539328234"));
		eventRequestTo.setBetTypeId(new ObjectToId("2"));
		eventRequestTo.setBetTypeEventId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetOdds", eventRequestTo);
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, TableResponseTo.class);
		List<TableResponseTo> tables = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), type);

		for (TableResponseTo table : tables) {
			List<TableResponseRowTo> rows = table.getRows();
			assertNotNull(rows);
			assertNotNull(table.getObjectToId().getId());

			int i = 0;
			for (TableResponseRowTo row : rows) {
				assertNotNull(row);

				if (i != rows.size() - 1 && i != rows.size() - 2
						&& i != rows.size() - 3) {
					int j = 0;
					assertEquals(row.getCellList().size(), 4);
					for (TableResponseCellTo cell : row.getCellList()) {
						assertNotNull(cell);
						switch (j) {
						case 0:
							assertNotNull(cell.getExternalLinkTo()
									.getLinkImgLocation());
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
							break;
						case 1:
						case 2:
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
							break;
						case 3:
							assertNotNull(cell.getValueTo().getValueStr());
							break;
						}
						j++;
					}
				} else {
					if (i == rows.size() - 3) {
						assertEquals(row.getCellList().size(), 3);
					} else {
						assertEquals(row.getCellList().size(), 2);
					}
					for (TableResponseCellTo cell : row.getCellList()) {
						assertNotNull(cell.getValueTo().getValueStr());
					}
				}
				i++;
			}
		}

	}

	/**
	 * Test get bet odds ganador.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetOddsGanador() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo(new ObjectToId(
				"25203425201276359656751413882"));
		eventRequestTo.setBetTypeId(new ObjectToId("3"));
		eventRequestTo.setBetTypeEventId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetOdds", eventRequestTo);
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, TableResponseTo.class);
		List<TableResponseTo> tables = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), type);

		// Controlar que hay 1 tabla con minimo 4 filas (3 filas de
		// estadisticas)
		assertNotNull(tables);
		assertEquals(tables.size(), 1);
		TableResponseTo table = tables.get(0);
		assertNotNull(table.getRows());
		assertTrue(table.getRows().size() >= 4);

		// Controlar el titulo - que tenga id (unico) y valueStr (nombre
		// participante)
		List<String> titleIds = new ArrayList<String>();
		assertNotNull(table.getTitle());
		for (TableResponseCellTo cell : table.getTitle().getCellList()) {
			assertNotNull(cell);
			assertNotNull(cell.getId());
			assertNotNull(cell.getId().getId());
			assertTrue(!titleIds.contains(cell.getId().getId()));
			titleIds.add(cell.getId().getId());

			assertNotNull(cell.getValueTo());
			assertNotNull(cell.getValueTo().getValueStr());
			assertTrue(!cell.getValueTo().getValueStr().isEmpty());
		}

		// Controlar las filas con las apuestas de un bookmaker
		List<TableResponseRowTo> bookmakerRows = table.getRows().subList(0,
				table.getRows().size() - 3);
		final int numCellsBookmakerRow = table.getTitle().getCellList().size() + 2;
		List<String> rowIds = new ArrayList<String>();
		for (TableResponseRowTo row : bookmakerRows) {
			// Controlamos que el id del row exista y que sea unico
			assertNotNull(row);
			assertNotNull(row.getObjectToId());
			assertNotNull(row.getObjectToId().getId());
			assertNotNull(row.getCellList());
			assertTrue(!row.getObjectToId().getId().isEmpty());
			assertTrue(!rowIds.contains(row.getObjectToId().getId()));
			rowIds.add(row.getObjectToId().getId());
			assertTrue(row.getCellList().size() == numCellsBookmakerRow);

			// Celda 0 - External link
			assertNotNull(row.getCellList().get(0));
			assertNotNull(row.getCellList().get(0).getExternalLinkTo());
			assertNotNull(row.getCellList().get(0).getExternalLinkTo()
					.getLinkImgLocation());
			assertNotNull(row.getCellList().get(0).getExternalLinkTo()
					.getLinkText());
			assertNotNull(row.getCellList().get(0).getExternalLinkTo().getUrl());
			assertNotNull(row.getCellList().get(0).getExternalLinkTo().getActionAnalytics());
			assertNotNull(row.getCellList().get(0).getExternalLinkTo().getCategoryAnalytics());

			// Celda [1, 2, 3, ..., Penultima celda] - External link con link
			// text
			for (int i = 1; i < row.getCellList().size() - 1; i++) {
				TableResponseCellTo cell = row.getCellList().get(i);
				assertNotNull(cell);
				assertNotNull(cell.getExternalLinkTo());
				assertNotNull(cell.getExternalLinkTo().getLinkText());
				assertNotNull(cell.getExternalLinkTo().getUrl());
				assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
				assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
			}

			// Ultima celda con el payout - ValueStr
			TableResponseCellTo lastCell = row.getCellList().get(
					row.getCellList().size() - 1);
			assertNotNull(lastCell.getValueTo());
			assertNotNull(lastCell.getValueTo().getValueStr());
			assertTrue(!lastCell.getValueTo().getValueStr().isEmpty());
		}

		List<TableResponseCellTo> meanRowCellListOdds = tables
				.get(0)
				.getRows()
				.get(tables.get(0).getRows().size() - 2)
				.getCellList()
				.subList(
						0,
						tables.get(0).getRows()
								.get(tables.get(0).getRows().size() - 2)
								.getCellList().size() - 1);

		// La primera de las fila de bookmaker debe tener los odds ordenados
		// ascendentmente
		String oddOld = "0";
		String oddNew;
		for (TableResponseCellTo cell : meanRowCellListOdds) {
			oddNew = cell.getValueTo().getValueStr();
			assertTrue(Double.valueOf(oddNew) >= Double.valueOf(oddOld));
			oddOld = oddNew;
		}

		// La primera de las fila de bookmaker debe tener los participantes
		// ordenados
		// como en el titulo de la tabla
		int titleCellIndex = 0;
		for (TableResponseCellTo cell : meanRowCellListOdds) {
			assertTrue(cell
					.getId()
					.getId()
					.equalsIgnoreCase(
							table.getTitle().getCellList().get(titleCellIndex)
									.getId().getId()));
			titleCellIndex++;
		}

		// Controlar las 3 ultimas filas (Media por pronostico, Valor mas alto,
		// Probabilidad)
		List<TableResponseRowTo> statisticsRows = table.getRows().subList(
				table.getRows().size() - 3, table.getRows().size());

		int rowNum = 0;
		for (TableResponseRowTo row : statisticsRows) {
			assertNotNull(row);
			assertNotNull(row.getCellList());
			if (rowNum == 2) {
				assertEquals(row.getCellList().size(), table.getTitle()
						.getCellList().size());
				for (int i = 0; i < row.getCellList().size(); i++) {
					TableResponseCellTo cell = row.getCellList().get(i);
					assertNotNull(cell);
					assertNotNull(cell.getId());
					assertNotNull(cell.getId().getId());

					assertNotNull(cell.getValueTo());
					assertNotNull(cell.getValueTo().getValueStr());
					assertTrue(!cell.getValueTo().getValueStr().isEmpty());
				}
			} else {
				assertEquals(row.getCellList().size(), table.getTitle()
						.getCellList().size() + 1);
				for (int i = 0; i < row.getCellList().size() - 1; i++) {
					TableResponseCellTo cell = row.getCellList().get(i);
					assertNotNull(cell);
					assertNotNull(cell.getId());
					assertNotNull(cell.getId().getId());

					assertNotNull(cell.getValueTo());
					assertNotNull(cell.getValueTo().getValueStr());
					assertTrue(!cell.getValueTo().getValueStr().isEmpty());
				}
			}
			// Ultima celda con el payout
			TableResponseCellTo lastCell = row.getCellList().get(
					row.getCellList().size() - 1);
			assertNotNull(lastCell.getValueTo());
			assertNotNull(lastCell.getValueTo().getValueStr());
			assertTrue(!lastCell.getValueTo().getValueStr().isEmpty());
			rowNum++;
		}

	}

	/**
	 * Test get bet odds handicap asiatico.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetOddsHandicapAsiatico() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo(new ObjectToId(
				"25205207949963658581539328234"));
		eventRequestTo.setBetTypeId(new ObjectToId("4"));
		eventRequestTo.setBetTypeEventId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetOdds", eventRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, TableResponseTo.class);
		List<TableResponseTo> tables = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), type);

		for (TableResponseTo table : tables) {
			assertNotNull(table.getObjectToId().getId());
			String handicapOld = "0";
			String handicapNew = "";
			int i = 0;
			for (TableResponseRowTo row : table.getRows()) {
				if (i != table.getRows().size() - 1
						&& i != table.getRows().size() - 2
						&& i != table.getRows().size() - 3) {
					assertNotNull(row.getObjectToId().getId());
					int j = 0;
					for (TableResponseCellTo cell : row.getCellList()) {
						if (j == 0 && cell.getExternalLinkTo() != null) {
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo()
									.getLinkImgLocation());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
						} else if (j == 1) {
							// Handicap. Verificar que las tablas estan
							// ordenadas por el handicap. El handicap puede
							// venir como 1.5/2.0, entonces cogemos siempre el
							// primer valor.
							assertNotNull(cell.getValueTo().getValueStr());
							handicapNew = cell.getValueTo().getValueStr();
							if (handicapNew.contains("/")) {
								handicapNew = handicapNew.substring(0,
										handicapNew.indexOf('/'));
							}
							assertTrue(Double.valueOf(handicapNew) > Double
									.valueOf(handicapOld));
						} else if (j == row.getCellList().size() - 1) {
							assertNotNull(cell.getValueTo().getValueStr());
						} else {
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
						}
						j++;
					}
				} else {
					int j = 0;
					for (TableResponseCellTo cell : row.getCellList()) {
						if (j != 2 && i != 2) {
							assertNotNull(cell.getValueTo().getValueStr());
						}
						j++;
					}
				}
				i++;
			}
		}
	}

	/**
	 * Test get bet odds handicap1 x2.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetOddsHandicap1X2() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo(new ObjectToId(
				"25205207949963658581539328234"));
		eventRequestTo.setBetTypeId(new ObjectToId("5"));
		eventRequestTo.setBetTypeEventId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetOdds", eventRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, TableResponseTo.class);
		List<TableResponseTo> tables = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), type);

		for (TableResponseTo table : tables) {
			assertNotNull(table.getObjectToId().getId());
			String handicapOld = "0";
			String handicapNew = "";
			int i = 0;
			for (TableResponseRowTo row : table.getRows()) {
				if (i != table.getRows().size() - 1
						&& i != table.getRows().size() - 2
						&& i != table.getRows().size() - 3) {
					assertNotNull(row.getObjectToId().getId());
					int j = 0;
					for (TableResponseCellTo cell : row.getCellList()) {
						if (j == 0 && cell.getExternalLinkTo() != null) {
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo()
									.getLinkImgLocation());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
						} else if (j == 1) {
							assertNotNull(cell.getValueTo().getValueStr());
							// Handicap. Verificar que las tablas estan
							// ordenadas por el handicap. El handicap puede
							// venir como 1.5/2.0, entonces cogemos siempre el
							// primer valor.
							assertNotNull(cell.getValueTo().getValueStr());
							handicapNew = cell.getValueTo().getValueStr();
							if (handicapNew.contains("/")) {
								handicapNew = handicapNew.substring(0,
										handicapNew.indexOf('/'));
							}
							assertTrue(Double.valueOf(handicapNew) > Double
									.valueOf(handicapOld));
						} else if (j == row.getCellList().size() - 1) {
							assertNotNull(cell.getValueTo().getValueStr());
						} else {
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
						}
						j++;
					}
				} else {
					int j = 0;
					for (TableResponseCellTo cell : row.getCellList()) {
						if (j != 2 && i != 2) {
							assertNotNull(cell.getValueTo().getValueStr());
						}
						j++;
					}
				}
				i++;
			}
		}
	}

	/**
	 * Test get bet odds mas menos.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetOddsMasMenos() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo(new ObjectToId(
				"25205207949963658581539328234"));
		eventRequestTo.setBetTypeId(new ObjectToId("6"));
		eventRequestTo.setBetTypeEventId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetOdds", eventRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, TableResponseTo.class);
		List<TableResponseTo> tables = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), type);

		for (TableResponseTo table : tables) {
			assertNotNull(table.getObjectToId().getId());
			String valueOld = "0";
			String valueNew = "";
			int i = 0;
			for (TableResponseRowTo row : table.getRows()) {
				if (i != table.getRows().size() - 1
						&& i != table.getRows().size() - 2
						&& i != table.getRows().size() - 3) {
					assertNotNull(row.getObjectToId().getId());
					int j = 0;
					for (TableResponseCellTo cell : row.getCellList()) {
						if (j == 0 && cell.getExternalLinkTo() != null) {
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo()
									.getLinkImgLocation());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
						} else if (j == 1) {
							assertNotNull(cell.getValueTo().getValueStr());
							// Valor de mas/menos. Verificar que las tablas
							// estan
							// ordenadas por el valor.
							assertNotNull(cell.getValueTo().getValueStr());
							valueNew = cell.getValueTo().getValueStr();
							assertTrue(Double.valueOf(valueNew) > Double
									.valueOf(valueOld));
						} else if (j == row.getCellList().size() - 1) {
							assertNotNull(cell.getValueTo().getValueStr());
						} else {
							assertNotNull(cell.getExternalLinkTo()
									.getLinkText());
							assertNotNull(cell.getExternalLinkTo().getUrl());
							assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
							assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
						}
						j++;
					}
				} else {
					int j = 0;
					for (TableResponseCellTo cell : row.getCellList()) {
						if (j != 2 && i != 2) {
							assertNotNull(cell.getValueTo().getValueStr());
						}
						j++;
					}
				}
				i++;
			}
		}
	}

	/**
	 * Test get bet odds maximo goleador.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetBetOddsMaximoGoleador() throws Exception {
		EventRequestTo eventRequestTo = new EventRequestTo(new ObjectToId(
				"25203425201276359656751413882"));
		eventRequestTo.setBetTypeId(new ObjectToId("7"));
		eventRequestTo.setBetTypeEventId(new ObjectToId("1"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/eventEventController/getBetOdds", eventRequestTo);
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, TableResponseTo.class);
		List<TableResponseTo> tables = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), type);

		for (TableResponseTo table : tables) {
			for (TableResponseCellTo cell : table.getTitle().getCellList()) {
				assertNotNull(cell.getValueTo().getValueStr());
				assertNotNull(cell.getId().getId());
			}
			List<TableResponseRowTo> rows = table.getRows();
			assertNotNull(rows);

			for (TableResponseRowTo row : rows) {
				assertNotNull(row);
				for (TableResponseCellTo cell : row.getCellList()) {
					assertNotNull(cell);
					if (cell.getExternalLinkTo() != null) {
						assertNotNull(cell.getExternalLinkTo().getLinkText());
						assertNotNull(cell.getExternalLinkTo().getUrl());
						assertNotNull(cell.getExternalLinkTo().getActionAnalytics());
						assertNotNull(cell.getExternalLinkTo().getCategoryAnalytics());
					} else {
						assertNotNull(cell.getValueTo().getValueStr());
					}
				}
			}
		}
	}

}
