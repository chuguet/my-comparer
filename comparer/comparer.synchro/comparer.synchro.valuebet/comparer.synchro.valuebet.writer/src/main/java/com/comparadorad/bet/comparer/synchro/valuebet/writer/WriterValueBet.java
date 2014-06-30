/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.valuebet.writer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.valuebet.bean.HistoricInfo.Cause;
import com.comparadorad.bet.comparer.model.valuebet.bean.ValueBetData;
import com.comparadorad.bet.comparer.model.valuebet.converter.ValueBetToHistoricConverter;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetHistoricService;
import com.comparadorad.bet.comparer.model.valuebet.service.IValueBetService;
import com.comparadorad.bet.comparer.synchro.valuebet.core.bean.result.ResultValueBet;

/**
 * The Class WriterValueBet.
 */
@Service
class WriterValueBet implements IWriterValueBet {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(WriterValueBet.class);

	/** The value bet historic service. */
	@Inject
	private IValueBetHistoricService valueBetHistoricService;

	/** The value bet service. */
	@Inject
	private IValueBetService valueBetService;

	/**
	 * Delete obsolete match value bets.
	 * 
	 * @param obsoleteMatchValueBetsDB
	 *            the obsolete match value bets db
	 */
	private void deleteObsoleteMatchValueBets(
			List<ValueBetData> obsoleteMatchValueBetsDB) {

		valueBetHistoricService.save(ValueBetToHistoricConverter
				.convertToHistoric(obsoleteMatchValueBetsDB,
						Cause.NO_LONGER_VALUEBET));

		valueBetService.delete(obsoleteMatchValueBetsDB);

	}

	/**
	 * Save value bet.
	 * 
	 * @param valueBetData
	 *            the value bet data
	 */
	private void saveValueBet(ValueBetData valueBetData) {

		LOG.debug("----------- ValueBet nuevo --------------------------");
		LOG.debug("Partido: " + valueBetData.getInfoMatch().getObjectId());
		LOG.debug("Mercado: "
				+ valueBetData.getInfoMatch().getMarket().getHashKey());
		LOG.debug("Bet: " + valueBetData.getBet().getHashKey());
		LOG.debug("Apuesta: " + valueBetData.getBet().getBetOdd().getOdds());
		LOG.debug("Probabilidad: " + valueBetData.getProbability().getValue());
		LOG.debug("Esperanza: " + valueBetData.getExpectation().getValue());
		LOG.debug("Partido: " + valueBetData.getInfoMatch().getObjectId());
		LOG.debug("----------- Fin ValueBet ----------------------------");
		valueBetData.setCreateDate(new CoreDate(Calendar.getInstance()
				.getTime()));
		valueBetService.save(valueBetData);

	}

	/**
	 * Update value bet.
	 * 
	 * @param valueBetDataDB
	 *            the value bet data db
	 * @param valueBetData
	 *            the value bet data
	 */
	private void updateValueBet(ValueBetData valueBetDataDB,
			ValueBetData valueBetData) {

		if (ValueBetToHistoricConverter.valueBetHasChanged(valueBetDataDB,
				valueBetData)) {
			LOG.info("Hay cambios, se procede a actualizar el valuebet y guardar en el historico el antiguo estado:");
			LOG.debug("-------------------- ValueBet -----------------------------");
			LOG.debug("Partido: " + valueBetDataDB.getInfoMatch().getObjectId());
			LOG.debug("Mercado: "
					+ valueBetDataDB.getInfoMatch().getMarket().getHashKey());
			LOG.debug("Bet: " + valueBetDataDB.getBet().getHashKey());
			LOG.debug("-------- ValueBet antes de actualizar -----------");
			LOG.debug("Apuesta: "
					+ valueBetDataDB.getBet().getBetOdd().getOdds());
			LOG.debug("Probabilidad: "
					+ valueBetDataDB.getProbability().getValue());
			LOG.debug("Esperanza: "
					+ valueBetDataDB.getExpectation().getValue());
			LOG.debug("-------- ValueBet con datos modificados ---------");
			LOG.debug("Apuesta: " + valueBetData.getBet().getBetOdd().getOdds());
			LOG.debug("Probabilidad: "
					+ valueBetData.getProbability().getValue());
			LOG.debug("Esperanza: " + valueBetData.getExpectation().getValue());
			LOG.debug("------------------ Fin ValueBet ---------------------------");
			valueBetHistoricService.save(ValueBetToHistoricConverter
					.convertToHistoric(valueBetDataDB, valueBetData));
		}

		valueBetService.update(valueBetDataDB, valueBetData);

	}

	/**
	 * Write.
	 * 
	 * @param items
	 *            the items {@inheritDoc}
	 */
	@Override
	public void write(List<? extends ResultValueBet> items) {

		List<ValueBetData> valueBetsDataDB;
		List<ValueBetData> obsoleteMatchValueBetsDB;

		List<String> hashKeysMarket = new ArrayList<String>();
		List<String> hashKeysBet = new ArrayList<String>();
		String idMatch = null;

		LOG.debug("------------------------ Inicio writer valuebet ---------------------------------");
		for (ResultValueBet resultValueBet : items) {

			for (ValueBetData valueBetData : resultValueBet.getValueBetDatas()) {

				idMatch = valueBetData.getInfoMatch().getObjectId().toString();
				hashKeysMarket.add(valueBetData.getInfoMatch().getMarket()
						.getHashKey());
				hashKeysBet.add(valueBetData.getBet().getHashKey());

				valueBetsDataDB = valueBetService.exist(valueBetData);

				if (valueBetsDataDB != null && valueBetsDataDB.size() == 1) {
					LOG.debug("Valubet ya existe.");
					updateValueBet(valueBetsDataDB.get(0), valueBetData);
				} else {
					LOG.debug("Valubet nuevo. Se procede a guardarla:");
					saveValueBet(valueBetData);
				}
			}

			obsoleteMatchValueBetsDB = valueBetService
					.getDifferingMatchValueBets(idMatch, hashKeysMarket,
							hashKeysBet);
			if (obsoleteMatchValueBetsDB != null
					&& obsoleteMatchValueBetsDB.size() > 0) {
				LOG.debug(new StringBuffer()
						.append("Se procede a borrar ")
						.append(obsoleteMatchValueBetsDB.size())
						.append(" valuebets que no se hayan encontrado del partido con id: ")
						.append(idMatch));
				deleteObsoleteMatchValueBets(obsoleteMatchValueBetsDB);
			}

		}

		LOG.debug("------------------------ Fin writer valuebet ---------------------------------");
	}

}
