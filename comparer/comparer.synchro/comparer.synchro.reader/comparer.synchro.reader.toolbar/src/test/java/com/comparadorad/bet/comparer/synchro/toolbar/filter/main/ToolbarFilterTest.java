package com.comparadorad.bet.comparer.synchro.toolbar.filter.main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.bean.ToolbarConfigurationBean;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.config.AbstractToolbarFilter;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.exception.ToolbarException;

public final class ToolbarFilterTest extends AbstractToolbarFilter {
	
	@Inject
	private ToolbarFilter filter;
	
	@Test
	public void test() throws ToolbarException{
		
		RtMatch rtMatch = new RtMatch();
		ToolbarConfigurationBean toolbarConfigurationBean = new ToolbarConfigurationBean(1000);
		Boolean result = Boolean.FALSE;
		
		assertNotNull(filter);
		
		result = filter.isNew(rtMatch, toolbarConfigurationBean);
		
		assertTrue(result);		
		
		result = filter.isNew(rtMatch, toolbarConfigurationBean);
		
		assertFalse(result);
		
		
	}

}
