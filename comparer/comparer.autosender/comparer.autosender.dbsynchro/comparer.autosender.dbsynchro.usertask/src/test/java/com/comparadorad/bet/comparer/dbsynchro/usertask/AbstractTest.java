package com.comparadorad.bet.comparer.dbsynchro.usertask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.dbsynchro.usertask.config.UserTaskConfigTest;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
import com.comparadorad.bet.comparer.model.autosender.bean.LogAction;
import com.comparadorad.bet.comparer.model.autosender.bean.LogAction.isCorrect;
import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment;
import com.comparadorad.bet.comparer.model.autosender.bean.TypePayment.TypePaymentName;
import com.comparadorad.bet.comparer.model.autosender.bean.User;
import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
import com.comparadorad.bet.comparer.model.autosender.bean.UserContent;
import com.comparadorad.bet.comparer.model.autosender.bean.UserContent.UserContentName;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment;
import com.comparadorad.bet.comparer.model.autosender.bean.UserPayment.StatePayment;
import com.comparadorad.bet.comparer.model.autosender.service.IUserService;
import com.comparadorad.bet.comparer.payment.adapter.config.PaymentAdapterSpringConfiguration;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UserTaskConfigTest.class,PaymentAdapterSpringConfiguration.class }, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"dd/MM/yyyy mm:HH");

	private Integer liferayId;

	public Integer getLiferayId() {
		return liferayId;
	}

	public void setLiferayId(Integer liferayId) {
		this.liferayId = liferayId;
	}

	@Inject
	private IUserService userService;

	// @After
	// public void finishBD() throws java.text.ParseException {
	// userService.deleteByLiferayId(liferayId);
	// }

	@Before
	public void initBD() throws java.text.ParseException {

		Random rnd = new Random();
		liferayId = Math.abs(rnd.nextInt());

		User user = createUser("Le Isaac bigotitos", "javi.gb.mad@gmail.com",
				liferayId, true);

		List<UserContent> contents = new ArrayList<UserContent>();

		contents.add(addContent(UserContentName.WEB_PRINCIPAL));
		contents.add(addContent(UserContentName.VALUEBET));
		
		user.setUserContents(contents);

		List<UserPayment> payments = new ArrayList<UserPayment>();

		payments.add(createPayment(true, TypePaymentName.NIVEL_1));
		payments.add(createPayment(false, TypePaymentName.NIVEL_2));

		user.setUserPayments(payments);

		List<UserAction> actions = new ArrayList<UserAction>();

		actions.add(createUserAction(ActionTypeName.CREATE_USER, user,
				sdf.parse("31/12/2013 00:00"), true));
		actions.add(createUserAction(
				ActionTypeName.ADD_PAYMENT_LIST_LVL_1_1ANO, user,
				sdf.parse("31/12/2013 00:01"), false));
		actions.add(createUserAction(ActionTypeName.CHANGE_ROLES, user,
				sdf.parse("31/12/2013 00:02"), false));
		actions.add(createUserAction(
				ActionTypeName.MODIFY_PAYMENT_LIST_LVL_2_6MES, user,
				sdf.parse("31/12/2013 00:03"), false));
		actions.add(createUserAction(ActionTypeName.CHANGE_ROLES, user,
				sdf.parse("31/12/2013 00:04"), false));
		actions.add(createUserAction(ActionTypeName.ADD_CONTENT_LIST_AFILIADOS,
				user, sdf.parse("31/12/2013 00:05"), false));

		user.setActions(actions);

		userService.save(user);
		userService.findByLiferayId(liferayId);
	}

	private UserContent addContent(UserContentName name) {
		UserContent result = new UserContent();
		result.setName(name);
		result.setExtenalSystemId(name.getName());
		return result;
	}

	private UserPayment createPayment(boolean active, TypePaymentName name) {
		UserPayment result = new UserPayment();
		if (active) {
			result.setStatePayment(StatePayment.ACTIVE);
		} else {
			result.setStatePayment(StatePayment.FINISH);
		}
		TypePayment typePayment = new TypePayment();
		typePayment.setTypePaymentName(name);
		result.setTypePayment(typePayment);
		return result;
	}

	private User createUser(String name, String email, Integer liferayUserId,
			Boolean active) {
		User user = new User();
		user.setActive(active);
		user.setEmail(email);
		user.setLiferayUserId(liferayUserId);
		user.setName(name);
		return user;
	}

	private UserAction createUserAction(ActionTypeName nameActionType,
			User user, Date date, boolean correct) {
		UserAction action = new UserAction();
		action.setUser(user);
		ActionType actionType = new ActionType();
		actionType.setName(nameActionType);
		action.setActionType(actionType);
		action.setCreationDate(date);
		LogAction logAction = new LogAction();
		if (correct) {
			logAction.setCorrect(isCorrect.SUCCESS);
		} else {
			logAction.setCorrect(isCorrect.WRONG);
		}
		action.setLogAction(logAction);
		return action;
	}

}
