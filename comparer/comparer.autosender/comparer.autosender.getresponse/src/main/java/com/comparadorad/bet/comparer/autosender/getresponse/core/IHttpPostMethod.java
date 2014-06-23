/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.core;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.httpclient.HttpException;

import com.comparadorad.bet.comparer.autosender.core.exception.ExternalAutoSenderException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidEncodingMessageGetResponseException;
import com.comparadorad.bet.comparer.autosender.getresponse.bean.ResponseBean;

/**
 * The Interface IHttpPostMethod.
 */
public interface IHttpPostMethod {

	/**
	 * Inits the.
	 *
	 * @param getResponseMethod the get response method
	 */
	public void init(String getResponseMethod);
	
	/**
	 * Execute method.
	 *
	 * @return the response bean
	 * @throws ExternalAutoSenderException the get response exception
	 * @throws HttpException the http exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ResponseBean executeMethod()  throws ExternalAutoSenderException, HttpException, IOException;
	
	/**
	 * Release connection.
	 */
	public void releaseConnection();
	
	/**
	 * Sets the message content.
	 *
	 * @param params the params
	 * @throws InvalidEncodingMessageGetResponseException the invalid encoding message get response exception
	 */
	public void setMessageContent(Hashtable<String, Object> params) throws InvalidEncodingMessageGetResponseException;
	
	
}
