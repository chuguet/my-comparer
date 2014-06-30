/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.securebet.process.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.util.commons.path.TargetPathUtil;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class AbstractWriterXML.
 *
 * @param <T> the generic type
 */
public abstract class AbstractWriterXML<T extends List<? extends Object>> {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractWriterXML.class);
	
	/**
	 * Checks if is extended.
	 *
	 * @return true, if is extended
	 */
	protected abstract boolean isExtended();
	
	/**
	 * Make object.
	 *
	 * @return the t
	 */
	protected abstract T makeObject();
	
	/**
	 * Make.
	 */
	@Test
	public void make() {
		Object object = makeObject();
		XStreamUtil.writeObject(object, pathFile(object));
	}
	
	/**
	 * Path file.
	 *
	 * @param pObject the object
	 * @return the string
	 */
	protected String pathFile(Object pObject) {
		return TargetPathUtil.getDbReadpathFile(pObject, isExtended(),
				this.getClass());
	}

}
