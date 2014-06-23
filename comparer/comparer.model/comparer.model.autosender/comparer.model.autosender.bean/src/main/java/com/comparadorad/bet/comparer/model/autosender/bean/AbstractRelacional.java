/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class AbstractRelacionalControl.
 */
@MappedSuperclass
public abstract class AbstractRelacional {

	/** The creacion user. */
	@Basic
	@Column(nullable = true, length = 30, name = "CREATION_USER")
	@Enumerated(EnumType.STRING)
	private UserCreacion creacionUser;

	/** The creation date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATION_DATE")
	private Date creationDate;

	/** The modification date. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFICATION_DATE")
	private Date modificationDate;

	/** The user. */
	@Basic
	@Column(nullable = true, length = 30, name = "MODIFICATION_USER")
	@Enumerated(EnumType.STRING)
	private UserCreacion modificationUser;

	/**
	 * Gets the creacion user.
	 * 
	 * @return the creacion user
	 */
	public UserCreacion getCreacionUser() {
		return creacionUser;
	}

	/**
	 * Gets the creation date.
	 * 
	 * @return the creation date
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * Gets the modification date.
	 * 
	 * @return the modification date
	 */
	public Date getModificationDate() {
		return modificationDate;
	}

	/**
	 * Gets the modification user.
	 * 
	 * @return the modification user
	 */
	public UserCreacion getModificationUser() {
		return modificationUser;
	}

	/**
	 * Sets the creacion user.
	 * 
	 * @param creacionUser
	 *            the new creacion user
	 */
	public void setCreacionUser(UserCreacion creacionUser) {
		this.creacionUser = creacionUser;
	}

	/**
	 * Sets the creation date.
	 * 
	 * @param creationDate
	 *            the new creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Sets the modification date.
	 * 
	 * @param modificationDate
	 *            the new modification date
	 */
	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	/**
	 * Sets the modification user.
	 * 
	 * @param modificationUser
	 *            the new modification user
	 */
	public void setModificationUser(UserCreacion modificationUser) {
		this.modificationUser = modificationUser;
	}

}
