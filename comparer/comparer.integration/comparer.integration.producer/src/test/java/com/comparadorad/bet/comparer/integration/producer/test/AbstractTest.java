/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.integration.producer.test;

import java.math.BigInteger;
import java.util.Arrays;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.comparadorad.bet.comparer.integration.core.beans.UpdaterBetsTO;
import com.comparadorad.bet.comparer.integration.producer.config.IntegrationProducerConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class AbstractTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { IntegrationProducerConfiguration.class })
@ActiveProfiles({ ProfileConstant.TEST })
public abstract class AbstractTest {

	/** The LOG. */
	@Inject
	protected ComparerWrapperLog LOG;

	/**
	 * Creates the message.
	 *
	 * @param s1 the s1
	 * @param s2 the s2
	 * @param s3 the s3
	 * @return the updater bets to
	 */
	protected UpdaterBetsTO createMessage(String s1, String s2, String... s3) {
		return new UpdaterBetsTO(s1, new BigInteger(s2), Arrays.asList(s3));
	}
}
