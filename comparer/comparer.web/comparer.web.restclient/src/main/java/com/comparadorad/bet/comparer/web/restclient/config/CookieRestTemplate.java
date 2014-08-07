package com.comparadorad.bet.comparer.web.restclient.config;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class CookieRestTemplate extends RestTemplate {

	List<String> cookieList;

	public CookieRestTemplate(ClientHttpRequestFactory requestFactory) {
		super();
		setRequestFactory(requestFactory);
	}

	@Override
	protected ClientHttpRequest createRequest(URI url, HttpMethod method)
			throws IOException {
		ClientHttpRequest request = super.createRequest(url, method);

		request.getHeaders().add("Cookie","COOKIE_SUPPORT=true");
		request.getHeaders().add("Cookie","uvf=1");
		request.getHeaders().add("Cookie","COMPANY_ID=10154");
		request.getHeaders().add("Cookie","ID=507733446671466a7539493d");
		request.getHeaders().add("Cookie","GUEST_LANGUAGE_ID=es_ES");
		request.getHeaders().add("Cookie","USER_TIMEZONE=Europe/Paris");
		request.getHeaders().add("Cookie","__uvt=");
		request.getHeaders().add("Cookie","COMPANY_ID=10154");

		return request;
	}

	public void setCookies(List<String> cookieList) {
		this.cookieList = cookieList;
	}

	private void applyCookies(ClientHttpRequest request) {
		for (String cookie : cookieList) {
			request.getHeaders().add("Cookie", cookie);
		}
	}

}
