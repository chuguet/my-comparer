package com.comparadorad.bet.comparer.util.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.util.cache.exception.AsynchronousCacheException;

public final class UtilCacheTest extends AbstractCacheTest {
	
	@Inject
	private IUtilCache utilCache;
	
	@Test
	public void addTest() throws AsynchronousCacheException{
		Object[] keys = {"parametro"};
		Object[] parameters = {"parametro"};
		Object value = "valor";
		CacheRegion[] cacheRegions = { CacheRegion.BETODDS_COMPETITIONEVENTCONTROLLER };
		
		assertNotNull(utilCache);
		
		utilCache.add(Arrays.asList(keys), value, cacheRegions);
		
		assertEquals(value,utilCache.find(Arrays.asList(parameters), cacheRegions).getObjectValue());
		
	}
	
	@Test(expected=AsynchronousCacheException.class)
	public void findTest() throws AsynchronousCacheException{
		Object[] keys = {"asynchronousCacheException"};
		
		CacheRegion[] cacheRegions = { CacheRegion.BETODDS_COMPETITIONEVENTCONTROLLER };
		
		assertNotNull(utilCache);		

		utilCache.find(Arrays.asList(keys), cacheRegions);
	}

}
