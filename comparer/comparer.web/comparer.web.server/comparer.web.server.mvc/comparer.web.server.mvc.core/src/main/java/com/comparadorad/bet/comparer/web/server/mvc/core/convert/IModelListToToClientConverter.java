/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.core.convert;

import com.comparadorad.bet.comparer.model.core.bean.IModel;
import com.comparadorad.bet.comparer.web.client.gwt.core.bean.IClientTo;

/**
 * The Interface IModelListToToClientConverter.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
public interface IModelListToToClientConverter<T extends IClientTo, I extends IModel> {
	/**
	 * Convert.
	 * 
	 * @param pIModel
	 *            the i model
	 * @return the i client to
	 */
	T convert(Iterable<?> pIModel);
}
