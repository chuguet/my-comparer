package com.comparadorad.bet.comparer.util.cache.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CacheConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles({ProfileConstant.DEV, ProfileConstant.TEST, ProfileConstant.PREPRODUCTION,ProfileConstant.PRODUCTION })
public class CacheConfigSeveralProfiles {
	
	@Inject
	private EhCacheCacheManager cacheCacheManager;

	/** The eh cache manager factory bean. */
	@Inject
	private EhCacheManagerFactoryBean ehCacheManagerFactoryBean;

	/** The resource. */
	@javax.annotation.Resource(name = "fileConfigCache")
	private Resource resource;
	
	@Test
	public void configTest() {
		assertNotNull(resource);
		assertEquals("ehcacheTest.xml", resource.getFilename());

		assertNotNull(cacheCacheManager);
		assertNotNull(ehCacheManagerFactoryBean);
	}

}
