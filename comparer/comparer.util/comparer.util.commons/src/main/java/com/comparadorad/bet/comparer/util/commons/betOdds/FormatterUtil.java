/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.betOdds;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * The Class Formatter.
 */
public class FormatterUtil {

	/** The Constant DECIMAL_FORMAT_SYMBOLS. */
	private static final DecimalFormatSymbols DECIMAL_FORMAT_SYMBOLS = new DecimalFormatSymbols();

	/** The Constant DECIMAL_FORMATTER. */
	private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat();
	
	/** The Constant HANDICAP_FORMATTER. */
	private static final DecimalFormat HANDICAP_FORMATTER = new DecimalFormat();

	/**
	 * Configure formatter.
	 * 
	 * @param digits
	 *            the digits
	 */
	private static void configureFormatter(int digits) {
		DECIMAL_FORMATTER.setRoundingMode(RoundingMode.HALF_UP);
		DECIMAL_FORMATTER.setMaximumFractionDigits(digits);
		DECIMAL_FORMATTER.setMinimumFractionDigits(digits);
		DECIMAL_FORMATTER.setGroupingUsed(false);

		DECIMAL_FORMAT_SYMBOLS.setDecimalSeparator('.');
		DECIMAL_FORMATTER.setDecimalFormatSymbols(DECIMAL_FORMAT_SYMBOLS);
	}

	/**
	 * Configure formatter handicap.
	 */
	private static void configureFormatterHandicap() {
		HANDICAP_FORMATTER.setGroupingUsed(false);
		HANDICAP_FORMATTER.setMaximumFractionDigits(2);

		DECIMAL_FORMAT_SYMBOLS.setDecimalSeparator('.');
		HANDICAP_FORMATTER.setDecimalFormatSymbols(DECIMAL_FORMAT_SYMBOLS);
	}

	/**
	 * Format bet.
	 * 
	 * @param betOdd
	 *            the bet odd
	 * @param formatterDigits
	 *            the formatter digits
	 * @return the string
	 */
	public static String formatBet(Double betOdd, int formatterDigits) {
		configureFormatter(formatterDigits);
		return DECIMAL_FORMATTER.format(betOdd);
	}

	/**
	 * Format bet.
	 * 
	 * @param betOdd
	 *            the bet odd
	 * @param formatterDigits
	 *            the formatter digits
	 * @return the string
	 */
	public static String formatBet(Float betOdd, int formatterDigits) {
		configureFormatter(formatterDigits);
		return DECIMAL_FORMATTER.format(betOdd);
	}

	/**
	 * Formatter bet.
	 * 
	 * @param betOdd
	 *            the bet odd
	 * @param formatterDigits
	 *            the formatter digits
	 * @return the string
	 */
	public static String formatBet(String betOdd, int formatterDigits) {
		configureFormatter(formatterDigits);
		return DECIMAL_FORMATTER.format(Double.valueOf(betOdd));
	}

	/**
	 * Format bet handicap.
	 *
	 * @param handicap the handicap
	 * @return the string
	 */
	public static String formatBetHandicap(Double handicap) {
		configureFormatterHandicap();
		String result;
		String handicapStr = HANDICAP_FORMATTER.format(handicap);
		if (handicap > 0) {
			result = new StringBuffer("+").append(handicapStr).toString();
		} else if (handicap < 0) {
			result = handicapStr;
		} else {
			result = "0";
		}
		return result;
	}

}
