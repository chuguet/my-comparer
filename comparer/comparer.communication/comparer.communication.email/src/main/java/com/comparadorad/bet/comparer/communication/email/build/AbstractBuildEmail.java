/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.communication.email.build;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.comparadorad.bet.comparer.communication.email.beans.IEmailParameter;
import com.comparadorad.bet.comparer.communication.email.build.enums.TemplateEmail;
import com.comparadorad.bet.comparer.communication.email.config.AbstractEmailConfig;
import com.comparadorad.bet.comparer.communication.email.exception.BuildEmailException;

/**
 * The Class AbstractBuildEmail.
 */
public abstract class AbstractBuildEmail<I extends List<? extends IEmailParameter>>
		implements IBuildEmail<I> {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(AbstractBuildEmail.class);

	@Inject
	private AbstractEmailConfig emailConfig;

	protected AbstractEmailConfig getEmailConfig() {
		return emailConfig;
	}

	/**
	 * Report compile.
	 * 
	 * @return the jasper report
	 * @throws BuildEmailException
	 *             the build email exception
	 */
	protected JasperReport reportCompile() throws BuildEmailException {
		JasperReport result = null;
		try {
			LOG.info("Se inicia la compilacion del fichero *.jrxml");
			result = JasperCompileManager.compileReport(this.getClass()
					.getResourceAsStream(getTemplateEmail().getName()));
		} catch (JRException e) {
			LOG.error(e.getMessage());
			throw new BuildEmailException(e.getMessage(), e);
		} finally {
			LOG.info("Se finaliza la compilacion del fichero *.jrxml");
		}
		return result;
	}

	/**
	 * Gets the jasper print.
	 * 
	 * @param jasperReport
	 *            the jasper report
	 * @param dataSource
	 *            the data source
	 * @return the jasper print
	 * @throws BuildEmailException
	 *             the build email exception
	 */
	protected JasperPrint getjasperPrint(final JasperReport jasperReport,
			final JRDataSource dataSource) throws BuildEmailException {
		JasperPrint result;
		try {
			result = JasperFillManager.fillReport(jasperReport,
					getParameters(), dataSource);
		} catch (JRException e) {
			LOG.error(e.getMessage());
			throw new BuildEmailException(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * Gets the output stream.
	 * 
	 * @param jasperPrint
	 *            the jasper print
	 * @param inputStream
	 *            the input stream
	 * @return the output stream
	 * @throws BuildEmailException
	 *             the build email exception
	 */
	protected String makeReport(final JasperPrint jasperPrint)
			throws BuildEmailException {
		JRHtmlExporter jrExporter = new JRHtmlExporter();
		StringBuffer result = new StringBuffer();
		try {
			jrExporter.setParameter(JRExporterParameter.JASPER_PRINT,
					jasperPrint);
			jrExporter.setParameter(
					JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			jrExporter.setParameter(JRHtmlExporterParameter.IMAGES_URI,
					getEmailConfig().getUriImagen());
			jrExporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,
					"UTF-8");
			jrExporter.setParameter(
					JRHtmlExporterParameter.OUTPUT_STRING_BUFFER, result);
			jrExporter.exportReport();
		} catch (JRException e) {
			LOG.error(e.getMessage());
			throw new BuildEmailException(e.getMessage(), e);
		}
		return result.toString();
	}

	/**
	 * Gets the parameters.
	 * 
	 * @return the parameters
	 */
	protected abstract Map<String, String> getParameters();

	/**
	 * Gets the template email.
	 * 
	 * @return the template email
	 */
	protected abstract TemplateEmail getTemplateEmail();

	protected String cleanerHtml(final String string) {
		String result = string;
		return result.replace(emailConfig.getEmailContact(),
				emailConfig.getEmailContactFinal());
	}

	/**
	 * Make mail.
	 * 
	 * @param jrDataSource
	 *            the jr data source
	 * @return the string
	 * @throws BuildEmailException
	 *             the build email exception {@inheritDoc}
	 */
	public String makeMail(final I i) throws BuildEmailException {
		String result = "";
		LOG.info("Se inicia el proceso de creacion del email");

		JasperReport jasperReport = reportCompile();
		JasperPrint jasperPrint = getjasperPrint(jasperReport,
				new JRBeanCollectionDataSource(i));
		result = makeReport(jasperPrint);

		LOG.info("Se finaliza el proceso de creacion del email");
		if (LOG.isDebugEnabled()) {
			LOG.debug("El email generado es:");
			LOG.debug(result);
		}
		result = cleanerHtml(result);
		return result;
	}

}
