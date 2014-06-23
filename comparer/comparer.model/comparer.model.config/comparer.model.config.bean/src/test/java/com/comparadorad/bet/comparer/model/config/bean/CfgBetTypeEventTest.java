/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;

/**
 * The Class CfgBetTypeEventTest.
 */
public class CfgBetTypeEventTest {

	/**
	 * Order test.
	 */
	@Test
	public final void orderTest() {

		CfgBetTypeEvent betTypeEvent1;
		CfgBetTypeEvent betTypeEvent2;

		
		betTypeEvent1 = new CfgBetTypeEvent();
		
		I18n i1 = new I18n();
		Set<I18nField> set1 = new HashSet<I18nField>();
		I18nField aux = new I18nField("ENG",Locale.ENGLISH);
		set1.add(aux);
		i1.setI18nFields(set1);
		
		betTypeEvent1.setI18n(i1);

		betTypeEvent2 = new CfgBetTypeEvent();

		I18n i2 = new I18n();
		Set<I18nField> set2 = new HashSet<I18nField>();
		set2 = new HashSet<I18nField>();
		aux = new I18nField("ENG",Locale.ENGLISH);
		set2.add(aux);
		i2.setI18nFields(set2);

		betTypeEvent2.setI18n(i2);

		assertTrue(betTypeEvent1.equals(betTypeEvent2));

	}
	
	@Test
	public final void nonEquals() {

		CfgBetTypeEvent betTypeEvent1;
		CfgBetTypeEvent betTypeEvent2;

		
		betTypeEvent1 = new CfgBetTypeEvent();
		
		I18n i1 = new I18n();
		Set<I18nField> set1 = new HashSet<I18nField>();
		I18nField aux = new I18nField("ENG",Locale.ENGLISH);
		set1.add(aux);
		i1.setI18nFields(set1);
		
		betTypeEvent1.setI18n(i1);

		betTypeEvent2 = new CfgBetTypeEvent();

		I18n i2 = new I18n();
		Set<I18nField> set2 = new HashSet<I18nField>();
		set2 = new HashSet<I18nField>();
		aux = new I18nField("ITA",Locale.ITALIAN);
		set2.add(aux);
		i2.setI18nFields(set2);

		betTypeEvent2.setI18n(i2);

		assertFalse(betTypeEvent1.equals(betTypeEvent2));

	}
}
