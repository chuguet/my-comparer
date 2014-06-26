/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ParticipiantNames.
 */
public class ParticipiantNames {

	/**
	 * The Class ParticipantName.
	 */
	public static class ParticipantName {

		/** The role. */
		private final String role;

		/** The name. */
		private final String name;

		/**
		 * Instantiates a new participant name.
		 * 
		 * @param pRole
		 *            the role
		 * @param pName
		 *            the name
		 */
		public ParticipantName(String pRole, String pName) {
			super();
			role = pRole;
			name = pName;
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
		 * Gets the name.
		 * 
		 * @return the name
		 */
		public String getName() {
			return name;
		}
	}

	/** The Constant PERCENTIL. */
	public static final String PERCENTIL = "PERCENTIL";
	/** The match name. */
	final String matchName;

	/** The participant name array. */
	private final List<ParticipantName> participantNameArray;

	/**
	 * Gets the participant name array.
	 * 
	 * @return the participant name array
	 */
	public List<ParticipantName> getParticipantNameArray() {
		return participantNameArray;
	}

	/** The participiant name type. */
	private final String participiantNameType;
	
	/** The porcentaje. */
	private final String porcentaje = "%";

	/**
	 * Instantiates a new participiant names.
	 * 
	 * @param pMatchName
	 *            the match name
	 * @param pDivider
	 *            the divider
	 * @param pParticipiantNameType
	 *            the participiant name type
	 */
	public ParticipiantNames(final String pMatchName, final String pDivider,
			final String pParticipiantNameType) {
		participantNameArray = new ArrayList<ParticipiantNames.ParticipantName>();
		this.matchName = pMatchName;
		this.participiantNameType = pParticipiantNameType;
		String[] tmpParticipantNameArray = this.matchName.split(pDivider);
		int index = 1;
		for (String name : tmpParticipantNameArray) {
			String role = "";
			if (PERCENTIL.equals(participiantNameType)) {
				role = porcentaje + index + porcentaje;
			}
			participantNameArray.add(new ParticipantName(role, name));
			index++;
		}

	}

	/**
	 * Gets the.
	 * 
	 * @param position
	 *            the position
	 * @return the string
	 */
	public String get(int position) {
		return participantNameArray.get(position).getName();
	}

	/**
	 * Gets the.
	 * 
	 * @param positionRole
	 *            the position role
	 * @return the string
	 */
	public String get(String positionRole) {
		for (ParticipantName participantName : participantNameArray) {
			if (positionRole.equals(participantName.getRole())) {
				return participantName.getName();
			}
		}
		return null;
	}
}
