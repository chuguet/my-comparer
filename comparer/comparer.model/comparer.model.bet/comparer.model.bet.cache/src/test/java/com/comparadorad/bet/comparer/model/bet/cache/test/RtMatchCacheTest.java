///**
// *
// * Copyright (C) FACTORIA ETSIA S.L.
// * All Rights Reserved.
// * www.factoriaetsia.com
// *
// */
//package com.comparadorad.bet.comparer.model.bet.cache.test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.math.BigInteger;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.junit.Test;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//
//import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
//import com.comparadorad.bet.comparer.model.bet.cache.service.IRtMatchCacheCustom;
//
///**
// * The Class RtMatchCacheTest.
// */
//public class RtMatchCacheTest extends AbstractBetCacheTest {
//
//	/** The cache manager. */
//	@Inject
//	private CacheManager cacheManager;
//
//	/** The match cache custom. */
//	@Inject
//	private IRtMatchCacheCustom matchCacheCustom;
//
//	/**
//	 * Size cache.
//	 * 
//	 * @param regionName
//	 *            the region name
//	 * @return the int
//	 */
//	private int sizeCache(String regionName) {
//		final Cache cache = cacheManager.getCache(regionName);
//		return ((net.sf.ehcache.Cache) cache.getNativeCache()).getSize();
//	}
//
//	private void clearCache(String regionName) {
//		((net.sf.ehcache.Cache) cacheManager.getCache(regionName)
//				.getNativeCache()).removeAll();
//	}
//
//	/**
//	 * Test find one cache.
//	 */
//	@Test
//	public void testFindOneCache() {
//		clearCache("findOneCustomCache");
//
//		assertNotNull(cacheManager);
//		assertNotNull(matchCacheCustom);
//
//		matchCacheCustom.findOneCustomCacheCustom("21229");
//		assertEquals(1, sizeCache("findOneCustomCache"));
//		matchCacheCustom.findOneCustomCacheCustom("66654321");
//		assertEquals(2, sizeCache("findOneCustomCache"));
//		matchCacheCustom.findOneCustomCacheCustom("21229");
//		assertEquals(1, sizeCache("findOneCustomCache"));
//		matchCacheCustom.findOneCustomCacheCustom("66654321");
//		assertEquals(1, sizeCache("findOneCustomCache"));
//	}
//
//	/**
//	 * Test long term cache market cache.
//	 */
//	@Test()
//	public void testLongTermCacheMarketCache() {
//		clearCache("longTermMarketCache");
//
//		assertNotNull(cacheManager);
//		assertNotNull(matchCacheCustom);
//
//		matchCacheCustom.getLongTermMarketCacheCustom(new BigInteger("48"),
//				new BigInteger("2"));
//		assertEquals(1, sizeCache("longTermMarketCache"));
//		matchCacheCustom.getLongTermMarketCacheCustom(new BigInteger("4"),
//				new BigInteger("2"));
//		assertEquals(2, sizeCache("longTermMarketCache"));
//		matchCacheCustom.getLongTermMarketCacheCustom(new BigInteger("48"),
//				new BigInteger("2"));
//		assertEquals(2, sizeCache("longTermMarketCache"));
//		matchCacheCustom.getLongTermMarketCacheCustom(new BigInteger("4"),
//				new BigInteger("2"));
//		assertEquals(2, sizeCache("longTermMarketCache"));
//	}
//
//	/**
//	 * Test map reduce get matchs by competition.
//	 */
//	@Test
//	public void testMapReduceGetMatchsByCompetition() {
//		clearCache("matchsByCompetitionCache");
//
//		assertNotNull(cacheManager);
//		assertNotNull(matchCacheCustom);
//
//		matchCacheCustom.mapReduceGetMatchsByCompetitionCacheCustom(
//				new BigInteger("48"), "2", "1");
//		assertEquals(1, sizeCache("matchsByCompetitionCache"));
//		matchCacheCustom.mapReduceGetMatchsByCompetitionCacheCustom(
//				new BigInteger("18"), "2", "1");
//		assertEquals(23, sizeCache("matchsByCompetitionCache"));
//		matchCacheCustom.mapReduceGetMatchsByCompetitionCacheCustom(
//				new BigInteger("18"), "2", "1");
//		assertEquals(23, sizeCache("matchsByCompetitionCache"));
//		matchCacheCustom.mapReduceGetMatchsByCompetitionCacheCustom(
//				new BigInteger("48"), "2", "1");
//		assertEquals(23, sizeCache("matchsByCompetitionCache"));
//	}
//
//	@Test
//	public void testtest() {
//		List<RtMatch> matchs = matchCacheCustom
//				.mapReduceGetMatchsByCompetitionCacheCustom(new BigInteger(
//						"709818229"), "1", "1");
//		assertNotNull(matchs);
//		matchs = matchCacheCustom.mapReduceGetMatchsByCompetitionCacheCustom(
//				new BigInteger("709818229"), "1", "1");
//		assertNotNull(matchs);
//		matchs = matchCacheCustom.mapReduceGetMatchsByCompetitionCacheCustom(
//				new BigInteger("709818229"), "1", "1");
//		assertNotNull(matchs);
//	}
//
// }
