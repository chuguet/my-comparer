/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.valuebet.bean;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.annotation.CorrectCoreDate;

/**
 * The Class HistoricInfo.
 */
@Document
public class HistoricInfo {

	/**
	 * The Enum Cause.
	 */
	public enum Cause {

		/** The EXPECTATIO n_ change d_ stil l_ valuebet. */
		EXPECTATION_CHANGED_STILL_VALUEBET,

		/** The MATC h_ ended. */
		MATCH_ENDED,

		/** The MATC h_ n o_ longe r_ exists. */
		MATCH_NO_LONGER_EXISTS,

		/** The N o_ longe r_ valuebet. */
		NO_LONGER_VALUEBET,

		/** The OD d_ change d_ stil l_ valuebet. */
		ODD_CHANGED_STILL_VALUEBET,

		/** The PROBABILIT y_ change d_ stil l_ valuebet. */
		PROBABILITY_CHANGED_STILL_VALUEBET;

	}

	/** The cause. */
	@Field
	private Cause cause;

	/** The create date. */
	@Field
	@CorrectCoreDate
	private CoreDate createDate;

	/**
	 * Instantiates a new historic info.
	 * 
	 * @param cause
	 *            the cause
	 * @param createDate
	 *            the create date
	 */
	public HistoricInfo(Cause cause, CoreDate createDate) {
		super();
		this.cause = cause;
		this.createDate = createDate;
	}

	/**
	 * Gets the cause.
	 * 
	 * @return the cause
	 */
	public Cause getCause() {
		return cause;
	}

	/**
	 * Gets the creates the date.
	 * 
	 * @return the creates the date
	 */
	public CoreDate getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the cause.
	 * 
	 * @param cause
	 *            the new cause
	 */
	public void setCause(Cause cause) {
		this.cause = cause;
	}

	/**
	 * Sets the creates the date.
	 * 
	 * @param createDate
	 *            the new creates the date
	 */
	public void setCreateDate(CoreDate createDate) {
		this.createDate = createDate;
	}
}
