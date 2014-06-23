/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import java.io.Serializable;

import javax.persistence.Column;

import com.comparadorad.bet.comparer.model.autosender.bean.UserContent.UserContentName;

/**
 * The Class UserContentPK.
 */
class UserContentPK implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4946405280258778457L;

	/** The user content id. */
	@Column(name = "USER_CONTENT_ID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userContentId;

	/** The name. */
	@Column(name = "NAME")
	private UserContentName name;

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return userContentId;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserContentPK other = (UserContentPK) obj;
		if (name != other.name)
			return false;
		if (userContentId == null) {
			if (other.userContentId != null)
				return false;
		} else if (!userContentId.equals(other.userContentId))
			return false;
		return true;
	}

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
