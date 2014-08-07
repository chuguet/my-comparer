//package com.comparadorad.bet.comparer.web.server.mvc.payment.control;
//
//import org.codehaus.jackson.map.ObjectMapper;
//import org.junit.Test;
//import org.springframework.test.web.server.request.DefaultRequestBuilder;
//
//	
//
//public class PaymentControllerTest extends AbstractPaymentMvcControllerTest {
//
//
//	
//	
//	@Test
//	public void getToken() throws Exception {
//		
//		
//		PaymentData paymentData = new PaymentData();
//		paymentData.setOption(1);
//
//		UserData userdata = new UserData();
//		userdata.setPrincipal("123");
//		Roles roles = new Roles();
//		List<LiferayRoles> lroles = new ArrayList<LiferayRoles>();
//		lroles.add(LiferayRoles.FREE);
//		roles.setRoles(lroles);
//		userdata.setRoles(roles);
//		
//		GenericResponse result = paymentController.getToken(paymentData, userdata);
//
//		Assert.assertEquals(GenericResponse.Status.OK, result.getStatus());
//		Assert.assertEquals("a", result.getValue());
//	}
//
//
//
//	@Test
//	public void verifyPayment() throws Exception {
//		
//		DefaultRequestBuilder requestBuilder = postJson("/paymentController/verifyPayment?&token=123&PayerID=321",null);
//
//		String result = super.perform(requestBuilder).andReturn().getResponse().getContentAsString();
//
//		ObjectMapper mapper = new ObjectMapper();
//		String status = mapper.readValue(result, String.class);
//		
//		System.err.print(status);
//	}
//
//}
