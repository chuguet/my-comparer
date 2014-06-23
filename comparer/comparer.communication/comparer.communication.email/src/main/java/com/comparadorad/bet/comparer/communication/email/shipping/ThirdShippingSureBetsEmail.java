/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.shipping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.comparadorad.bet.comparer.autosender.getresponse.enume.ListTypeUser;

/**
 * The Class ThirdShippingSureBetsEmail.
 */
@Service
public class ThirdShippingSureBetsEmail extends AbstractShippingSureBetsEmail {

	/**
	 * Gets the campaign id.
	 *
	 * @return the campaign id
	 * {@inheritDoc}
	 */ 
	@Override
	protected List<ListTypeUser> getCampaignId() {
		List<ListTypeUser> result = new ArrayList<ListTypeUser>();
		result.add(ListTypeUser.P_LIM_2);
		result.add(ListTypeUser.P_2_1);
		result.add(ListTypeUser.P_2_6);
		result.add(ListTypeUser.P_2_12);
		return result;
	}

}