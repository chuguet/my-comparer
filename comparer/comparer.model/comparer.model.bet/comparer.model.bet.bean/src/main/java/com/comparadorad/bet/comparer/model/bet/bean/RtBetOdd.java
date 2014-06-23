/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;

/**
 * The Class MarketBetOdd.
 */
@SuppressWarnings("serial")
public class RtBetOdd extends AbstractBetBean implements Cloneable {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RtBetOdd.class);

	/** The american odds. */
	@Field
	private String americanOdds;

	/** The Rt bet. */
	@Field
	private RtBet bet;

	/** The fra odds. */
	@Field
	private String fraOdds;

	/** The core date. */
	@Field
	private CoreDate modificationDate;

	/** The odds. */
	@Field
	@NotEmpty
	private String odds;

	/**
	 * Instantiates a new rt bet odd.
	 */
	public RtBetOdd() {
		super();
	}

	/**
	 * Instantiates a new rt bet odd.
	 * 
	 * @param odds
	 *            the odds
	 */
	public RtBetOdd(String odds) {
		super();
		this.odds = odds;
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
		RtBetOdd other = (RtBetOdd) obj;
		if (americanOdds == null) {
			if (other.americanOdds != null) {
				return false;
			}
		} else if (!americanOdds.equals(other.americanOdds)) {
			return false;
		}
		if (fraOdds == null) {
			if (other.fraOdds != null) {
				return false;
			}
		} else if (!fraOdds.equals(other.fraOdds)) {
			return false;
		}
		if (odds == null) {
			if (other.odds != null) {
				return false;
			}
		} else if (!odds.equals(other.odds)) {
			return false;
		}
		return true;
	}

	/**
	 * Gets the american odds.
	 * 
	 * @return the american odds
	 */
	public String getAmericanOdds() {
		return americanOdds;
	}

	/**
	 * Gets the rt bet.
	 * 
	 * @return the rt bet
	 */
	public RtBet getBet() {
		return bet;
	}

	/**
	 * Gets the fra odds.
	 * 
	 * @return the fra odds
	 */
	public String getFraOdds() {
		return fraOdds;
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
	 * Gets the odds.
	 * 
	 * @return the odds
	 */
	public String getOdds() {
		return odds;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */

	@Override
	public int hashCode() {
		return new HashCodeBuilder(499603411, 980712527)
				.appendSuper(super.hashCode()).append(this.americanOdds)
				.append(this.fraOdds).append(this.odds).toHashCode();
	}

	/**
	 * Sets the american odds.
	 * 
	 * @param pAmericanOdds
	 *            the new american odds
	 */
	public void setAmericanOdds(String pAmericanOdds) {
		americanOdds = pAmericanOdds;
	}

	/**
	 * Sets the rt bet.
	 * 
	 * @param pRtBet
	 *            the new rt bet
	 */
	public void setBet(RtBet pRtBet) {
		bet = pRtBet;
	}

	/**
	 * Sets the fra odds.
	 * 
	 * @param pFraOdds
	 *            the new fra odds
	 */
	public void setFraOdds(String pFraOdds) {
		fraOdds = pFraOdds;
	}

	/**
	 * Sets the modification date.
	 * 
	 * @param pModificationDate
	 *            the new modification date
	 */
	public void setModificationDate(CoreDate pModificationDate) {
		modificationDate = pModificationDate;
	}

	/**
	 * Sets the odds.
	 * 
	 * @param pOdds
	 *            the new odds
	 */
	public void setOdds(String pOdds) {
		odds = pOdds;
	}

	/**
	 * To string.
	 * 
	 * @return the string {@inheritDoc}
	 */

	@Override
	public String toString() {
		return String.format(
				"RtBetOdd [americanOdds=%s, bet=%s, fraOdds=%s, odds=%s]",
				americanOdds, bet, fraOdds, odds);
	}

}
