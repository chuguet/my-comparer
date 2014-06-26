/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.databaseclean.task;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.synchro.databaseclean.validators.IDatabaseCleaner;

/**
 * The Class CleanTask.
 */
@Component
class DatabaseCleanTask implements IDatabaseCleanTask {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(DatabaseCleanTask.class);

	/** The database cleaner. */
	@Inject
	private IDatabaseCleaner databaseCleaner;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.databaseclean.task.IDatabaseCleanTask
	 * #databaseCleanTask()
	 */
	@Override
	@Scheduled(fixedDelay = 10000)
	public void databaseCleanTask() {
		Integer deleteObjects;
		LOG.info("---------------------------------");
		LOG.info("Comienzo del proceso de limpieza.");
		LOG.info("Se procede a limpiar las Competiciones.");
		deleteObjects = databaseCleaner.cleanCompetitions();
		LOG.info(new StringBuffer("Se han eliminado ").append(deleteObjects)
				.append(" Competiciones.").toString());
		LOG.info("Se procede a limpiar los sinonimos de competicion.");
		deleteObjects = databaseCleaner.cleanCompetitionsSynonyms();
		LOG.info(new StringBuffer("Se han eliminado ").append(deleteObjects)
				.append(" sinonimos de competicion.").toString());
		LOG.info("Se procede a limpiar los Matchs.");
		deleteObjects = databaseCleaner.cleanMatches();
		LOG.info(new StringBuffer("Se han eliminado ").append(deleteObjects)
				.append(" Matchs.").toString());
		LOG.info("Se procede a limpiar los Participantes.");
		deleteObjects = databaseCleaner.cleanParticipants();
		LOG.info(new StringBuffer("Se han eliminado ").append(deleteObjects)
				.append(" Participantes.").toString());
		LOG.info("Se procede a limpiar los sinonimos de participante");
		deleteObjects = databaseCleaner.cleanParticipantsSynonyms();
		LOG.info(new StringBuffer("Se han eliminado ").append(deleteObjects)
				.append(" sinonimos de participante.").toString());
		LOG.info("Se procede a limpiar los sinonimos de region.");
		deleteObjects = databaseCleaner.cleanRegionSynonyms();
		LOG.info(new StringBuffer("Se han eliminado ").append(deleteObjects)
				.append(" sinonimos de region.").toString());
		LOG.info("Se procede a limpiar los sinonimos de deporte.");
		deleteObjects = databaseCleaner.cleanSportSynonyms();
		LOG.info(new StringBuffer("Se han eliminado ").append(deleteObjects)
				.append(" sinonimos de deporte.").toString());
		LOG.info("Se procede a limpiar las Sure Bets");
		deleteObjects = databaseCleaner.cleanSureBet();
		LOG.info(new StringBuffer("Se han eliminado ").append(deleteObjects)
				.append(" Sure Bets.").toString());
		LOG.info("Se procede a limpiar las Value Bets");
		deleteObjects = databaseCleaner.cleanValueBet();
		LOG.info(new StringBuffer("Se han eliminado ").append(deleteObjects)
				.append(" Value Bets.").toString());
		LOG.info("Fin del proceso de limpieza.");
		LOG.info("---------------------------------");
	}

}
