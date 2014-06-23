/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "USER")
public class User extends AbstractRelacional implements IAutoSender {

	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer userId;

	/** The Name. */
	@Basic
	@Column(nullable = true, length = 30, name = "NAME")
	private String Name;

	/** The liferay user id. */
	@Basic
	@Column(unique = true)
	private Integer liferayUserId;

	/** The email. */
	@Basic
	@Column(nullable = true, length = 255, name = "EMAIL")
	private String email;

	/** The active. */
	@Basic
	@Column(name = "ACTIVE")
	private Boolean active;

	/** The actions. */
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<UserAction> actions;

	/** The user contents. */
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<UserContent> userContents;

	/** The user payments. */
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<UserPayment> userPayments;

	/** The user referer. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private UserReferer userReferer;

	/**
	 * Gets the active.
	 * 
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Sets the active.
	 * 
	 * @param active
	 *            the new active
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}

	/**
	 * Gets the user referer.
	 * 
	 * @return the user referer
	 */
	public UserReferer getUserReferer() {
		return userReferer;
	}

	/**
	 * Sets the user referer.
	 * 
	 * @param userReferer
	 *            the new user referer
	 */
	public void setUserReferer(UserReferer userReferer) {
		this.userReferer = userReferer;
	}

	/**
	 * Gets the user payments.
	 * 
	 * @return the user payments
	 */
	public Collection<UserPayment> getUserPayments() {
		return userPayments;
	}

	/**
	 * Sets the user payments.
	 * 
	 * @param userPayments
	 *            the new user payments
	 */
	public void setUserPayments(Collection<UserPayment> userPayments) {
		this.userPayments = userPayments;
	}

	/**
	 * Gets the user contents.
	 * 
	 * @return the user contents
	 */
	public Collection<UserContent> getUserContents() {
		return userContents;
	}

	/**
	 * Sets the user contents.
	 * 
	 * @param userContents
	 *            the new user contents
	 */
	public void setUserContents(Collection<UserContent> userContents) {
		this.userContents = userContents;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 * 
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * Gets the liferay user id.
	 * 
	 * @return the liferay user id
	 */
	public Integer getLiferayUserId() {
		return liferayUserId;
	}

	/**
	 * Sets the liferay user id.
	 * 
	 * @param liferayUserId
	 *            the new liferay user id
	 */
	public void setLiferayUserId(Integer liferayUserId) {
		this.liferayUserId = liferayUserId;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the actions.
	 * 
	 * @return the actions
	 */
	public Collection<UserAction> getActions() {
		return actions;
	}

	/**
	 * Sets the actions.
	 * 
	 * @param actions
	 *            the new actions
	 */
	public void setActions(Collection<UserAction> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", Name=" + Name + ", liferayUserId="
				+ liferayUserId + ", email=" + email + ", active=" + active
				+ ", actions=" + actions + ", userContents=" + userContents
				+ ", userPayments=" + userPayments + ", userReferer="
				+ userReferer + "]";
	}
	
	

}
