/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.core.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.comparadorad.bet.comparer.communication.core.bean.AbstractQueue;

/**
 * The Class UpdaterBetsTO.
 */
public class UpdaterBetsTO extends AbstractQueue implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7242186959140367220L;

	/** The hash keys matchs. */
	private final String hashKeysMatch;

	/** The id bookmaker. */
	private final BigInteger bookmakerId;

	/** The markets hash keys. */
	private final List<String> marketsHashKeys;

	/**
	 * Instantiates a new updater bets to.
	 * 
	 * @param hashKeysMatch
	 *            the hash keys match
	 * @param bookmakerId
	 *            the bookmaker id
	 * @param marketsHashKeys
	 *            the markets hash keys
	 */
	public UpdaterBetsTO(String hashKeysMatch, BigInteger bookmakerId,
			List<String> marketsHashKeys) {
		super();
		this.hashKeysMatch = hashKeysMatch;
		this.bookmakerId = bookmakerId;
		this.marketsHashKeys = marketsHashKeys;
	}

	/**
	 * Gets the hash keys match.
	 * 
	 * @return the hash keys match
	 */
	public String getHashKeysMatch() {
		return hashKeysMatch;
	}

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id
	 */
	public BigInteger getBookmakerId() {
		return bookmakerId;
	}

	/**
	 * Gets the markets hash keys.
	 * 
	 * @return the markets hash keys
	 */
	public List<String> getMarketsHashKeys() {
		return marketsHashKeys;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookmakerId == null) ? 0 : bookmakerId.hashCode());
		result = prime * result
				+ ((hashKeysMatch == null) ? 0 : hashKeysMatch.hashCode());
		result = prime * result
				+ ((marketsHashKeys == null) ? 0 : marketsHashKeys.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdaterBetsTO other = (UpdaterBetsTO) obj;
		if (bookmakerId == null) {
			if (other.bookmakerId != null)
				return false;
		} else if (!bookmakerId.equals(other.bookmakerId))
			return false;
		if (hashKeysMatch == null) {
			if (other.hashKeysMatch != null)
				return false;
		} else if (!hashKeysMatch.equals(other.hashKeysMatch))
			return false;
		if (marketsHashKeys == null) {
			if (other.marketsHashKeys != null)
				return false;
		} else if (!marketsHashKeys.equals(other.marketsHashKeys))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UpdaterBetsTO [hashKeysMatch=" + hashKeysMatch
				+ ", bookmakerId=" + bookmakerId + ", marketsHashKeys="
				+ marketsHashKeys + "]";
	}
	
	

}
