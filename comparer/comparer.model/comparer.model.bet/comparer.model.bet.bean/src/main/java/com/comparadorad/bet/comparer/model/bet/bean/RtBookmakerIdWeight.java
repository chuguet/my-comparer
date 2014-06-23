/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;

/**
 * The Class RtBookmakerIdWeight.
 */
@Document
public class RtBookmakerIdWeight implements IRtData {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5984252983233276945L;

	/**
	 * Gets the serialversionuid.
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** The bookmaker id. */
	@Field
	private CfgBookmakerId bookmakerId;

	/** The weigth. */
	@Field
	private Integer weigth;

	/**
	 * Instantiates a new rt bookmaker id weight.
	 */
	public RtBookmakerIdWeight() {

	}

	/**
	 * Instantiates a new rt bookmaker id weight.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 */
	public RtBookmakerIdWeight(CfgBookmaker bookmaker) {
		this.bookmakerId = CfgBookmakerId.getCfgBookmakerIdById(bookmaker
				.getObjectId().toString());
		this.weigth = bookmaker.getBookmakerConfiguration().getPriorityModa();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RtBookmakerIdWeight other = (RtBookmakerIdWeight) obj;
		if (bookmakerId != other.bookmakerId)
			return false;
		return true;
	}

	/**
	 * Gets the bookmaker id.
	 * 
	 * @return the bookmaker id
	 */
	public CfgBookmakerId getBookmakerId() {
		return bookmakerId;
	}

	/**
	 * Gets the weigth.
	 * 
	 * @return the weigth
	 */
	public Integer getWeigth() {
		return weigth;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookmakerId == null) ? 0 : bookmakerId.hashCode());
		return result;
	}

	/**
	 * Sets the bookmaker id.
	 * 
	 * @param bookmakerId
	 *            the new bookmaker id
	 */
	public void setBookmakerId(CfgBookmakerId bookmakerId) {
		this.bookmakerId = bookmakerId;
	}

	/**
	 * Sets the weigth.
	 * 
	 * @param weigth
	 *            the new weigth
	 */
	public void setWeigth(Integer weigth) {
		this.weigth = weigth;
	}
}
