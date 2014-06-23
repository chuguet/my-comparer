package com.comparadorad.bet.comparer.communication.email.surebet.enums;

public enum SureBetEmailField {
	
	SUBTITLE("subtitle"),TITLE("title"),CONTACT("contact");
	
	private String nameId;
	
	private SureBetEmailField(String nameId){
		this.nameId = nameId;
	}

	public String getNameId() {
		return nameId;
	}

}
