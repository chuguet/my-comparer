/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.writer.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.activator.service.IActivatorMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.bean.RtModa;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.synchro.reader.writer.exception.SynchroMatchWriterServiceException;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsCandidate;
import com.comparadorad.bet.comparer.synchro.securebet.process.SureBetProcess;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class SynchroMatchWriterService.
 */
@Service
final class SynchroMatchWriterService implements ISynchroMatchWriterService {

	@Inject
	private SureBetProcess<SureBetsCandidate> sureBetProcess;

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	

	static final Logger updateBetsLog = Logger.getLogger("updateBets");

	/** The match process moda. */
	@Inject
	private RtMatchProcessModa matchProcessModa;

	/** The market validation. */
	@Inject
	private RtMarketValidation rtMarketValidation;

	@Inject
	private IActivatorMatch activatorMatch;

	/** The rt match participant inverter. */
	@Inject
	private RtMatchParticipantInverter rtMatchParticipantInverter;

	/** The rt match service. */
	@Inject
	private IRtMatchService rtMatchService;

	/** The rt match bet updater. */
	@Inject
	private RtMatchUpdateService rtMatchUpdateService;

	/**
	 * Gets the rt match from db.
	 * 
	 * @param matchHashKey
	 *            the rt match
	 * @return the rt match from db
	 */
	private RtMatch getRtMatchFromDB(final String matchHashKey) {

		return rtMatchService.isolatedFindByHashKey(matchHashKey);
	}

	/**
	 * Write.
	 * 
	 * @param rtMatch
	 *            the rt match {@inheritDoc}
	 */
	@Override
	public void write(final RtMatch rtMatch) {
		RtModa modaProcess;
		List<RtModa> modaDB;
		CoreDate modaDate;
		RtMatch result = rtMatch;
		RtMatch rtMatchDB;
		Date now = new Date();

		LOG.debug(Thread.currentThread(), new StringBuffer(
				"Inicio write del evento: ").append(rtMatch.getHashKey())
				.toString());

		modaProcess = matchProcessModa.getModaFromProcess(rtMatch);

		try {

			for (RtMarket market : rtMatch.getRtMarkets()) {
				for (RtBet rtBet : market.getBets()) {
					rtBet.setActualizeDate(now);
				}
			}

			result.setRtMarkets(rtMarketValidation.getValidMarkets(rtMatch));

			Boolean exist = rtMatchService.exists(result.getAbstractKey().getHashKey());

			if(exist){

				rtMatchDB = getRtMatchFromDB(result.getAbstractKey().getHashKey());

				result = rtMatchParticipantInverter.invertParticipants(result,
						rtMatchDB);

				result = rtMatchUpdateService
						.combineRtMatchs(result, rtMatchDB);
				modaDB = matchProcessModa.processModa(result.getMatchId()
						.getModa(), modaProcess);
				modaDate = matchProcessModa.calculateModa(modaDB);
				result.getMatchId().setModa(modaDB);
				result.getMatchId().setStartDate(modaDate);

			}

			result = activatorMatch.execute(result, Boolean.FALSE);

			LOG.debug(
					Thread.currentThread(),
					new StringBuffer(
							"Se inicia el guardado en RtMatch del partido: ")
					.append(result.getHashKey()).append(" - ")
					.append(result.getName(null)).toString());
			result.setRtMarkets(rtMarketValidation.getValidMarkets(result));

			result.setLastLock(null);
			rtMatchService.save(result);

			
			if (result.getMatchId().getCompetitionEvent().getLongTerm()
					.getLongTerm().equals(Boolean.FALSE)
					&& result.getCoreActiveElement().getActive()) {
				sureBetProcess.calculate(new SureBetsCandidate(result));
				LOG.debug(Thread.currentThread(),
						"Se generan las apuestas seguras para el partido");
			}

			LOG.debug(Thread.currentThread(),
					new StringBuffer(
							"Se finaliza el guardado en RtMatch del partido: ")
			.append(result.getHashKey()).toString());

		} catch (MappingException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
		} catch (SynchroMatchWriterServiceException e) {
			LOG.error(Thread.currentThread(), new StringBuffer(
					"No se va a guardar el partido por el siguiente error: ")
			.append(e.getMessage()).toString());
		} catch (Exception e) {
			LOG.error(Thread.currentThread(),
					new StringBuffer(e.getMessage()).toString());
		}

		LOG.debug(Thread.currentThread(), new StringBuffer(
				"Fin write del evento: ").append(rtMatch.getHashKey())
				.toString());

	}
}
