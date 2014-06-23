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
 * The Class UserReferer.
 */
@Entity
@Table(name = "USER_REFERER")
public class UserReferer extends AbstractSystemExternal implements IAutoSender {

	/**
	 * The Enum TypeReferer.
	 */
	public enum TypeReferer{
		
		/** The AFFILIATE. */
		AFFILIATE(),
		
		/** The N o_ affiliate. */
		NO_AFFILIATE()
		;
	}
	
	/** The User referer id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_REFERER_ID")
	private Integer UserRefererId;
	
	/** The referer. */
	@Basic
	@Column(name="REFERER")
	private TypeReferer referer;	

	/**
	 * Gets the referer.
	 *
	 * @return the referer
	 */
	public TypeReferer getReferer() {
		return referer;
	}

	/**
	 * Sets the referer.
	 *
	 * @param referer the new referer
	 */
	public void setReferer(TypeReferer referer) {
		this.referer = referer;
	}

	/**
	 * Gets the user referer id.
	 *
	 * @return the user referer id
	 */
	public Integer getUserRefererId() {
		return UserRefererId;
	}

	/**
	 * Sets the user referer id.
	 *
	 * @param userRefererId the new user referer id
	 */
	public void setUserRefererId(Integer userRefererId) {
		UserRefererId = userRefererId;
	}	
	
}
