/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.log.core;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;

/**
 * The Class AbstractComparerWrapperLog.
 */
public abstract class AbstractComparerWrapperLog implements ComparerWrapperLog {

	/** The full class name. */
	protected String fullClassName = "";

	/** The method name. */
	protected String methodName = "";

	/** The line number. */
	protected int lineNumber = 0;

	/** The logger. */
	protected Logger logger;

	/** The logging event. */
	protected LoggingEvent loggingEvent;

	/**
	 * Clase interna necesaria para sobreescribir el patron de escritura del
	 * logger ya que no podemos obtener via fichero de configuracion el id de
	 * hilo, ademas aprovechamos y ponemos el nombre de linea en el ya que por
	 * recomendación de apache no es conveniente por rendimiento.
	 * 
	 * @author amuelas
	 * 
	 */
	private class OwnLayout extends PatternLayout {

		/** {@inheritDoc} */
		public String format(LoggingEvent event) {
			String originalLog = super.format(event);
			String retval = String.valueOf(new StringBuffer().append(methodName).append(" - ").append(lineNumber).append(" - ")
					.append("[ThreadId: ").append(Thread.currentThread().getId()).append("] - ").append(originalLog).toString());
			return retval;
		}
	}

	/**
	 * Clase que se encarga de obtener todos los parametros necesarios para el
	 * log asi como el logger y el loggingEvent.
	 * 
	 * @param thread
	 *            the thread
	 * @param message
	 *            the message
	 * @return the log info parameters
	 */
	@SuppressWarnings("static-access")
	protected String getLogInfoParameters(Thread thread, final String message) {
		String finalLogMessage = "";
		fullClassName = thread.currentThread().getStackTrace()[3].getClassName();
		methodName = thread.currentThread().getStackTrace()[3].getMethodName();
		lineNumber = thread.currentThread().getStackTrace()[3].getLineNumber();
		logger = Logger.getLogger(fullClassName);
		loggingEvent = new LoggingEvent(fullClassName, logger, Level.DEBUG, message, null);
		OwnLayout own = new OwnLayout();
		finalLogMessage = own.format(loggingEvent);
		return finalLogMessage;
	}
}
