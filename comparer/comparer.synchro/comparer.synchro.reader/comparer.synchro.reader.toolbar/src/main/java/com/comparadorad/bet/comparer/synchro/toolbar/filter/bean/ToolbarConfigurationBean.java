/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.toolbar.filter.bean;

/**
 * The Class ToolbarConfigurationBean.
 */
public class ToolbarConfigurationBean {
	
	/** The memory max element. */
	private Integer memoryMaxElement;

	/**
	 * Instantiates a new toolbar configuration bean.
	 *
	 * @param memoryMaxElement the memory max element
	 */
	public ToolbarConfigurationBean(Integer memoryMaxElement) {
		super();
		this.memoryMaxElement = memoryMaxElement;
	}

	/**
	 * Gets the memory max element.
	 *
	 * @return the memory max element
	 */
	public final Integer getMemoryMaxElement() {
		return memoryMaxElement;
	}

	/**
	 * Sets the memory max element.
	 *
	 * @param memoryMaxElement the new memory max element
	 */
	public final void setMemoryMaxElement(Integer memoryMaxElement) {
		this.memoryMaxElement = memoryMaxElement;
	}	

}
