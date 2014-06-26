package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.xml.resolver.impl;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.RtMatch;
import com.comparadorad.bet.comparer.model.config.bean.LongTerm;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.exception.BetBySportNotAllowedException;

public class RtMatchNameResolverTest extends AbstractTest{

	@Inject
	private RtMatchNameResolver nameResolver;
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
	@Test
	public void resolveNameField() throws BetBySportNotAllowedException {
		RtMatch rtMatch = getRtMatch();
		
		assertNotNull(nameResolver.resolveNameField(rtMatch));
	}
	

}
