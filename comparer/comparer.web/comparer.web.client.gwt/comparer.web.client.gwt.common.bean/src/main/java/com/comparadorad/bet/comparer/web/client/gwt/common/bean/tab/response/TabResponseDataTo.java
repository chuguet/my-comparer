/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;

/**
 * The Class TabResponseDataTo.
 */
public class TabResponseDataTo {

	/** The id. */
	private ObjectToId id;

	/** The name. */
	private String name;

	/**
	 * Instantiates a new tab.
	 */
	public TabResponseDataTo() {
		super();
	}

	/**
	 * Instantiates a new tab response data to.
	 * 
	 * @param pId
	 *            the id
	 * @param pName
	 *            the name
	 */
	public TabResponseDataTo(ObjectToId pId, String pName) {
		super();
		id = pId;
		name = pName;
	}

	/**
	 * Instantiates a new tab.
	 * 
	 * @param name
	 *            the name
	 */
	public TabResponseDataTo(String name) {
		super();
		this.name = name;
	}

	/**
	 * Equals.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TabResponseDataTo other = (TabResponseDataTo) obj;
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
	public ObjectToId getId() {
		return id;
	}

	/**
	 * Gets the id str.
	 * 
	 * @return the id str
	 */
//	public String getIdStr() {
//		return id.getId();
//	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int {@inheritDoc}
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
	 * @param id
	 *            the new id
	 */
	public void setId(ObjectToId id) {
		this.id = id;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
