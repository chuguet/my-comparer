/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver;

import com.comparadorad.bet.comparer.model.bet.bean.IRtData;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.resolver.bean.XmlToRtResolverData;

/**
 * The Interface IXmlToRtResolver.
 * 
 * @param <T>
 *            the generic type
 * @param <S>
 *            the generic type
 * @param <I>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
public interface IXmlToRtResolver<T extends IRtData, S extends IRtData, I extends AbstractXmlData> {

	/**
	 * Resolve.
	 * 
	 * @param xmlData
	 *            the xml data
	 * @param rtData
	 *            the rt data
	 * @param xmlToRtResolverData
	 *            the xml to rt resolver data
	 * @return the t
	 */
	T resolve(I xmlData, S rtData, XmlToRtResolverData xmlToRtResolverData);

}
