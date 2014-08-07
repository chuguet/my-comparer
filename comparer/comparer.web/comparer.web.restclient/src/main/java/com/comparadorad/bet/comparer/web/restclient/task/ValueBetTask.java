package com.comparadorad.bet.comparer.web.restclient.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.request.ValueBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.valuebet.bean.response.ValueBetResponseTo;
import com.comparadorad.bet.comparer.web.restclient.exec.RequestSender;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

public class ValueBetTask extends AbstractLevelTask {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(ValueBetTask.class);

	private final Integer pageSize = 10;

	public ValueBetTask(AnnotationConfigApplicationContext pContext,
			Boolean pWriteURLs) {
		super(pContext, pWriteURLs);
	}

	@Override
	public void run() {
		try {

			ValueBetRequestTo valueBetRequest = new ValueBetRequestTo();
			valueBetRequest.setPageNum((long) 0);

			HttpEntity<Object> requestEntity = new HttpEntity<Object>(
					valueBetRequest, requestHeaders);

			String body = RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							restClient,
							".valuebet/ValueBetModule/rest/valueBetController/getValueBet",
							requestEntity, writeURLs)).get();

			ValueBetResponseTo sureBetResponseTo = RestTemplateUtil
					.fromJsonToJava(body, ValueBetResponseTo.class);

			LOG.debug("Sure Bets count: " + sureBetResponseTo.getCount());

			if (sureBetResponseTo != null) {

				for (int i = 1; i < sureBetResponseTo.getCount() / pageSize; i++) {
					valueBetRequest = new ValueBetRequestTo();
					valueBetRequest.setPageNum((long) i);

					requestEntity = new HttpEntity<Object>(valueBetRequest,
							requestHeaders);

					RestTemplateUtil.executorServiceSender
							.submit(new RequestSender(
									restClient,
									".valuebet/ValueBetModule/rest/valueBetController/getValueBet",
									requestEntity, writeURLs)).get();
				}

			}

		} catch (Exception e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}

	}

}
