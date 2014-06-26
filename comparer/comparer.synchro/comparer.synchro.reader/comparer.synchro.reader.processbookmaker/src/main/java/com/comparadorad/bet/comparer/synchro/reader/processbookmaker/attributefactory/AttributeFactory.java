/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.attributefactory;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;


/**
 * A factory for creating Attribute objects.
 */
@Service
public class AttributeFactory extends AbstractAttributeFactory{

	/** The attributes. */
	@Inject
	List<IAttribute> attributes;

	/* (non-Javadoc)
	 * @see com.comparadorad.bet.comparer.synchro.reader.processbookmaker.attributefactory.IAttributeFactory#makeAttribute(java.lang.String)
	 */
	@Override
	public IAttribute makeAttribute(String id) {
		IAttribute result = null;
		for (IAttribute attribute : attributes) {
			if (attribute.getName().equals(id)) {
				result = attribute;
				break;
			}
		}
		return result;
	}

}
