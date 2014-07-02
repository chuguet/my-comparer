/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.redirection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;

import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBetAtHometConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBetBooConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBetClickConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBetFredConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBetGunConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBetOnlineConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBetRedKingsConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBetcrisConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBetdsiConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBookmakerEuConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBoyleSportsConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlBwinConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlExpektConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlInterTopsConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlInterwettenConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlLuckiaConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlNordicBetConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlPinnacleSportsConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlSportsBettingAgConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlSportsBettingConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlTrioBetConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlUWinConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlUnibetConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlWilliamHillConversor;
import com.comparadorad.bet.comparer.web.server.redirection.conversor.impl.UrlYouWinConversor;

/**
 * The Class ConversorTest.
 */
public class ConversorTest extends AbstractTest {

	/** The url bet click conversor. */
	@Inject
	private UrlBetClickConversor urlBetClickConversor;

	/** The url boyle sports conversor. */
	@Inject
	private UrlBoyleSportsConversor urlBoyleSportsConversor;

	/** The url expekt conversor. */
	@Inject
	private UrlExpektConversor urlExpektConversor;

	/** The url nordic bet conversor. */
	@Inject
	private UrlNordicBetConversor urlNordicBetConversor;

	/** The url trio bet conversor. */
	@Inject
	private UrlTrioBetConversor urlTrioBetConversor;

	/** The url william hill conversor. */
	@Inject
	private UrlWilliamHillConversor urlWilliamHillConversor;

	/** The url you win conversor. */
	@Inject
	private UrlYouWinConversor urlYouWinConversor;

	/** The url bet fred conversor. */
	@Inject
	private UrlBetFredConversor urlBetFredConversor;

	/** The url interops conversor. */
	@Inject
	private UrlInterTopsConversor urlInterTopsConversor;

	/** The url unibet conversor. */
	@Inject
	private UrlUnibetConversor urlUnibetConversor;

	/** The url bet gun conversor. */
	@Inject
	private UrlBetGunConversor urlBetGunConversor;

	/** The url u win conversor. */
	@Inject
	private UrlUWinConversor urlUWinConversor;

	/** The url bet at homet conversor. */
	@Inject
	private UrlBetAtHometConversor urlBetAtHometConversor;

	/** The url bet online conversor. */
	@Inject
	private UrlBetOnlineConversor urlBetOnlineConversor;

	/** The url sports betting conversor. */
	@Inject
	private UrlSportsBettingConversor urlSportsBettingConversor;

	/** The url sports betting ag conversor. */
	@Inject
	private UrlSportsBettingAgConversor urlSportsBettingAgConversor;

	/** The url bookmaker eu conversor. */
	@Inject
	private UrlBookmakerEuConversor urlBookmakerEuConversor;

	/** The url betcris conversor. */
	@Inject
	private UrlBetcrisConversor urlBetcrisConversor;

	/** The url betdsi conversor. */
	@Inject
	private UrlBetdsiConversor urlBetdsiConversor;

	/** The url bet boo conversor. */
	@Inject
	private UrlBetBooConversor urlBetBooConversor;

	/** The url bet red kings conversor. */
	@Inject
	private UrlBetRedKingsConversor urlBetRedKingsConversor;

	/** The url pinnacle sports conversor. */
	@Inject
	private UrlPinnacleSportsConversor urlPinnacleSportsConversor;
	
	@Inject
	private UrlInterwettenConversor urlInterwettenConversor;
	
	@Inject
	private UrlLuckiaConversor urlLuckiaConversor;
	
	@Inject
	private UrlBwinConversor urlBwinConversor;

