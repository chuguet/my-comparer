/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean.bmconf;

import java.io.Serializable;

/**
 * The Class ResetDataInResolver.
 */
public class ResetDataInResolver implements Serializable {

	/** The reset market. */
	private boolean resetMarket;

	/** The resetMatch. */
	private boolean resetMatch;

	/** The reset participant. */
	private boolean resetParticipant;

	/** The reset region. */
	private boolean resetRegion;

	/** The resetSport. */
	private boolean resetSport;

	/** The reset tournament. */
	private boolean resetTournament;

	/** The reset tournament event. */
	private boolean resetTournamentEvent;

	/**
	 * Instantiates a new reset data in resolver.
	 */
	public ResetDataInResolver() {
		super();
	}

	/**
	 * Instantiates a new reset data in resolver.
	 * 
	 * @param pResetMarket
	 *            the reset market
	 * @param pResetMatch
	 *            the reset match
	 * @param pResetParticipant
	 *            the reset participant
	 * @param pResetRegion
	 *            the reset region
	 * @param pResetSport
	 *            the reset sport
	 * @param pResetTournament
	 *            the reset tournament
	 * @param pResetTournamentEvent
	 *            the reset tournament event
	 */
	public ResetDataInResolver(boolean pResetMarket, boolean pResetMatch,
			boolean pResetParticipant, boolean pResetRegion,
			boolean pResetSport, boolean pResetTournament,
			boolean pResetTournamentEvent) {
		super();
		resetMarket = pResetMarket;
		resetMatch = pResetMatch;
		resetParticipant = pResetParticipant;
		resetRegion = pResetRegion;
		resetSport = pResetSport;
		resetTournament = pResetTournament;
		resetTournamentEvent = pResetTournamentEvent;
	}

	/**
	 * Checks if is reset market.
	 * 
	 * @return true, if is reset market
	 */
	public boolean isResetMarket() {
		return resetMarket;
	}

	/**
	 * Checks if is reset match.
	 * 
	 * @return true, if is reset match
	 */
	public boolean isResetMatch() {
		return resetMatch;
	}

	/**
	 * Checks if is reset participant.
	 * 
	 * @return true, if is reset participant
	 */
	public boolean isResetParticipant() {
		return resetParticipant;
	}

	/**
	 * Checks if is reset region.
	 * 
	 * @return true, if is reset region
	 */
	public boolean isResetRegion() {
		return resetRegion;
	}

	/**
	 * Checks if is reset sport.
	 * 
	 * @return true, if is reset sport
	 */
	public boolean isResetSport() {
		return resetSport;
	}

	/**
	 * Checks if is reset tournament.
	 * 
	 * @return true, if is reset tournament
	 */
	public boolean isResetTournament() {
		return resetTournament;
	}

	/**
	 * Checks if is reset tournament event.
	 * 
	 * @return true, if is reset tournament event
	 */
	public boolean isResetTournamentEvent() {
		return resetTournamentEvent;
	}

	/**
	 * Sets the reset data.
	 * 
	 * @param pResetMarket
	 *            the reset market
	 * @param pResetMatch
	 *            the reset match
	 * @param pResetParticipant
	 *            the reset participant
	 * @param pResetRegion
	 *            the reset region
	 * @param pResetSport
	 *            the reset sport
	 * @param pResetTournament
	 *            the reset tournament
	 * @param pResetTournamentEvent
	 *            the reset tournament event
	 */
	public final void setResetData(boolean pResetMarket, boolean pResetMatch,
			boolean pResetParticipant, boolean pResetRegion,
			boolean pResetSport, boolean pResetTournament,
			boolean pResetTournamentEvent) {
		resetMarket = pResetMarket;
		resetMatch = pResetMatch;
		resetParticipant = pResetParticipant;
		resetRegion = pResetRegion;
		resetSport = pResetSport;
		resetTournament = pResetTournament;
		resetTournamentEvent = pResetTournamentEvent;
	}

	/**
	 * Sets the reset market.
	 * 
	 * @param pResetMarket
	 *            the new reset market
	 */
	public void setResetMarket(boolean pResetMarket) {
		resetMarket = pResetMarket;
	}

	/**
	 * Sets the reset match.
	 * 
	 * @param resetMatch
	 *            the new reset match
	 */
	public void setResetMatch(boolean resetMatch) {
		this.resetMatch = resetMatch;
	}

	/**
	 * Sets the reset participant.
	 * 
	 * @param pResetParticipant
	 *            the new reset participant
	 */
	public void setResetParticipant(boolean pResetParticipant) {
		resetParticipant = pResetParticipant;
	}

	/**
	 * Sets the reset region.
	 * 
	 * @param pResetRegion
	 *            the new reset region
	 */
	public void setResetRegion(boolean pResetRegion) {
		resetRegion = pResetRegion;
	}

	/**
	 * Sets the reset sport.
	 * 
	 * @param resetSport
	 *            the new reset sport
	 */
	public void setResetSport(boolean resetSport) {
		this.resetSport = resetSport;
	}

	/**
	 * Sets the reset tournament.
	 * 
	 * @param pResetTournament
	 *            the new reset tournament
	 */
	public void setResetTournament(boolean pResetTournament) {
		resetTournament = pResetTournament;
	}

	/**
	 * Sets the reset tournament event.
	 * 
	 * @param pResetTournamentEvent
	 *            the new reset tournament event
	 */
	public void setResetTournamentEvent(boolean pResetTournamentEvent) {
		resetTournamentEvent = pResetTournamentEvent;
	}
}