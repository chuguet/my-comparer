/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import java.util.Iterator;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtWebUrl;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlUrl;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;

/**
 * The Class XmlXmlUrlToWebUrl.
 */
@Component
public class XmlXmlUrlToWebUrl extends AbstractCustomConvertProcess implements CustomConvertProcess {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.CustomConverter#convert(java.lang.Object,
	 * java.lang.Object, java.lang.Class, java.lang.Class)
	 */
	@Override
	public Object convert(Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
		RtWebUrl result = null;

		if (sourceFieldValue instanceof XmlUrl) {
			XmlUrl xmlUrl = (XmlUrl) sourceFieldValue;
			if (StringUtils.isNotEmpty(xmlUrl.getUrl())) {
				result = new RtWebUrl();
				result.setUrl(StringEscapeUtils.escapeHtml(xmlUrl.getUrl()));
				result.setCoreActiveElement(new CoreActiveElement(true));

			} else {
				result = generateUrl();
			}

		} else {
			result = generateUrl();

		}

		return result;
	}

	/**
	 * Método que genera la url a partir de la información contenida en la
	 * configuración del bookmaker porque no ha sido capaz de resolverla a
	 * partir del XmlBet que llega del reader.
	 * 
	 * @return la url generada.
	 */
	private RtWebUrl generateUrl() {
		RtWebUrl result = new RtWebUrl();
		Iterator<CfgBookmakerWebUrl> itWebUrl = getCfgBookmaker().getBookmakerConfiguration().getBookmakerWebUrl().iterator();
		CfgBookmakerWebUrl cfgBookmakerWebUrl;

		cfgBookmakerWebUrl = itWebUrl.next();
		result = new RtWebUrl();
		result.setUrl(cfgBookmakerWebUrl.getUrl());
		result.setCoreActiveElement(new CoreActiveElement(true));
		result.setNameId(getCfgBookmaker().getNameId());
		result.setObjectId(getCfgBookmaker().getObjectId());

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.synchro.reader.process.convert.
	 * CustomConvertProcess#getName()
	 */
	@Override
	public String getName() {
		return "xmlXmlUrlToWebUrl";
	}

}
