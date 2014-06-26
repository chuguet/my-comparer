/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.AbstractRtAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.AbstractXMLAttribute;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.attributefactory.IAttribute;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.attributefactory.IAttributeFactory;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.CustomConvertProcess;

/**
 * The Class XmlXmlUrlToWebUrl.
 */
@Component
public class XmlAttributeToRtAttribute extends AbstractCustomConvertProcess
		implements CustomConvertProcess {

	@Inject
	private IAttributeFactory factoriaAtributos;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dozer.CustomConverter#convert(java.lang.Object,
	 * java.lang.Object, java.lang.Class, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object existingDestinationFieldValue,
			Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass) {
		AbstractRtAttribute result = null;

		if (sourceFieldValue instanceof AbstractXMLAttribute) {
			AbstractXMLAttribute xmlAttribute = (AbstractXMLAttribute) sourceFieldValue;

			IAttribute conversor = factoriaAtributos.makeAttribute(xmlAttribute
					.getCfgBetTypeId());
			result = conversor.convert(xmlAttribute);
		}

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
		return "xmlAttributeToRtAttribute";
	}

}
