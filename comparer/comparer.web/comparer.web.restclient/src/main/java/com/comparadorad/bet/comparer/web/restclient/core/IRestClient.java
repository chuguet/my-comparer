package com.comparadorad.bet.comparer.web.restclient.core;

import org.springframework.http.HttpEntity;

import com.comparadorad.bet.comparer.web.rest.beans.UserInfoRequest;
import com.comparadorad.bet.comparer.web.rest.beans.UserInfoResponse;
import com.comparadorad.bet.comparer.web.restclient.config.RestClientConfig;
import com.comparadorad.bet.comparer.web.restclient.exception.RestClientException;

/**
 * The Interface IRestClient.
 */
public interface IRestClient {

	/**
	 * Change roles.
	 * 
	 * @param request
	 *            the request
	 * @return the user info response
	 */
	UserInfoResponse changeRoles(UserInfoRequest request)
			throws RestClientException;

	String callController(String urlRest, HttpEntity<Object> requestEntit,
			Boolean writeUrls, Integer retryCount) throws RestClientException;

	public RestClientConfig getConfig();
}
