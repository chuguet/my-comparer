package com.comparadorad.bet.comparer.synchro.toolbar.filter.plugin;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.bean.ToolbarConfigurationBean;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.config.AbstractToolbarFilter;
import com.comparadorad.bet.comparer.synchro.toolbar.filter.exception.ToolbarException;

public final class HashKeyToolbarFilterTest extends AbstractToolbarFilter {
	
	@Inject
	private HashKeyToolbarFilter filter;
	
	@Test
	public void test() throws ToolbarException{
		
		RtMatch rtMatch = new RtMatch();
		ToolbarConfigurationBean toolbarConfigurationBean = new ToolbarConfigurationBean(1000);
		Boolean result = Boolean.FALSE;
		
		assertNotNull(filter);
		
		filter.reset();
		
		result = filter.deleteElement(rtMatch, toolbarConfigurationBean);
		
		assertFalse(result);
		
		result = filter.deleteElement(rtMatch, toolbarConfigurationBean);
		
		assertTrue(result);
		
		
	}
}
