/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.io.Serializable;
import java.math.BigInteger;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.ObjectState.ObjectStateEnum;

/**
 * The Class AbstractId.
 */
@SuppressWarnings("serial")
public abstract class AbstractId implements IObjectId, Serializable,
		IObjectStateContainer {

	/** The name id. */
	@Field
	private String nameId;

	/** The id. */
	@Id
	private BigInteger objectId;

	/** The object state. */
	@Transient
	private ObjectState objectState;

	/**
	 * Instantiates a new abstract id.
	 */
	public AbstractId() {
		super();
	}

	/**
	 * Instantiates a new abstract id.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractId(BigInteger pObjectId) {
		super();
		objectId = pObjectId;
	}

	/**
	 * Instantiates a new abstract id.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractId(IObjectIdEnum pObjectId) {
		super();
		objectId = pObjectId.objectId();
	}

	/**
	 * Instantiates a new abstract id.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public AbstractId(String pObjectId) {
		super();
		objectId = new BigInteger(pObjectId);
	}

	/**
	 * Gets the name id.
	 * 
	 * @return the name id
	 */
	public String getNameId() {
		return nameId;
	}

	/**
	 * Gets the core object id.
	 * 
	 * @return the core object id
	 */
	public BigInteger getObjectId() {
		return objectId;
	}

	/**
	 * Gets the object state.
	 * 
	 * @return the object state
	 */
	public ObjectState getObjectState() {
		return objectState;
	}

	/**
	 * Sets the object state.
	 * 
	 * @param pObjectState
	 *            the new object state
	 */
	public void setObjectState(ObjectStateEnum pObjectState) {
		objectState = new ObjectState(pObjectState);
	}

	/**
	 * Checks if is updated.
	 * 
	 * @return true, if is updated {@inheritDoc}
	 */
	@Override
	public boolean isUpdated() {
		return getObjectState() != null && getObjectState().isUpdated();
	}

	/**
	 * Sets the name id.
	 * 
	 * @param pNameId
	 *            the new name id
	 */
	public void setNameId(String pNameId) {
		nameId = pNameId;
	}

	/**
	 * Sets the core object id.
	 * 
	 * @param pBigInteger
	 *            the new object id
	 */
	public void setObjectId(BigInteger pBigInteger) {
		objectId = pBigInteger;
	}

	/**
	 * Sets the core object id.
	 * 
	 * @param pCoreObjectId
	 *            the new core object id
	 */
	public void setObjectId(String pCoreObjectId) {
		objectId = new BigInteger(pCoreObjectId);
	}

	/**
	 * Sets the updated.
	 * 
	 * @param pUpdated
	 *            the new updated {@inheritDoc}
	 */
	@Override
	public void setUpdated(boolean pUpdated) {
		if (objectState == null) {
			objectState = new ObjectState(ObjectStateEnum.UPDATED);
		} else {
			getObjectState().setUpdated();
		}
	}

	/**
	 * Equals.
	 * 
	 * @param object
	 *            the object
	 * @return true, if successful
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof AbstractId)) {
			return false;
		}
		AbstractId rhs = (AbstractId) object;
		return new EqualsBuilder().append(this.objectId, rhs.objectId)
				.append(this.objectState, rhs.objectState)
				.append(this.nameId, rhs.nameId).isEquals();
	}

}
