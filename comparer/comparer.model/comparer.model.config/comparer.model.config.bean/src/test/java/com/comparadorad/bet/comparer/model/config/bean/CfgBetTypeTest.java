package com.comparadorad.bet.comparer.model.config.bean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;

public class CfgBetTypeTest {
	@Test
	public final void equalTest() {

		CfgBetType betType1;
		CfgBetType betType2;

		
		betType1 = new CfgBetType();
		
		I18n i1 = new I18n();
		Set<I18nField> set1 = new HashSet<I18nField>();
		I18nField aux = new I18nField("ENG",Locale.ENGLISH);
		set1.add(aux);
		i1.setI18nFields(set1);
		
		betType1.setI18n(i1);

		betType2 = new CfgBetType();

		I18n i2 = new I18n();
		Set<I18nField> set2 = new HashSet<I18nField>();
		set2 = new HashSet<I18nField>();
		aux = new I18nField("ENG",Locale.ENGLISH);
		set2.add(aux);
		i2.setI18nFields(set2);

		betType2.setI18n(i2);

		assertTrue(betType1.equals(betType2));

	}
	
	@Test
	public final void notEqualTest() {

		CfgBetType betType1;
		CfgBetType betType2;

		
		betType1 = new CfgBetType();
		
		I18n i1 = new I18n();
		Set<I18nField> set1 = new HashSet<I18nField>();
		I18nField aux = new I18nField("ENG",Locale.ENGLISH);
		set1.add(aux);
		i1.setI18nFields(set1);
		
		betType1.setI18n(i1);

		betType2 = new CfgBetType();

		I18n i2 = new I18n();
		Set<I18nField> set2 = new HashSet<I18nField>();
		set2 = new HashSet<I18nField>();
		aux = new I18nField("ITA",Locale.ITALIAN);
		set2.add(aux);
		i2.setI18nFields(set2);

		betType2.setI18n(i2);

		assertFalse(betType1.equals(betType2));

	}
}
