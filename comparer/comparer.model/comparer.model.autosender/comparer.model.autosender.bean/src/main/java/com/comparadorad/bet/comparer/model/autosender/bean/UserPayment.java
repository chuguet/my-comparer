/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import java.util.Collection;
import java.util.Date;

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

/**
 * The Class UserPayment.
 */
@Entity
@Table(name = "USER_PAYMENT")
public class UserPayment extends AbstractRelacional implements IAutoSender {

	/**
	 * The Enum StatePayment.
	 */
	public enum StatePayment {

		/** The ACTIVE. */
		ACTIVE(),

		/** The DESACTIVE. */
		DESACTIVE(),

		/** The FINISH. */
		FINISH();
	}

	/** The duration payment. */
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<DurationPayment> durationPayment;

	/** The extenal system id. */
	@Basic
	@Column(nullable = true, length = 30, name = "EXTERNAL_SYSTEM_ID")
	private String extenalSystemId;

	/** The payment date. */
	@Basic
	@Column(name = "PAYMENT_DATE")
	private Date paymentDate;

	/** The state payment. */
	@Basic
	@Column(name = "STATE_PAYMENT")
	private StatePayment statePayment;

	/** The type payment. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private TypePayment typePayment;

	/** The user. */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User user;

	/** The user payment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_PAYMENT_ID")
	private Integer userPaymentId;

	/**
	 * Gets the duration payment.
	 * 
	 * @return the duration payment
	 */
	public Collection<DurationPayment> getDurationPayment() {
		return durationPayment;
	}

	/**
	 * Gets the extenal system id.
	 * 
	 * @return the extenal system id
	 */
	public String getExtenalSystemId() {
		return extenalSystemId;
	}

	/**
	 * Gets the payment date.
	 * 
	 * @return the payment date
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * Gets the state payment.
	 * 
	 * @return the state payment
	 */
	public StatePayment getStatePayment() {
		return statePayment;
	}

	/**
	 * Gets the type payment.
	 * 
	 * @return the type payment
	 */
	public TypePayment getTypePayment() {
		return typePayment;
	}

	/**
	 * Gets the user.
	 * 
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Gets the user payment id.
	 * 
	 * @return the user payment id
	 */
	public Integer getUserPaymentId() {
		return userPaymentId;
	}

	/**
	 * Sets the duration payment.
	 * 
	 * @param durationPayment
	 *            the new duration payment
	 */
	public void setDurationPayment(Collection<DurationPayment> durationPayment) {
		this.durationPayment = durationPayment;
	}

	/**
	 * Sets the extenal system id.
	 * 
	 * @param extenalSystemId
	 *            the new extenal system id
	 */
	public void setExtenalSystemId(String extenalSystemId) {
		this.extenalSystemId = extenalSystemId;
	}

	/**
	 * Sets the payment date.
	 * 
	 * @param paymentDate
	 *            the new payment date
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * Sets the state payment.
	 * 
	 * @param statePayment
	 *            the new state payment
	 */
	public void setStatePayment(StatePayment statePayment) {
		this.statePayment = statePayment;
	}

	/**
	 * Sets the type payment.
	 * 
	 * @param typePayment
	 *            the new type payment
	 */
	public void setTypePayment(TypePayment typePayment) {
		this.typePayment = typePayment;
	}

	@Override
	public String toString() {
		return "UserPayment [durationPayment=" + durationPayment
				+ ", extenalSystemId=" + extenalSystemId + ", paymentDate="
				+ paymentDate + ", statePayment=" + statePayment
				+ ", typePayment=" + typePayment + ", user=" + user
				+ ", userPaymentId=" + userPaymentId + "]";
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Sets the user payment id.
	 * 
	 * @param userPaymentId
	 *            the new user payment id
	 */
	public void setUserPaymentId(Integer userPaymentId) {
		this.userPaymentId = userPaymentId;
	}

}
