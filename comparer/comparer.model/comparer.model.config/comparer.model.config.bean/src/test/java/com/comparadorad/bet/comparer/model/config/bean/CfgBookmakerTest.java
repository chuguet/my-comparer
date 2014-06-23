package com.comparadorad.bet.comparer.model.config.bean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;

public class CfgBookmakerTest {
	
	@Test
	public final void equalsTest() {

		CfgBookmaker cfgBookmaker1;
		CfgBookmaker cfgBookmaker2;

		
		cfgBookmaker1 = new CfgBookmaker();
		
		I18n i1 = new I18n();
		Set<I18nField> set1 = new HashSet<I18nField>();
		I18nField aux = new I18nField("ENG",Locale.ENGLISH);
		set1.add(aux);
		i1.setI18nFields(set1);
		
		cfgBookmaker1.setI18n(i1);

		cfgBookmaker2 = new CfgBookmaker();

		I18n i2 = new I18n();
		Set<I18nField> set2 = new HashSet<I18nField>();
		set2 = new HashSet<I18nField>();
		aux = new I18nField("ENG",Locale.ENGLISH);
		set2.add(aux);
		i2.setI18nFields(set2);

		cfgBookmaker2.setI18n(i2);

		assertTrue(cfgBookmaker1.equals(cfgBookmaker2));

	}
	
	@Test
	public final void notEqualsTest() {

		CfgBookmaker cfgBookmaker1;
		CfgBookmaker cfgBookmaker2;

		
		cfgBookmaker1 = new CfgBookmaker();
		
		I18n i1 = new I18n();
		Set<I18nField> set1 = new HashSet<I18nField>();
		I18nField aux = new I18nField("ENG",Locale.ENGLISH);
		set1.add(aux);
		i1.setI18nFields(set1);
		
		cfgBookmaker1.setI18n(i1);

		cfgBookmaker2 = new CfgBookmaker();

		I18n i2 = new I18n();
		Set<I18nField> set2 = new HashSet<I18nField>();
		set2 = new HashSet<I18nField>();
		aux = new I18nField("ITA",Locale.ITALIAN);
		set2.add(aux);
		i2.setI18nFields(set2);

		cfgBookmaker2.setI18n(i2);

		assertFalse(cfgBookmaker1.equals(cfgBookmaker2));

	}
	
	@Test
	public final void cfgBookmakerIdRetrieve() {
		CfgBookmakerId cfgBookmakerId = CfgBookmakerId.getCfgBookmakerIdById("19");
		assertTrue(cfgBookmakerId.nameId().equals(CfgBookmakerId.BETCLIC_COM_ID.nameId()));
	}
}
