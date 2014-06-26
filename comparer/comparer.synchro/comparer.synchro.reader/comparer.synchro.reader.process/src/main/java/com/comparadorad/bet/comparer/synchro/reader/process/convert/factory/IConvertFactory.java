/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.process.convert.factory;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.process.convert.factory.bean.ConvertFactoryBean;

/**
 * The Interface IConvertFactory.
 */
@Component
public interface IConvertFactory {

	/**
	 * Gets the bet type instance.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @param convertFactoryBean
	 *            the convert factory bean
	 * @return the bet type instance
	 */
	Object getBetTypeInstance(CfgBookmaker bookmaker,
			ConvertFactoryBean convertFactoryBean);

}
