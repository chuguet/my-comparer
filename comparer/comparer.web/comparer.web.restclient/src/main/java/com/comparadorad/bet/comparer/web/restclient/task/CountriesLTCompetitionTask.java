package com.comparadorad.bet.comparer.web.restclient.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.CountryRequestTo;
import com.comparadorad.bet.comparer.web.restclient.exec.RequestSender;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

@SuppressWarnings("unused")
public class CountriesLTCompetitionTask extends AbstractLevelTask {
	/** The Constant LOG. */
	public static final Log LOG = LogFactory
			.getLog(CountriesCompetitionTask.class);

	private String idCountry;
	private String idSport;

	public CountriesLTCompetitionTask(
			AnnotationConfigApplicationContext pContext, String[] data,
			Boolean writeURLs) {
		super(pContext, writeURLs);
		idSport = data[0];
		idCountry = data[1];
	}

	@Override
	public void run() {
		CountryRequestTo countryRequestTo = new CountryRequestTo();

		countryRequestTo.setSportId(new ObjectToId(idSport));
		countryRequestTo.setCountryId(new ObjectToId(idCountry));

		HttpEntity<Object> requestEntity = new HttpEntity<Object>(
				countryRequestTo, requestHeaders);

		String body;
		try {
			RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							restClient,
							".results/ResultsModule/rest/countryLongTermController/getCountryLongTermCompetition",
							requestEntity, writeURLs)).get();
		} catch (Exception e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}

	}

}
