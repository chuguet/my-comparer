package com.comparadorad.bet.comparer.web.server.portlet.sitemap.scheduler;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;

/**
 * Portlet implementation class Sumador_Portlet
 */
public class SitemapController extends MVCPortlet {


	private static final String BASE = "http://www.betcompara.com";

	private static final long BLOG_ID = 10180;
	private static final long PRONOSTICOS_ID = 13344;
	private static final String BLOG_URL = "/blog/-/blogs/";
	private static final String PRONOSTICOS_URL = "/pronosticos/-/blogs/";
	private static final long GUIA_ID = 10180;
	private static final String GUIA_URL = "/guia-de-apuestas/-/wiki/Guia+de+apuestas/";
	private static final long CASAS_ID = 12587;
	private static final String CASAS_URL = "/casas-de-apuestas/-/wiki/Main/";


	public void processAction(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		WebSitemapGenerator webSitemapGenerator = null;
		List<WebSitemapUrl> urls = new ArrayList<WebSitemapUrl>();


		
		try {
			webSitemapGenerator = WebSitemapGenerator.builder("http://www.betcompara.com", new File("/etc/apache2/resourcesbetcompara/"))
					.gzip(false).build();

			urls.addAll(getStaticPages());
			urls.addAll(getBlogPages());
			urls.addAll(getWikiPages());
			//urls.addAll(getForumPages());

			webSitemapGenerator.addUrls(urls);

			webSitemapGenerator.write();
			actionRequest.setAttribute("error", "Se ha generado el SITEMAP.XML");
		} catch (Exception e) {
			actionRequest.setAttribute("error", e.getStackTrace().toString());
			
		}

	}

	private Collection<? extends WebSitemapUrl> getWikiPages() throws MalformedURLException, Exception {
		HashMap<String,WebSitemapUrl> urls = new HashMap<String,WebSitemapUrl>();

		List<WikiPage> pages = WikiPageLocalServiceUtil.getWikiPages(0, WikiPageLocalServiceUtil.getWikiPagesCount());


		for (WikiPage wikiPage : pages) {

			if(wikiPage.isHead()){
				if(wikiPage.getGroupId()==GUIA_ID ){
					urls.put(GUIA_URL+wikiPage.getTitle(),getURL(GUIA_URL+wikiPage.getTitle().replace(" ", "+"), 0.5, ChangeFreq.DAILY));
				}else if(wikiPage.getGroupId()==CASAS_ID){
					urls.put(CASAS_URL+wikiPage.getTitle(),getURL(CASAS_URL+wikiPage.getTitle().replace(" ", "+"), 0.5, ChangeFreq.DAILY));
				}
			}
		}
		return urls.values();
	}

	private Collection<? extends WebSitemapUrl> getBlogPages() throws SystemException, MalformedURLException, ParseException {
		List<WebSitemapUrl> urls = new ArrayList<WebSitemapUrl>();

		List<BlogsEntry> entries = BlogsEntryLocalServiceUtil.getBlogsEntries(0, BlogsEntryLocalServiceUtil.getBlogsEntriesCount());
		for (BlogsEntry blogsEntry : entries) {

			if(blogsEntry.getGroupId()==BLOG_ID){
				urls.add(getURL(BLOG_URL+blogsEntry.getUrlTitle(), 0.5, ChangeFreq.DAILY));
			}else if(blogsEntry.getGroupId()==PRONOSTICOS_ID){
				urls.add(getURL(PRONOSTICOS_URL+blogsEntry.getUrlTitle(), 0.5, ChangeFreq.DAILY));
			}

		}

		return urls;
	}

	private Collection<? extends WebSitemapUrl> getStaticPages() throws MalformedURLException, ParseException {
		List<WebSitemapUrl> urls = new ArrayList<WebSitemapUrl>();

		urls.add(getURL("", 1.0, ChangeFreq.DAILY));
		urls.add(getURL("/inicio", 1.0, ChangeFreq.DAILY));
		urls.add(getURL("/pronosticos", 0.5, ChangeFreq.DAILY));
		urls.add(getURL("/blog", 0.5, ChangeFreq.DAILY));
		urls.add(getURL("/foro", 0.5, ChangeFreq.DAILY));
		urls.add(getURL("/casas-de-apuestas", 0.5, ChangeFreq.DAILY));
		urls.add(getURL("/guia-de-apuestas", 0.5, ChangeFreq.DAILY));
		urls.add(getURL("/apuestas-seguras", 0.5, ChangeFreq.DAILY));
		urls.add(getURL("/value-bets", 0.5, ChangeFreq.DAILY));
		urls.add(getURL("/apuestas-seguras-info", 0.5, ChangeFreq.DAILY));
		urls.add(getURL("/value-bets-info", 0.5, ChangeFreq.DAILY));
		urls.add(getURL("/contacto", 0.5, ChangeFreq.DAILY));

		return urls;
	}

	private WebSitemapUrl getURL(String url,double priority,
			ChangeFreq hourly) throws MalformedURLException, ParseException {
		SimpleDateFormat util = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return new WebSitemapUrl.Options(BASE+url).lastMod(util.format(date)).priority(priority).changeFreq(hourly).build();
	}


}
