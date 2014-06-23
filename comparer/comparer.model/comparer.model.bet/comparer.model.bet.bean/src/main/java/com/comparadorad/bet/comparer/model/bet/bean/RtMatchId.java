/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.bet.bean.validator.AllContainsName;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.annotation.CorrectCoreDate;
import com.comparadorad.bet.comparer.model.core.bean.annotation.SetWithAtLeastTwoElement;

/**
 * The Class RtMatchID.
 * 
 * @author fvizcaino, chuguet
 * @version 1.0
 */
@SuppressWarnings("serial")
@Document
public class RtMatchId extends AbstractBetBean {

	/**
	 * The rt competition.
	 */
	@DBRef
	@NotNull
	@Valid
	private CfgCompetition competition;

	/** The competition event. */
	@DBRef
	@NotNull
	private CfgCompetitionEvent competitionEvent;

	/** The moda. */
	@Field
	@NotNull
	private List<RtModa> moda;

	/** The team. */
	@Field
	@SetWithAtLeastTwoElement
	@AllContainsName
	@Valid
	@NotNull
	private Set<RtParticipant> participiants;

	/** The rt date. */
	@Field
	@CorrectCoreDate
	@Valid
	private CoreDate startDate;

	/**
	 * Adds the moda.
	 * 
	 * @param pModa
	 *            the moda
	 */
	public void addModa(RtModa pModa) {
		if (moda == null) {
			moda = new ArrayList<RtModa>();
		}
		moda.add(pModa);
	}

	/**
	 * Adds the team.
	 * 
	 * @param pRtParticipiant
	 *            the p e
	 * @return true, if successful
	 */
	public boolean addParticipiant(RtParticipant pRtParticipiant) {
		return getParticipiants().add(pRtParticipiant);
	}

	/**
	 * Gets the competition.
	 * 
	 * @return the competition
	 */
	public CfgCompetition getCompetition() {
		return competition;
	}

	/**
	 * Gets the competition event.
	 * 
	 * @return the competition event
	 */
	public CfgCompetitionEvent getCompetitionEvent() {
		return competitionEvent;
	}

	/**
	 * Gets the moda.
	 * 
	 * @return the moda
	 */
	public List<RtModa> getModa() {
		return moda;
	}

	/**
	 * Gets the team.
	 * 
	 * @return the team
	 */
	public Set<RtParticipant> getParticipiants() {
		if (participiants == null) {
			participiants = new HashSet<RtParticipant>();
		}
		return participiants;
	}

	/**
	 * Gets the core date.
	 * 
	 * @return the core date
	 */
	public CoreDate getStartDate() {
		return startDate;
	}

	/**
	 * Sets the competition.
	 * 
	 * @param pCompetition
	 *            the new competition
	 */
	public void setCompetition(CfgCompetition pCompetition) {
		this.competition = pCompetition;
	}

	/**
	 * Sets the competition event.
	 * 
	 * @param pCompetitionEvent
	 *            the new competition event
	 */
	public void setCompetitionEvent(CfgCompetitionEvent pCompetitionEvent) {
		competitionEvent = pCompetitionEvent;
	}

	/**
	 * Sets the moda.
	 * 
	 * @param moda
	 *            the moda
	 */
	public void setModa(List<RtModa> moda) {
		this.moda = moda;
	}

	/**
	 * Sets the sets the team.
	 * 
	 * @param pParticipants
	 *            the new participiants
	 */
	public void setParticipiants(Set<RtParticipant> pParticipants) {
		participiants = pParticipants;
	}

	/**
	 * Sets the core date.
	 * 
	 * @param pCoreDate
	 *            the new core date
	 */
	public void setStartDate(CoreDate pCoreDate) {
		startDate = pCoreDate;
	}

}