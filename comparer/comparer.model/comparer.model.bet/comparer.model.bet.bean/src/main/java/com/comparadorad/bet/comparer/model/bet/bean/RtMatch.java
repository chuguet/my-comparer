/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.bet.bean.validator.CorrectMarket;
import com.comparadorad.bet.comparer.bet.bean.validator.CorrectMarketGroup;
import com.comparadorad.bet.comparer.model.bet.bean.hashkey.AbstractHashKey;
import com.comparadorad.bet.comparer.model.bet.bean.hashkey.HashKeyRtMatch;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetition;
import com.comparadorad.bet.comparer.model.config.bean.CfgCompetitionEvent;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.IActivable;
import com.comparadorad.bet.comparer.model.core.bean.annotation.SetWithAtLeastOneElement;

/**
 * The Class RtMatch.
 * 
 * @author imayoral
 * @version 1.0
 */
@Document
@CompoundIndexes(value={
    @CompoundIndex(name = "ActiveAndDate", def = "{'coreActiveElement.active': 1, 'matchId.startDate.zeroGmtMatchDate': 1}")
})
public class RtMatch extends AbstractI18NBetBean implements IRtData,
		IHashKey<RtMatch>, Cloneable, IActivable {

	private static final long serialVersionUID = 3464599904370040633L;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RtMatch.class);

	/** The core active element. */
	@Field
	@NotNull
	@Valid
	private CoreActiveElement coreActiveElement;
	
	/** The hash key rt match. */
	@Field
	@NotEmpty
	@Indexed(name="hashKey",direction=IndexDirection.ASCENDING,unique=true,dropDups=true)
	private String hashKey = getAbstractKey().getHashKey();
	
	/** The hash keys. */
	@Field
	private Set<String> hashKeys;

	/** The live. */
	@Field
	private boolean live = false;

	/** The live id. */
	@Field
	private String liveId;

	/** The lst rt market. */
	@Field
	@NotNull
	@Valid
	@SetWithAtLeastOneElement
	@CorrectMarket (groups = CorrectMarketGroup.class)
	private Set<RtMarket> markets;

	/**
	 * The match id.
	 */
	@Field
	@NotNull
	@Valid
	private RtMatchId matchId;

	/** The streaming. */
	@Field
	private String streaming;
	
	@Field
	private Date lastLock;
	
	public Date getLastLock() {
		return lastLock;
	}

	public void setLastLock(Date lastLock) {
		this.lastLock = lastLock;
	}


	/**
	 * Adds the market.
	 * 
	 * @param rtMarket
	 *            the rt market
	 * @return true, if successful
	 */
	public boolean add(RtMarket rtMarket) {
		return getRtMarkets().add(rtMarket);
	}


	/**
	 * Adds the hashkey.
	 *
	 * @param hashkey the hashkey
	 * @return true, if successful
	 */
	public boolean add(String hashkey){
		return getHashKeys().add(hashkey);
	}

	/**
	 * Adds the participiant.
	 * 
	 * @param pRtParticipiant
	 *            the rt participiant
	 * @return true, if successful
	 */
	public boolean addParticipiant(RtParticipant pRtParticipiant) {
		return getMatchId().addParticipiant(pRtParticipiant);
	}

	/**
	 * Clone.
	 *
	 * @return the object
	 * {@inheritDoc}
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
	 * @param obj the obj
	 * @return true, if successful
	 * {@inheritDoc}
	 */ 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RtMatch other = (RtMatch) obj;
		if (markets == null) {
			if (other.markets != null)
				return false;
		} else if (!markets.equals(other.markets))
			return false;
		return true;
	}

	/**
	 * Gets the abstract key.
	 * 
	 * @return the abstract key {@inheritDoc}
	 */
	@Override
	public AbstractHashKey<RtMatch> getAbstractKey() {
		return new HashKeyRtMatch(this);
	}

	/**
	 * Gets the competition.
	 * 
	 * @return the competition
	 */
	public CfgCompetition getCompetition() {
		return getMatchId().getCompetition();
	}

	/**
	 * Gets the competition event.
	 * 
	 * @return the competition event
	 */
	public CfgCompetitionEvent getCompetitionEvent() {
		return getMatchId().getCompetitionEvent();
	}

	/**
	 * Gets the hash key.
	 * 
	 * @return the hash key {@inheritDoc}
	 */

	@Override
	public String getHashKey() {
		hashKey = getAbstractKey().getHashKey();
		return hashKey;
	}

	/**
	 * Gets the hash key rt match.
	 * 
	 * @return the hash key rt match
	 */
	public AbstractHashKey<RtMatch> getHashKeyRtMatch() {
		return getAbstractKey();
	}

	/**
	 * Gets the hash keys.
	 *
	 * @return the hash keys
	 */
	public Set<String> getHashKeys() {
		if( hashKeys == null ){
			hashKeys = new HashSet<String>();
		}
		return hashKeys;
	}

	/**
	 * Gets the live id.
	 * 
	 * @return the live id
	 */
	public String getLiveId() {
		return liveId;
	}

	/**
	 * Gets the match id.
	 * 
	 * @return the match id
	 */
	public RtMatchId getMatchId() {
		if (matchId == null) {
			matchId = new RtMatchId();
		}
		return matchId;
	}

	/**
	 * Gets the participiants.
	 * 
	 * @return the participiants
	 */
	public Set<RtParticipant> getParticipiants() {
		return getMatchId().getParticipiants();
	}

	/**
	 * Gets the rt markets.
	 * 
	 * @return the rt markets
	 */
	public Set<RtMarket> getRtMarkets() {
		if (markets == null) {
			markets = new HashSet<RtMarket>();
		}
		return markets;
	}

	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public CoreDate getStartDate() {
		return getMatchId().getStartDate();
	}

	/**
	 * Gets the streaming.
	 * 
	 * @return the streaming
	 */
	public String getStreaming() {
		return streaming;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 * {@inheritDoc}
	 */ 
	@Override
	public int hashCode() {
		return new HashCodeBuilder(499603411, 980712527)
				.appendSuper(super.hashCode()).append(this.markets)
				.toHashCode();
	}

	/**
	 * Checks if is active.
	 *
	 * @param pDate the date
	 * @return true, if is active
	 */
	public boolean isActive(Date pDate) {
		boolean result = true;
		if (coreActiveElement != null) {
			result = coreActiveElement.isActive(pDate);
		}
		return result;
	}

	/**
	 * Checks if is live.
	 * 
	 * @return true, if is live
	 */
	public boolean isLive() {
		return live;
	}

	/**
	 * Removes the.
	 * 
	 * @param rtMarket
	 *            the rt market
	 * @return true, if successful
	 */
	public boolean remove(RtMarket rtMarket) {
		return getRtMarkets().remove(rtMarket);
	}

	/**
	 * Retrieve hash key.
	 *
	 * @return the string
	 */
	public String retrieveHashKey() {
		return this.hashKey;
	}

	/**
	 * Sets the competition.
	 * 
	 * @param pCompetition
	 *            the new competition
	 */
	public void setCompetition(CfgCompetition pCompetition) {
		getMatchId().setCompetition(pCompetition);
	}

	/**
	 * Sets the competition event.
	 * 
	 * @param pCompetitionEvent
	 *            the new competition event
	 */
	public void setCompetitionEvent(CfgCompetitionEvent pCompetitionEvent) {
		getMatchId().setCompetitionEvent(pCompetitionEvent);
	}

	/**
	 * Sets the core active element.
	 *
	 * @param pCoreActiveElement the new core active element
	 * {@inheritDoc}
	 */ 
	@Override
	public void setCoreActiveElement(CoreActiveElement pCoreActiveElement) {
		coreActiveElement = pCoreActiveElement;
	}
	
	

	/**
	 * Gets the core active element.
	 *
	 * @return the core active element
	 */
	public CoreActiveElement getCoreActiveElement() {
		return coreActiveElement;
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

	/**
	 * Sets the hash keys.
	 *
	 * @param hashKeys the new hash keys
	 */
	public void setHashKeys(Set<String> hashKeys) {
		this.hashKeys = hashKeys;
	}
	
	/**
	 * Contains.
	 *
	 * @param hashkey the hashkey
	 * @return true, if successful
	 */
	public boolean contains(String hashkey){
		return getHashKeys().contains(hashkey);
	}

	/**
	 * Sets the live.
	 * 
	 * @param pLive
	 *            the new live
	 */
	public void setLive(boolean pLive) {
		live = pLive;
	}

	/**
	 * Sets the live id.
	 * 
	 * @param pLiveId
	 *            the new live id
	 */
	public void setLiveId(String pLiveId) {
		liveId = pLiveId;
	}

	/**
	 * Sets the match id.
	 * 
	 * @param pMatchId
	 *            the new match id
	 */
	public void setMatchId(RtMatchId pMatchId) {
		matchId = pMatchId;
	}

	/**
	 * Sets the participiants.
	 * 
	 * @param pParticipants
	 *            the new participiants
	 */
	public void setParticipiants(Set<RtParticipant> pParticipants) {
		getMatchId().setParticipiants(pParticipants);
	}

	/**
	 * Sets the rt markets.
	 * 
	 * @param pRtMarkets
	 *            the new rt markets
	 */
	public void setRtMarkets(Set<RtMarket> pRtMarkets) {
		markets = pRtMarkets;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param pCoreDate
	 *            the new start date
	 */
	public void setStartDate(CoreDate pCoreDate) {
		getMatchId().setStartDate(pCoreDate);
	}
	
	/**
	 * Sets the streaming.
	 * 
	 * @param pStreaming
	 *            the new streaming
	 */
	public void setStreaming(String pStreaming) {
		streaming = pStreaming;
	}


}