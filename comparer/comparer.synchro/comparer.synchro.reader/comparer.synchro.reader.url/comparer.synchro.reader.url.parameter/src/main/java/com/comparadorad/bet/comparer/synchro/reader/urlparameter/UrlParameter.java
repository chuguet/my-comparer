/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.urlparameter;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.urlparameter.exception.UrlParameterException;

/**
 * The Interface UrlParameter.
 */
public interface UrlParameter {
	
	
	/**
	 * Read parameter.
	 *
	 * @param xmlMatch the xml match
	 * @param bookmaker the bookmaker
	 */
	void readParameter(XmlMatch xmlMatch, CfgBookmaker bookmaker) throws UrlParameterException;

}
