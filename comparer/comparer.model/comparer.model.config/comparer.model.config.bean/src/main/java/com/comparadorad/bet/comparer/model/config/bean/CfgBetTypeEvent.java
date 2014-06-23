/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.DBRef;
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
public class CfgBetTypeEvent extends AbstractI18nTableActivable implements
		IObjectOrder<CfgBetTypeEvent> {

	/** The agrupation. */
	@DBRef
	private CfgBetTypeEventAgrupation agrupation;

	/** The bet type. */
	@DBRef
	private CfgBetType betType;

	/** The order. */
	@Field
	@NotNull
	private Order order;

	/**
	 * The Enum CfgBetTypeEventId.
	 */
	public enum CfgBetTypeEventId implements INameIdEnum {

		/** The PARTID o_ completo. */
		PARTIDO_COMPLETO("PARTIDO_COMPLETO", "1"),
		/** The PRIMER a_ parte. */
		PRIMERA_PARTE("PRIMERA_PARTE", "2"),
		/** The SEGUND a_ parte. */
		SEGUNDA_PARTE("SEGUNDA_PARTE", "3"),
		/** The QUINC e_ minutos. */
		QUINCE_MINUTOS("QUINCE_MINUTOS", "4"),
		/** The TREINT a_ minutos. */
		TREINTA_MINUTOS("TREINTA_MINUTOS", "5"),
		/** The SESENT a_ minutos. */
		SETENTA_MINUTOS("SETENTA_MINUTOS", "6"),

		/** The PRIME r_ set. */
		PRIMER_SET("PRIMER_SET", "7"),

		/** The SEGUND o_ set. */
		SEGUNDO_SET("SEGUNDO_SET", "8"),

		/** The TERCE r_ set. */
		TERCER_SET("TERCER_SET", "9"),

		/** The CUART o_ set. */
		CUARTO_SET("CUARTO_SET", "10"),

		/** The QUINT o_ set. */
		QUINTO_SET("QUINTO_SET", "11"),

//		/** The A l_ descanso. */
//		AL_DESCANSO("AL_DESCANSO", "12"),

		/** The PRIME r_ cuarto. */
		PRIMER_CUARTO("PRIMER_CUARTO", "13"),

		/** The SEGUND o_ cuarto. */
		SEGUNDO_CUARTO("SEGUNDO_CUARTO", "14"),

		/** The TERCE r_ cuarto. */
		TERCER_CUARTO("TERCER_CUARTO", "15"),

		/** The CUART o_ cuarto. */
		CUARTO_CUARTO("CUARTO_CUARTO", "16"),

		/** The PARTID o_ complet o_ prorroga. */
		PARTIDO_COMPLETO_PRORROGA("PARTIDO_COMPLETO_PRORROGA", "17"),

		/** The PRIMER a_ entrada. */
		PRIMERA_ENTRADA("PRIMERA_ENTRADA", "18"),

		/** The CINC o_ primera s_ entradas. */
		CINCO_PRIMERAS_ENTRADAS("CINCO_PRIMERAS_ENTRADAS", "19"),

		/** The TERCER a_ parte. */
		TERCERA_PARTE("TERCERA_PARTE", "20");

		/** The name id. */
		private final String nameId;

		/** The object id. */
		private final String objectId;
		
		/** The is long term. */
		private final Boolean isLongTerm;

		/**
		 * Instantiates a new cfg bet type event id.
		 * 
		 * @param nameId
		 *            the name id
		 * @param objectId
		 *            the object id
		 */
		CfgBetTypeEventId(String nameId, String objectId) {
			this.nameId = nameId;
			this.objectId = objectId;
			this.isLongTerm = Boolean.FALSE;
		}
		
		/**
		 * Instantiates a new cfg bet type event id.
		 *
		 * @param nameId the name id
		 * @param objectId the object id
		 * @param isLongTerm the is long term
		 */
		CfgBetTypeEventId(String nameId, String objectId, Boolean isLongTerm) {
			this.nameId = nameId;
			this.objectId = objectId;
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
		 * Object id.
		 * 
		 * @return the string
		 */
		public String objectId() {
			return objectId;
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

	/**
	 * Compare to.
	 * 
	 * @param pBetTypeEventAgrupation
	 *            the bet type event agrupation
	 * @return the int {@inheritDoc}
	 */
	@Override
	public int compareTo(CfgBetTypeEvent pBetTypeEventAgrupation) {
		return ObjectOrderSort.compareTo(this, pBetTypeEventAgrupation);
	}

	/**
	 * Equals.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CfgBetTypeEvent other = (CfgBetTypeEvent) obj;
		if (this.getI18n() == null) {
			if (other.getI18n() != null)
				return false;
		} else if (!this.getI18n().equals(other.getI18n()))
			return false;
		return true;
	}

	/**
	 * Gets the agrupation.
	 * 
	 * @return the agrupation
	 */
	public CfgBetTypeEventAgrupation getAgrupation() {
		return agrupation;
	}

	/**
	 * Gets the bet type.
	 * 
	 * @return the bet type
	 */
	public CfgBetType getBetType() {
		return betType;
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
	public void setAgrupation(CfgBetTypeEventAgrupation pAgrupation) {
		agrupation = pAgrupation;
	}

	/**
	 * Sets the bet type.
	 * 
	 * @param pBetType
	 *            the new bet type
	 */
	public void setBetType(CfgBetType pBetType) {
		betType = pBetType;
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