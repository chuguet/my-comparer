/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.historic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.valuebet.bean.HistoricInfo.Cause;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetHistoricData;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetHistoricService;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetService;
import com.comparadorad.bet.comparer.synchro.valuebet.historic.beans.DataConfigurationHistoricValueBet;
import com.comparadorad.bet.comparer.util.test.mongo.json.util.JSONUtil;
import com.mongodb.util.JSONParseException;

/**
 * The Class ValueBetHistoricTest.
 */
public final class ValueBetHistoricTest extends AbstractTest {

	/** The data configuration. */
	@Inject
	private DataConfigurationHistoricValueBet dataConfiguration;

	/** The secure bet calculate writer. */
	@Inject
	private IValueBetHistoric valueBetHistoric;

	/** The value bet historic service. */
	@Inject
	private IValueBetHistoricService valueBetHistoricService;

	/** The value bet service. */
	@Inject
	private IValueBetService valueBetService;

	/**
	 * Gets the aditional name for load.
	 * 
	 * @return the aditional name for load {@inheritDoc}
	 */
	@Override
	public String getAditionalNameForLoad() {
		return new StringBuffer().append("-")
				.append(this.getClass().getSimpleName()).toString();
	}

	/**
	 * Match ended test. Cargamos 6 valuebets en la BD (con ids 1, 2, 3, 4, 5
	 * 6). Valuebet 1 y 5 tienen fechas pasadas y deberian pasarse al historico
	 * con la causa MATCH_ENDED.
	 */
	@Test
	public void matchEndedTest() {

		ValueBetData valueBetDB1;
		ValueBetData valueBetDB2;
		List<ValueBetHistoricData> historicValueBetDBList;

		try {
			List<IDocument> valueBets = JSONUtil.parseJSONToPOJO(
					ValueBetData.class, this.getClass(), "-matchEndedTest",
					mongoTemplate);
			for (IDocument pojo : valueBets) {
				ValueBetData v = (ValueBetData) pojo;
				valueBetService.save(v);
			}

		} catch (JSONParseException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}

		dataConfiguration.setLimitValueBets(10);

		// Estado inicial
		assertEquals(6, valueBetService.count());
		assertEquals(0, valueBetHistoricService.count());

		valueBetDB1 = valueBetService.findOne(new BigInteger("1"));
		assertTrue(valueBetDB1.getInfoMatch().getDate()
				.before(Calendar.getInstance().getTime()));
		valueBetDB2 = valueBetService.findOne(new BigInteger("5"));
		assertTrue(valueBetDB2.getInfoMatch().getDate()
				.before(Calendar.getInstance().getTime()));

		valueBetHistoric.execute();

		// Estado final
		assertEquals(4, valueBetService.count());
		assertEquals(2, valueBetHistoricService.count());

		assertNull(valueBetService.findOne(new BigInteger("1")));
		assertNull(valueBetService.findOne(new BigInteger("5")));

		historicValueBetDBList = valueBetHistoricService.exist(valueBetDB1);
		assertNotNull(historicValueBetDBList);
		assertEquals(1, historicValueBetDBList.size());
		assertEquals(Cause.MATCH_ENDED, historicValueBetDBList.get(0)
				.getHistoric().getCause());

		historicValueBetDBList = valueBetHistoricService.exist(valueBetDB2);
		assertNotNull(historicValueBetDBList);
		assertEquals(1, historicValueBetDBList.size());
		assertEquals(Cause.MATCH_ENDED, historicValueBetDBList.get(0)
				.getHistoric().getCause());

	}

	/**
	 * Match ended test. Cargamos 4 valuebets en la BD (con ids 1, 2, 3, 4).
	 * Tienen partidos con ids 1, 2, 3 y 4. En BD solo estan los partidos con id
	 * 1 y 2, asi que valuebet 3 y 4 deberian pasarse al historico con la causa
	 * MATCH_NO_LONGER_EXISTS.
	 */
	@Test
	public void matchNoLongerExistTest() {

		ValueBetData valueBetDB1;
		ValueBetData valueBetDB2;
		List<ValueBetHistoricData> historicValueBetDBList;

		try {
			List<IDocument> valueBets = JSONUtil.parseJSONToPOJO(
					ValueBetData.class, this.getClass(),
					"-matchNoLongerExistTest", mongoTemplate);
			for (IDocument pojo : valueBets) {
				ValueBetData v = (ValueBetData) pojo;
				valueBetService.save(v);
			}

		} catch (JSONParseException e) {
			fail(e.getMessage());
		} catch (IOException e) {
			fail(e.getMessage());
		}

		// Estado inicial
		assertEquals(4, valueBetService.count());
		assertEquals(0, valueBetHistoricService.count());

		valueBetDB1 = valueBetService.findOne(new BigInteger("3"));
		valueBetDB2 = valueBetService.findOne(new BigInteger("4"));

		valueBetHistoric.execute();

		// Estado final
		assertEquals(2, valueBetService.count());
		assertEquals(2, valueBetHistoricService.count());

		assertNull(valueBetService.findOne(new BigInteger("3")));
		assertNull(valueBetService.findOne(new BigInteger("4")));

		historicValueBetDBList = valueBetHistoricService.exist(valueBetDB1);
		assertNotNull(historicValueBetDBList);
		assertEquals(1, historicValueBetDBList.size());
		assertEquals(Cause.MATCH_NO_LONGER_EXISTS, historicValueBetDBList
				.get(0).getHistoric().getCause());

		historicValueBetDBList = valueBetHistoricService.exist(valueBetDB2);
		assertNotNull(historicValueBetDBList);
		assertEquals(1, historicValueBetDBList.size());
		assertEquals(Cause.MATCH_NO_LONGER_EXISTS, historicValueBetDBList
				.get(0).getHistoric().getCause());

	}

}
