/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;

/**
 * The Class RtMatchRepositoryTest.
 */
public class RtToolbarElementRepositoryTest extends AbstractTest {

	/** The rt match repository. */
	@Inject
	private RtToolbarElementRepository rtToolbarElementRepository;

	/**
	 * Test toolbar element repository child nodes test.
	 */
	@Test
	public void testToolbarElementRepositoryFirstLevelTest() {
		List<RtToolbarElement> toolbar;

		toolbar = rtToolbarElementRepository.getFirstLevel();
		assertNotNull(toolbar);
		assertTrue(toolbar.size() == 2);
		assertTrue(containsName(toolbar, "Fútbol"));
		assertTrue(containsName(toolbar, "Baloncesto"));
	}

	/**
	 * Test toolbar element repository orphan nodes test.
	 */
	@Test
	public void testToolbarElementRepositorySecondLevelTest() {
		List<RtToolbarElement> toolbar;

		toolbar = rtToolbarElementRepository.getSecondLevel("1");
		assertNotNull(toolbar);
		assertTrue(toolbar.size() == 1);
		assertTrue(containsName(toolbar, "España"));

		toolbar = rtToolbarElementRepository.getSecondLevel("2");
		assertNotNull(toolbar);
		assertTrue(toolbar.size() == 1);
		assertTrue(containsName(toolbar, "España"));
	}

	/**
	 * Test toolbar element repository third level test.
	 */
	@Test
	public void testToolbarElementRepositoryThirdLevelTest() {
		List<RtToolbarElement> toolbar;

		toolbar = rtToolbarElementRepository.getThirdLevel("1", "724");
		assertNotNull(toolbar);
		assertTrue(toolbar.size() == 2);
		assertTrue(containsName(toolbar, "Primera Liga"));
		assertTrue(containsName(toolbar, "Spanish Liga Segunda"));

		toolbar = rtToolbarElementRepository.getThirdLevel("2", "724");
		assertNotNull(toolbar);
		assertTrue(toolbar.size() == 1);
		assertTrue(containsName(toolbar, "Liga ACB"));
	}

	/**
	 * Contains name.
	 *
	 * @param toolbar the toolbar
	 * @param name the name
	 * @return true, if successful
	 */
	private boolean containsName(List<RtToolbarElement> toolbar, String name) {
		boolean result = false;
		for (RtToolbarElement toolbarElement : toolbar) {
			if (toolbarElement.getToolbarConfigurable().getName(null)
					.equals(name)) {
				result = true;
			}
		}
		return result;
	}

}
