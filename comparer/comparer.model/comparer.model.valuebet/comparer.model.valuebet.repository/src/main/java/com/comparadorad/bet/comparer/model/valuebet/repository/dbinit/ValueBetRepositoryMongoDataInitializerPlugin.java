/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.model.valuebet.repository.dbinit;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.dbcore.dbinit.AbstractMongoDataInitializerPlugin;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetHistoricData;
import com.comparadorad.bet.comparer.model.valuebet.repository.ValueBetHistoricRepository;
import com.comparadorad.bet.comparer.model.valuebet.repository.ValueBetRepository;

/**
 * The Class ConfigRepositoryMongoDataInitializerPlugin.
 * 
 * @author chuguet
 */
@Component
public class ValueBetRepositoryMongoDataInitializerPlugin extends
		AbstractMongoDataInitializerPlugin {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(ValueBetRepositoryMongoDataInitializerPlugin.class);

	/** The secure bet historic repository. */
	@Inject
	private ValueBetHistoricRepository valueBetHistoricRepository;

	/** The resource repository. */
	@Inject
	private ValueBetRepository valueBetRepository;

	/**
	 * Gets the drop collection list.
	 * 
	 * @return the drop collection list {@inheritDoc}
	 */
	// @Override
	// public Iterable<Class<? extends IDocument>> getDropCollectionList() {
	// final List<Class<? extends IDocument>> classes = new ArrayList<Class<?
	// extends IDocument>>();
	// classes.add(ValueBetData.class);
	// classes.add(ValueBetHistoricData.class);
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
		saveToRepository(ValueBetData.class, valueBetRepository);
		saveToRepository(ValueBetHistoricData.class, valueBetHistoricRepository);
	}
}
