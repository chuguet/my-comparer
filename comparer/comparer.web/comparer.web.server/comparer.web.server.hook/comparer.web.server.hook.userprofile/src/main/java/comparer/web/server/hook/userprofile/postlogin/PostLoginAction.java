package comparer.web.server.hook.userprofile.postlogin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.UserGroupLocalServiceUtil;

public class PostLoginAction extends Action{

	private static Log _log = LogFactoryUtil.getLog(PostLoginAction.class);
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response)
			throws ActionException {

		try {
			List<UserGroup> groups = UserGroupLocalServiceUtil.getUserUserGroups(Long.parseLong(request.getUserPrincipal().getName()));
			for (UserGroup userGroup : groups) {
				if(userGroup.getName().equals("Gratuitos")){
					response.sendRedirect("/servicios");
				}	
			}
		} catch (Exception e) {
			_log.error("No se ha podido enviar al usuario" + request.getUserPrincipal().getName()+ "a la lista de servicios.");
		}

	}

}
