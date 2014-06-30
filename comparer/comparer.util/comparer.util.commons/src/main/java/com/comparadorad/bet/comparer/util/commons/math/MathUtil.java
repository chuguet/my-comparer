/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.math;

/**
 * The Class MathUtil.
 */
public class MathUtil {

	/**
	 * Redondear.
	 * 
	 * @param numero
	 *            the numero
	 * @param digitos
	 *            the digitos
	 * @return the double
	 */
	public static String redondear(double numero, int digitos) {
		String result = "";
		int cifras = (int) Math.pow(10, digitos);
		result = String.valueOf(Math.rint(numero * cifras) / cifras);

		return result;
	}

}
