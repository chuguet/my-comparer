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
 * The Class FourthShippingSureBetsEmail.
 */
@Service
public class FourthShippingSureBetsEmail extends AbstractShippingSureBetsEmail {

	/** {@inheritDoc} */ 
	@Override
	protected List<ListTypeUser> getCampaignId() {
		List<ListTypeUser> result = new ArrayList<ListTypeUser>();
		result.add(ListTypeUser.P_LIM_3);
		result.add(ListTypeUser.P_3_1);
		result.add(ListTypeUser.P_3_6);
		result.add(ListTypeUser.P_3_12);
		return result;
	}

}
