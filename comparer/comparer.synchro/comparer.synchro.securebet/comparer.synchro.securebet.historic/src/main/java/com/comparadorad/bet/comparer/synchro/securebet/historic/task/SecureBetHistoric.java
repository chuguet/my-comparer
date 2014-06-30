/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.historic.task;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.bet.service.IRtMatchService;
import com.comparadorad.bet.comparer.model.securebet.bean.CfgSureBet;
import com.comparadorad.bet.comparer.model.securebet.bean.HistoricInfo.Cause;
import com.comparadorad.bet.comparer.model.securebet.bean.InfoMatch;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanBenefit;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanData;
import com.comparadorad.bet.comparer.model.securebet.bean.SecureBeanHistoricData;
import com.comparadorad.bet.comparer.model.securebet.repository.SecureBetHistoricRepository;
import com.comparadorad.bet.comparer.model.securebet.repository.SecureBetRepository;
import com.comparadorad.bet.comparer.model.securebet.service.ICfgSureBetService;
import com.comparadorad.bet.comparer.synchro.securebet.historic.exception.InvalidBenefitException;
import com.comparadorad.bet.comparer.synchro.securebet.historic.exception.SecureBetHistoricException;

/**
 * The Class SecureBetHistoric.
 */
@Service
final class SecureBetHistoric implements ISecureBetHistoric {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(SecureBetHistoric.class);

	/** The cfg sure bet config. */
	@Inject
	private ICfgSureBetService cfgSureBetConfig;

	/** The secure bet repository. */
	@Inject
	private SecureBetRepository secureBetRepository;

	/** The secure bet historic repository. */
	@Inject
	private SecureBetHistoricRepository secureBetHistoricRepository;

	/** The rt match service. */
	@Inject
	private IRtMatchService matchService;

	/** The page size. */
	private static int pageSize = 10;

	/**
	 * Execute.
	 * 
	 */
	@Override
	@Scheduled(fixedDelay = 1)
	public void execute() {
		Date startDate = new Date();
		Long now;
		SecureBeanHistoricData secureBeanHistoricData;
		int page = 0;
		int count = 0;
		Boolean delete;
		Cause cause = null;
		Iterable<SecureBeanData> secureBeansData;
		while (true) {
			count = 0;
			LOG.info("Se verifican 10 SB, page: " + page);
			secureBeansData = secureBetRepository.getSureBetPaginateForHistoric(pageSize, page);
			page++;
			for (SecureBeanData secureBeanData : secureBeansData) {

				count++;
				delete = Boolean.FALSE;
				try {
					if (pastEvent(secureBeanData.getInfoMatch())) {
						delete = Boolean.TRUE;
						cause = Cause.FinalDePartido;
					} else if (changeBets(secureBeanData)) {
						delete = Boolean.TRUE;
						cause = Cause.BajadaDeCuotas_YaNoEsSureBet;
					}
				} catch (SecureBetHistoricException exc) {
					LOG.error("Se ha detectado un error en la apuesta segura, se elimina para que no vuelva a ocurrir");
					delete = Boolean.TRUE;
					cause = Cause.Error_En_Apuesta;
				}

				if (delete) {
					LOG.info("Se pasa a historico una surebet: " + cause);
					secureBeanHistoricData = secureBeanData.convertToHistoric(cause);
					secureBetHistoricRepository.saveWithOutValidation(secureBeanHistoricData);
					secureBetRepository.delete(secureBeanData);

				}
			}

			if (count < pageSize || count == 0) {
				now = ((new Date().getTime() - startDate.getTime()) / 1000);
				LOG.info(new StringBuffer("El historico ha tardado: ").append(now).append(" segundos").toString());
				break;
			}
		}

	}

	/**
	 * Past event.
	 * 
	 * @param match
	 *            the match
	 * @return true, if successful
	 * @throws NullPointerException
	 *             the null pointer exception
	 */
	private Boolean pastEvent(InfoMatch match) throws SecureBetHistoricException {
		if (match.getDate() != null) {
			return Calendar.getInstance().getTime().after(match.getDate());
		} else {
			throw new SecureBetHistoricException("El partido no tiene fecha asociada");
		}

	}

	/**
	 * Change bets.
	 * 
	 * @param secureBeanData
	 *            the secure bean data
	 * @return true, if successful
	 */
	private Boolean changeBets(SecureBeanData secureBeanData) {
		Boolean result = Boolean.FALSE;
		RtMarket market = matchService.findMarketByBetTypeAndBetTypeEvent(secureBeanData.getInfoMatch().getObjectId().toString(),
				secureBeanData.getBetType().getObjectId().toString(), secureBeanData.getBetTypeEvent().getBetTypeEvent().getObjectId()
						.toString());

		if (market != null) {
			if (differencesFound(market, secureBeanData)) {
				result = true;
			}

		} else {
			result = true;
		}
		return result;
	}

