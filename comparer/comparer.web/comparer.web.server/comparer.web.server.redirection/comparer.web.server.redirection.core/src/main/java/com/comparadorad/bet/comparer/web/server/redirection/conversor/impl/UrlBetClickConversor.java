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
 * The Class UrlBetClickConversor.
 */
@Component
public class UrlBetClickConversor extends AbstractBetClickDecorator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.web.server.redirection.conversor.IUrlConversor
	 * #getName()
	 */
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.BETCLIC_COM_ID.objectId();
		result = id.toString();
		return result;
	}

}