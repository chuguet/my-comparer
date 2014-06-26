/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.service.beans;

import java.util.List;

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipantSynonyms;

/**
 * The Class ParticipantsSynonymsMerge.
 */
public class ParticipantsSynonymsMerge {

	/** The participants synonyms old. */
	private List<CfgParticipantSynonyms> participantsSynonymsOld;

	/** The participant synonym master. */
	private CfgParticipantSynonyms participantSynonymMaster;

	/**
	 * Gets the participants synonyms old.
	 * 
	 * @return the participants synonyms old
	 */
	public List<CfgParticipantSynonyms> getParticipantsSynonymsOld() {
		return participantsSynonymsOld;
	}

	/**
	 * Gets the participant synonym master.
	 * 
	 * @return the participant synonym master
	 */
	public CfgParticipantSynonyms getParticipantSynonymMaster() {
		return participantSynonymMaster;
	}

	/**
	 * Sets the participants synonyms old.
	 * 
	 * @param participantsSynonymsOld
	 *            the new participants synonyms old
	 */
	public void setParticipantsSynonymsOld(
			List<CfgParticipantSynonyms> participantsSynonymsOld) {
		this.participantsSynonymsOld = participantsSynonymsOld;
	}

	/**
	 * Sets the participant synonym master.
	 * 
	 * @param participantSynonymMaster
	 *            the new participant synonym master
	 */
	public void setParticipantSynonymMaster(
			CfgParticipantSynonyms participantSynonymMaster) {
		this.participantSynonymMaster = participantSynonymMaster;
	}
}
