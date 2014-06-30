package com.comparadorad.bet.comparer.util.commons.path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TargetPathUtilTest {

	@Test
	public void getDbReadpathFile() {

		List<TargetPathUtilTest> list = new ArrayList<TargetPathUtilTest>();
		list.add(new TargetPathUtilTest());

		boolean addDate = false;
		boolean isExtended = true;

		String result = TargetPathUtil.getDbReadpathFile(list, isExtended,
				addDate, "pasandoCadena", TargetPathUtilTest.class);

		assertNotNull(result);

		String cadena = result.substring(result.indexOf("/target"));

		assertEquals(cadena,
				"/target/generated-xml/TargetPathUtilTest.extended.pasandoCadena.dbread.xml");
	}
}