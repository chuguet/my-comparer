/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.redirection.conversor.impl;

import java.math.BigInteger;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;

/**
 * The Class UrlBookmakerEuConversor.
 */
@Component
public class UrlBookmakerEuConversor extends AbstractBookmakerEuDecorator {

	/** {@inheritDoc} */
	@Override
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.BOOKMAKER_EU_ID.objectId();
		result = id.toString();
		return result;
	}

}
