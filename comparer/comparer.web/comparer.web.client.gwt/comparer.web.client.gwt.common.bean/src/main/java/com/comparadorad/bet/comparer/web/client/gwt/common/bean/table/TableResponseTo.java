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
import com.comparadorad.bet.comparer.web.client.gwt.core.bean.AbstractClientToResponse;

/**
 * The Class Table.
 */
public class TableResponseTo extends AbstractClientToResponse {

	/** The objectToId. */
	private ObjectToId objectToId;

	/** The rows. */
	private List<TableResponseRowTo> rows;

	/** The title. */
	private TableResponseRowTitleTo title;

	/**
	 * Adds the.
	 * 
	 * @param pRow
	 *            the row
	 */
	public void add(TableResponseRowTo pRow) {
		if (rows == null) {
			rows = new ArrayList<TableResponseRowTo>();
		}
		rows.add(pRow);
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
		TableResponseTo other = (TableResponseTo) obj;
		if (objectToId == null) {
			if (other.objectToId != null)
				return false;
		} else if (!objectToId.equals(other.objectToId))
			return false;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	/**
	 * Gets the objectToId.
	 * 
	 * @return the objectToId
	 */
	public ObjectToId getObjectToId() {
		return objectToId;
	}

	/**
	 * Gets the rows.
	 * 
	 * @return the rows
	 */
	public List<TableResponseRowTo> getRows() {
		return rows;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public TableResponseRowTitleTo getTitle() {
		return title;
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
				+ ((objectToId == null) ? 0 : objectToId.hashCode());
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * Sets the objectToId.
	 * 
	 * @param pId
	 *            the new objectToId
	 */
	public void setObjectToId(ObjectToId pId) {
		objectToId = pId;
	}

	/**
	 * Sets the rows.
	 * 
	 * @param pRows
	 *            the new rows
	 */
	public void setRows(List<TableResponseRowTo> pRows) {
		rows = pRows;
	}

	/**
	 * Sets the title.
	 * 
	 * @param pTitle
	 *            the new title
	 */
	public void setTitle(TableResponseRowTitleTo pTitle) {
		title = pTitle;
	}
}
