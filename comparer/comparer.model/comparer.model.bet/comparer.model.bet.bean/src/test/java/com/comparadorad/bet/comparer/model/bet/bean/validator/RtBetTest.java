/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractBetBeanTest;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;

/**
 * The Class RtBetTest.
 */
public class RtBetTest extends AbstractBetBeanTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RtBetTest.class);

	/** The validator. */
	@Inject
	private Validator validator;

	/**
	 * Test.
	 * 
	 * {@inheritDoc}
	 */

	@Override
	@Test
	public void test() {

		Set<ConstraintViolation<RtBet>> constraintViolations;
		RtBet bet = new RtBet();
		constraintViolations = validator.validate(bet);
		assertNotNull(constraintViolations);
		assertEquals(5, constraintViolations.size());

		LOG.info("Violaciones de validacion: " + constraintViolations.size());

	}

}
