/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

/**
 * The Class XmlMatchParticipant.
 */
@SuppressWarnings("serial")
public class XmlMatchParticipant extends AbstractXmlData<XmlTournament> {

	/** The away participant. */
	private boolean awayParticipant = false;

	/** The home participant. */
	private boolean homeParticipant = false;
	
	private XmlTournament tournament = new XmlTournament();

	/** The role. (1 = home, 2 = away) */
	private String role;
	
	

	public XmlMatchParticipant() {

	}

	/**
	 * Instantiates a new xml match participant.
	 * 
	 * @param pName
	 *            the name
	 */
	public XmlMatchParticipant(final String pName, final XmlTournament pTournament) {
		super(pName);
		tournament = pTournament;
	}

	/**
	 * Instantiates a new xml match participant.
	 * 
	 * @param pName
	 *            the name
	 * @param pHomeParticipant
	 *            the home participant
	 * @param pAwayParticipant
	 *            the away participant
	 */
	public XmlMatchParticipant(String pName, boolean pHomeParticipant,
			boolean pAwayParticipant, final XmlTournament pTournament) {
		super(pName);
		homeParticipant = pHomeParticipant;
		awayParticipant = pAwayParticipant;
		tournament = pTournament;
	}

	/**
	 * Instantiates a new xml match participant.
	 * 
	 * @param pName
	 *            the name
	 * @param pRole
	 *            the internal id
	 */
	public XmlMatchParticipant(final String pName, final String pRole, final XmlTournament ptTournament) {
		super(pName);
		this.role = pRole;
		tournament = ptTournament;
	}

	/**
	 * Instantiates a new xml match participant.
	 * 
	 * @param pName
	 *            the name
	 * @param pRole
	 *            the role
	 * @param pHomeParticipant
	 *            the home participant
	 * @param pAwayParticipant
	 *            the away participant
	 */
	public XmlMatchParticipant(String pName, final String pRole,
			boolean pHomeParticipant, boolean pAwayParticipant, final XmlTournament pTournament) {
		super(pName);
		this.role = pRole;
		homeParticipant = pHomeParticipant;
		awayParticipant = pAwayParticipant;
		tournament = pTournament;
	}

	/**
	 * Gets the role.
	 * 
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Gets the xml tournament.
	 * 
	 * @return the xml tournament
	 */
	public XmlTournament getXmlTournament() {
		return tournament;
	}

	/**
	 * Checks if is away participant.
	 * 
	 * @return true, if is away participant
	 */
	public boolean isAwayParticipant() {
		return awayParticipant;
	}

	/**
	 * Checks if is home participant.
	 * 
	 * @return true, if is home participant
	 */
	public boolean isHomeParticipant() {
		return homeParticipant;
	}

	/**
	 * Sets the away participant.
	 * 
	 * @param pAwayParticipant
	 *            the new away participant
	 */
	public void setAwayParticipant(boolean pAwayParticipant) {
		awayParticipant = pAwayParticipant;
	}

	/**
	 * Sets the home participant.
	 * 
	 * @param pHomeParticipant
	 *            the new home participant
	 */
	public void setHomeParticipant(boolean pHomeParticipant) {
		homeParticipant = pHomeParticipant;
	}

	/**
	 * Sets the role.
	 * 
	 * @param pRole
	 *            the new role
	 */
	public void setRole(String pRole) {
		this.role = pRole;
	}

	@Override
	public String toString() {
		return "XmlMatchParticipant [awayParticipant=" + awayParticipant
				+ ", homeParticipant=" + homeParticipant + ", tournament="
				+ tournament + ", role=" + role + "]";
	}

	

}
