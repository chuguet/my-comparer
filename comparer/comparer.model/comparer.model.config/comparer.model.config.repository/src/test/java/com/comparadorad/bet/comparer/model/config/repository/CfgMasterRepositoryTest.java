/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster.CfgMasterId;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster.StrikeConfig;
import com.comparadorad.bet.comparer.model.repository.CfgMasterRepository;

/**
 * The Class CfgMasterRepositoryTest.
 */
public class CfgMasterRepositoryTest extends
		AbstractConfigRepositoryTest<CfgMasterRepository> {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CfgMasterRepositoryTest.class);

	/** The master repository. */
	@Inject
	private CfgMasterRepository cfgMasterRepository;

	/**
	 * Gets the crud repository.
	 * 
	 * @return the crud repository {@inheritDoc}
	 */
	@Override
	public CfgMasterRepository getCrudRepository() {
		return cfgMasterRepository;
	}

	/**
	 * Gets the new element.
	 * 
	 * @return the new element {@inheritDoc}
	 */
	@Override
	protected Object getNewElement() {
		CfgMaster cfgMaster = new CfgMaster();
		cfgMaster.setNameId(CfgMasterId.SPORT.nameId());
		cfgMaster.add(new StrikeConfig(15, new BigDecimal(0.8), new BigDecimal(
				0.9)));
		return cfgMaster;
	}
}
