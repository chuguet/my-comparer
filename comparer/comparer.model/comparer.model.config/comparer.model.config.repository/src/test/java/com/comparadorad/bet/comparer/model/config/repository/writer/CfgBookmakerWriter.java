/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.model.config.repository.writer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.UrlFilterWord;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl.UrlDataTypes;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerWebUrl;
import com.comparadorad.bet.comparer.model.core.bean.CoreActiveElement;
import com.comparadorad.bet.comparer.model.core.repository.AbstractWriterXML;

/**
 * The Class BookmakerConfigurationWriter.
 */
public class CfgBookmakerWriter extends AbstractWriterXML<List<CfgBookmaker>> {

	/**
	 * Adds the bookmaker.
	 * 
	 * @param objectId
	 *            the object id
	 * @param nameId
	 *            the name id
	 * @param name
	 *            the name
	 * @param url
	 *            the url
	 * @param webUrl
	 *            the web url
	 * @param active
	 *            the active
	 * @param date
	 *            the date
	 * @param bookmakers
	 *            the bookmakers
	 * @param master
	 *            the master
	 * @param priority
	 *            the priority
	 * @param idAfiliado
	 *            the id afiliado
	 * @param bookmakerTimeZone
	 *            the bookmaker time zone
	 * @param blackList
	 *            the black list
	 */
	public void addBookmaker(BigInteger objectId, String nameId, String name, String url, String webUrl, boolean active, String date,
			List<CfgBookmaker> bookmakers, boolean master, int priority, String idAfiliado, String bookmakerTimeZone,
			Long minimumTimeUpdate, Set<String> blackList, Set<UrlFilterWord> urlFilterWords, Integer priorityModa) {

		List<String> urls = new ArrayList<String>();
		List<String> webUrls = new ArrayList<String>();
		urls.add(url);
		webUrls.add(webUrl);

		addBookmaker(objectId, nameId, name, urls, webUrls, active, date, bookmakers, master, priority, idAfiliado, bookmakerTimeZone,
				minimumTimeUpdate, blackList, urlFilterWords, priorityModa);
	}

	/**
	 * Adds the bookmaker.
	 * 
	 * @param objectId
	 *            the object id
	 * @param nameId
	 *            the name id
	 * @param name
	 *            the name
	 * @param urls
	 *            the urls
	 * @param webUrls
	 *            the web urls
	 * @param active
	 *            the active
	 * @param date
	 *            the date
	 * @param bookmakers
	 *            the bookmakers
	 * @param master
	 *            the master
	 * @param priority
	 *            the priority
	 * @param idAfiliado
	 *            the id afiliado
	 * @param bookmakerTimeZone
	 *            the bookmaker time zone
	 * @param blackList
	 *            the black list
	 */
	public void addBookmaker(BigInteger objectId, String nameId, String name, List<String> urls, List<String> webUrls, boolean active,
			String date, List<CfgBookmaker> bookmakers, boolean master, int priority, String idAfiliado, String bookmakerTimeZone,
			Long minimumTimeUpdate, Set<String> blackList, Set<UrlFilterWord> urlFilterWords, Integer priorityModa) {
		CfgBookmaker bookmaker = new CfgBookmaker();
		bookmaker.setObjectId(objectId);
		bookmaker.setHistoricCreationData(getWriterAppUser(), getWriterAppDate(date));
		CfgBookmakerConfiguration cfgBookmakerConfiguration = new CfgBookmakerConfiguration();
		bookmaker.setName(name);
		bookmaker.setNameId(name);
		bookmaker.setCoreActiveElement(new CoreActiveElement(active));

		cfgBookmakerConfiguration.setCouldCreateMasterWord(master, priority);
		cfgBookmakerConfiguration.setIdAfiliado(idAfiliado);
		cfgBookmakerConfiguration.setTimeZone(bookmakerTimeZone);
		cfgBookmakerConfiguration.setBlackList(blackList);
		cfgBookmakerConfiguration.setMinimumTimeUpdate(minimumTimeUpdate);
		cfgBookmakerConfiguration.setFilterMakeUrl(urlFilterWords);
		cfgBookmakerConfiguration.setPriorityModa(priorityModa);

		// Configuracion del bookmaker

		Iterator<String> itURLs = urls.iterator();
		String url = null;
		while (itURLs.hasNext()) {
			url = itURLs.next();
			CfgBookmakerDataUrl cfgBookmakerDataUrl = new CfgBookmakerDataUrl();
			cfgBookmakerDataUrl.setUrl(url);
			cfgBookmakerDataUrl.setUrlDataType(UrlDataTypes.DATA);
			cfgBookmakerConfiguration.addBookmakerDataUrl(cfgBookmakerDataUrl);
		}

		Iterator<String> itWebURLs = webUrls.iterator();
		String webUrl = null;
		while (itWebURLs.hasNext()) {
			webUrl = itWebURLs.next();
			CfgBookmakerWebUrl cfgBookmakerWebUrl = new CfgBookmakerWebUrl();
			cfgBookmakerWebUrl.setUrl(webUrl);
			cfgBookmakerConfiguration.addBookmakerWebUrl(cfgBookmakerWebUrl);
		}

		bookmaker.setBookmakerConfiguration(cfgBookmakerConfiguration);
		// A�adir a la lista de bookmaker
		bookmakers.add(bookmaker);
	}

