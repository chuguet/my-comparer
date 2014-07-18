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

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ExternalLinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.LinkTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ValueTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;

/**
 * The Class TableResponseCellTo.
 */
public class TableResponseCellTo {

	/** The external link to. */
	private ExternalLinkTo externalLinkTo;

	/** The external link to list. */
	private List<ExternalLinkTo> externalLinkToList;

	/** The id. */
	private ObjectToId id;

	/** The link to. */
	private LinkTo linkTo;

	/** The resources. */
	private List<ResourceTo> resources;

	/** The id. */
	private transient ObjectToId rowObjectToid;

	/** The value. */
	private ValueTo valueTo;

	/**
	 * Instantiates a new field.
	 * 
	 */
	public TableResponseCellTo() {
		super();
	}

	/**
	 * Instantiates a new field.
	 * 
	 * @param resources
	 *            the resources
	 */
	public TableResponseCellTo(List<ResourceTo> resources) {
		super();
		this.resources = resources;
	}

	/**
	 * Instantiates a new field.
	 * 
	 * @param id
	 *            the id
	 * @param value
	 *            the value
	 */
	public TableResponseCellTo(ObjectToId id, ValueTo value) {
		super();
		this.id = id;
		this.valueTo = value;
	}

	/**
	 * Instantiates a new field.
	 * 
	 * @param value
	 *            the value
	 */
	public TableResponseCellTo(ValueTo value) {
		super();
		this.valueTo = value;
	}

	/**
	 * Adds the.
	 * 
	 * @param pResource
	 *            the resource
	 */
	public void add(ResourceTo pResource) {
		if (resources == null) {
			resources = new ArrayList<ResourceTo>();
		}
		resources.add(pResource);

	}

	/* (non-Javadoc)
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
		TableResponseCellTo other = (TableResponseCellTo) obj;
		if (externalLinkTo == null) {
			if (other.externalLinkTo != null)
				return false;
		} else if (!externalLinkTo.equals(other.externalLinkTo))
			return false;
		if (externalLinkToList == null) {
			if (other.externalLinkToList != null)
				return false;
		} else if (!externalLinkToList.equals(other.externalLinkToList))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (linkTo == null) {
			if (other.linkTo != null)
				return false;
		} else if (!linkTo.equals(other.linkTo))
			return false;
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		if (rowObjectToid == null) {
			if (other.rowObjectToid != null)
				return false;
		} else if (!rowObjectToid.equals(other.rowObjectToid))
			return false;
		if (valueTo == null) {
			if (other.valueTo != null)
				return false;
		} else if (!valueTo.equals(other.valueTo))
			return false;
		return true;
	}

	/**
	 * Gets the external link to.
	 * 
	 * @return the external link to
	 */
	public ExternalLinkTo getExternalLinkTo() {
		return externalLinkTo;
	}

	/**
	 * Gets the external link to list.
	 * 
	 * @return the external link to list
	 */
	public List<ExternalLinkTo> getExternalLinkToList() {
		return externalLinkToList;
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
	 * Gets the link to.
	 * 
	 * @return the link to
	 */
	public LinkTo getLinkTo() {
		return linkTo;
	}

	/**
	 * Gets the resources.
	 * 
	 * @return the resources
	 */
	public List<ResourceTo> getResources() {
		return resources;
	}

	/**
	 * Gets the row object toid.
	 * 
	 * @return the row object toid
	 */
	public ObjectToId getRowObjectToid() {
		return rowObjectToid;
	}

	/**
	 * Gets the value to.
	 * 
	 * @return the value to
	 */
	public ValueTo getValueTo() {
		return valueTo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((externalLinkTo == null) ? 0 : externalLinkTo.hashCode());
		result = prime
				* result
				+ ((externalLinkToList == null) ? 0 : externalLinkToList
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((linkTo == null) ? 0 : linkTo.hashCode());
		result = prime * result
				+ ((resources == null) ? 0 : resources.hashCode());
		result = prime * result
				+ ((rowObjectToid == null) ? 0 : rowObjectToid.hashCode());
		result = prime * result + ((valueTo == null) ? 0 : valueTo.hashCode());
		return result;
	}

	/**
	 * Sets the external link to.
	 * 
	 * @param pExternalLinkTo
	 *            the new external link to
	 */
	public void setExternalLinkTo(ExternalLinkTo pExternalLinkTo) {
		this.externalLinkTo = pExternalLinkTo;
	}

	/**
	 * Sets the external link to list.
	 * 
	 * @param pExternalLinkToList
	 *            the new external link to list
	 */
	public void setExternalLinkToList(List<ExternalLinkTo> pExternalLinkToList) {
		this.externalLinkToList = pExternalLinkToList;
	}

	/**
	 * Sets the id.
	 * 
	 * @param pId
	 *            the new id
	 */
	public void setId(ObjectToId pId) {
		this.id = pId;
	}

	/**
	 * Sets the link to.
	 * 
	 * @param pLinkTo
	 *            the new link to
	 */
	public void setLinkTo(LinkTo pLinkTo) {
		this.linkTo = pLinkTo;
	}

	/**
	 * Sets the resources.
	 * 
	 * @param pResources
	 *            the new resources
	 */
	public void setResources(List<ResourceTo> pResources) {
		this.resources = pResources;
	}

	/**
	 * Sets the row object toid.
	 * 
	 * @param pRowObjectToid
	 *            the new row object toid
	 */
	public void setRowObjectToid(ObjectToId pRowObjectToid) {
		this.rowObjectToid = pRowObjectToid;
	}

	/**
	 * Sets the value str.
	 * 
	 * @param valueStr
	 *            the new value str
	 */
	public void setValueStr(String valueStr) {
		if (valueTo != null) {
			valueTo.setValueStr(valueStr);
		}
	}

	/**
	 * Sets the value.
	 * 
	 * @param pValue
	 *            the new value
	 */
	public void setValueTo(ValueTo pValue) {
		this.valueTo = pValue;
	}

}
