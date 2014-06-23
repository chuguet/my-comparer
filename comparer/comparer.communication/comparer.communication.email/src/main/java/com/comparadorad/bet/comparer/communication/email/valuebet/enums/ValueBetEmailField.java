package com.comparadorad.bet.comparer.communication.email.valuebet.enums;


public enum ValueBetEmailField {
	
	SUBTITLE("subtitle"),TITLE("title"),CONTACT("contact");
	
	private String nameId;
	
	private ValueBetEmailField(String nameId){
		this.nameId = nameId;
	}

	public String getNameId() {
		return nameId;
	}
	

}
