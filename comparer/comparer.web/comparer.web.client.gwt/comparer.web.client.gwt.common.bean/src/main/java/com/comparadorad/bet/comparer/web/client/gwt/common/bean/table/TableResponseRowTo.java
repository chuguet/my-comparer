/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean.table;

import java.util.ArrayList;
import java.util.List;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;

/**
 * The Class TableResponseRowTo.
 */
public class TableResponseRowTo {
	
	/** The cellList. */
	private List<TableResponseCellTo> cellList;

	/** The object to id. */
	private ObjectToId objectToId;

	/**
	 * Adds the.
	 * 
	 * @param pField
	 *            the field
	 */
	public void add(TableResponseCellTo pField) {
		if (cellList == null) {
			cellList = new ArrayList<TableResponseCellTo>();
		}
		cellList.add(pField);
	}

	/**
	 * Adds the all.
	 * 
	 * @param pFields
	 *            the fields
	 */
	public void addAll(List<TableResponseCellTo> pFields) {
		if (cellList == null) {
			cellList = new ArrayList<TableResponseCellTo>();
		}
		cellList.addAll(pFields);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableResponseRowTo other = (TableResponseRowTo) obj;
		if (cellList == null) {
			if (other.cellList != null)
				return false;
		} else if (!cellList.equals(other.cellList))
			return false;
		if (objectToId == null) {
			if (other.objectToId != null)
				return false;
		} else if (!objectToId.equals(other.objectToId))
			return false;
		return true;
	}

	/**
	 * Gets the cellList.
	 * 
	 * @return the cellList
	 */
	public List<TableResponseCellTo> getCellList() {
		return cellList;
	}

	/**
	 * Gets the object to id.
	 * 
	 * @return the object to id
	 */
	public ObjectToId getObjectToId() {
		return objectToId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cellList == null) ? 0 : cellList.hashCode());
		result = prime * result
				+ ((objectToId == null) ? 0 : objectToId.hashCode());
		return result;
	}

	/**
	 * Sets the cellList.
	 * 
	 * @param pFields
	 *            the new cellList
	 */
	public void setCellList(List<TableResponseCellTo> pFields) {
		cellList = pFields;
	}

	/**
	 * Sets the id table response cell to.
	 * 
	 * @param cell
	 *            the new id table response cell to
	 */
	public void setIdTableResponseCellTo(TableResponseCellTo cell) {
		// Este metodo se hace para que no falle JSON
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

}
