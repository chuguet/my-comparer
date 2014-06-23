/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;

import javax.inject.Inject;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.comparadorad.bet.comparer.autosender.core.enume.ResponseStatus;
import com.comparadorad.bet.comparer.autosender.core.exception.ExternalAutoSenderException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidEncodingMessageGetResponseException;
import com.comparadorad.bet.comparer.autosender.core.exception.MissingContactException;
import com.comparadorad.bet.comparer.autosender.getresponse.bean.ResponseBean;
import com.comparadorad.bet.comparer.autosender.getresponse.config.AbstractAutosenderGetResponseConfig;
import com.comparadorad.bet.comparer.autosender.getresponse.enume.MessageAndError;

/**
 * The Class HttpPostMethodImpl.
 */
@Component
public class HttpPostMethodImpl implements IHttpPostMethod {

	/** The Constant LOG. */
	public static final Log LOG = LogFactory.getLog(HttpPostMethodImpl.class);

	/** The Constant GET_RESPONSE_METHOD. */
	private static final String GET_RESPONSE_METHOD = "method";

	/** The Constant GET_RESPONSE_PARAMS. */
	private static final String GET_RESPONSE_PARAMS = "params";

	/** The Constant GET_RESPONSE_ERROR. */
	private static final String GET_RESPONSE_ERROR = "error";

	private static final String JSON_RPC = "jsonrpc";

	private static final String JSON_RPC_VERSION = "2.0";

	private static final String ID = "id";

	private static final String ID_CONSTANT = "1";
	/** The client. */
	private HttpClient client;

	/** The method. */
	private PostMethod method;

	/** The get response method. */
	private String getResponseMethod;

	/** The autosender get response config. */
	@Inject
	private AbstractAutosenderGetResponseConfig autosenderGetResponseConfig;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.autosender.getresponse.core.IHttpPostMethod
	 * #init(java.lang.String)
	 */
	public void init(String getResponseMethod) {
		this.getResponseMethod = getResponseMethod;
		this.client = new HttpClient();
		setConfig(client);
		this.method = new PostMethod(autosenderGetResponseConfig.getBaseUri());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.autosender.getresponse.core.IHttpPostMethod
	 * #executeMethod()
	 */
	public ResponseBean executeMethod() throws ExternalAutoSenderException,
			HttpException, IOException {
		int statusCode;
		JSONObject jsonObject = new JSONObject();
		ResponseBean result = new ResponseBean();
		// make request.
		statusCode = client.executeMethod(method);

		if (statusCode != HttpStatus.SC_OK) {
			LOG.info("Method failed: " + method.getStatusLine());
			throw new ExternalAutoSenderException();
		}

		// read the response body
		byte[] responseBody = method.getResponseBody();
		String response_string = new String(responseBody);

		jsonObject = JSONObject.fromObject(response_string);

		result.setJsonContent(jsonObject);

		if ((jsonObject.get(GET_RESPONSE_ERROR) != null)) {
			JSONObject object = (JSONObject) jsonObject.get(GET_RESPONSE_ERROR);
			String message = (String) object.get("message");
			Integer code = (Integer) object.get("code");
			if (MessageAndError.MISSING_RECIPIENTS.getMessage().equals(message)
					&& MessageAndError.MISSING_RECIPIENTS.getCode()
							.equals(code)) {
				throw new MissingContactException(message, code);
			}else{
				throw new ExternalAutoSenderException(message, code);
			}			
		} else {
			result.setStatus(ResponseStatus.COMPLETED);
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.autosender.getresponse.core.IHttpPostMethod
	 * #setMessageContent(java.util.Hashtable)
	 */
	public void setMessageContent(Hashtable<String, Object> content)
			throws InvalidEncodingMessageGetResponseException {
		Object[] params = new Object[2];
		Hashtable<String, Object> request = new Hashtable<String, Object>();
		if (content != null) {
			params[0] = autosenderGetResponseConfig.getKey();
			params[1] = content;

		} else {
			params[0] = autosenderGetResponseConfig.getKey();
		}
		request.put(JSON_RPC, JSON_RPC_VERSION);
		request.put(ID, ID_CONSTANT);
		request.put(GET_RESPONSE_METHOD, getResponseMethod);
		request.put(GET_RESPONSE_PARAMS, params);
		String request_string = JSONObject.fromObject(request).toString();

		RequestEntity requestEntity;
		try {
			requestEntity = new StringRequestEntity(request_string,
					autosenderGetResponseConfig.getMessageContentType(),
					autosenderGetResponseConfig.getMessageCharSet());
		} catch (UnsupportedEncodingException e) {
			throw new InvalidEncodingMessageGetResponseException();
		}

		method.setRequestEntity(requestEntity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comparadorad.bet.comparer.autosender.getresponse.core.IHttpPostMethod
	 * #releaseConnection()
	 */
	public void releaseConnection() {
		method.releaseConnection();

	}

	/**
	 * Sets the config.
	 * 
	 * @param client
	 *            the new config
	 */
	private void setConfig(HttpClient client) {
		if (autosenderGetResponseConfig.isProxyActive()) {
			HostConfiguration config = client.getHostConfiguration();
			config.setProxy(autosenderGetResponseConfig.getHost(),
					autosenderGetResponseConfig.getPort());
			Credentials credentials = new UsernamePasswordCredentials(
					autosenderGetResponseConfig.getUser(),
					autosenderGetResponseConfig.getPassword());
			AuthScope authScope = new AuthScope(
					autosenderGetResponseConfig.getHost(),
					autosenderGetResponseConfig.getPort());

			client.getState().setProxyCredentials(authScope, credentials);
		}
	}
}
