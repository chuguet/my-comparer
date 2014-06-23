/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class PaypalAction.
 */
@Entity
@Table(name = "PAYPAL_ACTION")
public class PaypalAction extends AbstractRelacional implements IAutoSender {
	
	/** The paypal action id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYPAL_ACTION_ID")
	private Integer paypalActionId;
	
	/** The user. */
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="liferayUserId",referencedColumnName="liferayUserId",nullable=false, insertable=true, updatable=false)
	@Basic
	@Column(name = "liferayUserId",nullable = true, length = 255)
	private String user;
	
	/** The payment id. */
	@Basic
	@Column(nullable = true, length = 255, name = "PAYMENT_ID")
	private String payerId;
	
	/** The token. */
	@Basic
	@Column(nullable = true, length = 255, name = "TOKEN")
	private String token;

	/** The transition id. */
	@Basic
	@Column(nullable = true, length = 255, name = "TRANSACTION_ID")
	private String transactionId;
	
	/** The payment date. */
	@Basic
	@Column(nullable = true, length = 255, name = "PAYMENT_DATE")
	private String paymentDate; 
	
	/** The status. */
	@Column(name="STATUS") 
	@Enumerated(EnumType.STRING)
	private Status status;
	
	/** The payment type. */
	@Column(name="PAYMENTTYPE") 
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	
	
	/**
	 * Gets the payment type.
	 *
	 * @return the payment type
	 */
	public PaymentType getPaymentType() {
		return paymentType;
	}




	/**
	 * Sets the payment type.
	 *
	 * @param paymentType the new payment type
	 */
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}




	/**
	 * Gets the paypal action id.
	 *
	 * @return the paypal action id
	 */
	public Integer getPaypalActionId() {
		return paypalActionId;
	}




	/**
	 * Sets the paypal action id.
	 *
	 * @param paypalActionId the new paypal action id
	 */
	public void setPaypalActionId(Integer paypalActionId) {
		this.paypalActionId = paypalActionId;
	}




	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}




	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}




	/**
	 * Gets the payer id.
	 *
	 * @return the payer id
	 */
	public String getPayerId() {
		return payerId;
	}




	/**
	 * Sets the payer id.
	 *
	 * @param payerId the new payer id
	 */
	public void setPayerId(String payerId) {
		this.payerId = payerId;
	}




	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}




	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}




	/**
	 * Gets the transition id.
	 *
	 * @return the transition id
	 */
	public String getTransactionId() {
		return transactionId;
	}




	/**
	 * Sets the transition id.
	 *
	 * @param transitionId the new transition id
	 */
	public void setTransactionId(String transitionId) {
		this.transactionId = transitionId;
	}




	/**
	 * Gets the payment date.
	 *
	 * @return the payment date
	 */
	public String getPaymentDate() {
		return paymentDate;
	}




	/**
	 * Sets the payment date.
	 *
	 * @param paymentDate the new payment date
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}




	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}




	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}




	/**
	 * The Enum Status.
	 */
	public enum Status{
		
		/** The PENDING. */
		PENDING,
		
		/** The COMPLETED. */
		COMPLETED;
		
	}
	



	/**
	 * The Enum PaymentType.
	 */
	public enum PaymentType{


		/** The PREMIU m30. */
		PREMIUM30(1,"Servicio Premium 30 días",30,"99"),
		
		/** The PREMIU m90. */
		PREMIUM90(2,"Servicio Premium 90 días",90,"249"),
		
		/** The PREMIU m365. */
		PREMIUM365(3,"Servicio Premium 365 días",365,"949"),


		/** The PROFESIONA l30. */
		PROFESIONAL30(4,"Servicio Profesional 30 días",30,"39"),
		
		/** The PROFESIONA l90. */
		PROFESIONAL90(5,"Servicio Profesional 90 días",90,"99"),
		
		/** The PROFESIONA l365. */
		PROFESIONAL365(6,"Servicio Profesional 365 días",365,"374"),

		/** The BASIC o30. */
		BASICO30(7,"Servicio Básico 30 días",30,"6"),
		
		/** The BASIC o90. */
		BASICO90(8,"Servicio Básico 90 días",90,"15"),
		
		/** The BASIC o365. */
		BASICO365(9,"Servicio Básico 365 días",365,"57");

		/** The id. */
		private Integer id;

		/**
		 * Gets the id.
		 *
		 * @return the id
		 */
		public Integer getId() {
			return id;
		}

		/**
		 * Sets the id.
		 *
		 * @param id the new id
		 */
		public void setId(Integer id) {
			this.id = id;
		}

		/**
		 * Gets the name.
		 *
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets the name.
		 *
		 * @param name the new name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Gets the days.
		 *
		 * @return the days
		 */
		public Integer getDays() {
			return days;
		}

		/**
		 * Sets the days.
		 *
		 * @param days the new days
		 */
		public void setDays(Integer days) {
			this.days = days;
		}

		/**
		 * Gets the price.
		 *
		 * @return the price
		 */
		public String getPrice() {
			return price;
		}

		/**
		 * Sets the price.
		 *
		 * @param price the new price
		 */
		public void setPrice(String price) {
			this.price = price;
		}

		/** The name. */
		private String name;

		/** The days. */
		private Integer days;

		/** The price. */
		private String price;

		/**
		 * Instantiates a new payment type.
		 *
		 * @param id the id
		 * @param name the name
		 * @param days the days
		 * @param price the price
		 */
		PaymentType(Integer id, String name,Integer days,String price) {
			this.id = id;
			this.name = name;
			this.days = days;
			this.price = price;
		}

		/**
		 * Gets the payment type.
		 *
		 * @param option the option
		 * @return the payment type
		 * @throws InvalidPaymentType the invalid payment type
		 */
		public static PaymentType getPaymentType(Integer option) throws InvalidPaymentType{

			PaymentType result = null;

			for(PaymentType paymentType : PaymentType.values()){
				if(paymentType.id==option){
					result = paymentType;
					break;
				}
			}
			if(result==null){
				throw new InvalidPaymentType();
			}
			return result;

		}

	}
}
