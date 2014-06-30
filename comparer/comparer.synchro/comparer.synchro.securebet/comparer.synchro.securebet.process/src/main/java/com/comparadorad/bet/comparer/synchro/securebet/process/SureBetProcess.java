/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsCandidate;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMarket;
import com.comparadorad.bet.comparer.synchro.securebet.core.beans.SureBetsMatch;
import com.comparadorad.bet.comparer.synchro.securebet.process.factory.ICalculateSecureBetFactory;
import com.comparadorad.bet.comparer.synchro.securebet.process.factory.calculate.ICalculateSecureBet;
import com.comparadorad.bet.comparer.synchro.securebet.writer.SureBetWriter;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class ProcessSecureBet.
 * 
 * @param <T>
 *            the generic type
 */
@Service
public class SureBetProcess<T extends SureBetsCandidate> {

	/** The factory. */
	@Inject
	private ICalculateSecureBetFactory factory;

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;
	
	@Inject
	private SureBetWriter<SureBetsMatch> sureBetWriter;

	/**
	 * Calculate.
	 * 
	 * @param secureBetResultBean
	 *            the secure bet result bean
	 * @return the i {@inheritDoc}
	 */
	public void calculate(T sureBetsCandidate) {
		ICalculateSecureBet calculateSecureBet;
		SureBetsMatch sureBetsMatch;
		RtMatch match;
		SureBetsMatch result = new SureBetsMatch();
		if (sureBetsCandidate.getRtMatch() != null) {
			match = sureBetsCandidate.getRtMatch();
			LOG.debug(Thread.currentThread(), new StringBuffer(
					"Se va a procesar el partido ").append(match.getName(null))
					.toString());
			for (RtMarket rtMarket : match.getRtMarkets()) {
				calculateSecureBet = factory.calculateSecureBet(rtMarket
						.getBetType());
				sureBetsMatch = calculateSecureBet
						.calculateSecureBetForRtMarket(match, rtMarket);
				for (SureBetsMarket sureBetsMarket : sureBetsMatch
						.getSureBetsMarket()) {
					if (!sureBetsMarket.getSecureBetAgrupation().isEmpty()) {
						result.add(sureBetsMarket);
					}
				}
			}
			if (!result.getSureBetsMarket().isEmpty()) {
				LOG.debug(Thread.currentThread(),
						"Se van a guardar apuestas seguras");
				sureBetWriter.write(result);
				LOG.debug(Thread.currentThread(), "Apuestas seguras guardadas.");
			} else{
				LOG.debug(Thread.currentThread(), "El partido no tiene apuestas seguras.");
			}
		}
		LOG.debug(Thread.currentThread(), "Partido procesado");
	}
}
