package com.comparadorad.bet.comparer.web.restclient.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.SportRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.restclient.exec.RequestSender;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

public class SportsCountriesTask extends AbstractLevelTask {
	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(SportsCountriesTask.class);

	String idSport;

	public SportsCountriesTask(AnnotationConfigApplicationContext appContext,
			String sport, Boolean writeURLs) {
		super(appContext, writeURLs);
		idSport = sport;
	}

	@Override
	public void run() {
		SportRequestTo sportRequestTo = new SportRequestTo();
		sportRequestTo.setSportId(new ObjectToId(idSport));

		HttpEntity<Object> requestEntity = new HttpEntity<Object>(
				sportRequestTo, requestHeaders);

		String body;
		try {
			RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							restClient,
							".results/ResultsModule/rest/sportCountriesController/getHead",
							requestEntity, writeURLs)).get();

			body = RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							restClient,
							".results/ResultsModule/rest/sportCountriesController/getSportCountriesCountries",
							requestEntity, writeURLs)).get();

			TableResponseTo tableResponseTo = RestTemplateUtil.fromJsonToJava(
					body, TableResponseTo.class);

			if (tableResponseTo != null
					&& restClient.getConfig().getRequestLevel() >= IRestLevel.LEVEL_2) {
				List<TableResponseRowTo> countriesList = tableResponseTo
						.getRows();
				for (TableResponseRowTo country : countriesList) {
					LOG.debug("[SPORT] " + idSport + " [COUNTRY] "
							+ country.getObjectToId().getId());
					RestTemplateUtil.executorService
							.execute(new CountriesCompetitionTask(appContext,
									new String[] { idSport,
											country.getObjectToId().getId() },
									writeURLs));

					RestTemplateUtil.executorService
							.execute(new CountriesLTCompetitionTask(appContext,
									new String[] { idSport,
											country.getObjectToId().getId() },
									writeURLs));

				}
			}

		} catch (Exception e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}
	}
}
