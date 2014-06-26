/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.databaseclean.test;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.synchro.databaseclean.task.IDatabaseCleanTask;

/**
 * The Class DatabaseCleanTaskTest.
 */
public class DatabaseCleanTaskTest extends AbstractTest {

	/** The database clean task. */
	@Inject
	private IDatabaseCleanTask databaseCleanTask;

	/**
	 * Test database clean task.
	 */
	@Test
	public void testDatabaseCleanTask() {
		databaseCleanTask.databaseCleanTask();
	}
}
