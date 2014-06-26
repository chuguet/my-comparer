/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean.user;

import java.util.Locale;
import java.util.TimeZone;

import com.comparadorad.bet.comparer.model.core.bean.enume.LiferayRoles;

/**
 * The Class UserData. This class has all the user important data for session as
 * locale preferences, etc.
 */
public class UserData {

	private String principal;
	
	/** The locale. */
	private Locale locale;

	/** The time zone. */
	private TimeZone timeZone;


	/** The role. */
	private Roles roles;


	/**
	 * Instantiates a new user data.
	 */
	public UserData() {
		super();
	}

	/**
	 * Instantiates a new user data.
	 * 
	 * @param pLocale
	 *            the locale
	 */
	public UserData(Locale pLocale) {
		super();
		locale = pLocale;
	}

	/**
	 * Gets the locale.
	 * 
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Sets the locale.
	 * 
	 * @param pLocale
	 *            the new locale
	 */
	public void setLocale(Locale pLocale) {
		locale = pLocale;
	}


	/**
	 * Gets the time zone.
	 * 
	 * @return the time zone
	 */
	public TimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * Sets the time zone.
	 * 
	 * @param timeZone
	 *            the new time zone
	 */
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Roles getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserData [locale=" + locale + ", timeZone=" + timeZone
				+ ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locale == null) ? 0 : locale.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result
				+ ((timeZone == null) ? 0 : timeZone.hashCode());
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
		UserData other = (UserData) obj;
		if (locale == null) {
			if (other.locale != null)
				return false;
		} else if (!locale.equals(other.locale))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (timeZone == null) {
			if (other.timeZone != null)
				return false;
		} else if (!timeZone.equals(other.timeZone))
			return false;
		return true;
	}


	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public boolean isUnregistered(){
		boolean result = false;
		for (LiferayRoles rol : roles.getRoles()) {
			if(rol.equals(LiferayRoles.UNREGISTERED)){
				result = true;
				break;
			}
		}
		return result;
	}

}