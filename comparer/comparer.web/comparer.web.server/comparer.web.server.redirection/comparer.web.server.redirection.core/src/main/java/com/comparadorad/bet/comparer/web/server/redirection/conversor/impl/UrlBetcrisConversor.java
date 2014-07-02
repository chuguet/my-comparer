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
 * The Class UrlBetcrisConversor.
 */
@Component
public class UrlBetcrisConversor extends AbstractBookmakerEuDecorator {

	/** {@inheritDoc} */
	@Override
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.BETCRIS_COM_ID.objectId();
		result = id.toString();
		return result;
	}

}
