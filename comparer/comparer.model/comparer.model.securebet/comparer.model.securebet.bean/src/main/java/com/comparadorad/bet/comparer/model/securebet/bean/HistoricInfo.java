/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.securebet.bean;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.CoreDate;
import com.comparadorad.bet.comparer.model.core.bean.annotation.CorrectCoreDate;

/**
 * The Class HistoricInfo.
 */
@Document
public class HistoricInfo {
	
	/** The cause. */
	@Field
	private Cause cause;





	/** The create date. */
	@Field
	@CorrectCoreDate
	private CoreDate createDate;
	
	/**
	 * Instantiates a new historic info.
	 *
	 * @param cause the cause
	 * @param createDate the create date
	 */
	public HistoricInfo(Cause cause, CoreDate createDate) {
		super();
		this.cause = cause;
		this.createDate = createDate;
	}
	
	/**
	 * Gets the cause.
	 *
	 * @return the cause
	 */
	public Cause getCause() {
		return cause;
	}

	/**
	 * Sets the cause.
	 *
	 * @param cause the new cause
	 */
	public void setCause(Cause cause) {
		this.cause = cause;
	}

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public CoreDate getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(CoreDate createDate) {
		this.createDate = createDate;
	}
	
	
	/**
	 * The Enum Cause.
	 */
	public enum Cause{
		
		/** The Final de partido. */
		FinalDePartido,
		
		/** The Cambio de cuotas. */
		CambioDeCuotas_SigueSiendoSureBet,
		
		/** The Subida de cuotas. */
		SubidaDeCuotas,
		
		/** The Bajada de cuotas. */
		BajadaDeCuotas_YaNoEsSureBet,
		
		Partido_No_Existe, 
		
		Error_En_Apuesta;
		
		
	}
}
