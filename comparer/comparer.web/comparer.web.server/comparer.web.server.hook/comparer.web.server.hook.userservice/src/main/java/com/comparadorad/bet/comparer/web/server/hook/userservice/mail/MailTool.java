/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.hook.userservice.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class MailTool.
 */
public class MailTool implements IMailTool {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(MailTool.class);
	
	/** The Constant SMTP_AUTH. */
	private static final String SMTP_AUTH = "mail.smtp.auth";

	/** The Constant SMTP_HOST. */
	private static final String SMTP_HOST = "mail.smtp.host";

	/** The Constant SMTP_PORT. */
	private static final String SMTP_PORT = "mail.smtp.port";

	/** The Constant SMTP_STARTTLS. */
	private static final String SMTP_STARTTLS = "mail.smtp.starttls.enable";

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.util.mail.tool.IMailTool#sendMail(com.
	 * comparadorad.bet.comparer.util.mail.beans.Mail)
	 */
	public void sendMail(Mail mail) {
		LOG.info(new StringBuffer("Se inicia un envio de correo a ").append(
				mail.getTo()).toString());

		Properties props = new Properties();
		props.put(SMTP_AUTH, "true");
		props.put(SMTP_STARTTLS, "true");
		props.put(SMTP_HOST, "95.131.233.225");
		props.put(SMTP_PORT, "25");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"usuarios@betcompara.com", "user$13");
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("usuarios@betcompara.com",
					"Usuarios Betcompara"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					mail.getTo()));
			message.setSubject(mail.getSubject());
			message.setText(mail.getText(), "ISO-8859-1", "html");
			Transport.send(message);
			LOG.info("Se ha enviado un correo");
		} catch (MessagingException e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			LOG.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
