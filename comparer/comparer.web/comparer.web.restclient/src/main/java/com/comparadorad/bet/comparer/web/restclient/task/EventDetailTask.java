package com.comparadorad.bet.comparer.web.restclient.task;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.cfg.request.EventRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseDataTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.tab.response.TabResponseTo;
import com.comparadorad.bet.comparer.web.restclient.core.IRestClient;
import com.comparadorad.bet.comparer.web.restclient.exec.RequestSender;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

/**
 * Task for process a event's detail.
 * 
 * @author rdomingo
 * 
 */

@SuppressWarnings("unused")
public class EventDetailTask extends AbstractLevelTask {

	private ObjectToId eventId;

	public EventDetailTask(AnnotationConfigApplicationContext pContext,
			IRestClient parentClient, ObjectToId eventIdentificator,
			Boolean pWriteURLs) {
		super(pContext, pWriteURLs);
		eventId = eventIdentificator;
		restClient = parentClient;
	}

	@Override
	public void run() {
		ObjectToId betTypeId;
		ObjectToId betTypeEventId;

		EventRequestTo eventRequestTo = new EventRequestTo();
		eventRequestTo.setEventId(eventId);

		// Head
		HttpEntity<Object> requestEntity = new HttpEntity<Object>(
				eventRequestTo, requestHeaders);
		String body;
		try {
			RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							restClient,
							".results/ResultsModule/rest/eventEventController/getHead",
							requestEntity, writeURLs)).get();

			body = RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							restClient,
							".results/ResultsModule/rest/eventEventController/getBetTypes",
							requestEntity, writeURLs)).get();

			TabResponseTo tabResponse = (TabResponseTo) RestTemplateUtil
					.fromJsonToJava(body, TabResponseTo.class);

			if (tabResponse != null) {
				List<TabResponseDataTo> listTabs = tabResponse.getTabs();
				if (listTabs != null) {
					for (TabResponseDataTo tab : listTabs) {
						betTypeId = tab.getId();
						eventRequestTo.setBetTypeId(betTypeId);
						requestEntity = new HttpEntity<Object>(eventRequestTo,
								requestHeaders);
						body = RestTemplateUtil.executorServiceSender
								.submit(new RequestSender(
										restClient,
										".results/ResultsModule/rest/eventEventController/getBetTypeEvent",
										requestEntity, writeURLs)).get();

						TabResponseTo oddsTabResponse = RestTemplateUtil
								.fromJsonToJava(body, TabResponseTo.class);

						List<TabResponseDataTo> oddsListTab = tabResponse
								.getTabs();
						if (oddsListTab != null) {
							for (TabResponseDataTo odds : listTabs) {
								betTypeEventId = odds.getId();
								eventRequestTo.setBetTypeId(betTypeId);
								eventRequestTo
										.setBetTypeEventId(betTypeEventId);
								requestEntity = new HttpEntity<Object>(
										eventRequestTo, requestHeaders);
								RestTemplateUtil.executorServiceSender
										.submit(new RequestSender(
												restClient,
												".results/ResultsModule/rest/eventEventController/getBetOdds",
												requestEntity, writeURLs))
										.get();

							}
						}
					}
				}
			}

		} catch (Exception e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}
	}

}
