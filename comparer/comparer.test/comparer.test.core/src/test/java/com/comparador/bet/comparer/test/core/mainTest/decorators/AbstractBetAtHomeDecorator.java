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
import java.util.List;

import com.comparador.bet.comparer.test.core.mainTest.AbstractTemplateMainTest;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.test.bean.beans.BeanBookmaker;

/**
 * The Class AbstractBetclickDecorator.
 */
public abstract class AbstractBetAtHomeDecorator extends
		AbstractTemplateMainTest {

	/** The Constant XML_LOCATION. */
	private static final String BETATHOME_XML_LOCATION_SHORT = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betAtHomeGanadorPartido1Bug3469.xml";
	
	/** The Constant XML_LOCATION. */
	private static final String BETATHOME_XML_LOCATION_SHORT_1 = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betAtHomeGanadorPartido2Bug3469.xml";
	
	/** The Constant XML_LOCATION. */
	private static final String BETCLICK_XML_LOCATION_SHORT = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betclickGanadorPartidoBug3469.xml";
	
	
	private static final Integer bookmakerOrder = 0;
	
	private static final BigInteger idBookmaker = new BigInteger("16");

	
	@Override
	protected List<BeanBookmaker> getBookmakersData() {
		List<BeanBookmaker> bookmakersData = new ArrayList<BeanBookmaker>();
		BeanBookmaker beanBookmaker = new BeanBookmaker();
		beanBookmaker.setXmlLocation(BETATHOME_XML_LOCATION_SHORT);
		beanBookmaker.setOrdenBookmaker(bookmakerOrder);
		beanBookmaker.setIdBookmaker(idBookmaker);
		beanBookmaker.setBookmaker(getBookmakerBH());
		beanBookmaker.setBeanAdditionalXmlInfoReader(new BeanAdditionalXmlInfoReader("", "", ""));
		bookmakersData.add(beanBookmaker);
		
		beanBookmaker = new BeanBookmaker();
		beanBookmaker.setXmlLocation(BETATHOME_XML_LOCATION_SHORT_1);
		beanBookmaker.setOrdenBookmaker(bookmakerOrder);
		beanBookmaker.setIdBookmaker(idBookmaker);
		beanBookmaker.setBookmaker(getBookmakerBH());
		beanBookmaker.setBeanAdditionalXmlInfoReader(new BeanAdditionalXmlInfoReader("", "", ""));
		bookmakersData.add(beanBookmaker);
		
		beanBookmaker = new BeanBookmaker();
		beanBookmaker.setXmlLocation(BETCLICK_XML_LOCATION_SHORT);
		beanBookmaker.setOrdenBookmaker(2);
		beanBookmaker.setIdBookmaker(new BigInteger("19"));
		beanBookmaker.setBookmaker(getBookmakerBC());
		beanBookmaker.setBeanAdditionalXmlInfoReader(new BeanAdditionalXmlInfoReader("", "", ""));
		bookmakersData.add(beanBookmaker);
		
		return bookmakersData;
	}
	

	private CfgBookmaker getBookmakerBH() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmaker);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT-5");
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http:\\www.betathome.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerBC() {
		CfgBookmaker bookmaker = new CfgBookmaker(new BigInteger("19"));
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http:\\www.betclick.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}


}
