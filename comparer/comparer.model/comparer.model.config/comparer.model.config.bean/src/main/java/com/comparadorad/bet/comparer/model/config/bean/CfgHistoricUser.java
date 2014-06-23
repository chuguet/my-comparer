package com.comparadorad.bet.comparer.model.config.bean;

import com.comparadorad.bet.comparer.model.core.bean.INameIdEnum;

public enum CfgHistoricUser implements INameIdEnum {
	
	NOT_VERIFIED("NOT_VERIFIED"),
	APP_VERIFIED("APP_VERIFIED"),
	HUMAN_VERIFIED("HUMAN_VERIFIED");
	
	/** The object id. */
	private final String nameId;
	
	

	@Override
	public String nameId() {
		return nameId;
	}
	
	CfgHistoricUser(String nameId) {
		this.nameId = nameId;
	}
	
	

}
