/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.autosender.getresponse.config;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comparadorad.bet.comparer.autosender.core.enume.ResponseStatus;
import com.comparadorad.bet.comparer.autosender.core.exception.ExternalAutoSenderException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidBeanException;
import com.comparadorad.bet.comparer.autosender.core.exception.InvalidEncodingMessageGetResponseException;
import com.comparadorad.bet.comparer.autosender.core.exception.MissingContactException;
import com.comparadorad.bet.comparer.autosender.core.facade.IAutosender;
import com.comparadorad.bet.comparer.autosender.core.requestbean.AddContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.DeleteContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MessageResquestBean;
import com.comparadorad.bet.comparer.autosender.core.requestbean.MoveContactRequestBean;
import com.comparadorad.bet.comparer.autosender.core.responsebean.GenericResponseBean;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

/**
 * The Class AutosenderGetResponseConfigTest.
 */
@Configuration
@Profile(value = { ProfileConstant.TEST })
public class AutosenderGetResponseConfigTest extends
		AbstractAutosenderGetResponseConfig {

	/**
	 * Gets the autosender.
	 * 
	 * @return the autosender
	 * @throws HttpException
	 *             the http exception
	 * @throws ExternalAutoSenderException
	 *             the external auto sender exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws InvalidBeanException
	 *             the invalid bean exception
	 * @throws InvalidEncodingMessageGetResponseException
	 *             the invalid encoding message get response exception
	 * @throws MissingContactException
	 *             the missing contact exception
	 */
	@Bean
	public IAutosender getAutosender() throws HttpException,
			ExternalAutoSenderException, IOException, InvalidBeanException,
			InvalidEncodingMessageGetResponseException, MissingContactException {

		IAutosender mock = mock(IAutosender.class);
		GenericResponseBean bean = new GenericResponseBean();

		bean.setContent("");
		bean.setStatus(ResponseStatus.COMPLETED);

		when(mock.sendNewsletter((MessageResquestBean) anyObject()))
				.thenReturn(bean);

		when(mock.addContact((AddContactRequestBean) anyObject())).thenReturn(
				bean);

		when(mock.testConnection()).thenReturn(bean);

		when(mock.deleteContact((DeleteContactRequestBean) anyObject()))
				.thenReturn(bean);

		when(mock.moveContact((MoveContactRequestBean) anyObject()))
				.thenReturn(bean);

		return mock;
	}

}
