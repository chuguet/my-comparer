/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.bet.bean.hashkey.AbstractHashKey;
import com.comparadorad.bet.comparer.model.bet.bean.hashkey.HashKeyRtBet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.core.bean.CoreDate;

/**
 * The Class RtBet.
 */
public class RtBet extends AbstractBetBean implements IRtData, IHashKey<RtBet>,
		Cloneable {

	private static final long serialVersionUID = 604563035246472227L;

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RtBet.class);

	/** The attribute. */
	@Field
	@NotNull
	@Valid
	private AbstractRtAttribute attribute;

	/** The bet odd. */
	@Field
	@NotNull
	@Valid
	private RtBetOdd betOdd;

	/** The bet oddhistoric. */
	@Field
	private List<RtBetOdd> betOddhistoric;

	/** The bet type. */
	
	@DBRef
	private CfgBetType betType;

	/** The cfg bookmaker. */
	@DBRef
	@NotNull
	private CfgBookmaker bookmaker;

	/** The hash key. */
	@Field
	@NotEmpty
	private String hashKey;

	/** The market. */
	@DBRef
	private RtMarket market;

	/** The participant. */
	@Field
	@NotNull
	@Valid
	private RtParticipant participant;

	/** The core date. */
	@Field
	private CoreDate startDate;
	
	/** The actualize date. */
	@Field
	private Date actualizeDate;

	/** The web url. */
	@Field
	private RtWebUrl webUrl;

	/** The name. */
	private String name;

	
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
	 * @param pName the new name
	 */
	public void setName(String pName) {
		name = pName;
	}
	
	/**
	 * Instantiates a new rt bet.
	 */
	public RtBet(){
		super();
	}
	
	/**
	 * Instantiates a new rt bet.
	 *
	 * @param bookmaker the bookmaker
	 */
	public RtBet(CfgBookmaker bookmaker){
		super();
		this.bookmaker = bookmaker;
	}
	

	/**
	 * Adds the.
	 * 
	 * @param pRtBetOdd
	 *            the rt bet odd
	 */
	public void add(RtBetOdd pRtBetOdd) {
		if (betOddhistoric == null) {
			betOddhistoric = new ArrayList<RtBetOdd>();
		}
		betOddhistoric.add(pRtBetOdd);
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
		RtBet other = (RtBet) obj;
		if (attribute == null) {
			if (other.attribute != null) {
				return false;
			}
		} else if (!attribute.equals(other.attribute)) {
			return false;
		}
		if (betOdd == null) {
			if (other.betOdd != null) {
				return false;
			}
		} else if (!betOdd.equals(other.betOdd)) {
			return false;
		}
		if (bookmaker == null) {
			if (other.bookmaker != null) {
				return false;
			}
		} else if (!bookmaker.equals(other.bookmaker)) {
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
	public AbstractHashKey<RtBet> getAbstractKey() {
		return new HashKeyRtBet(this);
	}

	/**
	 * Gets the attribute.
	 * 
	 * @return the attribute
	 */
	public AbstractRtAttribute getAttribute() {
		return attribute;
	}

	/**
	 * Gets the bet odd.
	 * 
	 * @return the bet odd
	 */
	public RtBetOdd getBetOdd() {
		return betOdd;
	}

	/**
	 * Gets the bet oddhistoric.
	 * 
	 * @return the bet oddhistoric
	 */
	public List<RtBetOdd> getBetOddhistoric() {
		return betOddhistoric;
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
	 * Gets the cfg bookmaker.
	 * 
	 * @return the cfg bookmaker
	 */
	public CfgBookmaker getBookmaker() {
		return bookmaker;
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

	@Override
	public String getHashKey() {
		hashKey = getAbstractKey().getHashKey();
		return hashKey;
	}

	/**
	 * Gets the hash key rt bet.
	 * 
	 * @return the hash key rt bet
	 */
	public AbstractHashKey<RtBet> getHashKeyRtBet() {
		return getAbstractKey();
	}

	/**
	 * Gets the market.
	 * 
	 * @return the market
	 */
	public RtMarket getMarket() {
		return market;
	}

	/**
	 * Gets the participant.
	 * 
	 * @return the participant
	 */
	public RtParticipant getParticipant() {
		return participant;
	}

	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public CoreDate getStartDate() {
		return startDate;
	}

	/**
	 * Gets the web url.
	 * 
	 * @return the web url
	 */
	public RtWebUrl getWebUrl() {
		return webUrl;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */

	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(499603411, 980712527)
				.appendSuper(super.hashCode()).append(this.attribute)
				.append(this.betOdd).append(this.bookmaker).toHashCode();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "RtBet [attribute=" + attribute + ", betOdd=" + betOdd
				+ ", betOddhistoric=" + betOddhistoric + ", betType=" + betType
				+ ", bookmaker=" + bookmaker + ", hashKey=" + hashKey
				+ ", market=" + market + ", participant=" + participant
				+ ", startDate=" + startDate + ", webUrl=" + webUrl + ", name="
				+ name + "]";
	}

	/**
	 * Sets the attribute.
	 * 
	 * @param pAttribute
	 *            the new attribute
	 */
	public void setAttribute(AbstractRtAttribute pAttribute) {
		attribute = pAttribute;
	}

	/**
	 * Sets the bet odd.
	 * 
	 * @param pBetOdd
	 *            the new bet odd
	 */
	public void setBetOdd(RtBetOdd pBetOdd) {
		betOdd = pBetOdd;
	}

	/**
	 * Sets the bet oddhistoric.
	 * 
	 * @param pBetOddhistoric
	 *            the new bet oddhistoric
	 */
	public void setBetOddhistoric(List<RtBetOdd> pBetOddhistoric) {
		betOddhistoric = pBetOddhistoric;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param pBetType
	 *            the new bet type
	 */
	public void setBetType(CfgBetType pBetType) {
		betType = pBetType;
	}

	/**
	 * Sets the cfg bookmaker.
	 * 
	 * @param bookmaker
	 *            the new bookmaker
	 */
	public void setBookmaker(CfgBookmaker bookmaker) {
		this.bookmaker = bookmaker;
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

	/**
	 * Sets the market.
	 * 
	 * @param pMarket
	 *            the new market
	 */
	public void setMarket(RtMarket pMarket) {
		this.market = pMarket;
	}

	/**
	 * Sets the participant.
	 * 
	 * @param pParticipant
	 *            the new participant
	 */
	public void setParticipant(RtParticipant pParticipant) {
		participant = pParticipant;
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

	/**
	 * Sets the web url.
	 * 
	 * @param webUrl
	 *            the new web url
	 */
	public void setWebUrl(RtWebUrl webUrl) {
		this.webUrl = webUrl;
	}

	/**
	 * Gets the actualize date.
	 *
	 * @return the actualize date
	 */
	public Date getActualizeDate() {
		return actualizeDate;
	}

	/**
	 * Sets the actualize date.
	 *
	 * @param actualizeDate the new actualize date
	 */
	public void setActualizeDate(Date actualizeDate) {
		this.actualizeDate = actualizeDate;
	}

	
}
