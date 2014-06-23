/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.autosender.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionType.
 */
@Entity
@Table(name = "ACTION_TYPE")
public class ActionType extends AbstractRelacional implements IAutoSender {

	/**
	 * The Enum ActionTypeName.
	 */

	public enum ActionTypeName {
		/** The CREAT e_ user. */
		CREATE_USER("", "Creacion de usuario"),

		/** The DELET e_ user. */
		DELETE_USER("", "Borrado de usuario"),

		/** The AD d_ conten t_ lis t_ blog. */
		ADD_CONTENT_LIST_BLOG("TaY2", "Blog"),

		/** The AD d_ conten t_ lis t_ surebet. */
		ADD_CONTENT_LIST_SUREBET("TabL", "SureBet"),

		/** The AD d_ conten t_ lis t_ afiliados. */
		ADD_CONTENT_LIST_AFILIADOS("p1rK", ""),

		/** The AD d_ conten t_ lis t_ referidos. */
		ADD_CONTENT_LIST_REFERIDOS("p1ro", ""),

		/** The AD d_ conten t_ lis t_ valuebet. */
		ADD_CONTENT_LIST_VALUEBET("TabL", ""),

		/** The AD d_ conten t_ lis t_ we b_ principal. */
		ADD_CONTENT_LIST_WEB_PRINCIPAL("TabM", ""),

		/** The DELET e_ conten t_ lis t_ blog. */
		DELETE_CONTENT_LIST_BLOG("p1zW", ""),

		/** The DELET e_ conten t_ lis t_ surebet. */
		DELETE_CONTENT_LIST_SUREBET("p1rk" ,""),

		/** The DELET e_ conten t_ lis t_ afiliados. */
		DELETE_CONTENT_LIST_AFILIADOS("p1rK", ""),

		/** The DELET e_ conten t_ lis t_ referidos. */
		DELETE_CONTENT_LIST_REFERIDOS("p1ro", ""),

		/** The DELET e_ conten t_ lis t_ valuebet. */
		DELETE_CONTENT_LIST_VALUEBET("p1rF", ""),

		/** The DELET e_ conten t_ lis t_ we b_ principal. */
		DELETE_CONTENT_LIST_WEB_PRINCIPAL("p1rO", ""),

		/** The AD d_ paymen t_ lis t_ register. */
		ADD_PAYMENT_LIST_REGISTER("p1rI", ""),

		/** The AD d_ paymen t_ lis t_ fre e_ service. */
		ADD_PAYMENT_LIST_FREE_SERVICE("Tab2", ""),

		/** The AD d_ paymen t_ lis t_ lv l_1_1 mes. */
		ADD_PAYMENT_LIST_LVL_1_1MES("Tabx", ""),

		/** The AD d_ paymen t_ lis t_ lv l_1_6 mes. */
		ADD_PAYMENT_LIST_LVL_1_6MES("TabS", ""),

		/** The AD d_ paymen t_ lis t_ lv l_1_1 ano. */
		ADD_PAYMENT_LIST_LVL_1_1ANO("TabN", ""),

		/** The AD d_ paymen t_ lis t_ lv l_2_1 mes. */
		ADD_PAYMENT_LIST_LVL_2_1MES("TabA", ""),

		/** The AD d_ paymen t_ lis t_ lv l_2_6 mes. */
		ADD_PAYMENT_LIST_LVL_2_6MES("Tabv", ""),

		/** The AD d_ paymen t_ lis t_ lv l_2_1 ano. */
		ADD_PAYMENT_LIST_LVL_2_1ANO("TabH", ""),

		/** The AD d_ paymen t_ lis t_ lv l_3_1 mes. */
		ADD_PAYMENT_LIST_LVL_3_1MES("TabY", ""),

		/** The AD d_ paymen t_ lis t_ lv l_3_6 mes. */
		ADD_PAYMENT_LIST_LVL_3_6MES("Tabb", ""),

		/** The AD d_ paymen t_ lis t_ lv l_3_1 ano. */
		ADD_PAYMENT_LIST_LVL_3_1ANO("Tabd", ""),

		/** The MODIF y_ paymen t_ lis t_ register. */
		MODIFY_PAYMENT_LIST_REGISTER("p1rI", ""),