	/**
	 * Differences found.
	 * 
	 * @param market
	 *            the market
	 * @param secureBeanData
	 *            the secure bean data
	 * @return true, if successful
	 */
	private boolean differencesFound(RtMarket market, SecureBeanData secureBeanData) {
		Boolean result = Boolean.FALSE;
		Boolean flag = Boolean.FALSE;
		Set<RtBet> betsDB = new HashSet<RtBet>();
		for (RtBet rtBet : secureBeanData.getBets()) {
			for (RtBet bet : market.getBets()) {
				if (rtBet.getHashKey().equals(bet.getHashKey())) {
					betsDB.add(bet);
					if (!rtBet.getBetOdd().getOdds().equals(bet.getBetOdd().getOdds())) {
						flag = Boolean.TRUE;
					}
				}
			}
		}
		if (flag) {
			if (secureBeanData.getBets().size() == betsDB.size()) {
				try {
					update(betsDB, secureBeanData, getBenefit(betsDB));
					result = Boolean.FALSE;
				} catch (InvalidBenefitException e) {
					result = Boolean.TRUE;
				}
			} else {
				result = Boolean.TRUE;
			}
		}
		return result;
	}

	/**
	 * Find odd.
	 * 
	 * @param match
	 *            the match
	 * @param pBet
	 *            the bet
	 * @param betTypeEvent
	 *            the bet type event
	 * @return the float
	 */
	Float findOdd(RtMatch match, RtBet pBet, RtBetTypeEvent betTypeEvent) {
		Float result = null;
		for (RtMarket market : match.getRtMarkets()) {
			if ((betTypeEvent.getBetTypeEvent().getObjectId().toString().equals(market.getBetTypeEvent().getBetTypeEvent().getObjectId()
					.toString()))
					&& (pBet.getBetType().getObjectId().toString().equals(market.getBetType().getObjectId().toString()))) {
				for (RtBet bet : market.getBets()) {
					if (equalsBets(bet, pBet)) {
						return Float.valueOf(bet.getBetOdd().getOdds());
					}
				}
			}
		}
		return result;
	}

	/**
	 * Equals bets.
	 * 
	 * @param betMatch
	 *            the bet match
	 * @param betOdd
	 *            the bet odd
	 * @return true, if successful
	 */
	boolean equalsBets(RtBet betMatch, RtBet betOdd) {
		return betMatch.getBookmaker().equals(betOdd.getBookmaker()) && betMatch.getParticipant().equals(betOdd.getParticipant());
	}

	/**
	 * Update.
	 * 
	 * @param bets
	 *            the bets
	 * @param surebetDB
	 *            the surebet db
	 * @param benefit
	 *            the benefit
	 */
	private void update(Set<RtBet> bets, SecureBeanData surebetDB, SecureBeanBenefit benefit) {

		SecureBeanData secureBeanData = new SecureBeanData();
		secureBeanData.setBets(bets);
		secureBeanData.setBenefit(benefit);
		LOG.info("Se pasa a historico una surebet: " + Cause.CambioDeCuotas_SigueSiendoSureBet);
		secureBetRepository.update(surebetDB, secureBeanData.getBets(), secureBeanData.getBenefit());
		secureBetHistoricRepository.saveWithOutValidation(surebetDB.convertToHistoric(Cause.CambioDeCuotas_SigueSiendoSureBet));
	}

	/**
	 * Gets the benefit.
	 * 
	 * @param bets
	 *            the bets
	 * @return the benefit
	 * @throws InvalidBenefitException
	 *             the invalid benefit exception
	 */
	private SecureBeanBenefit getBenefit(Set<RtBet> bets) throws InvalidBenefitException {
		Float criteria;
		Double odd, benefit, probabilityOdd, probabilityStake, stake;
		RtBet bet;

		criteria = 0f;
		for (RtBet rtBet : bets) {
			criteria += 1 / Float.valueOf(rtBet.getBetOdd().getOdds());
		}

		benefit = 0d;
		bet = bets.iterator().next();
		odd = Double.valueOf(bet.getBetOdd().getOdds());
		probabilityOdd = 1 / odd;
		probabilityStake = probabilityOdd / criteria;
		stake = probabilityStake * 100;
		benefit = (stake * odd) - 100;

		if (!validBenefit(benefit)) {
			throw new InvalidBenefitException();
		}

		return new SecureBeanBenefit(benefit);
	}

	/**
	 * Valid benefit.
	 * 
	 * @param benefit
	 *            the benefit
	 * @return the boolean
	 */
	private Boolean validBenefit(Double benefit) {
		Boolean result = false;
		Double min;
		Double max;
		CfgSureBet cfgSureBet;
		Iterator<CfgSureBet> sureBetIterator = cfgSureBetConfig.findAll().iterator();
		if (sureBetIterator.hasNext()) {
			cfgSureBet = sureBetIterator.next();

			min = cfgSureBet.getMinBenefit().getValue();
			max = cfgSureBet.getMaxBenefit().getValue();

			result = benefit >= min && benefit <= max;
		}

		return result;
	}
}
