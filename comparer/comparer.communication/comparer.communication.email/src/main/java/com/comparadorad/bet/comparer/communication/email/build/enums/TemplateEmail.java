package com.comparadorad.bet.comparer.communication.email.build.enums;

public enum TemplateEmail {

	VALUEBET("valueBetReport.jrxml"), SUREBET("sureBetReport.jrxml") ;

	private String name;

	private TemplateEmail(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
