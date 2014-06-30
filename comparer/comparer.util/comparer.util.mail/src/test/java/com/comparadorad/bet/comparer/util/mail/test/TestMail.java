package com.comparadorad.bet.comparer.util.mail.test;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;
import com.comparadorad.bet.comparer.util.mail.beans.Mail;
import com.comparadorad.bet.comparer.util.mail.tool.IMailTool;

public class TestMail extends AbstractTest {

	@Inject
	private ComparerWrapperLog LOG;
	@Inject
	private IMailTool mailTool;

	@Test
	public void testSendMail() {
		LOG.debug(Thread.currentThread(), "Enviando mensaje");
		mailTool.sendMail(new Mail("prueba@mailinator.com",
				"<h1>PRUEBA DE ENVIO</h1><p>enviado</p>", "Prueba de envio"));
		LOG.debug(Thread.currentThread(), "Mensaje Enviado");
	}
}
