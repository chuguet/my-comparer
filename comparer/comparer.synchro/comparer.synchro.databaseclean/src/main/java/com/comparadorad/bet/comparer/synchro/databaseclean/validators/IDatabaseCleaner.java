/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.databaseclean.validators;

/**
 * The Interface ICleaner.
 */
public interface IDatabaseCleaner {

	/**
	 * Clean competitions.
	 *
	 * @return the integer
	 */
	Integer cleanCompetitions();

	/**
	 * Clean competitions synonyms.
	 *
	 * @return the integer
	 */
	Integer cleanCompetitionsSynonyms();

	/**
	 * Clean matches.
	 *
	 * @return the integer
	 */
	Integer cleanMatches();

	/**
	 * Clean participants.
	 *
	 * @return the integer
	 */
	Integer cleanParticipants();

	/**
	 * Clean participants synonyms.
	 *
	 * @return the integer
	 */
	Integer cleanParticipantsSynonyms();

	/**
	 * Clean region synonyms.
	 *
	 * @return the integer
	 */
	Integer cleanRegionSynonyms();

	/**
	 * Clean sports.
	 *
	 * @return the integer
	 */
	Integer cleanSports();

	/**
	 * Clean sport synonyms.
	 *
	 * @return the integer
	 */
	Integer cleanSportSynonyms();

	/**
	 * Clean sure bet.
	 *
	 * @return the integer
	 */
	Integer cleanSureBet();

	/**
	 * Clean value bet.
	 *
	 * @return the integer
	 */
	Integer cleanValueBet();
	
}
