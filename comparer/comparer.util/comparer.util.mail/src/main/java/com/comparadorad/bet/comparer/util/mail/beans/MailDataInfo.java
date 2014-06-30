/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.mail.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The Class MailDataInfo.
 */
@Component
public class MailDataInfo {

	/** The encode. */
	@Value("${mail.encode}")
	private String encode;

	/** The from. */
	@Value("${mail.from}")
	private String from;

	/** The password. */
	@Value("${mail.password}")
	private String password;

	/** The smtp auth. */
	@Value("${mail.smtp.auth}")
	private String smtpAuth;

	/** The smtp host. */
	@Value("${mail.smtp.host}")
	private String smtpHost;

	/** The smtp port. */
	@Value("${mail.smtp.port}")
	private String smtpPort;

	/** The smtp start tls. */
	@Value("${mail.smtp.startTls}")
	private String smtpStartTls;

	/** The html. */
	@Value("${mail.typeText}")
	private String typeText;

	/** The user. */
	@Value("${mail.user}")
	private String user;

	/**
	 * Gets the encode.
	 * 
	 * @return the encode
	 */
	public String getEncode() {
		return encode;
	}

	/**
	 * Gets the from.
	 * 
	 * @return the from
	 */
	public String getFrom() {
		return from;
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
	 * Gets the smtp auth.
	 * 
	 * @return the smtp auth
	 */
	public String getSmtpAuth() {
		return smtpAuth;
	}

	/**
	 * Gets the smtp host.
	 * 
	 * @return the smtp host
	 */
	public String getSmtpHost() {
		return smtpHost;
	}

	/**
	 * Gets the smtp port.
	 * 
	 * @return the smtp port
	 */
	public String getSmtpPort() {
		return smtpPort;
	}

	/**
	 * Gets the smtp start tls.
	 * 
	 * @return the smtp start tls
	 */
	public String getSmtpStartTls() {
		return smtpStartTls;
	}

	/**
	 * Gets the type text.
	 * 
	 * @return the type text
	 */
	public String getTypeText() {
		return typeText;
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
	 * Sets the encode.
	 * 
	 * @param encode
	 *            the new encode
	 */
	public void setEncode(String encode) {
		this.encode = encode;
	}

	/**
	 * Sets the from.
	 * 
	 * @param from
	 *            the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Sets the smtp auth.
	 * 
	 * @param smtpAuth
	 *            the new smtp auth
	 */
	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	/**
	 * Sets the smtp host.
	 * 
	 * @param smtpHost
	 *            the new smtp host
	 */
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	/**
	 * Sets the smtp port.
	 * 
	 * @param smtpPort
	 *            the new smtp port
	 */
	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

	/**
	 * Sets the smtp start tls.
	 * 
	 * @param smtpStartTls
	 *            the new smtp start tls
	 */
	public void setSmtpStartTls(String smtpStartTls) {
		this.smtpStartTls = smtpStartTls;
	}

	/**
	 * Sets the type text.
	 * 
	 * @param typeText
	 *            the new type text
	 */
	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	/**
	 * Sets the user.
	 * 
	 * @param user
	 *            the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}

}
