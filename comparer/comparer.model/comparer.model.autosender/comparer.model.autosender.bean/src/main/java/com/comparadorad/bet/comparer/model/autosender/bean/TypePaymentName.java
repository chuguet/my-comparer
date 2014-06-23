package com.comparadorad.bet.comparer.model.autosender.bean;

public enum TypePaymentName {

	NIVEL_1_1_MONTH("NIVEL_1_1_MONTH", 30), NIVEL_1_6_MONTH("NIVEL_1_1_MONTH",
			180), NIVEL_1_12_MONTH("NIVEL_1_1_MONTH", 360), NIVEL_2_1_MONTH(
			"NIVEL_2_1_MONTH", 30), NIVEL_2_6_MONTH("NIVEL_2_6_MONTH", 180), NIVEL_2_12_MONTH(
			"NIVEL_2_12_MONTH", 360), NIVEL_3_1_MONTH("NIVEL_3_1_MONTH", 30), NIVEL_3_6_MONTH(
			"NIVEL_3_6_MONTH", 180), NIVEL_3_12_MONTH("NIVEL_3_12_MONTH", 360), PROMOTION(
			"PROMOTION", 90);

	private String name;

	private Integer duration;

	private TypePaymentName(String name, Integer duration) {
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public Integer getDuration() {
		return duration;
	}

}
