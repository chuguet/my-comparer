/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */

package com.comparadorad.bet.comparer.log.repository.dbinit;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.log.repository.LogEventBookmakerMasterWordsRepository;
import com.comparadorad.bet.comparer.log.repository.LogEventBookmakerRepository;
import com.comparadorad.bet.comparer.log.repository.LogEventRepository;
import com.comparadorad.bet.comparer.model.dbcore.dbinit.AbstractMongoDataInitializerPlugin;
import com.comparadorad.bet.comparer.model.log.bean.LogEvent;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmaker;
import com.comparadorad.bet.comparer.model.log.bean.LogEventBookmakerMasterWords;

/**
 * The Class ConfigRepositoryMongoDataInitializerPlugin.
 * 
 * @author jgpelaez
 */
@Component
public class LogRepositoryMongoDataInitializerPlugin extends
		AbstractMongoDataInitializerPlugin {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory
			.getLog(LogRepositoryMongoDataInitializerPlugin.class);

	/** The log event bookmaker master words repository. */
	@Inject
	private LogEventBookmakerMasterWordsRepository logEventBookmakerMasterWordsRepository;

	/**
	 * Initialize database.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void loadDbCollection() {
		LOG.info("Initialize database in: " + getClass().getSimpleName());
		saveToRepository(LogEventBookmakerMasterWords.class,
				logEventBookmakerMasterWordsRepository);
	}
}
