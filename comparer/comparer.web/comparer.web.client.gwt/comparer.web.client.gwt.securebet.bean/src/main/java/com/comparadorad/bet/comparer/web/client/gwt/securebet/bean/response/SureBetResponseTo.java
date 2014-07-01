/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.response;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * The Class SecureBetResponseTo.
 */
public class SureBetResponseTo {

	/** The count. */
	private Long count;

	/** The no payment user. */
	private boolean noPaymentUser;

	/** The table response to. */
	private TableResponseTo tableResponseTo;

	/**
	 * Gets the count.
	 * 
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * Gets the table response to.
	 * 
	 * @return the table response to
	 */
	public TableResponseTo getTableResponseTo() {
		return tableResponseTo;
	}

	/**
	 * Checks if is no payment user.
	 * 
	 * @return true, if is no payment user
	 */
	public boolean isNoPaymentUser() {
		return this.noPaymentUser;
	}

	/**
	 * Sets the count.
	 * 
	 * @param count
	 *            the new count
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * Sets the no payment user.
	 * 
	 * @param pNoPaymentUser
	 *            the new no payment user
	 */
	public void setNoPaymentUser(boolean pNoPaymentUser) {
		this.noPaymentUser = pNoPaymentUser;
	}

	/**
	 * Sets the table response to.
	 * 
	 * @param tableResponseTo
	 *            the new table response to
	 */
	public void setTableResponseTo(TableResponseTo tableResponseTo) {
		this.tableResponseTo = tableResponseTo;
	}

}
