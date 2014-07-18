/**
 *
 * Copyright (C) FACTORIA ETSIA S.L.
 * All Rights Reserved.
 * www.factoriaetsia.com
 *
 */
package com.comparadorad.bet.comparer.web.server.mvc.payment.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.view.RedirectView;
import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AckCodeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsItemType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;
import urn.ebay.apis.eBLBaseComponents.SetExpressCheckoutRequestDetailsType;

import com.comparadorad.bet.comparer.model.autosender.bean.PaypalAction;
import com.comparadorad.bet.comparer.model.autosender.bean.PaypalAction.PaymentType;
import com.comparadorad.bet.comparer.model.autosender.bean.TypePaymentName;
import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.bean.UserCreacion;
import com.comparadorad.bet.comparer.model.autosender.service.impl.PaypalActionService;
import com.comparadorad.bet.comparer.model.core.bean.user.UserData;
import com.comparadorad.bet.comparer.web.server.mvc.core.control.AbstractComparerController;
import com.comparadorad.bet.comparer.web.server.mvc.payment.bean.GenericResponse;
import com.comparadorad.bet.comparer.web.server.mvc.payment.bean.GenericResponse.Status;
import com.comparadorad.bet.comparer.web.server.mvc.payment.bean.PaymentData;
import com.comparadorad.bet.comparer.web.server.mvc.payment.bean.TransactionData;
import com.comparadorad.bet.comparer.web.server.mvc.payment.config.AbstractPaymentConfig;
import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

@Controller
@RequestMapping("/paymentController")
public class PaymentController extends AbstractComparerController {

	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(PaymentController.class);


	@Inject
	private PayPalAPIInterfaceServiceService paypalService;

	@Inject
	private AbstractPaymentConfig config;

	//	@Inject
	//	private IUserPaymentService paymentService;

	@Inject
	private PaypalActionService paypalModelService;

	public PaymentController() {
		super();
	}

