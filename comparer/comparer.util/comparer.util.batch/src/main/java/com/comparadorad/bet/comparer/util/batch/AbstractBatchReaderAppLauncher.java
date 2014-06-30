/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.util.batch;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;

import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

/**
 * The Class AbstractBatchReaderAppLauncher.
 */

public abstract class AbstractBatchReaderAppLauncher {

	/** The Constant LOG. */
	@Inject
	private ComparerWrapperLog LOG;
	

	/** The application context. */
	@Inject
	private ApplicationContext applicationContext;

	/** The job launcher. */
	@Inject
	private JobLauncher jobLauncher;
	
	private Integer stepCount;
	
	private Long total;
	
	{
		stepCount = 0;
		total = 0L;
		
	}

	/**
	 * Launch.
	 */
	protected abstract void launch();

	/**
	 * Gets the job name.
	 * 
	 * @return the job name
	 */
	protected abstract String getJobName();	

	/**
	 * Launch.
	 */
	public void launchJobs() {
		JobParameters jobParameters = new JobParametersBuilder().addLong(
				"time", System.currentTimeMillis()).toJobParameters();
		JobExecution execution;
		Long now;
		Date startDate;
		try {
			Job job = applicationContext.getBean(getJobName(), Job.class);
			startDate = new Date();
			execution = jobLauncher.run(job, jobParameters);
			now = ((new Date().getTime() - startDate.getTime()) / 1000);
			total += now;
			LOG.info(Thread.currentThread(), new StringBuffer("Exit Status").append(execution.getStatus()).toString());
			LOG.info(Thread.currentThread(), new StringBuffer("Es la vuelta ").append(stepCount++).toString());
			LOG.info(Thread.currentThread(), new StringBuffer(
					"El tiempo que ha tardado esta ejecucion es: ").append(now).append(" segundos").toString());
			LOG.info(Thread.currentThread(), new StringBuffer("El tiempo medio de las ejecuciones es ").append(total/stepCount).append(" segundos").toString());
		} catch (JobExecutionAlreadyRunningException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		} catch (JobRestartException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		} catch (JobInstanceAlreadyCompleteException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		} catch (JobParametersInvalidException e) {
			LOG.error(Thread.currentThread(), e.getMessage(), e);
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}