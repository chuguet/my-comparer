/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.util;

import org.junit.Test;

/**
 * The Class ActiveBookmakersTest.
 */
public class ActiveBookmakersTest extends AbstractTest {

	/** {@inheritDoc} */
	@Override
	protected String getAditionalNameForLoad() {
		return new StringBuffer().append("-")
				.append(this.getClass().getSimpleName()).toString();
	}

	/**
	 * En BD tenemos 10 bookmakers activos y 2 bookmakers no activos.
	 * 
	 * @return the minimal number of bookmakers test
	 */
	@Test
	public final void getMinimalNumberOfBookmakersTest() {

		// assertEquals(12, bookmakerService.count());
		//
		// assertEquals(Long.valueOf("10"),
		// bookmakerService.getActiveBookmakers());
		//
		// int percent20 = activeBookmakers.getMinimalNumberOfBookmakers(20);
		// assertNotNull(percent20);
		// assertEquals(2, percent20);
		//
		// int percent33 = activeBookmakers.getMinimalNumberOfBookmakers(33);
		// assertNotNull(percent33);
		// assertEquals(3, percent33);
		//
		// int percent50 = activeBookmakers.getMinimalNumberOfBookmakers(50);
		// assertNotNull(percent50);
		// assertEquals(5, percent50);
		//
		// int percent68 = activeBookmakers.getMinimalNumberOfBookmakers(68);
		// assertNotNull(percent68);
		// assertEquals(7, percent68);
		//
		// int percent85 = activeBookmakers.getMinimalNumberOfBookmakers(85);
		// assertNotNull(percent85);
		// assertEquals(9, percent85);

	}

}
