/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.toolbar.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.springframework.test.web.server.request.DefaultRequestBuilder;

import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.Level;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementListTo;
import com.comparadorad.bet.comparer.web.client.gwt.toolbar.sports.bean.ToolbarElementTo;

/**
 * The Class SportTypeControllerTest.
 * 
 * Samples in
 * https://github.com/SpringSource/spring-test-mvc/blob/master/src/test
 * /java/org/springframework/test/web/server/samples/standalone/resultmatchers/
 * JsonPathResultMatcherTests.java
 */
public class ToolbarElementControllerTest extends AbstractTrMvcControllerTest {

	/**
	 * Test get toolbar element list.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetToolbarElementListLVL1() throws Exception {
		ToolbarElementTo toolbarElementTo = new ToolbarElementTo();
		toolbarElementTo.setLevel(Level.NIVEL_1);
		DefaultRequestBuilder requestBuilder = postJson(
				"/toolbarElementController/toolbarElementList",
				toolbarElementTo);

		ObjectMapper mapper = new ObjectMapper();
		ToolbarElementListTo toolbarElementListTo = mapper.readValue(super
				.perform(requestBuilder).andReturn().getResponse()
				.getContentAsString(), ToolbarElementListTo.class);

		assertNotNull(toolbarElementListTo.getToolbarElementList());
		assertTrue(toolbarElementListTo.getToolbarElementList().size() == 2);
		assertEquals(toolbarElementListTo.getToolbarElementList().get(0)
				.getElementName(), "Baloncesto");
		assertNotNull(toolbarElementListTo.getToolbarElementList().get(0)
				.getResourceTo());
		assertEquals("comparer/sport/basketball.png", toolbarElementListTo
				.getToolbarElementList().get(0).getResourceTo().getLocation());
		assertEquals(toolbarElementListTo.getToolbarElementList().get(1)
				.getElementName(), "Fútbol");
		assertNotNull(toolbarElementListTo.getToolbarElementList().get(1)
				.getResourceTo());
		assertEquals("comparer/sport/football.png", toolbarElementListTo
				.getToolbarElementList().get(1).getResourceTo().getLocation());
	}

	/**
	 * Test get toolbar element list lv l2.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetToolbarElementListLVL2() throws Exception {
		ToolbarElementTo toolbarElementTo = new ToolbarElementTo();
		toolbarElementTo.setLevel(Level.NIVEL_2);
		toolbarElementTo.setSportId("1");
		DefaultRequestBuilder requestBuilder = postJson(
				"/toolbarElementController/toolbarElementList",
				toolbarElementTo);

		ObjectMapper mapper = new ObjectMapper();
		ToolbarElementListTo toolbarElementListTo = mapper.readValue(super
				.perform(requestBuilder).andReturn().getResponse()
				.getContentAsString(), ToolbarElementListTo.class);

		assertNotNull(toolbarElementListTo.getToolbarElementList());
		assertTrue(toolbarElementListTo.getToolbarElementList().size() == 1);
		assertEquals(toolbarElementListTo.getToolbarElementList().get(0)
				.getElementName(), "España");
	}

	/**
	 * Test get toolbar element list lv l3.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testGetToolbarElementListLVL3() throws Exception {
		ToolbarElementTo toolbarElementTo = new ToolbarElementTo();
		toolbarElementTo.setLevel(Level.NIVEL_3);
		toolbarElementTo.setSportId("1");
		toolbarElementTo.setRegionId("724");
		DefaultRequestBuilder requestBuilder = postJson(
				"/toolbarElementController/toolbarElementList",
				toolbarElementTo);

		ObjectMapper mapper = new ObjectMapper();
		ToolbarElementListTo toolbarElementListTo = mapper.readValue(super
				.perform(requestBuilder).andReturn().getResponse()
				.getContentAsString(), ToolbarElementListTo.class);

		assertNotNull(toolbarElementListTo.getToolbarElementList());
		assertTrue(toolbarElementListTo.getToolbarElementList().size() == 2);
		assertEquals(toolbarElementListTo.getToolbarElementList().get(0)
				.getElementName(), "Primera Liga");
		assertEquals(toolbarElementListTo.getToolbarElementList().get(1)
				.getElementName(), "Spanish Liga Segunda");
	}

}
