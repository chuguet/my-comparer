package com.comparadorad.bet.comparer.synchro.reader.filter.bean;

public class FilterConfigurationBean {
	
	public FilterConfigurationBean(Integer memoryMaxElement) {
		super();
		this.memoryMaxElement = memoryMaxElement;
	}

	private Integer memoryMaxElement;

	public final Integer getMemoryMaxElement() {
		return memoryMaxElement;
	}

	public final void setMemoryMaxElement(Integer memoryMaxElement) {
		this.memoryMaxElement = memoryMaxElement;
	}	

}
