/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.RtWebUrl;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWebUrl;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.CustomConvertProcess;
import com.comparadorad.bet.comparer.synchro.reader.process.synonyms.ISynonymsComponent;

/**
 * The Class XmlWebUrlToRtWebUrl.
 * Transforma la url leida del xml a una url grabable en BD
 */
@Component
public class XmlWebUrlToRtWebUrl extends
		AbstractCustomConvertProcess implements CustomConvertProcess {

	/** The synonyms component. */
	@Inject
	private ISynonymsComponent synonymsComponent;

	/** {@inheritDoc} */
	@Override
	public Object convert(Object targetObject, Object sourceObject,
			Class<?> pArg2, Class<?> pArg3) {
		Set<RtWebUrl> result = new HashSet<RtWebUrl>();
		XmlWebUrl xmlWebUrl;
		if (sourceObject instanceof XmlWebUrl) {
			xmlWebUrl = (XmlWebUrl) sourceObject;
			RtWebUrl webUrl = new RtWebUrl();
			//Si tenemos en el xml una url la guardamos.
			if (StringUtils.isNotEmpty(xmlWebUrl.getUrl())) {
				webUrl.setUrl(StringEscapeUtils.escapeHtml(xmlWebUrl.getUrl()));
				result.add(webUrl);
			} else {
				Iterator<CfgBookmakerWebUrl> itWebUrl = getCfgBookmaker().getBookmakerConfiguration().getBookmakerWebUrl().iterator();
				CfgBookmakerWebUrl cfgBookmakerWebUrl;
				while (itWebUrl.hasNext()) {
					cfgBookmakerWebUrl = itWebUrl.next();
					webUrl = new RtWebUrl();
					webUrl.setUrl(StringEscapeUtils.escapeHtml(cfgBookmakerWebUrl.getUrl()));
					result.add(webUrl);
				}
			}
		}
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public String getName() {
		return "xmlWebUrlToRtWebUrl";
	}

}
