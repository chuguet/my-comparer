/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlDate;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.CustomConvertProcess;

/**
 * The Class XmlDateToCoreDate.
 */
@Component
public class XmlDateToCoreDate extends AbstractCustomConvertProcess implements
		CustomConvertProcess {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(XmlDateToCoreDate.class);

	/** {@inheritDoc} */
	@Override
	public Object convert(Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3) {
		CoreDate result = new CoreDate();
		if (sourceObject instanceof XmlDate) {
			LOG.debug("Inicio conversion la fecha");
			XmlDate xmlDate = (XmlDate) sourceObject;
			if (xmlDate.getZeroGmtMatchDate() != null) {
				result.setZeroGmtMatchDate(xmlDate.getZeroGmtMatchDate());
			}

			if (xmlDate.getProviderDate() != null) {
				result.setProviderDate(xmlDate.getProviderDate());
			}
			if (xmlDate.getProviderTimeZone() != null) {
				result.setProviderTimeZoneStr(xmlDate.getProviderTimeZoneStr());
			}
		} else {
			LOG.error("No se podido asignar los valores de la fecha");
		}
		LOG.debug("Fin conversion la fecha");
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return "xmlDateToCoreDate";
	}

}
