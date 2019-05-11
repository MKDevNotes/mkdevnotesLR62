package org.mk.liferay.example;

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

/**
 * @author muthukumar
 *
 */
public class MKGenericPortletController extends GenericPortlet {
	@Override
	public void init() throws PortletException {
		// TODO Auto-generated method stub
		_log.info(":::----Inside init method ----:::");
		viewJSP = getInitParameter("view-template");
		editJSP = getInitParameter("edit-template");
		helpJSP = getInitParameter("help-template");
	}

	@Override
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		_log.info(":::----Inside doView method ----:::");
		include(viewJSP, request, response);
	}
	
	@Override
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		_log.info(":::----Inside processAction method ----:::");
	}
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		_log.info(":::----Inside serveResource method ----:::");
		response.setContentType("text/html");
		response.getWriter().write("Resource served successfully!");
	}
	
	@Override
	protected void doDispatch(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		String jspPage = request.getParameter("jspPage");
		_log.info(":::----Inside doDispatch method ----:::");
		if (jspPage != null) {
			include(jspPage, request, response);
		}
		else {
			super.doDispatch(request, response);
		}
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

	protected String viewJSP;
	protected String editJSP;
	protected String helpJSP;

	private static Log _log = LogFactoryUtil.getLog(MKGenericPortletController.class);
}
