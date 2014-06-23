/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.core.bean.INameIdEnum;
import com.comparadorad.bet.comparer.model.core.bean.IObjectOrder;
import com.comparadorad.bet.comparer.model.core.bean.Order;
import com.comparadorad.bet.comparer.model.core.bean.sort.ObjectOrderSort;

/**
 * The Class CfgBetType.
 */
@SuppressWarnings("serial")
@Document
public class CfgBetType extends AbstractI18nTableActivable implements
		IObjectOrder<CfgBetType> {

	/** The order. */
	@Field
	@NotNull
	private Order order;

	/** The agrupation. */
	@DBRef
	private CfgBetTypeAgrupation agrupation;

	/**
	 * Gets the agrupation.
	 * 
	 * @return the agrupation
	 */
	public CfgBetTypeAgrupation getAgrupation() {
		return agrupation;
	}

	/**
	 * Sets the agrupation.
	 * 
	 * @param agrupation
	 *            the new agrupation
	 */
	public void setAgrupation(CfgBetTypeAgrupation agrupation) {
		this.agrupation = agrupation;
	}

	/**
	 * The Enum CfgBetTypeId.
	 */
	public enum CfgBetTypeId implements INameIdEnum {

		/** The ON e_ dra w_ two. */
		UNO_X_DOS("1X2", BigInteger.valueOf(1)),

		/** The MATC h_ winner. */
		GANADOR_PARTIDO("Ganador_Partido", BigInteger.valueOf(2)),

		/** The WINNER. */
		GANADOR("Ganador", BigInteger.valueOf(3)),

		/** The ASIA n_ handicap. */
		HANDICAP_ASIATICO("Handicap_Asiatico", BigInteger.valueOf(4)),

		/** The ON e_ dra w_ tw o_ handicap. */
		UNO_X_DOS_HANDICAP("1X2_Handicap", BigInteger.valueOf(5)),

		/** The UNDE r_ over. */
		MAS_MENOS("Mas_Menos", BigInteger.valueOf(6)),

		/** The MA x_ scorer. */
		MAXIMO_GOLEADOR("Maximo_Goleador", BigInteger.valueOf(7), Boolean.TRUE),

		;

		/** The object id. */
		private final String nameId;

		/** The id. */
		private final BigInteger id;
		
		/** The is long term. */
		private final Boolean isLongTerm;

		/**
		 * Instantiates a new cfg bookmaker id.
		 * 
		 * @param nameId
		 *            the name id
		 * @param id
		 *            the id
		 */
		CfgBetTypeId(String nameId, BigInteger id) {
			this.nameId = nameId;
			this.id = id;
			this.isLongTerm = Boolean.FALSE;
		}
		
		/**
		 * Instantiates a new cfg bet type id.
		 *
		 * @param nameId the name id
		 * @param id the id
		 * @param isLongTerm the is long term
		 */
		CfgBetTypeId(String nameId, BigInteger id, Boolean isLongTerm) {
			this.nameId = nameId;
			this.id = id;
			this.isLongTerm = isLongTerm;
		}

		/**
		 * Name id.
		 * 
		 * @return the string {@inheritDoc}
		 */

		@Override
		public String nameId() {
			return nameId;
		}

		/**
		 * Id.
		 * 
		 * @return the string
		 */
		public String id() {
			return String.valueOf(id);
		}

		/**
		 * Gets the checks if is long term.
		 *
		 * @return the checks if is long term
		 */
		public Boolean getIsLongTerm() {
			return isLongTerm;
		}
	}

	/** The characteristics. */
	private List<IBetTypeFeature> betTypeFeatures;

	/**
	 * Adds the.
	 * 
	 * @param betTypeFeature
	 *            the bet type feature
	 */
	public void add(IBetTypeFeature betTypeFeature) {
		getBetTypeFeatures().add(betTypeFeature);
	}

	/**
	 * Equals.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 * @see java.lang.Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CfgBetType other = (CfgBetType) obj;
		if (this.getI18n() == null) {
			if (other.getI18n() != null)
				return false;
		} else if (!this.getI18n().equals(other.getI18n()))
			return false;
		return true;
	}
	
	

	/** {@inheritDoc} */ 
	@Override
	public String toString() {
		return "CfgBetType [order=" + order + ", agrupation=" + agrupation
				+ ", betTypeFeatures=" + betTypeFeatures + "]";
	}

	/**
	 * Gets the bet type features.
	 * 
	 * @return the bet type features
	 */
	public List<IBetTypeFeature> getBetTypeFeatures() {
		if (betTypeFeatures == null) {
			betTypeFeatures = new ArrayList<IBetTypeFeature>();
		}
		return betTypeFeatures;
	}

	/**
	 * Sets the bet type features.
	 * 
	 * @param betTypeFeatures
	 *            the new bet type features
	 */
	public void setBetTypeFeatures(List<IBetTypeFeature> betTypeFeatures) {
		this.betTypeFeatures = betTypeFeatures;
	}

	/**
	 * Compare to.
	 * 
	 * @param betType
	 *            the bet type
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int compareTo(CfgBetType betType) {
		return ObjectOrderSort.compareTo(this, betType);
	}

	/**
	 * Gets the order.
	 * 
	 * @return the order {@inheritDoc}
	 */
	@Override
	public Order getOrder() {
		return order;
	}

	/**
	 * Sets the order.
	 * 
	 * @param pOrder
	 *            the new order {@inheritDoc}
	 */
	@Override
	public void setOrder(Order pOrder) {
		this.order = pOrder;

	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getObjectId().hashCode();
	}
}