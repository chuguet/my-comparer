/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.payment.config;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AckCodeType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentResponseDetailsType;
import urn.ebay.apis.eBLBaseComponents.GetExpressCheckoutDetailsResponseDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;

import com.comparadorad.bet.comparer.model.autosender.service.config.AutoSenderServiceConfigTest;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;
import com.comparadorad.bet.comparer.web.server.mvc.core.config.WebServerMvcCoreMockupConfig;
import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

/**
 * The Class WebServerMvcMatchMockupConfig.
 */
@Configuration
@Import(value = { WebServerMvcCoreMockupConfig.class, AutoSenderServiceConfigTest.class })
@ComponentScan("com.comparadorad.bet.comparer.web.server.mvc.payment.control")
@Profile({ "client", ProfileConstant.TEST })
public class WebServerMvcPaymentMockupConfig extends AbstractPaymentConfig{

	private static final String token = "ES-123456789";

	private static final String amountValue = "57";

	private static final String transactionID = "TRANSACTION-123456789";

	private static final String paymentDate = "25/12/2045";


	@Bean
	public  PayPalAPIInterfaceServiceService payPalAPIInterfaceServiceService() throws SSLConfigurationException, InvalidCredentialException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, OAuthException, IOException, InterruptedException, ParserConfigurationException, SAXException{

		PayPalAPIInterfaceServiceService mock = mock(PayPalAPIInterfaceServiceService.class);

		SetExpressCheckoutResponseType checkoutResponseType = new SetExpressCheckoutResponseType();
		checkoutResponseType.setToken(token);

		when(mock.setExpressCheckout((SetExpressCheckoutReq) anyObject()))
		.thenReturn(checkoutResponseType);

		GetExpressCheckoutDetailsResponseType checkoutDetailsResponseType = new GetExpressCheckoutDetailsResponseType();
		GetExpressCheckoutDetailsResponseDetailsType details = new GetExpressCheckoutDetailsResponseDetailsType();
		List<PaymentDetailsType> paymentList = new ArrayList<PaymentDetailsType>();
		PaymentDetailsType payment = new PaymentDetailsType();
		BasicAmountType amount = new BasicAmountType();
		amount.setValue(amountValue);
		payment.setOrderTotal(amount);

		paymentList.add(payment);
		details.setPaymentDetails(paymentList);
		checkoutDetailsResponseType.setGetExpressCheckoutDetailsResponseDetails(details);

		when(mock.getExpressCheckoutDetails((GetExpressCheckoutDetailsReq) anyObject())).thenReturn(
				checkoutDetailsResponseType);

		DoExpressCheckoutPaymentResponseType checkoutPaymentResponseType = new DoExpressCheckoutPaymentResponseType();
		checkoutPaymentResponseType.setAck(AckCodeType.SUCCESS);
		DoExpressCheckoutPaymentResponseDetailsType detailsDE = new DoExpressCheckoutPaymentResponseDetailsType();
		List<PaymentInfoType> paymentInfoList = new ArrayList<PaymentInfoType>();
		PaymentInfoType pay = new PaymentInfoType();
		pay.setTransactionID(transactionID);
		pay.setPaymentDate(paymentDate);

		paymentInfoList.add(pay);
		detailsDE.setPaymentInfo(paymentInfoList);
		checkoutPaymentResponseType.setDoExpressCheckoutPaymentResponseDetails(detailsDE);

		when(mock.doExpressCheckoutPayment((DoExpressCheckoutPaymentReq) anyObject())).thenReturn(
				checkoutPaymentResponseType);


		return mock;	
	}



}