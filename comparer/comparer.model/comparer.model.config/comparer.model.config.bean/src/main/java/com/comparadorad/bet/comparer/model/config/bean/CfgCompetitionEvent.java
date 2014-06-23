/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTable;
import com.comparadorad.bet.comparer.model.core.bean.IObjectOrder;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.core.bean.sort.ObjectOrderSort;

/**
 * The Class CfgCompetitionEvent.
 */
@SuppressWarnings("serial")
@Document
public class CfgCompetitionEvent extends AbstractI18nTable implements
		IObjectOrder<CfgCompetitionEvent> {

	/** The cfg competition event agrupation. */
	@DBRef
	private CfgCompetitionEventAgrupation agrupation;

	/** The cfg sport synonyms. */
	@DBRef
	private Set<CfgSportSynonyms> cfgSportSynonyms;

	/** The order. */
	@Field
	private Order order;

	/** The long term. */
	@Field
	@NotNull
	@Valid
	private LongTerm longTerm;

	/**
	 * Compare to.
	 * 
	 * @param pCfgCompetitionEvent
	 *            the cfg competition event
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int compareTo(CfgCompetitionEvent pCfgCompetitionEvent) {
		return ObjectOrderSort.compareTo(this, pCfgCompetitionEvent);
	}

	/**
	 * Gets the long term.
	 * 
	 * @return the long term
	 */
	public LongTerm getLongTerm() {
		return longTerm;
	}

	/**
	 * Sets the long term.
	 * 
	 * @param pLongTerm
	 *            the new long term
	 */
	public void setLongTerm(LongTerm pLongTerm) {
		longTerm = pLongTerm;
	}

	/**
	 * Gets the agrupation.
	 * 
	 * @return the agrupation
	 */
	public CfgCompetitionEventAgrupation getAgrupation() {
		return agrupation;
	}

	/**
	 * Gets the cfg sport synonyms.
	 * 
	 * @return the cfg sport synonyms
	 */
	public Set<CfgSportSynonyms> getCfgSportSynonyms() {
		return cfgSportSynonyms;
	}

	/**
	 * Gets the order.
	 * 
	 * @return the order
	 */
	@Override
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the agrupation.
	 * 
	 * @param pAgrupation
	 *            the new agrupation
	 */
	public void setAgrupation(CfgCompetitionEventAgrupation pAgrupation) {
		agrupation = pAgrupation;
	}

	/**
	 * Sets the cfg sport synonyms.
	 * 
	 * @param pCfgSportSynonyms
	 *            the new cfg sport synonyms
	 */
	public void setCfgSportSynonyms(Set<CfgSportSynonyms> pCfgSportSynonyms) {
		cfgSportSynonyms = pCfgSportSynonyms;
	}

	/**
	 * Sets the order.
	 * 
	 * @param pOrder
	 *            the new order
	 */
	@Override
	public void setOrder(Order pOrder) {
		order = pOrder;
	}

}
