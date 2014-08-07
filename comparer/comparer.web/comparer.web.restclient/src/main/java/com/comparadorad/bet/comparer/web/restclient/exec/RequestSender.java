package com.comparadorad.bet.comparer.web.restclient.exec;

import java.util.concurrent.Callable;

import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.restclient.core.IRestClient;
import com.comparadorad.bet.comparer.web.restclient.core.RestClient;
import com.comparadorad.bet.comparer.web.restclient.exception.RestClientException;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

public class RequestSender implements Callable<String> {

	private IRestClient restClient;
	private String url;
	private HttpEntity<Object> request;
	private Boolean writeURL;

	public RequestSender(IRestClient client, String urlRest,
			HttpEntity<Object> requestEntity, Boolean writeUrls) {
		restClient = client;
		url = urlRest;
		request = requestEntity;
		writeURL = writeUrls;
	}

	@Override
	public String call() throws Exception {
		try {
			return restClient.callController(url, request, writeURL, 0);
		} catch (RestClientException e) {
			RestTemplateUtil.writeToFile(restClient.getConfig()
					.getRestFileLog(), "[ERROR] " + "URL: " + url + " - Body: "
					+ request.getBody() + " - TRACE " + e.getMessage());
		}
		return "";
	}

}
