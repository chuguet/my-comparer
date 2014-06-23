/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class RtWinWinResult.
 */
@SuppressWarnings("serial")
public class RtGanadorPartidoAttribute extends AbstractRtAttribute {

	/** The result. */
	@Field
	private Result result;

	/** The winner name. */
	@Field
	private String winnerName;

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RtGanadorPartidoAttribute other = (RtGanadorPartidoAttribute) obj;
		if (result != other.result)
			return false;
		if (winnerName == null) {
			if (other.winnerName != null)
				return false;
		} else if (!winnerName.equals(other.winnerName))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String getAttributeHashCode() {
		return new StringBuffer().append(this.winnerName).append(this.result)
				.toString();
	}

	/**
	 * Gets the result.
	 * 
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * Gets the winner name.
	 * 
	 * @return the winner name
	 */
	public String getWinnerName() {
		return winnerName;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result
				+ ((winnerName == null) ? 0 : winnerName.hashCode());
		return result;
	}

	/**
	 * Sets the result.
	 * 
	 * @param pResult
	 *            the new result
	 */
	public void setResult(Result pResult) {
		result = pResult;
	}

	/**
	 * Sets the winner name.
	 * 
	 * @param winnerName
	 *            the new winner name
	 */
	public void setWinnerName(String winnerName) {
		this.winnerName = winnerName;
	}

	@Override
	public Boolean isValidForSurebet() {
		return Boolean.TRUE;
	}

	@Override
	public String toString() {
		return "RtGanadorPartidoAttribute [result=" + result + ", winnerName="
				+ winnerName + "]";
	}
	
	

}
