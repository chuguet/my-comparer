/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.attributefactory;

import org.springframework.stereotype.Component;

/**
 * A factory for creating IAttribute objects.
 */

public interface IAttributeFactory {
	
	/**
	 * Make attribute.
	 *
	 * @param id the id
	 * @return the i attribute
	 */
	IAttribute makeAttribute(String id);

}
