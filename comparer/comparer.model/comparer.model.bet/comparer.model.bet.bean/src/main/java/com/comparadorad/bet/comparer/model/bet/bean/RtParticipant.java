/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.math.BigInteger;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.comparadorad.bet.comparer.model.config.bean.CfgParticipant;

/**
 * The Class RtParticipant.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
public class RtParticipant extends AbstractBetBean implements IRtData, Comparable<RtParticipant> {

	/** The away participant. */
	private boolean awayParticipant = false;

	/** The cfg team. */
	@DBRef
	private CfgParticipant cfgParticipant;

	/** The home participant. */
	private boolean homeParticipant = false;

	/** The name. */
	private String name;

	/**
	 * Necesaria para las apuestas de tipo mas/menos que no llevan el
	 * participante indicado a nivel de RtBet.
	 */
	private Boolean under = Boolean.FALSE;

	/**
	 * Necesaria para las apuestas de tipo mas/menos que no llevan el
	 * participante indicado a nivel de RtBet.
	 */
	private Boolean over = Boolean.FALSE;

	/**
	 * Gets the under.
	 * 
	 * @return the under
	 */
	public Boolean getUnder() {
		if (under != null) {
			return under;
		} else {
			return new Boolean(false);
		}
	}

	/**
	 * Sets the under.
	 * 
	 * @param under
	 *            the new under
	 */
	public void setUnder(Boolean under) {
		this.under = under;
	}

	/**
	 * Checks if is under.
	 * 
	 * @return the boolean
	 */
	public Boolean isUnder() {
		return under;
	}

	/**
	 * Gets the over.
	 * 
	 * @return the over
	 */
	public Boolean getOver() {
		if (over != null) {
			return over;
		} else {
			return new Boolean(false);
		}

	}

	/**
	 * Sets the over.
	 * 
	 * @param over
	 *            the new over
	 */
	public void setOver(Boolean over) {
		this.over = over;
	}

	/**
	 * Checks if is over.
	 * 
	 * @return the boolean
	 */
	public Boolean isOver() {
		return over;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
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
		RtParticipant other = (RtParticipant) obj;
		if (awayParticipant != other.awayParticipant)
			return false;
		if (cfgParticipant == null) {
			if (other.cfgParticipant != null)
				return false;
		} else if (!cfgParticipant.equals(other.cfgParticipant))
			return false;
		if (homeParticipant != other.homeParticipant)
			return false;
		if (!under.equals(other.under))
			return false;
		if (!over.equals(other.over))
			return false;
		return true;
	}

	/**
	 * Gets the cfg participant.
	 * 
	 * @return the cfg participant
	 */
	public CfgParticipant getCfgParticipant() {
		return cfgParticipant;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int result;
		if (this.cfgParticipant != null) {
			result = this.cfgParticipant.hashCode();
		} else {
			result = new HashCodeBuilder(499603411, 980712527).append(this.awayParticipant).append(this.homeParticipant).append(this.under)
					.append(this.over).toHashCode();
		}
		return result;
	}

	/**
	 * Checks if is away participant.
	 * 
	 * @return true, if is away participant
	 */
	public boolean isAwayParticipant() {
		return awayParticipant;
	}

	/**
	 * Checks if is home participant.
	 * 
	 * @return true, if is home participant
	 */
	public boolean isHomeParticipant() {
		return homeParticipant;
	}

	/**
	 * Sets the away participant.
	 * 
	 * @param pAwayParticipant
	 *            the new away participant
	 */
	public void setAwayParticipant(boolean pAwayParticipant) {
		awayParticipant = pAwayParticipant;
	}

	/**
	 * Sets the cfg participant.
	 * 
	 * @param pCfgParticipant
	 *            the new cfg participant
	 */
	public void setCfgParticipant(CfgParticipant pCfgParticipant) {
		cfgParticipant = pCfgParticipant;
	}

	/**
	 * Sets the home participant.
	 * 
	 * @param pHomeParticipant
	 *            the new home participant
	 */
	public void setHomeParticipant(boolean pHomeParticipant) {
		homeParticipant = pHomeParticipant;
	}

	/** {@inheritDoc} */
	@Override
	public int compareTo(RtParticipant rtParticipant) {
		int result = 0;
		if (rtParticipant != null && rtParticipant.getCfgParticipant() != null && rtParticipant.getCfgParticipant().getObjectId() != null
				&& this.getCfgParticipant() != null && this.getCfgParticipant().getObjectId() != null) {
			BigInteger external = rtParticipant.getCfgParticipant().getObjectId();
			BigInteger internal = this.getCfgParticipant().getObjectId();
			result = external.compareTo(internal);
		}
		return result;
	}

}