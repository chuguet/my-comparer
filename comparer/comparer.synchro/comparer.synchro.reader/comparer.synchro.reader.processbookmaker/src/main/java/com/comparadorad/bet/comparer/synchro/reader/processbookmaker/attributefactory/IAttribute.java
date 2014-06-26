/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.attributefactory;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXMLAttribute;

/**
 * The Interface IAttribute.
 */
public interface IAttribute<T extends AbstractXMLAttribute> {

	/**
	 * Convert.
	 * 
	 * @return the abstract rt attribute
	 */
	AbstractRtAttribute convert(T xmlData);

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	String getName();

}
