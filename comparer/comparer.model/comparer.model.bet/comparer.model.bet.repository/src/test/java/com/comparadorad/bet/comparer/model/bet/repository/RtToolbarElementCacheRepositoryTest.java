/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElementCache;
import com.comparadorad.bet.comparer.model.repository.CfgCompetitionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgRegionRepository;
import com.comparadorad.bet.comparer.model.repository.CfgSportRepository;

/**
 * The Class RtMatchRepositoryTest.
 */
public class RtToolbarElementCacheRepositoryTest extends AbstractTest {

	/** The match repository. */
	@Inject
	private RtMatchRepository matchRepository;

	@Inject
	private CfgSportRepository sportRepository;

	@Inject
	private CfgRegionRepository regionRepository;

	@Inject
	private CfgCompetitionRepository competitionRepository;

	/** The rt toolbar element cache repository. */
	@Inject
	private RtToolbarElementCacheRepository rtToolbarElementCacheRepository;

	private void createMatchs() {
		RtMatch match = createMatch("656935033");
		matchRepository.save(match);

		match = createMatch("6");
		matchRepository.save(match);

		match = createMatch("41");
		matchRepository.save(match);
	}

	/**
	 * Inits the test.
	 */
	@Before
	public void initTest() {
		createMatchs();
	}

	/**
	 * Test toolbar element repository child nodes test.
	 */
	@Test
	public void testToolbarElementRepositoryTest() {
		List<RtToolbarElementCache> toolbarLVL1;
		List<RtToolbarElementCache> toolbarLVL2Football;
		List<RtToolbarElementCache> toolbarLVL2Basket;
		List<RtToolbarElementCache> toolbarLVL3FootballSpain;
		List<RtToolbarElementCache> toolbarLVL3BasketSpain;

		toolbarLVL1 = rtToolbarElementCacheRepository
				.generateFirstLevelToolbar();
		assertTrue(toolbarLVL1.size() == 3);
		assertTrue(elementToolbarContainsName(toolbarLVL1, "Fútbol", 1));
		assertTrue(elementToolbarContainsName(toolbarLVL1, "Baloncesto", 1));
		assertTrue(elementToolbarContainsName(toolbarLVL1, "F1", 1));
		for (RtToolbarElementCache toolbarElementCacheLVL1 : toolbarLVL1) {

			toolbarLVL2Football = rtToolbarElementCacheRepository
					.generateSecondLevelToolbar(toolbarElementCacheLVL1, "1");
			assertTrue(elementToolbarContainsName(toolbarLVL2Football,
					"España", 2));
			assertTrue(toolbarLVL2Football.size() == 1);

			toolbarLVL2Basket = rtToolbarElementCacheRepository
					.generateSecondLevelToolbar(toolbarElementCacheLVL1, "2");
			assertTrue(elementToolbarContainsName(toolbarLVL2Basket, "España",
					2));
			assertTrue(toolbarLVL2Basket.size() == 1);

			for (RtToolbarElementCache toolbarElementCacheLVL2Football : toolbarLVL2Football) {
				toolbarLVL3FootballSpain = rtToolbarElementCacheRepository
						.generateThirdLevelToolbar(
								toolbarElementCacheLVL2Football, "1", "724");
				assertTrue(toolbarLVL3FootballSpain.size() == 2);
				assertTrue(elementToolbarContainsName(toolbarLVL3FootballSpain,
						"Primera Liga", 3));
				assertTrue(elementToolbarContainsName(toolbarLVL3FootballSpain,
						"Spanish Liga Segunda", 3));
			}
			for (RtToolbarElementCache toolbarElementCacheLVL2Baket : toolbarLVL2Basket) {
				toolbarLVL3BasketSpain = rtToolbarElementCacheRepository
						.generateThirdLevelToolbar(
								toolbarElementCacheLVL2Baket, "2", "724");
				assertTrue(toolbarLVL3BasketSpain.size() == 1);
				assertTrue(elementToolbarContainsName(toolbarLVL3BasketSpain,
						"Liga ACB", 3));
			}
		}
	}

	private boolean elementToolbarContainsName(
			List<RtToolbarElementCache> toolbar, String value, int level) {
		boolean result = false;

		for (RtToolbarElementCache toolbarElementCache : toolbar) {
			if (level == 1) {
				if (sportRepository
						.findOne(
								toolbarElementCache.getToolbarConfigurable()
										.getObjectId()).getName(null)
						.equals(value)) {
					result = true;
					break;
				}

			} else if (level == 2) {
				if (regionRepository
						.findOne(
								toolbarElementCache.getToolbarConfigurable()
										.getObjectId()).getName(null)
						.equals(value)) {
					result = true;
					break;
				}

			} else {
				if (competitionRepository
						.findOne(
								toolbarElementCache.getToolbarConfigurable()
										.getObjectId()).getName(null)
						.equals(value)) {
					result = true;
					break;
				}
			}
		}

		return result;
	}

	/**
	 * Test toolbar element repository orphan nodes test.
	 */
	@Test
	public void testToolbarElementRepositorySecondLevelNoParentTest() {
		List<RtToolbarElementCache> toolbar = rtToolbarElementCacheRepository
				.generateSecondLevelToolbar(null, "1");
		for (RtToolbarElementCache toolbarElement : toolbar) {
			assertNull(toolbarElement.getParentElementCache());
		}
	}

	/**
	 * Test toolbar element repository third level test.
	 */
	@Test
	public void testToolbarElementRepositoryThirdLevelNoParentTest() {
		List<RtToolbarElementCache> toolbar = rtToolbarElementCacheRepository
				.generateThirdLevelToolbar(null, "1", "724");
		for (RtToolbarElementCache toolbarElement : toolbar) {
			assertNull(toolbarElement.getParentElementCache());
		}
	}

}
