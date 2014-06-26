/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker;

import java.io.Serializable;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

/**
 * The Class RtMatchWithHash.
 */
@SuppressWarnings("serial")
public class RtMatchWithHash implements Serializable {

	/** The match. */
	private final RtMatch match;
	
	/** The hash. */
	private final String hash;

	/**
	 * Instantiates a new rt match with hash.
	 *
	 * @param hash the hash
	 * @param match the match
	 */
	public RtMatchWithHash(RtMatch match, String hash) {
		super();
		this.hash = hash;
		this.match = match;
	}

	/**
	 * Gets the hash.
	 *
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * Gets the match.
	 *
	 * @return the match
	 */
	public RtMatch getMatch() {
		return match;
	}

	/** {@inheritDoc} */ 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + ((match == null) ? 0 : match.hashCode());
		return result;
	}

	/** {@inheritDoc} */ 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RtMatchWithHash other = (RtMatchWithHash) obj;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (match == null) {
			if (other.match != null)
				return false;
		} else if (!match.equals(other.match))
			return false;
		return true;
	}

}
