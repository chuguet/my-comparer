/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.restclient.core;

import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.comparadorad.bet.comparer.web.rest.beans.UserInfoRequest;
import com.comparadorad.bet.comparer.web.rest.beans.UserInfoResponse;
import com.comparadorad.bet.comparer.web.restclient.config.RestClientConfig;
import com.comparadorad.bet.comparer.web.restclient.exception.RestClientException;
import com.comparadorad.bet.comparer.web.restclient.util.RestTemplateUtil;

/**
 * The Class RestClient.
 */
@Component
@Scope("prototype")
public class RestClient implements IRestClient {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(RestClient.class);

	/** The rest template. */
	@Inject
	protected RestTemplate restTemplate;

	/** The client config. */
	@Inject
	private RestClientConfig clientConfig;

	/**
	 * Change roles.
	 * 
	 * @param request
	 *            the request
	 * @return the user info response
	 * @throws RestClientException
	 */
	@Override
	public UserInfoResponse changeRoles(UserInfoRequest request)
			throws RestClientException {
		UserInfoResponse result;
		try {
			result = restTemplate.postForObject(clientConfig.getUrl(), request,
					UserInfoResponse.class);
		} catch (Exception e) {
			throw new RestClientException();
		}
		return result;
	}

	@Override
	public synchronized String callController(String urlRest,
			HttpEntity<Object> requestEntity, Boolean writeUrls,
			Integer retryCount) throws RestClientException {
		HttpEntity<String> response = null;
		try {

			Date dateBefore = new Date();
			Long beforeTime = dateBefore.getTime();

			response = restTemplate.exchange(clientConfig.getUrl() + urlRest,
					HttpMethod.POST, requestEntity, String.class);

			Date dateAfter = new Date();
			Long afterTime = dateAfter.getTime();

			if (writeUrls) {
				RestTemplateUtil.writeURLToFile(
						clientConfig.getRestFileLogURLs(),
						Math.abs(beforeTime - afterTime) + ";"
								+ clientConfig.getUrl() + urlRest,
						requestEntity);
			}

			String[] st = urlRest.split("/");
			RestTemplateUtil.writeToFile(
					clientConfig.getRestFileLog(),
					st[st.length - 1]
							+ RestTemplateUtil.fromJavaToJson(requestEntity
									.getBody()));

			RestTemplateUtil.writeToFile(clientConfig.getLogResponseSize(),
					response.toString());

		} catch (Exception e) {
			LOG.debug("URL: " + urlRest);
			LOG.debug("Body: " + requestEntity.getBody());
			LOG.error(e.getMessage());

			if (retryCount < this.getConfig().getRequestRetries()) {
				RestTemplateUtil.writeToFile(
						clientConfig.getRestFileLog(),
						"[RETRY] " + "URL: " + urlRest + " - Body: "
								+ requestEntity.getBody() + " - TRACE "
								+ e.getMessage());

				callController(urlRest, requestEntity, writeUrls, ++retryCount);

				return response.getBody();
			} else {
				throw new RestClientException();
			}

		}
		return response.getBody();
	}

	public RestClientConfig getConfig() {
		return clientConfig;
	}

}