/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.model.bet.repository.dbinit;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.CfgImageSlider;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElement;
import com.comparadorad.bet.comparer.model.bet.bean.RtToolbarElementCache;
import com.comparadorad.bet.comparer.model.bet.repository.CfgImageSliderRepository;
import com.comparadorad.bet.comparer.model.bet.repository.RtMatchRepository;
import com.comparadorad.bet.comparer.model.bet.repository.RtToolbarElementCacheRepository;
import com.comparadorad.bet.comparer.model.bet.repository.RtToolbarElementRepository;
import com.comparadorad.bet.comparer.model.dbcore.dbinit.AbstractMongoDataInitializerPlugin;

/**
 * The Class ConfigRepositoryMongoDataInitializerPlugin.
 * 
 * @author jgpelaez
 */
@Component
public class BetRepositoryMongoDataInitializerPlugin extends
		AbstractMongoDataInitializerPlugin {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(BetRepositoryMongoDataInitializerPlugin.class);

	/** The image slider config repository. */
	@Inject
	private CfgImageSliderRepository cfgImageSliderRepository;

	/** The rt match repository. */
	@Inject
	private RtMatchRepository rtMatchRepository;

	/** The rt toolbar element cache repository. */
	@Inject
	private RtToolbarElementCacheRepository rtToolbarElementCacheRepository;

	/** The rt toolbar element repository. */
	@Inject
	private RtToolbarElementRepository rtToolbarElementRepository;

	/**
	 * Initialize database.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void loadDbCollection() {
		LOG.info("Initialize database in: " + getClass().getSimpleName());
		saveToRepository(RtMatch.class, rtMatchRepository);
		saveToRepository(CfgImageSlider.class, cfgImageSliderRepository);
		saveToRepository(RtToolbarElement.class, rtToolbarElementRepository);
		saveToRepository(RtToolbarElementCache.class,
				rtToolbarElementCacheRepository);
	}
}
