/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.imageslider.factory;



import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.web.server.mvc.imageslider.table.IMakeTableImageSlider;

/**
 * A factory for creating IObjectResponse objects.
 */
public interface IObjectResponseFactory {

	/**
	 * Make table competition.
	 * 
	 * @param cfgBetType
	 *            the cfg bet type
	 * @param informationWindow
	 *            the information window
	 * @return the i make table competition
	 */
	IMakeTableImageSlider makeTableImageSlider(CfgBetType cfgBetType);

}
