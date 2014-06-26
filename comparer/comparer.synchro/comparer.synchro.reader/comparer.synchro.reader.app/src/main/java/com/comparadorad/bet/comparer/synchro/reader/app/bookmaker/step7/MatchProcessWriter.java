/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.step7;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.AbstractBookmakerProcess;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.RtMatchWithHash;
import com.comparadorad.bet.comparer.synchro.reader.app.bookmaker.StepProcessData;
import com.comparadorad.bet.comparer.synchro.reader.filter.plugin.PluginFilterWithIdentificator;
import com.comparadorad.bet.comparer.synchro.reader.writer.service.ISynchroMatchWriterService;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class MatchProcessWriter.
 */
@Service
public class MatchProcessWriter extends AbstractBookmakerProcess implements
		ItemWriter<StepProcessData<RtMatchWithHash>> {

	/** The synchro match writer service. */
	@Inject
	private ISynchroMatchWriterService synchroMatchWriterService;

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The filters. */
	@Inject
	private PluginFilterWithIdentificator pluginFilterWithIdentificator;

	/**
	 * Write.
	 * 
	 * @param pMatchs
	 *            the matchs
	 * @throws Exception
	 *             the exception {@inheritDoc}
	 */
	@Override
	public void write(List<? extends StepProcessData<RtMatchWithHash>> pMatchs)
			throws Exception {

		List<String> hashkeyMarkets;
		RtMatch match;
		CfgBookmaker cfgBookmaker;
		String hashkeyXmlMatch;
		String hashkeyRtMatch;
		Boolean isFound = Boolean.FALSE;

		LOG.debug(Thread.currentThread(),
				"Se inicia el guardado de los RtMatch en base de datos");

		for (StepProcessData<RtMatchWithHash> abstractProcessData : pMatchs) {

			match = abstractProcessData.getData().getMatch();
			hashkeyRtMatch = match.getHashKey();
			hashkeyXmlMatch = abstractProcessData.getData().getHash();
			cfgBookmaker = abstractProcessData.getCfgBookmaker();
			hashkeyMarkets = new ArrayList<String>();

			for (RtMarket market : match.getRtMarkets()) {
				hashkeyMarkets.add(market.getHashKey());
			}

			isFound = pluginFilterWithIdentificator
					.completeRtMatchFilterIdentificatorWithXmlMatchHashkey(
							cfgBookmaker, hashkeyXmlMatch, hashkeyRtMatch,
							hashkeyMarkets);
			if (isFound) {
				synchroMatchWriterService.write(match);
			} else {
				LOG.info(Thread.currentThread(), new StringBuffer(
						"No ha sido posible rellenar el filtro").toString());
			}

		}

		LOG.debug(Thread.currentThread(),
				"Se finaliza el guardado de los RtMatch en base de datos");
	}

}
