package com.comparadorad.bet.comparer.synchro.reader.url.maker.strategy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

import com.comparadorad.bet.comparer.model.config.bean.CfgBookmaker;
import com.comparadorad.bet.comparer.model.config.bean.bmconf.CfgBookmakerConfiguration;
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
class StrategyLuckiaMakeUrl extends AbstractStrategyGenericMakeUrl {

	private Date dateStart;

	private final Map<String, Date> lastupdate;

	private static volatile List<String> competiciones = new ArrayList<String>();

	@Inject
	private ComparerWrapperLog LOG;

	/** The feed builder. */
	@Inject
	private XmlFeedBuilder feedBuilder;

	public StrategyLuckiaMakeUrl() {
		dateStart = new Date();
		lastupdate = new HashMap<String, Date>();
	}

	
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
			throw new URLOutConfigurationException("Por favor verificar configuracion de Luckia. Es necesario añadir url base.");
		}

		try {
			InputStream urlBase = this.downloadUrl(baseUrl.getUrl());
			JsonNode nodo = new ObjectMapper().readTree(urlBase);
			urlBase.close();
			JsonNode grupo = nodo.get("group");
			JsonNode grupos = grupo.get("groups");
			competiciones.clear();
			obtenerligas(grupos, bookmaker.getBookmakerConfiguration());
			Iterator<String> iteradorElementos = competiciones.iterator();
			while (iteradorElementos.hasNext()) {
				String competicion = iteradorElementos.next();
				String url = "http://feed.luckia.es/betcompara/event/group/" + competicion + ".json";
				try {
					InputStream urlCompeticion = this.downloadUrl(url);
					JsonNode nodoDeporte = new ObjectMapper().readTree(urlCompeticion);
					JsonNode eventos = nodoDeporte.get("events");
					Iterator<JsonNode> iteradorEventos = eventos.getElements();
					while (iteradorEventos.hasNext()) {
						JsonNode evento = iteradorEventos.next();
						String partido = evento.get("id").asText();
						BeanUrlMaker urlIterada = new BeanUrlMaker();
						urlIterada.setUrl("http://feed.luckia.es/betcompara/betoffer/event/" + partido + ".json");
						LOG.debug(Thread.currentThread(), new StringBuffer().append("Se añade la url a la lista de urls a descargar:")
								.append(urlIterada.getUrl().toString()).toString());
						result.add(urlIterada);
					}
				} catch (URLOutConfigurationException e) {
					LOG.warn(Thread.currentThread(),
							new StringBuffer("La url: ").append(url).append(" no se está descargando correctamente.").toString());
				}
			}

		} catch (JsonProcessingException e) {
			throw new URLOutConfigurationException("Por favor verificar configuracion de Luckia. Es necesario añadir url base.");
		} catch (IOException e) {
			throw new URLOutConfigurationException("Por favor verificar configuracion de Luckia. Es necesario añadir url base.");
		}
		return result;
	}

	private synchronized void obtenerligas(JsonNode grupos, CfgBookmakerConfiguration cfgBookmakerConfiguration) {
		Iterator<JsonNode> iteradorBusqueda = grupos.getElements();
		while (iteradorBusqueda.hasNext()) {
			JsonNode elemento = iteradorBusqueda.next();
			if (contains(elemento.get("sport").asText(), cfgBookmakerConfiguration)) {
				if (elemento.get("groups") != null) {
					JsonNode subElemento = elemento.get("groups");
					obtenerligas(subElemento, cfgBookmakerConfiguration);
				} else {
					competiciones.add(elemento.get("id").asText());
				}
			}
		}
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
			inputStream = xmlDataFiles.getDataFiles().get(0).getDataFileInputStream();
		} catch (IOException e) {
			LOG.error(Thread.currentThread(), new StringBuffer("Se ha producido un error leyendo la url: ").append(url).toString(), e);
			throw new URLOutConfigurationException(e);
		} catch (XmlNotFoundException e) {
			LOG.error(Thread.currentThread(), new StringBuffer("Se ha producido un error leyendo la url: ").append(url).toString(), e);
			throw new URLOutConfigurationException(e);
		}
		return inputStream;
	}

	@Override
	public StrategyType getStrategyType() {
		return StrategyType.LUCKIA_ID;
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
