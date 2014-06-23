/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service;

import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElementCache;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.config.bean.CfgSport;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class RtToolbarElementServiceTest.
 */
public class RtToolbarElementCacheServiceTest extends
		AbstractServiceTest<RtToolbarElementCache> {

	/** The match repository. */
	@Inject
	private RtMatchRepository matchRepository;

	/** The toolbar element cache service. */
	@Inject
	private IRtToolbarElementCacheService toolbarElementCacheService;

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
	protected IGenericCrudService<RtToolbarElementCache> getIGenericService() {
		return toolbarElementCacheService;
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
		List<RtToolbarElementCache> toolbar = toolbarElementCacheService
				.cacheableToolbar();
		for (RtToolbarElementCache toolbarElementCache : toolbar) {
			if (toolbarElementCache.getToolbarConfigurable() instanceof CfgSport
					&& toolbarElementCache.getToolbarConfigurable()
							.getName(null).equals("Baloncesto")) {
			} else if (toolbarElementCache.getToolbarConfigurable() instanceof CfgSport
					&& toolbarElementCache.getToolbarConfigurable()
							.getName(null).equals("Fútbol")) {
			} else if (toolbarElementCache.getToolbarConfigurable() instanceof CfgSport
							&& toolbarElementCache.getToolbarConfigurable()
									.getName(null).equals("F1")) {
			} else if (toolbarElementCache.getToolbarConfigurable() instanceof CfgRegion
					&& toolbarElementCache.getToolbarConfigurable()
							.getName(null).equals("España")
					&& toolbarElementCache.getParentElementCache()
							.getToolbarConfigurable().getObjectId().toString()
							.equals("1")) {
			} else if (toolbarElementCache.getToolbarConfigurable() instanceof CfgRegion
					&& toolbarElementCache.getToolbarConfigurable()
							.getName(null).equals("España")
					&& toolbarElementCache.getParentElementCache()
							.getToolbarConfigurable().getObjectId().toString()
							.equals("2")) {
			} else if (toolbarElementCache.getToolbarConfigurable() instanceof CfgCompetition
					&& toolbarElementCache.getToolbarConfigurable()
							.getName(null).equals("Liga ACB")) {
			} else if (toolbarElementCache.getToolbarConfigurable() instanceof CfgCompetition
					&& toolbarElementCache.getToolbarConfigurable()
							.getName(null).equals("Spanish Liga Segunda")) {
			} else if (toolbarElementCache.getToolbarConfigurable() instanceof CfgCompetition
					&& toolbarElementCache.getToolbarConfigurable()
							.getName(null).equals("Primera Liga")) {
			} 
		}
	}
}
