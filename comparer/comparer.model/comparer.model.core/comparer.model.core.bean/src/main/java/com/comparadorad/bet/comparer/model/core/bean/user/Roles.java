/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean.user;

import java.util.List;

import com.comparadorad.bet.comparer.model.core.bean.enume.LiferayRoles;


/**
 * The Class Role.
 */
public class Roles {

	/** The roles. */
	private List<LiferayRoles> roles;

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public List<LiferayRoles> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(List<LiferayRoles> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Roles [roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		Roles other = (Roles) obj;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}



}
