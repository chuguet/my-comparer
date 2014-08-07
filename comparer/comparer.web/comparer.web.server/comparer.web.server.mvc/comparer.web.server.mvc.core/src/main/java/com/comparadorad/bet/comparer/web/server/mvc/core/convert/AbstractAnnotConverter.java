/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.convert;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.util.DozerConstants;

import com.comparadorad.bet.comparer.web.client.gwt.core.bean.IClientTo;

/**
 * The Class AbstractAnnotConverter.
 * 
 * @param <B>
 *            the generic type
 */
public abstract class AbstractAnnotConverter<B extends IClientTo> {
	/** The mapper. */
	private Mapper mapper;

	/**
	 * Instantiates a new annotation model list to to client converter.
	 */
	public AbstractAnnotConverter() {
		super();
		System.setProperty(DozerConstants.DEBUG_SYS_PROP, "false");
		mapper = new DozerBeanMapper();
	}

	/**
	 * Map.
	 * 
	 * @param objToMap
	 *            the obj to map
	 * @param classToMap
	 *            the class to map
	 * @return the b
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected B map(Object objToMap, Class classToMap) {
		B result = (B) mapper.map(objToMap, classToMap);
		return result;
	}

	/**
	 * Map.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param objToMap
	 *            the obj to map
	 * @param classToMap
	 *            the class to map
	 * @return the t
	 */
	protected <T> T map2(Object objToMap, Class<T> classToMap) {
		T result = mapper.map(objToMap, classToMap);
		return result;
	}
}
