/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean;

import java.io.Serializable;

/**
 * The Class Id.
 */
public class ObjectToId implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8176379153550597883L;
	/** The id. */
	private String id;

	/**
	 * Instantiates a new id.
	 * 
	 */
	public ObjectToId() {
	}

	/**
	 * Instantiates a new id.
	 * 
	 * @param pId
	 *            the id
	 */
	public ObjectToId(String pId) {
		this.id = pId;
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
		ObjectToId other = (ObjectToId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Sets the id.
	 * 
	 * @param pId
	 *            the new id
	 */
	public void setId(String pId) {
		id = pId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ObjectToId [id=" + id + "]";
	}

}
