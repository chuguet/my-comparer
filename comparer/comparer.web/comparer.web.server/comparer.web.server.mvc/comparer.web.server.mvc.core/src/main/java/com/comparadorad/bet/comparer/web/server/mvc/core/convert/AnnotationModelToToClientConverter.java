/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.convert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.comparadorad.bet.comparer.model.core.bean.IModel;
import com.comparadorad.bet.comparer.web.client.gwt.core.bean.IClientTo;

/**
 * 
 * Converter for single elements, using the dozer annotations converter.
 * 
 * http://dozer.sourceforge.net/
 * 
 * The Class AnnotationModelToToClientConverter.
 * 
 * 
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
public abstract class AnnotationModelToToClientConverter<T extends IClientTo, I extends IModel>
		extends AbstractAnnotConverter<T> implements
		IModelToToClientConverter<T, I> {

	/** {@inheritDoc} */
	@Override
	public T convert(I pUser) {
		T result = map(pUser, (Class<T>) obtainTypeClass());
		return result;
	}

	/**
	 * Obtain type class.
	 * 
	 * @return the class
	 */
	private Class<?> obtainTypeClass() {
		Type type;
		ParameterizedType superclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		type = superclass.getActualTypeArguments()[0];
		return (Class<?>) type;
	}
}