	@RequestMapping(value = "/getToken", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse getToken(
			@RequestBody final PaymentData paymentData, final UserData userData) {

		GenericResponse result = new GenericResponse();

		if(userData.isUnregistered()){
			LOG.info(new StringBuffer().append("Un usuario no registrado a intentado acceder al TOKEN, se le deniega el acceso").toString());
			result.setStatus(Status.KO);
		}else{
			try {
				LOG.info(new StringBuffer().append("El usuario: ").append(userData.getPrincipal()).append(" realiza la opción de pago: ").append(paymentData.getOption()));
				PaymentType option = PaymentType.getPaymentType(paymentData.getOption());

				SetExpressCheckoutRequestDetailsType setExpressCheckoutRequestDetails = getDetails(option);

				SetExpressCheckoutReq setExpressCheckoutReq = getECRequest(setExpressCheckoutRequestDetails);

				SetExpressCheckoutResponseType setExpressCheckoutResponse = paypalService.setExpressCheckout(setExpressCheckoutReq);
				LOG.info(new StringBuffer().append("El TOKEN generado para el usuario: ").append(userData.getPrincipal()).append(" es: ").append(setExpressCheckoutResponse.getToken()));

				savePaypalAction(userData.getPrincipal(),setExpressCheckoutResponse.getToken(),option);

				result.setStatus(Status.OK);
				result.setValue(new StringBuffer().append(config.getRedirectURL()).append(setExpressCheckoutResponse.getToken()).toString());

			} catch (Exception e) {
				result.setStatus(Status.KO);
				LOG.debug((e.toString()));
			} 
		}
		return result;
	}



	@RequestMapping(value="/verifyPayment", method = RequestMethod.GET)
	@ResponseBody
	public RedirectView verifyPayment(NativeWebRequest request) {
		
		RedirectView result = new RedirectView();
		
		TransactionData transactionData = new TransactionData(request.getParameter("token"), request.getParameter("PayerID"));

		GetExpressCheckoutDetailsRequestType getExpressCheckoutDetailsRequest = new GetExpressCheckoutDetailsRequestType(transactionData.getToken());
		getExpressCheckoutDetailsRequest.setVersion(config.getVersion());

		GetExpressCheckoutDetailsReq getExpressCheckoutDetailsReq = new GetExpressCheckoutDetailsReq();
		getExpressCheckoutDetailsReq.setGetExpressCheckoutDetailsRequest(getExpressCheckoutDetailsRequest);

		try {
			LOG.info(new StringBuffer().append("Se obtienen los detalles de el pago con el TOKEN: ").append(transactionData.getToken()).append(" y el PayerID: ").append(transactionData.getPayerID()).toString());
			GetExpressCheckoutDetailsResponseType getExpressCheckoutDetailsResponse = paypalService.getExpressCheckoutDetails(getExpressCheckoutDetailsReq);

			if(getExpressCheckoutDetailsResponse.getAck().equals(AckCodeType.SUCCESS)){

				DoExpressCheckoutPaymentResponseType transaction = doExpressCheckoutPayment(transactionData,getExpressCheckoutDetailsResponse);

				if(transaction.getAck().equals(AckCodeType.SUCCESS)){
					List<PaypalAction> action = paypalModelService.findByToken(transactionData.getToken());
					if(action.size()>0){
						LOG.info(new StringBuffer().append("Verificamos la transaccion con TOKEN: ").append(transactionData.getToken()).append(" y PayerID: ").append(transactionData.getPayerID())
								.toString());
						doPayment(action.get(0).getUser(),getOption(action.get(0).getPaymentType()));
						updateAction(action.get(0),transactionData,transaction);

					}else{
						LOG.info(new StringBuffer().append("Se ha producido al obtener la PaypalAction del TOKEN: ").append(transactionData.getToken()).append(" y el PayerID: ").append(transactionData.getPayerID())
								.append(". El pago asociado a estos datos, ha sido completado").toString());
					}
				}

				result.setUrl(getStatus(transaction));
			}else{
				result.setUrl(config.getCancelURL());
			}
		} catch (Exception e) {
			result.setUrl(config.getCancelURL());
		}


		return result;

	}


	private void savePaypalAction(String principal, String token,PaymentType paymentType) {
		PaypalAction paypalAction = new PaypalAction();

		paypalAction.setCreacionUser(UserCreacion.Paypal_Controller);
		paypalAction.setCreationDate(new Date());
		paypalAction.setToken(token);
		User user = new User();
		user.setLiferayUserId(Integer.parseInt(principal));
		paypalAction.setUser(principal);
		paypalAction.setStatus(com.comparadorad.bet.comparer.model.autosender.bean.PaypalAction.Status.PENDING);
		paypalAction.setPaymentType(paymentType);

		paypalModelService.save(paypalAction);
	}

	private TypePaymentName getOption(PaymentType paymentType) {
		TypePaymentName result = null;

		switch (paymentType) {
		case PREMIUM365:
			result = TypePaymentName.NIVEL_1_12_MONTH;
			break;
		case PREMIUM90:
			result = TypePaymentName.NIVEL_1_6_MONTH;
			break;
		case PREMIUM30:
			result = TypePaymentName.NIVEL_1_1_MONTH;
			break;
		case PROFESIONAL365:
			result = TypePaymentName.NIVEL_2_12_MONTH;
			break;	
		case PROFESIONAL90:
			result = TypePaymentName.NIVEL_2_6_MONTH;
			break;
		case PROFESIONAL30:
			result = TypePaymentName.NIVEL_2_1_MONTH;
			break;
		case BASICO365:
			result = TypePaymentName.NIVEL_3_12_MONTH;
			break;
		case BASICO90:
			result = TypePaymentName.NIVEL_3_6_MONTH;
			break;
		case BASICO30:
			result = TypePaymentName.NIVEL_3_1_MONTH;
			break;
		default:
			break;
		}

		return result;
	}

	private void doPayment(String principal,
			com.comparadorad.bet.comparer.model.autosender.bean.TypePaymentName typePaymentName) {
		//		paymentService.makePaymentByLiferayUser(Integer.parseInt(principal), typePaymentName, UserCreacion.Paypal_Controller);
	}

	private void updateAction(PaypalAction paypalAction, TransactionData transactionData, DoExpressCheckoutPaymentResponseType transactionPaypal) {
		PaymentInfoType details = transactionPaypal.getDoExpressCheckoutPaymentResponseDetails().getPaymentInfo().get(0);

		paypalAction.setModificationDate(new Date());
		paypalAction.setModificationUser(UserCreacion.Paypal_Controller);
		paypalAction.setPayerId(transactionData.getPayerID());
		paypalAction.setPaymentDate(details.getPaymentDate());
		paypalAction.setStatus(com.comparadorad.bet.comparer.model.autosender.bean.PaypalAction.Status.COMPLETED);
		paypalAction.setTransactionId(details.getTransactionID());

		paypalModelService.update(paypalAction);

	}

	private String getStatus(DoExpressCheckoutPaymentResponseType transaction) {
		if(transaction.getAck().equals(AckCodeType.SUCCESS)){
			return config.getUrlSuccess();
		}else{
			return config.getCancelURL();
		}
	}

	private DoExpressCheckoutPaymentResponseType doExpressCheckoutPayment(
			TransactionData transactionData,
			GetExpressCheckoutDetailsResponseType getExpressCheckoutDetailsResponse) throws SSLConfigurationException, InvalidCredentialException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, OAuthException, IOException, InterruptedException, ParserConfigurationException, SAXException {

		String total = getExpressCheckoutDetailsResponse.getGetExpressCheckoutDetailsResponseDetails().getPaymentDetails().get(0).getOrderTotal().getValue();

		PaymentDetailsType paymentDetail = new PaymentDetailsType();
		paymentDetail.setNotifyURL("");
		BasicAmountType orderTotal = new BasicAmountType();
		orderTotal.setValue(total);
		orderTotal.setCurrencyID(CurrencyCodeType.EUR);
		paymentDetail.setOrderTotal(orderTotal);
		paymentDetail.setPaymentAction(PaymentActionCodeType.SALE);
		List<PaymentDetailsType> paymentDetails = new ArrayList<PaymentDetailsType>();
		paymentDetails.add(paymentDetail);

		DoExpressCheckoutPaymentRequestDetailsType doExpressCheckoutPaymentRequestDetails = new DoExpressCheckoutPaymentRequestDetailsType();
		doExpressCheckoutPaymentRequestDetails.setToken(transactionData.getToken());
		doExpressCheckoutPaymentRequestDetails.setPayerID(transactionData.getPayerID());
		doExpressCheckoutPaymentRequestDetails.setPaymentDetails(paymentDetails);

		DoExpressCheckoutPaymentRequestType doExpressCheckoutPaymentRequest = new DoExpressCheckoutPaymentRequestType(doExpressCheckoutPaymentRequestDetails);
		doExpressCheckoutPaymentRequest.setVersion(config.getVersion());

		DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq = new DoExpressCheckoutPaymentReq();
		doExpressCheckoutPaymentReq.setDoExpressCheckoutPaymentRequest(doExpressCheckoutPaymentRequest);


		return paypalService.doExpressCheckoutPayment(doExpressCheckoutPaymentReq);
	}



	private SetExpressCheckoutReq getECRequest(
			SetExpressCheckoutRequestDetailsType setExpressCheckoutRequestDetails) {

		SetExpressCheckoutRequestType setExpressCheckoutRequest = new SetExpressCheckoutRequestType(setExpressCheckoutRequestDetails);
		setExpressCheckoutRequest.setVersion(config.getVersion());

		SetExpressCheckoutReq setExpressCheckoutReq = new SetExpressCheckoutReq();
		setExpressCheckoutReq.setSetExpressCheckoutRequest(setExpressCheckoutRequest);

		return setExpressCheckoutReq;
	}



	private SetExpressCheckoutRequestDetailsType getDetails(PaymentType option) {

		PaymentDetailsType paymentDetails = new PaymentDetailsType();
		paymentDetails.setPaymentAction(PaymentActionCodeType.SALE);
		PaymentDetailsItemType item = new PaymentDetailsItemType();
		BasicAmountType amt = new BasicAmountType();
		amt.setCurrencyID(CurrencyCodeType.EUR);
		amt.setValue(option.getPrice());
		item.setQuantity(1);
		item.setName(option.getName());
		item.setAmount(amt);


		List<PaymentDetailsItemType> lineItems = new ArrayList<PaymentDetailsItemType>();
		lineItems.add(item);
		paymentDetails.setPaymentDetailsItem(lineItems);
		BasicAmountType orderTotal = new BasicAmountType();
		orderTotal.setCurrencyID(CurrencyCodeType.EUR);
		orderTotal.setValue(option.getPrice()); 
		paymentDetails.setOrderTotal(orderTotal);
		List<PaymentDetailsType> paymentDetailsList = new ArrayList<PaymentDetailsType>();
		paymentDetailsList.add(paymentDetails);

		SetExpressCheckoutRequestDetailsType setExpressCheckoutRequestDetails = new SetExpressCheckoutRequestDetailsType();
		setExpressCheckoutRequestDetails.setReturnURL(config.getReturnURL());
		setExpressCheckoutRequestDetails.setCancelURL(config.getCancelURL());

		setExpressCheckoutRequestDetails.setPaymentDetails(paymentDetailsList);

		return setExpressCheckoutRequestDetails;
	}
}
