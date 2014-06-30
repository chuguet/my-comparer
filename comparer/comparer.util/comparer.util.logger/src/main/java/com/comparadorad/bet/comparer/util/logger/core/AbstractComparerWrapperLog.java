/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.logger.core;

import java.util.Date;

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
	protected Logger logger = Logger.getRootLogger();

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
			String retval = String.valueOf(new StringBuffer().append(methodName).append(" | ").append(lineNumber).append(" | ")
					.append("[ThreadId: ").append(Thread.currentThread().getId()).append("] | ").append(originalLog).toString());
			return retval;
		}
	}

	/**
	 * Clase que se encarga de obtener todos los parametros necesarios para el
	 * log asi como el logger y el loggingEvent.
	 * 
	 * @param thread
	 *            El hilo de ejecucion que ha generado la traza
	 * @param message
	 *            El mensaje de la traza
	 * @param milliseconds
	 *            El tiempo de ejecucion de la traza para evitar que el log por
	 *            lo que sea si imprime tarde ya tenemos el tiempo en
	 *            milisegundos en el instante de la llamada.
	 * @return the log info parameters La traza formateada final.
	 */
	@SuppressWarnings("static-access")
	protected String getLogInfoParameters(Thread thread, final String message, final long milliseconds, Level logLevel) {
		String finalLogMessage = "";
		if (message == null) {
			finalLogMessage = new StringBuffer().append(new Date(milliseconds)).toString();
		} else {
			finalLogMessage = new StringBuffer(message).append(" | ").append(new Date(milliseconds)).toString();
		}
		
		if (thread != null) {
			fullClassName = thread.currentThread().getStackTrace()[3].getClassName();
			methodName = thread.currentThread().getStackTrace()[3].getMethodName();
			lineNumber = thread.currentThread().getStackTrace()[3].getLineNumber();
			logger = Logger.getLogger(fullClassName);
			loggingEvent = new LoggingEvent(fullClassName, logger, logLevel, finalLogMessage, null);
			OwnLayout own = new OwnLayout();
			finalLogMessage = own.format(loggingEvent).trim();
		}
		return finalLogMessage;
	}
}
