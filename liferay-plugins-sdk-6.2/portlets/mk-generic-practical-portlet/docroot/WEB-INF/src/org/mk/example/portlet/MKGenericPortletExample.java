package org.mk.example.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class MKGenericPortletExample extends GenericPortlet {
	
	protected String viewJSP;
	protected String editJSP;
	protected String helpJSP;
	
	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		
		viewJSP = getInitParameter(MKGenericPortletConstant.VIEW_JSP);
		editJSP = getInitParameter(MKGenericPortletConstant.EDIT_JSP);
		helpJSP = getInitParameter(MKGenericPortletConstant.HELP_JSP);
	}
	
	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		_log.info(":::----Inside doView method ----:::");
		
	}
	
	@Override
	public void processAction(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		_log.info(":::----Inside processAction method ----:::");
	}
	
	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		_log.info(":::----Inside render method ----:::");
		include(viewJSP, request, response);
	}
	
	
	@Override
	protected void doEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		_log.info(":::----Inside doEdit method ----:::");
		include(editJSP, request, response);
	}
	
	@Override
	protected void doHelp(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// TODO Auto-generated method stub
		_log.info(":::----Inside doHelp method ----:::");
		include(helpJSP, request, response);
	}
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException, IOException {
		_log.info(":::----Inside serveResource method ----:::");
		response.setContentType("text/html");
		response.getWriter().write("Resource served successfully!");
	}
	
	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(MKGenericPortletExample.class);

}
