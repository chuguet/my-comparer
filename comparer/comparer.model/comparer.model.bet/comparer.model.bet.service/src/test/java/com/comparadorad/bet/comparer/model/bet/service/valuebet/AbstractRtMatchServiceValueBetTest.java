/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.service.valuebet;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.comparadorad.bet.comparer.model.bet.config.BetServiceConfigTest;
import com.comparadorad.bet.comparer.model.bet.service.RtMatchService;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.test.mongo.AbstractTestMongoJSON;

/**
 * The Class AbstractRtMatchServiceValueBetTest.
 * 
 * @param <T>
 *            the generic type
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BetServiceConfigTest.class, loader = AnnotationConfigContextLoader.class)
@TransactionConfiguration(defaultRollback = true)
@ActiveProfiles({ ProfileConstant.TEST, ProfileConstant.TEST_NO_CREATE_DATA })
public abstract class AbstractRtMatchServiceValueBetTest<T> extends
		AbstractTestMongoJSON {

	/** The rt match repository. */
	@Inject
	protected RtMatchService rtMatchService;

	/**
	 * Gets the loader class.
	 * 
	 * @return the loader class {@inheritDoc}
	 */
	@Override
	protected Class<?> getLoaderClass() {
		return this.getClass();
	}

}
