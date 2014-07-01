/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean;

/**
 * The Class LinkTo.
 */
public class LinkTo {

	/** The name. */
	private String name;

	/** The object to id. */
	private ObjectToId objectToId;

	/** The object to id aux. */
	private ObjectToId objectToIdAux;

	/** The object to id aux2. */
	private ObjectToId objectToIdAux2;

	/**
	 * Instantiates a new link to.
	 */
	public LinkTo() {
		super();
	}

	/**
	 * Instantiates a new link to.
	 * 
	 * @param pName
	 *            the name
	 * @param pObjectToId
	 *            the object to id
	 */
	public LinkTo(String pName, ObjectToId pObjectToId) {
		super();
		name = pName;
		objectToId = pObjectToId;
	}

	/**
	 * Instantiates a new link to.
	 * 
	 * @param pName
	 *            the name
	 * @param pObjectToId
	 *            the object to id
	 * @param pObjectToIdAux1
	 *            the object to id aux1
	 */
	public LinkTo(String pName, ObjectToId pObjectToId,
			ObjectToId pObjectToIdAux1) {
		super();
		name = pName;
		objectToId = pObjectToId;
		objectToIdAux = pObjectToIdAux1;
	}

	/**
	 * Instantiates a new link to.
	 * 
	 * @param pName
	 *            the name
	 * @param pObjectToId
	 *            the object to id
	 * @param pObjectToIdAux1
	 *            the object to id aux1
	 * @param pObjectToIdAux2
	 *            the object to id aux2
	 */
	public LinkTo(String pName, ObjectToId pObjectToId,
			ObjectToId pObjectToIdAux1, ObjectToId pObjectToIdAux2) {
		super();
		name = pName;
		objectToId = pObjectToId;
		objectToIdAux = pObjectToIdAux1;
		objectToIdAux2 = pObjectToIdAux2;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the object to id.
	 * 
	 * @return the object to id
	 */
	public ObjectToId getObjectToId() {
		return objectToId;
	}

	/**
	 * Gets the object to id aux.
	 * 
	 * @return the object to id aux
	 */
	public ObjectToId getObjectToIdAux() {
		return objectToIdAux;
	}

	/**
	 * Gets the object to id aux2.
	 * 
	 * @return the object to id aux2
	 */
	public ObjectToId getObjectToIdAux2() {
		return objectToIdAux2;
	}

	/**
	 * Sets the name.
	 * 
	 * @param pName
	 *            the new name
	 */
	public void setName(String pName) {
		name = pName;
	}

	/**
	 * Sets the object to id.
	 * 
	 * @param pObjectToId
	 *            the new object to id
	 */
	public void setObjectToId(ObjectToId pObjectToId) {
		objectToId = pObjectToId;
	}

	/**
	 * Sets the object to id aux.
	 * 
	 * @param pObjectToIdAux
	 *            the new object to id aux
	 */
	public void setObjectToIdAux(ObjectToId pObjectToIdAux) {
		objectToIdAux = pObjectToIdAux;
	}

	/**
	 * Sets the object to id aux2.
	 * 
	 * @param pObjectToIdAux2
	 *            the new object to id aux2
	 */
	public void setObjectToIdAux2(ObjectToId pObjectToIdAux2) {
		objectToIdAux2 = pObjectToIdAux2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((objectToId == null) ? 0 : objectToId.hashCode());
		result = prime * result
				+ ((objectToIdAux == null) ? 0 : objectToIdAux.hashCode());
		result = prime * result
				+ ((objectToIdAux2 == null) ? 0 : objectToIdAux2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LinkTo other = (LinkTo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objectToId == null) {
			if (other.objectToId != null)
				return false;
		} else if (!objectToId.equals(other.objectToId))
			return false;
		if (objectToIdAux == null) {
			if (other.objectToIdAux != null)
				return false;
		} else if (!objectToIdAux.equals(other.objectToIdAux))
			return false;
		if (objectToIdAux2 == null) {
			if (other.objectToIdAux2 != null)
				return false;
		} else if (!objectToIdAux2.equals(other.objectToIdAux2))
			return false;
		return true;
	}

}