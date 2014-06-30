package com.comparadorad.bet.comparer.test.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.config.SynchroReaderProcessConfig;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.config.SynchroReaderReaderbookmakerConfig;
import com.comparadorad.bet.comparer.synchro.reader.writer.config.SynchroReaderWriterConfig;
import com.comparadorad.bet.comparer.synchro.securebet.process.config.SynchroSecureBetProcessConfig;
import com.comparadorad.bet.comparer.synchro.securebet.writer.config.SynchroSecureBetWriterConfig;
import com.comparadorad.bet.comparer.synchro.valuebet.process.config.SynchroValueBetProcessConfig;
import com.comparadorad.bet.comparer.synchro.valuebet.reader.config.SynchroValueBetReaderConfig;
import com.comparadorad.bet.comparer.synchro.valuebet.writer.config.SynchroValueBetWriterConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@Configuration
@Import(value = { SynchroReaderProcessConfig.class, SynchroReaderReaderbookmakerConfig.class, SynchroValueBetWriterConfig.class,
		SynchroValueBetReaderConfig.class, SynchroValueBetProcessConfig.class, SynchroReaderWriterConfig.class,
		SynchroSecureBetProcessConfig.class,SynchroSecureBetWriterConfig.class })
@ComponentScan({ "com.comparador.bet.comparer.test" })
@PropertySource({ "classpath:/readers.properties" })
@Profile(value = { ProfileConstant.TEST })
public class TestCoreConfig extends AbstractCoreTestConfig {

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
