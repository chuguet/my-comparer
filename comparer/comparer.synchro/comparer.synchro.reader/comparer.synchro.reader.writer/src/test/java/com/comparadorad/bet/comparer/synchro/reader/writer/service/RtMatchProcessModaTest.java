/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtBookmakerIdWeight;
import com.comparadorad.bet.comparer.model.bet.bean.RtModa;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.synchro.reader.writer.GeneralAbstractTest;

/**
 * The Class RtMatchProcessModaTest.
 */
public class RtMatchProcessModaTest extends GeneralAbstractTest {

	/** The Constant DATE_FORMATTER. */
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	/** The rt match process moda. */
	@Inject
	private RtMatchProcessModa rtMatchProcessModa;

	/**
	 * Contains bookmaker.
	 * 
	 * @param matchers
	 *            the matchers
	 * @param bookmakerId
	 *            the bookmaker id
	 * @return the boolean
	 */
	private Boolean containsBookmaker(List<RtBookmakerIdWeight> matchers,
			CfgBookmakerId bookmakerId) {
		Boolean result = Boolean.FALSE;
		for (RtBookmakerIdWeight bookmakerIdWeight : matchers) {
			if (bookmakerIdWeight.getBookmakerId().equals(bookmakerId)) {
				result = Boolean.TRUE;
				break;
			}
		}
		return result;
	}

