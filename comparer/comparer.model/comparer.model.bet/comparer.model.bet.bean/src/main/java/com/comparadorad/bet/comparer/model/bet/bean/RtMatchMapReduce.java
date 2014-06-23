package com.comparadorad.bet.comparer.model.bet.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class RtMatchMapReduce {

	@Id
	private String id;

	@Field
	private RtMatch value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public RtMatch getValue() {
		return value;
	}

	public void setValue(RtMatch value) {
		this.value = value;
	}
}
