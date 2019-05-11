package org.mk.example.ajax.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class MKAjaxController
 */
public class MKAjaxController extends MVCPortlet {
 
	public void init() {
		viewTemplate = getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        String path = ParamUtil.getString(renderRequest, "path","default");
        if(path.equalsIgnoreCase("success"))
        {
                renderRequest.setAttribute("name", (ParamUtil.getString(renderRequest, "name")));
        	renderRequest.setAttribute("password", (ParamUtil.getString(renderRequest, "password")));
        	include("/html/ajaxcontroller/success.jsp", renderRequest, renderResponse);
        }
        else{
		include(viewTemplate, renderRequest, renderResponse);
        }
	}
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
		
		String name = ParamUtil.getString(request, "name");
		String password = ParamUtil.getString(request, "password");
		
		 JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
		 jsonObject.put("name", name);
		 jsonObject.put("password", password);
		 response.getWriter().println(jsonObject);
		super.serveResource(request, response);
	}
	protected void include(String path, RenderRequest renderRequest, RenderResponse renderResponse) throws IOException,PortletException {
		PortletRequestDispatcher portletRequestDispatcher = getPortletContext().getRequestDispatcher(path);
		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}
	protected String viewTemplate;
	private static Log _log = LogFactoryUtil.getLog(MKAjaxController.class);

}
