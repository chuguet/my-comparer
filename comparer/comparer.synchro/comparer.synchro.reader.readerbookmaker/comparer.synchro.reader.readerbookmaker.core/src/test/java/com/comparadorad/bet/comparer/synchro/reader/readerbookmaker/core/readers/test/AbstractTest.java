/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.config.SynchroReaderReaderbookmakerConfig;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.data.XmlBetFileReaderResult;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.exception.XmlReaderException;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.core.readers.IXMLFileReader;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanAdditionalXmlInfoReader;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AbstracTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SynchroReaderReaderbookmakerConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

	/** The file reader. */
	@Inject
	protected List<IXMLFileReader> fileReader;

	/** The Constant BS_XML_LOCATION_1X2_ONLY. */
	protected static final String BS_XML_LOCATION_1X2_ONLY = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\boyleSports_1X2_only.xml";

	/** The Constant BS_XML_LOCATION_HANDICAP_1X2_ONLY. */
	protected static final String BS_XML_LOCATION_HANDICAP_1X2_ONLY = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\boyleSports_handicap_1X2_only.xml";

	/** The Constant BS_XML_LOCATION_GANADOR_PARTIDO_TENNIS. */
	protected static final String BS_XML_LOCATION_GANADOR_PARTIDO_TENNIS = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\BoyleSports_tennisGanadorPartido.xml";

	/** The Constant XML_LOCATION. */
	protected static final String BC_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betclick\\betclick.xml";

	/** The Constant WH_XML_LOCATION. */
	protected static final String WH_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\williamHillUKFootballMR.xml";

	/** The Constant TB_XML_LOCATION. */
	protected static final String TB_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\basketballTrioBet.xml";

	/** The Constant TB_XML_LOCATION. */
	protected static final String TB_XML_LOCATION_SHORT = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\basketballTrioBetShort.xml";

	/** The Constant WH_INC_XML_LOCATION. */
	protected static final String WH_INC_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\williamHillIncompleteXML.xml";

	/** The Constant EXPEKT_XML_LOCATION. */
	protected static final String EXPEKT_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\Expekt.xml";

	/** The Constant EXPEKT_XML_LOCATION. */
	protected static final String EXPEKT_XML_LOCATION_BIG = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\Expekt_big.xml";

	/** The Constant EXPEKT_XML_LOCATION. */
	protected static final String EXPEKT_XML_LOCATION_BAD = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\expekt_bad.xml";

	/** The Constant BS_XML_LOCATION. */
	protected static final String BS_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\BoyleSports_soccer.xml";

	/** The Constant BF_XML_LOCATION. */
	protected static final String BF_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_darts.xml";

	/** The Constant BF_XML_LOCATION. */
	protected static final String BF_XML_LOCATION_BASEBALL = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_baseball.xml";

	/** The Constant UNIBET_XML_LOCATION_BIG. */
	protected static final String UNIBET_XML_LOCATION_BIG = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\unibet_full.xml";

	/** The Constant UNIBET_XML_LOCATION. */
	protected static final String UNIBET_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\unibet.xml";

	/** The Constant BETFRED_BAD_XML_LOCATION. */
	protected static final String BETFRED_BAD_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_badXml.xml";

	/** The Constant BETFRED_BASEBALL_XML_LOCATION. */
	protected static final String BETFRED_BASEBALL_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_baseball.xml";

	/** The Constant BETFRED_SOCCER_XML_LOCATION. */
	protected static final String BETFRED_SOCCER_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betfred_soccer.xml";

	/** The Constant BOYLESPORTS_BAD_XML_LOCATION. */
	protected static final String BOYLESPORTS_BAD_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\BoyleSports_badXml.xml";

	/** The Constant BOYLESPORTS_BASKETBALL_XML_LOCATION. */
	protected static final String BOYLESPORTS_BASKETBALL_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\BoyleSports_basketball.xml";

	/** The Constant BOYLESPORTS_TENNIS_XML_LOCATION. */
	protected static final String BOYLESPORTS_TENNIS_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\BoyleSports_Tennis.xml";

	/** The Constant BOYLESPORTS_BASEBALL_XML_LOCATION. */
	protected static final String BOYLESPORTS_BASEBALL_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\BoyleSports_baseball.xml";

	/** The Constant WILLIAM_BASKETBALL_XML_LOCATION. */
	protected static final String WILLIAM_BASKETBALL_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\wiiliamhillBasketHL.xml";

	/** The Constant WILLIAM_DARTS_XML_LOCATION. */
	protected static final String WILLIAM_DARTS_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\williamDartsMW.xml";

	/** The Constant WILLIAM_FOOTBALL_XML_LOCATION. */
	protected static final String WILLIAM_FOOTBALL_XML_LOCATION = getProjectDir()
			+ "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\williamFootballAH.xml";

	/** The Constant BLUESQUARE_XML_FUTBOL. */
	protected static final String BLUESQUARE_XML_FUTBOL = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\blueSquare _futbol.xml";

	/** The Constant XML_LOCATION. */
	protected static final String BB_XML_LOCATION = getProjectDir() + "\\src\\test\\resources\\com\\comparadorad\\bet\\comparer"
			+ "\\synchro\\reader\\readerbookmaker\\core\\readers\\betboo.xml";

	/** The Constant BET_AT_HOME. */
	protected static final int BET_AT_HOME = 0;

	/** The Constant BETCLICK_READER. */
	protected static final int BETBOO_READER = 1;

	/** The Constant BETCLICK_READER. */
	protected static final int BETCLICK_READER = 2;

	/** The Constant BETFREDD_READER. */
	protected static final int BETFREDD_READER = 3;

	/** The Constant BETGUN_READER. */
	protected static final int BETGUN_READER = 4;

	/** The Constant BETONLINE_READER. */
	protected static final int BETONLINE_READER = 5;

	/** The Constant BETREDKINGS_READER. */
	protected static final int BETREDKINGS_READER = 6;

	/** The Constant BLUESQUARE_READER. */
	protected static final int BLUESQUARE_READER = 7;
	
	/** The Constant BETCRIS_READER. */
	protected static final int BETCRIS_READER = 8;

	/** The Constant BETDSI_READER. */
	protected static final int BETDSI_READER = 9;

	/** The Constant BOOKMAKER_READER. */
	protected static final int BOOKMAKER_READER = 10;

	/** The Constant BOYLE_SPORTS. */
	protected static final int BOYLESPORTS_READER = 11;

	/** The Constant BETCLICK_READER. */
	protected static final int BWIN_READER = 12;
	
	/** The Constant EXPEKT_READER. */
	protected static final int EXPEKT_READER = 13;

	/** The Constant INTEROPS_READER. */
	protected static final int INTERTOPS_READER = 14;

	/** The Constant NORDIC_READER. */
	protected static final int INTERWETTEN_READER = 15;

	/** The Constant LUCKIA_READER. */
	protected static final int LUCKIA_READER = 16;

	/** The Constant NORDIC_READER. */
	protected static final int NORDIC_READER = 17;

	/** The Constant PINNACLE_READER. */
	protected static final int PINNACLE_READER = 18;

	/** The Constant SPORTSBETTINGAG_READER. */
	protected static final int SPORTSBETTINGAG_READER = 19;

	/** The Constant SPORTSBETTING_READER. */
	protected static final int SPORTSBETTING_READER = 20;

	/** The Constant TRIO_READER. */
	protected static final int TRIO_READER = 21;

	/** The Constant UNIBET_READER. */
	protected static final int UNIBET_READER = 22;

	/** The Constant UWIN_READER. */
	protected static final int UWIN_READER = 23;

	/** The Constant WILLIAM_READER. */
	protected static final int WILLIAM_READER = 24;

	/** The Constant YOUWIN_READER. */
	protected static final int YOUWIN_READER = 25;

	/** The Constant BETATHOME_TIMEZONE. */
	protected static final String BETATHOME_TIMEZONE = "GMT+0";

	/** The Constant INTERTOPS_TIMEZONE. */
	protected static final String INTERTOPS_TIMEZONE = "GMT+0";

	/** The Constant WILLIAMHILL_TIMEZONE. */
	protected static final String WILLIAMHILL_TIMEZONE = "GMT+0";

	/** The Constant BETFRED_TIMEZONE. */
	protected static final String BETFRED_TIMEZONE = "GMT+0";

	/** The Constant BOYLESPORTS_TIMEZONE. */
	protected static final String BOYLESPORTS_TIMEZONE = "GMT+0";

	/** The Constant YOUWIN_TIMEZONE. */
	protected static final String YOUWIN_TIMEZONE = "GMT+0";

	/** The Constant EXPEKT_TIMEZONE. */
	protected static final String EXPEKT_TIMEZONE = "GMT+1";

	/** The Constant NORDICBET_TIMEZONE. */
	protected static final String NORDICBET_TIMEZONE = "GMT+1";

	/** The Constant TRIOBET_TIMEZONE. */
	protected static final String TRIOBET_TIMEZONE = "GMT+2";

	/** The Constant UNIBET_TIMEZONE. */
	protected static final String UNIBET_TIMEZONE = "GMT+0";

	/** The Constant BLUESQUARE_TIMEZONE. */
	protected static final String BLUESQUARE_TIMEZONE = "GMT+0";

	/** The Constant BETGUN_TIMEZONE. */
	protected static final String BETGUN_TIMEZONE = "GMT+2";

	/** The Constant BETREDKINGS_TIMEZONE. */
	protected static final String BETREDKINGS_TIMEZONE = "GMT+0";

	/** The Constant LUCKIA_TIMEZONE. */
	protected static final String LUCKIA_TIMEZONE = "GMT+0";

	/**
	 * Gets the project dir.
	 * 
	 * @return the project dir
	 */
	protected static String getProjectDir() {
		return System.getProperty("user.dir");
	}

	/**
	 * Gets the xML file.
	 * 
	 * @param numXml
	 *            the num xml
	 * @return the xML file
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	protected InputStream getXMLFile(int numXml) throws FileNotFoundException {
		if (numXml == BETCLICK_READER) {
			return new FileInputStream(new File(BC_XML_LOCATION));
		} else if (numXml == TRIO_READER) {
			return new FileInputStream(new File(TB_XML_LOCATION));
		} else if (numXml == WILLIAM_READER) {
			return new FileInputStream(new File(WH_XML_LOCATION));
		} else if (numXml == EXPEKT_READER) {
			return new FileInputStream(new File(EXPEKT_XML_LOCATION));
		} else if (numXml == BETFREDD_READER) {
			return new FileInputStream(new File(BF_XML_LOCATION));
		} else if (numXml == BOYLESPORTS_READER) {
			return new FileInputStream(new File(BS_XML_LOCATION));
		} else if (numXml == UNIBET_READER) {
			return new FileInputStream(new File(UNIBET_XML_LOCATION));
		} else if (numXml == BLUESQUARE_READER) {
			return new FileInputStream(new File(BLUESQUARE_XML_FUTBOL));
		} else if (numXml == BETBOO_READER) {
			return new FileInputStream(new File(BB_XML_LOCATION));
		}
		return new FileInputStream(new File(WH_XML_LOCATION));
	}

	/**
	 * Read xml.
	 * 
	 * @param pReader
	 *            the reader
	 * @param pXmlLocation
	 *            the xml location
	 * @param bookmakerConfiguration
	 *            the bookmaker configuration
	 * @param beanAdditionalXmlInfoReader
	 *            the bean additional xml info reader
	 * @return the xml bet file reader result
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws XmlReaderException
	 *             the xml reader exception
	 */
	protected XmlBetFileReaderResult readXML(int pReader, String pXmlLocation, CfgBookmakerConfiguration bookmakerConfiguration,
			BeanAdditionalXmlInfoReader beanAdditionalXmlInfoReader) throws FileNotFoundException, XmlReaderException {
		return fileReader.get(pReader).read(new FileInputStream(new File(pXmlLocation)), bookmakerConfiguration,
				beanAdditionalXmlInfoReader, "");

	}

}
