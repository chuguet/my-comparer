/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class CoreActiveElement.
 */
public class CoreActiveElement implements HasActive, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7626299043751190722L;

	/**
	 * The Class ActivationPeriod.
	 */

	public static class ActivationPeriod {
		/** The end date. */
		private Date endDate;

		/** The init date. */
		private Date initDate;

		/**
		 * Instantiates a new activation period.
		 */
		public ActivationPeriod() {
			super();
		}

		/**
		 * Instantiates a new activation period.
		 * 
		 * @param pInitDate
		 *            the init date
		 * @param pEndDate
		 *            the end date
		 */
		public ActivationPeriod(final Date pInitDate, final Date pEndDate) {
			super();
			initDate = pInitDate;
			endDate = pEndDate;
		}

		/**
		 * Gets the end date.
		 * 
		 * @return the end date
		 */
		public Date getEndDate() {
			return endDate;
		}

		/**
		 * Gets the inits the date.
		 * 
		 * @return the inits the date
		 */
		public Date getInitDate() {
			return initDate;
		}

		/**
		 * Sets the end date.
		 * 
		 * @param pEndDate
		 *            the new end date
		 */
		public void setEndDate(Date pEndDate) {
			endDate = pEndDate;
		}

		/**
		 * Sets the inits the date.
		 * 
		 * @param pInitDate
		 *            the new inits the date
		 */
		public void setInitDate(Date pInitDate) {
			initDate = pInitDate;
		}
	}

	/** The activation periods. */
	@Field
	private List<ActivationPeriod> activationPeriods;

	/** The active. */
	@Field
	@NotNull
	private Boolean active;

	/**
	 * Instantiates a new core active element.
	 */
	public CoreActiveElement() {
		super();
	}

	/**
	 * Instantiates a new core active element.
	 * 
	 * @param pActive
	 *            the active
	 */
	public CoreActiveElement(Boolean pActive) {
		super();
		active = pActive;
	}

	/**
	 * Adds the activation period.
	 * 
	 * @param pActivationPeriod
	 *            the activation period
	 * @return true, if successful
	 */
	public boolean addActivationPeriod(final ActivationPeriod pActivationPeriod) {
		if (activationPeriods == null) {
			activationPeriods = new ArrayList<ActivationPeriod>();
		}
		return activationPeriods.add(pActivationPeriod);
	}

	/**
	 * Adds the activation period.
	 * 
	 * @param pInitDate
	 *            the init date
	 * @param pEndDate
	 *            the end date
	 * @return true, if successful
	 */
	public boolean addActivationPeriod(final Date pInitDate, final Date pEndDate) {
		ActivationPeriod activationPeriod = new ActivationPeriod(pInitDate,
				pEndDate);
		return addActivationPeriod(activationPeriod);
	}

	/**
	 * Date after or equals.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return true, if successful
	 */
	private boolean dateAfterOrEquals(final Date date1, final Date date2) {
		return date1.after(date2) || date1.equals(date2);
	}

	/**
	 * Date before or equals.
	 * 
	 * @param date1
	 *            the date1
	 * @param date2
	 *            the date2
	 * @return true, if successful
	 */
	private boolean dateBeforeOrEquals(final Date date1, final Date date2) {
		return date1.before(date2) || date1.equals(date2);
	}

	/**
	 * Checks if is active.
	 * 
	 * @param pDate
	 *            the date
	 * @return true, if is active {@inheritDoc}
	 */
	@Override
	public boolean isActive(Date pDate) {
		boolean result = false;
		if (this.active != null) {
			result = this.active;
		} else if (activationPeriods != null) {
			for (ActivationPeriod activationPeriod : activationPeriods) {
				// We have both dates
				if (activationPeriod.getInitDate() != null
						&& activationPeriod.getEndDate() != null) {
					// The date is included between the two dates
					if (dateAfterOrEquals(pDate, activationPeriod.getInitDate())
							&& dateBeforeOrEquals(pDate,
									activationPeriod.getEndDate())) {
						result = true;
						break;
					}
				} else if (activationPeriod.getInitDate() != null
						&& activationPeriod.getEndDate() == null) {
					// The date is included after de init date
					if (dateAfterOrEquals(pDate, activationPeriod.getInitDate())) {
						result = true;
						break;
					}
				} else if (activationPeriod.getInitDate() == null
						&& activationPeriod.getEndDate() != null) {
					// The date is included between the two dates
					if (dateBeforeOrEquals(pDate, activationPeriod.getEndDate())) {
						result = true;
						break;
					}
				} else {
					// its both null
					result = true;
					break;
				}

			}
		} else {
			// anything is informed
			result = true;
		}
		return result;
	}

	/**
	 * Sets the active.
	 * 
	 * @param pActive
	 *            the new active
	 */
	public void setActive(Boolean pActive) {
		active = pActive;
	}

	public Boolean getActive() {
		return active;
	}

	/**
	 * Clear past dates.
	 * 
	 * @param pDate
	 *            the date
	 * @return true, if successful
	 */
	public boolean clearPastDates(Date pDate) {
		boolean updated = false;
		List<ActivationPeriod> aux = new ArrayList<CoreActiveElement.ActivationPeriod>(
				this.activationPeriods);
		for (ActivationPeriod activationPeriod : aux) {
			if (activationPeriod.endDate.compareTo(pDate) == -1) {
				activationPeriods.remove(activationPeriod);
				updated = true;
			}
		}
		return updated;
	}

	/**
	 * Contains activation period.
	 * 
	 * @param pActivationPeriod
	 *            the activation period
	 * @return true, if successful
	 */
	public boolean containsActivationPeriod(ActivationPeriod pActivationPeriod) {
		boolean result = false;
		for (ActivationPeriod activationPeriod : this.activationPeriods) {
			if (activationPeriod.initDate == null
					&& pActivationPeriod.initDate == null) {
				result = activationPeriod.endDate
						.equals(pActivationPeriod.endDate);
			}
			if (activationPeriod.endDate == null
					&& pActivationPeriod.endDate == null) {
				result = activationPeriod.initDate
						.equals(pActivationPeriod.initDate);
			}
			if (activationPeriod.initDate != null
					&& pActivationPeriod.initDate != null
					&& activationPeriod.endDate != null
					&& pActivationPeriod.endDate != null) {
				result = activationPeriod.initDate
						.equals(pActivationPeriod.initDate)
						&& activationPeriod.endDate
								.equals(pActivationPeriod.endDate);
			}
		}
		return result;
	}

}
