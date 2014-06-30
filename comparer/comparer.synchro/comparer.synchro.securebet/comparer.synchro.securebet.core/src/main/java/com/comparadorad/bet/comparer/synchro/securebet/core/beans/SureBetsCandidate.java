/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.core.beans;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;

/**
 * The Class SecureBetResultBean.
 */
public class SureBetsCandidate implements ISureBet {

	private static final long serialVersionUID = 8141647997009377420L;

	/** The rt match. */
	private RtMatch rtMatch;

	/**
	 * Instantiates a new secure bet result bean.
	 */
	public SureBetsCandidate() {
		super();
	}

	/**
	 * Instantiates a new secure bet result bean.
	 * 
	 * @param match
	 *            the match
	 */
	public SureBetsCandidate(RtMatch match) {
		this.rtMatch = match;
	}

	/**
	 * Gets the rt match.
	 * 
	 * @return the rt match
	 */
	public RtMatch getRtMatch() {
		return rtMatch;
	}

	/**
	 * Sets the rt match.
	 * 
	 * @param rtMatch
	 *            the new rt match
	 */
	public void setRtMatch(RtMatch rtMatch) {
		this.rtMatch = rtMatch;
	}

}
