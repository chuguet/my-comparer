/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.writer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.model.valuebet.bean.HistoricInfo;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetHistoricData;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.util.test.mongo.json.util.JSONUtil;
import com.mongodb.util.JSONParseException;

/**
 * The Class WriterValueBetTest.
 */
public class WriterValueBetTest extends AbstractValueBetWriterTest {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(WriterValueBetTest.class);

	/**
	 * Se guarda primero un valuebet en BD (con partido con id 1). Viene dos
	 * valueBets nuevos del mismo partido (id = 1) pero ninguno corresponde con
	 * el valuebet anteriormente guardado en BD. Se debe guardar los valuebets
	 * nuevos y borrar el valuebet antiguo.
	 */
	@Test
	public void deleteObsoleteValueBetTest() {

		List<IDocument> valueBetsPOJODB;
		List<IDocument> valueBetsPOJO = new ArrayList<IDocument>();
		List<ValueBetData> valueBets = new ArrayList<ValueBetData>();
		List<ResultValueBet> resultValueBets = new ArrayList<ResultValueBet>();
		ResultValueBet resultValueBet = new ResultValueBet();
		List<ValueBetData> valueBetExistDB;
		ValueBetData valueBetDB = null;
		ValueBetData incommingValueBet1 = null;
		ValueBetData incommingValueBet2 = null;

		try {

			valueBetsPOJODB = JSONUtil.parseJSONToPOJO(ValueBetData.class,
					getClass(), "-DeleteTest-ToSaveInDB", mongoTemplate);
			valueBetDB = (ValueBetData) valueBetsPOJODB.get(0);
			valueBetService.save(valueBetDB);

			valueBetsPOJO = JSONUtil.parseJSONToPOJO(ValueBetData.class,
					getClass(), "-DeleteTest-Incomming", mongoTemplate);
			assertEquals(2, valueBetsPOJO.size());
			incommingValueBet1 = (ValueBetData) valueBetsPOJO.get(0);
			incommingValueBet2 = (ValueBetData) valueBetsPOJO.get(1);

		} catch (JSONParseException e) {
			LOG.error("Test failure: ", e);
			fail("JSONParseException");
		} catch (IOException e) {
			LOG.error("Test failure: ", e);
			fail("IOException");
		}

		// Comprobar estado incial
		// ****************************************************
		assertEquals(1, valueBetService.count());
		valueBetExistDB = valueBetService.exist(valueBetDB);
		assertEquals(1, valueBetExistDB.size());
		valueBetExistDB = valueBetService.exist(incommingValueBet1);
		assertEquals(0, valueBetExistDB.size());
		valueBetExistDB = valueBetService.exist(incommingValueBet2);
		assertEquals(0, valueBetExistDB.size());

		valueBets.add(incommingValueBet1);
		valueBets.add(incommingValueBet2);
		resultValueBet.setValueBetDatas(valueBets);
		resultValueBets.add(resultValueBet);

		try {
			valueBetWriter.write(resultValueBets);

			// Comprobar estado final
			// ****************************************************
			assertEquals(2, valueBetService.count());
			valueBetExistDB = valueBetService.exist(valueBetDB);
			assertEquals(0, valueBetExistDB.size());
			valueBetExistDB = valueBetService.exist(incommingValueBet1);
			assertEquals(1, valueBetExistDB.size());
			valueBetExistDB = valueBetService.exist(incommingValueBet2);
			assertEquals(1, valueBetExistDB.size());

		} catch (Exception e) {
			LOG.error("Test failure: ", e);
			fail("Exception");
		}

	}

	/** {@inheritDoc} */
	@Override
	protected String getAditionalNameForLoad() {
		return new StringBuffer().append("-")
				.append(this.getClass().getSimpleName()).toString();
	}

	/**
	 * Viene un valueBet nuevo que se procede a guardar en la BD.
	 */
	@Test
	public void newValueBetTest() {

		List<IDocument> valueBetsPOJO = new ArrayList<IDocument>();
		List<ValueBetData> valueBets = new ArrayList<ValueBetData>();
		List<ResultValueBet> resultValueBets = new ArrayList<ResultValueBet>();
		ResultValueBet resultValueBet = new ResultValueBet();
		List<ValueBetData> valueBetExistDB;
		ValueBetData valueBetData;

		try {
			valueBetsPOJO = JSONUtil.parseJSONToPOJO(ValueBetData.class,
					getClass(), "-NewValueBetTest", mongoTemplate);
		} catch (JSONParseException e) {
			LOG.error("Test failure: ", e);
			fail("JSONParseException");
		} catch (IOException e) {
			LOG.error("Test failure: ", e);
			fail("IOException");
		}

		assertEquals(1, valueBetsPOJO.size());
		valueBetData = (ValueBetData) valueBetsPOJO.get(0);

		// Comprobar estado incial
		// ****************************************************
		valueBetExistDB = valueBetService.exist(valueBetData);
		assertEquals(0, valueBetExistDB.size());

		valueBets.add(valueBetData);
		resultValueBet.setValueBetDatas(valueBets);
		resultValueBets.add(resultValueBet);

		try {
			valueBetWriter.write(resultValueBets);

			// Comprobar estado final
			// ****************************************************
			valueBetExistDB = valueBetService.exist(valueBetData);
			assertEquals(1, valueBetExistDB.size());

		} catch (Exception e) {
			LOG.error("Test failure: ", e);
			fail("Exception");
		}

	}

