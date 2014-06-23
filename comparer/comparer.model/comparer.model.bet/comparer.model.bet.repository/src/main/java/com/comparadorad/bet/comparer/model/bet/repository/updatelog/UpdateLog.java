package com.comparadorad.bet.comparer.model.bet.repository.updatelog;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

@Component
public class UpdateLog {
	
	@Inject
	private ComparerWrapperLog LOG;
	
	
	public void errorLog(String msn){
		LOG.error(Thread.currentThread(), msn);
	}
}
