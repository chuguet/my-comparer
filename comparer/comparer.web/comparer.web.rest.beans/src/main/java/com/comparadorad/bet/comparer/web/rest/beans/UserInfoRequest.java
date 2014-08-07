/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.rest.beans;

import com.comparadorad.bet.comparer.web.rest.beans.enume.UserTypes;


/**
 * The Class UserInfoRequest.
 */
public class UserInfoRequest implements IRequest{

	/** The user id. */
	private String liferayUserId;

	

	/** The destiny group. */
	private UserTypes destinyGroup;
	
	

	/**
	 * Gets the liferay user id.
	 *
	 * @return the liferay user id
	 */
	public String getLiferayUserId() {
		return liferayUserId;
	}

	/**
	 * Sets the liferay user id.
	 *
	 * @param liferayUserId the new liferay user id
	 */
	public void setLiferayUserId(String liferayUserId) {
		this.liferayUserId = liferayUserId;
	}

	/**
	 * Gets the destiny group.
	 *
	 * @return the destiny group
	 */
	public UserTypes getDestinyGroup() {
		return destinyGroup;
	}

	/**
	 * Sets the destiny group.
	 *
	 * @param destinyGroup the new destiny group
	 */
	public void setDestinyGroup(UserTypes destinyGroup) {
		this.destinyGroup = destinyGroup;
	}

	@Override
	public String toString() {
		return "UserInfoRequest [liferayUserId=" + liferayUserId
				+ ", destinyGroup=" + destinyGroup + "]";
	}
	

}
