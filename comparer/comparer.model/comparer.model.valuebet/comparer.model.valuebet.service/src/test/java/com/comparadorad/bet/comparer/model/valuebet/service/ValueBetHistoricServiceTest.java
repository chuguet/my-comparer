package com.comparadorad.bet.comparer.model.valuebet.service;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetHistoricData;

// TODO: Auto-generated Javadoc
/**
 * The Class SecureBetHistoricServiceTest.
 */
public class ValueBetHistoricServiceTest extends
		AbstractServiceTest<ValueBetHistoricData> {
	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(ValueBetHistoricData.class);

	/** The secure bet historic service. */
	@Inject
	private IValueBetHistoricService valueBetHistoricService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<ValueBetHistoricData> getIGenericService() {
		return valueBetHistoricService;
	}

	/**
	 * Test service.
	 */
	@Test
	public void testService() {
		assertEquals(valueBetHistoricService.findOne(new BigInteger("1"))
				.getInfoMatch().getObjectId().toString(), "21229");
		assertEquals(valueBetHistoricService.findAll().iterator().next()
				.getInfoMatch().getObjectId().toString(), "21229");
	}

}
