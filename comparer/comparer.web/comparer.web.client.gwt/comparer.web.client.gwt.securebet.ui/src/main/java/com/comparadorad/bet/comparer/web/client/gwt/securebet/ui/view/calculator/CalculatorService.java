/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view.calculator;

import com.comparadorad.bet.comparer.web.client.gwt.securebet.ui.view.calculator.bean.BeanCalculator;

/**
 * The Class CalculatorService.
 */
public class CalculatorService {

	/**
	 * Open calculator.
	 * 
	 * @param beanCalculadora
	 *            the bean calculadora
	 */
	public void openCalculator(BeanCalculator beanCalculadora) {
		openJqueryCalculator(beanCalculadora);
	}

	/**
	 * Open jquery calculator.
	 * 
	 * @param calculadora
	 *            the calculadora
	 */
	private native void openJqueryCalculator(BeanCalculator calculadora) /*-{
		$wnd.openCalculator(calculadora);
	}-*/;
}
