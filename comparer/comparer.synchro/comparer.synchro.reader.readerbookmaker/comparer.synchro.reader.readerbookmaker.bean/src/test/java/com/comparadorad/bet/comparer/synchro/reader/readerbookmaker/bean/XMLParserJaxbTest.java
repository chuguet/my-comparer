/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean;


/**
 * The Class XMLParserJaxbTest.
 */
public class XMLParserJaxbTest {

	/**
	 * Read bet click by url test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	// @Test
	// public void readBetClickByUrlTest() throws Exception {
	// JAXBContext jc = JAXBContext.newInstance(Sports.class);
	// Unmarshaller u = jc.createUnmarshaller();
	// Sports sports = (Sports) u.unmarshal(getConnection(
	// UrlBookmakers.getUrl("betClick")).getInputStream());
	// Assert.assertNotNull(sports);
	// }

	/**
	 * Read william hill by url test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	// @Test
	// public void readWilliamHillByUrlTest() throws Exception {
	// Oxip oxip = null;
	// JAXBContext jc = JAXBContext.newInstance(Oxip.class);
	// Unmarshaller u = jc.createUnmarshaller();
	// List<String> urls = getUrls("williamHill");
	// for (String url : urls) {
	// oxip = (Oxip) u.unmarshal(getConnection(url).getInputStream());
	// Assert.assertNotNull(oxip);
	// }
	// }

	/**
	 * Read you win by url test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	// @Test
	// public void readYouWinByUrlTest() throws Exception {
	// Odds odds = null;
	// JAXBContext jc = JAXBContext
	// .newInstance(com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.youwin.Odds.class);
	// Unmarshaller u = jc.createUnmarshaller();
	// List<String> urls = getUrls("youWin");
	// for (String url : urls) {
	// odds = (Odds) u.unmarshal(getConnection(url).getInputStream());
	// Assert.assertNotNull(odds);
	// }
	// }

	//
	// @Test
	// public void readNordicByUrlTest() throws Exception {
	// Odds odds = null;
	// JAXBContext jc = JAXBContext.newInstance(Odds.class);
	// Unmarshaller u = jc.createUnmarshaller();
	// List<String> urls = getUrls("nordicBet");
	// for (String url : urls) {
	// odds = (Odds) u.unmarshal(getConnection(UrlBookmakers.getUrl(url))
	// .getInputStream());
	// Assert.assertNotNull(odds);
	// }
	// }
	//
	// @Test
	// public void readTrioByUrlTest() throws Exception {
	// Odds odds = null;
	// JAXBContext jc = JAXBContext.newInstance(Odds.class);
	// Unmarshaller u = jc.createUnmarshaller();
	// List<String> urls = getUrls("trioBet");
	// for (String url : urls) {
	// odds = (Odds) u.unmarshal(getConnection(UrlBookmakers.getUrl(url))
	// .getInputStream());
	// Assert.assertNotNull(odds);
	// }
	// }

	/**
	 * Gets the connection.
	 * 
	 * @param bookMaker
	 *            the book maker
	 * @return the connection
	 * @throws Exception
	 *             the exception
	 */
//	private URLConnection getConnection(String bookMaker) throws Exception {
//		// PROXY
//		System.setProperty("http.proxyHost", Configuration.getString("host"));
//		System.setProperty("http.proxyPort", Configuration.getString("port"));
//
//		URL urlBetclick = new URL(bookMaker);
//		HttpURLConnection con = (HttpURLConnection) urlBetclick
//				.openConnection();
//		//
//		// it's not the greatest idea to use a sun.misc.* class
//		// Sun strongly advises not to use them since they can
//		// change or go away in a future release so beware.
//		//
//		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
//		String encodedUserPwd = encoder.encode(Configuration.getString(
//				"userpassProxy").getBytes());
//		con.setRequestProperty("Proxy-Authorization", "Basic " + encodedUserPwd);
//		return con;
//	}

	/**
	 * Gets the urls.
	 * 
	 * @param bookMaker
	 *            the book maker
	 * @return the urls
	 */
	// @SuppressWarnings({ "rawtypes", "unchecked" })
	// private List<String> getUrls(String bookMaker) {
	// List<String> urls = new ArrayList<String>();
	// Properties properties = new Properties();
	// try {
	// InputStream in = new FileInputStream(new File(getProjectDir()
	// + "/src/test/resources/urlbookmakers.properties"));
	// properties.load(in);
	//
	// } catch (FileNotFoundException e) {
	// fail(e.getMessage());
	// } catch (IOException e) {
	// fail(e.getMessage());
	// }
	// Set<Entry<Object, Object>> urlBokkmakers = properties.entrySet();
	// for (Iterator iterator = urlBokkmakers.iterator(); iterator.hasNext();) {
	// Entry<Object, Object> entry = (Entry<Object, Object>) iterator
	// .next();
	// if (((String) entry.getKey()).contains((bookMaker))) {
	// urls.add((String) entry.getValue());
	// }
	//
	// }
	// return urls;
	// }

	/**
	 * Gets the project dir.
	 * 
	 * @return the project dir
	 */
	public static String getProjectDir() {
		return System.getProperty("user.dir");
	}

}
