/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.config;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletWebArgumentResolverAdapter;

import com.comparadorad.bet.comparer.util.commons.lang.EncodingUtil;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.mvc.core.control.SessionParamArgumentResolver;
import com.comparadorad.bet.comparer.web.server.redirection.config.WebServerRedirectionCoreConfig;

/**
 * The Class WebServerMvcCoreConfig.
 */
@Configuration
@EnableWebMvc
@Import(value = { WebServerRedirectionCoreConfig.class })
@ComponentScan({ "com.comparadorad.bet.comparer.web.server.mvc.core" })
@ImportResource("classpath*:/WebServerMvcCoreConfig.xml")
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class WebServerMvcCoreConfig extends WebMvcConfigurerAdapter {

	/**
	 * The Class CustomObjectMapper.
	 */
	public static class CustomObjectMapper extends ObjectMapper {

		/**
		 * Instantiates a new custom object mapper.
		 */
		public CustomObjectMapper() {
			super();
			configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
			configure(Feature.WRITE_NULL_MAP_VALUES, false);
			setSerializationInclusion(Inclusion.NON_NULL);
			getSerializerProvider().setNullKeySerializer(
					new NullKeySerializer());
			setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
		}

		private class NullKeySerializer extends JsonSerializer<Object> {
			@Override
			public void serialize(Object nullKey, JsonGenerator jsonGenerator,
					SerializerProvider unused) throws IOException,
					JsonProcessingException {
				jsonGenerator.writeFieldName("");
			}
		}
	}

	/**
	 * Adds the argument resolvers.
	 * 
	 * @param argumentResolvers
	 *            the argument resolvers {@inheritDoc}
	 */
	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new ServletWebArgumentResolverAdapter(
				new SessionParamArgumentResolver()));
	}

	/** {@inheritDoc} */
	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {

		MappingJacksonHttpMessageConverter mappingJacksonHttpMessageConverter = new MappingJacksonHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();

		supportedMediaTypes.add(new MediaType("application", "json", Charset
				.forName(EncodingUtil.UTF_8)));
		mappingJacksonHttpMessageConverter
				.setObjectMapper(new CustomObjectMapper());
		mappingJacksonHttpMessageConverter
				.setSupportedMediaTypes(supportedMediaTypes);
		converters.add(mappingJacksonHttpMessageConverter);
	}

	// @Bean
	// public MappingJacksonHttpMessageConverter jacksonMessageConverter() {
	//
	// return mappingJacksonHttpMessageConverter;
	// }
	//
	// @Bean
	// public AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter() {
	// AnnotationMethodHandlerAdapter adapter = new
	// AnnotationMethodHandlerAdapter();
	// adapter.setMessageConverters(new HttpMessageConverter<?>[] {
	// jacksonMessageConverter() });
	// return adapter;
	// }

}