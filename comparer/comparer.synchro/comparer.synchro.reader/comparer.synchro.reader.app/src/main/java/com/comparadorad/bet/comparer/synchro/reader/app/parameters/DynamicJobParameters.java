/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.app.parameters;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.stereotype.Component;

/**
 * The Class DynamicJobParameters.
 */
@Component
public class DynamicJobParameters implements JobParametersIncrementer {

	/**
	 * Gets the next.
	 *
	 * @param parameters the parameters
	 * @return the next
	 * {@inheritDoc}
	 */ 
	@Override
	public JobParameters getNext(JobParameters parameters) {
		JobParameters parametros = null;
		if (parameters == null || parameters.isEmpty()) {
			return new JobParametersBuilder().addLong("run.id", 1L)
					.toJobParameters();
		}
		long id = parameters.getLong("run.id", 1L) + 1;
		parametros = new JobParametersBuilder().addLong("run.id", id)
				.toJobParameters();

		return parametros;
	}

}