	/**
	 * El test empieza con guardar un valuebet en BD. Luego pasa por el 'write'
	 * el mismo valuebet pero con otra probabilidad. Este test verifica que se
	 * actualiza el valuebet y que se pasa al historico el valuebet antiguo.
	 */
	@Test
	public void updateValueBetTest() {

		List<IDocument> valueBetsPOJODB;
		List<IDocument> valueBetsPOJO = new ArrayList<IDocument>();
		List<ValueBetData> valueBets = new ArrayList<ValueBetData>();
		List<ResultValueBet> result = new ArrayList<ResultValueBet>();
		ResultValueBet resultValueBet = new ResultValueBet();
		List<ValueBetHistoricData> valueBetHistoricDB;
		List<ValueBetData> valueBetExistDB;
		ValueBetData valueBet;
		ValueBetData valueBetDB;
		ValueBetHistoricData historicDB;

		try {

			valueBetsPOJODB = JSONUtil.parseJSONToPOJO(ValueBetData.class,
					getClass(), "-UpdateValueBetTest-DB", mongoTemplate);
			valueBetDB = (ValueBetData) valueBetsPOJODB.get(0);
			valueBetService.save(valueBetDB);

			valueBetsPOJO = JSONUtil.parseJSONToPOJO(ValueBetData.class,
					getClass(), "-UpdateValueBetTest-Incomming", mongoTemplate);
		} catch (JSONParseException e) {
			LOG.error("Test failure: ", e);
			fail("JSONParseException");
		} catch (IOException e) {
			LOG.error("Test failure: ", e);
			fail("IOException");
		}

		assertEquals(1, valueBetsPOJO.size());
		valueBet = (ValueBetData) valueBetsPOJO.get(0);

		// Comprobar estado inicial
		// ****************************************************
		// Valuebet DB:
		valueBetExistDB = valueBetService.exist(valueBet);
		assertEquals(1, valueBetExistDB.size());
		valueBetDB = valueBetExistDB.get(0);
		assertEquals("8.50", valueBetDB.getBet().getBetOdd().getOdds());
		assertEquals(Double.valueOf(0.12d), valueBetDB.getProbability()
				.getValue());
		assertEquals(Double.valueOf(1.00d), valueBetDB.getExpectation()
				.getValue());

		// Valuebet historico:
		assertEquals(0, valueBetHistoricService.count());

		// Valuebet entrando:
		assertEquals("8.50", valueBet.getBet().getBetOdd().getOdds());
		assertEquals(Double.valueOf(0.13d), valueBet.getProbability()
				.getValue());
		assertEquals(Double.valueOf(1.00d), valueBet.getExpectation()
				.getValue());

		try {
			valueBets.add(valueBet);
			resultValueBet.setValueBetDatas(valueBets);
			result.add(resultValueBet);
			valueBetWriter.write(result);

			// Comprobar estado final
			// ****************************************************
			// Valuebet DB:
			valueBetExistDB = valueBetService.exist(valueBet);
			assertEquals(1, valueBetExistDB.size());
			valueBetDB = valueBetExistDB.get(0);
			assertEquals("8.50", valueBetDB.getBet().getBetOdd().getOdds());
			assertEquals(Double.valueOf(0.13d), valueBetDB.getProbability()
					.getValue());
			assertEquals(Double.valueOf(1.00d), valueBetDB.getExpectation()
					.getValue());

			// Valuebet historico:
			valueBetHistoricDB = valueBetHistoricService.exist(valueBet);
			assertEquals(1, valueBetHistoricDB.size());
			historicDB = valueBetHistoricDB.get(0);
			assertEquals(HistoricInfo.Cause.PROBABILITY_CHANGED_STILL_VALUEBET,
					historicDB.getHistoric().getCause());
			assertEquals("8.50", historicDB.getBet().getBetOdd().getOdds());
			assertEquals(Double.valueOf(0.12d), historicDB.getProbability()
					.getValue());
			assertEquals(Double.valueOf(1.00d), historicDB.getExpectation()
					.getValue());

		} catch (Exception e) {
			LOG.error("Test failure: ", e);
			fail("Exception");
		}

	}

}
