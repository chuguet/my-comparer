/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.core.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.comparadorad.bet.comparer.model.core.bean.IDocument;
import com.comparadorad.bet.comparer.util.commons.path.TargetPathUtil;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class AbstractWriterXML.
 * 
 * @param <T>
 *            the generic type
 * 
 *            Extends IDocument because ONLY can write object of type IDocument,
 *            not change
 */
public abstract class AbstractWriterXML<T extends List<? extends IDocument>> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractWriterXML.class);

	/** The Constant WRITER_APP_USER. */
	public static final String WRITER_APP_USER = "WRITER_APP";

	/**
	 * Gets the writer app user.
	 * 
	 * @return the writer app user
	 */
	protected String getWriterAppUser() {
		return WRITER_APP_USER;
	}

	/**
	 * Gets the writer app user.
	 * 
	 * @param date
	 *            the date
	 * @return the writer app user
	 */
	protected Date getWriterAppDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended
	 */
	protected abstract boolean isExtended();

	/**
	 * Make.
	 */
	public void make() {
		Object object = makeObject();
		XStreamUtil.writeObject(object, pathFile(object));
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
		return TargetPathUtil.getDbReadpathFile(pObject, isExtended(),
				this.getClass());
	}

	/**
	 * Test make.
	 */
	@Test
	public final void testMake() {
		make();
	}

}
