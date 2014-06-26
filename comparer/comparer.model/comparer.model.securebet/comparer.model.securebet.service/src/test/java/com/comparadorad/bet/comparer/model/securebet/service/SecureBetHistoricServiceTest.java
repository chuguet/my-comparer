package com.comparadorad.bet.comparer.model.securebet.service;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;

// TODO: Auto-generated Javadoc
/**
 * The Class SecureBetHistoricServiceTest.
 */
public class SecureBetHistoricServiceTest extends
		AbstractServiceTest<SecureBeanHistoricData> {
	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(SecureBetServiceTest.class);

	/** The secure bet historic service. */
	@Inject
	private ISecureBetHistoricService secureBetHistoricService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<SecureBeanHistoricData> getIGenericService() {
		return secureBetHistoricService;
	}

	/**
	 * Test service.
	 */
	@Test
	public void testService() {
		assertEquals(secureBetHistoricService.findOne(new BigInteger("1"))
				.getNameId(), "Real Madrid CF");
		assertEquals(secureBetHistoricService.findAll().iterator().next()
				.getNameId(), "Real Madrid CF");
	}

 }
