/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.imageslider.control;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.junit.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.web.server.request.DefaultRequestBuilder;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.comparadorad.bet.comparer.web.server.mvc.imageslider.config.WebServerMvcImageSliderConfig;

/**
 * The Class MainPageControllerTest.
 */
public class ImageSliderControllerTest extends AbstractTestMongo {

	// @Inject
	// private String rtMatchService;
	@Inject
	private RtMatchRepository rtMatchRepository;

	/**
	 * Test get event data.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public final void testGetEventData() throws Exception {
		DefaultRequestBuilder requestBuilder = postJson(
				"/imageSliderController/getEventData", null);
		ObjectMapper mapper = new ObjectMapper();
		JavaType type = mapper.getTypeFactory().constructCollectionType(
				List.class, ImageSliderResponseTo.class);
		List<ImageSliderResponseTo> imageSliderResponseTo = mapper.readValue(
				super.perform(requestBuilder).andReturn().getResponse()
						.getContentAsString(), type);
		assertNotNull(imageSliderResponseTo);
	}

	/**
	 * Test get event data update.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public final void testGetEventDataUpdate() throws Exception {
//		ImageSliderRequestTo imageSliderRequestTo = new ImageSliderRequestTo();
//		imageSliderRequestTo.setBetTypeId(new ObjectToId("1"));
//		imageSliderRequestTo.setBetTypeEventId(new ObjectToId("1"));
//		imageSliderRequestTo.setEventId(new ObjectToId("21223"));
//		DefaultRequestBuilder requestBuilder = postJson(
//				"/imageSliderController/getEventDataUpdate", imageSliderRequestTo);
//		ImageSliderResponseTo imageSliderResponseTo = new ObjectMapper()
//				.readValue(super.perform(requestBuilder).andReturn()
//						.getResponse().getContentAsString(),
//						ImageSliderResponseTo.class);
//		assertNotNull(imageSliderResponseTo);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected HashMap<Class<? extends IDocument>, CrudRepository> getRepository() {
		HashMap<Class<? extends IDocument>, CrudRepository> result = new HashMap<Class<? extends IDocument>, CrudRepository>();
		result.put(RtMatch.class, rtMatchRepository);
		return result;
	}

	@Override
	protected Class<?> getLoaderClass() {
		return WebServerMvcImageSliderConfig.class;
	}
}
