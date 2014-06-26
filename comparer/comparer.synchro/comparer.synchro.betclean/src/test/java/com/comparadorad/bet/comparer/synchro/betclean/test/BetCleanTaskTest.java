/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.betclean.test;

import java.util.HashMap;

import org.junit.Test;
import org.springframework.data.repository.CrudRepository;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.synchro.betclean.config.BetCleanTaskConfiguration;

/**
 * The Class BetCleanTaskTest.
 */
public class BetCleanTaskTest extends AbstractTest {

	@Test
	public void testBetCleanTask() {
		System.out.println("probando");
	}

	@Override
	protected Class<?> getLoaderClass() {
		return BetCleanTaskConfiguration.class;
	}

	@Override
	protected HashMap<Class<? extends IDocument>, CrudRepository> getRepository() {
		HashMap<Class<? extends IDocument>, CrudRepository> result = new HashMap<Class<? extends IDocument>, CrudRepository>();
		return result;
	}

}
