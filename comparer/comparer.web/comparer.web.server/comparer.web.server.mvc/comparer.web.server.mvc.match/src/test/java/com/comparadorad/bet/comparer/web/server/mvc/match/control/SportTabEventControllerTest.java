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
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.SportRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * The Class SportOddsControllerTest.
 */
public class SportTabEventControllerTest extends AbstractTrMvcControllerTest {

	/**
	 * Test get sport countries countries.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetSportCountriesCountries() throws Exception {
		// SportRequestTo sportRequestTo = new SportRequestTo();
		// ObjectToId sportId = new ObjectToId();
		// sportId.setId("1");
		// sportRequestTo.setSportId(sportId);
		// DefaultRequestBuilder requestBuilder = postJson(
		// "/sportCountriesController/getSportCountriesCountries",
		// sportRequestTo);
		//
		// ObjectMapper mapper = new ObjectMapper();
		// TableResponseTo table =
		// mapper.readValue(super.perform(requestBuilder)
		// .andReturn().getResponse().getContentAsString(),
		// TableResponseTo.class);
		// assertNotNull(table);
	}

	@Test
	public void testGetHead() throws Exception {
		SportRequestTo sportRequestTo = new SportRequestTo();
		ObjectToId sportId = new ObjectToId();
		sportId.setId("1");
		sportRequestTo.setSportId(sportId);
		DefaultRequestBuilder requestBuilder = postJson(
				"/sportCountriesController/getHead", sportRequestTo);

		ObjectMapper mapper = new ObjectMapper();
		HeadResponseTo head = mapper.readValue(super.perform(requestBuilder)
				.andReturn().getResponse().getContentAsString(),
				HeadResponseTo.class);
		assertNotNull(head);
	}

	/**
	 * Test get sport countries competitions.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetSportCountriesCompetitions() throws Exception {
//		SportRequestTo sportRequestTo = new SportRequestTo();
//		ObjectToId sportId = new ObjectToId();
//		sportId.setId("1");
//		sportRequestTo.setSportId(sportId);
//		ObjectToId countryId = new ObjectToId();
//		countryId.setId("724");
//		sportRequestTo.setCountryId(countryId);
//		DefaultRequestBuilder requestBuilder = postJson(
//				"/sportCountriesController/getSportCountriesCompetitions",
//				sportRequestTo);
//
//		ObjectMapper mapper = new ObjectMapper();
//		TableResponseTo table = mapper.readValue(super.perform(requestBuilder)
//				.andReturn().getResponse().getContentAsString(),
//				TableResponseTo.class);
//		assertNotNull(table);
	}

	/**
	 * Test get sport countries events. Competicion numero 666 tiene markets con
	 * tipo de apuesta 3 (ganador). La tabla de los odds debe ser de tipo
	 * ganador.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetSportTabEventGanador() throws Exception {
		SportRequestTo sportRequestTo = new SportRequestTo();
		String betTypeId = "3"; // Ganador
		sportRequestTo.setCompetitionId(new ObjectToId("666"));
		List<TableResponseTo> tables = getSportTabEventTable(sportRequestTo);
		for (TableResponseTo table : tables) {

			// Controlar que la tabla viene con id, titulo y rows
			assertNotNull(table.getObjectToId());
			assertNotNull(table.getTitle());
			assertNotNull(table.getRows());

			// Celda 0 del titulo - Id de la apuesta, Nombre de la apuesta
			assertNotNull(table.getTitle().getCellList());
			assertNotNull(table.getTitle().getCellList().get(0));
			assertNotNull(table.getTitle().getCellList().get(0).getId());
			assertNotNull(table.getTitle().getCellList().get(0).getId().getId());
			assertTrue(tables.get(0).getTitle().getCellList().get(0).getId()
					.getId().equals("3"));
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo());
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo()
					.getValueStr());
			assertTrue(table.getTitle().getCellList().get(0).getValueTo()
					.getValueStr().equalsIgnoreCase("Ganador"));

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
				// couta estan ordenadas ascendentemente
				String oddOld = "0";
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
	 * Test get sport tab event ganador partido. Competicion numero 18 tiene
	 * markets con tipo de apuesta 2 (ganador de partido) y 3 (ganador). El tipo
	 * de apuesta 2 es prioritario asi que la tabla de los odds debe ser de tipo
	 * gandor de partido.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetSportTabEventGanadorPartido() throws Exception {
		SportRequestTo sportRequestTo = new SportRequestTo();
		String betTypeId = "2"; // Ganador de Partido
		sportRequestTo.setCompetitionId(new ObjectToId("18"));
		List<TableResponseTo> tables = getSportTabEventTable(sportRequestTo);

		for (TableResponseTo table : tables) {
			// Controlar que la tabla viene con id, titulo y rows
			assertNotNull(table.getObjectToId());
			assertNotNull(table.getTitle());
			assertNotNull(table.getRows());

			// Celda 0 del titulo - Id de la apuesta, Nombre de la apuesta
			assertNotNull(table.getTitle().getCellList());
			assertNotNull(table.getTitle().getCellList().get(0));
			assertNotNull(table.getTitle().getCellList().get(0).getId());
			assertNotNull(table.getTitle().getCellList().get(0).getId().getId());
			assertTrue(tables.get(0).getTitle().getCellList().get(0).getId()
					.getId().equals("2"));
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo());
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo()
					.getValueStr());
			assertTrue(table.getTitle().getCellList().get(0).getValueTo()
					.getValueStr().equalsIgnoreCase("Ganador de partido"));

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
	 * Test get sport tab event3. Competicion numero 15 tiene markets con tipo
	 * de apuesta 1 (1X2) y 3 (ganador). El tipo de apuesta 1 es prioritario asi
	 * que la tabla de los odds debe ser de tipo 1X2.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetSportTabEventUnoXDos() throws Exception {
		SportRequestTo sportRequestTo = new SportRequestTo();
		String betTypeId = "1"; // 1X2
		sportRequestTo.setCompetitionId(new ObjectToId("15"));
		List<TableResponseTo> tables = getSportTabEventTable(sportRequestTo);

		for (TableResponseTo table : tables) {
			// Controlar que la tabla viene con id, titulo y rows
			assertNotNull(table.getObjectToId());
			assertNotNull(table.getTitle());
			assertNotNull(table.getRows());

			// Celda 0 del titulo - Id de la apuesta, Nombre de la apuesta
			assertNotNull(table.getTitle().getCellList());
			assertNotNull(table.getTitle().getCellList().get(0));
			assertNotNull(table.getTitle().getCellList().get(0).getId());
			assertNotNull(table.getTitle().getCellList().get(0).getId().getId());
			assertTrue(tables.get(0).getTitle().getCellList().get(0).getId()
					.getId().equals("1"));
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo());
			assertNotNull(table.getTitle().getCellList().get(0).getValueTo()
					.getValueStr());
			assertTrue(table.getTitle().getCellList().get(0).getValueTo()
					.getValueStr().equalsIgnoreCase("1 x 2"));

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
				}
			}
		}
	}

	/**
	 * Gets the sport tab event table.
	 * 
	 * @param sportRequestTo
	 *            the sport request to
	 * @return the sport tab event table
	 * @throws Exception
	 *             the exception
	 */
	private List<TableResponseTo> getSportTabEventTable(
			SportRequestTo sportRequestTo) throws Exception {
		DefaultRequestBuilder requestBuilder = postJson(
				"/sportCountriesController/getSportCountriesEvents",
				sportRequestTo);
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, TableResponseTo.class);
		return mapper.readValue(super.perform(requestBuilder).andReturn()
				.getResponse().getContentAsString(), type);
	}

}
