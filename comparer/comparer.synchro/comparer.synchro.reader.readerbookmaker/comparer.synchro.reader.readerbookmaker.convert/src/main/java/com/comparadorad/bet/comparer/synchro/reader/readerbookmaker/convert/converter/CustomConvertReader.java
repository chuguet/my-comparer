/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.converter;

import org.dozer.CustomConverter;
import org.dozer.Mapper;

/**
 * The Interface CustomConvertReader.
 */
public interface CustomConvertReader extends CustomConverter {

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Gets the mapper.
	 * 
	 * @return the mapper
	 */
	Mapper getMapper();

	/**
	 * Sets the mapper.
	 * 
	 * @param mapper
	 *            the new mapper
	 */
	void setMapper(Mapper mapper);

}
