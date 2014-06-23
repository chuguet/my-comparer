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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class DurationPayment.
 */
@Entity
@Table(name = "DURATION_PAYMENT")
public class DurationPayment extends AbstractRelacional implements IAutoSender {

	/**
	 * The Enum TypeDuration.
	 */
	public enum TypeDuration {

		/** The FINISH. */
		FINISHED(),

		/** The INIT. */
		ACTIVE(),

		/** The DESACTIVE. */
		STOPPED();
	}

	/** The days remaining. */
	@Basic
	@Column(name = "DAYS_REMAINING")
	private Integer daysRemaining;

	/** The duration payment id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DURATION_PAYMENT_ID")
	private Integer durationPaymentId;

	/** The expected date. */
	@Basic
	@Column(name = "EXPECTED_DATE")
	private Date expectedDate;

	/** The finish date. */
	@Basic
	@Column(name = "FINISH_DATE")
	private Date finishDate;

	/** The start date. */
	@Basic
	@Column(name = "START_DATE")
	private Date startDate;

	/** The type duration. */
	@Basic
	@Column(name = "TYPE_DURATION")
	private TypeDuration typeDuration;

	/**
	 * Gets the days remaining.
	 * 
	 * @return the days remaining
	 */
	public Integer getDaysRemaining() {
		return daysRemaining;
	}

	/**
	 * Gets the duration payment id.
	 * 
	 * @return the duration payment id
	 */
	public Integer getDurationPaymentId() {
		return durationPaymentId;
	}

	/**
	 * Gets the expected date.
	 * 
	 * @return the expected date
	 */
	public Date getExpectedDate() {
		return expectedDate;
	}

	/**
	 * Gets the finish date.
	 * 
	 * @return the finish date
	 */
	public Date getFinishDate() {
		return finishDate;
	}

	/**
	 * Gets the start date.
	 * 
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Gets the type duration.
	 * 
	 * @return the type duration
	 */
	public TypeDuration getTypeDuration() {
		return typeDuration;
	}

	/**
	 * Sets the days remaining.
	 * 
	 * @param daysRemaining
	 *            the new days remaining
	 */
	public void setDaysRemaining(Integer daysRemaining) {
		this.daysRemaining = daysRemaining;
	}

	/**
	 * Sets the duration payment id.
	 * 
	 * @param durationPaymentId
	 *            the new duration payment id
	 */
	public void setDurationPaymentId(Integer durationPaymentId) {
		this.durationPaymentId = durationPaymentId;
	}

	/**
	 * Sets the expected date.
	 * 
	 * @param expectedDate
	 *            the new expected date
	 */
	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	/**
	 * Sets the finish date.
	 * 
	 * @param finishDate
	 *            the new finish date
	 */
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	/**
	 * Sets the start date.
	 * 
	 * @param startDate
	 *            the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Sets the type duration.
	 * 
	 * @param typeDuration
	 *            the new type duration
	 */
	public void setTypeDuration(TypeDuration typeDuration) {
		this.typeDuration = typeDuration;
	}

}
