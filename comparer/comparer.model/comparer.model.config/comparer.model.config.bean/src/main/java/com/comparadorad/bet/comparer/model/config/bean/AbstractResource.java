/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.config.bean.CfgResource;

/**
 * The Class AbstractResource.
 */
public class AbstractResource {

	/** The resources. */
	@DBRef
	private CfgResource resource;

	/** The size. */
	@Field
	private Size size;

	/**
	 * Gets the resources.
	 * 
	 * @return the resources
	 */
	public CfgResource getResource() {
		return resource;
	}

	/**
	 * Gets the size.
	 * 
	 * @return the size
	 */
	public Size getSize() {
		return size;
	}

	/**
	 * Sets the resources.
	 * 
	 * @param pResources
	 *            the new resources
	 */
	public void setResources(CfgResource pResource) {
		resource = pResource;
	}

	/**
	 * Sets the size.
	 * 
	 * @param pSize
	 *            the new size
	 */
	public void setSize(Size pSize) {
		size = pSize;
	}

}
