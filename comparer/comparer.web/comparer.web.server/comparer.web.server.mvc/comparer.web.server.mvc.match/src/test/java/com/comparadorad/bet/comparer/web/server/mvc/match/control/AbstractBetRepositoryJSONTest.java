/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.match.control;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.setup.MockMvcBuilders.annotationConfigSetup;

import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.RequestBuilder;
import org.springframework.test.web.server.ResultActions;
import org.springframework.test.web.server.request.DefaultRequestBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;
import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfigTest;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEventSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmakerAuthorization;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegionSynonyms;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.commons.lang.EncodingUtil;
import com.comparadorad.bet.comparer.util.commons.locale.LocaleUtil;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongoJSON;
import com.comparadorad.bet.comparer.web.server.mvc.match.config.ValueBetServiceRtMatchConfigTest;
import com.mongodb.DBCollection;

/**
 * The Class AbstractBetRepositoryTest.
 * 
 * @param <T>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { BetRepositoryConfigTest.class, ValueBetServiceRtMatchConfigTest.class }, 
	loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class AbstractBetRepositoryJSONTest
		extends AbstractTestMongoJSON {

	
	@Inject
	protected IRtMatchService rtMatchService;
	
	/**
	 * The Class MyWebConfig.
	 */
	@Configuration
	@EnableWebMvc
	public static abstract class AbstractMyWebConfig extends
		WebMvcConfigurerAdapter {
	}

//	/* ~~~~~~~~~~~~~~~~~ Service configuration and a bean ~~~~~~~~~~~~~~~~~~~~~ */
//	/**
//	 * The Class MyServiceConfig.
//	 */
//	@Configuration
//	@Import({BetRepositoryConfig.class, ConfigRepositoryConfig.class})
//	static class MyServiceConfig {
//		
//	}

	/** The mock mvc. */
	private static MockMvc mockMvc;

	/** The service context. */
	@Autowired
	private ApplicationContext serviceContext;

	/**
	 * Gets the abstract my web config.
	 * 
	 * @return the abstract my web config
	 */
	protected abstract AbstractMyWebConfig getAbstractMyWebConfig();

	/**
	 * Gets the json.
	 * 
	 * @param objectToJson
	 *            the object to json
	 * @return the json
	 * @throws JsonGenerationException
	 *             the json generation exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected String getJson(Object objectToJson)
			throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(objectToJson);
		return json;
	}

	/*
	 * ~~~~~~~~~~~~~~~~~ Mvc configuration and a controller
	 * ~~~~~~~~~~~~~~~~~~~~~
	 */

	/**
	 * Perform.
	 * 
	 * @param pRequestBuilder
	 *            the request builder
	 * @return the result actions
	 * @throws Exception
	 *             the exception
	 */
	protected ResultActions perform(RequestBuilder pRequestBuilder)
			throws Exception {
		if (pRequestBuilder instanceof DefaultRequestBuilder) {
			((DefaultRequestBuilder) pRequestBuilder).locale(LocaleUtil.SPAIN);
		}
		return mockMvc.perform(pRequestBuilder);
	}

	/**
	 * Post json.
	 * 
	 * @param path
	 *            the path
	 * @param bodyObject
	 *            the body object
	 * @return the default request builder
	 * @throws JsonGenerationException
	 *             the json generation exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected DefaultRequestBuilder postJson(final String path,
			Object bodyObject) throws JsonGenerationException,
			JsonMappingException, IOException {
		DefaultRequestBuilder requestBuilder = post(path)
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding(EncodingUtil.ENCODING_ISO_8859_1)
				.body(getJson(bodyObject).getBytes());
		return requestBuilder;
	}

	/**
	 * Setup.
	 */
	@Before
	public void setup() {

		// Indicate where the webapp root is located.
		// That can be classpath or JVM-relative (e.g. "src/main/webapp").
		String warRootDir = "src/test/resources/META-INF/web-resources";
		boolean isClasspathRelative = false;
//		((ConfigurableApplicationContext) serviceContext).getEnvironment()
//				.setActiveProfiles(ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA);
		mockMvc = annotationConfigSetup(getAbstractMyWebConfig().getClass())
				.setParentContext(serviceContext)
				.configureWebAppRootDir(warRootDir, isClasspathRelative)
				.build();
	}
	
	@Override
	protected HashMap<Class<? extends IDocument>, DBCollection> getCollections() {
		HashMap<Class<? extends IDocument>, DBCollection> result = new HashMap<Class<? extends IDocument>, DBCollection>();
		result.put(CfgBetTypeEvent.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBetTypeEvent.class)));
		
		result.put(CfgBetTypeEventSynonyms.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBetTypeEventSynonyms.class)));

		result.put(CfgBetType.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBetType.class)));

		result.put(CfgBookmakerAuthorization.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBookmakerAuthorization.class)));

		result.put(CfgBookmaker.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgBookmaker.class)));

		result.put(CfgCompetitionEvent.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgCompetitionEvent.class)));
		
		result.put(CfgRegion.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgRegion.class)));
		
		result.put(CfgRegionSynonyms.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgRegionSynonyms.class)));

		
//		result.put(CfgCompetitionEventSynonyms.class, mongoTemplate
//				.getCollection(mongoTemplate
//						.getCollectionName(CfgCompetitionEventSynonyms.class)));

		result.put(CfgCompetition.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgCompetition.class)));

		result.put(CfgParticipant.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgParticipant.class)));

		result.put(CfgParticipantSynonyms.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgParticipantSynonyms.class)));

		result.put(CfgSport.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(CfgSport.class)));

		result.put(RtToolbarElement.class, mongoTemplate
				.getCollection(mongoTemplate
						.getCollectionName(RtToolbarElement.class)));

		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo#
	 * getLoaderClass()
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public Class getLoaderClass() {
		return this.getClass();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongo#
	 * getAditionalNameForLoad()
	 */
	@Override
	public String getAditionalNameForLoad() {
		return "Ini";
	}
}
