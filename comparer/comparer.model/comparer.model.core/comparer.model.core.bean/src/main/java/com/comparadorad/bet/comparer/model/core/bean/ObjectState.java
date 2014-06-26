/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.bean;

import java.io.Serializable;

/**
 * The Class ObjectState.
 */
public class ObjectState implements Serializable{

	/**
	 * The Enum ObjectStateEnum.
	 */
	public static enum ObjectStateEnum implements Serializable{

		/** The NO t_ modified. */
		NOT_MODIFIED("NOT_MODIFIED"), /** The DELETED. */
		DELETED("DELETED"), /** The NEW. */
		NEW("NEW"),
		/** The _12 be t_ co m_ id. */
		UPDATED("UPDATED");
		/** The _188 be t_ co m_ id. */
		/** The object id. */
		private final String stateId;

		/**
		 * Instantiates a new cfg bookmaker id.
		 * 
		 * @param stateId
		 *            the state id
		 */
		ObjectStateEnum(String stateId) {
			this.stateId = stateId;
		}

		/**
		 * Gets the state id.
		 * 
		 * @return the state id
		 */
		public String getStateId() {
			return stateId;
		}

	}

	/** The object state. */
	private ObjectStateEnum objectState;

	/**
	 * Instantiates a new object state.
	 * 
	 * @param pObjectState
	 *            the object state
	 */
	public ObjectState(ObjectStateEnum pObjectState) {
		super();
		objectState = pObjectState;
	}

	/**
	 * Gets the object state.
	 * 
	 * @return the object state
	 */
	public ObjectStateEnum getObjectState() {
		return objectState;
	}

	/**
	 * Checks if is new.
	 * 
	 * @return true, if is new
	 */
	public boolean isNew() {
		return objectState != null && objectState.equals(ObjectStateEnum.NEW);
	}

	/**
	 * Checks if is updated.
	 * 
	 * @return true, if is updated
	 */
	public boolean isUpdated() {
		return objectState != null
				&& objectState.equals(ObjectStateEnum.UPDATED);
	}

	/**
	 * Sets the object state.
	 * 
	 * @param pObjectState
	 *            the new object state
	 */
	public void setObjectState(ObjectStateEnum pObjectState) {
		objectState = pObjectState;
	}

	/**
	 * Sets the updated.
	 * 
	 */
	public void setUpdated() {
		objectState = ObjectStateEnum.UPDATED;
	}

}