	/**
	 * Url bet click conversor test.
	 */
	@Test
	public void UrlBetClickConversorTest() {
		String idAfiliado = "a_13214b_935";
		String url = "http://affiliates.beaffiliates.com/processing/clickthrgh.asp";
		String result = urlBetClickConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://affiliates.beaffiliates.com/processing/clickthrgh.asp?btag=a_13214b_935";
		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);

	}

	/**
	 * Url boyle sports conversor test.
	 */
	@Test
	public void UrlBoyleSportsConversorTest() {
		String idAfiliado = "pid=32412&bid=1876";
		String url = "http://ads.boylesports.com/redirect.aspx";
		String result = urlBoyleSportsConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://ads.boylesports.com/redirect.aspx?pid=32412&bid=1876";
		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);

	}

	/**
	 * Url pinnacle sports conversor test.
	 */
	@Test
	public void UrlPinnacleSportsConversorTest() {
		String idAfiliado = "a_9505b_2";
		String url = "http://affiliates.pinnaclesports.com/processing/clickthrgh.asp";
		String result = urlPinnacleSportsConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://affiliates.pinnaclesports.com/processing/clickthrgh.asp?btag=a_9505b_2";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);

	}

	/**
	 * Url expekt conversor test.
	 */
	@Test
	public void UrlExpektConversorTest() {
		String idAfiliado = "a_13214b_6156";
		String url = "http://affiliates.beaffiliates.com/processing/clickthrgh.asp";
		String result = urlExpektConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://affiliates.beaffiliates.com/processing/clickthrgh.asp?btag=a_13214b_6156";
		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);

	}

	/**
	 * Url nordic bet conversor test.
	 */
	@Test
	public void UrlNordicBetConversorTest() {
		String idAfiliado = "_D0wPHM9Sk6PHlmrc8_zc-2Nd7ZgqdRLk/1";
		String url = "http://record.affiliatelounge.com/";
		String result = urlTrioBetConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://record.affiliatelounge.com/_D0wPHM9Sk6PHlmrc8_zc-2Nd7ZgqdRLk/1";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);

	}

	/**
	 * Url trio bet conversor test.
	 */
	@Test
	public void UrlTrioBetConversorTest() {
		String idAfiliado = "_D0wPHM9Sk6OJ2ZcYN2da7mNd7ZgqdRLk/1";
		String url = "http://record.affiliatelounge.com/";
		String result = urlTrioBetConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://record.affiliatelounge.com/_D0wPHM9Sk6OJ2ZcYN2da7mNd7ZgqdRLk/1";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);

	}

	/**
	 * Url william hill conversor test.
	 */
	@Test
	public void UrlWilliamHillConversorTest() {
		String idAfiliado = "betcompara&campaign=DEFAULT&channel=DEFAULT&zone=1478329349&lp=1478329346";
		String url = "http://serve.williamhill.com/promoRedirect";
		String result = urlWilliamHillConversor.makeUrl(url, idAfiliado);
		
		String expectedUrl = "http://serve.williamhill.com/promoRedirect?member=betcompara&campaign=DEFAULT&channel=DEFAULT&zone=1478329349&lp=1478329346";
//		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);

	}
	
	/**
	 * Url william hill zero conversor test.
	 */
	@Test
	public void UrlWilliamHillZeroConversorTest() {
		String idAfiliado = "140346874&bid=1481354988&lpid=1477554369";
		String url = "http://ads.williamhill.es/redirect.aspx";
		String result = urlWilliamHillConversor.makeUrl(url, idAfiliado);
		
		String expectedUrl = "http://ads.williamhill.es/redirect.aspx?pid=140346874&bid=1481354988&lpid=1477554369";
//		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);

	}

	/**
	 * Url you win conversor test.
	 */
	@Test
	public void UrlYouWinConversorTest() {
		String idAfiliado = "13233&bid=2411";
		String url = "http://media.youwin.com/redirect.aspx";
		String result = urlYouWinConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://media.youwin.com/redirect.aspx?pid=13233&bid=2411";
//		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);
	}
	
	/**
	 * Url uwin conversor test.
	 */
	@Test
	public void UrlUWinConversorTest() {
		String idAfiliado = "13233&bid=2549";
		String url = "http://media.uwin.com/redirect.aspx";
		String result = urlUWinConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://media.uwin.com/redirect.aspx?pid=13233&bid=2549";
//		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);
	}

	/**
	 * Url bet fred conversor test.
	 */
	@Test
	public void UrlBetFredConversorTest() {
		String idAfiliado = "a_17984b_2928";
		String url = "http://partners.betfredaffiliates.com/processing/clickthrgh.asp";
		String result = urlBetFredConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://partners.betfredaffiliates.com/processing/clickthrgh.asp?btag=a_17984b_2928";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);
	}

	/**
	 * Url interops conversor test.
	 */
	@Test
	public void UrlInterTopsConversorTest() {
		String idAfiliado = "a_7527b_1098";
		String url = "http://affiliate.intertops.com/processing/clickthrgh.asp";
		String result = urlInterTopsConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://affiliate.intertops.com/processing/clickthrgh.asp?btag=a_7527b_1098";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);

	}

	/**
	 * Url unibet conversor test.
	 */
	@Test
	public void UrlUnibetConversorTest() {
		String idAfiliado = "330588&bid=14809";
		String url = "http://adserving.unibet.com/redirect.aspx";
		String result = urlUnibetConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://adserving.unibet.com/redirect.aspx?pid=330588&bid=14809";
//		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);

	}

	/**
	 * Url betgun conversor test.
	 */
	@Test
	public void UrlBetgunConversorTest() {
		String idAfiliado = "42722";
		String url = "http://www.betgun.com/en/index.php";
		String result = urlBetGunConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://www.betgun.com/en/index.php?ref_id=42722";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);
	}

	/**
	 * Url betonline conversor test.
	 */
	@Test
	public void UrlBetonlineConversorTest() {
		String idAfiliado = "a_36451b_4";
		String url = "http://partners.commission.bz/processing/clickthrgh.asp";
		String result = urlBetOnlineConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://partners.commission.bz/processing/clickthrgh.asp?btag=a_36451b_4";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);
	}

	/**
	 * Url sports betting conversor test.
	 */
	@Test
	public void UrlSportsBettingConversorTest() {
		String idAfiliado = "";
		String url = "www.google.com";
		String result = urlSportsBettingConversor.makeUrl(url, idAfiliado);

		assertNotNull(result);
	}

	/**
	 * Url bet at home conversor test.
	 */
	@Test
	public void UrlBetAtHomeConversorTest() {
		String idAfiliado = "a_74774b_5";
		String url = "http://affiliates.bet-at-home.com/processing/clickthrgh.asp";
		String result = urlBetAtHometConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://affiliates.bet-at-home.com/processing/clickthrgh.asp?btag=a_74774b_5";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);

	}

	/**
	 * Url sports betting ag conversor test.
	 */
	@Test
	public void UrlSportsBettingAgConversorTest() {
		String idAfiliado = "a_36451b_1098";
		String url = "http://partners.commission.bz/processing/clickthrgh.asp";
		String result = urlSportsBettingAgConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://partners.commission.bz/processing/clickthrgh.asp?btag=a_36451b_1098";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
	}

	/**
	 * Url bookmaker eu conversor test.
	 */
	@Test
	public void UrlBookmakerEuConversorTest() {
		String idAfiliado = "";
		String url = "www.google.com";
		String result = urlBookmakerEuConversor.makeUrl(url, idAfiliado);

		assertNotNull(result);
	}

	/**
	 * Url betcris conversor test.
	 */
	@Test
	public void UrlBetcrisConversorTest() {
		String idAfiliado = "";
		String url = "www.google.com";
		String result = urlBetcrisConversor.makeUrl(url, idAfiliado);

		assertNotNull(result);
	}

	/**
	 * Url betdsi conversor test.
	 */
	@Test
	public void UrlBetdsiConversorTest() {
		String idAfiliado = "18911";
		String url = "http://www.betdsi.eu/";
		String result = urlBetdsiConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://www.betdsi.eu/?cmpid=18911";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);
	}

	/**
	 * Test para Betboo.
	 */
	@Test
	public void UrlBetbooConversorTest() {
		String idAfiliado = "_H7U40lBzn13Kto_EPcZApGNd7ZgqdRLk/1";
		String url = "http://record.betboopartners.com/";
		String result = urlBetBooConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://record.betboopartners.com/_H7U40lBzn13Kto_EPcZApGNd7ZgqdRLk/1";
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);

	}

	/**
	 * Test para Betredskins.
	 */
	@Test
	public void UrlBetredskinsConversorTest() {
		String idAfiliado = "betcompara";
		String url = "http://site.betredkings.com/index.cgi";
		String result = urlBetRedKingsConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://site.betredkings.com/index.cgi?aname=betcompara&cg=spanish";
//		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);

	}
	
	/**
	 * Test para Interwetten.
	 */
	@Test
	public void UrlInterwettenConversorTest() {
		String idAfiliado = "12128&bid=5819";
		String url = "http://affiliatesys.interwetten.com/redirect.aspx";
		String result = urlInterwettenConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://affiliatesys.interwetten.com/redirect.aspx?pid=12128&bid=5819";
//		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
		assertEquals(expectedUrl, result);

	}
	
	
	/**
	 * Test para Luckia.
	 */
	@Test
	public void UrlLuckiaConversorTest() {
		String idAfiliado = "2733&bid=1635";
		String url = "http://ads.redluckia.com/redirect.aspx";
		String result = urlLuckiaConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "http://ads.redluckia.com/redirect.aspx?pid=2733&bid=1635";
		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);
	}
	
	/**
	 * Test para Bwin
	 */
	@Test
	public void UrlBwinConversorTest() {
		String idAfiliado = "4197312&zoneId=1580296";
		String url = "https://sports.bwin.com/es/sports";
		String result = urlBwinConversor.makeUrl(url, idAfiliado);

		String expectedUrl = "https://sports.bwin.com/es/sports?wm=4197312&zoneId=1580296";
		expectedUrl = StringEscapeUtils.escapeHtml(expectedUrl);
		expectedUrl = encryptUrl(expectedUrl);

		assertNotNull(result);

	}

}
