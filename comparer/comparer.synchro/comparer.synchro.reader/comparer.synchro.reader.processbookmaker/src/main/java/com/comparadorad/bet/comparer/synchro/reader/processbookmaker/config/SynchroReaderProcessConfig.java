/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.dozer.CustomConverter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.model.bet.config.BetBeanConfig;
import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfig;
import com.comparadorad.bet.comparer.model.config.service.config.ConfigServiceConfig;
import com.comparadorad.bet.comparer.model.log.service.config.LogServiceConfig;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.util.cache.config.CacheConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.string.StringUtil;
import com.comparadorad.bet.comparer.util.logger.config.SpringSynchroLogConfig;

/**
 * The Class ConfigProcess.
 */
@Configuration
@Import(value = { ConfigServiceConfig.class, BetServiceConfig.class,
		LogServiceConfig.class, BetBeanConfig.class, StringUtil.class, CacheConfig.class, SpringSynchroLogConfig.class })
@PropertySource("classpath:/process.properties")
@ComponentScan("com.comparadorad.bet.comparer.synchro.reader.processbookmaker")
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
public class SynchroReaderProcessConfig {

	/** The Constant FILE_CONFIGURATION_DOZER. */
	private final static String FILE_CONFIGURATION_DOZER = "configuration-bean-mapping.xml";

	/** The Constant FILE_MAPPINGS_DOZER. */
	private final static String FILE_MAPPINGS_DOZER = "dozer-bean-mappings.xml";

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/** The lst custom convert process. */
	@Inject
	private List<CustomConvertProcess> lstCustomConvertProcess;

	/**
	 * Gets the mapper config.
	 * 
	 * @return the mapper config
	 */
	@Bean(name = "process")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Mapper getMapperConfig() {
		DozerBeanMapper mapper = new DozerBeanMapper();
		List<String> mappingFileUrls = new ArrayList<String>();
		Map<String, CustomConverter> customConvertersWithId = new HashMap<String, CustomConverter>();

		mappingFileUrls.add(FILE_CONFIGURATION_DOZER);
		mappingFileUrls.add(FILE_MAPPINGS_DOZER);

		mapper.setMappingFiles(mappingFileUrls);

		for (CustomConvertProcess element : lstCustomConvertProcess) {
			customConvertersWithId.put(element.getName(), element);
		}
		mapper.setCustomConvertersWithId(customConvertersWithId);

		return mapper;
	}

}
