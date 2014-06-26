/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.processbookmaker.convert.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.comparadorad.bet.comparer.model.bet.bean.MasMenos;
import com.comparadorad.bet.comparer.model.bet.bean.Result;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2Attribute;
import com.comparadorad.bet.comparer.model.bet.bean.Rt1X2HandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtAsianHandicapAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtGanadorPartidoAttribute;
import com.comparadorad.bet.comparer.model.bet.bean.RtMasMenosAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.IXmlAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2Attribute;
import com.comparadorad.bet.comparer.synchro.reader.model.Xml1X2HandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlAsianHandicapAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchParticipant;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatchWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlMoreLessAttribute;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlWinnerAttribute;
import com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest;

/**
 * The Class XmlAttributeToRtAttributeTest.
 */
public class XmlAttributeToRtAttributeTest extends AbstractTest {

	/** The xml attribute to rt attribute. */
	@Inject
	private XmlAttributeToRtAttribute xmlAttributeToRtAttribute;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.synchro.reader.processbookmaker.AbstractTest
	 * #test()
	 */
	@Override
	@Test
	public void test() {
		IXmlAttribute xmlAttribute = new Xml1X2Attribute();
		((Xml1X2Attribute) xmlAttribute).setResult(Result.ONE);
		Rt1X2Attribute result = (Rt1X2Attribute) xmlAttributeToRtAttribute.convert(null, xmlAttribute, null, null);
		assertNotNull(result);
		assertTrue(result.getResult().equals(Result.ONE));
	}

	/**
	 * Test1x2 handicap.
	 */
	@Test
	public void test1x2Handicap() {
		IXmlAttribute xmlAttribute = new Xml1X2HandicapAttribute();
		((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.ONE);
		((Xml1X2HandicapAttribute) xmlAttribute).setFirstValue(0.5);
		((Xml1X2HandicapAttribute) xmlAttribute).setSecondValue(0.0);
		Rt1X2HandicapAttribute result = (Rt1X2HandicapAttribute) xmlAttributeToRtAttribute.convert(null, xmlAttribute, null, null);
		assertNotNull(result);
		assertTrue(result.getResult().equals(Result.ONE));
		assertTrue(result.getFinalValue().equals(0.25));
		assertTrue(result.getFirstValue().equals(0.5));
		assertTrue(result.getSecondValue().equals(0.0));
		
		xmlAttribute = new Xml1X2HandicapAttribute();
		((Xml1X2HandicapAttribute) xmlAttribute).setResult(Result.ONE);
		((Xml1X2HandicapAttribute) xmlAttribute).setFirstValue(0.5);
		result = (Rt1X2HandicapAttribute) xmlAttributeToRtAttribute.convert(null, xmlAttribute, null, null);
		assertNotNull(result);
		assertTrue(result.getResult().equals(Result.ONE));
		assertTrue(result.getFinalValue().equals(0.5));
		assertTrue(result.getFirstValue().equals(0.5));
		assertNull(result.getSecondValue());
	}

	/**
	 * Test handicap asiatico.
	 */
	@Test
	public void testHandicapAsiatico() {
		IXmlAttribute xmlAttribute = new XmlAsianHandicapAttribute();
		((XmlAsianHandicapAttribute) xmlAttribute).setFirstValue(1.5);
		((XmlAsianHandicapAttribute) xmlAttribute).setSecondValue(2.0);
		RtAsianHandicapAttribute result = (RtAsianHandicapAttribute) xmlAttributeToRtAttribute.convert(null, xmlAttribute, null, null);
		assertNotNull(result);
		assertTrue(result.getFirstValue().equals(1.5));
		assertTrue(result.getSecondValue().equals(2.0));
		assertTrue(result.getFinalValue().equals(1.75));
		
		xmlAttribute = new XmlAsianHandicapAttribute();
		((XmlAsianHandicapAttribute) xmlAttribute).setFirstValue(1.5);
		result = (RtAsianHandicapAttribute) xmlAttributeToRtAttribute.convert(null, xmlAttribute, null, null);
		assertNotNull(result);
		assertTrue(result.getFirstValue().equals(1.5));
		assertNull(result.getSecondValue());
		assertTrue(result.getFinalValue().equals(1.5));
	}

	/**
	 * Test ganador.
	 */
	@Test
	public void testGanador() {
		IXmlAttribute xmlAttribute = new XmlWinnerAttribute();
		((XmlWinnerAttribute) xmlAttribute).setWinner(new XmlMatchParticipant("Guadalajara", tournament));
		RtGanadorAttribute result = (RtGanadorAttribute) xmlAttributeToRtAttribute.convert(null, xmlAttribute, null, null);
		assertNotNull(result);
		assertTrue(result.getWinnerName().equals("Guadalajara"));
	}

	/**
	 * Test ganador partido.
	 */
	@Test
	public void testGanadorPartido() {
		IXmlAttribute xmlAttribute = new XmlMatchWinnerAttribute();
		((XmlMatchWinnerAttribute) xmlAttribute).setWinnerName(new XmlMatchParticipant("Guadalajara", tournament));
		RtGanadorPartidoAttribute result = (RtGanadorPartidoAttribute) xmlAttributeToRtAttribute.convert(null, xmlAttribute, null, null);
		assertNotNull(result);
		assertTrue(result.getWinnerName().equals("Guadalajara"));
	}

	/**
	 * Test mas menos.
	 */
	@Test
	public void testMasMenos() {
		IXmlAttribute xmlAttribute = new XmlMoreLessAttribute();
		((XmlMoreLessAttribute) xmlAttribute).setMasMenos(MasMenos.MAS);
		((XmlMoreLessAttribute) xmlAttribute).setTotalGoal(2.0);
		RtMasMenosAttribute result = (RtMasMenosAttribute) xmlAttributeToRtAttribute.convert(null, xmlAttribute, null, null);
		assertNotNull(result);
		assertTrue(result.getMasMenos().equals(MasMenos.MAS));
		assertTrue(result.getTotalGoalValue().equals(2.0));
		assertTrue(result.getFinalValue().equals(2.0));
	}

}
