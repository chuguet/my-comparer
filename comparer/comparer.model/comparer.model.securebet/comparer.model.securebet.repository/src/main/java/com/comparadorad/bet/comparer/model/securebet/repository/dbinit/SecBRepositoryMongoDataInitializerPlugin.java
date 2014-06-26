/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.model.securebet.repository.dbinit;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.dbcore.dbinit.AbstractMongoDataInitializerPlugin;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;
import com.comparadorad.bet.comparer.model.securebet.bean.CfgSureBet;
import com.comparadorad.bet.comparer.model.securebet.repository.SecureBetHistoricRepository;
import com.comparadorad.bet.comparer.model.securebet.repository.SecureBetRepository;
import com.comparadorad.bet.comparer.model.securebet.repository.CfgSureBetRepository;

/**
 * The Class ConfigRepositoryMongoDataInitializerPlugin.
 * 
 * @author chuguet
 */
@Component
public class SecBRepositoryMongoDataInitializerPlugin extends
		AbstractMongoDataInitializerPlugin {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(SecBRepositoryMongoDataInitializerPlugin.class);

	/** The secure bet historic repository. */
	@Inject
	private SecureBetHistoricRepository secureBetHistoricRepository;

	/** The resource repository. */
	@Inject
	private SecureBetRepository secureBetRepository;

	/** The sure bet config repository. */
	@Inject
	private CfgSureBetRepository cfgSureBetRepository;

	/**
	 * Gets the drop collection list.
	 * 
	 * @return the drop collection list {@inheritDoc}
	 */
	// @Override
	// public Iterable<Class<? extends IDocument>> getDropCollectionList() {
	// final List<Class<? extends IDocument>> classes = new ArrayList<Class<?
	// extends IDocument>>();
	// classes.add(SecureBeanData.class);
	// classes.add(SecureBeanHistoricData.class);
	// classes.add(SureBetConfig.class);
	// return classes;
	// }

	/**
	 * Initialize database.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void loadDbCollection() {
		LOG.info("Initialize database in: " + getClass().getSimpleName());
		saveToRepository(SecureBeanData.class, secureBetRepository);
		saveToRepository(SecureBeanHistoricData.class,
				secureBetHistoricRepository);
		saveToRepository(CfgSureBet.class, cfgSureBetRepository);
	}

}
