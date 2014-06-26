package com.comparadorad.bet.comparer.model.core.bean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Locale;

import org.junit.Test;

public class I18nTest {

	@Test
	public void testEquals (){
		
		
		I18n i18n1 = new I18n();
		I18nField i1 = new I18nField("ENG",Locale.ENGLISH);
		i18n1.addI18nField(i1);

		I18n i18n2 = new I18n();
		I18nField i2 = new I18nField("ENG",Locale.ENGLISH);
		i18n2.addI18nField(i2);
		
		assertTrue(i18n1.equals(i18n2));
		

	}
	
	@Test
	public void testNonEquals(){

		I18n i18n1 = new I18n();
		I18nField i1 = new I18nField("ITA",Locale.ITALIAN);
		i18n1.addI18nField(i1);

		I18n i18n2 = new I18n();
		I18nField i2 = new I18nField("ENG",Locale.ENGLISH);
		i18n2.addI18nField(i2);
		
		assertFalse(i18n1.equals(i18n2));
	}
}
