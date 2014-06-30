/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.mail.tool;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;
import com.comparadorad.bet.comparer.util.mail.beans.Mail;
import com.comparadorad.bet.comparer.util.mail.beans.MailDataInfo;

/**
 * The Class MailTool.
 */
@Component
class MailTool implements IMailTool {

	/** The Constant SMTP_AUTH. */
	private static final String SMTP_AUTH = "mail.smtp.auth";

	/** The Constant SMTP_HOST. */
	private static final String SMTP_HOST = "mail.smtp.host";

	/** The Constant SMTP_PORT. */
	private static final String SMTP_PORT = "mail.smtp.port";

	/** The Constant SMTP_STARTTLS. */
	private static final String SMTP_STARTTLS = "mail.smtp.starttls.enable";

	/** The LOG. */
	@Inject
	private ComparerWrapperLog LOG;

	/** The mail data info. */
	@Inject
	private MailDataInfo mailDataInfo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.comparadorad.bet.comparer.util.mail.tool.IMailTool#sendMail(com.
	 * comparadorad.bet.comparer.util.mail.beans.Mail)
	 */
	@Override
	public void sendMail(Mail mail) {
		LOG.info(Thread.currentThread(), new StringBuffer(
				"Se inicia un envio de correo a ").append(mail.getTo())
				.toString());

		Properties props = new Properties();
		props.put(SMTP_AUTH, mailDataInfo.getSmtpAuth());
		props.put(SMTP_STARTTLS, mailDataInfo.getSmtpStartTls());
		props.put(SMTP_HOST, mailDataInfo.getSmtpHost());
		props.put(SMTP_PORT, mailDataInfo.getSmtpPort());

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(mailDataInfo
								.getUser(), mailDataInfo.getPassword());
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailDataInfo.getUser(),
					mailDataInfo.getFrom()));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					mail.getTo()));
			message.setSubject(mail.getSubject());
			message.setText(mail.getText(), mailDataInfo.getEncode(),
					mailDataInfo.getTypeText());
			Transport.send(message);
			LOG.info(Thread.currentThread(), "Se ha enviado un correo");
		} catch (MessagingException e) {
			LOG.error(Thread.currentThread(), e.getMessage());
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			LOG.error(Thread.currentThread(), e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
