package com.comparadorad.bet.comparer.util.logger.core;

/**
 * Recubrimiento para log en el reader/process.
 * 
 * @author amuelas
 * 
 */
public interface ComparerWrapperLog {

	/**
	 * Debug.
	 * 
	 * @param thread
	 *            : hilo de ejecucion
	 * @param message
	 *            : mensaje de log
	 */
	void debug(Thread thread, String message);

	/**
	 * Info.
	 * 
	 * @param thread
	 *            : hilo de ejecucion
	 * @param message
	 *            : mensaje de log
	 */
	void info(Thread thread, String message);

	/**
	 * Warn.
	 * 
	 * @param thread
	 *            : hilo de ejecucion
	 * @param message
	 *            : mensaje de log
	 */
	void warn(Thread thread, String message, Exception exception);
	
	void warn(Thread thread, String message);
	/**
	 * Error.
	 * 
	 * @param thread
	 *            : hilo de ejecucion
	 * @param message
	 *            : mensaje de log
	 */
	void error(Thread thread, String message, Exception exception);
	
	void error(Thread thread, String message);

	/**
	 * Fatal.
	 * 
	 * @param thread
	 *            : hilo de ejecucion
	 * @param message
	 *            : mensaje de log
	 */
	void fatal(Thread thread, String message, Exception exception);
	void fatal(Thread thread, String message);

}
