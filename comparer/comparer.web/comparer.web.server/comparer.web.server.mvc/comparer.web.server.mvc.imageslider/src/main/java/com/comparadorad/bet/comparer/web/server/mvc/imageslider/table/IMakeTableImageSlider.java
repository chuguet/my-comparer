/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.imageslider.table;

import com.comparadorad.bet.comparer.model.bet.bean.CfgImageSlider;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.imageslider.bean.response.ImageSliderUpdateResponseTo;

/**
 * The Interface IMakeTableImageSlider.
 */
public interface IMakeTableImageSlider {

	
	/**
	 * Gets the bet type id.
	 *
	 * @return the bet type id
	 */
	CfgBetType.CfgBetTypeId getBetTypeId();

	
	
	/**
	 * Make table.
	 *
	 * @param view the view
	 * @param userData the user data
	 * @return the image slider response to
	 */
	ImageSliderResponseTo makeTable(CfgImageSlider view,UserData userData);
	
	
	
	/**
	 * Make table update.
	 *
	 * @param view the view
	 * @param userData the user data
	 * @return the image slider update response to
	 */
	ImageSliderUpdateResponseTo makeTableUpdate(CfgImageSlider view, UserData userData);

}
