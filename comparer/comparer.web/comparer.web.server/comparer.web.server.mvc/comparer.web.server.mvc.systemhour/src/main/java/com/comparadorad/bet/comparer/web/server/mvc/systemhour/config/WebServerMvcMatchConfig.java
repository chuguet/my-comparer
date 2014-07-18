/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.systemhour.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreConfig;

/**
 * The Class WebServerMvcMatchConfig.
 */
@Configuration
@Import(value = WebServerMvcCoreConfig.class)
@ComponentScan("com.comparadorad.bet.comparer.web.server.mvc.systemhour")
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class WebServerMvcMatchConfig {
	@Bean
	public MappingJacksonJsonView mappingJacksonJsonView() {
		return new MappingJacksonJsonView();
	}

	/**
	 * Bean que especifica los tipos de petición entre la vista y el
	 * controlador.
	 * 
	 * @return the content negotiating view resolver
	 */
	@Bean
	public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
		final ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();
		contentNegotiatingViewResolver
				.setDefaultContentType(MediaType.APPLICATION_JSON);
		final ArrayList<View> defaultViews = new ArrayList<View>();
		defaultViews.add(mappingJacksonJsonView());
		contentNegotiatingViewResolver.setDefaultViews(defaultViews);
		return contentNegotiatingViewResolver;
	}
}