		/** The MODIF y_ paymen t_ lis t_ fre e_ service. */
		MODIFY_PAYMENT_LIST_FREE_SERVICE("p1r7", ""),

		/** The MODIF y_ paymen t_ lis t_ afte r_ fre e_ service. */
		MODIFY_PAYMENT_LIST_AFTER_FREE_SERVICE("TabD", ""),

		/** The MODIF y_ paymen t_ lis t_ afte r_ paymen t_ service. */
		MODIFY_PAYMENT_LIST_AFTER_PAYMENT_SERVICE("p1rl", ""),

		/** The MODIF y_ paymen t_ lis t_ lv l_1_1 mes. */
		MODIFY_PAYMENT_LIST_LVL_1_1MES("p1r3", ""),

		/** The MODIF y_ paymen t_ lis t_ lv l_1_6 mes. */
		MODIFY_PAYMENT_LIST_LVL_1_6MES("p1rt", ""),

		/** The MODIF y_ paymen t_ lis t_ lv l_1_1 ano. */
		MODIFY_PAYMENT_LIST_LVL_1_1ANO("p1rm", ""),

		/** The MODIF y_ paymen t_ lis t_ lv l_2_1 mes. */
		MODIFY_PAYMENT_LIST_LVL_2_1MES("p1r0", ""),

		/** The MODIF y_ paymen t_ lis t_ lv l_2_6 mes. */
		MODIFY_PAYMENT_LIST_LVL_2_6MES("p1rD", ""),

		/** The MODIF y_ paymen t_ lis t_ lv l_2_1 ano. */
		MODIFY_PAYMENT_LIST_LVL_2_1ANO("p1re", ""),

		/** The MODIF y_ paymen t_ lis t_ lv l_3_1 mes. */
		MODIFY_PAYMENT_LIST_LVL_3_1MES("p1rx", ""),

		/** The MODIF y_ paymen t_ lis t_ lv l_3_6 mes. */
		MODIFY_PAYMENT_LIST_LVL_3_6MES("p1rU", ""),

		/** The MODIF y_ paymen t_ lis t_ lv l_3_1 ano. */
		MODIFY_PAYMENT_LIST_LVL_3_1ANO("p1r1", ""),

		/** The MODIF y_ paymen t_ lis t_ lim b2. */
		MODIFY_PAYMENT_LIST_LIMB2("Tadc", ""),

		/** The MODIF y_ paymen t_ lis t_ lim b3. */
		MODIFY_PAYMENT_LIST_LIMB3("p1rb", ""),

		/** The AD d_ lifera y_ list. */
		CHANGE_ROLES("", ""),

		ADD_REFERIDOS_NO_PERTENECE_U_ACTIVO("TadT",""),
		
		ADD_REFERIDOS_NO_PERTENECE_U_NO_ACTIVO("Tadn",""),
		
		ADD_REFERIDOS_PERTENECE("Tadp","");

		/** The name. */
		private String name;
		
		/** The description. */
		private String description;

		/**
		 * Instantiates a new action type name.
		 *
		 * @param pName the name
		 * @param description the description
		 */
		ActionTypeName(String pName, String description) {
			this.name = pName;
			this.description = description;
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
		 * Gets the description.
		 *
		 * @return the description
		 */
		public String getDescription(){
			return description;
		}
		
	};

	/** The action type id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACTION_TYPE_ID")
	private Integer actionTypeId;

	/** The description. */
	@Basic
	@Column(nullable = true, length = 255, name = "DESCRIPTION")
	private String description;

	/** The name. */
	@Basic
	@Column(name = "NAME")
	private ActionTypeName name;

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public ActionTypeName getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(ActionTypeName name) {
		this.name = name;
	}

	/**
	 * Gets the action type id.
	 * 
	 * @return the action type id
	 */
	public Integer getActionTypeId() {
		return actionTypeId;
	}

	/**
	 * Sets the action type id.
	 * 
	 * @param actionTypeId
	 *            the new action type id
	 */
	public void setActionTypeId(Integer actionTypeId) {
		this.actionTypeId = actionTypeId;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/** {@inheritDoc} */ 
	@Override
	public String toString() {
		return "ActionType [actionTypeId=" + actionTypeId + ", description="
				+ description + ", name=" + name + "]";
	}
	
	

}
