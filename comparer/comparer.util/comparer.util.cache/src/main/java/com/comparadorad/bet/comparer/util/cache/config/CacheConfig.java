/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.cache.config;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.comparadorad.bet.comparer.util.cache.bean.AsyncExecutorBean;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class SpringCacheConfiguration.
 */
@Configuration
@EnableCaching
@EnableAspectJAutoProxy
// @EnableAsync
@ComponentScan({ "com.comparadorad.bet.comparer.util.cache" })
@Import({ DevCacheConfig.class, PreProductionCacheConfig.class,
		ProductionCacheConfig.class, TestCacheConfig.class })
@Profile(value = { ProfileConstant.DEV, ProfileConstant.PREPRODUCTION,
		ProfileConstant.PRODUCTION, ProfileConstant.TEST })
public class CacheConfig {

	private static final Log LOG = LogFactory.getLog(CacheConfig.class);

	private AsyncExecutorBean asyncExecutorBean;

	/**
	 * Property sources placeholder configurer.
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/** The environment. */
	@Inject
	private Environment environment;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.scheduling.annotation.AsyncConfigurer#getAsyncExecutor
	 * ()
	 */
	@Bean(name = "cacheTaskExecutor")
	public Executor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		AsyncExecutorBean asyncExecutorBean = initializeAsyncExecutorBean();
		executor.setCorePoolSize(asyncExecutorBean.getCorePoolSize());
		executor.setMaxPoolSize(asyncExecutorBean.getMaxPoolSize());
		executor.setQueueCapacity(asyncExecutorBean.getQueueCapacity());
		executor.setThreadNamePrefix(asyncExecutorBean.getThreadNamePrefix());
		executor.initialize();
		return executor;
	}

	/**
	 * Gets the async executor bean.
	 * 
	 * @return the async executor bean
	 */
	private AsyncExecutorBean initializeAsyncExecutorBean() {
		asyncExecutorBean = new AsyncExecutorBean();
		asyncExecutorBean.setCorePoolSize(Integer.valueOf(environment
				.getProperty("config.corePoolSize")));
		asyncExecutorBean.setMaxPoolSize(Integer.valueOf(environment
				.getProperty("config.maxPoolSize")));
		asyncExecutorBean.setQueueCapacity(Integer.valueOf(environment
				.getProperty("config.queueCapacity")));
		asyncExecutorBean.setThreadNamePrefix(environment
				.getProperty("config.threadNamePrefix"));
		return asyncExecutorBean;
	}

	/**
	 * Gets the async executor bean.
	 * 
	 * @return the async executor bean
	 */
	public AsyncExecutorBean getAsyncExecutorBean() {
		if (asyncExecutorBean == null) {
			initializeAsyncExecutorBean();
		}
		return asyncExecutorBean;
	}

	/**
	 * Gets the resource.
	 * 
	 * @return the resource
	 */
	@Bean(name = "fileConfigCache")
	public Resource getResource() {
		String nameFile = null;
		if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.TEST_NO_CREATE_DATA)
				|| ArrayUtils.contains(applicationContext.getEnvironment()
						.getActiveProfiles(), ProfileConstant.TEST)) {
			nameFile = applicationContext.getBean("nameFileTestConfig",
					String.class);
		} else if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.DEV)) {
			nameFile = applicationContext.getBean("nameFileDevConfig",
					String.class);
		} else if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.PREPRODUCTION)) {
			nameFile = applicationContext.getBean(
					"nameFilePreproductionConfig", String.class);
		} else if (ArrayUtils.contains(applicationContext.getEnvironment()
				.getActiveProfiles(), ProfileConstant.PRODUCTION)) {
			nameFile = applicationContext.getBean("nameFileProductionConfig",
					String.class);
		}
		return new ClassPathResource(nameFile);
	}

	/**
	 * Cache manager.
	 * 
	 * @param cacheManagerFactoryBean
	 *            the cache manager factory bean
	 * @return the eh cache cache manager
	 */
	@Bean
	@Inject
	public CacheManager cacheManager(
			EhCacheManagerFactoryBean cacheManagerFactoryBean) {
		EhCacheCacheManager cacheCacheManager = new EhCacheCacheManager();
		net.sf.ehcache.CacheManager cacheManager = cacheManagerFactoryBean
				.getObject();

		cacheCacheManager.setCacheManager(cacheManager);

		// TODO: Monitorizacion de cache
		// MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		//
		// ManagementService.registerMBeans(cacheManager, mBeanServer, false,
		// false, false, true);
		// END Monitorizacion de cache

		return cacheCacheManager;
	}

	/**
	 * Eh cache.
	 * 
	 * @param resource
	 *            the resource
	 * @return the eh cache manager factory bean
	 */
	@Bean
	@javax.annotation.Resource(name = "fileConfigCache")
	public EhCacheManagerFactoryBean ehCache(Resource resource) {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setShared(true);
		ehCacheManagerFactoryBean.setConfigLocation(resource);

		if (LOG.isDebugEnabled()) {
			LOG.debug(new StringBuffer(
					"Se crea la configuracion de cache con en el fichero: ")
					.append(resource.getDescription()));
		}

		return ehCacheManagerFactoryBean;
	}

}
