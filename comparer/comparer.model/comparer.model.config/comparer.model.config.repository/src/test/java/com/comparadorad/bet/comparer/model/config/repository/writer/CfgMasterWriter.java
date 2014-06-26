/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.util.ArrayList;
import java.util.List;

import uk.ac.shef.wit.simmetrics.similaritymetrics.BlockDistance;
import uk.ac.shef.wit.simmetrics.similaritymetrics.ChapmanMatchingSoundex;
import uk.ac.shef.wit.simmetrics.similaritymetrics.MongeElkan;
import uk.ac.shef.wit.simmetrics.similaritymetrics.OverlapCoefficient;
import uk.ac.shef.wit.simmetrics.similaritymetrics.TagLink;

import com.comparadorad.bet.comparer.model.config.bean.CfgMaster;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster.CfgMasterId;
import com.comparadorad.bet.comparer.model.config.bean.CfgMaster.StrikeConfig;
import com.comparadorad.bet.comparer.model.config.bean.CfgResolverAlgorithm;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class CfgMasterWriter.
 */
public class CfgMasterWriter extends AbstractWriterXML<List<CfgMaster>> {

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended {@inheritDoc}
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	protected List<CfgMaster> makeObject() {
		List<CfgMaster> result = new ArrayList<CfgMaster>();
		CfgMaster cfgMaster;
		List<CfgResolverAlgorithm> listaAlgoritmos = new ArrayList<CfgResolverAlgorithm>();
		listaAlgoritmos.add(new CfgResolverAlgorithm(new TagLink(), 0.91));
		listaAlgoritmos.add(new CfgResolverAlgorithm(new BlockDistance(), 0.8));
		// listaAlgoritmos.add(new CfgResolverAlgorithm(new QGramsDistance(),
		// 0.83));
		listaAlgoritmos.add(new CfgResolverAlgorithm(new MongeElkan(), 0.995));
		listaAlgoritmos.add(new CfgResolverAlgorithm(new OverlapCoefficient(),
				0.995));
		listaAlgoritmos.add(new CfgResolverAlgorithm(
				new ChapmanMatchingSoundex(), 0.97));
		long timeToProcessSport = 1200000;
		long timeToProcessBetType = 1200000;
		long timeToProcessCompetition = 1200000;
		long timeToProcessParticipant = 1200000;
		long timeToProcessRegion = 1200000;
		Double sportAlgorithmPrecission = 2.5;
		Double betTypeAlgorithmPrecission = 2.5;
		Double competitionAlgorithmPrecission = 2.5;
		Double regionAlgorithmPrecission = 2.5;
		Double participantAlgorithmPrecission = 2.5;
		String competitionPrecission = "70";

		cfgMaster = createCfgMaster("1", CfgMasterId.BET_TYPE, "11/10/2012",
				result, listaAlgoritmos, timeToProcessBetType,
				betTypeAlgorithmPrecission, "");
		cfgMaster = createCfgMaster("2", CfgMasterId.COMPETITION, "11/10/2012",
				result, listaAlgoritmos, timeToProcessCompetition,
				competitionAlgorithmPrecission, competitionPrecission);
		cfgMaster = createCfgMaster("3", CfgMasterId.PARTICIPANT, "11/10/2012",
				result, listaAlgoritmos, timeToProcessParticipant,
				participantAlgorithmPrecission,"");
		cfgMaster = createCfgMaster("4", CfgMasterId.REGION, "11/10/2012",
				result, listaAlgoritmos, timeToProcessRegion,
				regionAlgorithmPrecission, "");
		cfgMaster = createCfgMaster("5", CfgMasterId.SPORT, "11/10/2012",
				result, listaAlgoritmos, timeToProcessSport,
				sportAlgorithmPrecission, "");
		return result;
	}

	/**
	 * Creates the cfg master.
	 * 
	 * @param objectId
	 *            the object id
	 * @param pCfgMasterId
	 *            the cfg master id
	 * @param date
	 *            the date
	 * @param result
	 *            the result
	 * @param listadoAlgoritmos
	 *            the listado algoritmos
	 * @return the cfg master
	 */
	private CfgMaster createCfgMaster(String objectId,
			CfgMasterId pCfgMasterId, String date, List<CfgMaster> result,
			List<CfgResolverAlgorithm> listadoAlgoritmos, long timeToProcess,
			Double algorithmPrecission, String competitionPrecission) {
		CfgMaster master = new CfgMaster(objectId);
		master.setNameId(pCfgMasterId.nameId());
		master.add(new StrikeConfig(15, "0.8", "0.9", "0.2"));
		master.add(new StrikeConfig(25, "0.7", "0.8", "0.2"));
		master.add(new StrikeConfig(null, "0.65", "0.75", "0.2"));
		master.add(new StrikeConfig());
		master.setHistoricCreationData(getWriterAppUser(),
				getWriterAppDate(date));
		master.setListaAlgoritmos(listadoAlgoritmos);
		master.setTimeToProcess(timeToProcess);
		master.setAlgorithmPrecission(algorithmPrecission);
		master.setCompetitionPrecissionPercent(competitionPrecission);
		result.add(master);
		return master;
	}
}
