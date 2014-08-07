/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.test;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.server.setup.MockMvcBuilders.annotationConfigSetup;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
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

import com.comparadorad.bet.comparer.model.bet.config.BetRepositoryConfig;
import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;
import com.comparadorad.bet.comparer.util.commons.lang.EncodingUtil;
import com.comparadorad.bet.comparer.util.commons.locale.LocaleUtil;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.mvc.core.test.AbstractMvcControllerTest.MyServiceConfig;

/**
 * Test that shows the usage of parent context injection in.
 * 
 * {@link org.springframework.test.web.server.setup.MockMvcBuilders}, by calling
 * {@link org.springframework.test.web.server.setup.ContextMockMvcBuilder#setParentContext(org.springframework.context.ApplicationContext)}
 * during setup.
 * 
 * <p>
 * When a controller and a junit depend on the same bean(s) in a service context
 * for instance, you may want to initialize the service context in the junit and
 * then inject it as a parent context of the web context.
 * 
 * @author Thomas Bruyelle
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyServiceConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractMvcControllerTest {

	/**
	 * The Class MyWebConfig.
	 */
	@Configuration
	@EnableWebMvc
	public static abstract class AbstractMyWebConfig extends
			WebMvcConfigurerAdapter {

	}

	/* ~~~~~~~~~~~~~~~~~ Service configuration and a bean ~~~~~~~~~~~~~~~~~~~~~ */
	/**
	 * The Class MyServiceConfig.
	 */
	@Configuration
	@Import({BetRepositoryConfig.class, ConfigRepositoryConfig.class})
	static class MyServiceConfig {
		
	}

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
	public ResultActions perform(RequestBuilder pRequestBuilder)
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
		((ConfigurableApplicationContext) serviceContext).getEnvironment()
				.setActiveProfiles(ProfileConstant.TEST);
		mockMvc = annotationConfigSetup(getAbstractMyWebConfig().getClass())
				.setParentContext(serviceContext)
				.configureWebAppRootDir(warRootDir, isClasspathRelative)
				.build();
	}
}
