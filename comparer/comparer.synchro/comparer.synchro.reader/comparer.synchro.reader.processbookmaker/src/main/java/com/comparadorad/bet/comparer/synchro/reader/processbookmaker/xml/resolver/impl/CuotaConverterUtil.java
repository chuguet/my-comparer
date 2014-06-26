/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtBetOdd;

/**
 * The Class CuotaConverterUtil.
 */
@Component
public class CuotaConverterUtil {

	/** The valor cuota. */
	private double valorCuota = 0.0;
	
	/** The decimal format. */
	private DecimalFormat decimalFormat = new DecimalFormat("#.##");

	/**
	 * Gets the american odds.
	 *
	 * @param betOdd the bet odd
	 * @return the american odds
	 */
	public String getAmericanOdds(RtBetOdd betOdd) {
		String result = "";
		//A partir de betOdds
		if (StringUtils.isNotEmpty(betOdd.getOdds())) {
			valorCuota = Double.valueOf(betOdd.getOdds());
			if (valorCuota < 2) {
				valorCuota = 100/(valorCuota-1);
				decimalFormat = new DecimalFormat("#");
				result = "-" + decimalFormat.format(valorCuota);
			} else {
				valorCuota = 100*(valorCuota-1);
				decimalFormat = new DecimalFormat("#");
				result = decimalFormat.format(valorCuota);
			}
		} else {
			//TODO resolver american odds a traves de fraodds
		}

		return result;
	}

	/**
	 * Gets the odds.
	 *
	 * @param betOdd the bet odd
	 * @return the odds
	 */
	public String getOdds(RtBetOdd betOdd) {
		String result = "";
		String util = "";
		//A partir de american odds
		if (StringUtils.isNotEmpty(betOdd.getAmericanOdds())) {
			valorCuota = Double.valueOf(betOdd.getAmericanOdds());
			if (valorCuota < 0) {
				valorCuota = 100/valorCuota;
				util = String.valueOf(valorCuota);
				util = util.replace("-", "");
				valorCuota = Double.valueOf(util);
				valorCuota = 1+valorCuota;
				result = decimalFormat.format(valorCuota);
			} else {
				valorCuota = (110/valorCuota)+1;
				result = decimalFormat.format(valorCuota);
			}
			//A partir de fraOdds
		} else {
			if (StringUtils.isNotEmpty(betOdd.getFraOdds())) {
				valorCuota = Double.valueOf(betOdd.getFraOdds());
				valorCuota = valorCuota+1;
				result = decimalFormat.format(valorCuota);
			}
		}
		return result;
	}



	/**
	 * Gets the fra odds.
	 *
	 * @param betOdd the bet odd
	 * @return the fra odds
	 */
	public String getFraOdds(RtBetOdd betOdd) {
		String result = "";
		//A partir de odds
		if (StringUtils.isNotEmpty(betOdd.getOdds())) {
			result = decimalToFra(Double.valueOf(betOdd.getOdds()));
			//a partir de americanodds
		} else {
			if (StringUtils.isNotEmpty(betOdd.getAmericanOdds())) {
				//TODO
			}

		}
		return result;
	}

	//cambiar a private y borrar el test.
	/**
	 * Decimal to fra.
	 *
	 * @param valorCuota the valor cuota
	 * @return the string
	 */
	private String decimalToFra(double valorCuota){

		double decimal;
		double originalDecimal;
		int LIMIT = 12;
		int denominators[] = new int[LIMIT + 1];
		int numerator=1, denominator = 1, temp = 0;
		int MAX_GOODNESS = 7;
		StringBuilder builder = new StringBuilder();
		decimal = valorCuota - 1;
		originalDecimal = decimal;


		// Compute all the denominators
		int i = 0;
		while (i < LIMIT + 1) {
			denominators[i] = (int)decimal;
			decimal = 1.0 / (decimal - denominators[i]);
			i = i + 1;
		}

		// Compute the i-th approximation
		int last = 0;
		while (last < LIMIT) {

			// Initialize variables used in computation
			numerator = 1;
			denominator = 1;
			temp = 0;

			// Do the computation
			int current = last;
			while (current >= 0) {
				denominator = numerator;
				numerator = (numerator * denominators[current]) + temp;
				temp = denominator;
				current = current - 1;
			}
			last = last + 1;

			// Display results
			double value = (double)numerator/denominator;
			int goodness = denominators[last];
			double error = 100 * Math.abs(value - originalDecimal) / originalDecimal;


			// Exit early if we have reached our goodness criterion
			if ((Math.abs(goodness) >= MAX_GOODNESS)) break;
			if( error<=1 && numerator>9 && denominator>9) break;
		}        

		builder.append((int)numerator).append("/").append((int)denominator);

		return builder.toString();
	}

}
