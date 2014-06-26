/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.model;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;

/**
 * The Class XMLMoreLessAttribute.
 */
@Component
@SuppressWarnings("serial")
public class XmlMoreLessAttribute extends AbstractXMLAttribute {

	/** The cfg bet type id. */
	private String cfgBetTypeId;

	/** The mas menos. */
	private MasMenos masMenos;

	/** The total goal. */
	private Double totalGoalValue;

	/**
	 * Instantiates a new xml more less attribute.
	 */
	public XmlMoreLessAttribute() {
		super();
		this.cfgBetTypeId = CfgBetTypeId.MAS_MENOS.nameId();
	}

	/**
	 * Instantiates a new xml more less attribute.
	 * 
	 * @param masMenos
	 *            the mas menos
	 * @param totalGoalValue
	 *            the total goal value
	 */
	public XmlMoreLessAttribute(MasMenos masMenos, Double totalGoalValue) {
		super();
		this.masMenos = masMenos;
		this.totalGoalValue = totalGoalValue;
		this.cfgBetTypeId = CfgBetTypeId.MAS_MENOS.nameId();
	}

	/**
	 * Gets the cfg bet type id.
	 * 
	 * @return the cfg bet type id
	 */
	public String getCfgBetTypeId() {
		return cfgBetTypeId;
	}

	/**
	 * Gets the mas menos.
	 * 
	 * @return the mas menos
	 */
	public MasMenos getMasMenos() {
		return masMenos;
	}

	/**
	 * Gets the total goal.
	 * 
	 * @return the total goal
	 */
	public Double getTotalGoal() {
		return totalGoalValue;
	}

	/**
	 * Sets the mas menos.
	 * 
	 * @param pMasMenos
	 *            the new mas menos
	 */
	public void setMasMenos(MasMenos pMasMenos) {
		masMenos = pMasMenos;
	}

	/**
	 * Sets the total goal.
	 * 
	 * @param pTotalGoal
	 *            the new total goal
	 */
	public void setTotalGoal(Double pTotalGoal) {
		totalGoalValue = pTotalGoal;
	}
}
