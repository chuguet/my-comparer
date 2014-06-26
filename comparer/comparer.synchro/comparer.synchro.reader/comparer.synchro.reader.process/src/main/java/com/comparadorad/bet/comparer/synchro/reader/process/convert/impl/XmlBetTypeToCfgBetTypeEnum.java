package com.comparadorad.bet.comparer.synchro.reader.process.convert.impl;

import java.math.BigInteger;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;

public enum XmlBetTypeToCfgBetTypeEnum {
	
	DEFAULT(null), PINNACLE(CfgBookmaker.CfgBookmakerId.PINNACLESPORTS_COM_ID
			.objectId()), NORDICBET(
			CfgBookmaker.CfgBookmakerId.NORDICBET_COM_ID.objectId()), TRIOBET(
			CfgBookmaker.CfgBookmakerId.TRIOBET_COM_ID.objectId());
	
	private BigInteger bookmakerId;
	
	private XmlBetTypeToCfgBetTypeEnum( BigInteger pBookmakerId ){
		bookmakerId = pBookmakerId;		
	}

	public BigInteger getBookmakerId() {
		return bookmakerId;
	}

	public void setBookmakerId(BigInteger pBookmakerId) {
		bookmakerId = pBookmakerId;
	}
	
	

}
