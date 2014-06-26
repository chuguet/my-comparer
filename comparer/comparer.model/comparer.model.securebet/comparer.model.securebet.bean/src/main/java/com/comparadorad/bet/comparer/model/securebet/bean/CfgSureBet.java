/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.bean;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Class SureBetConfig.
 */
@SuppressWarnings("serial")
public class CfgSureBet implements ISecureBeanData {

	/** The max benefit. */
	@NotNull
	@Field
	private SecureBeanBenefit maxBenefit;

	/** The min benefit. */
	@NotNull
	@Field
	private SecureBeanBenefit minBenefit;

	/** The porcentaje minimo. */
	@NotNull
	@Field
	private Float porcentajeMinimo;

	/** The retardo tipo0. */
	@NotNull
	@Field
	private Integer retardoTipo0;

	/** The retardo tipo1. */
	@NotNull
	@Field
	private Integer retardoTipo1;

	/** The retardo tipo2. */
	@NotNull
	@Field
	private Integer retardoTipo2;

	/** The retardo tipo3. */
	@NotNull
	@Field
	private Integer retardoTipo3;

	/**
	 * Gets the max benefit.
	 *
	 * @return the max benefit
	 */
	public SecureBeanBenefit getMaxBenefit() {
		return maxBenefit;
	}

	/**
	 * Gets the porcentaje minimo.
	 * 
	 * @return the porcentaje minimo
	 */
	public Float getPorcentajeMinimo() {
		return porcentajeMinimo;
	}

	/**
	 * Gets the retardo tipo0.
	 * 
	 * @return the retardo tipo0
	 */
	public Integer getRetardoTipo0() {
		return retardoTipo0;
	}

	/**
	 * Gets the retardo tipo1.
	 * 
	 * @return the retardo tipo1
	 */
	public Integer getRetardoTipo1() {
		return retardoTipo1;
	}

	/**
	 * Gets the retardo tipo2.
	 * 
	 * @return the retardo tipo2
	 */
	public Integer getRetardoTipo2() {
		return retardoTipo2;
	}

	/**
	 * Gets the retardo tipo3.
	 * 
	 * @return the retardo tipo3
	 */
	public Integer getRetardoTipo3() {
		return retardoTipo3;
	}

	/**
	 * Sets the max benefit.
	 *
	 * @param maxBenefit the new max benefit
	 */
	public void setMaxBenefit(SecureBeanBenefit maxBenefit) {
		this.maxBenefit = maxBenefit;
	}

	/**
	 * Sets the porcentaje minimo.
	 * 
	 * @param porcentajeMinimo
	 *            the new porcentaje minimo
	 */
	public void setPorcentajeMinimo(Float porcentajeMinimo) {
		this.porcentajeMinimo = porcentajeMinimo;
	}

	/**
	 * Sets the retardo tipo0.
	 * 
	 * @param retardoTipo0
	 *            the new retardo tipo0
	 */
	public void setRetardoTipo0(Integer retardoTipo0) {
		this.retardoTipo0 = retardoTipo0;
	}

	/**
	 * Sets the retardo tipo1.
	 * 
	 * @param retardoTipo1
	 *            the new retardo tipo1
	 */
	public void setRetardoTipo1(Integer retardoTipo1) {
		this.retardoTipo1 = retardoTipo1;
	}

	/**
	 * Sets the retardo tipo2.
	 * 
	 * @param retardoTipo2
	 *            the new retardo tipo2
	 */
	public void setRetardoTipo2(Integer retardoTipo2) {
		this.retardoTipo2 = retardoTipo2;
	}

	/**
	 * Sets the retardo tipo3.
	 * 
	 * @param retardoTipo3
	 *            the new retardo tipo3
	 */
	public void setRetardoTipo3(Integer retardoTipo3) {
		this.retardoTipo3 = retardoTipo3;
	}
	
	
	public SecureBeanBenefit getMinBenefit() {
		return minBenefit;
	}

	/**
	 * Sets the min benefit.
	 *
	 * @param minBenefit the new min benefit
	 */
	public void setMinBenefit(SecureBeanBenefit minBenefit) {
		this.minBenefit = minBenefit;
	}
	
}
