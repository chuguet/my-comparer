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
import com.comparadorad.bet.comparer.model.bet.bean.RtMatchId;
import com.comparadorad.bet.comparer.model.bet.bean.RtParticipant;
import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;

/**
 * The Class RtMatchIdTest.
 */
public class RtMatchIdTest extends AbstractBetBeanTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RtMatchIdTest.class);

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
		RtMatchId matchId = new RtMatchId();
		RtParticipant participant = new RtParticipant();
		CfgParticipant cfgParticipant = new CfgParticipant();
		cfgParticipant.setName("prueba", null);
		matchId.addParticipiant(participant);
		Set<ConstraintViolation<RtMatchId>> constraintViolations;
		constraintViolations = validator.validate(matchId);
		assertNotNull(constraintViolations);
		assertEquals(constraintViolations.size(), 7);

		LOG.info("Violaciones de validacion: " + constraintViolations.size());

	}

}
