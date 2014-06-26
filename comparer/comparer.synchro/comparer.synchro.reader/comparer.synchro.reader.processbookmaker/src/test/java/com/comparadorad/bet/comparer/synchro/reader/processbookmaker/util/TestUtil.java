/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.util;

import java.io.InputStream;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.util.commons.xstream.XStreamUtil;

/**
 * The Class TestUtil.
 */
public final class TestUtil {

	/**
	 * Read xml match file.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the xml match
	 */
	public XmlMatch readXmlMatchFile(final String fileName) {

		// String file = fileName;
		StringBuffer file = new StringBuffer();

		InputStream input;
		XmlMatch xmlMatch;

		file.append(fileName);
		file.append(".dbread.xml");

		// file = file + ".dbread.xml";
		input = getClass().getResourceAsStream((file.toString()));
		xmlMatch = (XmlMatch) XStreamUtil.fromXML(input);

		return xmlMatch;
	}

}
