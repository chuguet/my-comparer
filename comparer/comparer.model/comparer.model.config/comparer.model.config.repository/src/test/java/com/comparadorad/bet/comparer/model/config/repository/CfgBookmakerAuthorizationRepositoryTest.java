/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import java.util.Locale;

import javax.inject.Inject;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmakerAuthorization;
import com.comparadorad.bet.comparer.model.config.bean.CfgRegion;
import com.comparadorad.bet.comparer.model.core.bean.I18n;
import com.comparadorad.bet.comparer.model.core.bean.I18nField;
import com.comparadorad.bet.comparer.model.repository.CfgBookmakerAuthorizationRepository;

/**
 * The Class CfgBookmakerAuthorizationTest.
 */
public class CfgBookmakerAuthorizationRepositoryTest extends
		AbstractConfigRepositoryTest<CfgBookmakerAuthorizationRepository> {

	/** The bookmaker configuration repository. */
	@Inject
	private transient CfgBookmakerAuthorizationRepository repository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public CfgBookmakerAuthorizationRepository getCrudRepository() {
		return repository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		CfgBookmakerAuthorization element = new CfgBookmakerAuthorization();
		element.setI18n(getI18N());
		CfgBookmaker cfgBookmaker = new CfgBookmaker(
				CfgBookmakerId._10BET_COM_ID);
		CfgRegion region = new CfgRegion("1");
		I18n nombreRegion = new I18n();
		nombreRegion.addI18nField(new I18nField("nombreRegion", Locale.ENGLISH));
		region.setI18n(nombreRegion);
		element.setRegion(region);
		
		
		element.addBookmakers(cfgBookmaker);
		return element;
	}

}
