/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.xml.know.impl;

import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXmlData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.AbstractExistData;
import com.comparadorad.bet.comparer.synchro.reader.process.xml.know.bean.ExistData;

/**
 * The Interface IExistRTData.
 * 
 * @param <T>
 *            the generic type
 * @param <I>
 *            the generic type
 */
@SuppressWarnings("rawtypes")
public interface IExistRtData<T extends AbstractXmlData, I extends AbstractExistData> {

	/**
	 * Exist.
	 * 
	 * @param t
	 *            the t
	 * @param existRtDataData
	 *            the exist rt data data
	 * @return the t
	 */
	public I exist(T t, ExistData existRtDataData);

}
