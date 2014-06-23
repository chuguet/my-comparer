/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

/**
 * The Class RtMaximumGoalerAttribute.
 */
@SuppressWarnings("serial")
public class RtMaximumGoalerAttribute extends AbstractRtAttribute {

	/** The cfg bet type id. */
	private String cfgBetTypeId;

	/** The winner name. */
	private String goalerName;

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RtMaximumGoalerAttribute other = (RtMaximumGoalerAttribute) obj;
		if (cfgBetTypeId == null) {
			if (other.cfgBetTypeId != null)
				return false;
		} else if (!cfgBetTypeId.equals(other.cfgBetTypeId))
			return false;
		if (goalerName == null) {
			if (other.goalerName != null)
				return false;
		} else if (!goalerName.equals(other.goalerName))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String getAttributeHashCode() {
		return new StringBuffer().append(this.goalerName).toString();
	}

	/**
	 * Gets the cfg bet type id.
	 * 
	 * @return the cfg bet type id
	 */
	public String getCfgBetTypeId() {
		return cfgBetTypeId;
	}

	/**
	 * Gets the goaler name.
	 * 
	 * @return the goaler name
	 */
	public String getGoalerName() {
		return goalerName;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((cfgBetTypeId == null) ? 0 : cfgBetTypeId.hashCode());
		result = prime * result
				+ ((goalerName == null) ? 0 : goalerName.hashCode());
		return result;
	}

	/**
	 * Sets the cfg bet type id.
	 * 
	 * @param cfgBetTypeId
	 *            the new cfg bet type id
	 */
	public void setCfgBetTypeId(String cfgBetTypeId) {
		this.cfgBetTypeId = cfgBetTypeId;
	}

	/**
	 * Sets the goaler name.
	 * 
	 * @param goalerName
	 *            the new goaler name
	 */
	public void setGoalerName(String goalerName) {
		this.goalerName = goalerName;
	}
	
	@Override
	public Boolean isValidForSurebet() {
		return Boolean.TRUE;
	}

	@Override
	public String toString() {
		return "RtMaximumGoalerAttribute [cfgBetTypeId=" + cfgBetTypeId
				+ ", goalerName=" + goalerName + "]";
	}	

}
