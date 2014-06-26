/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.core.service.IGenericCrudService;

/**
 * The Class CfgSportSynonymsServiceTest.
 */
public class CfgMasterServiceTest extends AbstractServiceTest<CfgMaster> {

	public static final Log LOG = LogFactory.getLog(CfgMasterServiceTest.class);

	/** The sport type service. */
	@Inject
	private ICfgMasterService cfgMasterService;

	/**
	 * Gets the i generic service.
	 * 
	 * @return the i generic service {@inheritDoc}
	 */
	@Override
	protected IGenericCrudService<CfgMaster> getIGenericService() {
		return cfgMasterService;
	}
	
	@Test
	public void masterServiceTest() {
		List<CfgMaster> cfgMaster;
		cfgMaster = (List<CfgMaster>) cfgMasterService.findAll();
		
		for (CfgMaster master : cfgMaster) {
			assertNotNull(master);
			assertNotNull(master.getListaAlgoritmos());
		}
		
		
		
	}

}
