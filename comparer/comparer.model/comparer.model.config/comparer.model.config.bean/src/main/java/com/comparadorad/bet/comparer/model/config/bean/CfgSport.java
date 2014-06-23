/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.bean;

import java.math.BigInteger;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractI18nTableActivable;
import com.comparadorad.bet.comparer.model.core.bean.INameIdEnum;

/**
 * The Class Sport.
 * 
 * @author imayoral
 * @version 1.0
 */
@SuppressWarnings("serial")
@Document
public class CfgSport extends AbstractI18nTableActivable implements
		IToolbarConfigurable {

	/**
	 * The Enum CfgSportId.
	 */
	public enum CfgSportId implements INameIdEnum {

		/** The FOOTBALL. */
		FOOTBALL("Football", BigInteger.valueOf(1)),
		/** The TENNIS. */
		TENNIS("Tennis", BigInteger.valueOf(3)),
		/** The BASKETBALL. */
		BASKETBALL("Basketball", BigInteger.valueOf(2)),
		/** The BASEBALL. */
		BASEBALL("Baseball", BigInteger.valueOf(27)),
		/** The IC e_ hockey. */
		ICE_HOCKEY("Ice hockey", BigInteger.valueOf(24)),
		/** The HANDBALL. */
		HANDBALL("Handball", BigInteger.valueOf(18)),
		/** The MOTOR. */
		MOTOR("Motor", BigInteger.valueOf(99)),
		/** The CYCLING. */
		CYCLING("Cycling", BigInteger.valueOf(14)),
		/** The AMERICA n_ football. */
		AMERICAN_FOOTBALL("American Football", BigInteger.valueOf(26)),
		/** The RUGB y_ league. */
		RUGBY_LEAGUE("Rubby League", BigInteger.valueOf(32));

		/** The object id. */
		private final String nameId;

		/** The id. */
		private final BigInteger id;

		/**
		 * Instantiates a new cfg bookmaker id.
		 * 
		 * @param nameId
		 *            the name id
		 * @param id
		 *            the id
		 */
		CfgSportId(String nameId, BigInteger id) {
			this.nameId = nameId;
			this.id = id;
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
		 * Name id.
		 * 
		 * @return the string {@inheritDoc}
		 */

		@Override
		public String nameId() {
			return nameId;
		}

	}

	/** The order. */
	@Field
	private Integer order;

	/** The code. */
	@Field
	private String code;

	/** The resource. */
	@Field
	private CfgResource resource;

	/** The configured. */
	@Field
	private Boolean configured;

	/** The hash key participants. */
	@Field
	private Boolean hashKeyParticipants;

	/** The Constant SPORT_IMG_PATH. */
	public static final String SPORT_IMG_PATH = "comparer/sport/";

	/**
	 * Instantiates a new cfg sport.
	 */
	public CfgSport() {
		super();
	}

	/**
	 * Instantiates a new cfg sport.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgSport(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new cfg sport.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public CfgSport(String pObjectId) {
		super(pObjectId);
	}

	/**
	 * Equals.
	 * 
	 * @param object
	 *            the object
	 * @return true, if successful
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(final Object object) {
		if (!(object instanceof CfgSport)) {
			return false;
		}
		final CfgSport rhs = (CfgSport) object;
		return new EqualsBuilder().appendSuper(super.equals(object))
				.append(this.getI18n(), rhs.getI18n()).isEquals();
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the configured.
	 * 
	 * @return the configured
	 */
	public Boolean getConfigured() {
		return configured;
	}

	/**
	 * Gets the hash key participants.
	 * 
	 * @return the hash key participants
	 */
	public Boolean getHashKeyParticipants() {
		return hashKeyParticipants;
	}

	/**
	 * Gets the order.
	 * 
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * Gets the resource.
	 * 
	 * @return the resource {@inheritDoc}
	 */
	@Override
	public CfgResource getResource() {
		if (resource == null) {
			if (this.getCode() != null) {
				resource = new CfgResource(new StringBuffer(SPORT_IMG_PATH)
						.append(getCode().toLowerCase()).append(".png")
						.toString());
			}
		}
		return resource;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1331928311, 1968679015)
				.appendSuper(super.hashCode()).append(this.getI18n())
				.toHashCode();
	}

	/**
	 * Sets the code.
	 * 
	 * @param pCode
	 *            the new code
	 */
	public void setCode(String pCode) {
		code = pCode;
	}

	/**
	 * Sets the configured.
	 * 
	 * @param configured
	 *            the new configured
	 */
	public void setConfigured(Boolean configured) {
		this.configured = configured;
	}

	/**
	 * Sets the hash key participants.
	 * 
	 * @param hashKeyParticipants
	 *            the new hash key participants
	 */
	public void setHashKeyParticipants(Boolean hashKeyParticipants) {
		this.hashKeyParticipants = hashKeyParticipants;
	}

	/**
	 * Sets the order.
	 * 
	 * @param order
	 *            the new order
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * Sets the resource.
	 * 
	 * @param pResource
	 *            the new resource
	 */
	public void setResource(CfgResource pResource) {
		resource = pResource;
	}

}