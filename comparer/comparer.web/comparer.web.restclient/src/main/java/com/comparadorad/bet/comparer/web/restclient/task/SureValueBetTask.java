package com.comparadorad.bet.comparer.web.restclient.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.client.gwt.common.bean.ObjectToId;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.request.SureBetRequestTo;
import com.comparadorad.bet.comparer.web.client.gwt.securebet.bean.response.SureBetResponseTo;
import com.comparadorad.bet.comparer.web.restclient.exec.RequestSender;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

public class SureValueBetTask extends AbstractLevelTask {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(SureValueBetTask.class);

	private final Integer pageSize = 10;

	public SureValueBetTask(AnnotationConfigApplicationContext pContext,
			Boolean pWriteURLs) {
		super(pContext, pWriteURLs);
	}

	@Override
	public void run() {
		try {
			// UserInfoRequest userInfoRequest = new UserInfoRequest();
			// userInfoRequest.setLiferayUserId(String
			// .valueOf(LiferayRoles.LEVEL_1.getId()));
			// userInfoRequest.setDestinyGroup(UserTypes.NIVEL_1);
			// HttpEntity<Object> requestEntity = new HttpEntity<Object>(
			// userInfoRequest, requestHeaders);
			//
			// String body = RestTemplateUtil.executorServiceSender
			// .submit(new RequestSender(
			// restClient,
			// ".securebet/SecureBetModule/rest/rolesController/changeRoles",
			// requestEntity, writeURLs)).get();
			//
			// SureBetRequestTo sureBetRequest = new SureBetRequestTo();
			// // TODO: Tratamiento de paginas de resultados de apuestas
			// sureBetRequest.setPageNum(new Long(0));
			List<String> headerList = new ArrayList<String>();
			headerList.add("COOKIE_SUPPORT=true");
			headerList.add("uvf=1");
			headerList.add("COMPANY_ID=10154");
			headerList.add("ID=507733446671466a7539493d");
			headerList.add("GUEST_LANGUAGE_ID=es_ES");
			headerList.add("USER_TIMEZONE=Europe/Paris");
			headerList.add("USER_UUID=XGg0ozOUFhmA06TJdZFRcyEnpvOodf3w");
			headerList.add("JSESSIONID=11A92D080D02E8E4D4AE26306D1990E2");
			headerList.add("__uvt=");

			requestHeaders.put("Cookie", headerList);

			headerList = new ArrayList<String>();
			headerList
					.add("http://192.168.0.28:8080/web/betcompara/apuestas-seguras");

			requestHeaders.put("Referer", headerList);

			// ((CookieRestClient)restClient).setCookies(headerList);

			SureBetRequestTo sureBetRequest = new SureBetRequestTo();
			sureBetRequest.setPageNum((long) 0);
			sureBetRequest.setSureBetId(new ObjectToId());

			HttpEntity<Object> requestEntity = new HttpEntity<Object>(
					sureBetRequest, requestHeaders);

			String body = RestTemplateUtil.executorServiceSender
					.submit(new RequestSender(
							restClient,
							".securebet/SecureBetModule/rest/secureBetController/getAllSureBet",
							requestEntity, writeURLs)).get();

			SureBetResponseTo sureBetResponseTo = RestTemplateUtil
					.fromJsonToJava(body, SureBetResponseTo.class);

			LOG.debug("Sure Bets count: " + sureBetResponseTo.getCount());

			if (sureBetResponseTo != null) {

				for (int i = 1; i < sureBetResponseTo.getCount() / pageSize; i++) {
					sureBetRequest = new SureBetRequestTo();
					sureBetRequest.setPageNum((long) i);

					requestEntity = new HttpEntity<Object>(sureBetRequest,
							requestHeaders);

					RestTemplateUtil.executorServiceSender
							.submit(new RequestSender(
									restClient,
									".securebet/SecureBetModule/rest/secureBetController/getAllSureBet",
									requestEntity, writeURLs)).get();
				}

			}

		} catch (InterruptedException e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		} catch (ExecutionException e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + e.getMessage());
		}

	}

}
