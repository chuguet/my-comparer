/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.core.bean.IObjectIdEnum;

/**
 * The Class Team.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
@Document
public class CfgParticipant extends AbstractI18nTableActivable {

	/**
	 * The competition.
	 */
	@DBRef
	@NotNull
	@Valid
	private CfgCompetition cfgCompetition;

	/** The sport. */
	@DBRef
	private CfgSport cfgSport;

	/** The competition xml name. */
	@Field
	private String competitionXmlName;

	/** The sport xml name. */
	@Field
	private String sportXmlName;
	
	/** The participant xml name. */
	@Field
	private String participantXmlName;

	/**
	 * Gets the competition xml name.
	 * 
	 * @return the competition xml name
	 */
	public String getCompetitionXmlName() {
		return competitionXmlName;
	}

	/**
	 * Sets the competition xml name.
	 * 
	 * @param competitionXmlName
	 *            the new competition xml name
	 */
	public void setCompetitionXmlName(String competitionXmlName) {
		this.competitionXmlName = competitionXmlName;
	}

	/**
	 * Gets the sport xml name.
	 * 
	 * @return the sport xml name
	 */
	public String getSportXmlName() {
		return sportXmlName;
	}

	/**
	 * Sets the sport xml name.
	 * 
	 * @param sportXmlName
	 *            the new sport xml name
	 */
	public void setSportXmlName(String sportXmlName) {
		this.sportXmlName = sportXmlName;
	}

	/**
	 * Instantiates a new participant.
	 */
	public CfgParticipant() {
		super();
	}

	/**
	 * Instantiates a new cfg participant.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgParticipant(BigInteger pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new cfg participant.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgParticipant(IObjectIdEnum pObjectId) {
		super(pObjectId);

	}

	/**
	 * Instantiates a new cfg participant.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgParticipant(String pObjectId) {
		super(pObjectId);

	}

	/**
	 * Equals.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CfgParticipant other = (CfgParticipant) obj;
		if (cfgCompetition == null) {
			if (other.cfgCompetition != null)
				return false;
		} else if (!cfgCompetition.equals(other.cfgCompetition))
			return false;
		if (cfgSport == null) {
			if (other.cfgSport != null)
				return false;
		} else if (!cfgSport.equals(other.cfgSport))
			return false;
		return true;
	}

	/**
	 * Gets the competition.
	 * 
	 * @return the competition {@inheritDoc}
	 */
	public CfgCompetition getCompetition() {
		return cfgCompetition;
	}

	/**
	 * Gets the sport.
	 * 
	 * @return the sport {@inheritDoc}
	 */
	public CfgSport getSport() {
		return cfgSport;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Integer.valueOf(this.getObjectId().toString());
	}

	/**
	 * Sets the competition.
	 * 
	 * @param pCfgCompetition
	 *            the new competition {@inheritDoc}
	 */
	public void setCompetition(final CfgCompetition pCfgCompetition) {
		cfgCompetition = pCfgCompetition;
	}

	/**
	 * Sets the sport.
	 * 
	 * @param pCfgSport
	 *            the new sport {@inheritDoc}
	 */
	public void setSport(final CfgSport pCfgSport) {
		cfgSport = pCfgSport;
	}
	
	

	/**
	 * Gets the participant xml name.
	 *
	 * @return the participant xml name
	 */
	public String getParticipantXmlName() {
		return participantXmlName;
	}

	/**
	 * Sets the participant xml name.
	 *
	 * @param participantXmlName the new participant xml name
	 */
	public void setParticipantXmlName(String participantXmlName) {
		this.participantXmlName = participantXmlName;
	}

	/**
	 * To string.
	 * 
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this)
				.append("competition", this.cfgCompetition)
				.append("I18n", this.getI18n()).append("sport", this.cfgSport)
				.toString();
	}
}