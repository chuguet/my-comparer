package com.comparadorad.bet.comparer.synchro.reader.url.maker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.model.bet.config.BetBeanConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.config.SynchroReaderDatasourceConfig;

@Configuration
@Import(value = {SynchroReaderDatasourceConfig.class, BetBeanConfig.class})
public class UrlFactoryConfig extends AbstractUrlFactoryConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
