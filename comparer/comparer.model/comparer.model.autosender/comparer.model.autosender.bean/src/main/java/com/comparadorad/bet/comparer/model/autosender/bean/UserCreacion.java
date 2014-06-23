package com.comparadorad.bet.comparer.model.autosender.bean;

/**
 * The Enum UserCreacion.
 */
public enum UserCreacion{
	
	/** The USE r_ task. */
	USER_TASK("USER_TASK","Creado por la aplicacion comparer.autosender.dbsynchro.usertask"),
	LiferayUserServiceHook("LiferayUserServiceHook","Creado por la aplicacion hook"),
	Paypal_Controller("Paypal_Controller","Creado por la aplicacion comparer.web.server.mvc.payment");
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/**
	 * Instantiates a new user creacion.
	 *
	 * @param name the name
	 * @param description the description
	 */
	private UserCreacion(String name, String description){
		this.name = name;
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
	
}
