/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.client.gwt.common.bean;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.response.ResourceTo;

/**
 * The Class Breadcrumb.
 */
public class BreadcrumbTo {

	/** The name. */
	private String name;

	/** The object to id. */
	private ObjectToId objectToId;

	/** The order. */
	private Integer order;

	/** The url. */
	private ResourceTo resource;

	/**
	 * Instantiates a new breadcrumb.
	 */
	public BreadcrumbTo() {
		super();
	}

	/**
	 * Instantiates a new breadcrumb.
	 * 
	 * @param name
	 *            the name
	 * @param resource
	 *            the resource
	 */
	public BreadcrumbTo(String name, ResourceTo resource) {
		super();
		this.name = name;
		this.resource = resource;
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
	 * Gets the order.
	 * 
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * Gets the resource.
	 * 
	 * @return the resource
	 */
	public ResourceTo getResource() {
		return resource;
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
	 * @param objectToId
	 *            the new object to id
	 */
	public void setObjectToId(ObjectToId objectToId) {
		this.objectToId = objectToId;
	}

	/**
	 * Sets the order.
	 * 
	 * @param pOrder
	 *            the new order
	 */
	public void setOrder(Integer pOrder) {
		order = pOrder;
	}

	/**
	 * Sets the resource.
	 * 
	 * @param pResource
	 *            the new resource
	 */
	public void setResource(ResourceTo pResource) {
		resource = pResource;
	}

}
