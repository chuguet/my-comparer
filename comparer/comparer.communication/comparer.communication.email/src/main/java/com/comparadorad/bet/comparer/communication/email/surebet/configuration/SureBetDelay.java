/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.surebet.configuration;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.securebet.bean.CfgSureBet;
import com.comparadorad.bet.comparer.model.securebet.service.CfgSureBetService;

/**
 * The Class SureBetDelay.
 */
@Component
@Scope(value = "singleton")
public class SureBetDelay {
	
//	/** The sure bet config service. */
//	@Inject
//	private SureBetConfigService sureBetConfigService;
	
	private static final String SEPARATOR = " ";
	
	private static final String ALL = "*";
	
	private static final String DIVISOR = "/";
	
	/**
	 * Gets the delay type zero.
	 *
	 * @return the delay type zero
	 */
	public String getDelayTypeZero(){
//		StringBuilder builder = new StringBuilder();
//		builder.append(ALL);
//		builder.append(SEPARATOR);
//		builder.append(ALL);
//		builder.append(DIVISOR);
//		builder.append(getSureBetConfig().getRetardoTipo0());
		return "* * * * * *";
	}
	
	/**
	 * Gets the delay type one.
	 *
	 * @return the delay type one
	 */
	public Integer getDelayTypeOne(){
		return getSureBetConfig().getRetardoTipo1();
	}
	
	/**
	 * Gets the delay type two.
	 *
	 * @return the delay type two
	 */
	public Integer getDelayTypeTwo(){
		return getSureBetConfig().getRetardoTipo1();
	}
	
	/**
	 * Gets the delay type three.
	 *
	 * @return the delay type three
	 */
	public Integer getDelayTypeThree(){
		return getSureBetConfig().getRetardoTipo3();
	}
	
	
	/**
	 * Gets the sure bet config.
	 *
	 * @return the sure bet config
	 */
	private CfgSureBet getSureBetConfig(){
		CfgSureBet betConfig = new CfgSureBet();
//		Iterable<SureBetConfig> sureBetConfigs = sureBetConfigService.findAll();
//		for (SureBetConfig sureBetConfig : sureBetConfigs) {
//			betConfig = sureBetConfig;
//		}
		return betConfig;
	}
	
	

}
