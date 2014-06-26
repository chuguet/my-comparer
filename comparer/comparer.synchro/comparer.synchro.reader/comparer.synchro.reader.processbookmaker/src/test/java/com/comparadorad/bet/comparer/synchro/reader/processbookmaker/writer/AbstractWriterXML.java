/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.writer;

import java.net.URL;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class AbstractWriterXML.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class AbstractWriterXML<T extends List<? extends Object>> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractWriterXML.class);

	/**
	 * Make.
	 */
	public void make() {
		Object object = makeObject();
		String pathFile = pathFile(object);
		XStreamUtil.writeObject(object, pathFile);
	}

	/**
	 * Make object.
	 * 
	 * @return the object
	 */
	protected abstract T makeObject();

	/**
	 * Path file.
	 * 
	 * @param pObject
	 *            the object
	 * @return the string
	 */
	protected String pathFile(Object pObject) {
		String pathName = null;
		StringBuffer pathN = new StringBuffer();
		URL path = this.getClass().getResource(
				this.getClass().getSimpleName() + ".class");
		LOG.debug(pObject);
		if (pObject instanceof List) {
			if (((List<?>) pObject).size() > 0) {
				String className = ((List<?>) pObject).get(0).getClass()
						.getSimpleName();
				LOG.debug(path.getPath());
				if (path.getPath().contains("target")) {
					pathName = path.getPath().substring(0,
							path.getPath().indexOf("target"));
				} else {
					pathName = path.getPath().substring(0,
							path.getPath().indexOf(".instr"));
				}
				pathN.append(pathName);
				pathN.append("/target/generated-xml/");
				pathN.append(className);
				pathN.append(".dbread.xml");
				// pathName = pathName + "/target/generated-xml/" + className
				// + ".dbread.xml";
			}
		}
		return pathN.toString();
	}

	/**
	 * Test make.
	 */
	@Test
	public final void testMake() {
		make();
	}

}