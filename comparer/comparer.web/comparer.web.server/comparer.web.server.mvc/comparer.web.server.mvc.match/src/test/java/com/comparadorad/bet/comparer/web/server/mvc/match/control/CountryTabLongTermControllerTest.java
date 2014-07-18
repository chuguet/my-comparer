/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.test.web.server.request.DefaultRequestBuilder;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CountryRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * The Class EventOddsControllerTest.
 */
public class CountryTabLongTermControllerTest extends
		AbstractTrMvcControllerTest {

	/**
	 * Test.
	 * 
	 * @return the bet types test
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void getCountryLongTermCompetitionTest() throws Exception {
		// CountryRequestTo countryRequestTo = new CountryRequestTo();
		// countryRequestTo.setSportId(new ObjectToId("1"));
		// countryRequestTo.setCountryId(new ObjectToId("276"));
		// DefaultRequestBuilder requestBuilder = postJson(
		// "/countryLongTermController/getCountryLongTermCompetition",
		// countryRequestTo);
		// ObjectMapper mapper = new ObjectMapper();
		// TableResponseTo table =
		// mapper.readValue(super.perform(requestBuilder)
		// .andReturn().getResponse().getContentAsString(),
		// TableResponseTo.class);
		// assertNotNull(table);
	}

	@Test
	public void getCountryLongTermBetTypeTest() throws Exception {
		CountryRequestTo countryRequestTo = new CountryRequestTo();
		countryRequestTo.setCompetitionId(new ObjectToId("5"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/countryLongTermController/getCountryLongTermBetType",
				countryRequestTo);
		ObjectMapper mapper = new ObjectMapper();
		TableResponseTo table = mapper.readValue(super.perform(requestBuilder)
				.andReturn().getResponse().getContentAsString(),
				TableResponseTo.class);
		assertNotNull(table);
	}

	@Test
	public void getCountryLongTermEventTest() throws Exception {
		CountryRequestTo countryRequestTo = new CountryRequestTo();
		countryRequestTo.setCompetitionId(new ObjectToId("26"));
		countryRequestTo.setBetTypeId(new ObjectToId("3"));
		DefaultRequestBuilder requestBuilder = postJson(
				"/countryLongTermController/getCountryLongTermEvent",
				countryRequestTo);
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

	// @Test
	// public void getCountryLongTermHeadTest() throws Exception {
	// CountryRequestTo countryRequestTo = new CountryRequestTo();
	// countryRequestTo.setCompetitionId(new ObjectToId("39"));
	// countryRequestTo.setBetTypeId(new ObjectToId("3"));
	// DefaultRequestBuilder requestBuilder = postJson(
	// "/countryLongTermController/getHead", countryRequestTo);
	// ObjectMapper mapper = new ObjectMapper();
	// HeadResponseTo head = mapper.readValue(super.perform(requestBuilder)
	// .andReturn().getResponse().getContentAsString(),
	// HeadResponseTo.class);
	// assertNotNull(head);
	// }
}