	/**
	 * Checks if is extended.
	 * 
	 * @return true, if is extended {@inheritDoc}
	 */
	@Override
	protected boolean isExtended() {
		return false;
	}

	/**
	 * Make object.
	 * 
	 * @return the list {@inheritDoc}
	 */
	@Override
	public List<CfgBookmaker> makeObject() {
		List<CfgBookmaker> bookmakers = new ArrayList<CfgBookmaker>();

		Set<String> blackList = null;
		Set<UrlFilterWord> sportWhiteList = new HashSet<UrlFilterWord>();

		// Betboo
		addBookmaker(CfgBookmaker.CfgBookmakerId.BETBOO_ID.objectId(), CfgBookmaker.CfgBookmakerId.BETBOO_ID.nameId(), "BetBoo",
				"http://www.betboo.com/xml/openMatches.xml", "http://record.betboopartners.com/", false, "01/10/2011", bookmakers, true,
				10, "_H7U40lBzn13Kto_EPcZApGNd7ZgqdRLk/1", "America/Denver", 0L, blackList, sportWhiteList, 4);

		// Betclick
		addBookmaker(CfgBookmaker.CfgBookmakerId.BETCLIC_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.BETCLIC_COM_ID.nameId(),
				"BetClick.com", "http://xml.betclick.com/odds_en.xml", "http://affiliates.beaffiliates.com/processing/clickthrgh.asp",
				true, "01/10/2011", bookmakers, true, 10, "a_13214b_935", "UTC", 0L, blackList, sportWhiteList, 9);

		// Betredkings
		addBookmaker(CfgBookmaker.CfgBookmakerId.BETREDKINGS_ID.objectId(), CfgBookmaker.CfgBookmakerId.BETREDKINGS_ID.nameId(),
				"BetRedKings", "http://aws2.betredkings.com/feed/fileList.xml ", "http://site.betredkings.com/index.cgi", true,
				"01/10/2011", bookmakers, true, 10, "betcompara", "Atlantic/Cape_Verde", 0L, blackList, sportWhiteList, 12);

		// NordicBet
		addBookmaker(CfgBookmaker.CfgBookmakerId.NORDICBET_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.NORDICBET_COM_ID.nameId(),
				"NordicBet", "http://xml.nordicbet.com/eng/full.xml", "http://record.affiliatelounge.com/", true, "01/10/2011", bookmakers,
				true, 20, "_D0wPHM9Sk6PHlmrc8_zc-2Nd7ZgqdRLk/1", "Africa/Algiers", 0L, blackList, sportWhiteList, 5);

		// BetFred
		List<String> webUrls = Arrays.asList("http://partners.betfredaffiliates.com/processing/clickthrgh.asp");
		List<String> urls = Arrays.asList("http://xml.betfred.com/@Templates@.xml");
		addBookmaker(CfgBookmaker.CfgBookmakerId.BETFRED_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.BETFRED_COM_ID.nameId(), "BetFred",
				urls, webUrls, true, "01/10/2011", bookmakers, true, 0, "a_17984b_2928", "UTC", 0L, blackList, sportWhiteList, 8);

		// BlueSquare
		addBookmaker(CfgBookmaker.CfgBookmakerId.BLUESQUARE_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.BLUESQUARE_COM_ID.nameId(),
				"BlueSquare", "http://cubs.bluesq.com/cubs/cubs.php?action=dictionary", "http://www.bluesq.com", true, "01/10/2011",
				bookmakers, true, 0, "", "UTC", 0L, blackList, sportWhiteList, 1);

		// PinnacleSports
		addBookmaker(CfgBookmaker.CfgBookmakerId.PINNACLESPORTS_COM_ID.objectId(),
				CfgBookmaker.CfgBookmakerId.PINNACLESPORTS_COM_ID.nameId(), "PinnacleSports",
				"http://xml.pinnaclesports.com/pinnacleFeed.aspx", "http://affiliates.pinnaclesports.com/processing/clickthrgh.asp", false,
				"01/10/2011", bookmakers, true, 40, "a_9505b_2", "Atlantic/Cape_Verde", 0L, blackList, sportWhiteList, 2);

		// TrioBet
		addBookmaker(CfgBookmaker.CfgBookmakerId.TRIOBET_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.TRIOBET_COM_ID.nameId(), "TrioBet",
				"http://xml.triobet.com/eng/full.xml", "http://record.affiliatelounge.com/", true, "01/10/2011", bookmakers, true, 60,
				"_D0wPHM9Sk6OJ2ZcYN2da7mNd7ZgqdRLk/1", "Africa/Algiers", 0L, blackList, sportWhiteList, 5);

		// YouWin
		addBookmaker(CfgBookmaker.CfgBookmakerId.YOUWIN_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.YOUWIN_COM_ID.nameId(), "YouWin",
				"http://feed.youwincdn.com/web/xml/en/youwin_all_sports.xml", "http://media.youwin.com/redirect.aspx", true, "01/10/2011",
				bookmakers, true, 70, "13233&bid=2411", "Africa/Algiers", 0L, blackList, sportWhiteList, 12);

		// Interwetten
		sportWhiteList.add(new UrlFilterWord("American Football"));
		sportWhiteList.add(new UrlFilterWord("Baseball"));
		sportWhiteList.add(new UrlFilterWord("Basketball"));
		sportWhiteList.add(new UrlFilterWord("Cycling"));
		sportWhiteList.add(new UrlFilterWord("Football"));
		sportWhiteList.add(new UrlFilterWord("Ice Hockey"));
		sportWhiteList.add(new UrlFilterWord("Tennis"));
		sportWhiteList.add(new UrlFilterWord("Handball"));

		addBookmaker(CfgBookmaker.CfgBookmakerId.INTERWETTEN_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.INTERWETTEN_COM_ID.nameId(),
				"Interwetten", "http://ad.interwetten.com/XMLFeeder/feeder.asmx/getfeed?FEEDPARAMS=ValidKindofsports|LANGUAGE=EN",
				"https://www.interwetten.com", true, "01/10/2011", bookmakers, true, 0, "", "Africa/Algiers", 45000L, blackList,
				sportWhiteList, 12);

		sportWhiteList = new HashSet<UrlFilterWord>();

		// Expekt
		addBookmaker(CfgBookmaker.CfgBookmakerId.EXPEKT_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.EXPEKT_COM_ID.nameId(), "Expekt",
				"http://xml.cdn.expekt.com/odds_en.xml", "http://affiliates.beaffiliates.com/processing/clickthrgh.asp", true,
				"01/10/2011", bookmakers, true, 0, "a_13214b_6156", "Europe/Isle_of_Man", 0L, blackList, sportWhiteList, 9);
		// Intertops
		addBookmaker(CfgBookmaker.CfgBookmakerId.INTERTOPS_EU_ID.objectId(), CfgBookmaker.CfgBookmakerId.INTERTOPS_EU_ID.nameId(),
				"Intertops", "http://xmlfeed.intertops.com/XMLOddsFeed/IntertopsOdds.aspx",
				"http://affiliate.intertops.com/processing/clickthrgh.asp", false, "01/10/2011", bookmakers, true, 90, "a_7527b_1098",
				"EST", 0L, blackList, sportWhiteList, 2);
		// BetRedKings
		addBookmaker(CfgBookmaker.CfgBookmakerId.BETREDKINGS_ID.objectId(), CfgBookmaker.CfgBookmakerId.BETREDKINGS_ID.nameId(),
				"BetRedKings", "http://aws2.betredkings.com/feed/fileList.xml", "http://http://www.betredkings.com/", false, "01/10/2011",
				bookmakers, false, 90, "", "UTC", 0L, blackList, sportWhiteList, 12);

		// William Hill
		// S�lo se han a�adido las URLs que no son en directo, no implicaban
		// tipos de apuesta y s�lo hasta la F1. Las URLs est�n en
		// http://pricefeeds.williamhill.com/bet/en-gb?action=GoPriceFeed
		urls = Arrays
				.asList("http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=424&marketSort=--&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=424&marketSort=CS&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=424&marketSort=HH&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=424&marketSort=OE&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=424&marketSort=WH&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=--&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=HH&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=HL&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=MR&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=OE&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=WH&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=WM&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=283&marketSort=--&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=--&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=C3&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=CS&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=DN&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=HL&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=MH&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=MR&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=OE&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=401&marketSort=--&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=--&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=CS&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=DN&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=HF&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=HL&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=HT&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=MH&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=MR&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=OE&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=--&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=OE&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=WH&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=C3&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=HH&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=HL&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=MR&filterBIR=Y",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=19&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=18&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=310&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=437&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=301&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=335&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=335&marketSort=CS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=335&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=335&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=335&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=OE&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=273&marketSort=WH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=283&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=283&marketSort=DC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=283&marketSort=DN&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=283&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=283&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=283&marketSort=WH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=AG&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=AW&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=CS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=DC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=DN&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=FS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=FW&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=G3&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=GT&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=HF&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=HS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=LC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=LS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=LW&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=MG&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=OE&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=SC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=46&marketSort=SF&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=436&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=436&marketSort=AH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=436&marketSort=CS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=436&marketSort=DC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=436&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=436&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=5&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=348&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=348&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=348&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=349&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=8&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=385&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=45&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=303&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=303&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=303&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=303&marketSort=WH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=337&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=42&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=42&marketSort=CS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=42&marketSort=DC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=42&marketSort=DN&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=42&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=42&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=42&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=36&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=36&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=401&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=401&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=401&marketSort=WH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=40&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=40&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=420&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=412&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=32&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=32&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=AG&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=AW&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=CS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=DC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=DN&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=FS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=FW&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=G3&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=GT&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=HF&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=HS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=LC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=LS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=LW&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=MG&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=OE&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=SC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=274&marketSort=SF&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=325&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=7&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=334&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=413&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=419&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=275&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=402&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=9&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=AG&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=AW&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=B3&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=C3&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=CS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=DC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=DN&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=FS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=FW&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=G3&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=GT&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=HF&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=HS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=LC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=LS&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=LW&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=MG&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=OE&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=SC&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=1&marketSort=SF&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=336&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=336&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=336&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=336&marketSort=MR&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=336&marketSort=OE&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=336&marketSort=WH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=--&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=HH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=HL&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=320&marketSort=WH&filterBIR=N",
						"http://whdn.williamhill.com/pricefeed/openbet_cdn?action=template&template=getHierarchyByMarketType&classId=277&marketSort=--&filterBIR=N");
		webUrls = Arrays.asList("http://www.williamhill.com");
		addBookmaker(CfgBookmaker.CfgBookmakerId.WILLIAMHILL_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.WILLIAMHILL_COM_ID.nameId(),
				"WilliamHill", urls, webUrls, true, "01/10/2011", bookmakers, true, 0, "", "UTC", 0L, blackList, sportWhiteList, 8);

		// Betonline.ag
		// Betonline tiene una url por deporte. Abajo estan los 10 deportes que
		// tratamos por ahora. Dos de ellos (balonmano y ciclismo) no existen en
		// betonline (por ahora).
		// "http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=Handball"
		// "http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=Cycle"
		urls = Arrays.asList("http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=AutoRacing",
				"http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=Baseball",
				"http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=Basketball",
				"http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=Football",
				"http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=Hockey",
				"http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=Rugby",
				"http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=Soccer",
				"http://livelines.betonline.ag/sys/LineXML/LiveLineObjXml.asp?sport=Tennis");
		webUrls = Arrays.asList("http://www.betonline.ag");
		addBookmaker(CfgBookmaker.CfgBookmakerId.BETONLINE_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.BETONLINE_COM_ID.nameId(),
				"Betonline", urls, webUrls, true, "01/10/2011", bookmakers, true, 0, "", "EST", 0L, blackList, sportWhiteList, 4);

		// BoyleSports
		// Se desconocen las URLs de todos los deportes. Se han a�adido
		// algunas
		// que devuelven datos
		urls = Arrays.asList("http://xml.boylesports.com/xml/nfl.xml", "http://xml.boylesports.com/xml/baseball.xml",
				"http://xml.boylesports.com/xml/basketball.xml", "http://xml.boylesports.com/xml/boxing.xml",
				"http://xml.boylesports.com/xml/cricket.xml", "http://xml.boylesports.com/xml/Cycling.xml",
				"http://xml.boylesports.com/xml/Darts.xml", "http://xml.boylesports.com/xml/Golf.xml",
				"http://xml.boylesports.com/xml/handball.xml", "http://xml.boylesports.com/xml/motorsport.xml",
				"http://xml.boylesports.com/xml/novelty.xml", "http://xml.boylesports.com/xml/rugby.xml",
				"http://xml.boylesports.com/xml/soccer.xml", "http://xml.boylesports.com/xml/snooker.xml",
				"http://xml.boylesports.com/xml/speedway.xml", "http://xml.boylesports.com/xml/tennis.xml");
		webUrls = Arrays.asList("http://ads.boylesports.com/redirect.aspx");
		addBookmaker(CfgBookmaker.CfgBookmakerId.BOYLESPORTS_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.BOYLESPORTS_COM_ID.nameId(),
				"BoyleSports", urls, webUrls, true, "01/10/2011", bookmakers, true, 0, "32412&bid=1876", "UTC", 0L, blackList,
				sportWhiteList, 8);

		// Betgun
		urls = Arrays.asList("http://odds.betgun.com/");
		webUrls = Arrays.asList("http://www.betgun.com/en/index.php");
		addBookmaker(CfgBookmaker.CfgBookmakerId.BETGUN_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.BETGUN_COM_ID.nameId(), "Betgun",
				urls, webUrls, true, "01/10/2011", bookmakers, true, 0, "42722", "Africa/Algiers", 0L, blackList, sportWhiteList, 6);

		// Uwin
		addBookmaker(CfgBookmaker.CfgBookmakerId.UWIN.objectId(), CfgBookmaker.CfgBookmakerId.UWIN.nameId(), "Uwin",
				"http://feed.youwincdn.com/web/xml/en/youwin_all_sports.xml", "http://media.uwin.com/redirect.aspx", true, "01/10/2011",
				bookmakers, true, 70, "13233&bid=2549", "Africa/Algiers", 0L, blackList, sportWhiteList, 12);

		// BetAtHome
		addBookmaker(CfgBookmaker.CfgBookmakerId.BET_AT_HOME_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.BET_AT_HOME_COM_ID.nameId(),
				"BetAtHome", "http://www.bet-at-home.com/oddxml.aspx?lang=en&subscriber=a_74774b_5",
				"http://affiliates.bet-at-home.com/processing/clickthrgh.asp", true, "01/10/2011", bookmakers, true, 70, "a_74774b_5",
				"Africa/Algiers", 0L, blackList, sportWhiteList, 10);

		// Sportsbetting.com
		// Sportsbetting tiene una url por deporte. Abajo estan los 10 deportes
		// que
		// tratamos por ahora. Dos de ellos (balonmano y ciclismo) no existen en
		// betonline (por ahora).
		// "http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Handball"
		// "http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Cycle"
		urls = Arrays.asList("http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=AutoRacing",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Baseball",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Basketball",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Football",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Hockey",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Rugby",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Soccer",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Tennis");
		webUrls = Arrays.asList("http://www.Sportsbetting.com");
		addBookmaker(CfgBookmaker.CfgBookmakerId.SPORTSBETTING_COM_ID.objectId(),
				CfgBookmaker.CfgBookmakerId.SPORTSBETTING_COM_ID.nameId(), "Sportsbetting.com", urls, webUrls, true, "01/10/2011",
				bookmakers, true, 0, "", "EST", 0L, blackList, sportWhiteList, 4);

		// Sportsbetting.ag
		// Sportsbetting.ag tiene una url por deporte. Abajo estan los 10
		// deportes que
		// tratamos por ahora. Dos de ellos (balonmano y ciclismo) no existen en
		// betonline (por ahora).
		// "http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Handball"
		// "http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Cycle"
		urls = Arrays.asList("http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=AutoRacing",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Baseball",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Basketball",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Football",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Hockey",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Rugby",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Soccer",
				"http://livelines.betonline.com/sys/LineXML/LiveLineObjXml.asp?sport=Tennis");
		webUrls = Arrays.asList("http://partners.commission.bz/processing/clickthrgh.asp");
		addBookmaker(CfgBookmaker.CfgBookmakerId.SPORTSBETTING_AG_ID.objectId(), CfgBookmaker.CfgBookmakerId.SPORTSBETTING_AG_ID.nameId(),
				"Sportsbetting.ag", urls, webUrls, true, "01/10/2011", bookmakers, true, 0, "a_36451b_1098", "EST", 0L, blackList,
				sportWhiteList, 4);

		// Bookmaker.eu
		urls = Arrays.asList("http://lines.bookmaker.eu/", "http://plasma.betcris.com/XlinesSvc/XmlLines.asmx/newGetLeagues");
		webUrls = Arrays.asList("http://www.bookmaker.eu/");
		addBookmaker(CfgBookmaker.CfgBookmakerId.BOOKMAKER_EU_ID.objectId(), CfgBookmaker.CfgBookmakerId.BOOKMAKER_EU_ID.nameId(),
				"Bookmaker.eu", urls, webUrls, true, "01/10/2011", bookmakers, true, 70, "", "PST", 0L, blackList, sportWhiteList, 6);

		// Betcris
		addBookmaker(CfgBookmaker.CfgBookmakerId.BETCRIS_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.BETCRIS_COM_ID.nameId(), "Betcris",
				"http://lines.betcris.com/", "http://www.betcris.com/", true, "01/10/2011", bookmakers, true, 70, "", "PST", 0L, blackList,
				sportWhiteList, 6);

		// Betdsi
		addBookmaker(CfgBookmaker.CfgBookmakerId.BETDSI_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.BETDSI_COM_ID.nameId(), "Betdsi",
				"http://lines.betdsi.com/", "http://www.betdsi.eu/", true, "01/10/2011", bookmakers, true, 70, "18911", "PST", 0L,
				blackList, sportWhiteList, 6);

		// Unibet
		addBookmaker(CfgBookmaker.CfgBookmakerId.UNIBET_COM_ID.objectId(), CfgBookmaker.CfgBookmakerId.UNIBET_COM_ID.nameId(), "Unibet",
				"http://lines.betdsi.com/", "http://www.betdsi.eu/", true, "01/10/2011", bookmakers, true, 70, "18911", "PST", 0L,
				blackList, sportWhiteList, 6);

		// Luckia
		addBookmaker(CfgBookmaker.CfgBookmakerId.LUCKIA.objectId(), CfgBookmaker.CfgBookmakerId.LUCKIA.nameId(), "Luckia",
				"http://feed.luckia.es/betcompara/sports.php", "http://www.luckia.es/", true, "01/10/2011", bookmakers, true, 70, "18911", "PST", 0L,
				blackList, sportWhiteList, 6);

		return bookmakers;
	}
}
