/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.bookmaker;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class AbstractBookmakerProcess.
 */
public abstract class AbstractBookmakerProcess {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG; 
	
	/** The Constant PROCESS_LOG_INIT_STRING. */
	private static final String PROCESS_LOG_INIT_STRING = "[READER_APP] ";
	
	/** The step execution. */
	private StepExecution stepExecution;

	/**
	 * Gets the execution context.
	 * 
	 * @return the execution context
	 */
	protected ExecutionContext getExecutionContext() {
		ExecutionContext executionContext = this.stepExecution
				.getJobExecution().getExecutionContext();
		return executionContext;
	}

	/**
	 * Gets the log init string.
	 * 
	 * @return the log init string
	 */
	protected String getLogInitString() {
		return PROCESS_LOG_INIT_STRING;
	}

	/**
	 * Gets the step execution.
	 * 
	 * @return the step execution
	 */
	protected StepExecution getStepExecution() {
		return stepExecution;
	}

	/**
	 * Gets the step message chain.
	 * 
	 * @return the step message chain
	 */
	protected String getStepMessageChain() {
		return getStepMessageChain((CfgBookmaker) null);
	}

	/**
	 * Gets the step message chain.
	 * 
	 * @param bookmaker
	 *            the bookmaker
	 * @return the step message chain
	 */
	protected String getStepMessageChain(CfgBookmaker bookmaker) {
		StringBuffer message = new StringBuffer();
		message.append(getLogInitString());
		message.append("[JOB_EXECUTION_ID=")
				.append(stepExecution.getJobExecutionId()).append("]");
		message.append("[STEP_ID=").append(this.stepExecution.getId())
				.append("]");
		if (bookmaker != null) {
			message.append("[BOOKMAKER=")
					.append(bookmaker.getName(Locale.ENGLISH)).append("]");
		}
		return message.toString();
	}

	/**
	 * Gets the step message chain.
	 * 
	 * @param stepProcessData
	 *            the step process data
	 * @return the step message chain
	 */
	protected String getStepMessageChain(StepProcessData<?> stepProcessData) {
		if (stepProcessData == null) {
			return getStepMessageChain((CfgBookmaker) null);
		}

		return getStepMessageChain(stepProcessData.getCfgBookmaker());
	}

	/**
	 * Save step execution.
	 * 
	 * @param stepExecution
	 *            the step execution
	 */
	@BeforeStep
	public void saveStepExecution(StepExecution stepExecution) {
		LOG.debug(Thread.currentThread(), getLogInitString() + "Before executing: "
				+ this.getClass().getSimpleName());
		this.stepExecution = stepExecution;
	}
}
