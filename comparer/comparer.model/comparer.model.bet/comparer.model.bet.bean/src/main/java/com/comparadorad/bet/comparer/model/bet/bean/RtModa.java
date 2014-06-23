/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.bet.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;

/**
 * The Class RtModa.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
@Document
public class RtModa implements IRtData {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1448705060072109261L;

	/**
	 * Gets the serialversionuid.
	 * 
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** The element. */
	@Field
	private CoreDate element;

	/** The matchers. */
	@Field
	private List<RtBookmakerIdWeight> matchers;
	
	/**
	 * Adds the matchers.
	 * 
	 * @param matcher
	 *            the matcher
	 */
	public void addMatchers(RtBookmakerIdWeight matcher) {
		if (matchers == null) {
			matchers = new ArrayList<RtBookmakerIdWeight>();
		}
		matchers.add(matcher);
	}

	/**
	 * Gets the element.
	 * 
	 * @return the element
	 */
	public CoreDate getElement() {
		return element;
	}

	/**
	 * Gets the matchers.
	 * 
	 * @return the matchers
	 */
	public List<RtBookmakerIdWeight> getMatchers() {
		return matchers;
	}

	/**
	 * Sets the element.
	 * 
	 * @param element
	 *            the new element
	 */
	public void setElement(CoreDate element) {
		this.element = element;
	}

	/**
	 * Sets the matchers.
	 * 
	 * @param matchers
	 *            the new matchers
	 */
	public void setMatchers(List<RtBookmakerIdWeight> matchers) {
		this.matchers = matchers;
	}

}
