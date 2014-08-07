/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.sports.sample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.server.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.annotationConfigSetup;

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
@ContextConfiguration(classes = SampleParentContextTest.MyServiceConfig.class, loader = AnnotationConfigContextLoader.class)
public class SampleParentContextTest {

	/**
	 * The Class MyController.
	 */
	@Controller
	static class MyController {

		/** The my service. */
		private MyService myService;

		/**
		 * Instantiates a new my controller.
		 * 
		 * @param myService
		 *            the my service
		 */
		MyController(MyService myService) {
			this.myService = myService;
		}

		/**
		 * Gets the.
		 * 
		 * @return the list
		 */
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public @ResponseBody
		List<String> get() {
			return myService.get();
		}

	}

	/**
	 * The Class MyService.
	 */
	static class MyService {

		/** The list. */
		private List<String> list = new ArrayList<String>();

		/**
		 * Adds the.
		 * 
		 * @param item
		 *            the item
		 */
		public void add(String item) {
			list.add(item);
		}

		/**
		 * Gets the.
		 * 
		 * @return the list
		 */
		public List<String> get() {
			return list;
		}
	}

	/**
	 * The Class MyServiceConfig.
	 */
	@Configuration
	static class MyServiceConfig {

		/**
		 * My service.
		 * 
		 * @return the my service
		 */
		@Bean
		public MyService myService() {
			return new MyService();
		}
	}

	/**
	 * The Class MyWebConfig.
	 */
	@Configuration
	@EnableWebMvc
	static class MyWebConfig extends WebMvcConfigurerAdapter {

		/** The my service. */
		@Autowired
		private MyService myService;

		/**
		 * My controller.
		 * 
		 * @return the my controller
		 */
		@Bean
		public MyController myController() {
			return new MyController(myService);
		}
	}

	/** The mock mvc. */
	private static MockMvc mockMvc;

	/* ~~~~~~~~~~~~~~~~~ Service configuration and a bean ~~~~~~~~~~~~~~~~~~~~~ */

	/** The my service. */
	@Autowired
	private MyService myService;

	/** The service context. */
	@Autowired
	private ApplicationContext serviceContext;

	/*
	 * ~~~~~~~~~~~~~~~~~ Mvc configuration and a controller
	 * ~~~~~~~~~~~~~~~~~~~~~
	 */

	/**
	 * Setup.
	 */
	@Before
	public void setup() {

		// Indicate where the webapp root is located.
		// That can be classpath or JVM-relative (e.g. "src/main/webapp").
		String warRootDir = "src/test/resources/META-INF/web-resources";
		boolean isClasspathRelative = false;

		mockMvc = annotationConfigSetup(MyWebConfig.class)
				.setParentContext(serviceContext)
				.configureWebAppRootDir(warRootDir, isClasspathRelative)
				.build();
	}

	/**
	 * Test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void test() throws Exception {
		myService.add("item1");
		myService.add("item2");

		mockMvc.perform(get("/list")).andExpect(status().isOk())
				.andExpect(jsonPath("$[0]").value("item1"))
				.andExpect(jsonPath("$[1]").value("item2"));
	}
}
