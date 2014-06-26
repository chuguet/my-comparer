/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.converter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.valuebet.bean.HistoricInfo;
import com.comparadorad.bet.comparer.model.valuebet.bean.HistoricInfo.Cause;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetHistoricData;
import com.comparadorad.bet.comparer.model.valuebet.exception.CauseNotFoundException;

/**
 * The Class ValueBetToHistoricConverter.
 */
public class ValueBetToHistoricConverter {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ValueBetToHistoricConverter.class);

	/**
	 * Convert to historic.
	 * 
	 * @param valueBetDatas
	 *            the value bet datas
	 * @param cause
	 *            the cause
	 * @return the list
	 */
	public static List<ValueBetHistoricData> convertToHistoric(
			List<ValueBetData> valueBetDatas, Cause cause) {

		List<ValueBetHistoricData> historic = new ArrayList<ValueBetHistoricData>();

		for (ValueBetData valueBetData : valueBetDatas) {
			historic.add(convertToHistoric(valueBetData, cause));
		}

		return historic;

	}

	/**
	 * Gets the value bet historic.
	 * 
	 * @param valueBetData
	 *            the value bet data
	 * @return the value bet historic
	 */
	private static ValueBetHistoricData convertToHistoric(
			ValueBetData valueBetData) {
		ValueBetHistoricData valueBetHistoricData = new ValueBetHistoricData();

		valueBetHistoricData.setInfoMatch(valueBetData.getInfoMatch());
		valueBetHistoricData.setProbability(valueBetData.getProbability());
		valueBetHistoricData.setExpectation(valueBetData.getExpectation());
		valueBetHistoricData.setBet(valueBetData.getBet());
		valueBetHistoricData.setBetTypeEvent(valueBetData.getBetTypeEvent());

		valueBetHistoricData.setCreateDate(valueBetData.getCreateDate());

		return valueBetHistoricData;
	}

	/**
	 * Convert to historic.
	 * 
	 * @param valueBetData
	 *            the value bet data
	 * @param cause
	 *            the cause
	 * @return the value bet historic data
	 */
	public static ValueBetHistoricData convertToHistoric(
			ValueBetData valueBetData, Cause cause) {

		ValueBetHistoricData valueBetHistoricData = convertToHistoric(valueBetData);

		valueBetHistoricData.setHistoric(new HistoricInfo(cause, new CoreDate(
				Calendar.getInstance().getTime())));

		return valueBetHistoricData;
	}

	/**
	 * Convert to historic.
	 * 
	 * @param valueBetData
	 *            the value bet data
	 * @param valueBetDataDB
	 *            the value bet data db
	 * @return the value bet historic data
	 */
	public static ValueBetHistoricData convertToHistoric(
			ValueBetData valueBetData, ValueBetData valueBetDataDB) {

		ValueBetHistoricData valueBetHistoricData = convertToHistoric(valueBetData);

		valueBetHistoricData.setHistoric(new HistoricInfo(getCause(
				valueBetData, valueBetDataDB), new CoreDate(Calendar
				.getInstance().getTime())));

		return valueBetHistoricData;
	}

	/**
	 * Expectation has changed.
	 * 
	 * @param valueBetDataDB
	 *            the value bet data db
	 * @param valueBetData
	 *            the value bet data
	 * @return true, if successful
	 */
	private static boolean expectationHasChanged(ValueBetData valueBetDataDB,
			ValueBetData valueBetData) {

		Double expectation = valueBetData.getExpectation().getValue();
		Double expectationDB = valueBetDataDB.getExpectation().getValue();

		if (!expectation.equals(expectationDB)) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the cause.
	 * 
	 * @param valueBetDataDB
	 *            the value bet data db
	 * @param valueBetData
	 *            the value bet data
	 * @return the cause
	 */
	private static Cause getCause(ValueBetData valueBetDataDB,
			ValueBetData valueBetData) {

		Cause cause = null;

		if (oddHasChanged(valueBetDataDB, valueBetData)) {
			cause = Cause.ODD_CHANGED_STILL_VALUEBET;
		} else if (probabilityHasChanged(valueBetDataDB, valueBetData)) {
			cause = Cause.PROBABILITY_CHANGED_STILL_VALUEBET;
		} else if (expectationHasChanged(valueBetDataDB, valueBetData)) {
			cause = Cause.EXPECTATION_CHANGED_STILL_VALUEBET;
		}

		try {
			if (cause == null) {
				throw new CauseNotFoundException("");
			}
		} catch (CauseNotFoundException e) {
			LOG.error(
					"No se ha encontrado una causa por pasar el valuebet al historico.",
					e);
		}

		return cause;
	}

	/**
	 * Odd has changed.
	 * 
	 * @param valueBetDataDB
	 *            the value bet data db
	 * @param valueBetData
	 *            the value bet data
	 * @return true, if successful
	 */
	private static boolean oddHasChanged(ValueBetData valueBetDataDB,
			ValueBetData valueBetData) {

		String odd = valueBetData.getBet().getBetOdd().getOdds();
		String oddDB = valueBetDataDB.getBet().getBetOdd().getOdds();

		if (!odd.equals(oddDB)) {
			return true;
		}
		return false;
	}

	/**
	 * Probability has changed.
	 * 
	 * @param valueBetDataDB
	 *            the value bet data db
	 * @param valueBetData
	 *            the value bet data
	 * @return true, if successful
	 */
	private static boolean probabilityHasChanged(ValueBetData valueBetDataDB,
			ValueBetData valueBetData) {

		Double probability = valueBetData.getProbability().getValue();
		Double probabilityDB = valueBetDataDB.getProbability().getValue();

		if (!probability.equals(probabilityDB)) {
			return true;
		}

		return false;
	}

	/**
	 * Value bet has changed.
	 * 
	 * @param valueBetDataDB
	 *            the value bet data db
	 * @param valueBetData
	 *            the value bet data
	 * @return the boolean
	 */
	public static Boolean valueBetHasChanged(ValueBetData valueBetDataDB,
			ValueBetData valueBetData) {

		Boolean result = Boolean.FALSE;

		if (oddHasChanged(valueBetDataDB, valueBetData)) {
			result = Boolean.TRUE;
		} else if (probabilityHasChanged(valueBetDataDB, valueBetData)) {
			result = Boolean.TRUE;
		} else if (expectationHasChanged(valueBetDataDB, valueBetData)) {
			result = Boolean.TRUE;
		}

		return result;
	}

}
