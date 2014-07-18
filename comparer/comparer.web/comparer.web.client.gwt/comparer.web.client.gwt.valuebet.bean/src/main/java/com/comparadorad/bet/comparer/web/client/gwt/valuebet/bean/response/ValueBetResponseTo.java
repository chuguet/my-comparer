/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.response;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;

/**
 * The Class ValueBetResponseTo.
 */
public class ValueBetResponseTo {

	/** The last page. */
	private boolean lastPage;

	/** The no payment user. */
	private boolean noPaymentUser;

	/** The table response to. */
	private TableResponseTo tableResponseTo;
	
	/** The count. */
	private Long count;

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(Long count) {
		this.count = count;
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
	 * Checks if is last page.
	 * 
	 * @return true, if is last page
	 */
	public boolean isLastPage() {
		return this.lastPage;
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
	 * Sets the last page.
	 * 
	 * @param pLastPage
	 *            the new last page
	 */
	public void setLastPage(boolean pLastPage) {
		this.lastPage = pLastPage;
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
