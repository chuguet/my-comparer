package com.comparadorad.bet.comparer.synchro.reader.datasource.config;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import com.comparadorad.bet.comparer.model.log.service.config.LogServiceConfig;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.DatasourceProxy;
import com.comparadorad.bet.comparer.synchro.server.dummy.config.SynchroReaderServerDummyConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileUtil;

@Configuration
@ComponentScan({ "com.comparadorad.bet.comparer.synchro.reader.datasource" })
@Import(value = { SynchroReaderServerDummyConfig.class, LogServiceConfig.class })
@Profile(value = { ProfileConstant.TEST, ProfileConstant.DEV,
		ProfileConstant.PREPRODUCTION, ProfileConstant.PRODUCTION })
@PropertySource(value = { "classpath:/datasourceproxy.dev.properties",
		"classpath:/proxypassconfig.dev.properties" })
public class AbstractSynchroReaderDatasourceConfig {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(AbstractSynchroReaderDatasourceConfig.class);
	

	/** The user. */
	@Value("${proxyPassConfig.active}")
	private boolean active;

	/** The datasourceproxy active. */
	@Value("${datasourceproxy.active}")
	private boolean datasourceproxyActive;

	/** The host. */
	@Value("${proxyPassConfig.host}")
	private String host;

	/** The password. */
	@Value("${proxyPassConfig.password}")
	private String password;

	/** The port. */
	@Value("${proxyPassConfig.port}")
	private Integer port;

	/** The user. */
	@Value("${proxyPassConfig.user}")
	private String user;

	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/**
	 * Datasource proxy.
	 * 
	 * @return the datasource proxy
	 */
	@Bean
	public DatasourceProxy datasourceProxy() {
		if (containsProfile(ProfileConstant.DATASOURCEPROXY_ACTIVE_FALSE)
				|| containsProfile(ProfileConstant.PREPRODUCTION)
				|| containsProfile(ProfileConstant.PRODUCTION)
				|| containsProfile(ProfileConstant.DEV)) {
			datasourceproxyActive = false;
		}
		LOG.info("datasourceproxyActive is active:" + datasourceproxyActive);
		return new DatasourceProxy(datasourceproxyActive);
	}

	/**
	 * Contains profile.
	 * 
	 * @param profileId
	 *            the profile id
	 * @return true, if successful
	 */
	private boolean containsProfile(String profileId) {
		return ProfileUtil.containsProfile(profileId, applicationContext
				.getEnvironment().getActiveProfiles());
	}

	/**
	 * Proxy pass config.
	 * 
	 * @return the proxy pass config
	 */
	@Bean
	public ProxyPassConfig proxyPassConfig() {
		ProxyPassConfig proxyPassConfig = new ProxyPassConfig();
		proxyPassConfig.setHost(host);
		proxyPassConfig.setPassword(password);
		proxyPassConfig.setUser(user);
		proxyPassConfig.setPort(port);
		proxyPassConfig.setActive(active);
		if (datasourceProxy().isActive()) {
			// Si tenemos un proxy por datasource, el proxy no puede estar
			// activo ya que es local
			proxyPassConfig.setActive(false);
		}
		LOG.info("proxyPassConfig is active:" + proxyPassConfig.isActive());
		return proxyPassConfig;
	}

}
