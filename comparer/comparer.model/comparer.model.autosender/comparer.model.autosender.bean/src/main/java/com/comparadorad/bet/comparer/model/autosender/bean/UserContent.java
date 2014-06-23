/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class UserContent.
 */
@Entity
// @IdClass(UserContentPK.class)
@Table(name = "USER_CONTENT")
public class UserContent extends AbstractSystemExternal implements IAutoSender {

	/**
	 * The Enum UserContentName.
	 */
	public enum UserContentName {

		/** The INICIO. */
		BLOG("TaY2"),

		/** The PARTIDO s_ e n_ vivo. */
		SUREBET("TabL"),

		/** The PRONOSTICOS. */
		AFILIADOS("p1rK"),

		/** The BLOG. */
		REFERIDOS("p1ro"),

		/** The FORO. */
		VALUEBET("TabL"),

		/** The CASA s_ d e_ apuestas. */
		WEB_PRINCIPAL("TabM");

		

		/** The name id. */
		private String name;

		/**
		 * Instantiates a new user content name.
		 * 
		 * @param nameId
		 *            the name id
		 */
		UserContentName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}

	/** The user content id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_CONTENT_ID")
	private Integer userContentId;

	/** The name. */
	@Basic
	@Column(nullable = false, length = 30, name = "NAME")
	private UserContentName name;

	/**
	 * Gets the user content id.
	 * 
	 * @return the user content id
	 */
	public Integer getUserContentId() {
		return userContentId;
	}

	/**
	 * Sets the user content id.
	 * 
	 * @param userContentId
	 *            the new user content id
	 */
	public void setUserContentId(Integer userContentId) {
		this.userContentId = userContentId;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public UserContentName getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(UserContentName name) {
		this.name = name;
	}

}
