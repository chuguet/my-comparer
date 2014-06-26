package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.model.bet.bean.BeanUtilUnibet;
import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerDataUrl.UrlDataTypes;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.XmlDataFiles;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.builder.XmlFeedBuilder;
import com.comparadorad.bet.comparer.synchro.reader.datasource.connect.xml.director.XmlDirector;
import com.comparadorad.bet.comparer.synchro.reader.datasource.exception.XmlNotFoundException;
import com.comparadorad.bet.comparer.synchro.reader.url.core.StrategyType;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.bean.BeanUrlMaker;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.TimeOutReaderURLException;
import com.comparadorad.bet.comparer.synchro.reader.url.maker.exception.URLOutConfigurationException;
import com.comparadorad.bet.comparer.util.logger.core.ComparerWrapperLog;

@Component
class StrategyUnibetMakeUrl extends AbstractStrategyGenericMakeUrl {

	private Date dateStart;

	private final Map<String, Date> lastupdate;

	@Inject
	private ComparerWrapperLog LOG;

	@Inject
	private BeanUtilUnibet beanUtilUnibet;
	
	/** The feed builder. */
	@Inject
	private XmlFeedBuilder feedBuilder;


	public StrategyUnibetMakeUrl() {
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
	}

	List<String> betTypeList = Arrays.asList("1", "2", "4&includeparticipants=true", "6", "9", "11");

	@Override
	public List<BeanUrlMaker> getUrls(CfgBookmaker bookmaker) throws URLOutConfigurationException, TimeOutReaderURLException {
		List<BeanUrlMaker> result = new ArrayList<BeanUrlMaker>();
		List<BeanUrlMaker> urls;
		List<BeanUrlMaker> tmp;
		BeanUrlMaker baseUrl;

		urls = super.getUrls(bookmaker);

		tmp = getBeanUrlMakerByUrlDataTypes(urls, UrlDataTypes.BASE);
		if (tmp.size() == 1) {
			baseUrl = tmp.get(0);
		} else {
			throw new URLOutConfigurationException("Por favor verificar configuracion de Unibet. Es necesario añadir url base.");
		}

		
		try {
			InputStream urlBase = this.downloadUrl(baseUrl.getUrl());
			JsonNode nodo = new ObjectMapper().readTree(urlBase);
			beanUtilUnibet.setFicheroPadre(nodo);
			urlBase.close();
			JsonNode grupo = nodo.get("group");
			JsonNode grupos = grupo.get("groups");
			Iterator<JsonNode> iteradorElementos = grupos.getElements();
			while (iteradorElementos.hasNext()) {
				JsonNode deporte = iteradorElementos.next();
				if (contains(deporte.get("sport").asText(), bookmaker.getBookmakerConfiguration())) {
					Integer contadorApuesta = 0;
					while (contadorApuesta < betTypeList.size()) {
						String url = "http://api.unicdn.net/v1/feeds/sportsbook/betoffer/group/" + deporte.get("id").toString()
								+ ".json?local=en_GB&type=" + betTypeList.get(contadorApuesta)
								+ "&app_id=219230ff&app_key=f2da3925a86150e2668e3821a0e0d92a&rangeSize=1";
						try {
							InputStream urlDeporte = this.downloadUrl(url);
							Integer start = 0;
							JsonNode nodoDeporte = new ObjectMapper().readTree(urlDeporte);
							JsonNode rango = nodoDeporte.get("range");
							Integer total = Integer.valueOf(rango.get("total").toString());
							while (start <= total) {
								BeanUrlMaker urlIterada = new BeanUrlMaker();
								urlIterada.setUrl("http://api.unicdn.net/v1/feeds/sportsbook/betoffer/group/"
										+ deporte.get("id").toString() + ".json?local=en_GB&type=" + betTypeList.get(contadorApuesta)
										+ "&app_id=219230ff&app_key=f2da3925a86150e2668e3821a0e0d92a&rangeSize=100&rangeStart=" + start);
								LOG.debug(
										Thread.currentThread(),
										new StringBuffer().append("Se añade la url a la lista de urls a descargar:")
												.append(urlIterada.getUrl().toString()).toString());
								result.add(urlIterada);
								start += 100;
							}
						} catch (URLOutConfigurationException e) {
							LOG.warn(
									Thread.currentThread(),
									new StringBuffer("La url: ").append(url).append(" no admite el tipo de apuesta ")
											.append(betTypeList.get(contadorApuesta)).toString());
						}

						contadorApuesta++;
					}
				}
			}

		} catch (JsonProcessingException e) {
			throw new URLOutConfigurationException("Por favor verificar configuracion de Unibet. Es necesario añadir url base.");
		} catch (IOException e) {
			throw new URLOutConfigurationException("Por favor verificar configuracion de Unibet. Es necesario añadir url base.");
		} 
		return result;
	}
	
	protected InputStream downloadUrl(final String url) throws URLOutConfigurationException {
		InputStream inputStream = null;
		try {
			XmlDirector director = new XmlDirector();
			feedBuilder.setXmlDataFiles(new XmlDataFiles());
			feedBuilder.setUrl(url);
			director.setBuilder(feedBuilder);
			XmlDataFiles xmlDataFiles = new XmlDataFiles();
			xmlDataFiles = director.makeXML();
			inputStream = xmlDataFiles.getDataFiles().get(0)
					.getDataFileInputStream();
		} catch (IOException e) {
			LOG.error(Thread.currentThread(), new StringBuffer(
					"Se ha producido un error leyendo la url: ").append(url).toString(), e);
			throw new URLOutConfigurationException(e);
		}catch (XmlNotFoundException e) {
			LOG.error(Thread.currentThread(), new StringBuffer(
					"Se ha producido un error leyendo la url: ").append(url).toString(), e);
			throw new URLOutConfigurationException(e);
		}
		return inputStream;
	}

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.UNIBET_COM_ID;
	}

	@Override
	protected Date getDateStart() {
		return dateStart;
	}

	@Override
	protected Map<String, Date> getLastupdate() {
		return lastupdate;
	}

}
