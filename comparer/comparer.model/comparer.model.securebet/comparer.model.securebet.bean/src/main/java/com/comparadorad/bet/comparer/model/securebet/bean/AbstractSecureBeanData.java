/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.bean;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.bet.bean.RtBet;
import com.comparadorad.bet.comparer.model.bet.bean.RtBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.bean.AbstractIdActivable;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.annotation.CorrectCoreDate;
import com.comparadorad.bet.comparer.model.securebet.validator.MatchExistInBD;

/**
 * The Class AbstractSecureBeanData.
 */
@SuppressWarnings("serial")
public class AbstractSecureBeanData extends AbstractIdActivable implements
		ISecureBeanData {

	/** The benefit. */
	@NotNull
	@Field
	private SecureBeanBenefit benefit;

	/** The bets. */
	@Field
	private Set<RtBet> bets;

	/** The bet type. */
	@DBRef
	@NotNull
	private CfgBetType betType;

	/** The bet type event. */
	@Field
	@NotNull
	private RtBetTypeEvent betTypeEvent;

	/** The create date. */
	@Field
	@CorrectCoreDate
	private CoreDate createDate;

	/** The match. */
	@Field
	@NotNull
	@MatchExistInBD
	private InfoMatch infoMatch;


	/** The modification date. */
	@Field
	private CoreDate modificationDate;

	/** The historic. */
	@Field
	private HistoricInfo historic;

	/**
	 * Gets the historic.
	 *
	 * @return the historic
	 */
	public HistoricInfo getHistoric() {
		return historic;
	}

	/**
	 * Sets the historic.
	 *
	 * @param historic the new historic
	 */
	public void setHistoric(HistoricInfo historic) {
		this.historic = historic;
	}
	/**
	 * Gets the benefit.
	 * 
	 * @return the benefit
	 */
	public SecureBeanBenefit getBenefit() {
		return benefit;
	}

	/**
	 * Gets the bets.
	 * 
	 * @return the bets
	 */
	public Set<RtBet> getBets() {
		if (bets == null) {
			bets = new HashSet<RtBet>();
		}
		return bets;
	}

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public CfgBetType getBetType() {
		return betType;
	}

	/**
	 * Gets the bet type event.
	 * 
	 * @return the bet type event
	 */
	public RtBetTypeEvent getBetTypeEvent() {
		return betTypeEvent;
	}

	/**
	 * Gets the creates the date.
	 * 
	 * @return the creates the date
	 */
	public CoreDate getCreateDate() {
		return createDate;
	}

	/**
	 * Gets the match.
	 * 
	 * @return the match
	 */
	public InfoMatch getInfoMatch() {
		return infoMatch;
	}

	/**
	 * Gets the modification date.
	 * 
	 * @return the modification date
	 */
	public CoreDate getModificationDate() {
		return modificationDate;
	}

	/**
	 * Sets the benefit.
	 * 
	 * @param benefit
	 *            the new benefit
	 */
	public void setBenefit(SecureBeanBenefit benefit) {
		this.benefit = benefit;
	}

	/**
	 * Sets the bets.
	 * 
	 * @param bets
	 *            the new bets
	 */
	public void setBets(Set<RtBet> bets) {
		this.bets = bets;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param betType
	 *            the new bet type
	 */
	public void setBetType(CfgBetType betType) {
		this.betType = betType;
	}

	/**
	 * Sets the bet type event.
	 * 
	 * @param betTypeEvent
	 *            the new bet type event
	 */
	public void setBetTypeEvent(RtBetTypeEvent betTypeEvent) {
		this.betTypeEvent = betTypeEvent;
	}

	/**
	 * Sets the creates the date.
	 * 
	 * @param createDate
	 *            the new creates the date
	 */
	public void setCreateDate(CoreDate createDate) {
		this.createDate = createDate;
	}

	/**
	 * Sets the match.
	 * 
	 * @param pInfoMatch
	 *            the new info match
	 */
	public void setInfoMatch(InfoMatch pInfoMatch) {
		this.infoMatch = pInfoMatch;
	}

	/**
	 * Sets the modification date.
	 * 
	 * @param modificationDate
	 *            the new modification date
	 */
	public void setModificationDate(CoreDate modificationDate) {
		this.modificationDate = modificationDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((benefit == null) ? 0 : benefit.hashCode());
		result = prime * result + ((betType == null) ? 0 : betType.hashCode());
		result = prime * result
				+ ((betTypeEvent == null) ? 0 : betTypeEvent.hashCode());
		result = prime * result + ((bets == null) ? 0 : bets.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((infoMatch == null) ? 0 : infoMatch.hashCode());
		result = prime
				* result
				+ ((modificationDate == null) ? 0 : modificationDate.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.model.core.bean.AbstractId#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSecureBeanData other = (AbstractSecureBeanData) obj;
		if (benefit == null) {
			if (other.benefit != null)
				return false;
		} else if (!benefit.equals(other.benefit))
			return false;
		if (betType == null) {
			if (other.betType != null)
				return false;
		} else if (!betType.equals(other.betType))
			return false;
		if (betTypeEvent == null) {
			if (other.betTypeEvent != null)
				return false;
		} else if (!betTypeEvent.equals(other.betTypeEvent))
			return false;
		if (bets == null) {
			if (other.bets != null)
				return false;
		} else if (!bets.equals(other.bets))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (infoMatch == null) {
			if (other.infoMatch != null)
				return false;
		} else if (!infoMatch.equals(other.infoMatch))
			return false;
		if (modificationDate == null) {
			if (other.modificationDate != null)
				return false;
		} else if (!modificationDate.equals(other.modificationDate))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AbstractSecureBeanData [benefit=" + benefit + ", bets=" + bets
				+ ", betType=" + betType + ", betTypeEvent=" + betTypeEvent
				+ ", createDate=" + createDate + ", infoMatch=" + infoMatch
				+ ", modificationDate=" + modificationDate + "]";
	}

}
