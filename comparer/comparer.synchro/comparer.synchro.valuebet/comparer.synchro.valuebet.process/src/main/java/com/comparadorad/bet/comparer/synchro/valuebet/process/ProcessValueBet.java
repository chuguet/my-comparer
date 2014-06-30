/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.process;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtMarket;
import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;
import com.comparadorad.bet.comparer.synchro.valuebet.process.bean.CalculateValueBetData;
import com.comparadorad.bet.comparer.synchro.valuebet.process.calculate.ICalculateValueBet;
import com.comparadorad.bet.comparer.synchro.valuebet.process.convert.ICalculateValueBetDataToResultValueBet;
import com.comparadorad.bet.comparer.synchro.valuebet.process.factory.IFactoryCalculateValueBet;

/**
 * The Class ProcessValueBet.
 */
@Service
class ProcessValueBet implements IProcessValueBet {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(IProcessValueBet.class);

	/** The calculate value bet. */
	@Inject
	private IFactoryCalculateValueBet factoryCalculateValueBet;

	/** The to result value bet. */
	@Inject
	private ICalculateValueBetDataToResultValueBet toResultValueBet;

	/**
	 * Prints the log msg.
	 * 
	 * @param betDatas
	 *            the bet datas
	 */
	private void printLogMsg(List<CalculateValueBetData> betDatas) {
		if (LOG.isDebugEnabled()) {
			StringBuffer sb = new StringBuffer();
			sb.append("Numero de valueBets encontrado: ");
			sb.append(betDatas.size());
			for (CalculateValueBetData valueBet : betDatas) {
				sb.append("\n*************");
				sb.append("\nHashKey bet: ").append(
						valueBet.getBet().getHashKey());
				sb.append("\nOdd: ").append(
						valueBet.getBet().getBetOdd().getOdds());
				sb.append("\nBookmaker: ").append(
						valueBet.getBet().getBookmaker().getObjectId()
								.toString());
				sb.append("\nExpectation: ").append(
						valueBet.getExpectation().getValue().toString());
				sb.append("\nProbabilidad: ").append(
						valueBet.getProbability().getValue().toString());
			}
			sb.append("\n*************");
			LOG.debug(sb.toString());
		}

	}

	/**
	 * Process.
	 * 
	 * @param match
	 *            the match
	 * @return the result value bet
	 * @throws Exception
	 *             the exception {@inheritDoc}
	 */
	@Override
	public ResultValueBet process(RtMatch match) throws Exception {

		List<CalculateValueBetData> betDatas;
		List<RtBet> bets;
		ResultValueBet resultValueBet = new ResultValueBet();

		LOG.debug("------------------------ Inicio Process Valuebet ---------------------------------");
		LOG.debug(new StringBuffer().append(
				"Se procede a calcular los valubets del match: ").append(
				match.getHashKey()));

		for (RtMarket market : match.getRtMarkets()) {
			bets = new ArrayList<RtBet>();
			for (RtBet bet : market.getBets()) {
				bet.setBetType(market.getBetType());
				bets.add(bet);
			}
			// Le digo a la factoria que implementación me tiene que hacer
			ICalculateValueBet iCalculateValueBet = factoryCalculateValueBet
					.calculateValueBet(market.getBetType());
			LOG.debug(new StringBuffer()
					.append("Tratamos el mercado con betType: ")
					.append(market.getBetType().getNameId())
					.append(", betTypeEvent: ")
					.append(market.getBetTypeEvent().getBetTypeEvent()
							.getNameId()));
			// De todas las apuestas existentes, saco las de mas valor
			betDatas = iCalculateValueBet.calculateValueBet(bets);
			if (betDatas != null && !betDatas.isEmpty()) {
				printLogMsg(betDatas);
				resultValueBet.getValueBetDatas().addAll(
						toResultValueBet.convert(match, market, betDatas,
								market.getBetTypeEvent()).getValueBetDatas());
			}
		}
		LOG.debug("------------------------ Fin Process Valuebet ---------------------------------");

		return resultValueBet;

	}

}
