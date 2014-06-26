/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.log.bean;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.comparadorad.bet.comparer.model.core.bean.AbstractId;
import com.comparadorad.bet.comparer.model.core.bean.IDocument;

/**
 * The Class LogSynchroErrorEvent.
 */
@SuppressWarnings("serial")
@Document
public class LogEvent extends AbstractId implements IDocument {

	/**
	 * The Class LogLevel. based on log4j level
	 */
	public static class LogLevel {
		/**
		 * The <code>ALL</code> has the lowest possible rank and is intended to
		 * turn on all logging.
		 */
		public final static LogLevel ALL = new LogLevel(Integer.MIN_VALUE,
				"ALL", 7);
		/**
		 * The <code>DEBUG</code> LogLevel designates fine-grained informational
		 * events that are most useful to debug an application.
		 */
		final static public LogLevel DEBUG = new LogLevel(10000, "DEBUG", 7);

		/** The Constant ERROR. */
		final static public LogLevel ERROR = new LogLevel(40000, "ERROR", 3);

		/**
		 * The <code>INFO</code> LogLevel designates informational messages that
		 * highlight the progress of the application at coarse-grained LogLevel.
		 */
		final static public LogLevel INFO = new LogLevel(20000, "INFO", 6);

		/** The Constant OFF_INT. */
		public final static int OFF_INT = Integer.MAX_VALUE;

		/**
		 * The <code>TRACE</code> LogLevel designates finer-grained
		 * informational events than the <code>DEBUG</code LogLevel.
		 * 
		 * @since 1.2.12
		 */
		public static final LogLevel TRACE = new LogLevel(5000, "TRACE", 7);

		/**
		 * The <code>WARN</code> LogLevel designates potentially harmful
		 * situations.
		 */
		final static public LogLevel WARN = new LogLevel(30000, "WARN", 4);

		/** The level. */
		@Field
		private int level;

		/** The level str. */
		@Field
		private String levelStr;

		/** The syslog equivalent. */
		@Field
		private int syslogEquivalent;

		/**
		 * Instantiates a new log LogLevel.
		 */
		public LogLevel() {
			super();
		}

		/**
		 * Instantiates a new log level.
		 * 
		 * @param level
		 *            the level
		 * @param levelStr
		 *            the level str
		 * @param syslogEquivalent
		 *            the syslog equivalent
		 */
		protected LogLevel(int level, String levelStr, int syslogEquivalent) {
			this.level = level;
			this.levelStr = levelStr;
			this.syslogEquivalent = syslogEquivalent;
		}

		/**
		 * Gets the level.
		 * 
		 * @return the level
		 */
		public int getLevel() {
			return level;
		}

		/**
		 * Gets the level str.
		 * 
		 * @return the level str
		 */
		public String getLevelStr() {
			return levelStr;
		}

		/**
		 * Gets the syslog equivalent.
		 * 
		 * @return the syslog equivalent
		 */
		public int getSyslogEquivalent() {
			return syslogEquivalent;
		}

		/**
		 * Sets the level.
		 * 
		 * @param pLevel
		 *            the new level
		 */
		public void setLevel(int pLevel) {
			level = pLevel;
		}

		/**
		 * Sets the level str.
		 * 
		 * @param pLevelStr
		 *            the new level str
		 */
		public void setLevelStr(String pLevelStr) {
			levelStr = pLevelStr;
		}

		/**
		 * Sets the syslog equivalent.
		 * 
		 * @param pSyslogEquivalent
		 *            the new syslog equivalent
		 */
		public void setSyslogEquivalent(int pSyslogEquivalent) {
			syslogEquivalent = pSyslogEquivalent;
		}
	}

	/**
	 * The Enum LogState.
	 */
	public static enum LogState {

		/** The NEW. */
		NEW("NEW"),
		/** The DAT a_ ap p_ readed. */
		DATA_APP_READED("DATA_APP_READED"),
		/** The DAT a_ ap p_ d b_ updated. */
		DATA_APP_DB_UPDATED("DATA_APP_DB_UPDATED"),
		/** The DAT a_ error. */
		DATA_ERROR("DATA_ERROR");

