/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class RtToolbarElementServiceTest.
 */
public class RtToolbarElementServiceTest extends
		AbstractServiceTest<RtToolbarElement> {

	/** The Constant TOOLBAR_LVL1_CACHE_REGION_NAME. */
	private static final String TOOLBAR_LVL1_CACHE_REGION_NAME = "toolbarLVL1";

	/** The Constant TOOLBAR_LVL2_CACHE_REGION_NAME. */
	private static final String TOOLBAR_LVL2_CACHE_REGION_NAME = "toolbarLVL2";

	/** The Constant TOOLBAR_LVL3_CACHE_REGION_NAME. */
	private static final String TOOLBAR_LVL3_CACHE_REGION_NAME = "toolbarLVL3";

	/** The cache manager. */
	@Resource
	private CacheManager cacheManager;

	/** The match repository. */
	@Inject
	private RtMatchRepository matchRepository;

	/** The toolbar element service. */
	@Inject
	private IRtToolbarElementService toolbarElementService;

	/**
	 * Assert the number of objects in cache.
	 * 
	 * @param regionName
	 *            the region name
	 * @param numberOfObjectsExpected
	 *            the number of objects expected
	 */
	private void assertTheNumberOfObjectsInCache(String regionName,
			int numberOfObjectsExpected) {
		final Cache toolbarCache = cacheManager.getCache(regionName);
		assertEquals(
				((net.sf.ehcache.Cache) toolbarCache.getNativeCache())
						.getSize(),
				numberOfObjectsExpected);
	}

	/**
	 * Creates the matchs.
	 */
	private void createMatchs() {
		RtMatch match = createMatch("656935033");
		matchRepository.save(match);

		match = createMatch("6");
		matchRepository.save(match);

		match = createMatch("41");
		matchRepository.save(match);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.model.bet.service.AbstractServiceTest#
	 * getIGenericService()
	 */
	@Override
	protected IGenericCrudService<RtToolbarElement> getIGenericService() {
		return toolbarElementService;
	}

	/**
	 * Inits the test.
	 */
	@Before
	public void initTest() {
		createMatchs();
	}

	/**
	 * Test generate toolbar.
	 */
	@Test
	public void testGenerateToolbar() {
		toolbarElementService.generateToolbar();
		Iterable<RtToolbarElement> toolbar = toolbarElementService.findAll();

		for (RtToolbarElement toolbarElement : toolbar) {
			if (toolbarElement.getToolbarConfigurable() instanceof CfgSport
					&& toolbarElement.getToolbarConfigurable().getName(null)
							.equals("Baloncesto")) {
			} else if (toolbarElement.getToolbarConfigurable() instanceof CfgSport
					&& toolbarElement.getToolbarConfigurable().getName(null)
							.equals("Fútbol")) {
			} else if (toolbarElement.getToolbarConfigurable() instanceof CfgRegion
					&& toolbarElement.getToolbarConfigurable().getName(null)
							.equals("España")
					&& toolbarElement.getParentElement()
							.getToolbarConfigurable().getObjectId().toString()
							.equals("1")) {
			} else if (toolbarElement.getToolbarConfigurable() instanceof CfgRegion
					&& toolbarElement.getToolbarConfigurable().getName(null)
							.equals("España")
					&& toolbarElement.getParentElement()
							.getToolbarConfigurable().getObjectId().toString()
							.equals("2")) {
			} else if (toolbarElement.getToolbarConfigurable() instanceof CfgCompetition
					&& toolbarElement.getToolbarConfigurable().getName(null)
							.equals("Liga ACB")) {
			} else if (toolbarElement.getToolbarConfigurable() instanceof CfgCompetition
					&& toolbarElement.getToolbarConfigurable().getName(null)
							.equals("Spanish Liga Segunda")) {
			} else if (toolbarElement.getToolbarConfigurable() instanceof CfgCompetition
					&& toolbarElement.getToolbarConfigurable().getName(null)
							.equals("Primera Liga")) {
			} 

		}

	}

	/**
	 * Toolbar must be in cache.
	 */
	@Test
	public void toolbarMustBeInCache() {
		toolbarElementService.getFirstLevel();
		toolbarElementService.getSecondLevel("1");
		toolbarElementService.getThirdLevel("1", "724");
		assertTheNumberOfObjectsInCache(TOOLBAR_LVL1_CACHE_REGION_NAME, 1);
		assertTheNumberOfObjectsInCache(TOOLBAR_LVL2_CACHE_REGION_NAME, 1);
		assertTheNumberOfObjectsInCache(TOOLBAR_LVL3_CACHE_REGION_NAME, 1);
	}

	@Test
	public void toolbarMustBeInCacheTwoElements() {
		toolbarElementService.freeCache();
		assertTheNumberOfObjectsInCache(TOOLBAR_LVL2_CACHE_REGION_NAME, 0);
		List<RtToolbarElement> toolbarElementLvl1 = toolbarElementService
				.getSecondLevel("1");
		assertTheNumberOfObjectsInCache(TOOLBAR_LVL2_CACHE_REGION_NAME, 1);
		List<RtToolbarElement> toolbarElementLvl2 = toolbarElementService
				.getSecondLevel("2");
		assertTheNumberOfObjectsInCache(TOOLBAR_LVL2_CACHE_REGION_NAME, 2);
		List<RtToolbarElement> toolbarElementLvl3 = new ArrayList<RtToolbarElement>();

		final Cache toolbarCache = cacheManager
				.getCache(TOOLBAR_LVL2_CACHE_REGION_NAME);

		assertEquals(1, ((net.sf.ehcache.Cache) toolbarCache.getNativeCache())
				.getAll(toolbarElementLvl1).keySet().size());
		assertEquals(1, ((net.sf.ehcache.Cache) toolbarCache.getNativeCache())
				.getAll(toolbarElementLvl2).keySet().size());
		assertEquals(0, ((net.sf.ehcache.Cache) toolbarCache.getNativeCache())
				.getAll(toolbarElementLvl3).keySet().size());
	}

	/**
	 * Toolbar must evict from cache be in cache.
	 */
	@Test
	public void toolbarMustEvictFromCacheBeInCache() {
		toolbarElementService.freeCache();
		assertTheNumberOfObjectsInCache(TOOLBAR_LVL1_CACHE_REGION_NAME, 0);
		assertTheNumberOfObjectsInCache(TOOLBAR_LVL2_CACHE_REGION_NAME, 0);
		assertTheNumberOfObjectsInCache(TOOLBAR_LVL3_CACHE_REGION_NAME, 0);
	}
}
