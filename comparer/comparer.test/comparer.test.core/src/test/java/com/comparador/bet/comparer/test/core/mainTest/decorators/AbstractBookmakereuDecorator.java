/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparador.bet.comparer.test.core.mainTest.decorators;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.test.bean.beans.BeanBookmaker;

/**
 * The Class AbstractBookmakereuDecorator.
 */
public abstract class AbstractBookmakereuDecorator extends
		AbstractTemplateMainTest {

	/** The Constant XML_LOCATION. */
	private static final String BC_XML_LOCATION_SHORT = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\bookmakereuCompleto.xml";

	private static final Integer bookmakerOrder = 10;

	private static final BigInteger idBookmaker = new BigInteger("42");

	@Override
	protected List<BeanBookmaker> getBookmakersData() {
		List<BeanBookmaker> bookmakersData = new ArrayList<BeanBookmaker>();
		BeanBookmaker beanBookmaker = new BeanBookmaker();
		beanBookmaker.setXmlLocation(BC_XML_LOCATION_SHORT);
		beanBookmaker.setOrdenBookmaker(bookmakerOrder);
		beanBookmaker.setIdBookmaker(idBookmaker);
		beanBookmaker.setBookmaker(getBookmaker());
		BeanAdditionalXmlInfoReader beanAdiAdditionalXmlInfoReader = new BeanAdditionalXmlInfoReader(
				"", "", "");
		Map<String, String> deporte_torneo = new HashMap<String, String>();
		deporte_torneo.put("12251", "Soccer");
		deporte_torneo.put("12068", "Soccer");
		beanAdiAdditionalXmlInfoReader.setMapLeaguesBySport(deporte_torneo);
		beanBookmaker
				.setBeanAdditionalXmlInfoReader(beanAdiAdditionalXmlInfoReader);
		bookmakersData.add(beanBookmaker);

		return bookmakersData;
	}

	private CfgBookmaker getBookmaker() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmaker);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl(
				"http://www.bookmaker.eu"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}

}