		/** The state. */
		private String state;

		/**
		 * Instantiates a new log state.
		 * 
		 * @param pState
		 *            the state
		 */
		LogState(String pState) {
			this.state = pState;
		}

		/**
		 * Gets the state.
		 * 
		 * @return the state
		 */
		public String getState() {
			return state;
		}
	}

	/** The data. */
	@Field
	private Object data;

	/** The log LogLevel. */
	@Field
	private LogLevel logLevel;

	/** The data. */
	@Field
	private LogState logState;

	/** The message. */
	@Field
	@Indexed(unique = true)
	private String message;

	/** The process id. */
	@Field
	private String processId;

	/** The error date. */
	@Field
	private Date errorDate;

	/**
	 * Gets the error date.
	 * 
	 * @return the error date
	 */
	public Date getErrorDate() {
		return errorDate;
	}

	/**
	 * Instantiates a new log synchro error event.
	 */
	public LogEvent() {
		super();
	}

	/**
	 * Instantiates a new log synchro error event.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public LogEvent(BigInteger pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new log synchro error event.
	 * 
	 * @param pObjectId
	 *            the object id
	 */
	public LogEvent(String pObjectId) {
		super(pObjectId);
	}

	/**
	 * Instantiates a new log synchro error event.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pLogLevel
	 *            the log LogLevel
	 * @param pErrorDate
	 *            the error date
	 */
	public LogEvent(String pProcessId, String pMessage,
			final LogLevel pLogLevel, Date pErrorDate) {
		super();
		processId = pProcessId;
		message = pMessage;
		logLevel = pLogLevel;
		errorDate = pErrorDate;
	}

	/**
	 * Instantiates a new log synchro error event.
	 * 
	 * @param pProcessId
	 *            the process id
	 * @param pMessage
	 *            the message
	 * @param pData
	 *            the data
	 * @param pLogLevel
	 *            the log LogLevel
	 * @param pLogState
	 *            the log state
	 * @param pErrorDate
	 *            the error date
	 */
	public LogEvent(String pProcessId, String pMessage, Object pData,
			final LogLevel pLogLevel, final LogState pLogState, Date pErrorDate) {
		super();
		processId = pProcessId;
		message = pMessage;
		data = pData;
		logLevel = pLogLevel;
		this.logState = pLogState;
		errorDate = pErrorDate;
	}

	/**
	 * Gets the data.
	 * 
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * Gets the log LogLevel.
	 * 
	 * @return the log LogLevel
	 */
	public LogLevel getLogLevel() {
		return logLevel;
	}

	/**
	 * Gets the log state.
	 * 
	 * @return the log state
	 */
	public LogState getLogState() {
		return logState;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the process id.
	 * 
	 * @return the process id
	 */
	public String getProcessId() {
		return processId;
	}

	/**
	 * Sets the data.
	 * 
	 * @param pData
	 *            the new data
	 */
	public void setData(Object pData) {
		data = pData;
	}

	/**
	 * Sets the log LogLevel.
	 * 
	 * @param pLogLevel
	 *            the new log LogLevel
	 */
	public void setLogLevel(LogLevel pLogLevel) {
		logLevel = pLogLevel;
	}

	/**
	 * Sets the log state.
	 * 
	 * @param pLogState
	 *            the new log state
	 */
	public void setLogState(LogState pLogState) {
		logState = pLogState;
	}

	/**
	 * Sets the message.
	 * 
	 * @param pMessage
	 *            the new message
	 */
	public void setMessage(String pMessage) {
		message = pMessage;
	}

	/**
	 * Sets the process id.
	 * 
	 * @param pProcessId
	 *            the new process id
	 */
	public void setProcessId(String pProcessId) {
		processId = pProcessId;
	}

	/**
	 * Sets the error date.
	 * 
	 * @param errorDate
	 *            the new error date
	 */
	public void setErrorDate(Date errorDate) {
		this.errorDate = errorDate;
	}

}
