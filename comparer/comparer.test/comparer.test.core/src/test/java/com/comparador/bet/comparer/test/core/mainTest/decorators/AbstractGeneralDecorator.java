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
public abstract class AbstractGeneralDecorator extends
		AbstractTemplateMainTest {

	/** The Constant XML_LOCATION_BETCLICK. */
	private static final String BC_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betclickCompleto.xml";
	private static final Integer bookmakerOrderBC = 2;
	private static final BigInteger idBookmakerBC = new BigInteger("19");
	
	/** The Constant XML_LOCATION_BETFRED. */
	private static final String BF_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betfredCompleto.xml";
	private static final Integer bookmakerOrderBF = 3;
	private static final BigInteger idBookmakerBF = new BigInteger("26");
	
	/** The Constant XML_LOCATION_BS. */
	private static final String BS_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\boylesportsCompleto.xml";
	private static final Integer bookmakerOrderBS = 11;
	private static final BigInteger idBookmakerBS = new BigInteger("43");
	
	/** The Constant XML_LOCATION_EX. */
//	private static final String EX_XML_LOCATION_COMPLETE = getProjectDir()
//			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
//			+ "\\test\\core\\xmlReaders\\expektCompleto.xml";
	private static final Integer bookmakerOrderEX = 12;
	private static final BigInteger idBookmakerEX = new BigInteger("56");
	
	/** The Constant XML_LOCATION_IT. */
	private static final String IT_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\intertopsCompleto.xml";
	private static final Integer bookmakerOrderIT = 13;
	private static final BigInteger idBookmakerIT = new BigInteger("69");
	
	/** The Constant XML_LOCATION_NB. */
	private static final String NB_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\nordicbetCompleto.xml";
	private static final Integer bookmakerOrderNB = 15;
	private static final BigInteger idBookmakerNB = new BigInteger("77");
	
	/** The Constant XML_LOCATION_PS. */
	private static final String PS_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\pinnaclesportsCompleto.xml";
	private static final Integer bookmakerOrderPS = 16;
	private static final BigInteger idBookmakerPS = new BigInteger("85");
	
	/** The Constant XML_LOCATION_WH. */
	private static final String WH_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\williamhillCompleto.xml";
	private static final Integer bookmakerOrderWH = 22;
	private static final BigInteger idBookmakerWH = new BigInteger("105");
	
	/** The Constant XML_LOCATION_YW. */
	private static final String YW_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\youwinCompleto.xml";
	private static final Integer bookmakerOrderYW = 23;
	private static final BigInteger idBookmakerYW = new BigInteger("106");
	
	/** The Constant XML_LOCATION_IW. */
	private static final String IW_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\interwettenCompleto.xml";
	private static final Integer bookmakerOrderIW = 14;
	private static final BigInteger idBookmakerIW = new BigInteger("109");
	
	/** The Constant XML_LOCATION_BB. */
	private static final String BB_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betbooCompleto.xml";
	private static final Integer bookmakerOrderBB = 1;
	private static final BigInteger idBookmakerBB = new BigInteger("17");
	
	/** The Constant XML_LOCATION_BO. */
	private static final String BO_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betonlineCompleto.xml";
	private static final Integer bookmakerOrderBO = 5;
	private static final BigInteger idBookmakerBO = new BigInteger("33");
	
	/** The Constant XML_LOCATION_BSQ. */
	private static final String BSQ_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\bluesquareCompleto.xml";
	private static final Integer bookmakerOrderBSQ = 7;
	private static final BigInteger idBookmakerBSQ = new BigInteger("40");
	
	/** The Constant XML_LOCATION_BG. */
	private static final String BG_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betgunCompleto.xml";
	private static final Integer bookmakerOrderBG = 4;
	private static final BigInteger idBookmakerBG = new BigInteger("27");
	
	/** The Constant XML_LOCATION_BH. */
	private static final String BH_XML_LOCATION_COMPLETE = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\test\\core\\xmlReaders\\betathomeCompleto.xml";
	private static final Integer bookmakerOrderBH = 0;
	private static final BigInteger idBookmakerBH = new BigInteger("16");
	
	@Override
	protected List<BeanBookmaker> getBookmakersData() {
		List<BeanBookmaker> bookmakersData = new ArrayList<BeanBookmaker>();
		
		BeanBookmaker beanBookmakerBC = new BeanBookmaker();
		beanBookmakerBC.setXmlLocation(BC_XML_LOCATION_COMPLETE);
		beanBookmakerBC.setOrdenBookmaker(bookmakerOrderBC);
		beanBookmakerBC.setIdBookmaker(idBookmakerBC);
		beanBookmakerBC.setBookmaker(getBookmakerBC());
		bookmakersData.add(beanBookmakerBC);
		
		BeanBookmaker beanBookmakerBF = new BeanBookmaker();
		beanBookmakerBF.setXmlLocation(BF_XML_LOCATION_COMPLETE);
		beanBookmakerBF.setOrdenBookmaker(bookmakerOrderBF);
		beanBookmakerBF.setIdBookmaker(idBookmakerBF);
		beanBookmakerBF.setBookmaker(getBookmakerBF());
		bookmakersData.add(beanBookmakerBF);
		
		BeanBookmaker beanBookmakerBS = new BeanBookmaker();
		beanBookmakerBS.setXmlLocation(BS_XML_LOCATION_COMPLETE);
		beanBookmakerBS.setOrdenBookmaker(bookmakerOrderBS);
		beanBookmakerBS.setIdBookmaker(idBookmakerBS);
		beanBookmakerBS.setBookmaker(getBookmakerBS());
		bookmakersData.add(beanBookmakerBS);
		
//		BeanBookmaker beanBookmakerEX = new BeanBookmaker();
//		beanBookmakerEX.setXmlLocation(EX_XML_LOCATION_COMPLETE);
//		beanBookmakerEX.setOrdenBookmaker(bookmakerOrderEX);
//		beanBookmakerEX.setIdBookmaker(idBookmakerEX);
//		beanBookmakerEX.setBookmaker(getBookmakerEX());
//		bookmakersData.add(beanBookmakerEX);
		
		BeanBookmaker beanBookmakerIT = new BeanBookmaker();
		beanBookmakerIT.setXmlLocation(IT_XML_LOCATION_COMPLETE);
		beanBookmakerIT.setOrdenBookmaker(bookmakerOrderIT);
		beanBookmakerIT.setIdBookmaker(idBookmakerIT);
		beanBookmakerIT.setBookmaker(getBookmakerIT());
		bookmakersData.add(beanBookmakerIT);
		
//		BeanBookmaker beanBookmakerNB = new BeanBookmaker();
//		beanBookmakerNB.setXmlLocation(NB_XML_LOCATION_COMPLETE);
//		beanBookmakerNB.setOrdenBookmaker(bookmakerOrderNB);
//		beanBookmakerNB.setIdBookmaker(idBookmakerNB);
//		beanBookmakerNB.setBookmaker(getBookmakerNB());
//		bookmakersData.add(beanBookmakerNB);
		
		BeanBookmaker beanBookmakerPS = new BeanBookmaker();
		beanBookmakerPS.setXmlLocation(PS_XML_LOCATION_COMPLETE);
		beanBookmakerPS.setOrdenBookmaker(bookmakerOrderPS);
		beanBookmakerPS.setIdBookmaker(idBookmakerPS);
		beanBookmakerPS.setBookmaker(getBookmakerPS());
		bookmakersData.add(beanBookmakerPS);
		
		BeanBookmaker beanBookmakerWH = new BeanBookmaker();
		beanBookmakerWH.setXmlLocation(WH_XML_LOCATION_COMPLETE);
		beanBookmakerWH.setOrdenBookmaker(bookmakerOrderWH);
		beanBookmakerWH.setIdBookmaker(idBookmakerWH);
		beanBookmakerWH.setBookmaker(getBookmakerWH());
		bookmakersData.add(beanBookmakerWH);
		
		BeanBookmaker beanBookmakerYW = new BeanBookmaker();
		beanBookmakerYW.setXmlLocation(YW_XML_LOCATION_COMPLETE);
		beanBookmakerYW.setOrdenBookmaker(bookmakerOrderYW);
		beanBookmakerYW.setIdBookmaker(idBookmakerYW);
		beanBookmakerYW.setBookmaker(getBookmakerYW());
		bookmakersData.add(beanBookmakerYW);
		
		BeanBookmaker beanBookmakerIW = new BeanBookmaker();
		beanBookmakerIW.setXmlLocation(IW_XML_LOCATION_COMPLETE);
		beanBookmakerIW.setOrdenBookmaker(bookmakerOrderIW);
		beanBookmakerIW.setIdBookmaker(idBookmakerIW);
		beanBookmakerIW.setBookmaker(getBookmakerIW());
		bookmakersData.add(beanBookmakerIW);
		
		BeanBookmaker beanBookmakerBB = new BeanBookmaker();
		beanBookmakerBB.setXmlLocation(BB_XML_LOCATION_COMPLETE);
		beanBookmakerBB.setOrdenBookmaker(bookmakerOrderBB);
		beanBookmakerBB.setIdBookmaker(idBookmakerBB);
		beanBookmakerBB.setBookmaker(getBookmakerBB());
		bookmakersData.add(beanBookmakerBB);
		
//		BeanBookmaker beanBookmakerBO = new BeanBookmaker();
//		beanBookmakerBO.setXmlLocation(BO_XML_LOCATION_COMPLETE);
//		beanBookmakerBO.setOrdenBookmaker(bookmakerOrderBO);
//		beanBookmakerBO.setIdBookmaker(idBookmakerBO);
//		beanBookmakerBO.setBookmaker(getBookmakerBO());
//		bookmakersData.add(beanBookmakerBO);
		
//		BeanBookmaker beanBookmakerBSQ = new BeanBookmaker();
//		beanBookmakerBSQ.setXmlLocation(BSQ_XML_LOCATION_COMPLETE);
//		beanBookmakerBSQ.setOrdenBookmaker(bookmakerOrderBSQ);
//		beanBookmakerBSQ.setIdBookmaker(idBookmakerBSQ);
//		beanBookmakerBSQ.setBookmaker(getBookmakerBSQ());
//		bookmakersData.add(beanBookmakerBSQ);
		
		BeanBookmaker beanBookmakerBG = new BeanBookmaker();
		beanBookmakerBG.setXmlLocation(BG_XML_LOCATION_COMPLETE);
		beanBookmakerBG.setOrdenBookmaker(bookmakerOrderBG);
		beanBookmakerBG.setIdBookmaker(idBookmakerBG);
		beanBookmakerBG.setBookmaker(getBookmakerBG());
		BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader = new BeanAdditionalXmlInfoReader("", "World Cup", "");
		beanBookmakerBG.setBeanAdditionalXmlInfoReader(beanAdditionalXmlInfoReader);
		bookmakersData.add(beanBookmakerBG);
		
		
//		BeanBookmaker beanBookmakerBH = new BeanBookmaker();
//		beanBookmakerBH.setXmlLocation(BH_XML_LOCATION_COMPLETE);
//		beanBookmakerBH.setOrdenBookmaker(bookmakerOrderBH);
//		beanBookmakerBH.setIdBookmaker(idBookmakerBH);
//		beanBookmakerBH.setBookmaker(getBookmakerBH());
//		bookmakersData.add(beanBookmakerBH);
		
		return bookmakersData;
	}
	

	private CfgBookmaker getBookmakerBC() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerBC);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http:\\www.betclick.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}

	private CfgBookmaker getBookmakerBF() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerBF);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.betfred.com/"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerBS() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerBS);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.BoyleSports.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
