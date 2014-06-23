/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.bet.bean.hashkey.AbstractHashKey;
import com.comparadorad.bet.comparer.model.bet.bean.hashkey.HashKeyRtMarket;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetTypeEvent;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.annotation.SetWithAtLeastOneElement;

/**
 * The Class RtBetMatch.
 * 
 */
public class RtMarket extends AbstractBetBean implements IRtData,
		IHashKey<RtMarket>, Cloneable {

	private static final long serialVersionUID = 4231252257023898865L;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RtMarket.class);

	/** The set rt bet. */
	@Field
	@SetWithAtLeastOneElement
	@Valid
	private Set<RtBet> bets;

	/** The cfg bet type. */
	@DBRef
	@NotNull
	private CfgBetType betType;

	/** The rt event. */

	@Field
	@NotNull
	@Valid
	private RtBetTypeEvent betTypeEvent;

	/** The hash key. */
	@Field
	@NotEmpty
	private String hashKey;

	/**
	 * The m match.
	 */
//	@DBRef
//	@NotNull
//	private RtMatch match;

	/** The core date. */
	@Field
	private CoreDate startDate;

	/** The web url. */
	@Field
	private Set<RtWebUrl> webUrl;
	
	@Field
	private Boolean isValid = Boolean.TRUE;

	/**
	 * Gets the web url.
	 * 
	 * @return the web url
	 */
	public Set<RtWebUrl> getWebUrl() {
		return webUrl;
	}

	/**
	 * Sets the web url.
	 * 
	 * @param pWebUrl
	 *            the new web url
	 */
	public void setWebUrl(Set<RtWebUrl> pWebUrl) {
		webUrl = pWebUrl;
	}

	/**
	 * Adds the.
	 * 
	 * @param rtBet
	 *            the rt bet
	 * @return true, if successful
	 */
	public boolean add(RtBet rtBet) {
		return getBets().add(rtBet);
	}

	/**
	 * Clone.
	 * 
	 * @return the object {@inheritDoc}
	 */

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			LOG.error(e.getMessage(), e);
		}
		return null;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RtMarket other = (RtMarket) obj;
		if (betType == null) {
			if (other.betType != null) {
				return false;
			}
		} else if (!betType.equals(other.betType)) {
			return false;
		}
		if (bets == null) {
			if (other.bets != null) {
				return false;
			}
		} else if (!bets.equals(other.bets)) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the abstract key.
	 * 
	 * @return the abstract key {@inheritDoc}
	 */
	@Override
	public AbstractHashKey<RtMarket> getAbstractKey() {
		return new HashKeyRtMarket(this);
	}

	/**
	 * Gets the sets the rt bet.
	 * 
	 * @return the sets the rt bet
	 */
	public Set<RtBet> getBets() {
		if (bets == null) {
			bets = new HashSet<RtBet>();
		}
		return bets;
	}

	/**
	 * Gets the bets by bookmaker.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @return the bets by bookmaker
	 */
	public Set<RtBet> getBetsByBookmaker(CfgBookmaker bookmaker) {
		Set<RtBet> result = new HashSet<RtBet>();
		for (RtBet rtBet : getBets()) {
			if (rtBet.getBookmaker().equals(bookmaker)) {
				result.add(rtBet);
			}
		}
		return result;
	}

	/**
	 * Gets the cfg bet type.
	 * 
	 * @return the cfg bet type
	 */
	public CfgBetType getBetType() {
		return betType;
	}

	/**
	 * Gets the rt event.
	 * 
	 * @return the rt event
	 */
	public RtBetTypeEvent getBetTypeEvent() {
		if (betTypeEvent == null) {
			betTypeEvent = new RtBetTypeEvent();
			betTypeEvent
					.setNameId(CfgBetTypeEvent.CfgBetTypeEventId.PARTIDO_COMPLETO
							.nameId());
		}
		return betTypeEvent;
	}

	/**
	 * Gets the bookmakers.
	 * 
	 * @return the bookmakers
	 */
	public Set<CfgBookmaker> getBookmakers() {
		Set<CfgBookmaker> result = new HashSet<CfgBookmaker>();
		for (RtBet rtBet : getBets()) {
			result.add(rtBet.getBookmaker());
		}
		return result;
	}

	/**
	 * Gets the core date.
	 * 
	 * @return the core date
	 */
	public CoreDate getCoreDate() {
		return startDate;
	}

	/**
	 * Gets the hash key.
	 * 
	 * @return the hash key {@inheritDoc}
	 */

	public String getHashKeyDB(){
		return hashKey;
	}
	
	@Override
	public String getHashKey() {
		hashKey = getAbstractKey().getHashKey();
		return hashKey;
	}

	/**
	 * Gets the hash key rt market.
	 * 
	 * @return the hash key rt market
	 */
	public AbstractHashKey<RtMarket> getHashKeyRtMarket() {
		return getAbstractKey();
	}

//	/**
//	 * Gets the rt match.
//	 * 
//	 * @return the rt match
//	 */
//	public RtMatch getMatch() {
//		return match;
//	}

	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public CoreDate getStartDate() {
		return startDate;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */

	@Override
	public int hashCode() {
		return new HashCodeBuilder(499603411, 980712527)
				.appendSuper(super.hashCode()).append(this.betType)
				.append(this.bets).toHashCode();
	}

	/**
	 * Removes the.
	 * 
	 * @param rtBet
	 *            the rt bet
	 * @return true, if successful
	 */
	public boolean remove(RtBet rtBet) {
		return getBets().remove(rtBet);
	}

	/**
	 * Sets the bets.
	 * 
	 * @param pBets
	 *            the new bets
	 */
	public void setBets(Set<RtBet> pBets) {
		bets = pBets;
	}

	/**
	 * Sets the cfg bet type.
	 * 
	 * @param cfgBetType
	 *            the new bet type
	 */
	public void setBetType(CfgBetType cfgBetType) {
		this.betType = cfgBetType;
	}

	/**
	 * Sets the rt event.
	 * 
	 * @param betTypeEvent
	 *            the new bet type event
	 */
	public void setBetTypeEvent(RtBetTypeEvent betTypeEvent) {
		this.betTypeEvent = betTypeEvent;
	}

	/**
	 * Sets the core date.
	 * 
	 * @param pStartDate
	 *            the new core date
	 */
	public void setCoreDate(CoreDate pStartDate) {
		this.startDate = pStartDate;
	}

	/**
	 * Sets the hash key.
	 * 
	 * @param pHashKey
	 *            the new hash key
	 */
	public void setHashKey(String pHashKey) {
		hashKey = pHashKey;
	}

//	/**
//	 * Sets the rt match.
//	 * 
//	 * @param match
//	 *            the new match
//	 */
//	public void setMatch(RtMatch match) {
//		this.match = match;
//	}

	/**
	 * Sets the sets the rt bet.
	 * 
	 * @param bets
	 *            the new rt bets
	 */
	public void setRtBets(Set<RtBet> bets) {
		this.bets = bets;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param pStartDate
	 *            the new start date
	 */
	public void setStartDate(CoreDate pStartDate) {
		startDate = pStartDate;
	}

	@Override
	public String toString() {
		return "RtMarket [bets=" + bets + ", betType=" + betType
				+ ", betTypeEvent=" + betTypeEvent + ", hashKey=" + hashKey
				+ ", startDate=" + startDate + ", webUrl=" + webUrl + "]";
	}

	public Boolean isValid() {
		return isValid;
	}

	public void setValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
	

}