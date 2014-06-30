/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.commons.path;

import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.util.commons.date.DateFormatUtil;

/**
 * The Class TargetPathUtil.
 */
public final class TargetPathUtil {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(TargetPathUtil.class);

	/**
	 * Gets the db readpath file.
	 * 
	 * @param pObject
	 *            the object
	 * @param isExtended
	 *            the is extended
	 * @param addDate
	 *            the add date
	 * @param targetProjectClass
	 *            the target project class
	 * @return the db readpath file
	 */
	public static String getDbReadpathFile(Object pObject, boolean isExtended,
			boolean addDate, final String chainToAdd,
			Class<?> targetProjectClass) {
		String pathName = null;
		StringBuffer pathN = new StringBuffer();
		URL path = targetProjectClass.getResource(targetProjectClass
				.getSimpleName() + ".class");
		LOG.debug(pObject);
		if (pObject instanceof List) {
			if (((List) pObject).size() > 0) {
				String className = ((List) pObject).get(0).getClass()
						.getSimpleName();
				LOG.debug(path.getPath());
				if (path.getPath().contains("target")) {
					pathName = path.getPath().substring(0,
							path.getPath().indexOf("target"));
				} else if (path.getPath().contains(".instr")) {
					pathName = path.getPath().substring(0,
							path.getPath().indexOf(".instr"));
				} else {
					pathName = "/tmp/";
				}
				pathN.append(pathName);
				pathN.append("target/generated-xml/");
				pathN.append(getFileName(className, isExtended, addDate,
						chainToAdd));
				pathN.append(".dbread.xml");
				// pathName = pathName + "/target/generated-xml/"
				// + getFileName(className) + ".dbread.xml";
			}
		}
		return pathN.toString();
	}

	/**
	 * Gets the db readpath file.
	 * 
	 * @param pObject
	 *            the object
	 * @param isExtended
	 *            the is extended
	 * @param targetProjectClass
	 *            the target project class
	 * @return the db readpath file
	 */
	public static String getDbReadpathFile(Object pObject, boolean isExtended,
			Class<?> targetProjectClass) {
		return getDbReadpathFile(pObject, isExtended, false, null,
				targetProjectClass);
	}

	/**
	 * Gets the file name.
	 * 
	 * @param className
	 *            the class name
	 * @param isExtended
	 *            the is extended
	 * @param addDate
	 *            the add date
	 * @return the file name
	 */
	private static String getFileName(String className, boolean isExtended,
			boolean addDate, final String chainToAdd) {
		StringBuffer result = new StringBuffer();
		result.append(className);
		if (isExtended) {
			result.append(".extended");
		}
		if (chainToAdd != null) {
			result.append(".").append(chainToAdd);
		}
		if (addDate) {
			result.append(".");
			result.append(DateFormatUtil.getInstance(
					DateFormatUtil.FILENAME_FORMAT).format(new Date()));
		}
		return result.toString();
	}

	/**
	 * Instantiates a new target path util.
	 */
	private TargetPathUtil() {
		super();
	}
}
