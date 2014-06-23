/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.config;


/**
 * The Class ProxyPassConfig.
 */
public class ProxyConfig {
	
	/** The active. */
	private boolean active;
	
	/** The host. */
	private String host;

	/** The password. */
	private String password;

	/** The port. */
	private Integer port;
	
	/** The user. */
	private String user;
	
	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public Integer getPort() {
		return port;
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
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param pActive the new active
	 */
	public void setActive(boolean pActive) {
		active = pActive;
	}

	/**
	 * Sets the host.
	 *
	 * @param pHost the new host
	 */
	public void setHost(String pHost) {
		host = pHost;
	}

	/**
	 * Sets the password.
	 *
	 * @param pPassword the new password
	 */
	public void setPassword(String pPassword) {
		password = pPassword;
	}

	/**
	 * Sets the port.
	 *
	 * @param pPort the new port
	 */
	public void setPort(Integer pPort) {
		port = pPort;
	}

	/**
	 * Sets the user.
	 *
	 * @param pUser the new user
	 */
	public void setUser(String pUser) {
		user = pUser;
	}
}