//	private CfgBookmaker getBookmakerEX() {
//		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerEX);
//		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
//		bookmakerConfiguration.setTimeZone("GMT+1");
//		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.Expekt.com"));
//		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
//		return bookmaker;
//	}
	
	private CfgBookmaker getBookmakerIT() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerIT);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.Intertops.eu"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerNB() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerNB);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+2");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.Nordicbet.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerPS() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerPS);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.Pinnaclesports.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerWH() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerWH);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.williamhill.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerYW() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerYW);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.YouWin.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerIW() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerIW);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("https://www.interwetten.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerBB() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerBB);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.betboo.com/"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerBO() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerBO);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.Betonline.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerBSQ() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerBSQ);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.bluesq.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerBG() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerBG);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.betgun.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
	
	private CfgBookmaker getBookmakerBH() {
		CfgBookmaker bookmaker = new CfgBookmaker(idBookmakerBH);
		CfgBookmakerConfiguration bookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmakerConfiguration.setTimeZone("GMT+0");
		bookmakerConfiguration.setPriorityModa(1);
		bookmakerConfiguration.addBookmakerWebUrl(new CfgBookmakerWebUrl("http://www.bet-at-home.com"));
		bookmaker.setBookmakerConfiguration(bookmakerConfiguration);
		return bookmaker;
	}
}
