/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process.calculate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetMathematicalExpectation;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetProbability;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.OddsSortedBy;
import com.comparadorad.bet.comparer.util.commons.betOdds.FormatterUtil;

/**
 * The Class AbstractCalculateValueBet.
 * 
 * @param <T>
 *            the generic type
 */
abstract class AbstractCalculateValueBet<T extends OddsSortedBy> implements
		ICalculateValueBet {

	/** The Constant DECIMAL_NUMBERS. */
	protected static final Integer DECIMAL_NUMBERS = 2;

	/**
	 * Calculate mean.
	 * 
	 * @param bets
	 *            the bets
	 * @return the float
	 */
	protected Double calculateMean(List<RtBet> bets) {
		Double result = 0d;
		for (RtBet bet : bets) {
			result += Double.valueOf(bet.getBetOdd().getOdds());
		}
		result = result / bets.size();
		return result;
	}

	/**
	 * Calculate probability.
	 * 
	 * @param mean
	 *            the mean
	 * @param payout
	 *            the payout
	 * @return the double
	 */
	private Double calculateProbability(Double mean, Double payout) {
		return 1 / mean * payout;
	}

	/**
	 * Calculate value bet. A este punto, me llegan todas las apuestas de un
	 * partido y de un mismo mercado del partido y me dispongo a calcular cuales
	 * son las que tiene mas valor sobre el resto. Se clasifican los bets por
	 * resultado (participante y atributo de apuesta) y se calcula las coutas
	 * medias. De las coutas medias se calcula el payout medio y utilizando la
	 * couta media de cada resultato y el payout se calcula la probabilidad
	 * media. Luego se multiplica todas las coutas con la probabildad, si el
	 * valor es mayor de 1 es un valuebet.
	 * 
	 * @param bets
	 *            the bets
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<CalculateValueBetData> calculateValueBet(List<RtBet> bets) {

		List<T> columnOdds;
		List<CalculateValueBetData> result = new ArrayList<CalculateValueBetData>();

		if (bets != null) {
			// Se ordenan las apuestas por atributo (Si son de handicap o mas
			// menos) o por participantes (si es ganador , 1x2...)
			columnOdds = sortedBetsByAttributeOrParticipant(bets);

			// Se calcula la couta media de cada resultado
			for (T columnOdd : columnOdds) {
				columnOdd.setMean(calculateMean(columnOdd.getBets()));
			}

			// Se calcula el payout a traves de las medias: se mapea finalValue
			// con payout
			Map<Double, Double> averagePayout = getAveragePayout(columnOdds);

			// Se calcula la probabilidad media de cada columna
			Double payout;
			for (T columnOdd : columnOdds) {
				payout = averagePayout.get(columnOdd.getFinalValue());
				columnOdd.setProbability(calculateProbability(
						columnOdd.getMean(), payout));
			}

			result = calculateValueBet2(columnOdds);
		}

		return result;
	}

	/**
	 * Calculate value bet2.
	 * 
	 * @param pHandicapOddsSortedByAttribute
	 *            the handicap odds sorted by attribute
	 * @return the list
	 */
	protected List<CalculateValueBetData> calculateValueBet2(
			List<T> pHandicapOddsSortedByAttribute) {

		List<CalculateValueBetData> result = new ArrayList<CalculateValueBetData>();
		CalculateValueBetData calculateValueBetData;

		for (OddsSortedBy bean : pHandicapOddsSortedByAttribute) {

			for (RtBet bet : bean.getBets()) {

				if (isValueBet(Double.valueOf(bet.getBetOdd().getOdds()),
						bean.getMean(), bean.getProbability())) {

					calculateValueBetData = getCalculateValueBet(bet,
							bean.getMean(), bean.getProbability());

					result.add(calculateValueBetData);
				}
			}
		}

		return result;
	}

	/**
	 * Gets the average payout.
	 * 
	 * @param pColumnOdds
	 *            the column odds
	 * @return the average payout
	 */
	protected abstract Map<Double, Double> getAveragePayout(List<T> pColumnOdds);

	/**
	 * Gets the calculate value bet.
	 * 
	 * @param bet
	 *            the bet
	 * @param mean
	 *            the mean
	 * @param prob
	 *            the prob
	 * @return the calculate value bet
	 */
	private CalculateValueBetData getCalculateValueBet(RtBet bet, Double mean,
			Double prob) {

		ValueBetMathematicalExpectation expectation = new ValueBetMathematicalExpectation(
				Double.valueOf(FormatterUtil.formatBet(
						getExpectation(
								Double.valueOf(bet.getBetOdd().getOdds()),
								mean, prob), DECIMAL_NUMBERS)));

		ValueBetProbability probability = new ValueBetProbability(
				Double.valueOf(FormatterUtil.formatBet(prob, DECIMAL_NUMBERS)));

		return new CalculateValueBetData(bet, expectation, probability);
	}

	/**
	 * Gets the expectation.
	 * 
	 * @param odd
	 *            the odd
	 * @param mean
	 *            the mean
	 * @param probability
	 *            the probability
	 * @return the expectation
	 */
	protected Double getExpectation(Double odd, Double mean, Double probability) {
		Double result;
		result = (odd * probability);
		return result;
	}

	/**
	 * Checks if is value bet.
	 * 
	 * @param odd
	 *            the odd
	 * @param mean
	 *            the mean
	 * @param probability
	 *            the probability
	 * @return the boolean
	 */
	protected Boolean isValueBet(Double odd, Double mean, Double probability) {
		if (getExpectation(odd, mean, probability) > 1) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	/**
	 * Sorted bets by attribute or participant.
	 * 
	 * @param bets
	 *            the bets
	 * @return the list
	 */
	protected abstract List<T> sortedBetsByAttributeOrParticipant(
			List<RtBet> bets);

}
