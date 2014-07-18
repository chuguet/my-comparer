//package com.comparadorad.bet.comparer.web.server.hook.userservice;
//
//import static org.junit.Assert.assertNotNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import org.junit.Test;
//
//import com.comparadorad.bet.comparer.model.autosender.bean.ActionType;
//import com.comparadorad.bet.comparer.model.autosender.bean.ActionType.ActionTypeName;
//import com.comparadorad.bet.comparer.model.autosender.bean.User;
//import com.comparadorad.bet.comparer.model.autosender.bean.UserAction;
//import com.comparadorad.bet.comparer.model.autosender.bean.UserContent;
//import com.comparadorad.bet.comparer.model.autosender.bean.UserContent.UserContentName;
//import com.comparadorad.bet.comparer.web.server.hook.userservice.database.IUserService;
//import com.comparadorad.bet.comparer.web.server.hook.userservice.database.UserService;
//
//public class TestService {
//
//	@Test
//	public void testAddUser() {
//		Random generator = new Random();
//		IUserService service = new UserService();
//		long userId = generator.nextInt();
//		;
//		String emailAddress = "alunden@factoriaetsia.com";
//		String name = "Lena";
//		String location = "p1rO";
//		System.out.println("AutoSenderService: addUser: userId = " + userId
//				+ ", emailAddress = " + emailAddress + ", name = " + name);
//
//		User user = service.findByLiferayUser((int) userId);
//		if (user == null || user.getUserId() != null
//				|| user.getLiferayUserId() != null) {
//			user = new User();
//		}
//		user.setLiferayUserId(new Integer((int) userId));
//		user.setName(name);
//		user.setEmail(emailAddress);
//		user.setActive(true);
//
//		// content
//		List<UserContent> contentList = (List<UserContent>) user
//				.getUserContents();
//		if (contentList == null) {
//			contentList = new ArrayList<UserContent>();
//		}
//		UserContent content = new UserContent();
//		UserContentName userContentName = getUserContentName(location);
//		content.setName(userContentName);
//		contentList.add(content);
//		user.setUserContents(contentList);
//
//		// action
//		List<UserAction> actionList = (List<UserAction>) user.getActions();
//		if (actionList == null) {
//			actionList = new ArrayList<UserAction>();
//		}
//
//		UserAction action1 = new UserAction();
//		action1.setUser(user);
//		ActionType actionType1 = new ActionType();
//		actionType1.setName(ActionTypeName.CREATE_USER);
//		action1.setActionType(actionType1);
//		actionList.add(action1);
//
//		UserAction action2 = new UserAction();
//		action2.setUser(user);
//		ActionType actionType2 = new ActionType();
//		actionType2.setName(ActionTypeName.ADD_CONTENT_LIST_AFILIADOS);
//		action2.setActionType(actionType2);
//		actionList.add(action2);
//
//		user.setActions(actionList);
//
//		System.out.println("userService.save(user)");
//		service.save(user);
//	}
//
//	private UserContentName getUserContentName(String nameId) {
//		UserContentName result = null;
//		for (UserContentName contentName : UserContentName.values()) {
//			if (contentName.getName().equalsIgnoreCase(nameId)) {
//				result = contentName;
//			}
//		}
//		return result;
//	}
//
//	@Test
//	public void testFindByLiferayId() {
//		System.out.println("testFindByLiferayId");
//		IUserService service = new UserService();
//		assertNotNull(service.findByLiferayUser(1234).getEmail());
//	}
//
//	@Test
//	public void testFindByEmail() {
//		System.out.println("testFindByEmail");
//		IUserService service = new UserService();
//		service.findByEmail("test@test.com");
//	}
//
//	@Test
//	public void testUpdateUserName() {
//		System.out.println("testUpdateUserName");
//		IUserService service = new UserService();
//		long userId = 1234;
//		String firstName = "Linnea";
//		User user = service.findByLiferayUser((int) userId);
//		if (user != null
//				&& (user.getUserId() == null || user.getLiferayUserId() == null)) {
//			user = null;
//		}
//		if (user != null) {
//			System.out.println("update el nombre del usr");
//			if (!user.getName().equalsIgnoreCase(firstName)) {
//				user.setName(firstName);
//				service.update(user,
//						ActionTypeName.MODIFY_PAYMENT_LIST_FREE_SERVICE);
//			}
//		}
//	}
//
//	@Test
//	public void testDeactivateUser() {
//		System.out.println("testDeactivateUser");
//		IUserService service = new UserService();
//		long userId = 1234;
//		int status = 5;
//		User user = service.findByLiferayUser((int) userId);
//		if (user != null
//				&& (user.getUserId() == null || user.getLiferayUserId() == null)) {
//			user = null;
//		}
//		if (user != null && status != 0) {
//			System.out.println("deactivate user");
//
//			List<UserAction> actionList = (List<UserAction>) user.getActions();
//			if (actionList == null) {
//				actionList = new ArrayList<UserAction>();
//			}
//			UserAction action = new UserAction();
//			action.setUser(user);
//			ActionType actionType = new ActionType();
//			actionType.setName(ActionTypeName.DELETE_USER);
//			action.setActionType(actionType);
//			actionList.add(action);
//			user.setActions(actionList);
//
//			service.deactivate(user.getLiferayUserId(),
//					ActionTypeName.DELETE_USER); // borrado
//			// l�gico
//		}
//	}
//
//	@Test
//	public void testDeleteUser() {
//	}
//}
