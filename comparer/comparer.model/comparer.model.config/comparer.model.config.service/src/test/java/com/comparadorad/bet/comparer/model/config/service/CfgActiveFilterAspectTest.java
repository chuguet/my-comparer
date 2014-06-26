/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class CfgActiveFilterAspectTest.
 */
public class CfgActiveFilterAspectTest extends AbstractServiceTest<CfgBetType> {

	/** The bet type service. */
	@Inject
	private ICfgBetTypeService betTypeService;

	/** {@inheritDoc} */
	@Override
	protected IGenericCrudService<CfgBetType> getIGenericService() {
		return betTypeService;
	}

	/**
	 * Test aspect.
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void testAspect() {
		int numElementsBefore = ((List) betTypeService.findAll()).size();
		// unactive element
		CfgBetType betType = new CfgBetType();
		betType.setCoreActiveElement(new CoreActiveElement(false));
		I18n i18n = new I18n();
		i18n.addI18nField(new I18nField("nombre", Locale.ENGLISH));
		betType.setI18n(i18n);
		betType.setObjectId(new BigInteger("5325324324"));
		betTypeService.save(betType);
		int numElementsAfter = ((List) betTypeService.findAll()).size();
		assertEquals(numElementsBefore, numElementsAfter);
		// active element
		CfgBetType betType2 = new CfgBetType();
		betType2.setCoreActiveElement(new CoreActiveElement(true));
		betType2.setI18n(i18n);
		betType2.setObjectId(new BigInteger("897358352"));
		betTypeService.save(betType2);
		numElementsAfter = ((List) betTypeService.findAll()).size();
		assertEquals(numElementsBefore + 1, numElementsAfter);
	}
}
