package comparer.web.server.hook.userprofile.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.struts.StrutsAction;


public class UpdateReminderQueryAction extends BaseStrutsAction {

	

	@Override
	public String execute(StrutsAction originalStrutsAction,
			HttpServletRequest request, HttpServletResponse response)
					throws Exception {

		String result = originalStrutsAction.execute(request, response);
		
		if(request.getParameter("referer")!=null){
			return "/custom/payment.jsp";
		}
		return result;
	}
	
	
}
