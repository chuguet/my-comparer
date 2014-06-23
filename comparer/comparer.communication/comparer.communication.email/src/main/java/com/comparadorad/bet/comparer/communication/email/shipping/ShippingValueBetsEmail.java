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

import com.comparadorad.bet.comparer.autosender.core.enume.MessageType;
import com.comparadorad.bet.comparer.autosender.getresponse.enume.ListTypeUser;

/**
 * The Class ShippingValueBetsEmail.
 */
@Service
public class ShippingValueBetsEmail extends AbstractShippingEmail {

	/**
	 * Gets the message type.
	 * 
	 * @return the message type {@inheritDoc}
	 */
	protected MessageType getMessageType() {
		return MessageType.HTML;
	}

	/**
	 * Gets the content.
	 * 
	 * @return the content {@inheritDoc}
	 */
	@Override
	protected String getContent() {
		return "Value Bet";
	}

	 /** {@inheritDoc} */ 
	@Override
	protected List<ListTypeUser> getCampaignId() {
		List<ListTypeUser> result = new ArrayList<ListTypeUser>();
		result.add(ListTypeUser.P_LIM_1);
		result.add(ListTypeUser.P_LIM_2);
		result.add(ListTypeUser.P_LIM_3);
		result.add(ListTypeUser.P_1_1);
		result.add(ListTypeUser.P_1_6);
		result.add(ListTypeUser.P_1_12);
		result.add(ListTypeUser.P_2_1);
		result.add(ListTypeUser.P_2_6);
		result.add(ListTypeUser.P_2_12);
		result.add(ListTypeUser.P_3_1);
		result.add(ListTypeUser.P_3_6);
		result.add(ListTypeUser.P_3_12);
		result.add(ListTypeUser.REF_N_N_ACT);
		return result;
	}

}
