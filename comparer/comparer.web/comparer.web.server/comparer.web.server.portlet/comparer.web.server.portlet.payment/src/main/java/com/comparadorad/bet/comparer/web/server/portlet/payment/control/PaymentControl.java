package com.comparadorad.bet.comparer.web.server.portlet.payment.control;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;


public class PaymentControl extends MVCPortlet{

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher prd;

		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		
		String status = PortalUtil.getOriginalServletRequest(request).getParameter("status");
		
		if(status!=null){
			if(status.equals("success")){
				prd =  getPortletContext().getRequestDispatcher("/html/success.jsp");
			}else if(status.equals("error")){
				prd =  getPortletContext().getRequestDispatcher("/html/error.jsp");
			}else{
				prd =  getPortletContext().getRequestDispatcher("/html/view.jsp");
			}
		}
		else{
			prd =  getPortletContext().getRequestDispatcher("/html/view.jsp");
		}
		
		prd.include(renderRequest, renderResponse);

	}
}
