package com.comparadorad.bet.comparer.payment.adapter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.DurationPayment.TypeDuration;
import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment;
import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment.TypePaymentName;
import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment.StatePayment;
import com.comparadorad.bet.comparer.model.autosender.service.IUserService;
import com.comparadorad.bet.comparer.payment.adapter.facade.IPaymentFacade;
import com.comparadorad.bet.comparer.payment.beans.PaymentInfo;
import com.comparadorad.bet.comparer.payment.beans.UserInfo;
import com.comparadorad.bet.comparer.payment.enums.PaymentDuration;
import com.comparadorad.bet.comparer.payment.enums.PaymentType;

public class PaymentFacadeTest extends AbstractTest {
	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yyyy");
	private static final Log LOG = LogFactory.getLog(PaymentFacadeTest.class);
	@Inject
	private IPaymentFacade paymentFacade;

	@Inject
	private IUserService userService;

	@Test
	@Transactional
	public void paymentFacadeTest() {
		try {
			createUser(123, sdf.parse("16/03/2013"));
			createUser(321, null);
		} catch (ParseException e) {
			LOG.error(e.getMessage());
		}

		// Usuario sin pagos
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setPaymentDuration(PaymentDuration.SEIS_MESES);
		paymentInfo.setPaymentType(PaymentType.NIVEL_2);
		UserInfo userInfo = new UserInfo();
		userInfo.setLiferayUserId(321);
		paymentFacade.addPayment(userInfo, paymentInfo);
		User usuario = userService.findByLiferayId(321);
		for (UserPayment payment : usuario.getUserPayments()) {
			assertEquals(payment.getStatePayment().name(),
					StatePayment.ACTIVE.name());
			assertEquals(
					sdf.format(payment.getDurationPayment().iterator().next()
							.getStartDate()), sdf.format(new Date()));
			assertNotNull(sdf.format(payment.getDurationPayment().iterator()
					.next().getExpectedDate()));
		}

		// Usuario con al menos un pago
		paymentInfo = new PaymentInfo();
		paymentInfo.setPaymentDuration(PaymentDuration.UN_ANYO);
		paymentInfo.setPaymentType(PaymentType.NIVEL_1);
		userInfo = new UserInfo();
		userInfo.setLiferayUserId(123);
		paymentFacade.addPayment(userInfo, paymentInfo);
		usuario = userService.findByLiferayId(123);
		for (UserPayment payment : usuario.getUserPayments()) {
			if (payment.getTypePayment().getTypePaymentName().name()
					.equals(PaymentType.NIVEL_1.name())) {
				assertEquals(payment.getStatePayment().name(),
						StatePayment.ACTIVE.name());
				assertEquals(
						sdf.format(payment.getDurationPayment().iterator()
								.next().getStartDate()), sdf.format(new Date()));
				assertNotNull(sdf.format(payment.getDurationPayment().iterator()
						.next().getExpectedDate()));
			} else {
				assertEquals(payment.getStatePayment().name(),
						StatePayment.DESACTIVE.name());
				for (DurationPayment duration : payment.getDurationPayment()) {
					if (duration.getTypeDuration().name()
							.equals(TypeDuration.FINISHED.name())) {
						assertNotNull(duration.getFinishDate());
						assertNotNull(duration.getStartDate());
						assertNotNull(duration.getExpectedDate());
					} else {
						assertNotNull(duration.getDaysRemaining());
					}
				}
			}
		}
	}

	private void createUser(Integer idLiferay, Date fecha) {
		User user = new User();

		user.setLiferayUserId(idLiferay);
		user.setName("Carlos");
		if (fecha != null) {
			Collection<UserPayment> payments = new ArrayList<UserPayment>();

			UserPayment payment = new UserPayment();

			payment.setStatePayment(StatePayment.ACTIVE);

			payment.setPaymentDate(fecha);

			TypePayment typePayment = new TypePayment();
			typePayment.setDuration(365);
			typePayment.setTypePaymentName(TypePaymentName.NIVEL_2);
			payment.setTypePayment(typePayment);

			Collection<DurationPayment> durationPayments = new ArrayList<DurationPayment>();
			DurationPayment durationPayment = new DurationPayment();
			durationPayment.setStartDate(fecha);
			durationPayment.setExpectedDate(new Date(
					fecha.getTime() + 31536000000l));
			durationPayment.setTypeDuration(TypeDuration.ACTIVE);
			durationPayments.add(durationPayment);
			payment.setDurationPayment(durationPayments);

			payments.add(payment);

			user.setUserPayments(payments);
		}
		userService.save(user);
	}
}
