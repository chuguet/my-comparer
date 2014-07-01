/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.request;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.core.bean.AbstractClientToRequest;

/**
 * The Class SecureBetRequestTo.
 */
public class SureBetRequestTo extends AbstractClientToRequest {

	/** The page num. */
	private Long pageNum;

	/** The sure bet id. */
	private ObjectToId sureBetId;

	/**
	 * Gets the page num.
	 * 
	 * @return the page num
	 */
	public Long getPageNum() {
		return pageNum;
	}

	/**
	 * Gets the sure bet id.
	 * 
	 * @return the sure bet id
	 */
	public ObjectToId getSureBetId() {
		return sureBetId;
	}

	/**
	 * Sets the page num.
	 * 
	 * @param pageNum
	 *            the new page num
	 */
	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * Sets the sure bet id.
	 * 
	 * @param pSureBetId
	 *            the new sure bet id
	 */
	public void setSureBetId(ObjectToId pSureBetId) {
		sureBetId = pSureBetId;
	}
}
