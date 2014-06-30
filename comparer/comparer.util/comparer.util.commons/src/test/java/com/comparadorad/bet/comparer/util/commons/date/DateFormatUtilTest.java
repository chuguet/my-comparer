package com.comparadorad.bet.comparer.util.commons.date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;

public class DateFormatUtilTest {
	
	@Test
	public void getDate() {
		String removeChars[]={":", "*"};
		DateFormatUtil dateFormatUtil = new DateFormatUtil("dd/MM/yyyy", removeChars, "GMT+1");
		
		Date date = dateFormatUtil.getDate("19/04/2013");
		
		assertNotNull(date);
		assertEquals(date.toString(), "Fri Apr 19 01:00:00 CEST 2013");
	}
	
	@Test
	public void getZeroGmtDate() {
		String removeChars[]={":", "*"};
		DateFormatUtil dateFormatUtil = new DateFormatUtil("dd/MM/yyyy", removeChars);
		
		Date date = dateFormatUtil.getZeroGmtDate("19/04/2013");
		
		assertNotNull(date);
		assertEquals(date.toString(), "Fri Apr 19 00:00:00 CEST 2013");
	}
	
	@Test
	public void format() {
		DateFormatUtil dateFormatUtil = new DateFormatUtil("dd/MM/yyyy");
		Date date = new Date();
		
		String result = dateFormatUtil.format(date);
		
		assertNotNull(result);
	}
}
