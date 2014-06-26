package com.comparadorad.bet.comparer.model.core.bean;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;

public class I18nFieldTest {
	@Test
	public void testEquals (){
		I18nField i1 = new I18nField("ENG",Locale.ENGLISH);
		I18nField i2 = new I18nField("ENG",Locale.ENGLISH);
		assertTrue(i1.equals(i2));
		

		i1 = new I18nField("ITA",Locale.ITALIAN);
		i2 = new I18nField("ENG",Locale.ENGLISH);
		assertFalse(i1.equals(i2));
	}
}
