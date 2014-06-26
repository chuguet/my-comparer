/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.filter.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Helper Class with information to manage hashkeys list and information to
 * access matchs, markets and bets to managed tasks: actualize timestamps, and
 * more.
 * 
 * @author farce
 * 
 */
public class RtMatchFilterIdentificator {

	/** The stack. */
	private final Stack<String> hashkeyXmlMatchs;

	/** The rt match id. */
	private String hashkeyRtMatch;

	/** The list hash markets. */
	private List<String> hashkeyRtMarkets;

	/**
	 * Instantiates a new rt match filter identificator.
	 * 
	 * @param hashkeyXmlMatchs
	 *            the hashkey xml matchs
	 * @param hashkeyRtMatch
	 *            the hashkey rt match
	 * @param hashkeyRtMarkets
	 *            the hashkey rt markets
	 */
	public RtMatchFilterIdentificator(Stack<String> hashkeyXmlMatchs,
			String hashkeyRtMatch, List<String> hashkeyRtMarkets) {
		super();
		this.hashkeyXmlMatchs = hashkeyXmlMatchs;
		this.hashkeyRtMatch = hashkeyRtMatch;
		this.hashkeyRtMarkets = hashkeyRtMarkets;
	}

	/**
	 * Instantiates a new rt match filter identificator.
	 * 
	 * @param hashkeyXmlMatchs
	 *            the hashkey xml matchs
	 */
	public RtMatchFilterIdentificator(Stack<String> hashkeyXmlMatchs) {
		super();
		this.hashkeyXmlMatchs = hashkeyXmlMatchs;
	}

	/**
	 * Instantiates a new rt match filter identificator.
	 * 
	 * @param hashkeyXmlMatch
	 *            the hashkey xml match
	 */
	public RtMatchFilterIdentificator(String hashkeyXmlMatch) {
		this.hashkeyXmlMatchs = new Stack<String>();
		this.hashkeyXmlMatchs.add(hashkeyXmlMatch);
	}

	/**
	 * Gets the hashkey rt match.
	 * 
	 * @return the hashkey rt match
	 */
	public String getHashkeyRtMatch() {
		return hashkeyRtMatch;
	}

	/**
	 * Sets the hashkey rt match.
	 * 
	 * @param hashkeyRtMatch
	 *            the new hashkey rt match
	 */
	public void setHashkeyRtMatch(String hashkeyRtMatch) {
		this.hashkeyRtMatch = hashkeyRtMatch;
	}

	/**
	 * Gets the hashkey rt markets.
	 * 
	 * @return the hashkey rt markets
	 */
	public List<String> getHashkeyRtMarkets() {
		if (this.hashkeyRtMarkets == null) {
			this.hashkeyRtMarkets = new ArrayList<String>();
		}
		return hashkeyRtMarkets;
	}

	/**
	 * Sets the hashkey rt markets.
	 * 
	 * @param hashkeyRtMarkets
	 *            the new hashkey rt markets
	 */
	public void setHashkeyRtMarkets(List<String> hashkeyRtMarkets) {
		this.hashkeyRtMarkets = hashkeyRtMarkets;
	}

	/**
	 * Gets the hashkey xml matchs.
	 * 
	 * @return the hashkey xml matchs
	 */
	public Stack<String> getHashkeyXmlMatchs() {
		return hashkeyXmlMatchs;
	}

	public Boolean add(String hashkeyXmlMatch) {
		return hashkeyXmlMatchs.add(hashkeyXmlMatch);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((hashkeyRtMarkets == null) ? 0 : hashkeyRtMarkets.hashCode());
		result = prime * result
				+ ((hashkeyRtMatch == null) ? 0 : hashkeyRtMatch.hashCode());
		result = prime
				* result
				+ ((hashkeyXmlMatchs == null) ? 0 : hashkeyXmlMatchs.hashCode());
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
		RtMatchFilterIdentificator other = (RtMatchFilterIdentificator) obj;
		if (hashkeyRtMarkets == null) {
			if (other.hashkeyRtMarkets != null)
				return false;
		} else if (!hashkeyRtMarkets.equals(other.hashkeyRtMarkets))
			return false;
		if (hashkeyRtMatch == null) {
			if (other.hashkeyRtMatch != null)
				return false;
		} else if (!hashkeyRtMatch.equals(other.hashkeyRtMatch))
			return false;
		if (hashkeyXmlMatchs == null) {
			if (other.hashkeyXmlMatchs != null)
				return false;
		} else if (!hashkeyXmlMatchs.equals(other.hashkeyXmlMatchs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RtMatchFilterIdentificator [hashkeyXmlMatchs="
				+ hashkeyXmlMatchs + ", hashkeyRtMatch=" + hashkeyRtMatch
				+ ", hashkeyRtMarkets=" + hashkeyRtMarkets + "]";
	}
	
	

}
