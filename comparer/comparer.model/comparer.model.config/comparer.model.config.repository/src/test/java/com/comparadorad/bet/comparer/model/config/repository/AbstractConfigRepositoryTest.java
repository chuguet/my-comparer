/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;
import com.comparadorad.bet.comparer.model.core.repository.AbstractRepositoryTest;
import com.comparadorad.bet.comparer.model.core.repository.IGenericRepository;
import com.comparadorad.bet.comparer.model.repository.config.ConfigRepositoryConfig;

/**
 * The Class AbstractConfigRepositoryTest.
 * 
 * @param <T>
 *            the generic type
 */

@SuppressWarnings("rawtypes")
@ContextConfiguration(classes = { ConfigRepositoryConfig.class }, loader = AnnotationConfigContextLoader.class)
public abstract class AbstractConfigRepositoryTest<T extends IGenericRepository>
		extends AbstractRepositoryTest<T> {

	/**
	 * Gets the i18 n.
	 * 
	 * @return the i18 n
	 */
	public I18n getI18N() {
		I18n i18 = new I18n();
		I18nField i18nField = new I18nField();
		i18nField.setString("Nombre a mostrar");
		i18.addI18nField(i18nField);
		return i18;
	}
	
	protected CfgBookmaker getBookmaker() {
		return new CfgBookmaker("19");
	}

	
}
