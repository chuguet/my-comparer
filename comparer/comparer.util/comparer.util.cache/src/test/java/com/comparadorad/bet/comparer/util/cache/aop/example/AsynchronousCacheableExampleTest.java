package com.comparadorad.bet.comparer.util.cache.aop.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.util.cache.AbstractCacheTest;
import com.comparadorad.bet.comparer.util.cache.CacheRegion;
import com.comparadorad.bet.comparer.util.cache.IUtilCache;

public class AsynchronousCacheableExampleTest extends AbstractCacheTest {
	
	private static final Log LOG = LogFactory
			.getLog(AsynchronousCacheableExampleTest.class);

	@Inject
	private IAsynchronousCacheableExample asynchronousCacheableExample;

	@Inject
	private IAsynchronousCacheableExample asynchronousCacheableInterceptor;

	@Inject
	private IUtilCache utilCache;

	@Test
	public void executeWithoutCacheWithAUniqueArgument() {

		assertNotNull(asynchronousCacheableExample);
		assertNotNull(asynchronousCacheableInterceptor);
		assertEquals("Se devuelve desde el metodo: test",
				asynchronousCacheableExample.execute("test"));

	}

	@Test
	public void executeWithoutCacheWithSeveralArgument() {

		assertNotNull(asynchronousCacheableExample);
		assertNotNull(asynchronousCacheableInterceptor);
		assertEquals("Se devuelve desde el metodo: test1 y test2",
				asynchronousCacheableExample.executeTwo("test1", "test2"));

	}
	
	@Test
	public void executeWithtCacheWithAUniqueArgument() {
		Object keys[] = { "parametro" };
		String value = "test";
		String result;
		CacheRegion[] cacheRegions = { CacheRegion.BETODDS_COMPETITIONEVENTCONTROLLER };

		utilCache.add(Arrays.asList(keys), value, cacheRegions);

		result = asynchronousCacheableExample.execute((String) keys[0]);
		assertEquals(value, result);

	}
	
	@Test
	public void executeWithtCacheWithSeveralArgument() {
		
		Object keys[] = { "parametro1",  "parametro2"};
		String value = "test";
		String result;
		CacheRegion[] cacheRegions = { CacheRegion.BETODDS_COMPETITIONEVENTCONTROLLER };
		
		utilCache.add(Arrays.asList(keys), value, cacheRegions);
		
		result = asynchronousCacheableExample.executeTwo((String) keys[0], (String) keys[1]);
		assertEquals(value, result);
	}
	
	@Test
	public void execute(){
		
		Object keys[] = { "parametro1",  "parametro2"};
		String value = "test";
		String result;
		CacheRegion[] cacheRegions = { CacheRegion.BETODDS_COMPETITIONEVENTCONTROLLER };
		
		utilCache.add(Arrays.asList(keys), value, cacheRegions);
		
		result = asynchronousCacheableExample.executeTwo((String) keys[0], (String) keys[1]);
		assertEquals(value, result);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
		}
		
		result = asynchronousCacheableExample.executeTwo((String) keys[0], (String) keys[1]);
		assertEquals("Se devuelve desde el metodo: parametro1 y parametro2", result);
	}

}
