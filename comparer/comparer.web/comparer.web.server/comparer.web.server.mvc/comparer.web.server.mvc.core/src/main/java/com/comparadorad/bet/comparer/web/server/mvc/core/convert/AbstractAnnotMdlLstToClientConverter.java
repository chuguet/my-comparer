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
 * 
 * Converter for multiple elements elements, using the dozer annotations
 * converter.
 * 
 * Must be implemented with a class for creation of elements
 * 
 * http://dozer.sourceforge.net/
 * 
 * The Class AbstractAnnotMdlLstToClientConverter.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 * @param <B>
 *            the generic type
 */
public abstract class AbstractAnnotMdlLstToClientConverter<T extends IClientTo, I extends IModel, B extends IClientTo>
		extends AbstractAnnotConverter<B> implements
		IModelListToToClientConverter<T, I> {

}