	/**
	 * Creates the bookmaker.
	 * 
	 * @param idBookmaker
	 *            the id bookmaker
	 * @param weight
	 *            the weight
	 * @return the cfg bookmaker
	 */
	private CfgBookmaker createBookmaker(String idBookmaker, Integer weight) {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmaker);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setPriorityModa(weight);
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}

	/**
	 * Test moda calculate cambia hora.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testModaCalculateCambiaHora() throws ParseException {
		List<RtModa> modas = new ArrayList<RtModa>();
		RtModa moda;

		// Con varias horas
		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.PINNACLESPORTS_COM_ID.objectId().toString(), 2)));
		modas.add(moda);

		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETREDKINGS_ID.objectId().toString(), 12)));
		modas.add(moda);

		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/11/2111 13:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.WILLIAMHILL_COM_ID.objectId().toString(), 8)));
		modas.add(moda);

		assertEquals(new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
				"GMT+1"), rtMatchProcessModa.calculateModa(modas));
	}

	@Test
	public void testModaCalculateWeightZero() throws ParseException {
		List<RtModa> modas = new ArrayList<RtModa>();
		RtModa moda;

		// Con varias horas
		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.PINNACLESPORTS_COM_ID.objectId().toString(), 0)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETCLIC_COM_ID.objectId().toString(), 0)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString(), 0)));
		modas.add(moda);

		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETREDKINGS_ID.objectId().toString(), 0)));
		modas.add(moda);

		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/11/2111 13:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETBOO_ID.objectId().toString(), 0)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.WILLIAMHILL_COM_ID.objectId().toString(), 0)));
		modas.add(moda);

		assertEquals(new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
				"GMT+1"), rtMatchProcessModa.calculateModa(modas));
	}
	/**
	 * Test moda calculate cambia mes.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testModaCalculateCambiaMes() throws ParseException {
		List<RtModa> modas = new ArrayList<RtModa>();
		RtModa moda;

		// Cambiando mes
		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/10/2111 11:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETBOO_ID.objectId().toString(), 4)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETREDKINGS_ID.objectId().toString(), 12)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.UWIN.objectId().toString(), 12)));
		modas.add(moda);

		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.SPORTSBETTING_AG_ID.objectId().toString(), 4)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETDSI_COM_ID.objectId().toString(), 6)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETONLINE_COM_ID.objectId().toString(), 4)));
		modas.add(moda);

		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/12/2111 11:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.TRIOBET_COM_ID.objectId().toString(), 5)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString(), 10)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.PINNACLESPORTS_COM_ID.objectId().toString(), 2)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.WILLIAMHILL_COM_ID.objectId().toString(), 8)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.INTERWETTEN_COM_ID.objectId().toString(), 12)));
		modas.add(moda);

		assertEquals(new CoreDate(DATE_FORMATTER.parse("11/12/2111 11:11"),
				"GMT+1"), rtMatchProcessModa.calculateModa(modas));
	}

	/**
	 * Test moda calculate different weights.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testModaCalculateDifferentWeights() throws ParseException {
		List<RtModa> modas = new ArrayList<RtModa>();
		RtModa moda;

		// Con varias horas
		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.PINNACLESPORTS_COM_ID.objectId().toString(), 2)));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.WILLIAMHILL_COM_ID.objectId().toString(), 8)));
		modas.add(moda);

		moda = new RtModa();
		moda.setElement(new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
				"GMT+1"));
		moda.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETREDKINGS_ID.objectId().toString(), 12)));
		modas.add(moda);

		assertEquals(new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
				"GMT+1"), rtMatchProcessModa.calculateModa(modas));
	}

	/**
	 * Test moda calculate no fechas.
	 */
	@Test
	public void testModaCalculateNoFechas() {
		List<RtModa> modas;

		// Sin fechas
		modas = new ArrayList<RtModa>();
		assertNull(rtMatchProcessModa.calculateModa(modas));
	}

	/**
	 * Test moda process bookmaker exist change hour.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testModaProcessBookmakerExistChangeHour() throws ParseException {
		List<RtModa> modasDB = new ArrayList<RtModa>();
		List<RtModa> result;
		RtModa modaDB;
		RtModa modaProcess;

		// MODA DATABASE
		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 11:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._24HPOKER_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETQS_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.ADMIRALBET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._32REDBET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 12:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._12BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._188BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._1BET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 13:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.DIGIBET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._5DIMES_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET1128_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		// MODA PROCESS
		modaProcess = new RtModa();
		modaProcess.setElement(new CoreDate(DATE_FORMATTER
				.parse("11/11/2111 08:11"), "GMT+1"));
		modaProcess.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET1128_COM_ID.objectId().toString(), 1)));

		result = rtMatchProcessModa.processModa(modasDB, modaProcess);
		assertEquals(4, result.size());
		for (RtModa moda : result) {
			if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
							"GMT+1"))) {
				assertEquals(5, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._24HPOKER_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET_AT_HOME_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BETQS_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.ADMIRALBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._32REDBET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
							"GMT+1"))) {
				assertEquals(3, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._12BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._188BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._1BET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 13:11"),
							"GMT+1"))) {
				assertEquals(2, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.DIGIBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._5DIMES_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 08:11"),
							"GMT+1"))) {
				assertEquals(1, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET1128_COM_ID));
			} else {
				fail("No estan todas las fechas");
			}
		}
	}

	/**
	 * Test moda process bookmaker exist deprecated hour.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testModaProcessBookmakerExistDeprecatedHour()
			throws ParseException {
		List<RtModa> modasDB = new ArrayList<RtModa>();
		List<RtModa> result;
		RtModa modaDB;
		RtModa modaProcess;

		// MODA DATABASE
		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 11:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._24HPOKER_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETQS_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.ADMIRALBET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._32REDBET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 12:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._12BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._188BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._1BET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 13:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET1128_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		// MODA PROCESS
		modaProcess = new RtModa();
		modaProcess.setElement(new CoreDate(DATE_FORMATTER
				.parse("11/11/2111 08:11"), "GMT+1"));
		modaProcess.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET1128_COM_ID.objectId().toString(), 1)));

		result = rtMatchProcessModa.processModa(modasDB, modaProcess);
		assertEquals(3, result.size());
		for (RtModa moda : result) {
			if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
							"GMT+1"))) {
				assertEquals(5, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._24HPOKER_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET_AT_HOME_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BETQS_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.ADMIRALBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._32REDBET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
							"GMT+1"))) {
				assertEquals(3, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._12BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._188BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._1BET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 08:11"),
							"GMT+1"))) {
				assertEquals(1, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET1128_COM_ID));
			} else {
				fail("No estan todas las fechas");
			}
		}
	}

	/**
	 * Test moda process bookmaker exist hour change bookmaker.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testModaProcessBookmakerExistHourChangeBookmaker()
			throws ParseException {
		List<RtModa> modasDB = new ArrayList<RtModa>();
		List<RtModa> result;
		RtModa modaDB;
		RtModa modaProcess;

		// MODA DATABASE
		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 11:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._24HPOKER_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETQS_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.ADMIRALBET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._32REDBET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 12:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._12BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._188BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._1BET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 13:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET1128_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		// MODA PROCESS
		modaProcess = new RtModa();
		modaProcess.setElement(new CoreDate(DATE_FORMATTER
				.parse("11/11/2111 11:11"), "GMT+1"));
		modaProcess.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._12BET_COM_ID.objectId().toString(), 1)));

		result = rtMatchProcessModa.processModa(modasDB, modaProcess);
		assertEquals(3, result.size());
		for (RtModa moda : result) {
			if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
							"GMT+1"))) {
				assertEquals(6, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._24HPOKER_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET_AT_HOME_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BETQS_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.ADMIRALBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._32REDBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._12BET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
							"GMT+1"))) {
				assertEquals(2, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._188BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._1BET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 13:11"),
							"GMT+1"))) {
				assertEquals(1, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET1128_COM_ID));
			} else {
				fail("No estan todas las fechas");
			}
		}
	}

	/**
	 * Test moda process bookmaker exist hour new bookmaker.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testModaProcessBookmakerExistHourNewBookmaker()
			throws ParseException {
		List<RtModa> modasDB = new ArrayList<RtModa>();
		List<RtModa> result;
		RtModa modaDB;
		RtModa modaProcess;

		// MODA DATABASE
		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 11:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._24HPOKER_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETQS_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.ADMIRALBET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._32REDBET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 12:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._12BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._188BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._1BET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 13:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET1128_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		// MODA PROCESS
		modaProcess = new RtModa();
		modaProcess.setElement(new CoreDate(DATE_FORMATTER
				.parse("11/11/2111 11:11"), "GMT+1"));
		modaProcess.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.ALLYOUBET_COM_ID.objectId().toString(), 1)));

		result = rtMatchProcessModa.processModa(modasDB, modaProcess);
		assertEquals(3, result.size());
		for (RtModa moda : result) {
			if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
							"GMT+1"))) {
				assertEquals(6, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._24HPOKER_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET_AT_HOME_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BETQS_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.ADMIRALBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._32REDBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.ALLYOUBET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
							"GMT+1"))) {
				assertEquals(3, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._12BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._188BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._1BET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 13:11"),
							"GMT+1"))) {
				assertEquals(1, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET1128_COM_ID));
			} else {
				fail("No estan todas las fechas");
			}
		}
	}

	/**
	 * Test moda process no change.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testModaProcessNoChange() throws ParseException {
		List<RtModa> modasDB = new ArrayList<RtModa>();
		List<RtModa> result;
		RtModa modaDB;
		RtModa modaProcess;

		// MODA DATABASE
		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 11:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._24HPOKER_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETQS_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.ADMIRALBET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._32REDBET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 12:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._12BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._188BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._1BET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 13:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.DIGIBET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._5DIMES_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET1128_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		// MODA PROCESS
		modaProcess = new RtModa();
		modaProcess.setElement(new CoreDate(DATE_FORMATTER
				.parse("11/11/2111 13:11"), "GMT+1"));
		modaProcess.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._5DIMES_COM_ID.objectId().toString(), 1)));

		result = rtMatchProcessModa.processModa(modasDB, modaProcess);
		assertEquals(3, result.size());
		for (RtModa moda : result) {
			if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
							"GMT+1"))) {
				assertEquals(5, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._24HPOKER_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET_AT_HOME_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BETQS_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.ADMIRALBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._32REDBET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
							"GMT+1"))) {
				assertEquals(3, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._12BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._188BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._1BET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 13:11"),
							"GMT+1"))) {
				assertEquals(3, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.DIGIBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._5DIMES_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET1128_COM_ID));
			} else {
				fail("No estan todas las fechas");
			}
		}

	}

	/**
	 * Test moda process no existe hora no existe bookmaker.
	 * 
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testModaProcessNoExisteHoraNoExisteBookmaker()
			throws ParseException {
		List<RtModa> result;
		List<RtModa> modasDB = new ArrayList<RtModa>();
		RtModa modaDB;
		RtModa modaProcess;

		// MODA DATABASE
		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 11:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._24HPOKER_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET_AT_HOME_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETQS_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.ADMIRALBET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._32REDBET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 12:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._12BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._188BET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._1BET_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		modaDB = new RtModa();
		modaDB.setElement(new CoreDate(
				DATE_FORMATTER.parse("11/11/2111 13:11"), "GMT+1"));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.DIGIBET_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId._5DIMES_COM_ID.objectId().toString(), 1)));
		modaDB.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BET1128_COM_ID.objectId().toString(), 1)));
		modasDB.add(modaDB);

		// MODA PROCESS
		modaProcess = new RtModa();
		modaProcess.setElement(new CoreDate(DATE_FORMATTER
				.parse("11/11/2111 08:11"), "GMT+1"));
		modaProcess.addMatchers(new RtBookmakerIdWeight(createBookmaker(
				CfgBookmakerId.BETFRED_COM_ID.objectId().toString(), 1)));

		result = rtMatchProcessModa.processModa(modasDB, modaProcess);
		assertEquals(4, result.size());
		for (RtModa moda : result) {
			if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 11:11"),
							"GMT+1"))) {
				assertEquals(5, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._24HPOKER_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET_AT_HOME_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BETQS_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.ADMIRALBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._32REDBET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 12:11"),
							"GMT+1"))) {
				assertEquals(3, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._12BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._188BET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._1BET_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 13:11"),
							"GMT+1"))) {
				assertEquals(3, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.DIGIBET_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId._5DIMES_COM_ID));
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BET1128_COM_ID));
			} else if (moda.getElement().equals(
					new CoreDate(DATE_FORMATTER.parse("11/11/2111 08:11"),
							"GMT+1"))) {
				assertEquals(1, moda.getMatchers().size());
				assertTrue(containsBookmaker(moda.getMatchers(),
						CfgBookmakerId.BETFRED_COM_ID));
			} else {
				fail("No estan todas las fechas");
			}
		}
	}

}
