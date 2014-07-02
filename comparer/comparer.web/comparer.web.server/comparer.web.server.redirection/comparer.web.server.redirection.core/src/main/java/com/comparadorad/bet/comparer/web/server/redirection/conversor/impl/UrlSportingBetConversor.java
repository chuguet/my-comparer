package com.comparadorad.bet.comparer.web.server.redirection.conversor.impl;

import java.math.BigInteger;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker.CfgBookmakerId;

public class UrlSportingBetConversor extends
		AbstractSportingBetCentreBetMiapuestaDecorator {

	@Override
	public String getId() {
		String result = "";
		BigInteger id = CfgBookmakerId.SPORTINGBET_ID.objectId();
		result = id.toString();
		return result;
	}

}
